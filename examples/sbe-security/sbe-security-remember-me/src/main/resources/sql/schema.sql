---------------------------------------------
-- 运行本项目的初始化 DDL 脚本
---------------------------------------------

-- 创建数据表 user
DROP TABLE if EXISTS user ;
CREATE TABLE user (
id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Id',
username VARCHAR(64) NOT NULL DEFAULT 'default' COMMENT '用户名',
password VARCHAR(64) NOT NULL DEFAULT 'default' COMMENT '密码',
PRIMARY KEY (id)) COMMENT = '用户表' ;

