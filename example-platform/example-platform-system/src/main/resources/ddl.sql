CREATE DATABASE `example_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `example_system`;

CREATE TABLE IF NOT EXISTS `sys_user`
(
    `id`        BIGINT       NOT NULL,
    `deletedAt` BIGINT       NOT NULL DEFAULT 0,
    `username`  VARCHAR(255) NOT NULL COMMENT '用户名',
    `password`  VARCHAR(255) NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`)
) COMMENT '用户表';
