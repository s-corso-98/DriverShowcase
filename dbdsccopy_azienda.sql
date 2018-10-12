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
-- Table structure for table `azienda`
--

DROP TABLE IF EXISTS `azienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `azienda` (
  `PIVA` varchar(20) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `CittÃ ` varchar(60) NOT NULL,
  `Via` varchar(60) NOT NULL,
  `Recapito` varchar(25) NOT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Provincia` varchar(45) NOT NULL,
  PRIMARY KEY (`PIVA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES ('02590540650','Galdieri auto','Fisciano','Strada Statale 88 (Km 10+400)','089827211','callcenter@galdieriauto.it','GaldieriTry1','SA'),('14124213184','RomaMotorsport','Roma','Appia 11','06501341','RomaMotori@live.it','RomaMotorsport','RM'),('23841392957','AutoMotoSRL','Torino','Gelsi 21','092842213','AutoMotoSRL@live.it','AutoMoto','TO'),('32490\'243112','BuyDrive','Catania','Piazza Ministero 93','043124912','Drive@live.it','DriveCar','CT'),('43114821443','TuttoAuto','Milano','Marte 42','041234821','TuttoAuto@gmail.com','TuttoAuto','MI'),('43128943181','AutoveicoliTrento','Trento','Ville 30','098413124','TrentoMotori@live.it','TrentoMotori','TN'),('43209142392','MotorSport','Cagliari','Casata 21','013942103','MotorSport@live.it','SportMotors','CA'),('4812934142','BikeNcar','Bari','Marittima 12','0523143123','BikeNcar@live.it','RentNCar','BA'),('7412397129','AutoRent','Roma','Latina 12','0650212343','RentCar@gmail.com','RentCar','RM'),('9124814921','RentAll','Messina','Appia 30','0321484234','AppiaMotor@live.it','Motor','ME');
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;
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
