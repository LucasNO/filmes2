CREATE DATABASE  IF NOT EXISTS `locadora` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `locadora`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fatec_filmes
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao` (
  `idavaliacao` int(11) NOT NULL AUTO_INCREMENT,
  `nota` float NOT NULL,
  `idfilme` int(11) NOT NULL,
  PRIMARY KEY (`idavaliacao`),
  KEY `fk_avaliacao_1_idx` (`idfilme`),
  CONSTRAINT `fk_avaliacao_1` FOREIGN KEY (`idfilme`) REFERENCES `filmes` (`idfilme`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (1,5,3);
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classificacao`
--

DROP TABLE IF EXISTS `classificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classificacao` (
  `idclassificacao` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idclassificacao`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificacao`
--

LOCK TABLES `classificacao` WRITE;
/*!40000 ALTER TABLE `classificacao` DISABLE KEYS */;
INSERT INTO `classificacao` VALUES (1,'Aventura'),(2,'Ação'),(3,'Teste'),(4,'123'),(5,'dlnsclndc'),(6,'12345678'),(7,'nhgfdertyjioiuytrf'),(8,'Romance');
/*!40000 ALTER TABLE `classificacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filmes`
--

DROP TABLE IF EXISTS `filmes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filmes` (
  `idfilme` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `idclassificacao` int(11) NOT NULL,
  PRIMARY KEY (`idfilme`),
  KEY `fk_filmes_1_idx` (`idclassificacao`),
  CONSTRAINT `fk_filmes_1` FOREIGN KEY (`idclassificacao`) REFERENCES `classificacao` (`idclassificacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filmes`
--

LOCK TABLES `filmes` WRITE;
/*!40000 ALTER TABLE `filmes` DISABLE KEYS */;
INSERT INTO `filmes` VALUES (1,'De Volta Para o Futuro',1),(2,'Teste',1),(3,'Mercenarios',2),(4,'Mogli',1),(5,'hjhfhkg',2),(6,'bg mnjhhhh',1),(7,'Harry Potter',1),(8,'Harry Potter',1);
/*!40000 ALTER TABLE `filmes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `per_permissao`
--

DROP TABLE IF EXISTS `per_permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `per_permissao` (
  `PER_ID` int(11) NOT NULL,
  `PER_DESCRICAO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `per_permissao`
--

LOCK TABLES `per_permissao` WRITE;
/*!40000 ALTER TABLE `per_permissao` DISABLE KEYS */;
INSERT INTO `per_permissao` VALUES (1,'ADMIN'),(2,'USUARIO'),(3,'FUNCIONARIO');
/*!40000 ALTER TABLE `per_permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pus_permissao_usuario`
--

DROP TABLE IF EXISTS `pus_permissao_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pus_permissao_usuario` (
  `idPUS_PERMISSAO_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `USR_ID` int(11) DEFAULT NULL,
  `PER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPUS_PERMISSAO_USUARIO`),
  KEY `fk_PUS_PERMISSAO_USUARIO_1` (`USR_ID`),
  KEY `fk_PUS_PERMISSAO_USUARIO_2` (`PER_ID`),
  CONSTRAINT `fk_PUS_PERMISSAO_USUARIO_1` FOREIGN KEY (`USR_ID`) REFERENCES `usr_usuario` (`USR_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PUS_PERMISSAO_USUARIO_2` FOREIGN KEY (`PER_ID`) REFERENCES `per_permissao` (`PER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pus_permissao_usuario`
--

LOCK TABLES `pus_permissao_usuario` WRITE;
/*!40000 ALTER TABLE `pus_permissao_usuario` DISABLE KEYS */;
INSERT INTO `pus_permissao_usuario` VALUES (4,3,2),(5,1,1),(11,2,1),(14,6,1),(15,6,2),(16,6,3),(17,12,2),(18,12,3),(19,4,1),(20,4,2),(21,4,3);
/*!40000 ALTER TABLE `pus_permissao_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr_usuario`
--

DROP TABLE IF EXISTS `usr_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usr_usuario` (
  `USR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USR_SENHA` varchar(45) NOT NULL,
  `USR_NOME` varchar(45) NOT NULL,
  PRIMARY KEY (`USR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr_usuario`
--

LOCK TABLES `usr_usuario` WRITE;
/*!40000 ALTER TABLE `usr_usuario` DISABLE KEYS */;
INSERT INTO `usr_usuario` VALUES (1,'123','thiago'),(2,'123','lucas'),(3,'123','tarcisio'),(4,'123','ronan'),(6,'123','nicodemos'),(12,'123','teste');
/*!40000 ALTER TABLE `usr_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'fatec_filmes'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-03 12:49:12
