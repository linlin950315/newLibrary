-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `counts` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `createUser` varchar(100) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `create_user` bigint DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `update_user` bigint DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26381 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (101,'Java',NULL,33,'gtrgr',2,NULL,333.00,NULL,66,NULL,NULL,NULL,NULL),(102,'Spring Boot',NULL,666,'gdh',2,NULL,333.00,NULL,77,NULL,NULL,NULL,NULL),(103,'MyBatis',NULL,55,'gfndshgn',2,NULL,333.00,NULL,88,NULL,NULL,NULL,NULL),(26367,'insyytt',NULL,7788,'yyy7788',1,NULL,7788.00,NULL,7788,NULL,NULL,NULL,NULL),(26370,'hhhh',NULL,6,'dhgh',1,NULL,666.00,NULL,666,NULL,NULL,NULL,NULL),(26372,'Java2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26373,'Spring Boot2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26374,'MyBatis2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26375,'Java3',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26376,'Spring Boot3',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26377,'MyBatis3',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26378,'Java4',NULL,2,'hhhh',1,NULL,66.00,NULL,3,NULL,NULL,NULL,NULL),(26379,'Spring Boot4',NULL,2,'hhhh',1,NULL,66.00,NULL,3,NULL,NULL,NULL,NULL),(26380,'MyBatis4',NULL,2,'hhhh',1,NULL,66.00,NULL,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_seq`
--

DROP TABLE IF EXISTS `book_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_seq`
--

LOCK TABLES `book_seq` WRITE;
/*!40000 ALTER TABLE `book_seq` DISABLE KEYS */;
INSERT INTO `book_seq` VALUES (1);
/*!40000 ALTER TABLE `book_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_name` varchar(255) NOT NULL,
  `category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`category_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_seq`
--

DROP TABLE IF EXISTS `category_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_seq`
--

LOCK TABLES `category_seq` WRITE;
/*!40000 ALTER TABLE `category_seq` DISABLE KEYS */;
INSERT INTO `category_seq` VALUES (1);
/*!40000 ALTER TABLE `category_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lend`
--

DROP TABLE IF EXISTS `lend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lend` (
  `bookId` int DEFAULT NULL,
  `date_lend` datetime DEFAULT NULL,
  `date_return` datetime DEFAULT NULL,
  `studentId` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lend_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`lend_id`),
  KEY `book_id` (`bookId`),
  KEY `student_id` (`studentId`),
  CONSTRAINT `lend_ibfk_2` FOREIGN KEY (`studentId`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lend`
--

LOCK TABLES `lend` WRITE;
/*!40000 ALTER TABLE `lend` DISABLE KEYS */;
INSERT INTO `lend` VALUES (2,NULL,NULL,'1',8),(11,NULL,NULL,'1',26),(4,NULL,NULL,'1',27),(1,NULL,NULL,'1',28);
/*!40000 ALTER TABLE `lend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `rent_date` varchar(100) DEFAULT NULL,
  `return_date` varchar(100) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('1','s1',NULL,NULL,NULL,NULL,NULL),('2','S2',NULL,NULL,NULL,NULL,NULL),('3','S3',NULL,NULL,NULL,NULL,NULL),('4','S4',NULL,NULL,NULL,NULL,NULL),('5','S5',NULL,NULL,NULL,NULL,NULL),('6','S6',NULL,NULL,NULL,NULL,NULL),('7','S7',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'library'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-21 18:27:53
