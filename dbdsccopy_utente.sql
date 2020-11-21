-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dbdsccopy
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `CodiceFiscale` varchar(16) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `Via` varchar(60) NOT NULL,
  `Recapito` varchar(25) NOT NULL,
  `Email` varchar(60) NOT NULL,
  `Admin` tinyint(4) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `DataDiNascita` date NOT NULL,
  `Documento` varchar(45) NOT NULL,
  `NumDocumento` varchar(45) NOT NULL,
  `CittÃ ` varchar(60) NOT NULL,
  `Provincia` varchar(45) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('CNSMRA78R20C351W','Mario','Console','Delle Banche 12','3398212473','MConsole@hotmail.it',0,'Mconsole','1978-10-20','Passaporto','PassMConsole29312','Catania','Catania'),('DCRNTN71R12E472K','Antonio','De Carlo','Del Mare 129','3298231421','DeCarloAntonio@live.it',0,'Decarlo','1971-10-12','Patente','PaDcAn18429','Latina','Latina'),('DCRRRT80A01H501X','Roberto','De Caro','Feudi 19','3284923123','RobertoDecaro@tiscali.it',0,'RobDeCaro','1980-01-01','Patente','RDC123932','Roma','Roma'),('DFLLBA82C45A662S','Alba','De Falco','Miramare 21','3289239421','Alba.DF@live.it',0,'AlbaDF','1982-03-05','Patente','PaADF212','Bari','Bari'),('DVVMNL83D42L219B','Manuela','De Vivo','Marmi 92','3204923412','Manuela.DeVivo@gmail.com',0,'Manuela','1989-01-30','Patente','PaDV23021','Torino','Torino'),('FAKEDATA1','Silvio','Corso','FAKEADRESS','0000000000','ragusa12@hotmail.it',1,'daje1','2010-11-19','Carta d\'identita','FAKEDATA1','Salerno','SA'),('FAKEDATA2','Angelo','Fortunato','FAKEADRESS1','0000000000','AngeloFortunato@live.it',1,'AngeloFortunato','2010-11-19','Patente','FAKEDATA2','Salerno','Salerno'),('FAKEDATA3','Matteo','Pastore','FAKEADRESS2','0000000000','matteopastore1998@gmail.com',1,'password','2010-11-19','Carta D\'Identita ','FAKEDATA3','Salerno','Sa'),('VGRRRT75P55F205E','Roberta','Vigore','Wenner 12','3219429213','RobVigore75@hotmail.it',0,'VigoRoberta','1975-09-15','Passaporto','RP3294','Milano','Milano');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-12 15:42:12
