/*
 Navicat Premium Data Transfer

 Source Server         : localhost3306
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : localhost:3306
 Source Schema         : auth

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 15/08/2019 14:29:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bs_user
-- ----------------------------
DROP TABLE IF EXISTS `bs_user`;
CREATE TABLE `bs_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(64) DEFAULT NULL COMMENT '创建人姓名',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记',
  `update_date` datetime DEFAULT NULL COMMENT '上次更新时间',
  `update_user_id` varchar(64) DEFAULT NULL COMMENT '上次更新人id',
  `update_user_name` varchar(64) DEFAULT NULL COMMENT '上次更新人姓名',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁标记',
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bs_user
-- ----------------------------
BEGIN;
INSERT INTO `bs_user` VALUES (1, '2019-07-23 15:09:36', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 'admin');
INSERT INTO `bs_user` VALUES (2, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, '$2a$10$n5EFos7o5u/YxJiB0TfG7eW.c3qzxd/EO6K2OQcfzZZqfLuGSxLTC', 'quguang');
INSERT INTO `bs_user` VALUES (3, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, '$2a$10$WR/yDEnhTLsg0lQPwC1Z/.vUBwZxoXbU3h3NwRfTxJaFszQV0SJqK', 'quguang2');
COMMIT;

-- ----------------------------
-- Table structure for pe_permission
-- ----------------------------
DROP TABLE IF EXISTS `pe_permission`;
CREATE TABLE `pe_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(64) DEFAULT NULL COMMENT '创建人姓名',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记',
  `update_date` datetime DEFAULT NULL COMMENT '上次更新时间',
  `update_user_id` varchar(64) DEFAULT NULL COMMENT '上次更新人id',
  `update_user_name` varchar(64) DEFAULT NULL COMMENT '上次更新人姓名',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁标记',
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pid` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pe_permission
-- ----------------------------
BEGIN;
INSERT INTO `pe_permission` VALUES (1, '2019-08-14 19:02:37', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, NULL, '权限1', '1', 3);
COMMIT;

-- ----------------------------
-- Table structure for pe_permission_api
-- ----------------------------
DROP TABLE IF EXISTS `pe_permission_api`;
CREATE TABLE `pe_permission_api` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(64) DEFAULT NULL COMMENT '创建人姓名',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记',
  `update_date` datetime DEFAULT NULL COMMENT '上次更新时间',
  `update_user_id` varchar(64) DEFAULT NULL COMMENT '上次更新人id',
  `update_user_name` varchar(64) DEFAULT NULL COMMENT '上次更新人姓名',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁标记',
  `api_level` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `operation_id` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pe_permission_api
-- ----------------------------
BEGIN;
INSERT INTO `pe_permission_api` VALUES (1, '2019-08-14 19:03:04', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 'GET', NULL, '/test/aa', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for pe_permission_menu
-- ----------------------------
DROP TABLE IF EXISTS `pe_permission_menu`;
CREATE TABLE `pe_permission_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(64) DEFAULT NULL COMMENT '创建人姓名',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记',
  `update_date` datetime DEFAULT NULL COMMENT '上次更新时间',
  `update_user_id` varchar(64) DEFAULT NULL COMMENT '上次更新人id',
  `update_user_name` varchar(64) DEFAULT NULL COMMENT '上次更新人姓名',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁标记',
  `link` varchar(255) DEFAULT NULL,
  `menu_icon` varchar(255) DEFAULT NULL,
  `menu_order` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for pe_permission_point
-- ----------------------------
DROP TABLE IF EXISTS `pe_permission_point`;
CREATE TABLE `pe_permission_point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(64) DEFAULT NULL COMMENT '创建人姓名',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记',
  `update_date` datetime DEFAULT NULL COMMENT '上次更新时间',
  `update_user_id` varchar(64) DEFAULT NULL COMMENT '上次更新人id',
  `update_user_name` varchar(64) DEFAULT NULL COMMENT '上次更新人姓名',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁标记',
  `point_class` varchar(255) DEFAULT NULL,
  `point_icon` varchar(255) DEFAULT NULL,
  `point_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for pe_role
-- ----------------------------
DROP TABLE IF EXISTS `pe_role`;
CREATE TABLE `pe_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(64) DEFAULT NULL COMMENT '创建人姓名',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记',
  `update_date` datetime DEFAULT NULL COMMENT '上次更新时间',
  `update_user_id` varchar(64) DEFAULT NULL COMMENT '上次更新人id',
  `update_user_name` varchar(64) DEFAULT NULL COMMENT '上次更新人姓名',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁标记',
  `name` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pe_role
-- ----------------------------
BEGIN;
INSERT INTO `pe_role` VALUES (1, '2019-07-23 15:09:18', NULL, NULL, 0, NULL, NULL, NULL, 0, 'ADMIN', NULL);
INSERT INTO `pe_role` VALUES (2, '2019-07-23 15:10:04', NULL, NULL, 0, NULL, NULL, NULL, 0, 'USER', NULL);
INSERT INTO `pe_role` VALUES (3, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, 'ROLE_NORMAL', '普通用户');
INSERT INTO `pe_role` VALUES (4, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, 'ROLE_NORMAL', '普通用户');
COMMIT;

-- ----------------------------
-- Table structure for pe_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `pe_role_permission`;
CREATE TABLE `pe_role_permission` (
  `role_id` bigint(20) NOT NULL COMMENT '主键',
  `permission_id` bigint(20) NOT NULL COMMENT '主键',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pe_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `pe_role_permission` VALUES (1, 1);
COMMIT;

-- ----------------------------
-- Table structure for pe_user_role
-- ----------------------------
DROP TABLE IF EXISTS `pe_user_role`;
CREATE TABLE `pe_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '主键',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pe_user_role
-- ----------------------------
BEGIN;
INSERT INTO `pe_user_role` VALUES (1, 1);
INSERT INTO `pe_user_role` VALUES (2, 1);
INSERT INTO `pe_user_role` VALUES (2, 3);
INSERT INTO `pe_user_role` VALUES (3, 4);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
