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

-- Volcando datos para la tabla test.favorite: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
REPLACE INTO `favorite` (`ID`, `IDFAVORITE`, `IDUUID`, `idFavoritoType`) VALUES
	(4, '5meb7aKE722LA66ssBhvfM', '6964605CDF9148E5A7EB71F5708404D6', 3),
	(5, '1M8Klr6g1qPzykza6wN1BA', '7E9494F12B4D4BDE8C04CB9E1EEA36C3', 3),
	(8, '1M8Klr6g1qPzykza6wN1BA', '7E9494F12B4D4BDE8C04CB9E1EEA36C3', 3),
	(9, '0UWZUmn7sybxMCqrw9tGa7', 'CCFF6663AFD24F4C97878BE684250843', 6),
	(10, '0eGsygTp906u18L0Oimnem', '4F9D00CCA4CA4C8F92ECDC9B52D0CF10', 7),
	(12, '0UWZUmn7sybxMCqrw9tGa7', '24CE79483F1E4A30872BEFFEFEB09561', 6);
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
/*!40000 ALTER TABLE `favoritetype` DISABLE KEYS */;
REPLACE INTO `favoritetype` (`ID`, `DESCRIPTION`, `IDUUID`) VALUES
	(3, 'ALBUM', '64229A2A136842F9A9E47BBF30C6BBCC'),
	(6, 'ARTIST', 'F41C1808A95146CBB8BF4771AABC6C40'),
	(7, 'TRACK', '66A70CBC1A8E4BC28E7724BED6C4CFF6');
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
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
REPLACE INTO `role` (`id`, `IDUUID`, `ROLE`) VALUES
	(1, '2CBD13D460254FCDBF65A09CB2B8D6CA', 'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Volcando estructura para tabla test.sequence
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.sequence: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
REPLACE INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
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

-- Volcando datos para la tabla test.users: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`ID`, `create_time`, `EMAIL`, `ENABLED`, `IDUUID`, `PASSWORD`, `USERNAME`) VALUES
	(2, _binary 0xACED00057372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770E05000007DF060414290E137D9FC078, 'jjj@jsj.es', 1, '6722052B96424CB5A143BB05FD627C67', '*u1*', 'u1'),
	(11, _binary 0xACED00057372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770E05000007DF060414290E31E39B4078, '123@rr.es', 1, '052779EF22384BAABA6003B17B7FB176', '*u2*', 'u2');
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

-- Volcando datos para la tabla test.users_favorite: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `users_favorite` DISABLE KEYS */;
REPLACE INTO `users_favorite` (`User_ID`, `favorites_ID`) VALUES
	(2, 4),
	(2, 8),
	(2, 9),
	(2, 10),
	(11, 12);
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
/*!40000 ALTER TABLE `users_role` DISABLE KEYS */;
REPLACE INTO `users_role` (`User_ID`, `userRoles_id`) VALUES
	(2, 1);
/*!40000 ALTER TABLE `users_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
