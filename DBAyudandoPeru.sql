CREATE DATABASE  IF NOT EXISTS `dbayudandoperu2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbayudandoperu2`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: dbayudandoperu2
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `donation`
--

DROP TABLE IF EXISTS `donation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donation` (
  `id_donation` int(11) NOT NULL AUTO_INCREMENT,
  `id_gatheringcenter_donation` int(11) NOT NULL,
  `id_person_donation` int(11) NOT NULL,
  `id_donationtype_donation` int(11) NOT NULL,
  `description_donation` varchar(45) DEFAULT NULL,
  `quantity_donation` float DEFAULT NULL,
  `creation_date_donation` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_state_donation` int(11) DEFAULT '1',
  PRIMARY KEY (`id_donation`),
  KEY `fk_idGatheringcenter_donation_idx` (`id_gatheringcenter_donation`),
  KEY `fk_idPerson_donation_idx` (`id_person_donation`),
  KEY `fk_idDonationtype_donation_idx` (`id_donationtype_donation`),
  KEY `fk_idState_person_idx` (`id_state_donation`),
  CONSTRAINT `fk_idDonationtype_donation` FOREIGN KEY (`id_donationtype_donation`) REFERENCES `donationtype` (`id_donationtype`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idGatheringcenter_donation` FOREIGN KEY (`id_gatheringcenter_donation`) REFERENCES `gatheringcenter` (`id_gatheringcenter`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idPerson_donation` FOREIGN KEY (`id_person_donation`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idState_donation` FOREIGN KEY (`id_state_donation`) REFERENCES `state` (`id_state`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donation`
--

LOCK TABLES `donation` WRITE;
/*!40000 ALTER TABLE `donation` DISABLE KEYS */;
INSERT INTO `donation` VALUES (1,1,10,1,'latas de atun',2,'2017-06-26 20:09:14',1),(2,1,17,2,'polos para niños',3,'2017-06-26 20:10:12',1),(3,1,3,2,'pantalon para niño',1,'2017-06-26 20:13:06',1),(4,1,22,1,'polo para adulto',1,'2017-06-26 20:13:24',1),(5,2,10,1,'latas de atun',3,'2017-06-26 20:14:04',1),(6,2,22,3,'juguetes de colores',5,'2017-06-26 20:14:41',1),(7,8,20,1,'comida no perecible en kilogramos',0.5,'2017-06-26 20:16:13',1),(8,9,22,4,'viveres distintos',3,'2017-06-26 20:17:22',1),(9,10,3,2,'abrigos distintos',4,'2017-06-26 20:31:23',1),(10,11,6,2,'abrigos distintos',2,'2017-06-26 20:31:23',1),(11,12,3,3,'juguetes distintos',2,'2017-06-26 20:31:23',1),(12,13,22,1,'lata de atun',1,'2017-06-26 20:31:23',1);
/*!40000 ALTER TABLE `donation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donationtype`
--

DROP TABLE IF EXISTS `donationtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donationtype` (
  `id_donationtype` int(11) NOT NULL AUTO_INCREMENT,
  `name_donationtype` varchar(45) NOT NULL,
  PRIMARY KEY (`id_donationtype`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donationtype`
--

LOCK TABLES `donationtype` WRITE;
/*!40000 ALTER TABLE `donationtype` DISABLE KEYS */;
INSERT INTO `donationtype` VALUES (1,'Comida'),(2,'Ropa'),(3,'Juguetes'),(4,'Otros');
/*!40000 ALTER TABLE `donationtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `id_person_event` int(11) NOT NULL,
  `name_event` varchar(45) NOT NULL,
  `description_event` varchar(150) NOT NULL,
  `creation_date_event` datetime DEFAULT CURRENT_TIMESTAMP,
  `starting_date_event` datetime NOT NULL,
  `ending_date_event` datetime NOT NULL,
  `id_state_event` int(11) DEFAULT '1',
  PRIMARY KEY (`id_event`),
  KEY `fk_idPerson_event_idx` (`id_person_event`),
  KEY `fk_idState_event_idx` (`id_state_event`),
  CONSTRAINT `fk_idPerson_event` FOREIGN KEY (`id_person_event`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idState_event` FOREIGN KEY (`id_state_event`) REFERENCES `state` (`id_state`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,3,'Juntos Piura','Evento para ayudar a los daminficados de Piura','2017-06-26 11:32:47','2017-08-02 12:00:00','2017-08-07 12:00:00',1),(2,3,'Juntos Arequipa','Evento de recoleccion para ayudar a los damnificados en Arequipa','2017-06-26 11:32:47','2017-11-21 12:00:00','2017-11-28 12:00:00',1),(3,12,'Una sola fuerza','Evento para ayudar a todos los damnificados en el peru por los huaicos','2017-06-26 11:50:18','2017-07-21 12:00:00','2017-07-26 12:00:00',1),(4,11,'Solidaridad','Evento para la ayudar a los damnificados en el peru','2017-06-26 11:50:18','2017-07-01 12:00:00','2017-07-12 12:00:00',1),(5,13,'Peru en emergencia','Evento para poder ayudar a las personas con problemas generados por los desastres naturales ','2017-06-26 11:59:30','2017-12-18 12:00:00','2017-12-23 12:00:00',1),(6,14,'Cooperando ante los huaicos ','Evento de recoleccion','2017-06-26 11:59:30','2017-12-01 12:00:00','2017-12-11 12:00:00',1),(7,15,'Por los damnificados por los huaicos','Evento de recoleccion para los que deseen donar','2017-06-26 11:59:30','2017-12-22 12:00:00','2017-12-24 12:00:00',1),(8,3,'Franco','HAHAAHAHAAHH XDXD','2017-06-28 00:00:00','2017-03-01 00:00:00','2017-04-04 00:00:00',1),(9,3,'Franco','Yolosweg','2017-06-28 00:00:00','2017-03-05 00:00:00','2017-04-01 00:00:00',0),(10,3,'Nuevo Evento','Yolo sweg','2017-06-28 00:00:00','2017-05-30 00:00:00','2017-06-07 00:00:00',NULL);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gatheringcenter`
--

DROP TABLE IF EXISTS `gatheringcenter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gatheringcenter` (
  `id_gatheringcenter` int(11) NOT NULL AUTO_INCREMENT,
  `id_person_gatheringcenter` int(11) NOT NULL,
  `id_event_gatheringcenter` int(11) NOT NULL,
  `name_gatheringcenter` varchar(45) NOT NULL,
  `lattitude_gatherincenter` double NOT NULL,
  `longitude_gatherincenter` double NOT NULL,
  `description_gatheringcenter` varchar(150) NOT NULL,
  `img_gatheringcenter` varchar(45) DEFAULT NULL,
  `id_state_gatheringcenter` int(11) DEFAULT '1',
  PRIMARY KEY (`id_gatheringcenter`),
  KEY `fk_idPerson_gatheringcenter_idx` (`id_person_gatheringcenter`),
  KEY `fk_idEvent_gatheringcenter_idx` (`id_event_gatheringcenter`),
  KEY `fk_idState_gatherincenter_idx` (`id_state_gatheringcenter`),
  CONSTRAINT `fk_idEvent_gatheringcenter` FOREIGN KEY (`id_event_gatheringcenter`) REFERENCES `event` (`id_event`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idPerson_gatheringcenter` FOREIGN KEY (`id_person_gatheringcenter`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gatheringcenter`
--

LOCK TABLES `gatheringcenter` WRITE;
/*!40000 ALTER TABLE `gatheringcenter` DISABLE KEYS */;
INSERT INTO `gatheringcenter` VALUES (1,2,1,'Metro de Pershing',-12.08913599,-77.05778763,'Hipermercado Metro ubicado en la Av. Pershing',NULL,1),(2,8,1,'Parque de las Leyendas',-12.07201429,-77.08692312,'Parque de las Leyendas ubicado cerca de la Av. Precursores',NULL,1),(3,8,1,'AELU Club',-12.0733677,-77.07713842,'Club AELU junto al colegio La Union',NULL,1),(4,16,2,'IEP Santo Domingo El Apostol',-12.08107886,-77.10378885,'Colegio Santo Domingo',NULL,1),(5,16,3,'Colegio Leoncio Prado',-12.07553944,-77.11842299,'Colegio Leoncio Prado cerca a ',NULL,1),(6,9,3,'Colegio San Antonio Marianistas',-12.06017954,-77.12442577,'Colegio San Antonio Marianistas cerca de la guardia chalaca',NULL,1),(7,17,1,'UNI',-12.02403204,-77.04813838,'Universidad Nacional de Ingenieria',NULL,1),(8,20,4,'UPC Monterrico',-12.10402741,-76.96289241,'Sede de Monterrico de la UPC',NULL,1),(9,20,4,'UPC Villa',-12.19802506,-77.00729102,'Sede ubicada en Villa de la UPC',NULL,1),(10,20,4,'UPC San Isidro',-12.08762297,-77.05010154,'Sede ubicada en San Isidro de la UPC',NULL,1),(11,18,4,'UPC San Miguel',-12.0768218,-77.0936082,'Sede ubicada en San Miguel de la UPC',NULL,1),(12,23,5,'ULima',-12.084761,-76.970816,'Local de la Universidad de Lima ubicada en Javier Prado Este',NULL,1),(13,14,6,'Local del INSN',-12.0652904,-77.0458374,'Local del Instituto nacional de salud del Niño',NULL,1),(14,15,7,'UNMSM',-12.05589875,-77.08439112,'Local de la UNMSM en la Av. Universitaria',NULL,1),(20,3,1,'Franco',-12.085149420518668,-77.05587387084961,'12312313',NULL,1),(21,3,1,'Yolo',-12.062991387963827,-77.03596115112305,'sawag',NULL,1);
/*!40000 ALTER TABLE `gatheringcenter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id_person` int(11) NOT NULL AUTO_INCREMENT,
  `name_person` varchar(45) NOT NULL,
  `last_name_person` varchar(45) DEFAULT NULL,
  `identity_number_person` varchar(45) NOT NULL,
  `password_person` varchar(100) NOT NULL,
  `card_number_person` varchar(20) DEFAULT NULL,
  `img_person` varchar(45) DEFAULT NULL,
  `cellphone_person` varchar(20) DEFAULT NULL,
  `address_person` varchar(40) NOT NULL,
  `email_person` varchar(45) NOT NULL,
  `creation_date_person` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_state_person` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_person`),
  KEY `fk_idState_person_idx` (`id_state_person`),
  CONSTRAINT `fk_idState_person` FOREIGN KEY (`id_state_person`) REFERENCES `state` (`id_state`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Henry','Mendoza','Henry','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-701','henrymendoza@gmail.com','2017-06-25 17:55:53',1),(2,'Marco','Bruggman','Marco','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-702','marcobruggman@gmail.com','2017-06-25 17:55:53',1),(3,'Franco','Rivera','Franco','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-703','francorivera@gmail.com','2017-06-25 17:55:53',1),(4,'Jesus','Cueto','Jesus','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-704','jesuscueto@gmail.com','2017-06-25 17:55:53',1),(5,'Gonzalo','Cirilo','Gonzalo','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-705','gonzalocirilo@gmail.com','2017-06-25 17:55:53',1),(6,'Christian','Lertora','Christian','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-706','christianlertora@gmail.com','2017-06-25 17:55:53',1),(7,'Paul','Alvarez','Paul','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-707','paulalvarez@gmail.com','2017-06-25 17:55:53',1),(8,'William','Bravo','William','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-708','williambravo@gmail.com','2017-06-25 17:55:53',1),(9,'Jose','Escajadillo','JoseEscajadillo','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-709','joseescajadillo@gmail.com','2017-06-25 17:55:53',1),(10,'Jose','Nagayoshi','JoseNagayoshi','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-710','josenagayoshi@gmail.com','2017-06-25 17:55:53',1),(11,'UPC',NULL,'UPC','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'Monterrico','upc@upc.edu.pe','2017-06-26 03:18:02',1),(12,'Ministerio de Defensa',NULL,'Ministerio','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'Av. La Peruanidad','mindef@gob.pe','2017-06-26 03:18:02',1),(13,'Universidad de Lima',NULL,'ULima','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'Javier Prado Este','ulima@ulima.edu.pe','2017-06-26 03:18:02',1),(14,'Instituto Nacional de Salud del Niño',NULL,'INSN','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'Av. Brasil N°600','insn@gmail.com','2017-06-26 03:18:02',1),(15,'UNMSM',NULL,'UNMSM','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'Av. Universitaria','unmsm@unmsm.edu.pe','2017-06-26 03:18:02',1),(16,'Luis','Muñoz','Muñoz','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'B-303','luismuñoz@gmail.com','2017-06-26 03:18:02',1),(17,'Wilmer','Namay','Namay','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'B-402','wilmernamay@gmail.com','2017-06-26 03:18:02',1),(18,'Gonzalo','Mori','Mori','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-702','gonzalomori@gmail.com','2017-06-26 03:18:02',1),(19,'Jesus','Caldas','Caldas','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-702','jesuscaldas@gmail.com','2017-06-26 03:18:02',1),(20,'Daniel','Burga','Burga','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'B-404','danielburga@gmail.com','2017-06-26 03:18:02',1),(21,'Jorge','Delgado','Jorgedelgado','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'A-702','jorgedelgado@gmail.com','2017-06-26 03:18:02',1),(22,'Oscar','Castañeda','Oscarcastañeda','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'B-202','oscarcastañeda@gmail.com','2017-06-26 03:18:02',1),(23,'Oscar','Quezada','Oscarquezada','$2a$10$WEhE8Pc4YJzxtZPImu6fx.BPAettx6Pprsc//aKcKQ8MexPPgVEce',NULL,NULL,NULL,'Javier Prado Este','oscarquezada@ulima.edu.pe','2017-06-26 19:45:42',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personrole`
--

DROP TABLE IF EXISTS `personrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personrole` (
  `id_person_role` int(11) NOT NULL AUTO_INCREMENT,
  `id_role` int(11) NOT NULL,
  `id_person` int(11) NOT NULL,
  PRIMARY KEY (`id_person_role`),
  KEY `fk_role_personrole_idx` (`id_role`),
  KEY `fk_person_personrole_idx` (`id_person`),
  CONSTRAINT `fk_person_personrole` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_personrole` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personrole`
--

LOCK TABLES `personrole` WRITE;
/*!40000 ALTER TABLE `personrole` DISABLE KEYS */;
INSERT INTO `personrole` VALUES (1,1,3),(2,1,4),(3,1,5),(4,1,6),(5,1,7),(6,2,1),(7,2,2),(8,2,8),(9,2,9),(10,2,10),(11,2,16),(12,2,17),(13,2,18),(14,2,19),(15,2,20),(16,2,21),(17,2,22),(18,3,11),(19,3,12),(20,3,13),(21,3,14),(22,3,15);
/*!40000 ALTER TABLE `personrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `name_role` varchar(45) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMINISTRADOR'),(2,'ROLE_GENERAL'),(3,'ROLE_ENTIDAD');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id_state` int(11) NOT NULL AUTO_INCREMENT,
  `name_state` varchar(45) NOT NULL,
  PRIMARY KEY (`id_state`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (0,'INA'),(1,'ACT');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dbayudandoperu2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-28 13:44:23
