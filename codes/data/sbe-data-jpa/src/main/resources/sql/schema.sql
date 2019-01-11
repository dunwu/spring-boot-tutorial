---------------------------------------------
-- 运行本项目的初始化 SQL 脚本
---------------------------------------------

-- 撤销数据库 test
DROP DATABASE IF EXISTS test;

-- 创建数据库 test
CREATE DATABASE test;

-- 选择数据库 test
USE test;

-- 创建数据表 user
DROP TABLE if EXISTS user ;
CREATE TABLE user (
id BIGINT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Id',
name varchar(10) NOT NULL DEFAULT '' COMMENT '用户名',
age tinyint(3) NOT NULL DEFAULT 0 COMMENT '年龄',
address varchar(32) NOT NULL DEFAULT '' COMMENT '地址',
email varchar(32) NOT NULL DEFAULT '' COMMENT '邮件',
PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT = '用户表';
