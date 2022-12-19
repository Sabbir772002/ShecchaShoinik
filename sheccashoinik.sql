-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2022 at 05:32 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sheccashoinik`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Name` int(11) NOT NULL,
  `Pass` int(11) NOT NULL,
  `Mail` int(11) NOT NULL,
  `Division` int(11) NOT NULL,
  `Username` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `diasterlist`
--

CREATE TABLE `diasterlist` (
  `Title` text NOT NULL,
  `Type` text NOT NULL,
  `Address` text NOT NULL,
  `Division` text NOT NULL,
  `District` text NOT NULL,
  `Id` int(11) NOT NULL,
  `Additional Info` text NOT NULL,
  `Image` longblob NOT NULL,
  `Time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `Name` text NOT NULL,
  `Username` text NOT NULL,
  `License` int(10) NOT NULL,
  `ID` int(11) NOT NULL,
  `Mail` text NOT NULL,
  `Pass` text NOT NULL,
  `District` text NOT NULL,
  `Division` text NOT NULL,
  `Type` text NOT NULL,
  `Phone` int(11) NOT NULL,
  `Availablity` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `userlist`
--

CREATE TABLE `userlist` (
  `S.I.` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Username` text NOT NULL,
  `Password` text NOT NULL,
  `Division` text NOT NULL,
  `District` text NOT NULL,
  `DOB` text NOT NULL,
  `ID` text NOT NULL,
  `Gender` text NOT NULL,
  `Volunteer` text NOT NULL,
  `BG` text NOT NULL,
  `Phone` text NOT NULL,
  `Mail` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userlist`
--

INSERT INTO `userlist` (`S.I.`, `Name`, `Username`, `Password`, `Division`, `District`, `DOB`, `ID`, `Gender`, `Volunteer`, `BG`, `Phone`, `Mail`) VALUES
(1, '', '1', '1', '', '', '2002-07-07', '', '', '0', '0', '0', ''),
(2, 'Sabbir Hossain', 'Sabbir', 'Admin', 'Rajshahi', 'Sirajgong', '2002-07-07', '1963890981', 'MALE', 'Others', 'A+', '01571144383', 'Sabbir@mail.com'),
(3, 'Sabbir', '', '', '', '', '', '', '', '', '', '', ''),
(4, 'Nusrat Hossain', 'Nuha', '0', 'Rajshahi', 'Rajshahi', '07-09-2003', '1963890981', 'Female', 'Cyclone', 'O+', '01787474383', 'Nusrat@mail.com'),
(5, 'Shahin', 'Shahin', '0', 'Chattogram', 'Feni', '2022-12-14', '1963890981', 'Male', 'Fire', 'O+', '0157135528', 'Shahin@gmail.com'),
(6, 'Nafis Hossain', 'Nafis', '0', 'Barishal', 'Barishal', '2022-12-14', '1963890981', 'Male', 'EarthQuake', 'A+', '01525262252', 'Nafis@gmail.com'),
(7, 'Alif', 'Alif', '0', 'Rajshahi', 'Chapinawabganj', '2022-12-06', '1963890981', 'Male', 'EarthQuake', 'A+', '01852050205', 'Alif@gmail.com'),
(8, 'Musfirat', 'Musfirat', '0', 'Dhaka', 'Dhaka', '2022-12-12', '1963890981', 'Female', 'Cyclone', 'AB-', '015838883929', 'Musfirat@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diasterlist`
--
ALTER TABLE `diasterlist`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `userlist`
--
ALTER TABLE `userlist`
  ADD PRIMARY KEY (`S.I.`),
  ADD UNIQUE KEY `Username` (`Username`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diasterlist`
--
ALTER TABLE `diasterlist`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `teams`
--
ALTER TABLE `teams`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `userlist`
--
ALTER TABLE `userlist`
  MODIFY `S.I.` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
