-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 11, 2016 at 10:08 AM
-- Server version: 5.6.27-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `EgenRestaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_detail`
--

CREATE TABLE IF NOT EXISTS `customer_detail` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_firstname` varchar(100) COLLATE utf8_bin NOT NULL,
  `customer_lastname` varchar(100) COLLATE utf8_bin NOT NULL,
  `customer_phone` varchar(100) COLLATE utf8_bin NOT NULL,
  `customer_email` varchar(100) COLLATE utf8_bin NOT NULL,
  `customer_streetAddress` varchar(100) COLLATE utf8_bin NOT NULL,
  `customer_suiteAddress` varchar(10) COLLATE utf8_bin NOT NULL,
  `customer_city` varchar(100) COLLATE utf8_bin NOT NULL,
  `customer_state` varchar(100) COLLATE utf8_bin NOT NULL,
  `customer_zip` int(10) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=25 ;

--
-- Dumping data for table `customer_detail`
--

INSERT INTO `customer_detail` (`customer_id`, `customer_firstname`, `customer_lastname`, `customer_phone`, `customer_email`, `customer_streetAddress`, `customer_suiteAddress`, `customer_city`, `customer_state`, `customer_zip`) VALUES
(1, '', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(2, 'Swethaa', 'Murthyy', '3617201234', 'swethamurthy@outlook.com', '1100, W Corral Ave,', 'Apt 36', 'Kingsville', 'TX', 78363),
(3, 'Prayank', 'Shah', '3617200234', 'prayankshah@outlook.com', '1100, W Corral Ave,', 'Apt 155', 'Kingsville', 'TX', 78363),
(4, 'Sumukha', 'Prasanna', '3617200711', 'sumukhaprasanna@outlook.com', '1100, W Corral Ave,', 'Apt 145', 'Kingsville', 'TX', 78363),
(5, 'Priyanka', 'Ramavat', '9876354208', 'priyanka.ramavat@swetha.com', '1100 W Corral Ave', 'Apt 36', 'Kingsville', 'TX', 78363),
(6, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(7, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(8, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(9, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(10, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(11, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(12, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(13, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(14, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(15, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(16, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(17, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(18, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(19, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(20, 'Aditya Sai Chandra', 'Atkuri', '3614604260', 'adityaatkuri@gmail.com', '855 N. UNIVERSITY BLVD, LEWIS HALL, ROOM-234', '12', 'KINGSVILLE', 'Texas', 78363),
(21, 'Aditya Sai Chandra', 'Atkuri', '3614604260', 'adityaatkuri@gmail.com', '855 N. UNIVERSITY BLVD, LEWIS HALL, ROOM-234', '12', 'KINGSVILLE', 'Texas', 78363),
(22, 'Dhiraj', 'Sharma', '3617200771', 'dhirajksharma@outlook.com', '1100, W Corral Ave,', 'Apt 154', 'Kingsville', 'TX', 78363),
(23, 'DHIRAJ KUMAR', 'SHARMA', '3614604260', 'dhiraj.sharma@students.tamuk.edu', '700, University Blvd, Lewis Hall 233', '223', 'Kingsville', 'Texas', 78363),
(24, 'DHIRAJ KUMAR', 'SHARMA', '3614604260', 'dhiraj.sharma@students.tamuk.edu', '700, University Blvd, Lewis Hall 233', '12', 'Kingsville', 'Texas', 78363);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `reservation_id` int(10) NOT NULL AUTO_INCREMENT,
  `reservation_occasion` varchar(100) COLLATE utf8_bin NOT NULL,
  `reservation_start_date` date NOT NULL,
  `reservation_end_date` date NOT NULL,
  `reservation_start_time` time NOT NULL,
  `reservation_end_time` time NOT NULL,
  `reservation_party_size` varchar(100) COLLATE utf8_bin NOT NULL,
  `reservation_additional_details` varchar(100) COLLATE utf8_bin NOT NULL,
  `customer_id` int(10) NOT NULL,
  `reservation_bookedBy` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1020 ;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`reservation_id`, `reservation_occasion`, `reservation_start_date`, `reservation_end_date`, `reservation_start_time`, `reservation_end_time`, `reservation_party_size`, `reservation_additional_details`, `customer_id`, `reservation_bookedBy`) VALUES
(1001, 'Birthdayyyyyyyyyyyy', '2016-01-27', '2016-01-06', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 1, 'DHIRAJS'),
(1002, 'Birthdayyyyyyyyy', '2016-01-07', '2016-01-07', '12:00:00', '16:00:00', '10', 'Cake Needed', 2, 'Customer'),
(1004, 'Graduation', '2016-01-11', '2016-01-11', '10:30:00', '16:30:00', '20', '', 3, 'Customer'),
(1005, 'Reunion', '2016-01-12', '2016-01-12', '12:30:00', '21:30:00', '20', '', 4, 'Customer'),
(1007, 'Anniversary', '2016-01-13', '2016-01-13', '17:00:00', '18:00:00', '2', 'Water only', 5, 'Customer'),
(1008, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 10, 'Admin'),
(1009, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 11, 'Admin'),
(1010, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 12, 'Admin'),
(1011, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 13, 'Admin'),
(1012, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 14, 'Admin'),
(1013, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 15, 'Admin'),
(1014, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 16, 'Admin'),
(1015, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 17, 'Admin'),
(1016, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 18, 'Admin'),
(1017, 'Birthday', '2016-01-31', '2016-01-10', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 19, 'Admin'),
(1018, 'Birthdayyyyyyyyyyyy', '2016-01-28', '2016-01-07', '11:00:00', '16:00:00', '20', 'Need Birthday Cake', 22, 'DHIRAJS'),
(1019, 'aA', '2016-01-10', '2016-01-10', '11:55:00', '20:40:00', '23', '', 24, 'Customer');

-- --------------------------------------------------------

--
-- Table structure for table `reservation_codes`
--

CREATE TABLE IF NOT EXISTS `reservation_codes` (
  `reservation_id` int(10) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `confirmation_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  UNIQUE KEY `confirmation_code` (`confirmation_code`),
  KEY `customer_id` (`customer_id`),
  KEY `reservation_id` (`reservation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation_codes`
--

INSERT INTO `reservation_codes` (`reservation_id`, `customer_id`, `confirmation_code`) VALUES
(1018, 22, '6W94UGP12JRI'),
(1019, 24, '7ICA49SQRM6O'),
(1017, 19, '95SL4U3YF6WR'),
(1001, 1, 'DhirajSharma'),
(1016, 18, 'PM9812TAULDY'),
(1004, 3, 'PrayankShah'),
(1005, 4, 'SumukhaPrasanna'),
(1002, 2, 'SwethaMurthy'),
(1015, 17, 'XOW8ZHMTSURB');

-- --------------------------------------------------------

--
-- Table structure for table `reservation_status`
--

CREATE TABLE IF NOT EXISTS `reservation_status` (
  `srno` int(10) NOT NULL AUTO_INCREMENT,
  `reservation_id` int(10) NOT NULL,
  `reservation_status` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`srno`),
  KEY `reservation_id` (`reservation_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `reservation_status`
--

INSERT INTO `reservation_status` (`srno`, `reservation_id`, `reservation_status`) VALUES
(6, 1001, 'CANCELLED'),
(7, 1002, 'Waiting'),
(8, 1004, 'Waiting'),
(9, 1005, 'Confirmed'),
(10, 1015, 'WAITING'),
(11, 1016, 'WAITING'),
(12, 1017, 'WAITING'),
(13, 1018, 'WAITING'),
(14, 1019, 'WAITING');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_timings`
--

CREATE TABLE IF NOT EXISTS `restaurant_timings` (
  `srno` int(10) NOT NULL AUTO_INCREMENT,
  `restaurant_workingDate` date NOT NULL,
  `restaurant_openingTime` time NOT NULL,
  `restaurant_closingTime` time NOT NULL,
  PRIMARY KEY (`srno`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Dumping data for table `restaurant_timings`
--

INSERT INTO `restaurant_timings` (`srno`, `restaurant_workingDate`, `restaurant_openingTime`, `restaurant_closingTime`) VALUES
(1, '2016-01-11', '09:00:00', '22:00:00'),
(2, '2016-01-12', '09:00:00', '22:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `table_detail`
--

CREATE TABLE IF NOT EXISTS `table_detail` (
  `table_number` int(10) NOT NULL AUTO_INCREMENT,
  `table_size` int(10) NOT NULL,
  PRIMARY KEY (`table_number`),
  UNIQUE KEY `table_number` (`table_number`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7017 ;

--
-- Dumping data for table `table_detail`
--

INSERT INTO `table_detail` (`table_number`, `table_size`) VALUES
(7001, 5),
(7002, 10),
(7003, 10),
(7004, 10),
(7005, 5),
(7007, 4),
(7008, 6),
(7009, 2),
(7010, 2),
(7011, 4),
(7012, 6),
(7013, 10),
(7014, 6),
(7015, 20),
(7016, 20);

-- --------------------------------------------------------

--
-- Table structure for table `table_status`
--

CREATE TABLE IF NOT EXISTS `table_status` (
  `srno` int(10) NOT NULL AUTO_INCREMENT,
  `table_number` int(10) NOT NULL,
  `reservation_id` int(10) NOT NULL,
  PRIMARY KEY (`srno`),
  KEY `table_number` (`table_number`),
  KEY `reservation_id` (`reservation_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `table_status`
--

INSERT INTO `table_status` (`srno`, `table_number`, `reservation_id`) VALUES
(1, 7015, 1001),
(2, 7002, 1002),
(3, 7015, 1004),
(4, 7016, 1005);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `user_email`, `user_password`) VALUES
(1, 'admin', 'admin@admin.com', 'admin123');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer_detail` (`customer_id`);

--
-- Constraints for table `reservation_codes`
--
ALTER TABLE `reservation_codes`
  ADD CONSTRAINT `reservation_codes_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`),
  ADD CONSTRAINT `reservation_codes_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer_detail` (`customer_id`),
  ADD CONSTRAINT `reservation_codes_ibfk_3` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`),
  ADD CONSTRAINT `reservation_codes_ibfk_4` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`);

--
-- Constraints for table `reservation_status`
--
ALTER TABLE `reservation_status`
  ADD CONSTRAINT `reservation_status_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`);

--
-- Constraints for table `table_status`
--
ALTER TABLE `table_status`
  ADD CONSTRAINT `table_status_ibfk_1` FOREIGN KEY (`table_number`) REFERENCES `table_detail` (`table_number`),
  ADD CONSTRAINT `table_status_ibfk_2` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
