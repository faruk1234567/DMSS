-- MariaDB dump 10.19  Distrib 10.5.12-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: report
-- ------------------------------------------------------
-- Server version	10.5.12-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `report_users`
--

DROP TABLE IF EXISTS `report_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `municipality_id` int(11) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKrtnj2wn4tr2p2nk0uts7lhoe5` (`username`),
  UNIQUE KEY `UKnb5fvod44pjjd1ic25agq2i0g` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_users`
--

LOCK TABLES `report_users` WRITE;
/*!40000 ALTER TABLE `report_users` DISABLE KEYS */;
INSERT INTO `report_users` VALUES (1,'Admin','admin@infinity.com',NULL,'$2a$10$bBMgh1WoVdzeyf6P3q/HButTskE6nkvzHWLZeOgQcTNS5H3jAavfS','admin'),(2,'HTB Report User','htb-report@infinity.com',6,'$2a$10$qcJmSTwN/FIQd5hFdmS1jOViiBLnlZTTEdf4BSIsu.ujKVOpKkiCy','htb-report'),(3,'WB Report User','water-report@infinity.com',6,'$2a$10$eQ8FQr1IUl1J222aIfSLWefHTwmc4C3iaLumqzOYas4RzG83/ALIC','water-report');
/*!40000 ALTER TABLE `report_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-09  9:57:52
