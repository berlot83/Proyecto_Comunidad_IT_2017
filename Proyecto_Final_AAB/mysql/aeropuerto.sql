-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-05-2017 a las 15:42:15
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aeropuerto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `id_administrador` int(11) NOT NULL,
  `tipo_admin` varchar(100) NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `pass` text NOT NULL,
  `email` text NOT NULL,
  `direccion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`id_administrador`, `tipo_admin`, `nombre`, `apellido`, `usuario`, `pass`, `email`, `direccion`) VALUES
(24, 'adminRH', 'Manuel', 'Manzanero', 'user', '81dc9bdb52d04dc20036dbd8313ed055', 'asd', 'asd'),
(37, 'adminVuelos', 'pepe', 'argento', 'pepe', '81dc9bdb52d04dc20036dbd8313ed055', 'asd', 'asd'),
(41, 'adminSeg', 'Pepa', 'Miranda', 'pepa', '81dc9bdb52d04dc20036dbd8313ed055', 'asd', 'asd'),
(116, 'adminVuelos', 'Jorge', 'Pereyra', 'jorge82', '81dc9bdb52d04dc20036dbd8313ed055', 'jorge82@yahoo.com.ar', 'Brandsen'),
(117, 'adminRH', 'Marcelo', 'Morelos', 'marce81', '81dc9bdb52d04dc20036dbd8313ed055', 'marce83@yahoo.com.ar', 'MontesOca'),
(118, 'adminVuelos', 'Carlos', 'Tomada', 'carlos83', '81dc9bdb52d04dc20036dbd8313ed055', 'carlos83@yahoo.com.ar', 'SanJuan'),
(120, 'adminVuelos', 'Pablo', 'Gottifredi', 'PabloG', 'e10adc3949ba59abbe56e057f20f883e', 'asd@asd.com', 'Scalabrini');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aviones`
--

CREATE TABLE `aviones` (
  `id` int(11) NOT NULL,
  `tipo_avion` varchar(50) NOT NULL,
  `matricula` varchar(50) NOT NULL,
  `cantidad_pasajeros` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aviones`
--

INSERT INTO `aviones` (`id`, `tipo_avion`, `matricula`, `cantidad_pasajeros`) VALUES
(2, 'Jumbo 747', 'LM-505', 350),
(12, 'C-135', 'CV-435', 35),
(14, 'C-130H', 'CH-230', 60),
(16, 'Super Jumbo', 'SJ-357', 390),
(17, 'Cessna-182', 'CS-182', 4),
(24, 'Galaxy', 'GL-456', 200),
(25, 'cv', '1234', 234);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleado` int(11) NOT NULL,
  `dni` int(8) NOT NULL,
  `cuit` bigint(11) NOT NULL,
  `nacimiento` date NOT NULL,
  `nombre` tinytext NOT NULL,
  `apellido` tinytext NOT NULL,
  `direccion` tinytext NOT NULL,
  `cargo` tinytext NOT NULL,
  `sueldo_cargo` float NOT NULL,
  `cargas_sociales` float NOT NULL,
  `vacaciones` float NOT NULL,
  `sueldo_neto` float NOT NULL,
  `id_administrador` int(11) NOT NULL,
  `tipo_administrador` varchar(100) NOT NULL,
  `usuario_administrador` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `dni`, `cuit`, `nacimiento`, `nombre`, `apellido`, `direccion`, `cargo`, `sueldo_cargo`, `cargas_sociales`, `vacaciones`, `sueldo_neto`, `id_administrador`, `tipo_administrador`, `usuario_administrador`) VALUES
(143, 25345123, 20123456784, '1994-07-14', 'Maria', 'Colombraro', 'Colombres', 'Encargada', 10000, 1700, 400, 7900, 24, 'adminRH', 'user'),
(144, 25546123, 23123456794, '1994-07-12', 'Pedro', 'Gimenez', 'SanJuan', 'Seguridad', 9500, 1615, 380, 7505, 24, 'adminRH', 'user'),
(145, 25546145, 23123456732, '1992-09-15', 'Marcelo', 'Cohelo', 'Directorio', 'Balijero', 25000, 4250, 1000, 19750, 24, 'adminRH', 'user'),
(147, 25546115, 23123456737, '1992-09-17', 'Pablo', 'Pereyra', 'Independencia', 'Balijero', 25000, 4250, 1000, 19750, 24, 'adminRH', 'user'),
(148, 25346715, 26123456747, '1989-02-07', 'Gisela', 'Monteagudo', 'Peron1025', 'Recepcionista', 23000, 3910, 920, 18170, 24, 'adminRH', 'user'),
(149, 40158719, 20301577191, '1983-04-09', '', '', '234', '123', 12345, 2098.65, 493.8, 9752.55, 24, 'adminRH', 'user'),
(150, 23456789, 23123456789, '2017-04-18', 'sdf', 'sdf', 'sdf1234', 'wer324', 4000, 680, 160, 3160, 24, 'adminRH', 'user'),
(151, 90454567, 90345678909, '2017-04-09', 'pepe', 'pepe', 'pepe0', 'pepe0', 12, 2.04, 0.48, 9.48, 24, 'adminRH', 'user'),
(152, 12345678, 12345678909, '2017-05-17', 'Jaime', 'Baily', 'Brandsen', 'empleado', 14000, 2380, 560, 11060, 24, 'adminRH', 'user'),
(154, 12373678, 32165256345, '2017-05-16', 'Lorenzo', 'Lamas', 'Cancun', 'empleado', 15000, 2550, 600, 11850, 24, 'adminRH', 'marce81'),
(155, 9876589, 12398745685, '2017-05-24', 'Charlie', 'Sheen', 'Malibu', 'actor', 14000, 2380, 560, 11060, 24, 'adminRH', 'marce81');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE `empresas` (
  `id` int(11) NOT NULL,
  `empresa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`id`, `empresa`) VALUES
(1, 'Aerolineas Argentinas'),
(14, 'Air France'),
(9, 'AliTalia'),
(2, 'American Airlines'),
(7, 'Austral'),
(15, 'Blue Airlines'),
(5, 'British Airways'),
(13, 'Iberia'),
(8, 'KLM'),
(6, 'Latam'),
(4, 'Lufthansa'),
(11, 'Souther Airlines'),
(12, 'United Airlines'),
(3, 'Varig');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `id_evento` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`id_evento`, `nombre`, `fecha`) VALUES
(4, 'Embajador Chino', '2017-04-29'),
(8, 'Visita embajador China', '2017-04-30'),
(10, 'Visita embajador Peru', '2017-04-30'),
(16, 'Visita del gerente del 2do coca cola', '2017-04-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `id_servicio` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`id_servicio`, `nombre`, `activo`) VALUES
(36, 'Servicio especial antiexplosivos', 1),
(37, 'Servicio especial antidrogas', 0),
(38, 'Antidrogas', 1),
(43, 'AntiBombas', 0),
(46, 'Servicio especial de perros', 1),
(48, 'Bomberos voluntarios', 0),
(51, 'Servicio especial antiterrorismo', 1),
(52, 'Servicio especial radares aereos', 0),
(56, 'Lobby seguridad', 0),
(57, 'Buffet', 1),
(58, 'baño', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `super_administradores`
--

CREATE TABLE `super_administradores` (
  `id` int(11) NOT NULL,
  `usuario` text NOT NULL,
  `pass` text NOT NULL,
  `token` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `super_administradores`
--

INSERT INTO `super_administradores` (`id`, `usuario`, `pass`, `token`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 1234);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--

CREATE TABLE `vuelos` (
  `id` int(11) NOT NULL,
  `id_avion` int(11) NOT NULL,
  `id_administrador` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `destino` text NOT NULL,
  `escalas` int(2) NOT NULL,
  `pasajes` int(11) NOT NULL,
  `fechaSalida` date NOT NULL,
  `horarioSalida` text NOT NULL,
  `fechaArribo` date NOT NULL,
  `horarioArribo` text NOT NULL,
  `tipo_administrador` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vuelos`
--

INSERT INTO `vuelos` (`id`, `id_avion`, `id_administrador`, `id_empresa`, `destino`, `escalas`, `pasajes`, `fechaSalida`, `horarioSalida`, `fechaArribo`, `horarioArribo`, `tipo_administrador`) VALUES
(77, 25, 37, 15, 'KI', 3, 120, '2017-05-17', '00:00', '2017-05-25', '00:00', 'adminVuelos'),
(78, 12, 37, 8, 'DM', 4, 20, '2017-05-16', '00:00', '2017-05-17', '00:00', 'adminVuelos'),
(79, 14, 37, 11, 'JP', 2, 45, '2017-05-16', '00:00', '2017-05-17', '00:00', 'adminVuelos'),
(80, 24, 37, 5, 'PR', 2, 185, '2017-05-16', '00:00', '2017-05-17', '00:00', 'adminVuelos'),
(81, 2, 37, 1, 'ER', 2, 100, '2017-05-10', '00:00', '2017-05-18', '00:00', 'adminVuelos'),
(82, 14, 37, 13, 'GY', 3, 50, '2017-05-09', '02:01', '2017-05-18', '05:01', 'adminVuelos'),
(83, 16, 37, 4, 'MN', 1, 100, '2017-05-09', '01:58', '2017-05-17', '00:00', 'adminVuelos'),
(84, 16, 116, 15, 'DK', 2, 123, '2017-05-09', '00:00', '2017-05-17', '00:00', 'adminVuelos'),
(85, 2, 116, 1, 'ES', 2, 34, '2017-05-15', '04:04', '2017-05-16', '04:04', 'adminVuelos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonas`
--

CREATE TABLE `zonas` (
  `id_zona` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cubierta` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `zonas`
--

INSERT INTO `zonas` (`id_zona`, `nombre`, `cubierta`) VALUES
(3, 'Pista cuadrante 1', 0),
(4, 'Pista cuadrante 2', 0),
(5, 'Pista cuadrante 3', 0),
(6, 'Pista cuadrante 4', 0),
(7, 'Buffete 1', 1),
(8, 'Buffete 2', 1),
(9, 'Buffete 3', 1),
(10, 'Patio de comidas', 1),
(11, 'Free Shop', 1),
(12, 'Freeshop 1', 0),
(13, 'Freeshop 2', 0),
(15, 'Freeshop 3', 0),
(16, 'Migraciones', 1),
(19, 'Depto Limpieza', 1),
(20, 'Hangar 1', 1),
(21, 'Hangar 2', 1),
(22, 'Hangar 3', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id_administrador`),
  ADD UNIQUE KEY `usuario_2` (`usuario`),
  ADD KEY `usuario` (`usuario`),
  ADD KEY `tipo_admin` (`tipo_admin`) USING BTREE;

--
-- Indices de la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `matricula` (`matricula`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleado`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `cuit` (`cuit`),
  ADD KEY `usuario_administrador` (`usuario_administrador`) USING BTREE,
  ADD KEY `tipo_administrador` (`tipo_administrador`) USING BTREE,
  ADD KEY `admin` (`id_administrador`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `empresa` (`empresa`);

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id_evento`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`id_servicio`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `super_administradores`
--
ALTER TABLE `super_administradores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vuelos_ibfk_1` (`id_administrador`),
  ADD KEY `vuelos_ibfk_2` (`id_avion`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `zonas`
--
ALTER TABLE `zonas`
  ADD PRIMARY KEY (`id_zona`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id_administrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;
--
-- AUTO_INCREMENT de la tabla `aviones`
--
ALTER TABLE `aviones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=156;
--
-- AUTO_INCREMENT de la tabla `empresas`
--
ALTER TABLE `empresas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `id_servicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
--
-- AUTO_INCREMENT de la tabla `super_administradores`
--
ALTER TABLE `super_administradores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;
--
-- AUTO_INCREMENT de la tabla `zonas`
--
ALTER TABLE `zonas`
  MODIFY `id_zona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `admin` FOREIGN KEY (`id_administrador`) REFERENCES `administradores` (`id_administrador`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD CONSTRAINT `vuelos_ibfk_1` FOREIGN KEY (`id_administrador`) REFERENCES `administradores` (`id_administrador`) ON UPDATE CASCADE,
  ADD CONSTRAINT `vuelos_ibfk_2` FOREIGN KEY (`id_avion`) REFERENCES `aviones` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `vuelos_ibfk_3` FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
