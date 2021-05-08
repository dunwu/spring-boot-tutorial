package io.github.dunwu.springboot.config;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;
import net.sf.jsqlparser.util.deparser.StatementDeParser;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;

import java.lang.reflect.Field;
import java.sql.Connection;

/**
 * Mybatis Plus SQL 语句包裹插件
 * <p>
 * 本插件用于解决以下问题：
 * <p>
 * 1.Mysql 中，关键字如果不加反引号 `，执行 SQL 时会抛出语法错误
 * <p>
 * 2.Mybatis Plus 3.x 版本后，不会对关键字进行特殊处理，只能通过 @TableField(value ="`status`") 方式进行标注
 * <p>
 * 解决方案： 直接在 SQL 中为所有 column 强行加上反引号
 *
 * @author peng.zhang
 * @date 2021/5/8
 */
@Slf4j
public class MysqlWrapperInterceptor implements InnerInterceptor {

    @Override
    public void beforePrepare(StatementHandler sh, Connection connection, Integer transactionTimeout) {

        BoundSql boundSql = sh.getBoundSql();

        // 1. 获取到原始sql语句
        String originSql = boundSql.getSql();
        if (log.isDebugEnabled()) {
            log.debug("[SqlWrapperInceptor] 原始 SQL: {}", originSql);
        }

        // 2. 注册 jsqlparser 表达式解析器
        StringBuilder sb = new StringBuilder();
        ExpressionDeParser expr = new ReplaceColumnDeParser();
        SelectDeParser selectDeparser = new SelectDeParser(expr, sb);
        expr.setSelectVisitor(selectDeparser);
        expr.setBuffer(sb);
        StatementDeParser stmtDeparser = new StatementDeParser(expr, selectDeparser, sb);

        // 3. 使用 jsqlparser 解析 SQL 字符串，转化为 Statement，然后再用注册的解析器进行处理
        Statement stmt;
        try {
            stmt = CCJSqlParserUtil.parse(originSql);
            stmt.accept(stmtDeparser);
        } catch (JSQLParserException e) {
            log.error("[SqlWrapperInceptor] 解析 SQL 失败！", e);
            return;
        }

        // 4. 将替换后的 sql 语句，通过反射回填到 boundSql 原始字段 sql 中
        String replacedSql = stmtDeparser.getBuffer().toString();
        if (log.isDebugEnabled()) {
            log.debug("[SqlWrapperInceptor] 替换后的 SQL: {}", replacedSql);
        }
        try {
            Field field = boundSql.getClass().getDeclaredField("sql");
            field.setAccessible(true);
            field.set(boundSql, replacedSql);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * SQL 表达式解析器 Mysql 中，关键字如果不加反引号 `，执行 SQL 时会抛出语法错误
     */
    static class ReplaceColumnDeParser extends ExpressionDeParser {

        @Override
        public void visit(Column column) {
            this.getBuffer().append("`").append(column.getColumnName()).append("`");
        }

    }

}
