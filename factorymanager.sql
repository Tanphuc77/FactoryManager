-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.41 - MySQL Community Server - GPL
-- Server OS:                    Linux
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table factorymanager.company
CREATE TABLE IF NOT EXISTS `company` (
  `id` varchar(255) NOT NULL,
  `code` varchar(50) NOT NULL,
  `companyname` varchar(100) NOT NULL,
  `subcontractor` bit(1) NOT NULL,
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `state` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mobile_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.company: ~15 rows (approximately)
INSERT INTO `company` (`id`, `code`, `companyname`, `subcontractor`, `status`, `state`, `contact_name`, `mobile_phone`, `create_at`, `update_at`, `address`) VALUES
	('5685bc6f-16a2-11f0-ab71-0242ac120002', 'WH2', 'Market Paper', b'1', 'Active', 'Victoria', 'Jim John Lewis', '0401178604', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('5685ff4e-16a2-11f0-ab71-0242ac120002', 'WH10', 'Marterniy Khay', b'1', 'Inactive', 'Victoria', 'Dorothy Montgomery', '(02) 6170 0797', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('56860f20-16a2-11f0-ab71-0242ac120002', 'WH4', 'Leonave Devandi', b'1', 'Active', 'New South Wales', 'Jay Larson', '(02) 6124 7369', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('5686100e-16a2-11f0-ab71-0242ac120002', 'WH5', 'Engvie Flore', b'1', 'Active', 'South Australia', 'Allison Mitchell', '(02) 6130 6453', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('56861052-16a2-11f0-ab71-0242ac120002', 'WH6', 'Riverside Gardens', b'1', 'Inactive', 'Western Australia', 'Amy Morris', '(03) 2345 6789', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('56861091-16a2-11f0-ab71-0242ac120002', 'QS', 'Queen Stack', b'0', 'Active', 'Tasmania', 'Yvonne Foster', '(07) 3456 7890', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('568610ce-16a2-11f0-ab71-0242ac120002', 'QA', 'Queran Assitaert', b'1', 'Inactive', 'South Australia', 'Jessie Harper', '(08) 4567 8901', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('5686255a-16a2-11f0-ab71-0242ac120002', 'RE', 'Ringle Envested', b'1', 'Active', 'South Australia', 'Jesus Lowe', '0412 345 678', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('568626bb-16a2-11f0-ab71-0242ac120002', 'MA', 'Machartla Engvireal', b'1', 'Active', 'South Australia', 'Marshall Mcdaniel', '0423 456 789', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('5686271c-16a2-11f0-ab71-0242ac120002', 'TG', 'Tinghall Gall', b'1', 'Active', 'Western Australia', 'Marlene Cook', '(02) 2345 6789', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('5686285c-16a2-11f0-ab71-0242ac120002', 'SS', 'Superior Sheet', b'1', 'Active', 'Tasmania', 'Christopher Ward', '(02) 6543 2109', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('568628c2-16a2-11f0-ab71-0242ac120002', 'PS', 'PrecisionSheet', b'1', 'Active', 'Tasmania', 'Henry Mitchell', '(02) 9876 5432', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('56862903-16a2-11f0-ab71-0242ac120002', 'MM', 'Master Metalworks', b'1', 'Active', 'New South Wales', 'Liam Cooper', '(02) 3456 7890', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('56862942-16a2-11f0-ab71-0242ac120002', 'SCI', 'SteelCraft Innovations', b'1', 'Active', 'New South Wales', 'Isaac Parker', '(02) 8765 4321', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', ''),
	('56862a40-16a2-11f0-ab71-0242ac120002', 'ASI', 'ApexSheet Industries', b'0', 'Active', 'New South Wales', 'Benjamin Hayes', '(02) 6543 2109', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', '');

-- Dumping structure for event factorymanager.delete_old_expired_tokens
DELIMITER //
CREATE EVENT `delete_old_expired_tokens` ON SCHEDULE EVERY 1 DAY STARTS '2025-04-14 09:33:44' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM user_token
WHERE expiry_at < DATE_SUB(NOW(), INTERVAL 7 DAY)//
DELIMITER ;

-- Dumping structure for table factorymanager.flyway_schema_history
CREATE TABLE IF NOT EXISTS `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.flyway_schema_history: ~0 rows (approximately)

-- Dumping structure for table factorymanager.permission
CREATE TABLE IF NOT EXISTS `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK2ojme20jpga3r4r79tdso17gi` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.permission: ~5 rows (approximately)
INSERT INTO `permission` (`id`, `create_at`, `name`, `description`, `update_at`) VALUES
	(1, '2025-04-16 06:45:07.000000', 'VIEW_DATA', 'Xem danh sách người dùng', '2025-04-16 06:45:07.000000'),
	(2, '2025-04-16 06:45:07.000000', 'ADD_DATA', 'Thêm người dùng', '2025-04-16 06:45:07.000000'),
	(3, '2025-04-16 06:45:07.000000', 'EDIT_DATA', 'Chỉnh sửa người dùng', '2025-04-16 06:45:07.000000'),
	(4, '2025-04-16 06:45:07.000000', 'DELETE_DATA', 'Xoá người dùng', '2025-04-16 06:45:07.000000'),
	(9, '2025-04-16 06:45:07.000000', 'VIEW_DASHBOARD', 'Xem dashboard hệ thống', '2025-04-16 06:45:07.000000');

-- Dumping structure for table factorymanager.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.role: ~4 rows (approximately)
INSERT INTO `role` (`id`, `name`, `description`, `create_at`, `update_at`) VALUES
	(1, 'SUPER_ADMIN', 'Toàn quyền hệ thống, bao gồm quản lý Admin', '2025-04-11 14:06:38.000000', '2025-04-11 14:06:38.000000'),
	(2, 'ADMIN', 'Quản lý nội dung hệ thống, không quản lý được các Admin khác', '2025-04-16 10:31:48.000000', '2025-04-17 08:32:03.000000'),
	(3, 'PRODUCTION_OFFICE', 'Quản lý thông tin và hoạt động văn phòng sản xuất', '2025-04-16 10:09:52.000000', '2025-04-16 10:13:52.000000'),
	(4, 'FACTORY_MANAGER', 'Quản lý tổng thể hoạt động sản xuất tại nhà máy', '2025-04-16 10:12:09.000000', '2025-04-17 08:32:04.000000');

-- Dumping structure for table factorymanager.role_permission
CREATE TABLE IF NOT EXISTS `role_permission` (
  `role_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FKf8yllw1ecvwqy3ehyxawqa1qp` (`permission_id`),
  CONSTRAINT `FKa6jx8n8xkesmjmv6jqug6bg68` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKf8yllw1ecvwqy3ehyxawqa1qp` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.role_permission: ~5 rows (approximately)
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES
	(1, 1),
	(2, 1),
	(1, 2),
	(1, 3),
	(1, 4);

-- Dumping structure for table factorymanager.team
CREATE TABLE IF NOT EXISTS `team` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.team: ~4 rows (approximately)
INSERT INTO `team` (`id`, `name`, `create_at`, `update_at`) VALUES
	('c6afbca0-16a2-11f0-ab71-0242ac120002', 'Engineering', '2025-04-11 07:01:22.000000', '2025-04-11 07:01:22.000000'),
	('c6afd552-16a2-11f0-ab71-0242ac120002', 'Marketing', '2025-04-11 07:01:22.000000', '2025-04-11 07:01:22.000000'),
	('c6afd950-16a2-11f0-ab71-0242ac120002', 'Sales', '2025-04-11 07:01:22.000000', '2025-04-11 07:01:22.000000'),
	('c6afda08-16a2-11f0-ab71-0242ac120002', 'Design', '2025-04-11 07:01:22.000000', '2025-04-11 07:01:22.000000');

-- Dumping structure for table factorymanager.ui_config
CREATE TABLE IF NOT EXISTS `ui_config` (
  `id` int NOT NULL AUTO_INCREMENT,
  `config_json` text NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `screen_code` varchar(100) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoejxkcsq4hgrtxeylxrjyhufm` (`user_id`),
  CONSTRAINT `FKoejxkcsq4hgrtxeylxrjyhufm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.ui_config: ~0 rows (approximately)

-- Dumping structure for table factorymanager.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(255) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `status` enum('ACTIVE','INACTIVE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `project_manager` bit(1) NOT NULL,
  `role_id` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.user: ~2 rows (approximately)
INSERT INTO `user` (`id`, `firstname`, `lastname`, `date_of_birth`, `status`, `username`, `password`, `image`, `project_manager`, `role_id`, `created_at`, `updated_at`) VALUES
	('24379ed8-55c4-4981-ae88-26df52a43c0b', 'Phuc', 'Tan', '2002-04-12', 'ACTIVE', 'thongnguyen', '$2a$10$U9DSa43wnb/5MciVqMKht.l.cbQKwEPlkDldqPDse5tYx/80uULD.', 'http://localhost:8080/factory/api/upload/bd3c42b3-6525-416d-b3c9-660011cc689d_photo-1633332755192-727a05c4013d.jpg', b'0', 2, NULL, NULL),
	('a23860b8-c088-4e53-a335-762b41ce2446', 'Admin', 'Super', NULL, 'ACTIVE', 'Admin', '$2a$10$0PdoJBLE8Ftv/evemYx.IeynR.Xjcom90VotY79jvPjkqjoBcItuy', NULL, b'1', 1, NULL, NULL);

-- Dumping structure for table factorymanager.user_company
CREATE TABLE IF NOT EXISTS `user_company` (
  `user_id` varchar(255) NOT NULL,
  `company_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`company_id`),
  KEY `FK31viftsw6kihfrdybimaj0r3d` (`company_id`),
  CONSTRAINT `FK31viftsw6kihfrdybimaj0r3d` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `FK7ca8sstytm1n5sg8if4qq2ph8` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.user_company: ~1 rows (approximately)
INSERT INTO `user_company` (`user_id`, `company_id`) VALUES
	('24379ed8-55c4-4981-ae88-26df52a43c0b', '5685bc6f-16a2-11f0-ab71-0242ac120002');

-- Dumping structure for table factorymanager.user_team
CREATE TABLE IF NOT EXISTS `user_team` (
  `user_id` varchar(255) NOT NULL,
  `team_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`team_id`),
  KEY `FK6d6agqknw564xtsa91d3259wu` (`team_id`),
  CONSTRAINT `FK6d6agqknw564xtsa91d3259wu` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKd6um0sk8hyytfq7oalt5a4nph` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.user_team: ~1 rows (approximately)
INSERT INTO `user_team` (`user_id`, `team_id`) VALUES
	('24379ed8-55c4-4981-ae88-26df52a43c0b', 'c6afbca0-16a2-11f0-ab71-0242ac120002');

-- Dumping structure for table factorymanager.user_token
CREATE TABLE IF NOT EXISTS `user_token` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `token` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `token_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `device_info` varchar(255) DEFAULT NULL,
  `issued_at` datetime(6) DEFAULT NULL,
  `expiry_at` datetime(6) DEFAULT NULL,
  `is_valid` bit(1) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKraru0qloxyh7wacxneiam2hi7` (`user_id`),
  CONSTRAINT `FKraru0qloxyh7wacxneiam2hi7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table factorymanager.user_token: ~2 rows (approximately)
INSERT INTO `user_token` (`id`, `user_id`, `token`, `token_type`, `device_info`, `issued_at`, `expiry_at`, `is_valid`, `created_at`, `updated_at`) VALUES
	('acc76f1b-2c88-4a84-8bea-964b578554f8', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwicmVtZW1iZXJNZSI6dHJ1ZSwiZXhwIjoxNzQ1NDgxNjc4LCJpYXQiOjE3NDQ4NzY4NzgsImp0aSI6IjFiMTZlZmUzLTdjMGUtNDQ5ZC05NGJhLWNiZGI3MDhmMWM1YSJ9.VtcTM9F1eg-3Uv5SEogLIyyX6TDxhM8Cw6kO3eoDin2J-Rc0Jv2siCwV9V3xYICKEW1Vsb_tkh4LvBFCRHFD_A', 'Bearer', 'WEB', '2025-04-17 15:01:18.435255', '2025-04-24 15:01:18.435255', b'1', '2025-04-17 15:01:18.435255', '2025-04-17 15:01:18.435255'),
	('e51fd782-ea5b-4f3a-8222-2a6cc50a2a2d', 'a23860b8-c088-4e53-a335-762b41ce2446', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZG1pbiIsInNjb3BlIjoiUk9MRV9TVVBFUl9BRE1JTiBWSUVXX0RBVEEgREVMRVRFX0RBVEEgQUREX0RBVEEgRURJVF9EQVRBIiwiaXNzIjoiU3ByaW5nQm9vdERhdGFiYXNlLmNvbSIsInJlbWVtYmVyTWUiOnRydWUsImV4cCI6MTc0NTQ3OTc2OSwiaWF0IjoxNzQ0ODc0OTY5LCJqdGkiOiI0MjkzZmU1NC1jMzI2LTQ0ZTEtYTU2ZC00Mzc0NGNjNTIyZDQifQ.AGQxrrvyyWqPGQSwb8jXSZxtTyDfU8Jnt0JLgI5m1txUOXXSMTw7CrGEUBrVgqQeE0OeJ7g0FPoZrlwWUSyiVQ', 'Bearer', 'WEB', '2025-04-17 14:29:30.027716', '2025-04-24 14:29:30.027716', b'1', '2025-04-17 14:29:30.027716', '2025-04-17 14:29:30.027716');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
