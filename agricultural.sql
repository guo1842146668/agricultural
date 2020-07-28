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

 Date: 24/07/2020 13:47:17
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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_function
-- ----------------------------
INSERT INTO `agricultural_function` VALUES (1, '人员管理', NULL, 0, 500, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (2, '权限管理', NULL, 0, 600, 1, NULL, NULL, NULL);
INSERT INTO `agricultural_function` VALUES (3, '角色管理', NULL, 0, 700, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for agricultural_machinery
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_machinery`;
CREATE TABLE `agricultural_machinery`  (
  `machineryID` int(11) NOT NULL AUTO_INCREMENT COMMENT '农业机械ID',
  `machineryOwner` int(11) NULL DEFAULT NULL COMMENT '农业机械所有者ID',
  `machineryName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农业机械名称',
  `machineryLength` double(20, 2) NULL DEFAULT NULL COMMENT '农业机械长度',
  `machineryWidth` double(20, 2) NULL DEFAULT NULL COMMENT '农业机械宽度',
  `machineryHeight` double(20, 2) NULL DEFAULT NULL COMMENT '农业机械高度',
  `machineryStatus` int(11) NULL DEFAULT NULL COMMENT '农机状态    1正常   2损坏  3维修  4报废删除',
  PRIMARY KEY (`machineryID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_machinery
-- ----------------------------
INSERT INTO `agricultural_machinery` VALUES (1, 2, '联合收割机', 5.43, 2.64, 3.23, 1);
INSERT INTO `agricultural_machinery` VALUES (2, 2, '大型播种机', 3.70, 1.89, 1.56, 1);
INSERT INTO `agricultural_machinery` VALUES (3, 2, '小型秸秆还田机', 1.12, 1.36, 1.43, -1);

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
  `province` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
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
INSERT INTO `agricultural_user` VALUES (2, 'gyy', '92c74ec4234c6d05c011e55c7eae452f', '17301304406', '1842146668@qq.com', 1, 1, NULL, '2020-07-22 14:21:40', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
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
INSERT INTO `agricultural_user` VALUES (20, 'g**', '151e6f0fc8ae8bdb4059c086536d8636', '1*****406', '18*******8@qq.com', 1, 1, NULL, '2020-07-23 17:56:49', NULL, NULL, NULL, '河南省', '**市', '**县', '**镇', '**村', '******合作社');
INSERT INTO `agricultural_user` VALUES (21, 'g**', '151e6f0fc8ae8bdb4059c086536d8636', '1*****406', '18*******8@qq.com', 1, 1, NULL, '2020-07-23 18:01:29', NULL, NULL, NULL, '河南省', '**市', '**县', '**镇', '**村', '******合作社');

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
  `workTime` datetime(0) NULL DEFAULT NULL COMMENT '作业时间',
  `workMap` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作业坐标',
  `workLength` int(11) NULL DEFAULT NULL COMMENT '作业长度',
  `checkLength` int(11) NULL DEFAULT NULL COMMENT '核对长度',
  `workWidth` int(11) NULL DEFAULT NULL COMMENT '作业宽度',
  `checkWidth` int(11) NULL DEFAULT NULL COMMENT '核对宽度',
  `workArea` int(11) NULL DEFAULT NULL COMMENT '作业面积',
  `checkArea` int(11) NULL DEFAULT NULL COMMENT '核对面积',
  `province` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `county` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县',
  `town` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '镇',
  `village` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '村',
  PRIMARY KEY (`workID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricultural_work
-- ----------------------------
INSERT INTO `agricultural_work` VALUES (1, 1, '2020-07-23 14:14:57', NULL, 50, 49, 3, 3, 150, 147, NULL, '北京市', '大兴区', '台湖镇', '白庄村');
INSERT INTO `agricultural_work` VALUES (2, 1, '2020-07-21 14:22:39', NULL, 1000, 1100, 60, 50, 60000, 55000, '河南省', '洛阳市', '涧西区', '磁涧镇', '后坡村');
INSERT INTO `agricultural_work` VALUES (3, 2, '2020-07-22 14:24:07', NULL, 200, 186, 46, 53, 9200, 9858, '河北省', '石家庄市', '鹿泉区', '山尹镇', '山尹村');
INSERT INTO `agricultural_work` VALUES (4, 2, '2020-07-20 15:15:16', NULL, 300, 300, 10, 10, 3000, 3000, '河北省', '石家庄市', '鹿泉区', '山尹镇', '山尹村');
INSERT INTO `agricultural_work` VALUES (6, 3, NULL, '11111,1111', 100, 100, 100, 100, 10000, 10000, '河南省', '洛阳市', '涧西区', '涧西县', '建西村');

SET FOREIGN_KEY_CHECKS = 1;
