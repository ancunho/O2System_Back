CREATE DATABASE  IF NOT EXISTS `o2system_dev` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `o2system_dev`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: o2system_dev
-- ------------------------------------------------------
-- Server version	5.7.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='공통설정데이타 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_config`
--

LOCK TABLES `tb_config` WRITE;
/*!40000 ALTER TABLE `tb_config` DISABLE KEYS */;
INSERT INTO `tb_config` VALUES (1,'DEPARTMENT','人资部','1','인사부',NULL,NULL,NULL,NULL,NULL),(2,'DEPARTMENT','财务部','2','재무부',NULL,NULL,NULL,NULL,NULL),(3,'DEPARTMENT','营业部','3','영업부',NULL,NULL,NULL,NULL,NULL),(4,'QUESTION','1','QUESTION---1','QUESTION----1_KR',NULL,NULL,NULL,NULL,NULL),(5,'QUESTION','2','QUESTION---2','QUESTION----2_KR',NULL,NULL,NULL,NULL,NULL),(6,'QUESTION','3','QUESTION---3','QUESTION----3_KR',NULL,NULL,NULL,NULL,NULL),(7,'PRODUCT_CATEGORY','1','保健食品-1','보건식품-1',NULL,NULL,NULL,NULL,NULL),(8,'PRODUCT_CATEGORY','2','保健食品-2','보건식품-2',NULL,NULL,NULL,NULL,NULL),(9,'PRODUCT_CATEGORY','3','保健食品-3','보건식품-3',NULL,NULL,NULL,NULL,NULL),(10,'PRODUCT_CATEGORY','4','保健食品-4','보건식품-4',NULL,NULL,NULL,NULL,NULL),(11,'PRODUCT_PACKAGE','1','包装类型-1','포장유형-1',NULL,NULL,NULL,NULL,NULL),(12,'PRODUCT_PACKAGE','2','包装类型-2','포장유형-2',NULL,NULL,NULL,NULL,NULL),(13,'PRODUCT_PACKAGE','3','包装类型-2','포장유형-3',NULL,NULL,NULL,NULL,NULL),(14,'PRODUCT_CONCEPT','1','CONCEPT-1','CONCEPT유형-1',NULL,NULL,NULL,NULL,NULL),(15,'PRODUCT_CONCEPT','2','CONCEPT-2','CONCEPT유형-2',NULL,NULL,NULL,NULL,NULL),(16,'PRODUCT_CONCEPT','3','CONCEPT-3','CONCEPT유형-3',NULL,NULL,NULL,NULL,NULL),(17,'PRODUCT_TYPE','1','食品类型-1','식품유형-1',NULL,NULL,NULL,NULL,NULL),(18,'PRODUCT_TYPE','2','食品类型-2','식품유형-2',NULL,NULL,NULL,NULL,NULL),(19,'PRODUCT_TYPE','3','食品类型-3','식품유형-3',NULL,NULL,NULL,NULL,NULL),(20,'PROJECT_STATUS','1','项目进行中','진행중',NULL,NULL,NULL,NULL,NULL),(21,'PROJECT_STATUS','2','产品咨询/确认','제품협의/확정',NULL,NULL,NULL,NULL,NULL),(22,'PROJECT_STATUS','3','标签/出口准备','라벨/수출준비',NULL,NULL,NULL,NULL,NULL),(23,'PROJECT_STATUS','4','PO/合同/订单','PO/계약/발주',NULL,NULL,NULL,NULL,NULL),(24,'PROJECT_STATUS','5','生产/出库','생산/출고',NULL,NULL,NULL,NULL,NULL),(25,'PROJECT_STATUS','6','出口/AS','수출/AS',NULL,NULL,NULL,NULL,NULL),(26,'PROJECT_STATUS','99','项目已结束','진행완료',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_customer`
--

DROP TABLE IF EXISTS `tb_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` varchar(100) DEFAULT NULL,
  `CUSTOMER_NAME` varchar(50) DEFAULT NULL,
  `CUSTOMER_NAME_KR` varchar(50) DEFAULT NULL,
  `CUSTOMER_CD` varchar(45) DEFAULT NULL,
  `AUTHOR` varchar(45) DEFAULT NULL,
  `DIRECTOR` varchar(45) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `PHONE` varchar(45) DEFAULT NULL,
  `WECHAT` varchar(45) DEFAULT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `SALES_VOLUMN` varchar(45) DEFAULT NULL,
  `DEVELOPMENT_SKILL` varchar(45) DEFAULT NULL,
  `TARGET` varchar(45) DEFAULT NULL,
  `PRODUCT_LIST` varchar(200) DEFAULT NULL,
  `DISTRIBUTION` varchar(100) DEFAULT NULL,
  `PROVINCE` varchar(45) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `AREA` varchar(45) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `SALES_MAN` varchar(200) DEFAULT NULL,
  `CUSTOMER_IMAGE` varchar(100) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='고객테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_customer`
--

LOCK TABLES `tb_customer` WRITE;
/*!40000 ALTER TABLE `tb_customer` DISABLE KEYS */;
INSERT INTO `tb_customer` VALUES (18,'[1,2]','11111',NULL,'#aaaaaaaaa',NULL,'111',NULL,'11','11','1111','111','111','111','11','111','11','1101','110101','1111','[11,10,4]','/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-18 00:00:00','2020-04-19 20:18:29'),(19,NULL,'2222',NULL,'22222',NULL,'2222',NULL,NULL,NULL,NULL,'222','2222',NULL,NULL,NULL,'12','1201','120101','2222',NULL,'/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-18 23:00:14','2020-04-18 23:00:14'),(20,NULL,'333',NULL,'3333',NULL,'333',NULL,NULL,NULL,NULL,'333','3333',NULL,NULL,NULL,'11','1101','110101','3333',NULL,'/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-18 23:00:51','2020-04-18 23:00:51'),(21,NULL,'4444',NULL,'4444',NULL,'4444',NULL,NULL,NULL,NULL,'4444','4444',NULL,NULL,NULL,'11','1101','110101','4444',NULL,'/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-18 23:01:15','2020-04-18 23:01:15'),(22,NULL,'555',NULL,'5555',NULL,'5',NULL,NULL,NULL,NULL,'5','5',NULL,NULL,NULL,'11','1101','110101','555',NULL,'/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-18 23:01:34','2020-04-18 23:01:34'),(23,NULL,'6',NULL,'6',NULL,'6',NULL,NULL,NULL,NULL,'6','6',NULL,NULL,NULL,'11','1101','110101','6',NULL,'/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-18 23:04:44','2020-04-18 23:04:44'),(24,'[1,2]','7',NULL,'7',NULL,'7',NULL,NULL,NULL,NULL,'7','7',NULL,NULL,NULL,'12','1201','120101','7',NULL,'/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-19 15:05:16','2020-04-19 20:07:31'),(25,'[1,2]','8',NULL,'8',NULL,'8',NULL,NULL,NULL,NULL,'8','8',NULL,NULL,NULL,'11','1101','110101','8','[]','/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-19 00:00:00','2020-04-19 20:18:56'),(26,'[1,2]','9',NULL,'9',NULL,'9',NULL,NULL,NULL,NULL,'9sdfghj','9',NULL,NULL,NULL,'11','1101','110101','9','[]','/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-19 00:00:00','2020-04-19 20:18:42');
/*!40000 ALTER TABLE `tb_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_log`
--

DROP TABLE IF EXISTS `tb_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_project_baseinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_CD` varchar(20) DEFAULT NULL,
  `PROJECT_NAME` varchar(100) DEFAULT NULL,
  `PROJECT_CUSTOMER` varchar(50) DEFAULT NULL,
  `PROJECT_SALES_MAN` varchar(50) DEFAULT NULL,
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
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='프로젝트기본정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_baseinfo`
--

LOCK TABLES `tb_project_baseinfo` WRITE;
/*!40000 ALTER TABLE `tb_project_baseinfo` DISABLE KEYS */;
INSERT INTO `tb_project_baseinfo` VALUES (20,'aaaaa','aaaaa','11111','[13]','aaaa','1','2020-04-19','2020-04-19',NULL,NULL,NULL,NULL,NULL,'2020-04-19 18:06:04','2020-04-19 18:06:04'),(21,'3333','333','9','[12]','333','1','2020-04-19','2020-04-12',NULL,NULL,NULL,NULL,NULL,'2020-04-19 18:09:33','2020-04-19 18:09:33'),(22,'qqqq','qqqq','8','[13]','qqq','1','2020-04-19','2020-04-19',NULL,NULL,NULL,NULL,NULL,'2020-04-19 20:00:37','2020-04-19 20:00:37'),(23,'zzzz','zzz','11111','[13]','zzz','1','2020-04-19','2020-04-19',NULL,NULL,NULL,NULL,NULL,'2020-04-19 20:02:33','2020-04-19 20:02:33'),(24,'aaaaaa','aaaa','7','[13]','aaaa','1','2020-04-01','2020-04-07',NULL,NULL,NULL,NULL,NULL,'2020-04-19 20:07:31','2020-04-19 20:07:31');
/*!40000 ALTER TABLE `tb_project_baseinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_customer`
--

DROP TABLE IF EXISTS `tb_project_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
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
/*!50503 SET character_set_client = utf8mb4 */;
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
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
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
/*!50503 SET character_set_client = utf8mb4 */;
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
  `PRICE_LIST` varchar(2000) DEFAULT NULL,
  `DESCRIPTION_LIST` varchar(2000) DEFAULT NULL,
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
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='프로젝트 가격정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_price`
--

LOCK TABLES `tb_project_price` WRITE;
/*!40000 ALTER TABLE `tb_project_price` DISABLE KEYS */;
INSERT INTO `tb_project_price` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,1,2,'제품명','111','11111','99','999','22222','88888','8','9999','json','json','text text text','text','text','text','2020-04-20','text',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,22,NULL,'','','','','','','','','','[]','[]','','','','','','',NULL,NULL,NULL,NULL,NULL,'2020-04-19 20:00:44','2020-04-19 20:00:44'),(4,24,NULL,'a','a','a','a','a','a','a','a','a','[{\"project\":\"\",\"price\":\"a\",\"setPrice\":\"a\",\"percent\":\"a\"}]','[{\"key\":\"a\",\"value\":\"a\"}]','a','a','aaaaaa','aaa','2020-04-02','aaaa',NULL,NULL,NULL,NULL,NULL,'2020-04-19 20:08:14','2020-04-19 20:08:14');
/*!40000 ALTER TABLE `tb_project_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_product`
--

DROP TABLE IF EXISTS `tb_project_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `PRODUCT_QUANTITY` varchar(20) DEFAULT NULL,
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
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='프로젝트 제품정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_product`
--

LOCK TABLES `tb_project_product` WRITE;
/*!40000 ALTER TABLE `tb_project_product` DISABLE KEYS */;
INSERT INTO `tb_project_product` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2020-04-17 23:53:18','2020-04-17 23:53:18'),(2,1,'제품명','[\'text1\',\'222\',\'333\',\'444\']','[\'aaa\',\'bbb\',\'cccc\',\'dddd\']','2','4','text text text','33','234','3999','text text text text','text text text','http://114.xxxxxxxx/xxxx.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-18 15:59:53','2020-04-18 15:59:53'),(3,22,'123123','[]','[]','','','','',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'2020-04-19 20:00:44','2020-04-19 20:00:44'),(4,24,'aaa','[\"aaa\",\"aa\",\"a\"]','[\"zz\",\"zzzzzz\"]','aa','a','a','a','a','a','aaa','aaa','',NULL,NULL,NULL,NULL,NULL,'2020-04-19 20:08:14','2020-04-19 20:08:14');
/*!40000 ALTER TABLE `tb_project_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_record`
--

DROP TABLE IF EXISTS `tb_project_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_project_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `RECORD_ID` varchar(20) DEFAULT NULL,
  `RECORD_CONTENT` varchar(2000) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='프로젝트 이력정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_record`
--

LOCK TABLES `tb_project_record` WRITE;
/*!40000 ALTER TABLE `tb_project_record` DISABLE KEYS */;
INSERT INTO `tb_project_record` VALUES (1,NULL,'recode1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,'recode222',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,1,'1','{\"projectId\":1,\"timelineAuthor\":\"XXXXX\",\"timelineContent\":\"json\",\"timelineId\":\"1\"}',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,1,'2','{\"projectId\":1,\"timelineAuthor\":\"XXXXX\",\"timelineContent\":\"json\",\"timelineId\":\"1\"}',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,1,'3','{\"projectId\":1,\"timelineAuthor\":\"XXXXX\",\"timelineContent\":\"json\",\"timelineId\":\"1\"}',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,1,'4','{\"projectId\":1,\"timelineAuthor\":\"XXXXX\",\"timelineContent\":\"json\",\"timelineId\":\"1\"}',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,1,'5','{\"projectId\":1,\"timelineAuthor\":\"XXXXX\",\"timelineContent\":\"json\",\"timelineId\":\"1\"}',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,24,'1','[{\"title\":\"aaaa\",\"date\":\"2020-04-01T12:08:02.477Z\",\"content\":\"aa\",\"principal\":\"aaaa\",\"check\":\"aaa\"},{\"title\":\"aaa\",\"date\":\"2020-04-04T12:08:03.023Z\",\"content\":\"aaa\",\"principal\":\"aa\",\"check\":\"aaa\"}]',NULL,NULL,NULL,NULL,NULL,'2020-04-19 20:08:14','2020-04-19 20:08:14');
/*!40000 ALTER TABLE `tb_project_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project_salesman`
--

DROP TABLE IF EXISTS `tb_project_salesman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_project_timeline` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `MEETING_TIME` varchar(10) DEFAULT NULL,
  `MEETING_DATE` varchar(45) DEFAULT NULL,
  `TIMELINE_CONTENT` varchar(2000) DEFAULT NULL,
  `TIMELINE_AUTHOR` varchar(30) DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `PARAM1` varchar(45) DEFAULT NULL,
  `PARAM2` varchar(45) DEFAULT NULL,
  `PARAM3` varchar(45) DEFAULT NULL,
  `PARAM4` varchar(45) DEFAULT NULL,
  `PARAM5` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='프로젝트미팅기록';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project_timeline`
--

LOCK TABLES `tb_project_timeline` WRITE;
/*!40000 ALTER TABLE `tb_project_timeline` DISABLE KEYS */;
INSERT INTO `tb_project_timeline` VALUES (1,1,NULL,NULL,'json','XXXXX','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,1,NULL,NULL,'json','XXXXX','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,1,NULL,NULL,'json','XXXXX','3',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_project_timeline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `PROVINCE` varchar(45) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `AREA` varchar(45) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='회원테이블\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (3,'admin','D8F80B67499E434EA61ADAF6E6219BF2','1','ROLE_ADMIN',NULL,'1111111','ancunho','17712341324','test@test.com','人资部','1','2020-04-29','cunho910','222222','11','1101','110101','qqqqqqqq','wenti','daan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2020-04-18 22:45:38'),(4,'cunho','6915C112187BBFAB3F685563000AA080','0','ROLE_USER',NULL,'123456','111111','17712341234','test2@test.com','人资部','1','2020-04-07','cunho910','111111','11','1101','110101','xxxxxxx','wenti','daan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2020-04-18 22:45:05'),(9,'test123','4F98253DECBEB8C4ABD31CCF68919E17','0','ROLE_USER',NULL,'1234',NULL,'17712341234','123@123.com','财务部',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2','123213123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2020-04-18 22:45:15'),(10,'harace','2A26383F9C7E3D39D87D0967C517A3FB','0','ROLE_USER','1','wqeqwe','ym','17712341234','ym@test.com','财务部',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2','qweqe','/avatar.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'user1234','D8F80B67499E434EA61ADAF6E6219BF2','0','ROLE_USER','1','11111','2222','17712341234','user@user.com','人资部','1','2020-04-18','333334','444444','11','1101','110105','55555','1','666666','/avatar.jpg',NULL,NULL,NULL,NULL,NULL,NULL,'2020-04-18 22:44:16'),(12,'aaaaaa','2A26383F9C7E3D39D87D0967C517A3FB','0','ROLE_USER','1','aaaaa','aaaa','17712341234','qwe@ad.com','人资部','1','2020-04-28','aaaaaaa',NULL,NULL,NULL,NULL,NULL,'1','aaaaa','/avatar.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'user2','2A26383F9C7E3D39D87D0967C517A3FB','0','ROLE_USER','1','user2','user','17712341234','user2@user.com','人资部','1','2020-04-19','11111',NULL,'11','1101','110101','1','1','1','/avatar.jpg',NULL,NULL,NULL,NULL,NULL,'2020-04-19 00:00:00','2020-04-19 20:19:24');
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

-- Dump completed on 2020-04-22 23:18:39
