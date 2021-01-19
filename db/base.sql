/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : associations

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-01-19 18:04:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ass_id` varchar(50) DEFAULT NULL,
  `content` text,
  `start_time` datetime DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for ass
-- ----------------------------
DROP TABLE IF EXISTS `ass`;
CREATE TABLE `ass` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `master` varchar(50) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `summary` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ass
-- ----------------------------

-- ----------------------------
-- Table structure for ass_user
-- ----------------------------
DROP TABLE IF EXISTS `ass_user`;
CREATE TABLE `ass_user` (
  `ass_id` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ass_user
-- ----------------------------

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `value` varchar(100) DEFAULT NULL COMMENT '数据值',
  `label` varchar(100) DEFAULT NULL COMMENT '标签名',
  `type` varchar(100) DEFAULT NULL COMMENT '类型',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `sort` decimal(10,0) DEFAULT NULL COMMENT '排序（升序）',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', '0', '否', 'yes_no', '是否', '10');
INSERT INTO `dict` VALUES ('10', '0', '待通过', 'ass_user_status', '社团成员状态', '10');
INSERT INTO `dict` VALUES ('11', '1', '已加入', 'ass_user_status', '社团成员状态', '20');
INSERT INTO `dict` VALUES ('12', '2', '已拒绝', 'ass_user_status', '社团成员状态', '30');
INSERT INTO `dict` VALUES ('13', '0', '已打回', 'activity_status', '活动申请状态', '40');
INSERT INTO `dict` VALUES ('2', '1', '是', 'yes_no', '是否', '20');
INSERT INTO `dict` VALUES ('3', '1', '老师', 'user_type', '用户类型', '20');
INSERT INTO `dict` VALUES ('4', '2', '学生', 'user_type', '用户类型', '10');
INSERT INTO `dict` VALUES ('5', '1', '部门', 'office_type', '部门类型', '10');
INSERT INTO `dict` VALUES ('6', '2', '班级', 'office_type', '部门类型', '20');
INSERT INTO `dict` VALUES ('7', '1', '草稿', 'activity_status', '活动申请状态', '10');
INSERT INTO `dict` VALUES ('8', '2', '待审核', 'activity_status', '活动申请状态', '20');
INSERT INTO `dict` VALUES ('9', '3', '已通过', 'activity_status', '活动申请状态', '30');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `component` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '0', '0,', '系统管理', '100', 'el-icon-setting', '1', null, null);
INSERT INTO `menu` VALUES ('11', '1', '0,1,', '部门管理', '20', 'el-icon-office-building', '1', null, '/sys/office');
INSERT INTO `menu` VALUES ('12', '1', '0,1,', '用户管理', '10', 'el-icon-user-solid', '1', null, '/sys/user');
INSERT INTO `menu` VALUES ('13', '1', '0,1,', '权限管理', '50', 'el-icon-s-operation', '1', null, '/sys/role');
INSERT INTO `menu` VALUES ('14', '1', '0,1,', '菜单管理', '30', 'el-icon-menu', '1', null, '/sys/menu');
INSERT INTO `menu` VALUES ('15', '1', '0,1,', '字典管理', '40', 'el-icon-notebook-2', '1', null, '/sys/dict');
INSERT INTO `menu` VALUES ('2', '0', '0,', '社团管理', '10', 'el-icon-s-shop', '1', null, null);
INSERT INTO `menu` VALUES ('21', '2', '0,2,', '信息管理', '10', 'el-icon-info', '1', null, '/ass/assInfo');
INSERT INTO `menu` VALUES ('22', '2', '0,2,', '成员管理', '20', 'el-icon-user', '1', null, '/ass/assUser');
INSERT INTO `menu` VALUES ('23', '2', '0,2,', '社团管理', '20', 'el-icon-help', '1', null, '/ass/ass');
INSERT INTO `menu` VALUES ('3', '0', '0,', '活动管理', '20', 'el-icon-date', '1', null, null);
INSERT INTO `menu` VALUES ('31', '3', '0,3,', '我的活动', '10', 'el-icon-s-promotion', '1', null, '/ass/activity');
INSERT INTO `menu` VALUES ('32', '3', '0,3,', '审核', '100', 'el-icon-s-check', '1', null, '/ass/activityCheck');

-- ----------------------------
-- Table structure for office
-- ----------------------------
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office` (
  `id` varchar(50) NOT NULL,
  `parent_id` varchar(50) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `master` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of office
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `user_id` varchar(64) NOT NULL COMMENT '用户编号',
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
-- Records of role_user
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `office_id` varchar(50) DEFAULT NULL,
  `num` varchar(50) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `user_type` char(1) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, 'admin', '管理员', 'e5e3ce5078f04d2af0f5a8d6b23c6cfb897e85116374719ab136dc51', null, null, null, null);
