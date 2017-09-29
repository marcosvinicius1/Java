CREATE DATABASE  IF NOT EXISTS `painelfx` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `painelfx`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: servidor    Database: painelfx
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
-- Table structure for table `tb_config`
--

DROP TABLE IF EXISTS `tb_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_config` (
  `idtb_config` int(11) NOT NULL AUTO_INCREMENT,
  `tamanhox` int(11) DEFAULT NULL,
  `tamanhoy` int(11) DEFAULT NULL,
  `letreiro` tinyint(4) DEFAULT NULL,
  `tipolocalizacao` varchar(45) DEFAULT NULL,
  `topoimagem` mediumblob,
  `fundoimagem` mediumblob,
  `lateralimagem` mediumblob,
  `letreirotempo` int(11) DEFAULT NULL,
  `letreirocorfonte` int(11) DEFAULT NULL,
  `fontetabela` int(11) DEFAULT NULL,
  `corfontetabela` int(11) DEFAULT NULL,
  `letreirocorfundo` int(11) DEFAULT NULL,
  `letreirotexto` varchar(100) DEFAULT NULL,
  `tabela01` tinyint(4) DEFAULT NULL,
  `tabela02` tinyint(4) DEFAULT NULL,
  `tabela03` tinyint(4) DEFAULT NULL,
  `tabela04` tinyint(4) DEFAULT NULL,
  `terminal` int(11) DEFAULT NULL,
  `ctcodigo` tinyint(4) DEFAULT NULL,
  `ctproduto` tinyint(4) DEFAULT NULL,
  `ctunid` tinyint(4) DEFAULT NULL,
  `ctoferta` tinyint(4) DEFAULT NULL,
  `ctvalor1` tinyint(4) DEFAULT NULL,
  `ctvalor2` tinyint(4) DEFAULT NULL,
  `nomevalor1` varchar(45) DEFAULT NULL,
  `nomevalor2` varchar(45) DEFAULT NULL,
  `corfundotabela` int(11) DEFAULT NULL,
  `fonteestilotabela` int(11) DEFAULT NULL,
  `fontetipotabela` varchar(45) DEFAULT NULL,
  `espacamento` int(11) DEFAULT NULL,
  `tabela1nome` varchar(45) DEFAULT NULL,
  `tabela2nome` varchar(45) DEFAULT NULL,
  `tabela3nome` varchar(45) DEFAULT NULL,
  `tabela4nome` varchar(45) DEFAULT NULL,
  `transpfundotabela` int(11) DEFAULT NULL,
  `fontetabelatitulo` int(11) DEFAULT NULL,
  `fontetipotabelatitulo` varchar(45) DEFAULT NULL,
  `fonteestilotabelatitulo` int(11) DEFAULT NULL,
  `exibirtopo` tinyint(4) DEFAULT NULL,
  `exibirlateral` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idtb_config`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_prod`
--

DROP TABLE IF EXISTS `tb_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_prod` (
  `idtb_prod` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `unid` varchar(45) DEFAULT NULL,
  `valor1` float DEFAULT NULL,
  `valor2` float DEFAULT NULL,
  `receita` varchar(100) DEFAULT NULL,
  `oferta` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idtb_prod`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=16930 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `painelfx`.`UPDATE_TB_PROD_PAINEL_VALOR1` AFTER INSERT ON `tb_prod` FOR EACH ROW
BEGIN
UPDATE tb_prod_painel set valor1=new.valor1 where codigo=new.codigo;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tb_prod_painel`
--

DROP TABLE IF EXISTS `tb_prod_painel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_prod_painel` (
  `idtb_painel` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `unid` varchar(45) DEFAULT NULL,
  `valor1` float DEFAULT NULL,
  `valor2` float DEFAULT NULL,
  `receita` varchar(100) DEFAULT NULL,
  `oferta` tinyint(4) DEFAULT NULL,
  `terminal` int(11) DEFAULT NULL,
  `painel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtb_painel`)
) ENGINE=InnoDB AUTO_INCREMENT=3649 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'painelfx'
--

--
-- Dumping routines for database 'painelfx'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-24 10:31:24
