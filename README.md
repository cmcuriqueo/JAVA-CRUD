# PrimerTrabajoJava
##Base de datos de prueba
###Base de datos de clientes
```

--
-- Base de datos: `clientes_db`
--
CREATE DATABASE IF NOT EXISTS `clientes_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `clientes_db`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `activo` int(11) NOT NULL,
  `nacionalidad_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nacionalidad_id` (`nacionalidad_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `apellido`, `nombre`, `fecha_nacimiento`, `activo`, `nacionalidad_id`) VALUES
(3, 'ARGENTO', 'PEPE', '1997-09-10', 1, 13),
(4, 'TORRES', 'PEPITO', '1990-04-10', 1, 3),
(6, 'DEL PINO', 'JOSE', '1969-09-30', 0, 3),
(7, 'del Pino', 'peter', '1960-01-14', 1, 226);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nacionalidades`
--

CREATE TABLE IF NOT EXISTS `nacionalidades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `codigo` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=243 ;

--
-- Volcado de datos para la tabla `nacionalidades`
--

INSERT INTO `nacionalidades` (`id`, `descripcion`, `codigo`) VALUES
(3, 'ANDORRA', 'AD'),
(4, 'EMIRATOS ÁRABES UNIDOS', 'AE'),
(5, 'AFGANISTáN', 'AF'),
(6, 'ANTIGUA Y BARBUDA', 'AG'),
(7, 'ANGUILLA', 'AI'),
(8, 'ALBANIA', 'AL'),
(9, 'ARMENIA', 'AM'),
(10, 'ANTILLAS HOLANDESAS', 'AN'),
(11, 'ANGOLA', 'AO'),
(12, 'ANTáRTIDA', 'AQ'),
(13, 'ARGENTINA', 'AR'),
(14, 'SAMOA AMERICANA', 'AS'),
(15, 'AUSTRIA', 'AT'),
(16, 'AUSTRALIA', 'AU'),
(17, 'ARUBA', 'AW'),
(18, 'ISLAS GLAND', 'AX'),
(19, 'AZERBAIYáN', 'AZ'),
(20, 'BOSNIA Y HERZEGOVINA', 'BA'),
(21, 'BARBADOS', 'BB'),
(22, 'BANGLADESH', 'BD'),
(23, 'BéLGICA', 'BE'),
(24, 'BURKINA FASO', 'BF'),
(25, 'BULGARIA', 'BG'),
(26, 'BAHRéIN', 'BH'),
(27, 'BURUNDI', 'BI'),
(28, 'BENIN', 'BJ'),
(29, 'BERMUDAS', 'BM'),
(30, 'BRUNéI', 'BN'),
(31, 'BOLIVIA', 'BO'),
(32, 'BRASIL', 'BR'),
(33, 'BAHAMAS', 'BS'),
(34, 'BHUTáN', 'BT'),
(35, 'ISLA BOUVET', 'BV'),
(36, 'BOTSUANA', 'BW'),
(37, 'BIELORRUSIA', 'BY'),
(38, 'BELICE', 'BZ'),
(39, 'CANADá', 'CA'),
(40, 'ISLAS COCOS', 'CC'),
(41, 'REPúBLICA DEMOCRáTICA DEL CONGO', 'CD'),
(42, 'REPúBLICA CENTROAFRICANA', 'CF'),
(43, 'CONGO', 'CG'),
(44, 'SUIZA', 'CH'),
(45, 'COSTA DE MARFIL', 'CI'),
(46, 'ISLAS COOK', 'CK'),
(47, 'CHILE', 'CL'),
(48, 'CAMERúN', 'CM'),
(49, 'CHINA', 'CN'),
(50, 'COLOMBIA', 'CO'),
(51, 'COSTA RICA', 'CR'),
(52, 'SERBIA Y MONTENEGRO', 'CS'),
(53, 'CUBA', 'CU'),
(54, 'CABO VERDE', 'CV'),
(55, 'ISLA DE NAVIDAD', 'CX'),
(56, 'CHIPRE', 'CY'),
(57, 'REPúBLICA CHECA', 'CZ'),
(58, 'ALEMANIA', 'DE'),
(59, 'YIBUTI', 'DJ'),
(60, 'DINAMARCA', 'DK'),
(61, 'DOMINICA', 'DM'),
(62, 'REPúBLICA DOMINICANA', 'DO'),
(63, 'ARGELIA', 'DZ'),
(64, 'ECUADOR', 'EC'),
(65, 'ESTONIA', 'EE'),
(66, 'EGIPTO', 'EG'),
(67, 'SAHARA OCCIDENTAL', 'EH'),
(68, 'ERITREA', 'ER'),
(69, 'ESPAñA', 'ES'),
(70, 'ETIOPíA', 'ET'),
(71, 'FINLANDIA', 'FI'),
(72, 'FIYI', 'FJ'),
(73, 'ISLAS MALVINAS', 'FK'),
(74, 'MICRONESIA', 'FM'),
(75, 'ISLAS FEROE', 'FO'),
(76, 'FRANCIA', 'FR'),
(77, 'GABóN', 'GA'),
(78, 'REINO UNIDO', 'GB'),
(79, 'GRANADA', 'GD'),
(80, 'GEORGIA', 'GE'),
(81, 'GUAYANA FRANCESA', 'GF'),
(82, 'GHANA', 'GH'),
(83, 'GIBRALTAR', 'GI'),
(84, 'GROENLANDIA', 'GL'),
(85, 'GAMBIA', 'GM'),
(86, 'GUINEA', 'GN'),
(87, 'GUADALUPE', 'GP'),
(88, 'GUINEA ECUATORIAL', 'GQ'),
(89, 'GRECIA', 'GR'),
(90, 'ISLAS GEORGIAS DEL SUR Y SANDWICH DEL SUR', 'GS'),
(91, 'GUATEMALA', 'GT'),
(92, 'GUAM', 'GU'),
(93, 'GUINEA-BISSAU', 'GW'),
(94, 'GUYANA', 'GY'),
(95, 'HONG KONG', 'HK'),
(96, 'ISLAS HEARD Y MCDONALD', 'HM'),
(97, 'HONDURAS', 'HN'),
(98, 'CROACIA', 'HR'),
(99, 'HAITí', 'HT'),
(100, 'HUNGRíA', 'HU'),
(101, 'INDONESIA', 'ID'),
(102, 'IRLANDA', 'IE'),
(103, 'ISRAEL', 'IL'),
(104, 'INDIA', 'IN'),
(105, 'TERRITORIO BRITáNICO DEL OCéANO ÍNDICO', 'IO'),
(106, 'IRAQ', 'IQ'),
(107, 'IRáN', 'IR'),
(108, 'ISLANDIA', 'IS'),
(109, 'ITALIA', 'IT'),
(110, 'JAMAICA', 'JM'),
(111, 'JORDANIA', 'JO'),
(112, 'JAPóN', 'JP'),
(113, 'KENIA', 'KE'),
(114, 'KIRGUISTáN', 'KG'),
(115, 'CAMBOYA', 'KH'),
(116, 'KIRIBATI', 'KI'),
(117, 'COMORAS', 'KM'),
(118, 'SAN CRISTóBAL Y NEVIS', 'KN'),
(119, 'COREA DEL NORTE', 'KP'),
(120, 'COREA DEL SUR', 'KR'),
(121, 'KUWAIT', 'KW'),
(122, 'ISLAS CAIMáN', 'KY'),
(123, 'KAZAJSTáN', 'KZ'),
(124, 'LAOS', 'LA'),
(125, 'LíBANO', 'LB'),
(126, 'SANTA LUCíA', 'LC'),
(127, 'LIECHTENSTEIN', 'LI'),
(128, 'SRI LANKA', 'LK'),
(129, 'LIBERIA', 'LR'),
(130, 'LESOTHO', 'LS'),
(131, 'LITUANIA', 'LT'),
(132, 'LUXEMBURGO', 'LU'),
(133, 'LETONIA', 'LV'),
(134, 'LIBIA', 'LY'),
(135, 'MARRUECOS', 'MA'),
(136, 'MóNACO', 'MC'),
(137, 'MOLDAVIA', 'MD'),
(138, 'MADAGASCAR', 'MG'),
(139, 'ISLAS MARSHALL', 'MH'),
(140, 'ARY MACEDONIA', 'MK'),
(141, 'MALí', 'ML'),
(142, 'MYANMAR', 'MM'),
(143, 'MONGOLIA', 'MN'),
(144, 'MACAO', 'MO'),
(145, 'ISLAS MARIANAS DEL NORTE', 'MP'),
(146, 'MARTINICA', 'MQ'),
(147, 'MAURITANIA', 'MR'),
(148, 'MONTSERRAT', 'MS'),
(149, 'MALTA', 'MT'),
(150, 'MAURICIO', 'MU'),
(151, 'MALDIVAS', 'MV'),
(152, 'MALAWI', 'MW'),
(153, 'MéXICO', 'MX'),
(154, 'MALASIA', 'MY'),
(155, 'MOZAMBIQUE', 'MZ'),
(156, 'NAMIBIA', 'NA'),
(157, 'NUEVA CALEDONIA', 'NC'),
(158, 'NíGER', 'NE'),
(159, 'ISLA NORFOLK', 'NF'),
(160, 'NIGERIA', 'NG'),
(161, 'NICARAGUA', 'NI'),
(162, 'PAíSES BAJOS', 'NL'),
(163, 'NORUEGA', 'NO'),
(164, 'NEPAL', 'NP'),
(165, 'NAURU', 'NR'),
(166, 'NIUE', 'NU'),
(167, 'NUEVA ZELANDA', 'NZ'),
(168, 'OMáN', 'OM'),
(169, 'PANAMá', 'PA'),
(170, 'PERú', 'PE'),
(171, 'POLINESIA FRANCESA', 'PF'),
(172, 'PAPúA NUEVA GUINEA', 'PG'),
(173, 'FILIPINAS', 'PH'),
(174, 'PAKISTáN', 'PK'),
(175, 'POLONIA', 'PL'),
(176, 'SAN PEDRO Y MIQUELóN', 'PM'),
(177, 'ISLAS PITCAIRN', 'PN'),
(178, 'PUERTO RICO', 'PR'),
(179, 'PALESTINA', 'PS'),
(180, 'PORTUGAL', 'PT'),
(181, 'PALAU', 'PW'),
(182, 'PARAGUAY', 'PY'),
(183, 'QATAR', 'QA'),
(184, 'REUNIóN', 'RE'),
(185, 'RUMANIA', 'RO'),
(186, 'RUSIA', 'RU'),
(187, 'RUANDA', 'RW'),
(188, 'ARABIA SAUDí', 'SA'),
(189, 'ISLAS SALOMóN', 'SB'),
(190, 'SEYCHELLES', 'SC'),
(191, 'SUDáN', 'SD'),
(192, 'SUECIA', 'SE'),
(193, 'SINGAPUR', 'SG'),
(194, 'SANTA HELENA', 'SH'),
(195, 'ESLOVENIA', 'SI'),
(196, 'SVALBARD Y JAN MAYEN', 'SJ'),
(197, 'ESLOVAQUIA', 'SK'),
(198, 'SIERRA LEONA', 'SL'),
(199, 'SAN MARINO', 'SM'),
(200, 'SENEGAL', 'SN'),
(201, 'SOMALIA', 'SO'),
(202, 'SURINAM', 'SR'),
(203, 'SANTO TOMé Y PRíNCIPE', 'ST'),
(204, 'EL SALVADOR', 'SV'),
(205, 'SIRIA', 'SY'),
(206, 'SUAZILANDIA', 'SZ'),
(207, 'ISLAS TURCAS Y CAICOS', 'TC'),
(208, 'CHAD', 'TD'),
(209, 'TERRITORIOS AUSTRALES FRANCESES', 'TF'),
(210, 'TOGO', 'TG'),
(211, 'TAILANDIA', 'TH'),
(212, 'TAYIKISTáN', 'TJ'),
(213, 'TOKELAU', 'TK'),
(214, 'TIMOR ORIENTAL', 'TL'),
(215, 'TURKMENISTáN', 'TM'),
(216, 'TúNEZ', 'TN'),
(217, 'TONGA', 'TO'),
(218, 'TURQUíA', 'TR'),
(219, 'TRINIDAD Y TOBAGO', 'TT'),
(220, 'TUVALU', 'TV'),
(221, 'TAIWáN', 'TW'),
(222, 'TANZANIA', 'TZ'),
(223, 'UCRANIA', 'UA'),
(224, 'UGANDA', 'UG'),
(225, 'ISLAS ULTRAMARINAS DE ESTADOS UNIDOS', 'UM'),
(226, 'ESTADOS UNIDOS', 'US'),
(227, 'URUGUAY', 'UY'),
(228, 'UZBEKISTáN', 'UZ'),
(229, 'CIUDAD DEL VATICANO', 'VA'),
(230, 'SAN VICENTE Y LAS GRANADINAS', 'VC'),
(231, 'VENEZUELA', 'VE'),
(232, 'ISLAS VíRGENES BRITáNICAS', 'VG'),
(233, 'ISLAS VíRGENES DE LOS ESTADOS UNIDOS', 'VI'),
(234, 'VIETNAM', 'VN'),
(235, 'VANUATU', 'VU'),
(236, 'WALLIS Y FUTUNA', 'WF'),
(237, 'SAMOA', 'WS'),
(238, 'YEMEN', 'YE'),
(239, 'MAYOTTE', 'YT'),
(240, 'SUDáFRICA', 'ZA'),
(241, 'ZAMBIA', 'ZM'),
(242, 'ZIMBAWE', 'ZW');


--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`nacionalidad_id`) REFERENCES `nacionalidades` (`id`) ON UPDATE CASCADE;

```
###Base de datos de usuarios de app
```

--
-- Base de datos: `usuario`
--
CREATE DATABASE IF NOT EXISTS `usuario` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `usuario`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicacion`
--

CREATE TABLE IF NOT EXISTS `aplicacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  `fecha_alta` date NOT NULL,
  `url` varchar(75) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `aplicacion`
--

INSERT INTO `aplicacion` (`id`, `descripcion`, `fecha_alta`, `url`) VALUES
(1, 'PRIMER APP PHP', '2016-09-08', 'LOCALHOST/PRIMERPROYECTOPHP/'),
(2, 'PRIMER APP JAVA', '2016-09-08', 'LOCALHOST/PRIMERPROYECTOJAVA/');

--
-- Disparadores `aplicacion`
--
DROP TRIGGER IF EXISTS `logger_delete_aplicacion`;
DELIMITER //
CREATE TRIGGER `logger_delete_aplicacion` BEFORE DELETE ON `aplicacion`
 FOR EACH ROW INSERT INTO logger ( id_registro, fecha ,usuario ,tabla ,accion ,dato) VALUES (OLD.id, now(), user(), 'APLICACION' ,'DELETE' ,CONCAT( OLD.descripcion,', ', OLD.fecha_alta,', ',OLD.url))
//
DELIMITER ;
DROP TRIGGER IF EXISTS `logger_update_aplicacion`;
DELIMITER //
CREATE TRIGGER `logger_update_aplicacion` BEFORE UPDATE ON `aplicacion`
 FOR EACH ROW INSERT INTO logger ( id_registro, fecha ,usuario ,tabla ,accion ,dato) VALUES (OLD.id, now(), user(), 'APLICACION' ,'UPDATE' ,CONCAT( OLD.descripcion,', ', OLD.fecha_alta,', ',OLD.url))
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicacion_permiso`
--

CREATE TABLE IF NOT EXISTS `aplicacion_permiso` (
  `id_aplicacion` int(11) NOT NULL,
  `id_permiso` int(11) NOT NULL,
  PRIMARY KEY (`id_aplicacion`,`id_permiso`),
  KEY `id_aplicacion` (`id_aplicacion`),
  KEY `id_permiso` (`id_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aplicacion_permiso`
--

INSERT INTO `aplicacion_permiso` (`id_aplicacion`, `id_permiso`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicacion_usuario`
--

CREATE TABLE IF NOT EXISTS `aplicacion_usuario` (
  `id_aplicacion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_aplicacion`,`id_usuario`),
  KEY `id_aplicacion` (`id_aplicacion`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aplicacion_usuario`
--

INSERT INTO `aplicacion_usuario` (`id_aplicacion`, `id_usuario`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logger`
--

CREATE TABLE IF NOT EXISTS `logger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `tabla` varchar(30) NOT NULL,
  `accion` varchar(6) NOT NULL,
  `dato` text NOT NULL,
  `id_registro` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `logger`
--

INSERT INTO `logger` (`id`, `fecha`, `usuario`, `tabla`, `accion`, `dato`, `id_registro`) VALUES
(1, '2016-09-06', 'root@localhost', 'PERFIL', 'DELETE', 'PEPE, ARGENTO, 39443529, 1945-02-02', 1),
(2, '2016-09-07', 'root@localhost', 'PERFIL', 'UPDATE', 'PIPO, ARGENTO, 20456456, 1965-09-05', 1),
(3, '2016-09-07', 'root@localhost', 'ROL', 'DELETE', 'MODIFICADOR', 3),
(4, '2016-09-15', 'root@localhost', 'PERFIL', 'DELETE', 'PEPE, ARGENTO, 20456456, 1965-09-05', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE IF NOT EXISTS `perfil` (
  `id` int(11) NOT NULL,
  `referido_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`id`, `referido_id`) VALUES
(1, NULL),
(2, NULL);

--
-- Disparadores `perfil`
--
DROP TRIGGER IF EXISTS `persona`;
DELIMITER //
CREATE TRIGGER `persona` AFTER INSERT ON `perfil`
 FOR EACH ROW -- Edit trigger body code below this line. Do not edit lines above this one
INSERT INTO `persona` (id) VALUES (NEW.id)
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

CREATE TABLE IF NOT EXISTS `permiso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `permiso`
--

INSERT INTO `permiso` (`id`, `descripcion`) VALUES
(1, 'SELECT'),
(2, 'INSERT'),
(3, 'UPDATE'),
(4, 'DELETE');

--
-- Disparadores `permiso`
--
DROP TRIGGER IF EXISTS `logger_delete_permiso`;
DELIMITER //
CREATE TRIGGER `logger_delete_permiso` BEFORE DELETE ON `permiso`
 FOR EACH ROW INSERT INTO logger ( id_registro, fecha ,usuario, tabla ,accion ,dato) VALUES (OLD.id, now(), user(), 'PERMISO', 'DELETE' ,CONCAT( OLD.descripcion))
//
DELIMITER ;
DROP TRIGGER IF EXISTS `logger_update_permiso`;
DELIMITER //
CREATE TRIGGER `logger_update_permiso` BEFORE UPDATE ON `permiso`
 FOR EACH ROW INSERT INTO logger ( id_registro, fecha ,usuario, tabla ,accion ,dato) VALUES (OLD.id, now(), user(), 'PERMISO', 'UPDATE' ,CONCAT( OLD.descripcion))
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso_rol`
--

CREATE TABLE IF NOT EXISTS `permiso_rol` (
  `id_permiso` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id_permiso`,`id_rol`),
  KEY `id_rol` (`id_rol`),
  KEY `id_permiso` (`id_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `permiso_rol`
--

INSERT INTO `permiso_rol` (`id_permiso`, `id_rol`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(1, 2),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso_usuario`
--

CREATE TABLE IF NOT EXISTS `permiso_usuario` (
  `id_permiso` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_permiso`,`id_usuario`),
  KEY `id_permiso` (`id_permiso`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `dni` varchar(12) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `nombre`, `apellido`, `dni`, `fecha_nacimiento`) VALUES
(1, NULL, NULL, NULL, NULL),
(2, 'CESAR MATIAS', 'CURIQUEO', '39443529', '1996-06-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `descripcion`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'CREADOR');

--
-- Disparadores `rol`
--
DROP TRIGGER IF EXISTS `logger_delete_rol`;
DELIMITER //
CREATE TRIGGER `logger_delete_rol` BEFORE DELETE ON `rol`
 FOR EACH ROW INSERT INTO logger ( id_registro,fecha ,usuario ,tabla,accion ,dato) VALUES (OLD.id, now(), user(), 'ROL','DELETE' ,CONCAT( OLD.descripcion))
//
DELIMITER ;
DROP TRIGGER IF EXISTS `logger_update_rol`;
DELIMITER //
CREATE TRIGGER `logger_update_rol` BEFORE UPDATE ON `rol`
 FOR EACH ROW INSERT INTO logger ( id_registro,fecha ,usuario ,tabla,accion ,dato) VALUES (OLD.id, now(), user(), 'ROL','UPDATE' ,CONCAT( OLD.descripcion))
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol_usuario`
--

CREATE TABLE IF NOT EXISTS `rol_usuario` (
  `id_rol` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha_alta` date NOT NULL,
  PRIMARY KEY (`id_rol`,`id_usuario`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol_usuario`
--

INSERT INTO `rol_usuario` (`id_rol`, `id_usuario`, `fecha_alta`) VALUES
(1, 1, '2016-09-01'),
(2, 2, '2016-09-05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `contrasenia` varchar(44) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `contrasenia`, `estado`) VALUES
(1, 'PEPE', 'PEPE', 1),
(2, 'JOSE', 'JOSE', 1);

--
-- Disparadores `usuario`
--
DROP TRIGGER IF EXISTS `USUARIO`;
DELIMITER //
CREATE TRIGGER `USUARIO` BEFORE INSERT ON `usuario`
 FOR EACH ROW SET NEW.contrasenia = SHA1(NEW.contrasenia)
//
DELIMITER ;
DROP TRIGGER IF EXISTS `logger_delete_usuario`;
DELIMITER //
CREATE TRIGGER `logger_delete_usuario` BEFORE DELETE ON `usuario`
 FOR EACH ROW INSERT INTO logger ( id_registro, fecha ,usuario ,accion ,dato) VALUES (OLD.id, now(), user(),'DELETE' ,CONCAT(OLD.nombre,', ',OLD.contrasenia,', ',OLD.estado))
//
DELIMITER ;
DROP TRIGGER IF EXISTS `logger_update_usuario`;
DELIMITER //
CREATE TRIGGER `logger_update_usuario` BEFORE UPDATE ON `usuario`
 FOR EACH ROW INSERT INTO logger ( id_registro,fecha ,usuario ,accion ,dato) VALUES (OLD.id, now(), user(),'UPDATE',CONCAT(OLD.nombre,', ',OLD.contrasenia,', ',OLD.estado))
//
DELIMITER ;
DROP TRIGGER IF EXISTS `perfil`;
DELIMITER //
CREATE TRIGGER `perfil` AFTER INSERT ON `usuario`
 FOR EACH ROW -- Edit trigger body code below this line. Do not edit lines above this one

INSERT INTO logger ( id ) VALUES (NEW.id)
//
DELIMITER ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aplicacion_permiso`
--
ALTER TABLE `aplicacion_permiso`
  ADD CONSTRAINT `aplicacion_permiso_ibfk_1` FOREIGN KEY (`id_permiso`) REFERENCES `permiso` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `aplicacion_permiso_ibfk_2` FOREIGN KEY (`id_aplicacion`) REFERENCES `aplicacion` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `aplicacion_usuario`
--
ALTER TABLE `aplicacion_usuario`
  ADD CONSTRAINT `aplicacion_usuario_ibfk_1` FOREIGN KEY (`id_aplicacion`) REFERENCES `aplicacion` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `aplicacion_usuario_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `perfil`
--
ALTER TABLE `perfil`
  ADD CONSTRAINT `perfil_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `permiso_rol`
--
ALTER TABLE `permiso_rol`
  ADD CONSTRAINT `permiso_rol_ibfk_1` FOREIGN KEY (`id_permiso`) REFERENCES `permiso` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `permiso_rol_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `permiso_usuario`
--
ALTER TABLE `permiso_usuario`
  ADD CONSTRAINT `permiso_usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `permiso_usuario_ibfk_2` FOREIGN KEY (`id_permiso`) REFERENCES `permiso` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `fk_persona_perfil1` FOREIGN KEY (`id`) REFERENCES `perfil` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `rol_usuario`
--
ALTER TABLE `rol_usuario`
  ADD CONSTRAINT `rol_usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `rol_usuario_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_perfil1` FOREIGN KEY (`id`) REFERENCES `perfil` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

```
