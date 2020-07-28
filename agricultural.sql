/*
 Navicat Premium Data Transfer

 Source Server         : localhsot
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost:3306
 Source Schema         : agricultural

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 28/07/2020 15:54:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agricultural_function
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_function`;
CREATE TABLE `agricultural_function`  (
  `functionID` int(11) NOT NULL AUTO_INCREMENT COMMENT '方法ID',
  `functionName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法名称',
  `linkedUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问路径',
  `parentID` int(11) NULL DEFAULT NULL COMMENT '父级ID',
  `orderNum` int(11) NULL DEFAULT NULL COMMENT '统计顺序',
  `status` int(11) NULL DEFAULT NULL COMMENT '方法是否可用',
  `spare1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `spare2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `spare3` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`functionID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_function
-- ----------------------------
INSERT INTO `agricultural_function` VALUES (1, '系统管理', NULL, 0, 500, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (2, '权限管理', NULL, 1, 503, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (3, '角色管理', NULL, 1, 502, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (4, '用户管理', NULL, 1, 501, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (5, '农机管理', NULL, 0, 100, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (6, '作业管理', NULL, 0, 200, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (7, '统计报表', NULL, 0, 300, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (8, '农机信息', NULL, 5, 101, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (9, '农机查询', NULL, 5, 102, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (10, '作业信息', NULL, 6, 201, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (11, '作业查询', NULL, 6, 202, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (12, '区域统计', NULL, 7, 301, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (13, '作业统计', NULL, 7, 302, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (14, '深松统计', NULL, 7, 303, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for agricultural_machinery
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_machinery`;
CREATE TABLE `agricultural_machinery`  (
  `machineryID` int(11) NOT NULL AUTO_INCREMENT COMMENT '农业机械ID',
  `machineryOwner` int(11) NULL DEFAULT NULL COMMENT '农业机械所有者ID',
  `machineryNO` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农业机械编号',
  `machineryIMEI` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国际移动设备识别码',
  `machineryLicense` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农业机械车牌号',
  `machineryBrand` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农业机械品牌',
  `machineryWidth` double(20, 2) NULL DEFAULT NULL COMMENT '农业机械宽度',
  `machineryStatus` int(11) NULL DEFAULT NULL COMMENT '农机状态    1正常   2损坏  3维修  4报废删除',
  PRIMARY KEY (`machineryID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_machinery
-- ----------------------------
INSERT INTO `agricultural_machinery` VALUES (1, 2, '060047295260', NULL, '豫·5260CA', '联合', 3.64, 1);
INSERT INTO `agricultural_machinery` VALUES (2, 2, '060047295261', NULL, '豫·52HL56', '大众', 2.89, 1);
INSERT INTO `agricultural_machinery` VALUES (3, 2, '060047295262', NULL, '豫·L56S8A', '深林', 1.36, 1);
INSERT INTO `agricultural_machinery` VALUES (4, 3, '060047295263', NULL, '豫·L5868A', '大众', 3.50, 1);
INSERT INTO `agricultural_machinery` VALUES (5, NULL, '060047295264', '867160047295260', NULL, NULL, NULL, 1);
INSERT INTO `agricultural_machinery` VALUES (6, NULL, '060047295267', '867160047295260', NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for agricultural_role
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_role`;
CREATE TABLE `agricultural_role`  (
  `roleID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID自增',
  `roleName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `createDate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `updateDate` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `updator` int(11) NULL DEFAULT NULL COMMENT '修改人',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `spare1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `spare2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `spare3` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`roleID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_role
-- ----------------------------
INSERT INTO `agricultural_role` VALUES (1, '管理员', '2020-07-22 11:17:06', 1, NULL, NULL, 1, '管理员', NULL, NULL, NULL);
INSERT INTO `agricultural_role` VALUES (2, '普通用户1', '2020-07-23 18:26:55', 1, '2020-07-23 18:28:43', NULL, -1, '222', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for agricultural_role_function
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_role_function`;
CREATE TABLE `agricultural_role_function`  (
  `roleFunctionID` int(11) NOT NULL AUTO_INCREMENT COMMENT '方法与角色对照ID',
  `roleID` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `functionID` int(11) NULL DEFAULT NULL COMMENT '方法ID',
  PRIMARY KEY (`roleFunctionID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_role_function
-- ----------------------------
INSERT INTO `agricultural_role_function` VALUES (1, 1, 1);
INSERT INTO `agricultural_role_function` VALUES (2, 1, 2);
INSERT INTO `agricultural_role_function` VALUES (3, 1, 3);
INSERT INTO `agricultural_role_function` VALUES (4, 1, 4);
INSERT INTO `agricultural_role_function` VALUES (5, 1, 1);
INSERT INTO `agricultural_role_function` VALUES (6, 1, 1);
INSERT INTO `agricultural_role_function` VALUES (7, 1, 7);
INSERT INTO `agricultural_role_function` VALUES (8, 1, 8);
INSERT INTO `agricultural_role_function` VALUES (9, 1, 9);
INSERT INTO `agricultural_role_function` VALUES (10, 1, 10);
INSERT INTO `agricultural_role_function` VALUES (11, 1, 11);
INSERT INTO `agricultural_role_function` VALUES (12, 1, 12);
INSERT INTO `agricultural_role_function` VALUES (13, 1, 5);
INSERT INTO `agricultural_role_function` VALUES (14, 1, 6);

-- ----------------------------
-- Table structure for agricultural_user
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_user`;
CREATE TABLE `agricultural_user`  (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID自增',
  `userName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `type` int(11) NULL DEFAULT NULL COMMENT '人事类型',
  `status` int(11) NULL DEFAULT NULL COMMENT '用户是否生效',
  `lastLoginTime` datetime(0) NULL DEFAULT NULL COMMENT '上一次登录时间',
  `createDate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `updateDate` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `updator` int(11) NULL DEFAULT NULL COMMENT '更新人',
  `province` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省        以下算作是   归属区域',
  `city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `county` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县',
  `town` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '镇',
  `village` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '村',
  `cooperative` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合作社',
  PRIMARY KEY (`userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_user
-- ----------------------------
INSERT INTO `agricultural_user` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '123456', '789@qq.com', 1, -1, '2020-07-21 14:55:02', '2020-07-21 14:55:05', 1, '2020-07-23 18:21:12', 1, NULL, NULL, NULL, NULL, NULL, '不知道');
INSERT INTO `agricultural_user` VALUES (2, 'gyy', '92c74ec4234c6d05c011e55c7eae452f', '17301304406', '1842146668@qq.com', 2, 1, NULL, '2020-07-22 14:21:40', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (3, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (4, '2545', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (5, '3425', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (6, '524524', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (7, '6741', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (8, '74', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (9, '9645', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (10, '96442', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (11, '645424', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (12, '6543', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (13, '6346', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (14, '450', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (15, '1204', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_user` VALUES (16, '', '', '', '', NULL, NULL, NULL, '2020-07-23 17:50:41', NULL, NULL, NULL, '', '', '', '', '', '');
INSERT INTO `agricultural_user` VALUES (17, '', '', '', '', NULL, NULL, NULL, '2020-07-23 17:52:26', NULL, NULL, NULL, '', '', '', '', '', '');
INSERT INTO `agricultural_user` VALUES (18, '', '', '', '', NULL, NULL, NULL, '2020-07-23 17:54:22', NULL, NULL, NULL, '', '', '', '', '', '');
INSERT INTO `agricultural_user` VALUES (19, '', '', '', '', NULL, NULL, NULL, '2020-07-23 17:54:50', NULL, NULL, NULL, '', '', '', '', '', '');
INSERT INTO `agricultural_user` VALUES (20, 'g**', '151e6f0fc8ae8bdb4059c086536d8636', '1*****406', '18*******8@qq.com', 2, 1, NULL, '2020-07-23 17:56:49', NULL, NULL, NULL, '河南省', '**市', '**县', '**镇', '**村', '******合作社');
INSERT INTO `agricultural_user` VALUES (21, 'g**', '151e6f0fc8ae8bdb4059c086536d8636', '1*****406', '18*******8@qq.com', 2, 1, NULL, '2020-07-23 18:01:29', NULL, NULL, NULL, '河南省', '**市', '**县', '**镇', '**村', '******合作社');

-- ----------------------------
-- Table structure for agricultural_user_role
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_user_role`;
CREATE TABLE `agricultural_user_role`  (
  `userRoleID` int(11) NOT NULL AUTO_INCREMENT COMMENT '人事与角色关系对照ID',
  `userID` int(11) NULL DEFAULT NULL COMMENT '人事ID',
  `roleID` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`userRoleID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_user_role
-- ----------------------------
INSERT INTO `agricultural_user_role` VALUES (1, 1, 1);
INSERT INTO `agricultural_user_role` VALUES (2, 1, 2);
INSERT INTO `agricultural_user_role` VALUES (3, 1, 3);
INSERT INTO `agricultural_user_role` VALUES (4, 1, 4);

-- ----------------------------
-- Table structure for agricultural_work
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_work`;
CREATE TABLE `agricultural_work`  (
  `workID` int(11) NOT NULL AUTO_INCREMENT COMMENT '作业ID',
  `workMachineryID` int(11) NULL DEFAULT NULL COMMENT '作业的机械ID',
  `workStartTime` datetime(0) NULL DEFAULT NULL COMMENT '作业开始时间',
  `workStartMap` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作业开始坐标',
  `workEndTime` datetime(0) NULL DEFAULT NULL COMMENT '作业结束时间',
  `workEndMap` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作业结束坐标',
  `drivenDistance` double(11, 2) NULL DEFAULT NULL COMMENT '行驶里程',
  `workLength` double(11, 2) NULL DEFAULT NULL COMMENT '作业里程 （KM）',
  `workArea` double(11, 2) NULL DEFAULT NULL COMMENT '作业面积 （亩）',
  `workDepth` double(2, 0) NULL DEFAULT NULL COMMENT '作业深度（厘米）',
  `verificationResults` int(11) NULL DEFAULT NULL COMMENT '核查结果     1通过   -1不通过',
  `province` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `county` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县',
  `town` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '镇',
  `village` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '村',
  PRIMARY KEY (`workID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_work
-- ----------------------------
INSERT INTO `agricultural_work` VALUES (1, 1, '2020-07-23 14:14:57', NULL, NULL, NULL, NULL, 50.00, 150.00, NULL, NULL, NULL, '北京市', '大兴区', '台湖镇', '白庄村');
INSERT INTO `agricultural_work` VALUES (2, 1, '2020-07-21 14:22:39', NULL, NULL, NULL, NULL, 1000.00, 60000.00, NULL, NULL, '河南省', '洛阳市', '涧西区', '磁涧镇', '后坡村');
INSERT INTO `agricultural_work` VALUES (3, 2, '2020-07-22 14:24:07', NULL, NULL, NULL, NULL, 200.00, 9200.00, NULL, NULL, '河北省', '石家庄市', '鹿泉区', '山尹镇', '山尹村');
INSERT INTO `agricultural_work` VALUES (4, 2, '2020-07-20 15:15:16', NULL, NULL, NULL, NULL, 300.00, 3000.00, NULL, NULL, '河北省', '石家庄市', '鹿泉区', '山尹镇', '山尹村');
INSERT INTO `agricultural_work` VALUES (6, 3, NULL, '11111,1111', NULL, NULL, NULL, 100.00, 10000.00, NULL, NULL, '河南省', '洛阳市', '涧西区', '涧西县', '建西村');
INSERT INTO `agricultural_work` VALUES (7, 6, '2020-07-28 10:03:08', '000000000,000000000', NULL, NULL, 18760.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_work` VALUES (8, 6, '2020-07-28 10:13:35', '000000000,000000000', NULL, NULL, 18760.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_work` VALUES (9, 6, '2020-07-28 10:13:56', '000000000,000000000', NULL, NULL, 18760.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_work` VALUES (10, 6, '2020-07-28 10:14:43', '000000000,000000000', NULL, NULL, 18760.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `agricultural_work` VALUES (11, 6, '2020-07-28 10:37:27', '000000000,000000000', NULL, NULL, 18760.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
