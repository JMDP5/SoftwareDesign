CREATE DATABASE  IF NOT EXISTS `baza_prosoft` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `baza_prosoft`;
-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: baza_prosoft
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.12.04.1

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
-- Table structure for table `zadatak`
--

DROP TABLE IF EXISTS `zadatak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zadatak` (
  `zadatakid` int(11) NOT NULL AUTO_INCREMENT,
  `nazivzadatka` varchar(300) NOT NULL,
  `rokzaizvrsenje` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `opis` text NOT NULL,
  PRIMARY KEY (`zadatakid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zadatak`
--

LOCK TABLES `zadatak` WRITE;
/*!40000 ALTER TABLE `zadatak` DISABLE KEYS */;
INSERT INTO `zadatak` VALUES (2,'Zadatak 2','2018-08-08','u toku','Binarizuj sve slike.'),(3,'Zadatak 3','2014-06-06','u toku','Detektuj ivice.'),(14,'Zadatak 14','2014-07-10','zavrsen -na vreme','');
/*!40000 ALTER TABLE `zadatak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesto`
--

DROP TABLE IF EXISTS `mesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesto` (
  `pttbroj` int(11) NOT NULL,
  `nazivmesta` varchar(100) NOT NULL,
  PRIMARY KEY (`pttbroj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesto`
--

LOCK TABLES `mesto` WRITE;
/*!40000 ALTER TABLE `mesto` DISABLE KEYS */;
INSERT INTO `mesto` VALUES (1,'Beograd'),(123,'ns'),(12000,'Zemun');
/*!40000 ALTER TABLE `mesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaduzenje`
--

DROP TABLE IF EXISTS `zaduzenje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zaduzenje` (
  `radnikid` int(11) NOT NULL,
  `zadatakid` int(11) NOT NULL,
  `datumdodele` date DEFAULT NULL,
  `napomena` text,
  PRIMARY KEY (`radnikid`,`zadatakid`),
  KEY `zadatak_id_idx` (`zadatakid`),
  CONSTRAINT `radnik` FOREIGN KEY (`radnikid`) REFERENCES `radnik` (`radnikid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `zadatak` FOREIGN KEY (`zadatakid`) REFERENCES `zadatak` (`zadatakid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaduzenje`
--

LOCK TABLES `zaduzenje` WRITE;
/*!40000 ALTER TABLE `zaduzenje` DISABLE KEYS */;
INSERT INTO `zaduzenje` VALUES (2,2,'2014-07-03',''),(2,3,'2014-07-07',NULL);
/*!40000 ALTER TABLE `zaduzenje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evidencija`
--

DROP TABLE IF EXISTS `evidencija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evidencija` (
  `evidencijaid` int(11) NOT NULL AUTO_INCREMENT,
  `datumkreiranja` date DEFAULT NULL,
  `komentar` text,
  `ocena` int(11) DEFAULT NULL,
  `zadatakid` int(11) DEFAULT NULL,
  `menadzerid` int(11) DEFAULT NULL,
  PRIMARY KEY (`evidencijaid`),
  KEY `zadatak_e_idx` (`zadatakid`),
  KEY `menadzer_e_idx` (`menadzerid`),
  CONSTRAINT `menadzer_e` FOREIGN KEY (`menadzerid`) REFERENCES `menadzer` (`menadzerid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `zadatak_e` FOREIGN KEY (`zadatakid`) REFERENCES `zadatak` (`zadatakid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evidencija`
--

LOCK TABLES `evidencija` WRITE;
/*!40000 ALTER TABLE `evidencija` DISABLE KEYS */;
/*!40000 ALTER TABLE `evidencija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radnik`
--

DROP TABLE IF EXISTS `radnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `radnik` (
  `radnikid` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) DEFAULT NULL,
  `prezime` varchar(100) DEFAULT NULL,
  `korisnickoime` varchar(45) NOT NULL,
  `lozinka` varchar(45) NOT NULL,
  `pttbroj` int(11) DEFAULT NULL,
  PRIMARY KEY (`radnikid`),
  KEY `ptt_broj_idx` (`pttbroj`),
  CONSTRAINT `ptt_broj` FOREIGN KEY (`pttbroj`) REFERENCES `mesto` (`pttbroj`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radnik`
--

LOCK TABLES `radnik` WRITE;
/*!40000 ALTER TABLE `radnik` DISABLE KEYS */;
INSERT INTO `radnik` VALUES (2,'Aleksandar','B','a','b',1),(3,'Ivana','J','ika','ika',12000);
/*!40000 ALTER TABLE `radnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menadzer`
--

DROP TABLE IF EXISTS `menadzer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menadzer` (
  `menadzerid` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) DEFAULT NULL,
  `prezime` varchar(100) DEFAULT NULL,
  `obrazovanje` varchar(300) DEFAULT NULL,
  `brojpodredjenih` int(11) DEFAULT NULL,
  `korisnickoime` varchar(45) NOT NULL,
  `lozinka` varchar(45) NOT NULL,
  PRIMARY KEY (`menadzerid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menadzer`
--

LOCK TABLES `menadzer` WRITE;
/*!40000 ALTER TABLE `menadzer` DISABLE KEYS */;
INSERT INTO `menadzer` VALUES (1,'Stevan','S','FON',10,'stevan','stevan');
/*!40000 ALTER TABLE `menadzer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slika`
--

DROP TABLE IF EXISTS `slika`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slika` (
  `zadatakid` int(11) NOT NULL,
  `slikaid` int(11) NOT NULL,
  `naziv` varchar(200) DEFAULT NULL,
  `slikafajl` varchar(300) DEFAULT NULL,
  `opis` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`zadatakid`,`slikaid`),
  KEY `zadatak_id_idx` (`zadatakid`),
  CONSTRAINT `zadatak_id` FOREIGN KEY (`zadatakid`) REFERENCES `zadatak` (`zadatakid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slika`
--

LOCK TABLES `slika` WRITE;
/*!40000 ALTER TABLE `slika` DISABLE KEYS */;
INSERT INTO `slika` VALUES (2,1,'lenna.jpg','/home/aleksandar/Documents/Images/lenna.jpg','Samo binarizuj.'),(3,1,'flower2.jpg','/home/aleksandar/Documents/Images/flower2.jpg','Grayscale, pa detekcija.'),(3,2,'lotus_flower.jpg','/home/aleksandar/Documents/Images/lotus_flower.jpg','Samo detekcija.');
/*!40000 ALTER TABLE `slika` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-09  9:13:29
