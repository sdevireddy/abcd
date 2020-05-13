-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: May 13, 2020 at 03:52 PM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vmoksha`
--

-- --------------------------------------------------------

--
-- Table structure for table `cardetails`
--

DROP TABLE IF EXISTS `cardetails`;
CREATE TABLE IF NOT EXISTS `cardetails` (
  `CAR_ID` int(10) NOT NULL AUTO_INCREMENT,
  `COMPANY_NAME` varchar(50) NOT NULL,
  `CARTYPE_ID` int(10) NOT NULL,
  PRIMARY KEY (`CAR_ID`),
  KEY `fk_cartype` (`CARTYPE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cartype`
--

DROP TABLE IF EXISTS `cartype`;
CREATE TABLE IF NOT EXISTS `cartype` (
  `CARTYPE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CARTYPE_CODE` varchar(50) NOT NULL,
  `CARTYPE_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`CARTYPE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `STATE_ID` int(10) DEFAULT NULL,
  `NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `STATUS` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CITY_STATE` (`STATE_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`ID`, `STATE_ID`, `NAME`, `CODE`, `DESCRIPTION`, `STATUS`) VALUES
(1, 2, 'HYD', '', 'HYDERABAD', '1'),
(2, 2, 'PUN', '', 'PUNE', '0'),
(3, 1, 'DELHI', NULL, 'Cool place in winter', '1');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE IF NOT EXISTS `country` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NAME` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `STATUS` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`ID`, `CODE`, `NAME`, `STATUS`) VALUES
(12, 'PK', 'PAKISTAN', '1'),
(3, 'SL', 'Sri Lanka', '1'),
(8, 'SLK', 'Skkk', '1');

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
CREATE TABLE IF NOT EXISTS `language` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `STATUS` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `language`
--

INSERT INTO `language` (`ID`, `CODE`, `NAME`, `STATUS`) VALUES
(1, 'TA', 'TAMIL', '1'),
(2, 'EN', 'ENGLISH', '1'),
(3, 'PU', 'PUNJABI', '1'),
(6, 'TE', 'TELUGU', '1'),
(7, 'TU', 'TULU', '1'),
(8, 'KK', 'KKKK', '1');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `ROLE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(50) NOT NULL,
  `ROLE_DESCRIPTION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
CREATE TABLE IF NOT EXISTS `state` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `STATUS` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `COUNTRY_ID` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_country` (`COUNTRY_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`ID`, `CODE`, `NAME`, `STATUS`, `COUNTRY_ID`) VALUES
(1, 'UP', 'Uttar Pradesh', '1', 8),
(4, 'AP', 'Andhra Pradesh', '1', 1),
(5, 'PU', 'PUNJAB', '1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) DEFAULT NULL,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  `PHONE_NUMBER` varchar(50) DEFAULT NULL,
  `ENABLE` tinyint(4) NOT NULL DEFAULT '1',
  `ADDRESS_ID` int(3) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `fk_address` (`ADDRESS_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
