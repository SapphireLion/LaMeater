-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for meats
DROP DATABASE IF EXISTS `meats`;
CREATE DATABASE IF NOT EXISTS `meats` /*!40100 DEFAULT CHARACTER SET utf16 COLLATE utf16_bin */;
USE `meats`;

-- Dumping structure for table lameater.meats
DROP TABLE IF EXISTS `meats`;
CREATE TABLE IF NOT EXISTS `meats` (
  `MEATID` int NOT NULL,
  `NAME` varchar(10) COLLATE utf16_bin DEFAULT NULL,
  `CATEGORY` varchar(10) COLLATE utf16_bin DEFAULT NULL,
  `MINTEMP` int DEFAULT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf16_bin DEFAULT NULL,
  `DESIREDTEMP` int DEFAULT NULL,
   PRIMARY KEY (`MEATID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

-- Dumping data for table lameater.meats: ~139 rows (approximately)
/*!40000 ALTER TABLE `meats` DISABLE KEYS */;
INSERT INTO `meats` (`MEATID`, `NAME`, `CATEGORY`, `MINTEMP`, `DESCRIPTION`, `DESIREDTEMP`) VALUES
	(8131995,'Ribs','Beef',145,'The term 'Ribs' usually refers to the less meaty part of the chops, often cooked as a slab (not cut into separate ribs). They can be roasted, grilled, fried, baked, braised, or smoked.',0),
	(8131994,'Brisket','Beef',145,'Brisket is a cut of meat from the breast or lower chest of beef or veal. Brisket can be cooked many ways, including baking, boiling and roasting. Popular methods in the United States include rubbing with a spice rub or marinating the meat, then cooking slowly over indirect heat from charcoal or wood.',0),
	(8131996,'Ground Beef','Beef',160,'For the casual barbecue fan or the tailgater, burgers are a sure bet. Pair with fried potatoes for best results!',0),
	(8131997,'Steak','Beef',145,'Whether it is a casual grill or a fancy dinner date, this dish is best served off the grill!',0),
	(9141995,'Ribs','Pork',145,'The term Ribs usually refers to the less meaty part of the chops, often cooked as a slab (not cut into separate ribs). They can be roasted, grilled, fried, baked, braised, or smoked.',0),
	(9141996,'Loins','Pork',145,'Give me that pig!',0),
	(9141994,'Ham','Pork',145,'For use in sandwiches or family gatherings, why even buy a turkey?',0),
	(10311993,'Breast','Chicken',165,'Probably the most casual of meats.',0),
	(10311994,'Wings','Chicken',165,'Grill like a champion today!',0),
	(11171994,'Shrimp','Fish',145,'For the shellfish enthusiast.',0);
	
/*!40000 ALTER TABLE `meats` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;