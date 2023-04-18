-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 18, 2023 at 04:36 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `demo`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `payrate` double NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `name`, `password`, `payrate`, `title`, `username`) VALUES
(1, 'sponge', 'pass', 12, 'CHEF', 'sponge');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` bigint(20) NOT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `inventory_restock`
--

CREATE TABLE `inventory_restock` (
  `id` bigint(20) NOT NULL,
  `itemid` bigint(20) NOT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `managerid` bigint(20) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL,
  `calories` int(11) NOT NULL,
  `cost` double NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `calories`, `cost`, `name`) VALUES
(1, 100, 1, 'FOUNTAIN WATER'),
(2, 400, 6, 'COKE'),
(3, 1300, 20, 'Pizza'),
(4, 500, 11, 'Nuggets');

-- --------------------------------------------------------

--
-- Table structure for table `menu_orders`
--

CREATE TABLE `menu_orders` (
  `contents_id` bigint(20) NOT NULL,
  `orders_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu_orders`
--

INSERT INTO `menu_orders` (`contents_id`, `orders_id`) VALUES
(2, 1),
(1, 1),
(3, 1),
(3, 1),
(1, 2),
(4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` bigint(20) NOT NULL,
  `cost` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `party` int(11) NOT NULL,
  `status` enum('NOT STARTED','COOKING','DONE','SERVED') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id`, `cost`, `name`, `party`, `status`) VALUES
(1, 13.45, 'Brook', 50, 'NOT STARTED'),
(2, 40, 'Chopper', 2, 'NOT STARTED');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory_restock`
--
ALTER TABLE `inventory_restock`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu_orders`
--
ALTER TABLE `menu_orders`
  ADD KEY `FK3d0nsjm89addxo97suhl0otax` (`orders_id`),
  ADD KEY `FKj5b18p1s9w9g1k13epqsne92c` (`contents_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `inventory_restock`
--
ALTER TABLE `inventory_restock`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `menu_orders`
--
ALTER TABLE `menu_orders`
  ADD CONSTRAINT `FK3d0nsjm89addxo97suhl0otax` FOREIGN KEY (`orders_id`) REFERENCES `order` (`id`),
  ADD CONSTRAINT `FKj5b18p1s9w9g1k13epqsne92c` FOREIGN KEY (`contents_id`) REFERENCES `menu` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
