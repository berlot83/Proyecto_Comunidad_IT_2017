-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2017 a las 02:32:37
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
(24, 'adminRH', 'Manuel', 'Manzanero', 'user', '1234', 'asd', 'asd'),
(37, 'adminVuelos', 'pepe', 'argento', 'pepe', '1234', 'asd', 'asd'),
(38, 'adminRH', 'German', 'Gonzalez', 'dana', '1234', 'asd', 'asd'),
(41, 'adminSeg', 'Pepa', 'Miranda', 'pepa', '1234', 'asd', 'asd');

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
(4, 'MD5', 'MD-605', 250),
(5, 'Boing 777-700', 'LV-205', 320),
(6, 'KL-310', 'KL-310', 153),
(11, 'KL-310', 'LM-306', 153),
(12, 'C-135', 'CV-435', 35),
(13, 'Fokker-27', 'FO-125', 25),
(14, 'C-130H', 'CH-230', 60),
(15, 'cessna', 'CS-450', 4),
(16, 'Super Jumbo', 'SJ-357', 390),
(17, 'Cessna-182', 'CS-182', 4);

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
(140, 30158619, 20301586192, '2017-04-11', 'asd', 'asd', 'asd', 'asd', 123, 20.91, 4.92, 97.17, 38, 'adminRH', 'user'),
(142, 12345673, 9123456789, '2017-04-12', 'dfg', 'dfg', 'dfg', 'dfg', 56566700, 9616330, 2262670, 44687700, 24, 'adminRH', 'user'),
(143, 25345123, 20123456784, '1994-07-14', 'Maria', 'Colombraro', 'Colombres', 'Encargada', 10000, 1700, 400, 7900, 24, 'adminRH', 'user'),
(144, 25546123, 23123456794, '1994-07-12', 'Pedro', 'Gimenez', 'SanJuan', 'Seguridad', 9500, 1615, 380, 7505, 24, 'adminRH', 'user'),
(145, 25546145, 23123456732, '1992-09-15', 'Marcelo', 'Cohelo', 'Directorio', 'Balijero', 25000, 4250, 1000, 19750, 24, 'adminRH', 'user'),
(147, 25546115, 23123456737, '1992-09-17', 'Pablo', 'Pereyra', 'Independencia', 'Balijero', 25000, 4250, 1000, 19750, 24, 'adminRH', 'user'),
(148, 25346715, 26123456747, '1989-02-07', 'Gisela', 'Monteagudo', 'Peron1025', 'Recepcionista', 23000, 3910, 920, 18170, 24, 'adminRH', 'user');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `id_evento` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`id_evento`, `nombre`, `fecha`) VALUES
(2, 'GimGisell', '2017-04-20'),
(4, 'Embajador Chino', '2017-04-29'),
(5, 'asd', '2017-04-26'),
(6, 'sd', '2017-04-24'),
(7, 'ert', '2017-04-28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `id_servicio` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`id_servicio`, `nombre`, `activo`) VALUES
(36, 'Servicio especial antiexplosivos', 1),
(37, 'Servicio especial antidrogas', 0),
(38, 'Antidrogas', 1),
(41, 'Megacanje', 1),
(43, 'AntiBombas', 0),
(44, 'Hospitalario', 1),
(45, 'Policía aduanera', 1),
(46, 'Servicio especial de perros', 1),
(47, 'Guardaespaldas', 0),
(48, 'Bomberos voluntarios', 0);

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
(1, 'admin', 'admin', 1234);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--

CREATE TABLE `vuelos` (
  `id` int(11) NOT NULL,
  `id_avion` int(11) NOT NULL,
  `id_administrador` int(11) NOT NULL,
  `empresa` text NOT NULL,
  `destino` text NOT NULL,
  `escalas` int(2) NOT NULL,
  `pasajes` int(11) NOT NULL,
  `fechaSalida` date NOT NULL,
  `horarioSalida` text NOT NULL,
  `fechaArribo` date NOT NULL,
  `horarioArribo` text NOT NULL,
  `pago` text NOT NULL,
  `precio` int(11) NOT NULL,
  `tipo_administrador` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vuelos`
--

INSERT INTO `vuelos` (`id`, `id_avion`, `id_administrador`, `empresa`, `destino`, `escalas`, `pasajes`, `fechaSalida`, `horarioSalida`, `fechaArribo`, `horarioArribo`, `pago`, `precio`, `tipo_administrador`) VALUES
(59, 5, 37, 'british', 'ES', 2, 250, '2017-04-13', '03:05', '2017-04-18', '17:05', 'amex', 15000, 'adminVuelos'),
(60, 6, 37, 'air', 'YE', 4, 150, '2017-04-02', '01:00', '2017-04-26', '01:00', 'naranja', 13000, 'adminVuelos'),
(61, 2, 37, 'aerolineas', 'ES', 2, 200, '2017-04-04', '01:00', '2017-04-11', '02:00', 'amex', 100, 'adminVuelos'),
(62, 11, 37, 'american', 'CX', 2, 150, '2017-04-12', '02:02', '2018-01-01', '23:01', 'master', 123, 'adminVuelos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonas`
--

CREATE TABLE `zonas` (
  `id_zona` int(11) NOT NULL,
  `nombre` text NOT NULL,
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
(11, 'Free Shop', 1);

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
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id_evento`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`id_servicio`);

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
  ADD KEY `vuelos_ibfk_2` (`id_avion`);

--
-- Indices de la tabla `zonas`
--
ALTER TABLE `zonas`
  ADD PRIMARY KEY (`id_zona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id_administrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT de la tabla `aviones`
--
ALTER TABLE `aviones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=149;
--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `id_servicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT de la tabla `super_administradores`
--
ALTER TABLE `super_administradores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
--
-- AUTO_INCREMENT de la tabla `zonas`
--
ALTER TABLE `zonas`
  MODIFY `id_zona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
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
  ADD CONSTRAINT `vuelos_ibfk_2` FOREIGN KEY (`id_avion`) REFERENCES `aviones` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
