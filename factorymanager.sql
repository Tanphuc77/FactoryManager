-- --------------------------------------------------------
-- Host:                         yamanote.proxy.rlwy.net
-- Server version:               9.3.0 - MySQL Community Server - GPL
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

-- Dumping structure for table railway.company
CREATE TABLE IF NOT EXISTS `company` (
  `id` varchar(255) NOT NULL,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `companyname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `subcontractor` bit(1) NOT NULL,
  `state` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` enum('ACTIVE','INACTIVE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mobile_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.company: ~15 rows (approximately)
INSERT INTO `company` (`id`, `code`, `companyname`, `subcontractor`, `state`, `status`, `contact_name`, `mobile_phone`, `address`, `create_at`, `update_at`, `created_at`, `updated_at`) VALUES
	('5685bc6f-16a2-11f0-ab71-0242ac120002', 'WH2', 'Market Paper', b'1', 'Victoria', 'ACTIVE', 'Jim John Lewis', '0401178604', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('5685ff4e-16a2-11f0-ab71-0242ac120002', 'WH10', 'Marterniy Khay', b'1', 'Victoria', 'ACTIVE', 'Dorothy Montgomery', '(02) 6170 0797', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('56860f20-16a2-11f0-ab71-0242ac120002', 'WH4', 'Leonave Devandi', b'1', 'New South Wales', 'ACTIVE', 'Jay Larson', '(02) 6124 7369', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('5686100e-16a2-11f0-ab71-0242ac120002', 'WH5', 'Engvie Flore', b'1', 'South Australia', 'ACTIVE', 'Allison Mitchell', '(02) 6130 6453', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('56861052-16a2-11f0-ab71-0242ac120002', 'WH6', 'Riverside Gardens', b'1', 'Western Australia', 'ACTIVE', 'Amy Morris', '(03) 2345 6789', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('56861091-16a2-11f0-ab71-0242ac120002', 'QS', 'Queen Stack', b'0', 'Tasmania', 'ACTIVE', 'Yvonne Foster', '(07) 3456 7890', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('568610ce-16a2-11f0-ab71-0242ac120002', 'QA', 'Queran Assitaert', b'1', 'South Australia', 'ACTIVE', 'Jessie Harper', '(08) 4567 8901', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('5686255a-16a2-11f0-ab71-0242ac120002', 'RE', 'Ringle Envested', b'1', 'South Australia', 'ACTIVE', 'Jesus Lowe', '0412 345 678', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('568626bb-16a2-11f0-ab71-0242ac120002', 'MA', 'Machartla Engvireal', b'1', 'South Australia', 'ACTIVE', 'Marshall Mcdaniel', '0423 456 789', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('5686271c-16a2-11f0-ab71-0242ac120002', 'TG', 'Tinghall Gall', b'1', 'Western Australia', 'ACTIVE', 'Marlene Cook', '(02) 2345 6789', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('5686285c-16a2-11f0-ab71-0242ac120002', 'SS', 'Superior Sheet', b'1', 'Tasmania', 'ACTIVE', 'Christopher Ward', '(02) 6543 2109', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('568628c2-16a2-11f0-ab71-0242ac120002', 'PS', 'Precision Sheet', b'1', 'Tasmania', 'ACTIVE', 'Henry Mitchell', '(02) 9876 5432', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('56862903-16a2-11f0-ab71-0242ac120002', 'MM', 'Master Metalworks', b'1', 'New South Wales', 'ACTIVE', 'Liam Cooper', '(02) 3456 7890', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('56862942-16a2-11f0-ab71-0242ac120002', 'SCI', 'SteelCraft Innovations', b'1', 'New South Wales', 'ACTIVE', 'Isaac Parker', '(02) 8765 4321', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL),
	('56862a40-16a2-11f0-ab71-0242ac120002', 'ASI', 'ApexSheet Industries', b'0', 'New South Wales', 'ACTIVE', 'Benjamin Hayes', '(02) 6543 2109', '', '2025-04-11 06:58:14.000000', '2025-04-11 06:58:14.000000', NULL, NULL);

-- Dumping structure for table railway.flyway_schema_history
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

-- Dumping data for table railway.flyway_schema_history: ~0 rows (approximately)

-- Dumping structure for table railway.permission
CREATE TABLE IF NOT EXISTS `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK2ojme20jpga3r4r79tdso17gi` (`name`),
  KEY `FKqp7umovkuakff1jilk6dp9l1x` (`group_id`),
  CONSTRAINT `FKqp7umovkuakff1jilk6dp9l1x` FOREIGN KEY (`group_id`) REFERENCES `permission_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.permission: ~5 rows (approximately)
INSERT INTO `permission` (`id`, `name`, `description`, `create_at`, `update_at`) VALUES
	(1, 'VIEW_DATA', 'View data list', '2025-04-16 06:45:07.000000', '2025-04-16 06:45:07.000000'),
	(2, 'ADD_DATA', 'Create data', '2025-04-16 06:45:07.000000', '2025-04-16 06:45:07.000000'),
	(3, 'EDIT_DATA', 'Update data', '2025-04-16 06:45:07.000000', '2025-04-16 06:45:07.000000'),
	(4, 'DELETE_DATA', 'delete data', '2025-04-16 06:45:07.000000', '2025-04-16 06:45:07.000000'),
	(9, 'VIEW_DASHBOARD', 'View dashboard system', '2025-04-16 06:45:07.000000', '2025-04-16 06:45:07.000000');

-- Dumping structure for table railway.permission_group
CREATE TABLE IF NOT EXISTS `permission_group` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK94ilfetvc2doipy2wavk1l9kc` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.permission_group: ~1 rows (approximately)
INSERT INTO `permission_group` (`id`, `name`, `description`, `create_at`, `update_at`) VALUES
	(1, 'User Manager', 'User Manager', '2025-04-24 14:40:47.000000', '2025-04-24 14:41:17.000000');

-- Dumping structure for table railway.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.role: ~4 rows (approximately)
INSERT INTO `role` (`id`, `name`, `description`, `create_at`, `update_at`) VALUES
	(1, 'SUPER_ADMIN', 'Toàn quyền hệ thống, bao gồm quản lý Admin', '2025-04-11 14:06:38.000000', '2025-04-11 14:06:38.000000'),
	(2, 'ADMIN', 'Quản lý nội dung hệ thống, không quản lý được các Admin khác', '2025-04-16 10:31:48.000000', '2025-04-17 08:32:03.000000'),
	(3, 'PRODUCTION_OFFICE', 'Quản lý thông tin và hoạt động văn phòng sản xuất', '2025-04-16 10:09:52.000000', '2025-04-16 10:13:52.000000'),
	(4, 'FACTORY_MANAGER', 'Quản lý tổng thể hoạt động sản xuất tại nhà máy', '2025-04-16 10:12:09.000000', '2025-04-17 08:32:04.000000');

-- Dumping structure for table railway.role_permission
CREATE TABLE IF NOT EXISTS `role_permission` (
  `role_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FKf8yllw1ecvwqy3ehyxawqa1qp` (`permission_id`),
  CONSTRAINT `FKa6jx8n8xkesmjmv6jqug6bg68` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKf8yllw1ecvwqy3ehyxawqa1qp` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.role_permission: ~5 rows (approximately)
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES
	(1, 1),
	(2, 1),
	(1, 2),
	(1, 3),
	(1, 4);

-- Dumping structure for table railway.team
CREATE TABLE IF NOT EXISTS `team` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.team: ~4 rows (approximately)
INSERT INTO `team` (`id`, `name`, `create_at`, `update_at`) VALUES
	('c6afbca0-16a2-11f0-ab71-0242ac120002', 'Engineering', '2025-04-11 07:01:22.000000', '2025-04-11 07:01:22.000000'),
	('c6afd552-16a2-11f0-ab71-0242ac120002', 'Marketing', '2025-04-11 07:01:22.000000', '2025-04-11 07:01:22.000000'),
	('c6afd950-16a2-11f0-ab71-0242ac120002', 'Sales', '2025-04-11 07:01:22.000000', '2025-04-11 07:01:22.000000'),
	('c6afda08-16a2-11f0-ab71-0242ac120002', 'Design', '2025-04-11 07:01:22.000000', '2025-04-11 07:01:22.000000');

-- Dumping structure for table railway.ui_config
CREATE TABLE IF NOT EXISTS `ui_config` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `screen_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `config_json` text NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoejxkcsq4hgrtxeylxrjyhufm` (`user_id`),
  CONSTRAINT `FKoejxkcsq4hgrtxeylxrjyhufm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.ui_config: ~0 rows (approximately)

-- Dumping structure for table railway.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(255) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `status` enum('ACTIVE','INACTIVE') NOT NULL,
  `project_manager` bit(1) NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `role_id` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.user: ~11 rows (approximately)
INSERT INTO `user` (`id`, `firstname`, `lastname`, `date_of_birth`, `username`, `password`, `status`, `project_manager`, `image`, `role_id`, `created_at`, `updated_at`) VALUES
	('24379ed8-55c4-4981-ae88-26df52a43c0b', 'Phuc', 'phan', '2003-04-24', 'phucphan', '$2a$10$U9DSa43wnb/5MciVqMKht.l.cbQKwEPlkDldqPDse5tYx/80uULD.', 'INACTIVE', b'0', NULL, 3, '2025-04-23 14:11:02.000000', '2025-04-24 14:23:13.676087'),
	('32d38a72-7726-49f8-bb54-a587b8b37759', 'dung', 'nguyen', '1990-04-12', 'quanab', '$2a$10$WfiR11HyOjLXMv.hy33QlutQ9gRoksCBudItcxoosuDUZWW/lLK.K', 'ACTIVE', b'0', 'upload/f7fd1314-417f-46fc-bd4b-46c9c755e9a1_photo-1633332755192-727a05c4013d.jpg', 3, '2025-04-23 14:11:04.000000', '2025-04-24 13:51:08.029258'),
	('a85f92d4-c7da-4cde-ae6a-a714445a4ab7', 'AAA', 'AAA', '2003-04-28', 'aaaaaaaa', '$2a$10$l5FXjV/V8mvHaGDENNLr6eFmWJCp5dcf6z.bl9kJC4TvrFjsAExN2', 'ACTIVE', b'0', NULL, 3, NULL, NULL),
	('afe16427-abda-4fd2-a78d-cf79294b4207', 'Quan', 'Trinh', '2003-04-28', 'quantrinh', '$2a$10$rDyLF6/o2YsyG1.VtwIGTeHGXpFKXXmQyW0rTy8PD7gRGaxzUiwFG', 'ACTIVE', b'0', 'upload\\3554d460-1541-4213-8bab-26cbe3d60619_d71bbef3-66c4-41f9-9412-0cc5da1dddb5.jpg', 3, '2025-04-23 14:11:07.000000', '2025-04-23 14:11:31.000000'),
	('c2027395-40ac-4349-ac21-bf088004cf6c', 'Quan', 'Trinh', '2003-04-28', 'quantrinhhung', '$2a$10$i.vMexZNwEVZUHjWpaxoS.gNSXGmAfJrs9Q6/P5IEXra4aZ6I7Yi.', 'INACTIVE', b'0', NULL, 3, '2025-04-23 14:11:08.000000', '2025-04-23 14:11:32.000000'),
	('c36bbeb5-3a75-494e-8726-00f43f718f96', 'Peter', 'Sigma', '2003-04-29', 'petersigma', '$2a$10$RTBRE4Ql/nWeMkg.O38wgujys1uokIJUMri1wT1EIuHg8rikhH8.G', 'ACTIVE', b'0', 'upload\\9fd86c9a-b5fc-47ae-8cd2-636a9696afe2_premium_photo-1683121366070-5ceb7e007a97.jpg', 3, '2025-04-23 14:11:10.000000', '2025-04-23 14:11:34.000000'),
	('d1a0dbf9-2214-4a36-8dad-f56fca11774f', 'Admin', 'Super', NULL, 'Admin', '$2a$10$/ssotrB2Rh5WGXfbnAzA2uA3XXMNjwDBc2qlf0FhxxhZGg3ZOB4EW', 'ACTIVE', b'1', NULL, 1, '2025-04-23 14:11:12.000000', '2025-04-23 14:11:33.000000'),
	('e0065989-1425-4144-92cc-471a560a5dfe', 'quan', 'nguyen', '2002-04-12', 'quannguyen', '$2a$10$U.cYBoQxuya7g2Qxhgu5/eVLXxjGN0TgoTkVzB164U4tDSkMZi7ti', 'ACTIVE', b'0', 'upload/a473d40f-72cc-4fa2-be2b-d26f8c1c2712_bd197972-17d5-474d-b176-9fde55861c7b.jpg', 2, '2025-04-23 14:11:13.000000', '2025-04-23 14:11:35.000000'),
	('ef1585cd-303e-4de8-8253-e961c267b49f', 'Quan', 'Trinh', '2003-04-28', 'qtrinh0204', '$2a$10$Iy/8uLZ53W.RybQT2NeoB.a7DZxGIWHVLxDxym/aPFS6RAfUVtjnC', 'INACTIVE', b'0', 'upload\\d9486ea6-71fe-4654-9378-d089d822fa9d_d71bbef3-66c4-41f9-9412-0cc5da1dddb5.jpg', 3, '2025-04-23 14:11:14.000000', '2025-04-23 14:11:37.000000'),
	('f90d36d8-31ca-4517-ae44-f6c1f5a2a065', 'Quan', 'Trinh', '2003-04-01', 'trinhhungquan', '$2a$10$zADCExyR5q3hnDrfR5xpxO.AW7I1rDLESrbl92pVcPTQqOOMGObf.', 'INACTIVE', b'0', NULL, 3, '2025-04-23 14:11:15.000000', '2025-04-23 14:11:38.000000'),
	('fe8b4f62-9b01-4e08-a778-50a431d74468', 'dung', 'Trinh', '2003-04-28', 'dungtrinh', '$2a$10$O8l7T1pHE6PmKZoqOOL2s.2iJhU15sL3pjlAw09udN5iyhht00l8K', 'ACTIVE', b'0', NULL, 3, '2025-04-24 11:14:08.620355', '2025-04-24 13:48:04.257651');

-- Dumping structure for table railway.user_company
CREATE TABLE IF NOT EXISTS `user_company` (
  `user_id` varchar(255) NOT NULL,
  `company_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`company_id`),
  KEY `FK31viftsw6kihfrdybimaj0r3d` (`company_id`),
  CONSTRAINT `FK31viftsw6kihfrdybimaj0r3d` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `FK7ca8sstytm1n5sg8if4qq2ph8` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.user_company: ~14 rows (approximately)
INSERT INTO `user_company` (`user_id`, `company_id`) VALUES
	('24379ed8-55c4-4981-ae88-26df52a43c0b', '5685bc6f-16a2-11f0-ab71-0242ac120002'),
	('32d38a72-7726-49f8-bb54-a587b8b37759', '5685bc6f-16a2-11f0-ab71-0242ac120002'),
	('e0065989-1425-4144-92cc-471a560a5dfe', '5685bc6f-16a2-11f0-ab71-0242ac120002'),
	('a85f92d4-c7da-4cde-ae6a-a714445a4ab7', '56861091-16a2-11f0-ab71-0242ac120002'),
	('afe16427-abda-4fd2-a78d-cf79294b4207', '56861091-16a2-11f0-ab71-0242ac120002'),
	('c36bbeb5-3a75-494e-8726-00f43f718f96', '56861091-16a2-11f0-ab71-0242ac120002'),
	('c36bbeb5-3a75-494e-8726-00f43f718f96', '568610ce-16a2-11f0-ab71-0242ac120002'),
	('f90d36d8-31ca-4517-ae44-f6c1f5a2a065', '568610ce-16a2-11f0-ab71-0242ac120002'),
	('fe8b4f62-9b01-4e08-a778-50a431d74468', '568610ce-16a2-11f0-ab71-0242ac120002'),
	('c2027395-40ac-4349-ac21-bf088004cf6c', '5686255a-16a2-11f0-ab71-0242ac120002'),
	('ef1585cd-303e-4de8-8253-e961c267b49f', '5686255a-16a2-11f0-ab71-0242ac120002'),
	('f90d36d8-31ca-4517-ae44-f6c1f5a2a065', '5686255a-16a2-11f0-ab71-0242ac120002'),
	('fe8b4f62-9b01-4e08-a778-50a431d74468', '5686255a-16a2-11f0-ab71-0242ac120002'),
	('24379ed8-55c4-4981-ae88-26df52a43c0b', '568628c2-16a2-11f0-ab71-0242ac120002');

-- Dumping structure for table railway.user_team
CREATE TABLE IF NOT EXISTS `user_team` (
  `user_id` varchar(255) NOT NULL,
  `team_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`team_id`),
  KEY `FK6d6agqknw564xtsa91d3259wu` (`team_id`),
  CONSTRAINT `FK6d6agqknw564xtsa91d3259wu` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKd6um0sk8hyytfq7oalt5a4nph` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table railway.user_team: ~14 rows (approximately)
INSERT INTO `user_team` (`user_id`, `team_id`) VALUES
	('24379ed8-55c4-4981-ae88-26df52a43c0b', 'c6afbca0-16a2-11f0-ab71-0242ac120002'),
	('32d38a72-7726-49f8-bb54-a587b8b37759', 'c6afbca0-16a2-11f0-ab71-0242ac120002'),
	('c36bbeb5-3a75-494e-8726-00f43f718f96', 'c6afbca0-16a2-11f0-ab71-0242ac120002'),
	('e0065989-1425-4144-92cc-471a560a5dfe', 'c6afbca0-16a2-11f0-ab71-0242ac120002'),
	('a85f92d4-c7da-4cde-ae6a-a714445a4ab7', 'c6afd552-16a2-11f0-ab71-0242ac120002'),
	('c2027395-40ac-4349-ac21-bf088004cf6c', 'c6afd552-16a2-11f0-ab71-0242ac120002'),
	('c36bbeb5-3a75-494e-8726-00f43f718f96', 'c6afd552-16a2-11f0-ab71-0242ac120002'),
	('ef1585cd-303e-4de8-8253-e961c267b49f', 'c6afd552-16a2-11f0-ab71-0242ac120002'),
	('f90d36d8-31ca-4517-ae44-f6c1f5a2a065', 'c6afd552-16a2-11f0-ab71-0242ac120002'),
	('fe8b4f62-9b01-4e08-a778-50a431d74468', 'c6afd552-16a2-11f0-ab71-0242ac120002'),
	('f90d36d8-31ca-4517-ae44-f6c1f5a2a065', 'c6afd950-16a2-11f0-ab71-0242ac120002'),
	('fe8b4f62-9b01-4e08-a778-50a431d74468', 'c6afd950-16a2-11f0-ab71-0242ac120002'),
	('24379ed8-55c4-4981-ae88-26df52a43c0b', 'c6afda08-16a2-11f0-ab71-0242ac120002'),
	('afe16427-abda-4fd2-a78d-cf79294b4207', 'c6afda08-16a2-11f0-ab71-0242ac120002');

-- Dumping structure for table railway.user_token
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

-- Dumping data for table railway.user_token: ~21 rows (approximately)
INSERT INTO `user_token` (`id`, `user_id`, `token`, `token_type`, `device_info`, `issued_at`, `expiry_at`, `is_valid`, `created_at`, `updated_at`) VALUES
	('049b4121-bf13-48b2-8ba2-4ac0ec589bf6', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ2MDY0MTY3LCJpYXQiOjE3NDU0NTkzNjcsImp0aSI6ImRlZWRiNTU4LTcxMGUtNGI4MC1iMGE5LTQ5ZTE0YTRjOTgxMSJ9.lMI4scr_uqLcR03usvFTIhl3YBYYSm21lFvkpBcXS3jLxX-o2Kj6Biu9hNIt8ohz2dX-JKeRch8IWanliokNwg', 'Bearer', 'WEB', '2025-04-24 08:49:27.095341', '2025-05-01 08:49:27.095341', b'0', '2025-04-24 08:49:27.095341', '2025-04-24 08:49:27.095341'),
	('06a0f28e-3eb9-43f2-98e4-2f87ccd67d06', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ2MDAxMzY2LCJpYXQiOjE3NDUzOTY1NjYsImp0aSI6IjQ1YjQ2NTY2LTJlNTktNDc1MC1hMDBjLWU3NThlYjM4ZjY1YSJ9.P6SGbsbJl8fXdTd6gr2tHoqg2ilphvj2ynkQYLPqmDgI6VJhZKK7sY7Q0IZBmRLZeJcIkI6ndeMimM1Gxy7QMA', 'Bearer', 'WEB', '2025-04-23 15:22:46.659881', '2025-04-30 15:22:46.659881', b'0', '2025-04-23 15:22:46.659881', '2025-04-23 15:22:46.659881'),
	('1a0af8b0-7b64-47b2-bc5e-2b5dbb4ca57c', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwicmVtZW1iZXJNZSI6ZmFsc2UsImV4cCI6MTc0NTM5MzA3NCwiaWF0IjoxNzQ1MzA2Njc0LCJqdGkiOiIxZGNmNTZkOS1mNDg2LTQ4YmItYjA5MS04Y2I5ZGM2OGQwNTUifQ.Gur2Aowk5oaHbQXrV1BcvLNQXkzMvLMjx5_DZrKVBxS8jhR8qyF2hfRm3bv8xnHnqS94e6uNidf9iuXFpg1TBw', 'Bearer', 'WEB', '2025-04-22 14:24:34.798591', '2025-04-23 14:24:34.798591', b'0', '2025-04-22 14:24:34.798591', '2025-04-22 14:24:34.798591'),
	('20fe487f-3fac-4647-960f-f6632cc6586f', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ2MDY0NzA0LCJpYXQiOjE3NDU0NTk5MDQsImp0aSI6IjQ3NjNjZGJiLTA2MjItNGIxYS1iZWY5LTEwYmFhOWIzYzVmMyJ9.l1VoEvNArAhGV3Lb9Gq_kNssTYEdx_wjHegkpdCFdA8xcrdmbim1pwnfSr0mtkg-ryUxTYM-7Buj-czecaXWvQ', 'Bearer', 'WEB', '2025-04-24 08:58:24.851324', '2025-05-01 08:58:24.851324', b'1', '2025-04-24 08:58:24.851324', '2025-04-24 08:58:24.851324'),
	('24e05fe9-cddc-4a80-8b92-c53aff8893c5', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwicmVtZW1iZXJNZSI6ZmFsc2UsImV4cCI6MTc0NTM5MTk4MiwiaWF0IjoxNzQ1MzA1NTgyLCJqdGkiOiIwMDBkNjA2Yy0zN2Q1LTQ1MzEtYWU2YS0wNjhjYmQ3ZTgxNTEifQ._LvAh0SG2nYicA1m9fOlr-txmtuGeAjjXg-lKfAw7fadqQVDaN2X0qBWa0P3wmki6CVXwifbK5BNdOpLiRqx4A', 'Bearer', 'WEB', '2025-04-22 14:06:22.147289', '2025-04-23 14:06:22.147289', b'0', '2025-04-22 14:06:22.147289', '2025-04-22 14:24:19.266379'),
	('2ba7d21c-c4d8-43f3-a3a2-88cbcb6fdf97', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwicmVtZW1iZXJNZSI6ZmFsc2UsImV4cCI6MTc0NTMzMDQ1NCwiaWF0IjoxNzQ1MjQ0MDU0LCJqdGkiOiJmN2RhMmM2ZC1iNDAxLTRmMDktOGU4My04YTQzOGY5ODBhMmUifQ.hx1OxU2fgW_9qP1JVdPIu4GQZ8IT2_IlyYhrp1P_uQV3lzZaeUykPnNu8XlLYxkGQbQ-LCSq7wFmPWFU1pBIHQ', 'Bearer', 'WEB', '2025-04-21 21:00:54.573774', '2025-04-22 21:00:54.573774', b'0', '2025-04-21 21:00:54.573774', '2025-04-22 14:05:55.926085'),
	('3d27c0ba-046d-4e87-a960-3708fdf6296b', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ1OTc5MDUzLCJpYXQiOjE3NDUzNzQyNTMsImp0aSI6Ijc1ZjQ3ZWE2LTliMmItNGQ3Yy1iNGJjLWE4MjY1MTI0ZDAxNiJ9.7E59paW_fOtv-Qkbt3OkI64M8ES3jcplEGQSEpIxVLxrmlTIWfqmdPPPaijd70pn5P3O6vPDWx-xeQj7ClVg_w', 'Bearer', 'WEB', '2025-04-23 09:10:53.991691', '2025-04-30 09:10:53.991691', b'0', '2025-04-23 09:10:53.991691', '2025-04-23 09:10:53.991691'),
	('3fe71aab-c09b-4b97-84c6-511a624a8114', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ2MDYzMTMwLCJpYXQiOjE3NDU0NTgzMzAsImp0aSI6ImYzNzFkMmUwLWVkNjktNGMxNS05YjM4LWZhOTkwNmJjMzM3ZCJ9.0DG-5TC5lvEtiJFn1DvnuwBSvwy2oGbuQ_MW7EMD7NqsRzkAMHxOmbExY9jyu7EqMO0t5FSyLOgMGiPnzsj9dg', 'Bearer', 'WEB', '2025-04-24 08:32:10.749862', '2025-05-01 08:32:10.749862', b'0', '2025-04-24 08:32:10.749862', '2025-04-24 08:32:10.749862'),
	('4e5275a6-1505-4956-9e46-b2758792fae9', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ2MDAzNzczLCJpYXQiOjE3NDUzOTg5NzMsImp0aSI6IjBiOGVjNGU1LTk5ODMtNGYxMi05MTk3LTA3Y2Q3NzNkZDBhNSJ9.rh60v6P5SBKf6DOpYYF_NJlVJ7xESwrvLDpwo36Sgp-9Yfi-DBAsdv-0XMzde6j-1sPwN8_eNVxl3so6z9TIFA', 'Bearer', 'WEB', '2025-04-23 16:02:53.760142', '2025-04-30 16:02:53.760142', b'0', '2025-04-23 16:02:53.760142', '2025-04-23 16:02:53.760142'),
	('7438c715-3dca-4337-ac9b-4b3735dae405', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwicmVtZW1iZXJNZSI6ZmFsc2UsImV4cCI6MTc0NTMwNzg2MSwiaWF0IjoxNzQ1MjIxNDYxLCJqdGkiOiI0NzQzYWQ4Ni03Yzg5LTQ4M2EtYjU3ZS05MzIzODZkMDI4ZjIifQ.DhSX4oeLDpDI3q4zX_UF1e3upRwadAfHuzLdF5k3MubRNM08sj48AS4Rut6UoPO4SaS0CgoWHlNFBP6fzbhy_A', 'Bearer', 'WEB', '2025-04-21 14:44:21.479086', '2025-04-22 14:44:21.479086', b'0', '2025-04-21 14:44:21.479086', '2025-04-21 20:55:01.357739'),
	('80229019-3182-4332-b808-263552bfc4b8', 'c2027395-40ac-4349-ac21-bf088004cf6c', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJxdWFudHJpbmhodW5nIiwic2NvcGUiOiJST0xFX1BST0RVQ1RJT05fT0ZGSUNFIiwiaXNzIjoiU3ByaW5nQm9vdERhdGFiYXNlLmNvbSIsImV4cCI6MTc0NjAwNDAyMCwiaWF0IjoxNzQ1Mzk5MjIwLCJqdGkiOiJhNmQ5OTk2NC03ZTE2LTRlMjgtOTI3MS05ZWZjNmUxZTExZWQifQ.7o_v-wi5zcdYWKcUp6l_Zx15yM2iwlf00uRAdE6rTYX-ffsLh57kIUfSIbf0nL1NHQoEzNCmQB5jBBjXdBqIqQ', 'Bearer', 'WEB', '2025-04-23 16:07:00.874104', '2025-04-30 16:07:00.874104', b'1', '2025-04-23 16:07:00.874104', '2025-04-23 16:07:00.874104'),
	('818c81b6-7d9f-4668-8bae-aaaf428b4275', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ1OTc4MzA0LCJpYXQiOjE3NDUzNzM1MDQsImp0aSI6IjM1NzUyMmY4LWRkOTQtNGZmMC05YTk1LThkNjQ0ODFhNDZhNSJ9.kGw5ykFX1Gr6WBNyVw7Uxz1ib4MUgj2ol033s_ZOr5QQBT7hOcmGDxmpHSOz1w6vhE0eZ8NTa5alYPOFOA6c8g', 'Bearer', 'WEB', '2025-04-23 08:58:24.499901', '2025-04-30 08:58:24.499901', b'0', '2025-04-23 08:58:24.499901', '2025-04-23 08:58:24.499901'),
	('96816c58-b2a9-4e4a-8f2c-13cf27d35534', 'd1a0dbf9-2214-4a36-8dad-f56fca11774f', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZG1pbiIsInNjb3BlIjoiUk9MRV9TVVBFUl9BRE1JTiBWSUVXX0RBVEEgREVMRVRFX0RBVEEgQUREX0RBVEEgRURJVF9EQVRBIiwiaXNzIjoiU3ByaW5nQm9vdERhdGFiYXNlLmNvbSIsImV4cCI6MTc0NjA3MjQ2MywiaWF0IjoxNzQ1NDY3NjYzLCJqdGkiOiJiMTNjZTRmYy05YTQzLTRlZDEtYTIxZi1mNzkwY2MwMmQ5ZTQifQ.msoR-rsoFOdjooiU-PRLW30pTHuEN80KOHCL-RQJ6lvUAZl6acBqc2k2V0m_lMw8O59Oo53Eos7Af56HqLcSSQ', 'Bearer', 'WEB', '2025-04-24 11:07:43.408698', '2025-05-01 11:07:43.408698', b'0', '2025-04-24 11:07:43.408698', '2025-04-24 11:07:43.408698'),
	('a260b43d-ddf9-49f4-9525-6a657fc3e65a', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ2MDA0OTM4LCJpYXQiOjE3NDU0MDAxMzgsImp0aSI6IjFlNGRkZDVmLWEzMDAtNDc0NC04NzhiLWNhYWM5ZGYzM2QzMiJ9.n9N_-R86M5DdCOB0JtivxiTYgTHEguaTpV5tx8hnCRQcg8nY10QG0TPeDAWIwASXIaJ6mvWN08csFf0caTHbyA', 'Bearer', 'WEB', '2025-04-23 16:22:18.916243', '2025-04-30 16:22:18.916243', b'0', '2025-04-23 16:22:18.916243', '2025-04-23 16:22:18.916243'),
	('adcd8a2f-0e4d-426b-b407-9221cfb93191', 'd1a0dbf9-2214-4a36-8dad-f56fca11774f', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZG1pbiIsInNjb3BlIjoiUk9MRV9TVVBFUl9BRE1JTiBWSUVXX0RBVEEgREVMRVRFX0RBVEEgQUREX0RBVEEgRURJVF9EQVRBIiwiaXNzIjoiU3ByaW5nQm9vdERhdGFiYXNlLmNvbSIsImV4cCI6MTc0NjAwMTMwMywiaWF0IjoxNzQ1Mzk2NTAzLCJqdGkiOiIyZDVjNjczYS01NDM2LTQ5NTEtOThkOC1lNjJlNjQ2YzkzN2MifQ.qzRJcaRODsPfIwiVvOkoG58AuOHzoFCmaiRIvNf8trFgP-lE7pEI7TXsHP3oZIDXspt02J3VTar1pzETfq_PnA', 'Bearer', 'WEB', '2025-04-23 15:21:43.320692', '2025-04-30 15:21:43.320692', b'0', '2025-04-23 15:21:43.320692', '2025-04-23 15:21:43.320692'),
	('c2e23b02-9214-422e-802c-2a17f24fb8e0', 'd1a0dbf9-2214-4a36-8dad-f56fca11774f', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZG1pbiIsInNjb3BlIjoiUk9MRV9TVVBFUl9BRE1JTiBWSUVXX0RBVEEgREVMRVRFX0RBVEEgQUREX0RBVEEgRURJVF9EQVRBIiwiaXNzIjoiU3ByaW5nQm9vdERhdGFiYXNlLmNvbSIsImV4cCI6MTc0NjA3Mzc2NiwiaWF0IjoxNzQ1NDY4OTY2LCJqdGkiOiJlNGVlODEyMy1hMTlmLTQwMTQtYTcyMy0zODhlMDY1ZDU4YjgifQ.JV_R-06W4bhUt6HAm22pIZr7BoFuwtu95Y54vhTwD1y7GGoh4By4HEeROxkP7DSxRnSpCpvcTu_TSx4o3qbvcw', 'Bearer', 'WEB', '2025-04-24 11:29:26.992914', '2025-05-01 11:29:26.992914', b'1', '2025-04-24 11:29:26.992914', '2025-04-24 11:29:26.992914'),
	('c3311ae1-d4d4-4a0f-99dc-a3c21259e25a', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ1OTMwNDY5LCJpYXQiOjE3NDUzMjU2NjksImp0aSI6IjdmNWU2MjU4LWZjZmEtNDExYy05MTMzLTYyZWMyZTEyZTZjYyJ9.WifVEPZkQdSgIHxNMDkfaOgYsiStywbUoTjRAhFZKDYWPDI8Vmi1VG4avBZm9vPAReDUVxJc8LH-SSmKpPftng', 'Bearer', 'WEB', '2025-04-22 19:41:09.649040', '2025-04-29 19:41:09.649040', b'0', '2025-04-22 19:41:09.649040', '2025-04-23 08:58:10.958352'),
	('c77cc49d-d2bc-46dc-abb1-b160d0635a51', 'd1a0dbf9-2214-4a36-8dad-f56fca11774f', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZG1pbiIsInNjb3BlIjoiUk9MRV9TVVBFUl9BRE1JTiBWSUVXX0RBVEEgREVMRVRFX0RBVEEgQUREX0RBVEEgRURJVF9EQVRBIiwiaXNzIjoiU3ByaW5nQm9vdERhdGFiYXNlLmNvbSIsImV4cCI6MTc0NTk4Mjg0MCwiaWF0IjoxNzQ1Mzc4MDQwLCJqdGkiOiIzODVhMjcxMS1kZTU1LTQ2MmYtYTk4Ni0wNWQyZjllY2UyNjMifQ.uTaC8ts1hMCyz8whWnlKW4A3qSnTXnZhK-41rQPOggzWmyv0s-F4wwBoVp7oDiNsvF_4KNGcNPqUwnac_Rr58Q', 'Bearer', 'WEB', '2025-04-23 10:14:00.438069', '2025-04-30 10:14:00.438069', b'0', '2025-04-23 10:14:00.438069', '2025-04-23 10:14:00.438069'),
	('ccd75fb6-6635-4488-a548-31ae19cce995', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwicmVtZW1iZXJNZSI6ZmFsc2UsImV4cCI6MTc0NTM5MTk2MywiaWF0IjoxNzQ1MzA1NTYzLCJqdGkiOiJmZjkwODE1ZC0xMDJiLTQ5ZGEtYjQyMy04NTI0MzUzMDY2YjMifQ.r9T7r44LT3vqSlULIga6oLKyyEUALKjONnQ0ZUtsvV0C7SNeOKtCu76jVzpUvawZY57Zv6R6SfHFKUQzTTggmA', 'Bearer', 'WEB', '2025-04-22 14:06:03.922870', '2025-04-23 14:06:03.922870', b'0', '2025-04-22 14:06:03.922870', '2025-04-22 14:06:03.922870'),
	('d13d2bea-c689-4729-98d8-651da32545a7', '24379ed8-55c4-4981-ae88-26df52a43c0b', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aG9uZ25ndXllbiIsInNjb3BlIjoiUk9MRV9BRE1JTiBWSUVXX0RBVEEiLCJpc3MiOiJTcHJpbmdCb290RGF0YWJhc2UuY29tIiwiZXhwIjoxNzQ1OTk1NjEzLCJpYXQiOjE3NDUzOTA4MTMsImp0aSI6IjJjYWRiMjBkLTE2MTktNDExNS1hYjAyLWFjZDNmNWQ4M2YwNyJ9.gyRWI4RrNiSB7fad-G3rzpejdrV4ZESe5q7R2MjCQ0QRyK9dtsbLodCscN0TlDDRcNqjJZvOt-OsnZvnzdozNg', 'Bearer', 'WEB', '2025-04-23 13:46:53.938286', '2025-04-30 13:46:53.939287', b'0', '2025-04-23 13:46:53.939287', '2025-04-23 13:46:53.939287'),
	('e4fd088b-c11b-41fe-8a2b-2a4a0bce6006', 'd1a0dbf9-2214-4a36-8dad-f56fca11774f', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZG1pbiIsInNjb3BlIjoiUk9MRV9TVVBFUl9BRE1JTiBWSUVXX0RBVEEgREVMRVRFX0RBVEEgQUREX0RBVEEgRURJVF9EQVRBIiwiaXNzIjoiU3ByaW5nQm9vdERhdGFiYXNlLmNvbSIsImV4cCI6MTc0NjA3Mjk5MSwiaWF0IjoxNzQ1NDY4MTkxLCJqdGkiOiJkOWQ3ZGUyNy1hZjFjLTRiZWYtODFiYi1mZDMzZjk2M2VhOGYifQ.Q01cPwIt8kPcj7s5ZWH7HTmxN8Q28rmENRYRosDqFx7HhwjneZ4D-fewchfj8oSh7DMzIx8OlqMIp97aatZZbA', 'Bearer', 'WEB', '2025-04-24 11:16:31.901636', '2025-05-01 11:16:31.901636', b'0', '2025-04-24 11:16:31.901636', '2025-04-24 11:16:31.901636');

-- Dumping structure for trigger railway.trg_prevent_super_admin
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `trg_prevent_super_admin` BEFORE INSERT ON `user` FOR EACH ROW BEGIN
    IF NEW.role_id = '1' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot assign SUPER_ADMIN role directly.';
    END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger railway.trg_prevent_super_admin_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `trg_prevent_super_admin_update` BEFORE UPDATE ON `user` FOR EACH ROW BEGIN
    IF NEW.role_id = '1' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot assign SUPER_ADMIN role directly (update).';
    END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;