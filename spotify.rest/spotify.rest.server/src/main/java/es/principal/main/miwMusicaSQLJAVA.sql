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
CREATE TABLE IF NOT EXISTS `favorite` (
  `ID` int(11) NOT NULL,
  `IDFAVORITE` varchar(255) DEFAULT NULL,
  `IDUUID` varchar(255) DEFAULT NULL,
  `idFavoritoType` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_FAVORITE_idFavoritoType` (`idFavoritoType`),
  CONSTRAINT `FK_FAVORITE_idFavoritoType` FOREIGN KEY (`idFavoritoType`) REFERENCES `favoritetype` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.favorite: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` (`ID`, `IDFAVORITE`, `IDUUID`, `idFavoritoType`) VALUES
	(2, '0EmeFodog0BfCgMzAIvKQp', 'CD4D9E89C41A47DE934BA8B5D9A767EF', 6),
	(3, '29dqyZX9kKFuWfqg6lXNdS', 'A4C8B88A64764167B06008120F8C3066', 3),
	(4, '6NPVjNh8Jhru9xOmyQigds', 'C3317E4AA8354264AC5E2A10D6D64600', 7),
	(5, '3tm3GG9BBOYhUzKWlS6A74', '2802DDB4980442FF88755BCC34DA78A1', 7),
	(51, '1NI3bX5M8OEhK3hZqaUGGu', '70E32839A23C4767ADB203AB2BB11433', 3),
	(103, '08OYgvhtSRzZFnNpmdGL5K', '6FBD95BEE9E54DC3BDE75814003F58D0', 7),
	(104, '7opp16lU7VM3l2WBdGMYHP', '3279DE8B944E4658B42287F9F00F3925', 6),
	(105, '285HeuLxsngjFn4GGegGNm', '469DE00289A44311BF705FD17CB4CA90', 7),
	(106, '10rh0uWcwhvw0FeG1yBNRd', '53792F5BD2724A419D5C640886B54909', 3);
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;


-- Volcando estructura para tabla test.favoritetype
CREATE TABLE IF NOT EXISTS `favoritetype` (
  `ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `IDUUID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.favoritetype: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `favoritetype` DISABLE KEYS */;
INSERT INTO `favoritetype` (`ID`, `DESCRIPTION`, `IDUUID`) VALUES
	(3, 'ALBUM', '64229A2A136842F9A9E47BBF30C6BBCC'),
	(6, 'ARTIST', 'F41C1808A95146CBB8BF4771AABC6C40'),
	(7, 'TRACK', '66A70CBC1A8E4BC28E7724BED6C4CFF6');
/*!40000 ALTER TABLE `favoritetype` ENABLE KEYS */;


-- Volcando estructura para tabla test.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL,
  `IDUUID` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.role: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `IDUUID`, `ROLE`) VALUES
	(1, '2CBD13D460254FCDBF65A09CB2B8D6CA', 'ADMIN'),
	(2, 'KSJFSKJFHSFKJN3U737823WN880038393', 'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Volcando estructura para tabla test.sequence
CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.sequence: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
	('SEQ_GEN', 150);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;


-- Volcando estructura para tabla test.users
CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `ENABLED` tinyint(1) DEFAULT '0',
  `IDUUID` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.users: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`ID`, `create_time`, `EMAIL`, `ENABLED`, `IDUUID`, `PASSWORD`, `USERNAME`) VALUES
	(1, '2013-02-23 12:27:36', 'deybiz58@hotmail.com', 1, '195A8498A96F4C45A3334B43CAD60233', '9635596945b79a0b06de647c3c8b142f', 'u3'),
	(2, '2012-10-23 18:00:00', 'jjj@jsj.es', 1, '6722052B96424CB5A143BB05FD627C67', '9bdc476e0072cd4903a182073605410a', 'u1'),
	(11, '2000-01-01 14:23:23', '123@rr.es', 1, '052779EF22384BAABA6003B17B7FB176', 'e1225dba92a2f9be0f0d8cf496ceca26', 'u2'),
	(101, '2011-04-19 10:27:25', 'mgacoelho@hotmail.com', 1, '081F2BA7FED64E7FAD16F70B53BA5AC6', '78c3025e9eb11aeb3333539b848d092d', 'u4'),
	(102, '2012-02-23 18:30:37', 'SWFWER@JJ.ES', 1, '5C40DA8F4EE94B21A8FD0A0292B826E1', '14a0a8641338196cd08cf1d187b3ac6', 'u5'),
	(107, '2014-01-22 18:30:09', 'sss@kk.es', 1, '6AE921559CEB4DC2B1C57148BDE7B26D', 'b9be81d318344f30fcfba6c882b3ea', 'u7');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Volcando estructura para tabla test.users_favorite
CREATE TABLE IF NOT EXISTS `users_favorite` (
  `User_ID` int(11) NOT NULL,
  `favorites_ID` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`,`favorites_ID`),
  KEY `FK_users_FAVORITE_favorites_ID` (`favorites_ID`),
  CONSTRAINT `FK_users_FAVORITE_User_ID` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`),
  CONSTRAINT `FK_users_FAVORITE_favorites_ID` FOREIGN KEY (`favorites_ID`) REFERENCES `favorite` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.users_favorite: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `users_favorite` DISABLE KEYS */;
INSERT INTO `users_favorite` (`User_ID`, `favorites_ID`) VALUES
	(2, 2),
	(2, 3),
	(2, 4),
	(2, 5),
	(2, 51),
	(2, 103),
	(11, 104),
	(11, 105),
	(11, 106);
/*!40000 ALTER TABLE `users_favorite` ENABLE KEYS */;


-- Volcando estructura para tabla test.users_role
CREATE TABLE IF NOT EXISTS `users_role` (
  `User_ID` int(11) NOT NULL,
  `userRoles_id` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`,`userRoles_id`),
  KEY `FK_users_role_userRoles_id` (`userRoles_id`),
  CONSTRAINT `FK_users_role_User_ID` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`),
  CONSTRAINT `FK_users_role_userRoles_id` FOREIGN KEY (`userRoles_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.users_role: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `users_role` DISABLE KEYS */;
INSERT INTO `users_role` (`User_ID`, `userRoles_id`) VALUES
	(1, 1),
	(2, 1),
	(11, 1),
	(101, 1),
	(102, 1),
	(107, 2);
/*!40000 ALTER TABLE `users_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
