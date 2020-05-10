-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 10 2020 г., 12:10
-- Версия сервера: 10.4.11-MariaDB
-- Версия PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `dealear_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cars`
--

CREATE TABLE `cars` (
  `id_car` int(11) NOT NULL,
  `brand` varchar(128) NOT NULL,
  `model` varchar(128) NOT NULL,
  `drive_type` varchar(128) NOT NULL,
  `fuel_type` varchar(128) NOT NULL,
  `year` int(128) NOT NULL,
  `hp` int(128) NOT NULL,
  `price` int(128) NOT NULL,
  `volume` varchar(128) NOT NULL,
  `fuel` varchar(128) NOT NULL,
  `time` varchar(128) NOT NULL,
  `body_type` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `cars`
--

INSERT INTO `cars` (`id_car`, `brand`, `model`, `drive_type`, `fuel_type`, `year`, `hp`, `price`, `volume`, `fuel`, `time`, `body_type`) VALUES
(15, 'Mercedes-Benz', 'S 63 AMG', '4-Wheel Drive', 'Gasoline', 2019, 612, 155000, '4.0L AMG V8 biturbo', '8.9L /100 km', '3.5 sec.', 'Sedan'),
(16, 'Mercedes-Benz', 'G 63 AMG', '4-Wheel Drive', 'Gasoline', 2020, 585, 156000, '4.0L AMG V8 biturbo', '13.1L /100 km', '4.5 sec.', 'SUV'),
(17, 'Mercedes-Benz', 'A 35 AMG ', '4-Wheel Drive', 'Gasoline', 2020, 302, 45000, '2.0L AMG', '7.6L/100km', '4.7 sec.', 'Hatchback'),
(18, 'Mercedes-Benz', 'E 63 AMG', '4-Wheel Drive', 'Gasoline', 2020, 612, 108000, '4.0L AMG V8 biturbo', '9.1L/100 km', '3.4 sec.', 'Sedan'),
(19, 'Mercedes-Benz', 'CLS 350 D', '4-Wheel Drive', 'Diesel', 2020, 249, 45000, '3.0L', '6.9L /100 km', '5.7 sec.', '4 Door Coupe'),
(20, 'Mercedes-Benz', 'Maybach GLS 600', '4-Wheel Drive', 'Gasoline', 2020, 558, 187000, '5.0L', '12 L/100 km', '4.9 sec.', 'SUV'),
(23, 'Mercedes-Benz', 'C 43 AMG', '4-Wheel Drive', 'Gasoline', 2020, 390, 95000, '3.0L AMG', '9.5 L/100 km', '4.7 sec.', 'Coupe'),
(24, 'Mercedes-Benz', 'AMG GT Coupe', '4-Wheel Drive', 'Gasoline', 2020, 585, 135000, '4.0L AMG V8 biturbo', '11.4 L/100 km', '3.6 sec.', 'Coupe'),
(25, 'Mercedes-Benz', 'GLE 450 ', '4-Wheel Drive', 'Gasoline', 2020, 362, 65000, '3.0L with EQ Boost', '9.4 L/100 km	', '5.5 sec.', 'SUV'),
(26, 'Mercedes-Benz', 'GLB 250 ', '4-Wheel Drive', 'Gasoline', 2020, 236, 45000, '2.0L turbo', '9.5 L/100 km', '6.8 sec.', 'SUV'),
(27, 'Mercedes-Benz', 'Maybach S 650', 'Rear-wheel drive', 'Gasoline', 2020, 630, 250000, 'V12 AMG', '12.7L /100 km', '4.7 sec.', 'Limousine');

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `id_order` int(11) NOT NULL,
  `id_user` int(128) NOT NULL,
  `id_car` int(128) NOT NULL,
  `status` varchar(128) NOT NULL,
  `date` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`id_order`, `id_user`, `id_car`, `status`, `date`) VALUES
(30, 6, 15, 'COMPLETED', '10.05.2020 15:25'),
(31, 6, 17, 'AWAITING PAYMENT', '10.05.2020 15:26'),
(32, 6, 18, 'NEW', '10.05.2020 16:01');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `firstName` varchar(128) NOT NULL,
  `lastName` varchar(128) NOT NULL,
  `city` varchar(128) NOT NULL,
  `phone` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `gender` varchar(128) NOT NULL,
  `role` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`, `firstName`, `lastName`, `city`, `phone`, `email`, `gender`, `role`) VALUES
(6, 'tltvd', '2', 'Dinmukhamed', 'Tuletayev', 'New-York', '87056297777', '28276@edu.iitu.kz', 'Male', 'USER'),
(8, 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'ADMIN'),
(10, 'sdf', 'sdf', 'sdfs', 'sfd', 'sdf', 'sdf', 'sdf', 'Male', 'USER'),
(11, 'ewf', 'few', 'test1', 'test1', 'wef', 'ef', 'ew', 'Male', 'USER'),
(12, 'ewf', 'sdf', 'dfh', 'hyyfd', 'wef', 'ef', 'ew', 'Male', 'USER'),
(15, 'test3', 'test3', 'test3', 'test3', 'test3', 'test3', 'test3', 'Female', 'USER'),
(22, 'testFinall', 'testFinall', 'testFinall', 'testFinall', 'testFinall', 'testFinall', '@testFinall', 'Male', 'USER');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id_car`);

--
-- Индексы таблицы `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_car` (`id_car`),
  ADD KEY `id_user` (`id_user`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cars`
--
ALTER TABLE `cars`
  MODIFY `id_car` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT для таблицы `orders`
--
ALTER TABLE `orders`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_car`) REFERENCES `cars` (`id_car`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
