-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
-- ------------------------------------------------------
-- Server version	5.6.11

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
-- Table structure for table `resultados`
--

DROP TABLE IF EXISTS `resultados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resultados` (
  `idresultados` int(11) NOT NULL AUTO_INCREMENT,
  `nif` varchar(9) NOT NULL,
  `idruta` int(4) NOT NULL,
  `hores` int(4) NOT NULL,
  `minuts` int(2) NOT NULL,
  `velmedia` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idresultados`),
  KEY `nif_idx` (`nif`),
  KEY `idruta_idx` (`idruta`),
  CONSTRAINT `idruta` FOREIGN KEY (`idruta`) REFERENCES `ruta` (`idruta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nif` FOREIGN KEY (`nif`) REFERENCES `user` (`nif`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultados`
--

LOCK TABLES `resultados` WRITE;
/*!40000 ALTER TABLE `resultados` DISABLE KEYS */;
INSERT INTO `resultados` VALUES (14,'12345678S',1234,8,0,21.88),(23,'45678900E',1241,3,14,26.29),(27,'12547896S',1241,3,45,22.67),(35,'45678900E',1241,8,15,10.30),(36,'14521452A',1479,3,45,34.67),(37,'12547896S',1241,4,25,19.25),(43,'45678900E',1241,7,45,10.97),(46,'12345678S',1241,3,32,24.06),(53,'14521452A',4440,3,32,12.74),(56,'12547896S',1241,4,20,19.62),(57,'12345678S',1479,3,30,37.14),(59,'45678900E',1241,4,25,19.25),(60,'17456874S',8888,4,30,26.67),(63,'12345678S',1241,4,15,20.00),(64,'12547896S',8888,5,25,22.15),(65,'45678900E',4440,2,5,21.60),(68,'45678900E',4444,3,52,24.57),(69,'14521452A',1241,2,22,35.92),(70,'12345671Q',1241,7,25,11.46),(73,'14521452A',4444,3,32,26.89),(74,'12345671Q',1479,3,25,38.05),(75,'12345671Q',1479,8,10,15.92),(76,'12345671Q',6660,1,0,10000.00);
/*!40000 ALTER TABLE `resultados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta` (
  `idruta` int(4) NOT NULL,
  `nomruta` varchar(30) NOT NULL,
  `distancia` decimal(10,2) NOT NULL,
  `desnivell` int(11) NOT NULL,
  `dificultat` int(11) NOT NULL,
  PRIMARY KEY (`idruta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta`
--

LOCK TABLES `ruta` WRITE;
/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
INSERT INTO `ruta` VALUES (1234,'Remences Llarga',175.00,3200,8),(1241,'Treparriscos',85.00,1200,6),(1479,'Canibal',130.00,1900,6),(4440,'pineda-barcelona',45.00,0,5),(4444,'Remences  Curta',95.00,1200,6),(4449,'hola',500.00,10,10),(4781,'Quebrantahuesos',200.00,3200,9),(6660,'pol',10000.00,10000,9),(8888,'Pineda-Santa Fe-Pineda',120.00,1800,7);
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `nif` varchar(9) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `cognoms` varchar(45) NOT NULL,
  `pes` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  PRIMARY KEY (`nif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('12345671Q','Pol','Cordova',75,38),('12345678S','Dama','Divara',80,34),('12547896S','David','Vicente Barcelo',85,30),('14521452A','Pepe','Perez Garcia',85,39),('17456874S','Juan','Tavera',70,29),('45678900E','Sandro','Gamarra Gamarra',77,33);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-23 12:47:42
