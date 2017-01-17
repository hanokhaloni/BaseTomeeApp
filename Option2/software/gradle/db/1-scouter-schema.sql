-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for scouterdb
CREATE DATABASE IF NOT EXISTS `scouterdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `scouterdb`;


-- Dumping structure for table scouterdb.actions
CREATE TABLE IF NOT EXISTS `actions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `executor` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `details` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKActionsClientId` (`client_id`),
  CONSTRAINT `FKActionsClientId` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.alerts
CREATE TABLE IF NOT EXISTS `alerts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `is_acknowledged` bit(1) NOT NULL,
  `is_archived` bit(1) NOT NULL,
  `role` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKClientId` (`client_id`),
  CONSTRAINT `FKClientId` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.clients
CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_bin NOT NULL,
  `client_internal_id` varchar(30) COLLATE utf8_bin NOT NULL,
  `encryption_key` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ssl_certificate_password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `app_version` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `installation_status` int(11) DEFAULT NULL,
  `can_messages_be_sent` bit(1) DEFAULT NULL,
  `is_open_with_icon` bit(1) NOT NULL,
  `code_number` varchar(20) COLLATE utf8_bin NOT NULL,
  `icon_id` int(11) NOT NULL,
  `is_push_on` bit(1) NOT NULL,
  `is_wifi` bit(1) NOT NULL,
  `is_mobile_internet` bit(1) NOT NULL,
  `allowed_idle_time` int(11) NOT NULL,
  `app_language` varchar(20) COLLATE utf8_bin NOT NULL,
  `client_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `app_name` varchar(100) COLLATE utf8_bin NOT NULL,
  `installation_file_name` varchar(100) COLLATE utf8_bin NOT NULL,
  `apk_file` blob,
  `ip_id` int(11) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `role` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKIpId` (`ip_id`),
  CONSTRAINT `FKIpId` FOREIGN KEY (`ip_id`) REFERENCES `ips` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.current_medium_name
CREATE TABLE IF NOT EXISTS `current_medium_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `current_name` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.distribution_client
CREATE TABLE IF NOT EXISTS `distribution_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distribution_list_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDistClientId` (`client_id`),
  KEY `FKDistListId` (`distribution_list_id`),
  CONSTRAINT `FKDistClientId` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  CONSTRAINT `FKDistListId` FOREIGN KEY (`distribution_list_id`) REFERENCES `distribution_lists` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.distribution_lists
CREATE TABLE IF NOT EXISTS `distribution_lists` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_bin NOT NULL,
  `allowed_clients_types` varchar(30) COLLATE utf8_bin NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `role` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.ips
CREATE TABLE IF NOT EXISTS `ips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_ip` varchar(255) COLLATE utf8_bin NOT NULL,
  `second_ip` varchar(255) COLLATE utf8_bin NOT NULL,
  `supported_clients_types` varchar(50) COLLATE utf8_bin NOT NULL,
  `max_allowed_clients` int(11) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.media
CREATE TABLE IF NOT EXISTS `media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `media_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `media_size` int(11) NOT NULL,
  `is_sound` tinyint(1) NOT NULL,
  `preview_image` longblob,
  `medium_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `media_length` int(11) DEFAULT NULL,
  `medium` longblob,
  `message_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKMediaMessages` (`message_id`),
  CONSTRAINT `FKMediaMessages` FOREIGN KEY (`message_id`) REFERENCES `messages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.media_viewed
CREATE TABLE IF NOT EXISTS `media_viewed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `medium_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL,
  `is_medium_viewed` bit(1) NOT NULL DEFAULT b'0',
  `medium_viewed_time` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKMediumClientsId` (`client_id`),
  KEY `FKMediaViewedId` (`medium_id`),
  KEY `FKMediaViewedMessages` (`message_id`),
  CONSTRAINT `FKMediaViewedId` FOREIGN KEY (`medium_id`) REFERENCES `media` (`id`),
  CONSTRAINT `FKMediumClientsId` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  CONSTRAINT `FKMediaViewedMessages` FOREIGN KEY (`message_id`) REFERENCES `messages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.messages
CREATE TABLE IF NOT EXISTS `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `messages_status` int(11) DEFAULT NULL,
  `expiration_time` datetime DEFAULT NULL,
  `role` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.


-- Dumping structure for table scouterdb.message_client
CREATE TABLE IF NOT EXISTS `message_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKMessageClientClients` (`client_id`),
  KEY `FKMessageClientMessages` (`message_id`),
  CONSTRAINT `FKMessageClientClients` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  CONSTRAINT `FKMessageClientMessages` FOREIGN KEY (`message_id`) REFERENCES `messages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
