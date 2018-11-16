-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2017 at 11:24 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

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
-- Table structure for table `bookstore`
--

CREATE TABLE `bookstore` (
  `id` int(11) NOT NULL,
  `book` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookstore`
--

INSERT INTO `bookstore` (`id`, `book`, `author`, `isbn`, `price`) VALUES
(1, 'Introduction to PHP', 'Mark User', '3334-4424-334-3433', 500),
(2, 'DHTML and CSS', 'Teague Sanders', '4545-23-23-23-23232', 1500),
(3, 'Introduction to PHP', 'Weeling Tom', '4334-2323-23233-434', 300),
(4, ' Web design', ' Weeling Tom', ' 4334-2323-23233-434', 600),
(5, ' PHP 5', ' Weeling Tom', ' 444-87-67665-678678', 600),
(6, ' JavaServer Pages', ' Tick Own', ' 897-9898-987-099', 800);

-- --------------------------------------------------------

--
-- Table structure for table `crudclass`
--

CREATE TABLE `crudclass` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crudclass`
--

INSERT INTO `crudclass` (`id`, `name`, `email`) VALUES
(1, 'Name 1', 'name1@email.com'),
(2, 'Name 2', 'name2@email.com'),
(3, 'Name 3', 'name3@email.com');

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

INSERT INTO `users` (`id`, `name`, `age`, `email`) VALUES
(1, 'Mont Patricks Peter', 37, 'pat@example.com'),
(2, 'Jimmy Karter', 45, 'jim@example.com'),
(4, 'new', 23, 'new@data.com'),
(8, 'new record', 88, 'new@record.com'),
(6, 'temp', 21, 'ydate@example.com'),
(9, 'Imad', 74, 'im@exmaple.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookstore`
--
ALTER TABLE `bookstore`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `crudclass`
--
ALTER TABLE `crudclass`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookstore`
--
ALTER TABLE `bookstore`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `crudclass`
--
ALTER TABLE `crudclass`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
