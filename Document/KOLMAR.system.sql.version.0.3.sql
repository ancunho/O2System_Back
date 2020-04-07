-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: o2system_dev
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_config`
--

DROP TABLE IF EXISTS `tb_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CNF_CODE` varchar(50) DEFAULT NULL,
  `CNF_VALUE` varchar(50) DEFAULT NULL,
  `CNF_NOTE` varchar(50) DEFAULT NULL,
  `CNF_NOTE_KR` varchar(50) DEFAULT NULL,
  `CNF_PARAM_1` varchar(50) DEFAULT NULL,
  `CNF_PARAM_2` varchar(50) DEFAULT NULL,
  `CNF_PARAM_3` varchar(50) DEFAULT NULL,
  `CNF_PARAM_4` varchar(50) DEFAULT NULL,
  `CNF_PARAM_5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='공통설정데이타 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_config`
--

LOCK TABLES `tb_config` WRITE;
/*!40000 ALTER TABLE `tb_config` DISABLE KEYS */;
INSERT INTO `tb_config` VALUES (1,'DEPARTMENT','人资部','1','인사부',NULL,NULL,NULL,NULL,NULL),(2,'DEPARTMENT','财务部','2','재무부',NULL,NULL,NULL,NULL,NULL),(3,'DEPARTMENT','营业部','3','영업부',NULL,NULL,NULL,NULL,NULL),(4,'QUESTION','1','QUESTION---1','QUESTION----1_KR',NULL,NULL,NULL,NULL,NULL),(5,'QUESTION','2','QUESTION---2','QUESTION----2_KR',NULL,NULL,NULL,NULL,NULL),(6,'QUESTION','3','QUESTION---3','QUESTION----3_KR',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_customer`
--

DROP TABLE IF EXISTS `tb_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_NAME` varchar(50) DEFAULT NULL,
  `CUSTOMER_NAME_KR` varchar(50) DEFAULT NULL,
  `CUSTOMER_CD` varchar(50) DEFAULT NULL,
  `DIRECTOR` varchar(50) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `PHONE` varchar(50) DEFAULT NULL,
  `WECHAT` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `TARGET` varchar(100) DEFAULT NULL,
  `PRODUCT_LIST` varchar(100) DEFAULT NULL,
  `DISTRIBUTION` varchar(50) DEFAULT NULL,
  `PROVINCE` varchar(30) DEFAULT NULL,
  `CITY` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `AUTHOR` varchar(45) DEFAULT NULL,
  `CUSTOMER_IMAGE` varchar(100) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='고객정보테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_customer`
--

LOCK TABLES `tb_customer` WRITE;
/*!40000 ALTER TABLE `tb_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_log`
--

DROP TABLE IF EXISTS `tb_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AUTHOR` varchar(45) DEFAULT NULL,
  `ACTION_ID` varchar(45) DEFAULT NULL,
  `ACTION_NAME` varchar(50) DEFAULT NULL,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `PRODUCT_ID` int(11) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_log`
--

LOCK TABLES `tb_log` WRITE;
/*!40000 ALTER TABLE `tb_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_baseinfo`
--

DROP TABLE IF EXISTS `tb_project_baseinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_project_baseinfo` (
  `ID` int(11) NOT NULL,
  `PROJECT_CD` varchar(20) DEFAULT NULL,
  `PROJECT_NAME` varchar(100) DEFAULT NULL,
  `PROJECT_CUSTOMER` varchar(50) DEFAULT NULL,
  `PROJECT_PRICE_TOTAL` varchar(50) DEFAULT NULL,
  `PROJECT_STATUS` varchar(50) DEFAULT NULL,
  `PROJECT_STARTTIME` varchar(50) DEFAULT NULL,
  `PROJECT_ENDTIME` varchar(50) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='프로젝트기본정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_baseinfo`
--

LOCK TABLES `tb_project_baseinfo` WRITE;
/*!40000 ALTER TABLE `tb_project_baseinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_project_baseinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_customer`
--

DROP TABLE IF EXISTS `tb_project_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_project_customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `CUSTOMER_NAME` varchar(50) DEFAULT NULL,
  `CUSTOMER_CD` varchar(50) DEFAULT NULL,
  `DIRECTOR` varchar(50) DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `MOBILE` varchar(50) DEFAULT NULL,
  `WECHAT` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `SALES_VOLUMN` varchar(50) DEFAULT NULL,
  `DEVELOPMENT_SKILL` varchar(50) DEFAULT NULL,
  `TARGET` varchar(50) DEFAULT NULL,
  `PRODUCT_LIST` varchar(50) DEFAULT NULL,
  `DISTRIBUTION` varchar(50) DEFAULT NULL,
  `CITY` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(50) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='프로젝트 - 고객정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_customer`
--

LOCK TABLES `tb_project_customer` WRITE;
/*!40000 ALTER TABLE `tb_project_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_project_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_fileinfo`
--

DROP TABLE IF EXISTS `tb_project_fileinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_project_fileinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `FILE_NAME` varchar(45) DEFAULT NULL,
  `FILE_EXTENSION` varchar(10) DEFAULT NULL,
  `FILE_COMMENT` varchar(45) DEFAULT NULL,
  `FILE_PATH` varchar(100) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='첨부파일';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_fileinfo`
--

LOCK TABLES `tb_project_fileinfo` WRITE;
/*!40000 ALTER TABLE `tb_project_fileinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_project_fileinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_price`
--

DROP TABLE IF EXISTS `tb_project_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_project_price` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `PROJECT_PRODUCT_ID` int(11) DEFAULT NULL,
  `PRODUCT_NAME` varchar(30) DEFAULT NULL,
  `ORDER_QUANTITY` varchar(30) DEFAULT NULL,
  `ACTUAL_INPUT` varchar(30) DEFAULT NULL,
  `UNIT_WEIGHT` varchar(30) DEFAULT NULL,
  `WEIGHT` varchar(30) DEFAULT NULL,
  `PACKAGE_SPEC` varchar(30) DEFAULT NULL,
  `THEORY_QUANTITY` varchar(30) DEFAULT NULL,
  `YIELD_PERCENT` varchar(30) DEFAULT NULL,
  `ACTUAL_PRODUCTION` varchar(30) DEFAULT NULL,
  `PRICE_LIST` varchar(200) DEFAULT NULL,
  `DESCRIPTION_LIST` varchar(200) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `VALUE_NO_VAT` varchar(30) DEFAULT NULL,
  `SPECIAL_COMMENT` varchar(50) DEFAULT NULL,
  `PERSON_IN_CHARGE` varchar(30) DEFAULT NULL,
  `RELEASE_DATE` varchar(30) DEFAULT NULL,
  `DEAL_PLACE` varchar(30) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='프로젝트 가격정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_price`
--

LOCK TABLES `tb_project_price` WRITE;
/*!40000 ALTER TABLE `tb_project_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_project_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_product`
--

DROP TABLE IF EXISTS `tb_project_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_project_product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `PRODUCT_NAME` varchar(50) DEFAULT NULL,
  `PRODUCT_MAIN_MATERIAL` varchar(200) DEFAULT NULL,
  `PRODUCT_SUB_MATERIAL` varchar(200) DEFAULT NULL,
  `PRODUCT_CATEGORY` varchar(30) DEFAULT NULL,
  `PRODUCT_PACKAGE` varchar(30) DEFAULT NULL,
  `PRODUCT_CONCEPT` varchar(100) DEFAULT NULL,
  `PRODUCT_TYPE` varchar(30) DEFAULT NULL,
  `PRODUCT_TARGET_PRICE` varchar(10) DEFAULT NULL,
  `PRODUCT_DETAIL` varchar(200) DEFAULT NULL,
  `PRODUCT_TARGET_CONTENT` varchar(100) DEFAULT NULL,
  `PRODUCT_IMAGE` varchar(100) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='프로젝트 제품정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_product`
--

LOCK TABLES `tb_project_product` WRITE;
/*!40000 ALTER TABLE `tb_project_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_project_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_record`
--

DROP TABLE IF EXISTS `tb_project_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_project_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `RECORD_ID` varchar(20) DEFAULT NULL,
  `RECORD_CONTENT` varchar(250) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='프로젝트 이력정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_record`
--

LOCK TABLES `tb_project_record` WRITE;
/*!40000 ALTER TABLE `tb_project_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_project_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_salesman`
--

DROP TABLE IF EXISTS `tb_project_salesman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_project_salesman` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `SALESMAN_ID` int(11) DEFAULT NULL,
  `SALESMAN_NAME` varchar(50) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='프로젝트 - 영업사원정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_salesman`
--

LOCK TABLES `tb_project_salesman` WRITE;
/*!40000 ALTER TABLE `tb_project_salesman` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_project_salesman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_timeline`
--

DROP TABLE IF EXISTS `tb_project_timeline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_project_timeline` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `TIMELINE_ID` varchar(20) DEFAULT NULL,
  `TIMELINE_CONTENT` varchar(250) DEFAULT NULL,
  `TIMELINE_AUTHOR` varchar(30) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='프로젝트미팅기록';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_timeline`
--

LOCK TABLES `tb_project_timeline` WRITE;
/*!40000 ALTER TABLE `tb_project_timeline` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_project_timeline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `ROLE_NO` varchar(2) DEFAULT NULL,
  `ROLE` varchar(30) DEFAULT NULL,
  `STATUS` varchar(2) DEFAULT NULL,
  `EMPNO` varchar(30) DEFAULT NULL,
  `REALNAME` varchar(20) DEFAULT NULL,
  `PHONE` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `DEPARTMENT` varchar(30) DEFAULT NULL,
  `SEX` varchar(2) DEFAULT NULL,
  `BIRTHDAY` varchar(30) DEFAULT NULL,
  `WECHAT` varchar(30) DEFAULT NULL,
  `QQ` varchar(30) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `QUESTION` varchar(100) DEFAULT NULL,
  `ANSWER` varchar(100) DEFAULT NULL,
  `IMAGE_PHOTO` varchar(100) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='회원테이블\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (3,'admin','427338237BD929443EC5D48E24FD2B1A','1','ROLE_ADMIN',NULL,NULL,NULL,'88888888','test@test.com',NULL,'1',NULL,'cunho910',NULL,NULL,'wenti','daan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2020-03-29 16:28:05'),(4,'cunho','6915C112187BBFAB3F685563000AA080','0','ROLE_USER',NULL,'123456',NULL,'88888888','test2@test.com',NULL,'1',NULL,'cunho910',NULL,'xxxxxxx','wenti','daan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2020-03-29 16:31:31'),(9,'test123','4F98253DECBEB8C4ABD31CCF68919E17','0','ROLE_USER',NULL,'1234',NULL,'17712341234','123@123.com','财务部',NULL,NULL,NULL,NULL,NULL,'2','123213123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2020-03-29 19:11:46');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-07 21:40:50
