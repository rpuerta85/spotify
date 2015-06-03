-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.21 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para test
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;


-- Volcando estructura para tabla test.favorite
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE IF NOT EXISTS `favorite` (
  `ID` int(11) NOT NULL,
  `IDFAVORITE` varchar(255) DEFAULT NULL,
  `IDUUID` varchar(255) DEFAULT NULL,
  `idFavoritoType` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_FAVORITE_idFavoritoType` (`idFavoritoType`),
  CONSTRAINT `FK_FAVORITE_idFavoritoType` FOREIGN KEY (`idFavoritoType`) REFERENCES `favoritetype` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.favorite: ~4 rows (aproximadamente)
DELETE FROM `favorite`;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` (`ID`, `IDFAVORITE`, `IDUUID`, `idFavoritoType`) VALUES
	(4, '5meb7aKE722LA66ssBhvfM', 'BEC8C3FA0AC84CD799FBF2D2AF2B0E51', 3),
	(5, '1M8Klr6g1qPzykza6wN1BA', 'D21FB434670340B1A7799FE31F150ACE', 3),
	(7, '0UWZUmn7sybxMCqrw9tGa7', 'ACB1F2024EF546B680A36E2E021DA818', 6),
	(8, '0eGsygTp906u18L0Oimnem', 'EBCF6EF0F8A9443C8DAF6415DCA13EC6', 9);
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;


-- Volcando estructura para tabla test.favoritetype
DROP TABLE IF EXISTS `favoritetype`;
CREATE TABLE IF NOT EXISTS `favoritetype` (
  `ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `IDUUID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.favoritetype: ~3 rows (aproximadamente)
DELETE FROM `favoritetype`;
/*!40000 ALTER TABLE `favoritetype` DISABLE KEYS */;
INSERT INTO `favoritetype` (`ID`, `DESCRIPTION`, `IDUUID`) VALUES
	(3, 'ALBUM', '21EAB46A7A45459C808A80364F5D1988'),
	(6, 'ARTIST', '345C08A5AB634B509752B637EDE6ECDF'),
	(9, 'TRACK', '30DDDB83E87B4882895305E6319A381C');
/*!40000 ALTER TABLE `favoritetype` ENABLE KEYS */;


-- Volcando estructura para tabla test.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL,
  `IDUUID` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.role: ~1 rows (aproximadamente)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `IDUUID`, `ROLE`) VALUES
	(1, 'A0731C9A181F433B8010AF34700175B3', 'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Volcando estructura para tabla test.sequence
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.sequence: ~1 rows (aproximadamente)
DELETE FROM `sequence`;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
	('SEQ_GEN', 50);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;


-- Volcando estructura para tabla test.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(11) NOT NULL,
  `create_time` longblob,
  `EMAIL` varchar(255) DEFAULT NULL,
  `ENABLED` tinyint(1) DEFAULT '0',
  `IDUUID` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.users: ~1 rows (aproximadamente)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`ID`, `create_time`, `EMAIL`, `ENABLED`, `IDUUID`, `PASSWORD`, `USERNAME`) VALUES
	(2, _binary 0xACED00057372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770E05000007DF0603121F061B003B4078, 'jjj@jsj.es', 1, '7C243AB2EAAC479FB8A1778254C44AF2', '*u1*', 'u1');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Volcando estructura para tabla test.users_favorite
DROP TABLE IF EXISTS `users_favorite`;
CREATE TABLE IF NOT EXISTS `users_favorite` (
  `User_ID` int(11) NOT NULL,
  `favorites_ID` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`,`favorites_ID`),
  KEY `FK_users_FAVORITE_favorites_ID` (`favorites_ID`),
  CONSTRAINT `FK_users_FAVORITE_User_ID` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`),
  CONSTRAINT `FK_users_FAVORITE_favorites_ID` FOREIGN KEY (`favorites_ID`) REFERENCES `favorite` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.users_favorite: ~4 rows (aproximadamente)
DELETE FROM `users_favorite`;
/*!40000 ALTER TABLE `users_favorite` DISABLE KEYS */;
INSERT INTO `users_favorite` (`User_ID`, `favorites_ID`) VALUES
	(2, 4),
	(2, 5),
	(2, 7),
	(2, 8);
/*!40000 ALTER TABLE `users_favorite` ENABLE KEYS */;


-- Volcando estructura para tabla test.users_role
DROP TABLE IF EXISTS `users_role`;
CREATE TABLE IF NOT EXISTS `users_role` (
  `User_ID` int(11) NOT NULL,
  `userRoles_id` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`,`userRoles_id`),
  KEY `FK_users_role_userRoles_id` (`userRoles_id`),
  CONSTRAINT `FK_users_role_User_ID` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`),
  CONSTRAINT `FK_users_role_userRoles_id` FOREIGN KEY (`userRoles_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.users_role: ~1 rows (aproximadamente)
DELETE FROM `users_role`;
/*!40000 ALTER TABLE `users_role` DISABLE KEYS */;
INSERT INTO `users_role` (`User_ID`, `userRoles_id`) VALUES
	(2, 1);
/*!40000 ALTER TABLE `users_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
