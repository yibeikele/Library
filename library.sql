-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: library
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `publish` varchar(20) DEFAULT NULL,
  `pages` float(10,2) DEFAULT NULL,
  `bookcaseid` int(10) DEFAULT NULL,
  `abled` int(10) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookcaseid` (`bookcaseid`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`bookcaseid`) REFERENCES `bookcase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (17,'解忧杂货店','东野圭吾','南海出版公司',102.00,2,1,27),(18,'追风筝的人','卡勒德·胡赛尼','上海人民出版社',230.00,3,0,34),(19,'人间失格','太宰治','作家出版社',150.00,1,1,17),(20,'这就是二十四节气','高春香','海豚出版社',220.00,3,1,59),(21,'白夜行','东野圭吾','南海出版公司',300.00,4,1,27),(22,'摆渡人','克莱儿·麦克福尔','百花洲文艺出版社',225.00,1,1,23),(23,'暖暖心绘本','米拦弗特毕','湖南少儿出版社',168.00,5,1,132),(24,'天才在左疯子在右','高铭','北京联合出版公司',330.00,6,1,28),(25,'我们仨','杨绛','生活.读书.新知三联书店',89.00,7,1,17),(26,'活着','余华','作家出版社',100.00,1,1,13),(27,'水浒传','施耐庵','三联出版社',300.00,1,1,50),(28,'三国演义','罗贯中','三联出版社',300.00,2,1,50),(29,'红楼梦','曹雪芹','三联出版社',300.00,5,1,50),(30,'西游记','吴承恩','三联出版社',300.00,3,1,60);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookadmin`
--

DROP TABLE IF EXISTS `bookadmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bookadmin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookadmin`
--

LOCK TABLES `bookadmin` WRITE;
/*!40000 ALTER TABLE `bookadmin` DISABLE KEYS */;
INSERT INTO `bookadmin` VALUES (4,'admin1','123123'),(5,'admin2','222222'),(6,'zhangsan','000');
/*!40000 ALTER TABLE `bookadmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookcase`
--

DROP TABLE IF EXISTS `bookcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bookcase` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookcase`
--

LOCK TABLES `bookcase` WRITE;
/*!40000 ALTER TABLE `bookcase` DISABLE KEYS */;
INSERT INTO `bookcase` VALUES (1,'社会'),(2,'情感'),(3,'国学'),(4,'推理'),(5,'绘画'),(6,'心理学'),(7,'传记');
/*!40000 ALTER TABLE `bookcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `borrow` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) DEFAULT NULL,
  `readerid` int(10) DEFAULT NULL,
  `borrowtime` varchar(20) DEFAULT NULL,
  `returntime` varchar(20) DEFAULT NULL,
  `adminid` int(10) DEFAULT NULL,
  `state` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
INSERT INTO `borrow` VALUES (17,27,7,'2019-08-27','2019-09-10',4,1),(18,20,7,'2019-08-27','2019-09-10',4,0),(19,20,7,'2019-08-27','2019-09-10',4,1),(20,20,7,'2019-08-27','2019-09-10',4,0),(21,21,7,'2019-09-10','2019-09-24',4,0),(22,21,7,'2019-09-17','2019-10-01',4,0),(23,21,7,'2019-09-17','2019-10-01',4,0),(24,21,7,'2019-09-18','2019-10-02',4,1),(25,22,7,'2019-09-18','2019-10-02',4,1),(26,21,7,'2019-09-18','2019-10-02',4,0),(27,21,7,'2019-09-18','2019-10-02',4,0),(28,23,7,'2019-09-18','2019-10-02',4,1),(29,21,7,'2019-09-18','2019-10-02',4,0),(30,21,7,'2019-09-18','2019-10-02',4,0),(31,21,7,'2019-09-18','2019-10-02',4,0),(32,22,7,'2019-09-18','2019-10-02',4,0),(33,23,7,'2019-09-18','2019-10-02',4,0),(34,23,7,'2019-09-18','2019-10-02',4,0),(35,23,7,'2019-09-18','2019-10-02',4,0),(36,24,7,'2019-09-18','2019-10-02',4,1),(37,23,7,'2019-09-18','2019-10-02',4,0),(38,23,7,'2019-09-18','2019-10-02',4,1),(39,24,7,'2019-09-18','2019-10-02',4,0),(40,25,7,'2019-09-18','2019-10-02',4,1),(41,26,7,'2019-09-18','2019-10-02',4,1),(42,27,9,'2019-09-18','2019-10-02',4,1),(43,29,9,'2019-09-18','2019-10-02',4,1),(44,20,7,'2019-09-18','2019-10-02',4,0),(45,17,7,'2019-09-18','2019-10-02',4,0);
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader`
--

DROP TABLE IF EXISTS `reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reader` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `cardid` varchar(20) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader`
--

LOCK TABLES `reader` WRITE;
/*!40000 ALTER TABLE `reader` DISABLE KEYS */;
INSERT INTO `reader` VALUES (7,'zhangsan','123123','张三','131','001','男'),(8,'lisi','000000','李四','987655123','002','男'),(9,'haha2','1231232','哈哈','13567876541','546578987654345','女'),(10,'xiaohua','zhangsan','张三三','15126262626','15261526','男'),(11,'xiaohao','zhangsan','吴作栋','15126263535','15265612','男');
/*!40000 ALTER TABLE `reader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `returnbook`
--

DROP TABLE IF EXISTS `returnbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `returnbook` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) DEFAULT NULL,
  `readerid` int(10) DEFAULT NULL,
  `returntime` varchar(20) DEFAULT NULL,
  `adminid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `returnbook`
--

LOCK TABLES `returnbook` WRITE;
/*!40000 ALTER TABLE `returnbook` DISABLE KEYS */;
INSERT INTO `returnbook` VALUES (1,20,7,'2019-09-18',4),(2,20,7,'2019-09-18',4),(3,20,7,'2019-09-18',4),(4,20,7,'2019-09-18',4),(5,20,7,'2019-09-18',4),(6,20,7,'2019-09-18',4),(7,20,7,'2019-09-18',4),(8,20,7,'2019-09-18',4),(9,20,7,'2019-09-18',4),(10,20,7,'2019-09-18',4),(11,20,7,'2019-09-18',4),(12,27,7,'2019-09-18',4),(13,20,7,'2019-09-18',4),(14,20,7,'2019-09-18',4),(15,20,7,'2019-09-18',4),(16,21,7,'2019-09-18',4),(17,21,7,'2019-09-18',4),(18,21,7,'2019-09-18',4),(19,21,7,'2019-09-18',4),(20,22,7,'2019-09-18',4),(21,21,7,'2019-09-18',4),(22,21,7,'2019-09-18',4),(23,23,7,'2019-09-18',4),(24,21,7,'2019-09-18',4),(25,21,7,'2019-09-18',4),(26,21,7,'2019-09-18',4),(27,22,7,'2019-09-18',4),(28,23,7,'2019-09-18',4),(29,23,7,'2019-09-18',4),(30,23,7,'2019-09-18',4),(31,24,7,'2019-09-18',4),(32,23,7,'2019-09-18',4),(33,23,7,'2019-09-18',4),(34,24,7,'2019-09-18',4),(35,25,7,'2019-09-18',4),(36,26,7,'2019-09-18',4),(37,27,9,'2019-09-18',4),(38,29,9,'2019-09-18',4),(39,20,7,'2019-09-18',4),(40,27,7,'2019-09-18',4),(41,21,7,'2019-09-18',4),(42,23,7,'2019-09-18',4),(43,21,7,'2019-09-18',4),(44,21,7,'2019-09-18',4),(45,21,7,'2019-09-18',4),(46,22,7,'2019-09-18',4),(47,23,7,'2019-09-18',4),(48,23,7,'2019-09-18',4),(49,23,7,'2019-09-18',4),(50,24,7,'2019-09-18',4),(51,23,7,'2019-09-18',4),(52,23,7,'2019-09-18',4),(53,24,7,'2019-09-18',4),(54,25,7,'2019-09-18',4),(55,26,7,'2019-09-18',4),(56,27,9,'2019-09-18',4),(57,29,9,'2019-09-18',4),(58,20,7,'2019-09-18',4),(59,21,7,'2019-09-18',4),(60,22,7,'2019-09-18',4),(61,21,7,'2019-09-18',4),(62,21,7,'2019-09-18',4),(63,21,7,'2019-09-18',4),(64,21,7,'2019-09-18',4),(65,20,7,'2019-09-18',4),(66,20,7,'2019-09-18',4),(67,20,7,'2019-09-18',4),(68,22,7,'2019-09-18',4),(69,21,7,'2019-09-18',4),(70,21,7,'2019-09-18',4),(71,23,7,'2019-09-18',4),(72,21,7,'2019-09-18',4),(73,21,7,'2019-09-18',4),(74,21,7,'2019-09-18',4),(75,22,7,'2019-09-18',4),(76,23,7,'2019-09-18',4),(77,23,7,'2019-09-18',4),(78,23,7,'2019-09-18',4),(79,24,7,'2019-09-18',4),(80,23,7,'2019-09-18',4),(81,23,7,'2019-09-18',4),(82,24,7,'2019-09-18',4),(83,25,7,'2019-09-18',4),(84,26,7,'2019-09-18',4),(85,27,9,'2019-09-18',4),(86,29,9,'2019-09-18',4),(87,20,7,'2019-09-18',4),(88,17,7,'2019-09-18',4),(89,21,7,'2019-09-18',4),(90,21,7,'2019-09-18',4),(91,21,7,'2019-09-18',4),(92,21,7,'2019-09-18',4),(93,20,7,'2019-09-18',4),(94,20,7,'2019-09-18',4),(95,20,7,'2019-09-18',4),(96,27,7,'2019-09-18',4),(97,20,7,'2019-09-18',4),(98,20,7,'2019-09-18',4),(99,27,7,'2019-09-18',4),(100,23,7,'2019-09-18',4),(101,21,7,'2019-09-18',4),(102,21,7,'2019-09-18',4),(103,23,7,'2019-09-18',4),(104,23,7,'2019-09-18',4),(105,23,7,'2019-09-18',4),(106,23,7,'2019-09-18',4),(107,24,7,'2019-09-18',4),(108,24,7,'2019-09-18',4),(109,20,7,'2019-09-18',4),(110,21,7,'2019-09-18',4),(111,27,9,'2019-09-18',4),(112,26,7,'2019-09-18',4),(113,25,7,'2019-09-18',4),(114,20,7,'2019-09-18',4),(115,20,7,'2019-09-18',4),(116,21,7,'2019-09-18',4),(117,21,7,'2019-09-18',4),(118,21,7,'2019-09-18',4),(119,21,7,'2019-09-18',4),(120,21,7,'2019-09-18',4),(121,21,7,'2019-09-18',4),(122,21,7,'2019-09-18',4),(123,21,7,'2019-09-18',4),(124,22,7,'2019-09-18',4),(125,23,7,'2019-09-18',4),(126,23,7,'2019-09-18',4),(127,23,7,'2019-09-18',4),(128,23,7,'2019-09-18',4),(129,24,7,'2019-09-18',4),(130,20,7,'2019-09-18',4),(131,17,7,'2019-09-18',4);
/*!40000 ALTER TABLE `returnbook` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-18 18:16:47
