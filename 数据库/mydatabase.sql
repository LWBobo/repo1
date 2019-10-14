/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : mydatabase

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-09-24 18:36:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `part`
-- ----------------------------
DROP TABLE IF EXISTS `part`;
CREATE TABLE `part` (
  `partkey` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `mfgr` char(25) DEFAULT NULL,
  `brand` char(10) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `container` char(10) DEFAULT NULL,
  `retailprice` double DEFAULT NULL,
  `comment` varchar(23) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of part
-- ----------------------------

-- ----------------------------
-- Table structure for `partsupp`
-- ----------------------------
DROP TABLE IF EXISTS `partsupp`;
CREATE TABLE `partsupp` (
  `partkey` int(11) DEFAULT NULL,
  `suppkey` int(11) DEFAULT NULL,
  `availqty` int(11) DEFAULT NULL,
  `supplycost` double DEFAULT NULL,
  `comment` varchar(199) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of partsupp
-- ----------------------------

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `suppkey` int(11) DEFAULT NULL,
  `name` char(25) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `nationkey` int(11) DEFAULT NULL,
  `phone` char(15) DEFAULT NULL,
  `acctbal` double DEFAULT NULL,
  `comment` varchar(101) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
