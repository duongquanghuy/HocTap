-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 07, 2019 lúc 11:10 AM
-- Phiên bản máy phục vụ: 10.3.15-MariaDB
-- Phiên bản PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bt201`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`ID`, `NAME`) VALUES
(1, 'pepsi111'),
(7, 'c2'),
(12, 'coca cola');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `infouser`
--

CREATE TABLE `infouser` (
  `userName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PASSWORD` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `infouser`
--

INSERT INTO `infouser` (`userName`, `PASSWORD`, `email`, `phoneNumber`) VALUES
('tuan', '1', '@', 1),
('tuan2', '1', '@@', 1),
('	', '', '@', 12),
('1', '1', 'letuan311299@gmail.com', 969378157);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) DEFAULT 0,
  `dateOfManufacture` date DEFAULT NULL,
  `idCategory` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `dateOfManufacture`, `idCategory`) VALUES
(2, 'pepsi10k', 10000, '2019-07-03', 1),
(13, 'fanta het han', 10000, '2019-02-01', 1),
(14, 'coca sap het han', 10000, '2019-06-25', 1),
(15, 'ca phe sap het han', 50000, '2019-06-27', 12),
(16, 'tra xanh khong do', 10000, '2019-06-05', 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `productssold`
--

CREATE TABLE `productssold` (
  `id` int(11) NOT NULL,
  `name` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `dateOfManufacture` date DEFAULT NULL,
  `dateOfSold` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `productssold`
--

INSERT INTO `productssold` (`id`, `name`, `category`, `price`, `dateOfManufacture`, `dateOfSold`) VALUES
(1, 'c2 het han', 'pepsi111', 2000, '2019-06-25', '2019-07-05'),
(2, 'coca 10k', 'pepsi111', 10000, '2019-07-05', '2019-07-05'),
(3, 'pepsi test', 'pepsi111', 10000, '2019-04-02', '2019-07-05'),
(4, 'fanta', 'pepsi111', 5000, '2019-04-03', '2019-04-03');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `productssold`
--
ALTER TABLE `productssold`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `productssold`
--
ALTER TABLE `productssold`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
