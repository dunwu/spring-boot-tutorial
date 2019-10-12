-- -------------------------------------------
-- 运行本项目的 DDL 脚本
-- -------------------------------------------

-- 创建数据表 user
CREATE TABLE IF NOT EXISTS user (
    id      INT IDENTITY NOT NULL COMMENT '主键ID',
    name    VARCHAR(30)  NOT NULL COMMENT '姓名',
    age     INT          NULL DEFAULT 0 COMMENT '年龄',
    address VARCHAR(50)  NULL DEFAULT '' COMMENT '地址',
    email   VARCHAR(50)  NULL DEFAULT '' COMMENT '邮箱',
    PRIMARY KEY (id)
);
