# [SpringBoot 教程之访问 MongoDB

<!-- TOC depthFrom:2 depthTo:3 -->

- [1. 配置 mongodb](#1-配置-mongodb)
    - [1.1. 创建 admin](#11-创建-admin)
    - [1.2. 创建 root](#12-创建-root)
    - [1.3. 创建用户自己的数据库的角色](#13-创建用户自己的数据库的角色)
    - [1.4. 查看用户](#14-查看用户)
    - [1.5. 删除用户](#15-删除用户)
- [Spring Boot 配置](#spring-boot-配置)
- [2. 引用和引申](#2-引用和引申)

<!-- /TOC -->

## 1. 配置 mongodb

### 1.1. 创建 admin

```bash
use admin
db.createUser({
  "user": "admin",
  "pwd": "123456",
  "roles": [{ "role": "userAdminAnyDatabase", "db": "admin" }]
})
```

### 1.2. 创建 root

```bash
db.createUser({
  "user": "root",
  "pwd": "123456",
  "roles": [{ "role": "root", "db": "admin" }]
})
```

### 1.3. 创建用户自己的数据库的角色

```bash
use test
db.createUser({
  "user": "test",
  "pwd": "123456",
  "roles": [{ "role": "dbOwner", "db": "test" }]
})
```

### 1.4. 查看用户

```bash
db.system.users.find()
show users
```

### 1.5. 删除用户

删除用户必须由账号管理员来删，所以，切换到 admin 角色

```bash
use admin
db.auth("admin","123456")

# 删除单个用户
db.system.users.remove({user:"XXXXXX"})
# 删除所有用户
db.system.users.remove({})
```

## Spring Boot 配置

```properties
spring.data.mongodb.host = localhost
spring.data.mongodb.port = 27017
spring.data.mongodb.database = test
spring.data.mongodb.username = root
spring.data.mongodb.password = root
```

## 2. 引用和引申

https://spring.io/guides/gs/accessing-data-mongodb/
