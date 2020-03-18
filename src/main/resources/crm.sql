/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-03-18 22:39:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '诗人名',
  `sex` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '性别',
  `dynasty` enum('唐朝','宋朝') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '朝代',
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', '李白', '男', '唐朝');
INSERT INTO `author` VALUES ('2', '杜甫', '男', '唐朝');
INSERT INTO `author` VALUES ('3', '白居易', '男', '唐朝');

-- ----------------------------
-- Table structure for crm_authority
-- ----------------------------
DROP TABLE IF EXISTS `crm_authority`;
CREATE TABLE `crm_authority` (
  `AUTHORITY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `AUTHORITY_NAME` varchar(70) NOT NULL COMMENT '权限名称',
  `AUTHORITY_TYPE` int(1) NOT NULL COMMENT '权限级别（1表示一级权限2表示二级权限，二级权限才有实际的功能）',
  `URL_CODE` varchar(30) DEFAULT NULL COMMENT '权限功能打开选项卡时选项卡中include的JSP页面名称',
  `PARENT_ID` int(11) NOT NULL COMMENT '类别编号（一级权限parent_id和自身的authority_id相同，二级权限是其对应的一级权限的authority_id）',
  PRIMARY KEY (`AUTHORITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of crm_authority
-- ----------------------------
INSERT INTO `crm_authority` VALUES ('1', '部门管理', '2', 'depart', '6');
INSERT INTO `crm_authority` VALUES ('2', '职位管理', '2', 'role', '7');
INSERT INTO `crm_authority` VALUES ('3', '员工管理', '2', 'user', '6');
INSERT INTO `crm_authority` VALUES ('4', '修改密码', '2', 'updatePwd', '5');
INSERT INTO `crm_authority` VALUES ('5', '账号管理', '1', null, '5');
INSERT INTO `crm_authority` VALUES ('6', '人事管理', '1', null, '6');
INSERT INTO `crm_authority` VALUES ('7', '系统管理', '1', null, '7');

-- ----------------------------
-- Table structure for crm_authority_job
-- ----------------------------
DROP TABLE IF EXISTS `crm_authority_job`;
CREATE TABLE `crm_authority_job` (
  `AUTHORITY_JOB_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `JOBINFO_ID` int(11) NOT NULL COMMENT '对应职位表主键',
  `AUTHORITY_ID` int(11) NOT NULL COMMENT '对应权限表主键',
  PRIMARY KEY (`AUTHORITY_JOB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of crm_authority_job
-- ----------------------------
INSERT INTO `crm_authority_job` VALUES ('240', '1', '4');
INSERT INTO `crm_authority_job` VALUES ('241', '1', '1');
INSERT INTO `crm_authority_job` VALUES ('242', '1', '3');
INSERT INTO `crm_authority_job` VALUES ('243', '1', '2');
INSERT INTO `crm_authority_job` VALUES ('255', '2', '4');
INSERT INTO `crm_authority_job` VALUES ('256', '2', '3');

-- ----------------------------
-- Table structure for crm_consult_record
-- ----------------------------
DROP TABLE IF EXISTS `crm_consult_record`;
CREATE TABLE `crm_consult_record` (
  `CONSULT_RECORD_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CUSTOMER_ID` int(11) NOT NULL COMMENT '客户编号（对应客户表主键）',
  `CONSULTANT_ID` int(11) NOT NULL COMMENT '咨询师编号（对应员工表主键）',
  `CONSULT_STATUS` int(1) NOT NULL COMMENT '咨询状态（0：新增 1：紧跟 2：已报名\r\n3：死单(死单时同时更新客户基础信息表状态)\r\n4报名后退费\r\n）',
  `CONSULT_DATE` varchar(20) NOT NULL COMMENT '咨询日期（分配到的日期）',
  `CONSULT_MARK` varchar(100) DEFAULT NULL COMMENT '咨询备注',
  PRIMARY KEY (`CONSULT_RECORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of crm_consult_record
-- ----------------------------

-- ----------------------------
-- Table structure for crm_customer
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer`;
CREATE TABLE `crm_customer` (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `CUSTOMER_NAME` varchar(30) NOT NULL COMMENT '客户姓名',
  `EDUCATION` varchar(10) DEFAULT NULL COMMENT '教育水平',
  `CUSTOMER_PHONE` varchar(11) NOT NULL COMMENT '手机',
  `QQ` int(11) DEFAULT NULL COMMENT 'QQ',
  `CUSTOMER_EMAIL` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `CUSTOMER_STATUS` int(1) DEFAULT NULL COMMENT '客户状态:0 新增未上门 1新增已上门 2：销售跟进中 3：咨询跟进中 4：死单 5：已报名 ',
  `CREATE_DATE` varchar(20) DEFAULT NULL COMMENT '创建日期',
  `INVITER_NAME` varchar(30) DEFAULT NULL COMMENT '邀请人姓名',
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of crm_customer
-- ----------------------------
INSERT INTO `crm_customer` VALUES ('1', 'lcy1', '本科', '15811111111', '1111111111', '1111111111@qq.com', '0', '21-12月-18', null);

-- ----------------------------
-- Table structure for crm_customer_tracking_info
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer_tracking_info`;
CREATE TABLE `crm_customer_tracking_info` (
  `CUSTOMER_TRACKING_INFO_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CUSTOMER_ID` int(11) NOT NULL COMMENT '客户编号（对应客户表主键）',
  `DOCUMENTARY_PERSON_ID` int(11) NOT NULL COMMENT '跟单人编号（对应员工表主键）',
  `DOCUMENTARY_STATUS` int(1) NOT NULL COMMENT '跟单状态（0：未联系 1：未接通\r\n2：紧跟 3：已上门4：死单(死单时同时更新客户基础信息表状态)，5：电话无效\r\n）',
  `START_DATE` varchar(20) NOT NULL COMMENT '分配到的日期',
  `LAST_FOLLOW_DATE` varchar(20) DEFAULT NULL COMMENT '最近联系',
  `PLAN_DATE` varchar(30) DEFAULT NULL COMMENT '计划联系日期',
  `MARK` varchar(100) DEFAULT NULL COMMENT '跟单备注',
  PRIMARY KEY (`CUSTOMER_TRACKING_INFO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of crm_customer_tracking_info
-- ----------------------------

-- ----------------------------
-- Table structure for crm_department
-- ----------------------------
DROP TABLE IF EXISTS `crm_department`;
CREATE TABLE `crm_department` (
  `DEPARTMENT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `DEPARTMENT_NAME` varchar(20) NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of crm_department
-- ----------------------------
INSERT INTO `crm_department` VALUES ('1', '技术部');
INSERT INTO `crm_department` VALUES ('2', '销售部');
INSERT INTO `crm_department` VALUES ('3', '线上咨询部');
INSERT INTO `crm_department` VALUES ('4', '线下咨询部');
INSERT INTO `crm_department` VALUES ('5', '销售支持部');

-- ----------------------------
-- Table structure for crm_employee
-- ----------------------------
DROP TABLE IF EXISTS `crm_employee`;
CREATE TABLE `crm_employee` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `EMPLOYEE_USERNAME` varchar(30) NOT NULL COMMENT '用户名',
  `EMPLOYEE_PASSWORD` varchar(18) NOT NULL COMMENT '密码',
  `EMPLOYEE_NICKNAME` varchar(30) NOT NULL COMMENT '昵称',
  `EMPLOYEE_REALNAME` varchar(30) NOT NULL COMMENT '真实姓名',
  `JOBINFO_ID` int(11) NOT NULL COMMENT '职位编号',
  `DEPARTMENT_ID` int(11) NOT NULL COMMENT '部门编号',
  `EMPLOYEE_PHONE` varchar(11) NOT NULL COMMENT '手机',
  `OFFICE_TEL` varchar(11) DEFAULT NULL COMMENT '办公电话',
  `WORK_STATUS` int(1) NOT NULL COMMENT '在职状态(1表示在职，0表示离职。离职后不能登陆系统)',
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of crm_employee
-- ----------------------------
INSERT INTO `crm_employee` VALUES ('1', 'cy123', '123456', 'Heskey', '陈煜', '1', '1', '15858494198', '66666666', '1');
INSERT INTO `crm_employee` VALUES ('4', 'wyl', '000000', 'Crisom', '王韵琳', '2', '1', '15822222222', null, '1');

-- ----------------------------
-- Table structure for crm_jobinfo
-- ----------------------------
DROP TABLE IF EXISTS `crm_jobinfo`;
CREATE TABLE `crm_jobinfo` (
  `JOBINFO_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位编号',
  `JOBINFO_NAME` varchar(20) NOT NULL COMMENT '职位名称',
  `DEPARTMENT_ID` int(11) NOT NULL COMMENT '部门编号',
  PRIMARY KEY (`JOBINFO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of crm_jobinfo
-- ----------------------------
INSERT INTO `crm_jobinfo` VALUES ('1', '超级管理员', '1');
INSERT INTO `crm_jobinfo` VALUES ('2', '管理员', '1');
INSERT INTO `crm_jobinfo` VALUES ('3', '销售主管', '2');
INSERT INTO `crm_jobinfo` VALUES ('4', '销售员', '2');
INSERT INTO `crm_jobinfo` VALUES ('5', '网络咨询主管', '3');
INSERT INTO `crm_jobinfo` VALUES ('6', '网络咨询师', '3');
INSERT INTO `crm_jobinfo` VALUES ('7', '咨询主管', '4');
INSERT INTO `crm_jobinfo` VALUES ('8', '咨询师', '4');

-- ----------------------------
-- Table structure for crm_resetpass_record
-- ----------------------------
DROP TABLE IF EXISTS `crm_resetpass_record`;
CREATE TABLE `crm_resetpass_record` (
  `RESETPASS_RECORD_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `USERNAME` varchar(30) NOT NULL COMMENT '用户名',
  `PHONE` varchar(11) NOT NULL COMMENT '手机号',
  PRIMARY KEY (`RESETPASS_RECORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of crm_resetpass_record
-- ----------------------------

-- ----------------------------
-- Table structure for poetry
-- ----------------------------
DROP TABLE IF EXISTS `poetry`;
CREATE TABLE `poetry` (
  `poetry_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '诗词名',
  `author_id` int(11) NOT NULL COMMENT '作者id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '诗词内容',
  `image_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`poetry_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of poetry
-- ----------------------------
INSERT INTO `poetry` VALUES ('1', '静夜思', '1', '床前明月光，疑是地上霜。\r\n举头望明月，低头思故乡。', null, '2020-03-07 21:01:40');
INSERT INTO `poetry` VALUES ('2', '赠汪伦', '1', '李白乘舟将欲行，忽闻岸上踏歌声。\r\n桃花潭水深千尺，不及汪伦送我情。', null, '2020-03-07 21:02:03');
INSERT INTO `poetry` VALUES ('3', '赋得古原草送别', '3', '离离原上草，一岁一枯荣。\r\n野火烧不尽，春风吹又生。\r\n远芳侵古道，晴翠接荒城。\r\n又送王孙去，萋萋满别情。', null, '2020-03-07 21:04:14');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'px', '123456');
INSERT INTO `user` VALUES ('2', 'cy', '123456');
SET FOREIGN_KEY_CHECKS=1;
