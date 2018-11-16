-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2018 at 06:09 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserAge` (IN `uid` INT(11), OUT `age` VARCHAR(10))  BEGIN
    DECLARE ageVal int;
 
    SELECT age INTO ageVal
    FROM users
    WHERE id = uid;
 
    IF ageVal > 50 THEN
    	SET age = 'Old';
    ELSEIF (ageVal <= 50 AND ageVal >= 35) THEN
        SET age = 'Adult';
    ELSEIF (ageVal <= 35 AND ageVal >= 20) THEN
        SET age = 'Young Adult';
    ELSEIF (ageVal <= 13 AND ageVal >= 19) THEN
        SET age = 'Teenager';
    ELSE
        SET age = 'Child';
    END IF;
 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUser` (IN `name_val` VARCHAR(255), IN `age_val` VARCHAR(255), IN `email_val` VARCHAR(255))  BEGIN 
    INSERT INTO users(name, age, email) VALUES(name_val, age_val, email_val); 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `selectBooks` ()  BEGIN 
    SELECT * from bookstore;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `total_price` (OUT `total` INT)  BEGIN 
	SELECT sum(price) into total from bookstore;
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `calTax` (`amount` INT) RETURNS INT(11) RETURN amount*0.10$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `age` int(3) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `age`, `email`) VALUES(1, 'Mont Patricks Peter', 37, 'pat@example.com');
INSERT INTO `users` (`id`, `name`, `age`, `email`) VALUES(2, 'Jimmy Karter', 45, 'jim@example.com');
INSERT INTO `users` (`id`, `name`, `age`, `email`) VALUES(4, 'new', 23, 'new@data.com');
INSERT INTO `users` (`id`, `name`, `age`, `email`) VALUES(8, 'updated at 1527', 88, 'new@record.com');
INSERT INTO `users` (`id`, `name`, `age`, `email`) VALUES(6, 'temp', 21, 'ydate@example.com');
INSERT INTO `users` (`id`, `name`, `age`, `email`) VALUES(11, 'Ali', 57, 'ali@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;