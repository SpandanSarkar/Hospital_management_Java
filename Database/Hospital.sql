-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Apr 25, 2022 at 05:17 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `Hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`userName`, `password`) VALUES
('spandansarkar71@gmail.com', '12345678'),
('sunanda', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `ID` int(10) NOT NULL,
  `Name` varchar(80) NOT NULL,
  `Age` int(5) NOT NULL,
  `Disease` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `CabinNo` varchar(20) NOT NULL,
  `Occupation` varchar(50) NOT NULL,
  `Doctor` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`ID`, `Name`, `Age`, `Disease`, `Address`, `CabinNo`, `Occupation`, `Doctor`) VALUES
(1, 'ABC', 25, 'jjb', 'Savar', '61', 'Student', 'James'),
(3, 'abc', 34, 'abc', 'abc', '12a', 'abc', 'abc');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`userName`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`ID`);
