/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : associations

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-01-21 10:36:30
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
INSERT INTO `office` VALUES ('06b772bc28344661898cdcfcf28b3322', '0b397b35c4bd4951b9d24bbcd1a284e0', '0,1f0854ad65a748678f75e244dc1ee39d,0b397b35c4bd4951b9d24bbcd1a284e0,', '数字媒体艺术', '30', '2', '', '');
INSERT INTO `office` VALUES ('0b397b35c4bd4951b9d24bbcd1a284e0', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '艺术设计学院', '90', '1', '', '');
INSERT INTO `office` VALUES ('0bdae3d6e9b6469fa909d8b622a709df', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '电商与物流学院', '50', '1', '', '');
INSERT INTO `office` VALUES ('0d8e36257f814a2ea747c6ad09e22b9c', '0bdae3d6e9b6469fa909d8b622a709df', '0,1f0854ad65a748678f75e244dc1ee39d,0bdae3d6e9b6469fa909d8b622a709df,', '物流工程', '10', '2', '', '');
INSERT INTO `office` VALUES ('0dc0665ff74d429db0e8e049d979e211', '850406599da84170a1e7910b30077dbf', '0,1f0854ad65a748678f75e244dc1ee39d,850406599da84170a1e7910b30077dbf,', '金融学', '20', '2', '', '');
INSERT INTO `office` VALUES ('1736792d69a8463ca23a889e78661a42', 'e4a403b427f84c0baf39ee4dc378d03d', '0,1f0854ad65a748678f75e244dc1ee39d,e4a403b427f84c0baf39ee4dc378d03d,', '物联网工程', '20', '2', '', '');
INSERT INTO `office` VALUES ('195d3c78b8f1428c921d1b715fa50685', '4232e5283b61487789ac580c9cf69c39', '0,1f0854ad65a748678f75e244dc1ee39d,4232e5283b61487789ac580c9cf69c39,', '市场营销', '20', '2', '', '');
INSERT INTO `office` VALUES ('1dd9078be3ab4b4d8aa9190d46369094', '0bdae3d6e9b6469fa909d8b622a709df', '0,1f0854ad65a748678f75e244dc1ee39d,0bdae3d6e9b6469fa909d8b622a709df,', '电子商务', '30', '2', '', '');
INSERT INTO `office` VALUES ('1e2b0fc6e1d1458d9c57c7b4950cb89f', '4232e5283b61487789ac580c9cf69c39', '0,1f0854ad65a748678f75e244dc1ee39d,4232e5283b61487789ac580c9cf69c39,', '人力资源管理', '40', '2', '', '');
INSERT INTO `office` VALUES ('1f0854ad65a748678f75e244dc1ee39d', '0', '0,', '山西大学商务学院', '1', '1', '', '');
INSERT INTO `office` VALUES ('26c4fbe7210f4513a14baf665ef43b3b', '0b397b35c4bd4951b9d24bbcd1a284e0', '0,1f0854ad65a748678f75e244dc1ee39d,0b397b35c4bd4951b9d24bbcd1a284e0,', '美术学', '50', '2', '', '');
INSERT INTO `office` VALUES ('2d022685fcde4e25bb493fa080c4e364', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '文化传播学院', '60', '1', '', '');
INSERT INTO `office` VALUES ('41f36a5b27b14a2d89b589054a5859e0', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '外国语学院', '80', '1', '', '');
INSERT INTO `office` VALUES ('4232e5283b61487789ac580c9cf69c39', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '管理学院', '20', '1', '', '');
INSERT INTO `office` VALUES ('4d269027d2ce471392ed5b18f48eb53d', '8104990ad65d4bb4a644d45d40fe78c4', '0,1f0854ad65a748678f75e244dc1ee39d,8104990ad65d4bb4a644d45d40fe78c4,', 'ACCA方向班', '20', '2', '', '');
INSERT INTO `office` VALUES ('5ba36cda041346ffa10f194a2e489ba7', 'e4a403b427f84c0baf39ee4dc378d03d', '0,1f0854ad65a748678f75e244dc1ee39d,e4a403b427f84c0baf39ee4dc378d03d,', '软件工程', '10', '2', '', '');
INSERT INTO `office` VALUES ('5e79c7bb79334a929413d7022465d706', '4232e5283b61487789ac580c9cf69c39', '0,1f0854ad65a748678f75e244dc1ee39d,4232e5283b61487789ac580c9cf69c39,', '旅游管理', '30', '2', '', '');
INSERT INTO `office` VALUES ('6046e62479734654b3edb73cb6e8dd4d', '850406599da84170a1e7910b30077dbf', '0,1f0854ad65a748678f75e244dc1ee39d,850406599da84170a1e7910b30077dbf,', '贸易经济', '30', '2', '', '');
INSERT INTO `office` VALUES ('619b2241460e464aa5509c613f721948', '850406599da84170a1e7910b30077dbf', '0,1f0854ad65a748678f75e244dc1ee39d,850406599da84170a1e7910b30077dbf,', '经济学', '10', '2', '', '');
INSERT INTO `office` VALUES ('623e7baf0ab64ccab60fb8023f2db7aa', '850406599da84170a1e7910b30077dbf', '0,1f0854ad65a748678f75e244dc1ee39d,850406599da84170a1e7910b30077dbf,', '商务经济学', '40', '2', '', '');
INSERT INTO `office` VALUES ('643a095c3bd04bb5b75ec2b55202b9dc', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '体育学院', '110', '1', '', '');
INSERT INTO `office` VALUES ('67de704b859a4a82910bd279a46870e9', 'ba7ea5f1f7ee49c6959fe049d39d7da7', '0,1f0854ad65a748678f75e244dc1ee39d,ba7ea5f1f7ee49c6959fe049d39d7da7,', '音乐表演', '10', '2', '', '');
INSERT INTO `office` VALUES ('6ebe450fd86c49198d04461f47a54a46', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '会计学院', '10', '1', '', '');
INSERT INTO `office` VALUES ('6fa4a475d7ba4ed1b195e1152269c747', '41f36a5b27b14a2d89b589054a5859e0', '0,1f0854ad65a748678f75e244dc1ee39d,41f36a5b27b14a2d89b589054a5859e0,', '英语', '20', '2', '', '');
INSERT INTO `office` VALUES ('76c23511691845459ff9b876f5e8859c', 'ba7ea5f1f7ee49c6959fe049d39d7da7', '0,1f0854ad65a748678f75e244dc1ee39d,ba7ea5f1f7ee49c6959fe049d39d7da7,', '舞蹈编导', '20', '2', '', '');
INSERT INTO `office` VALUES ('8104990ad65d4bb4a644d45d40fe78c4', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '国际教育学院', '120', '1', '', '');
INSERT INTO `office` VALUES ('8160cfc8183d4ba6bf9715fbf0e05a21', 'e4a403b427f84c0baf39ee4dc378d03d', '0,1f0854ad65a748678f75e244dc1ee39d,e4a403b427f84c0baf39ee4dc378d03d,', '网络工程', '30', '2', '', '');
INSERT INTO `office` VALUES ('850406599da84170a1e7910b30077dbf', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '经济学院', '40', '1', '', '');
INSERT INTO `office` VALUES ('87374e361f4548dd96e680f6fe3616b7', '850406599da84170a1e7910b30077dbf', '0,1f0854ad65a748678f75e244dc1ee39d,850406599da84170a1e7910b30077dbf,', '国际经济与贸易', '50', '2', '', '');
INSERT INTO `office` VALUES ('87b4d45235ff4184a3bc493ada02ab34', '0b397b35c4bd4951b9d24bbcd1a284e0', '0,1f0854ad65a748678f75e244dc1ee39d,0b397b35c4bd4951b9d24bbcd1a284e0,', '艺术与科技', '40', '2', '', '');
INSERT INTO `office` VALUES ('90ef71b3d1aa45dc93e0d9e2184f78cf', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '法学院', '70', '1', '', '');
INSERT INTO `office` VALUES ('9143ed5a57c7494fbd4847a9471aa2c6', '2d022685fcde4e25bb493fa080c4e364', '0,1f0854ad65a748678f75e244dc1ee39d,2d022685fcde4e25bb493fa080c4e364,', '新闻学', '30', '2', '', '');
INSERT INTO `office` VALUES ('92172e64d1f74dc8b6463d067dd9713d', '6ebe450fd86c49198d04461f47a54a46', '0,1f0854ad65a748678f75e244dc1ee39d,6ebe450fd86c49198d04461f47a54a46,', '财务管理', '40', '2', '', '');
INSERT INTO `office` VALUES ('94684ffdae8e4912b6bc2353bc978274', 'e4a403b427f84c0baf39ee4dc378d03d', '0,1f0854ad65a748678f75e244dc1ee39d,e4a403b427f84c0baf39ee4dc378d03d,', '计算机科学与技术', '40', '2', '', '');
INSERT INTO `office` VALUES ('9abfce2d45c24d22900fb283468b0fbd', '6ebe450fd86c49198d04461f47a54a46', '0,1f0854ad65a748678f75e244dc1ee39d,6ebe450fd86c49198d04461f47a54a46,', '资产评估', '50', '2', '', '');
INSERT INTO `office` VALUES ('a1419322acf74545bdfe0e73805e385f', '4232e5283b61487789ac580c9cf69c39', '0,1f0854ad65a748678f75e244dc1ee39d,4232e5283b61487789ac580c9cf69c39,', '行政管理', '50', '2', '', '');
INSERT INTO `office` VALUES ('a6bb0580c0bc4b00b844af16b62378e5', '6ebe450fd86c49198d04461f47a54a46', '0,1f0854ad65a748678f75e244dc1ee39d,6ebe450fd86c49198d04461f47a54a46,', '会计电算化', '30', '2', '', '');
INSERT INTO `office` VALUES ('ba7ea5f1f7ee49c6959fe049d39d7da7', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '音乐舞蹈学院', '100', '1', '', '');
INSERT INTO `office` VALUES ('c32496d26e9541c0bf5e14b7f773186c', '0b397b35c4bd4951b9d24bbcd1a284e0', '0,1f0854ad65a748678f75e244dc1ee39d,0b397b35c4bd4951b9d24bbcd1a284e0,', '环境设计', '20', '2', '', '');
INSERT INTO `office` VALUES ('cdb7692623a0439485edae0bb519758d', '2d022685fcde4e25bb493fa080c4e364', '0,1f0854ad65a748678f75e244dc1ee39d,2d022685fcde4e25bb493fa080c4e364,', '汉语言文学', '10', '2', '', '');
INSERT INTO `office` VALUES ('e17a503848494148b18c8b9acd4fdb95', '4232e5283b61487789ac580c9cf69c39', '0,1f0854ad65a748678f75e244dc1ee39d,4232e5283b61487789ac580c9cf69c39,', '工商管理', '10', '2', '', '');
INSERT INTO `office` VALUES ('e1a6e98718ea4d5e94239889e24360b8', '0b397b35c4bd4951b9d24bbcd1a284e0', '0,1f0854ad65a748678f75e244dc1ee39d,0b397b35c4bd4951b9d24bbcd1a284e0,', '视觉传达设计', '10', '2', '', '');
INSERT INTO `office` VALUES ('e41aa345b370492f978af3147af40692', 'e4a403b427f84c0baf39ee4dc378d03d', '0,1f0854ad65a748678f75e244dc1ee39d,e4a403b427f84c0baf39ee4dc378d03d,', '电子信息科学与技术', '50', '2', '', '');
INSERT INTO `office` VALUES ('e4a403b427f84c0baf39ee4dc378d03d', '1f0854ad65a748678f75e244dc1ee39d', '0,1f0854ad65a748678f75e244dc1ee39d,', '信息学院', '30', '1', '', '');
INSERT INTO `office` VALUES ('e7612505e11e4be1b69408cb632d7eb6', '6ebe450fd86c49198d04461f47a54a46', '0,1f0854ad65a748678f75e244dc1ee39d,6ebe450fd86c49198d04461f47a54a46,', '会计实务与管理', '10', '2', '', '');
INSERT INTO `office` VALUES ('e7b66260902241d3a8d61b83917b06ce', '2d022685fcde4e25bb493fa080c4e364', '0,1f0854ad65a748678f75e244dc1ee39d,2d022685fcde4e25bb493fa080c4e364,', '汉语国际教育', '20', '2', '', '');
INSERT INTO `office` VALUES ('e7ecdbed4a134d588f4d65177791a218', '8104990ad65d4bb4a644d45d40fe78c4', '0,1f0854ad65a748678f75e244dc1ee39d,8104990ad65d4bb4a644d45d40fe78c4,', '恒德班', '10', '2', '', '');
INSERT INTO `office` VALUES ('e826e235dca04d6fbee14276319a1a6a', '41f36a5b27b14a2d89b589054a5859e0', '0,1f0854ad65a748678f75e244dc1ee39d,41f36a5b27b14a2d89b589054a5859e0,', '日语', '30', '2', '', '');
INSERT INTO `office` VALUES ('eb4671a546a347d2923656acd468ec9d', '0bdae3d6e9b6469fa909d8b622a709df', '0,1f0854ad65a748678f75e244dc1ee39d,0bdae3d6e9b6469fa909d8b622a709df,', '物流管理', '20', '2', '', '');
INSERT INTO `office` VALUES ('eee038f913da4e8bbb19dc12f1fe8a27', '2d022685fcde4e25bb493fa080c4e364', '0,1f0854ad65a748678f75e244dc1ee39d,2d022685fcde4e25bb493fa080c4e364,', '文化产业管理', '50', '2', '', '');
INSERT INTO `office` VALUES ('f77ccb220d2947a69955af3504541654', '6ebe450fd86c49198d04461f47a54a46', '0,1f0854ad65a748678f75e244dc1ee39d,6ebe450fd86c49198d04461f47a54a46,', '注册会计师', '20', '2', '', '');
INSERT INTO `office` VALUES ('f95e31ce46fb4ebcbd9115fa16efac6f', '41f36a5b27b14a2d89b589054a5859e0', '0,1f0854ad65a748678f75e244dc1ee39d,41f36a5b27b14a2d89b589054a5859e0,', '商务英语', '10', '2', '', '');
INSERT INTO `office` VALUES ('fbb075b562c445d59f72cfa7a3c10dca', '2d022685fcde4e25bb493fa080c4e364', '0,1f0854ad65a748678f75e244dc1ee39d,2d022685fcde4e25bb493fa080c4e364,', '广告学', '40', '2', '', '');

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
  `wid` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, 'admin', '管理员', 'e5e3ce5078f04d2af0f5a8d6b23c6cfb897e85116374719ab136dc51', null, null, null, null, 'oKOu94jTBu1e3PKx5m94a9C4TM0M');
