/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50647
Source Host           : 39.96.53.121:3306
Source Database       : reservation_system

Target Server Type    : MYSQL
Target Server Version : 50647
File Encoding         : 65001

Date: 2020-07-19 18:12:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('0', 'admin', 'admin');
INSERT INTO `admin` VALUES ('22', 'username', 'password');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` varchar(5) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `windowId` int(4) DEFAULT NULL,
  `phoneNum` varchar(11) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1001', '张三', '1', '13626262626', '123');
INSERT INTO `employee` VALUES ('1002', '韩梅梅1', '2', '15336125311', '123');
INSERT INTO `employee` VALUES ('1003', '李四', '3', '13561666666', '123');
INSERT INTO `employee` VALUES ('1004', '二妞', '4', '15388888888', '123');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `windowId` int(2) DEFAULT NULL,
  `content` varchar(245) DEFAULT NULL,
  `score` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('15336125311', '史腾飞', '1', '服务态度真好！', '8');
INSERT INTO `evaluate` VALUES ('15336125311', '啊giao', '2', 'good', '9');
INSERT INTO `evaluate` VALUES ('15336125344', '三月', '4', '好', '6');
INSERT INTO `evaluate` VALUES ('.15336125388', '史腾飞', '1', '真好！', '8');
INSERT INTO `evaluate` VALUES ('15336125366', 'stf', '2', '很好的', '9');
INSERT INTO `evaluate` VALUES ('15336125311', '史腾飞', '1', '服务态度好', '9');

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `wid` int(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `state` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('1', '15312123344', '1', '2020-07-05 07:07:05', '1');
INSERT INTO `reservation` VALUES ('2', '15336125311', '1', '2020-07-05 08:10:31', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `openId` varchar(18) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` int(3) DEFAULT NULL,
  `cardId` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('15336125311', null, 'giao', '1', '610527199807215611');
INSERT INTO `student` VALUES ('15312123344', null, '尼姑拉丝', '2', '610527199807221111');
INSERT INTO `student` VALUES ('13812123344', null, '阿毛', '1', '610527199807222222');
INSERT INTO `student` VALUES ('13812123355', null, 'test1', '1', '610527199807222333');
INSERT INTO `student` VALUES ('13812123356', null, 'test2', '1', '610527199807222223');
INSERT INTO `student` VALUES ('15336125312', null, 'test3', '1', '610527199807222225');

-- ----------------------------
-- Table structure for window
-- ----------------------------
DROP TABLE IF EXISTS `window`;
CREATE TABLE `window` (
  `id` int(3) NOT NULL,
  `openTime` datetime DEFAULT NULL,
  `closeTime` datetime DEFAULT NULL,
  `currentSid` varchar(20) DEFAULT NULL,
  `waitCount` int(10) DEFAULT NULL,
  `maxCount` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of window
-- ----------------------------
INSERT INTO `window` VALUES ('1', '2020-05-20 00:00:00', '2020-05-21 00:00:00', '2', '5', '38');
INSERT INTO `window` VALUES ('2', '2020-05-19 16:00:00', '2020-05-19 16:00:00', '1', '1', '45');
INSERT INTO `window` VALUES ('3', '2020-05-20 11:24:46', '2020-05-20 11:24:46', '1', '4', '45');
INSERT INTO `window` VALUES ('4', '2020-05-20 00:00:00', '2020-05-21 00:00:00', '-1', '0', '50');
