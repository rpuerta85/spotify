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

-- Volcando datos para la tabla test.favorite: ~18 rows (aproximadamente)
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` (`ID`, `IDFAVORITE`, `IDUUID`, `idFavoritoType`) VALUES
	(253, '6YeV0JWW7g8dDf78jFIe1e', '917B6CEAB3134A4D83C77906C88BFB62', 3),
	(254, '3M9UNyYTjbGpLnf02QSgMy', '160C9B9237044E91A8FE8BA354D6B5FA', 7),
	(255, '6k2AsDKvvip54F59DIn1Mv', 'D8BB456462DF45D8893E8074903B4737', 7),
	(256, '56LsEoYMQmzPm9JMICPfxe', '267CB70209784F32AB6EE43FF8DC5240', 7),
	(258, '1oaGF1WX4dMGOwZL3ueYVw', '1CB9EF953E50476392E7D9C72D1607DF', 7),
	(261, '2RdwBSPQiwcmiDo9kixcl8', '69ED7E982E814AF5BF813BEB449A2A29', 6),
	(262, '7uWUavweZSj3QyG2IIhj2i', 'D287B0C435A648A7AB07C6F21C997C95', 6),
	(303, '0B70RUdQurJEWLT28GdNtD', '854C78EF0F9C477EA9F5AE0C48EF09D1', 7),
	(304, '5QyeQxnM5onN4hFeI9xQmI', '400F40879B7A4F8C9579425913C8A818', 3),
	(306, '5lODCkFdEtpPn3YxfmyLfT', '0336B70DB34B41E5A59D69A95A2B58FC', 6),
	(307, '0C8ZW7ezQVs4URX5aX7Kqx', 'FA9BFFE0A68D4B60B9E212A1C18865D5', 6),
	(308, '0sJaoFM0uFCOBE5Qcrhv7n', 'C031867F5AA54764A2AD2205D4CAB632', 6),
	(309, '5G2P0iITwxqqqn1h9dX1wc', 'F08F256704D04C38BC7BC5D6D24F365E', 6),
	(310, '5BT7D9YTEXQSyeVaRNAuyv', '4DEEFCFD3F7F4704901AFE9ADC3A5653', 3),
	(311, '1XGkDZ1fAhuQtMGfN8D8jg', 'DDDE7000CD1C4ECFA747E551FABCB259', 3),
	(312, '1hQmICC4YS92qv5flhbNYs', 'A1F65C7E122E4FC68F75306B075C7FBD', 3),
	(313, '3fMbdgg4jU18AjLCKBhRSm', '5045D059298D4542B0D2A9EDC4E32A4A', 6),
	(314, '349ymR3M8bnpdXdLrmbGVu', 'AA1B574376FD47E89686E4BB65C687AA', 6);
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
INSERT INTO `favoritetype` (`ID`, `DESCRIPTION`, `IDUUID`) VALUES
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

-- Volcando datos para la tabla test.role: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `IDUUID`, `ROLE`) VALUES
	(1, '2CBD13D460254FCDBF65A09CB2B8D6CA', 'ADMIN'),
	(2, 'KSJFSKJFHSFKJN3U737823WN880038393', 'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Volcando estructura para tabla test.sequence
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.sequence: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
	('SEQ_GEN', 600);
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

-- Volcando datos para la tabla test.users: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`ID`, `create_time`, `EMAIL`, `ENABLED`, `IDUUID`, `PASSWORD`, `USERNAME`) VALUES
	(2, _binary 0x303030302D30302D30302030303A30303A3030, 'jjj@jsj.es', 1, '6722052B96424CB5A143BB05FD627C67', '9bdc476e0072cd4903a182073605410a', 'u1'),
	(11, _binary 0x303030302D30302D30302030303A30303A3030, '123@rr.es', 1, '052779EF22384BAABA6003B17B7FB176', 'e1225dba92a2f9be0f0d8cf496ceca26', 'u2'),
	(351, _binary 0x303030302D30302D30302030303A30303A3030, NULL, 0, NULL, '530ae7f580da3d1bccd408b028226620', 'pepe'),
	(401, _binary 0x303030302D30302D30302030303A30303A3030, NULL, 0, 'A06A07989AAF4927B6C35099AEC53FFB', 'cd09f148fed2c79ba57eedf834fe1942', 'ieie'),
	(402, _binary 0x303030302D30302D30302030303A30303A3030, NULL, 0, 'AA2E3F92E6D74A43BF38FD7B5C1FCC60', '1e9aecc92a3b915e9b2f0baf010d4aac', 'kjhefkj'),
	(403, _binary 0x303030302D30302D30302030303A30303A3030, 'kkk@kk.es', 0, 'C5135E20E174488A9BF036970AF11925', '5e36941b3d856737e81516acd45edc50', 'kjgj'),
	(451, _binary 0x303030302D30302D30302030303A30303A3030, 'kkk@tt.es', 0, 'B0F97DE0FA9F4077A1F7C903D9E101DF', '5f45e31901b1486a1a99cc0d7bfd2a0d', 'u22'),
	(452, _binary 0x303030302D30302D30302030303A30303A3030, 'kkk@jjj.es', 0, '1A7F5CC7A9A3487CB81EEB6CEC40167F', '915bc66e8aa43da2f2bce239f501a13a', 'u25'),
	(453, _binary 0x303030302D30302D30302030303A30303A3030, 'uuu55@uu.es', 0, '81CF9C8F0C224688B5EAAE6DC4523FDB', '972b92409ebae14e3dbe82b5c8822a87', 'u99'),
	(454, _binary 0x303030302D30302D30302030303A30303A3030, 'sfgf@hhh.es', 0, '0827D8821EC84E839CA4E985640E1D33', '320ed0dba6f8bc068935c7bee14507a4', 'u100'),
	(455, _binary 0x303030302D30302D30302030303A30303A3030, 'ggg@jj.es', 1, 'D33B42B1FD764756BDDB84A5F44C21A9', '327abb0a25db4ee838efc3a52682f13e', 'u102'),
	(456, _binary 0x303030302D30302D30302030303A30303A3030, 'hhh@jjj.es', 1, 'A5598BF4CA124C2BBD7009B533C89CCF', 'aac57914c7f380456dfab59cc72e5c20', 'u103'),
	(501, _binary 0x303030302D30302D30302030303A30303A3030, 'jj@jj.es', 1, '37FAEA509CC94F6184970F633D780979', '6b00f5b596081d463e9a13268842a142', 'u999'),
	(551, _binary 0x303030302D30302D30302030303A30303A3030, 'SWFWER@JJ.ES', 1, '360EEEDCEDA6403191CCBA7BF9A86F32', 'c81e728d9d4c2f636f067f89cc14862c', 'u2999');
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

-- Volcando datos para la tabla test.users_favorite: ~18 rows (aproximadamente)
/*!40000 ALTER TABLE `users_favorite` DISABLE KEYS */;
INSERT INTO `users_favorite` (`User_ID`, `favorites_ID`) VALUES
	(11, 253),
	(11, 254),
	(11, 255),
	(11, 256),
	(2, 258),
	(11, 261),
	(11, 262),
	(2, 303),
	(2, 304),
	(2, 306),
	(11, 307),
	(11, 308),
	(11, 309),
	(11, 310),
	(11, 311),
	(2, 312),
	(2, 313),
	(2, 314);
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

-- Volcando datos para la tabla test.users_role: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `users_role` DISABLE KEYS */;
INSERT INTO `users_role` (`User_ID`, `userRoles_id`) VALUES
	(2, 1),
	(455, 1),
	(456, 1),
	(501, 1),
	(551, 1),
	(11, 2),
	(351, 2),
	(401, 2),
	(402, 2),
	(403, 2),
	(451, 2),
	(452, 2),
	(453, 2),
	(454, 2);
/*!40000 ALTER TABLE `users_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
