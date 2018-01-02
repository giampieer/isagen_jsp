SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `relacion` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
USE `relacion` ;

-- -----------------------------------------------------
-- Table `relacion`.`jefe`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`jefe` (
  `CODJEFE` INT(11) NOT NULL ,
  `NOMBJEFE` VARCHAR(40) NOT NULL ,
  `EMAJEFE` VARCHAR(40) NOT NULL ,
  `TELFJEFE` VARCHAR(9) NOT NULL ,
  `AREAJEFE` VARCHAR(20) NOT NULL ,
  `ID` VARCHAR(20) NOT NULL ,
  `PASS` INT(4) NOT NULL ,
  PRIMARY KEY (`CODJEFE`) ,
  UNIQUE INDEX `ID` (`ID` ASC) )
ENGINE = InnoDB;

INSERT INTO `jefe` (`CODJEFE`, `NOMBJEFE`, `EMAJEFE`, `TELFJEFE`, `AREAJEFE`, `ID`, `PASS`) VALUES
(3, 'MARCO', 'marco_valega_ramirez@hotmail.com', '923144865', 'Administracion', 'marco', 1111),
(2, 'LUIS', 'luis._12@hotmail.com', '945286360', 'Administracion', 'luis', 1111),
(1, 'GIAMPIEER', 'giampieer_95@gmail.com', '964233752', 'Finanzas', 'giampieer24', 1111),
(4, 'CARLOS', 'giancarlos.gp_98@outlook.es', '988985595', 'Administracion', 'carlos', 1111),
(5, 'JOSE', 'jose_99@hotmial.es', '976716625', 'Administracion', 'jose', 1111),
(6, 'MARIA', 'maria_65@hotmail.es', '966585456', 'Administracion', 'maria', 1111),
(7, 'BRUNO', 'bruno_64@hotmail.com', '998560704', 'Finanzas', 'bruno', 1111),
(8, 'EMILIANO', 'emiliano32@hotmail.es', '960220243', 'Administracion', 'emiliano', 1111),
(9, 'PABLO', 'pablo_75@outlook.es', '985965456', 'Finanzas', 'pablo', 1111),
(10, 'JUAN', 'juan56@hotmail.es', '942153697', 'Finanzas', 'juan', 1111),
(11, 'OMAR', 'omar_48@hotmail.es', '985687752', 'Finanzas', 'omar', 1111),
(12, 'FRANCISCO', 'francisco_23@hotmail.es', '978542314', 'Administracion', 'francisco', 1111),
(13, 'RONAL', 'ronal_15@hotmail.es', '935476929', 'Administracion', 'ronal', 1111),
(14, 'LEONARDO', 'leonarlo_65@hotmail.com', '962548545', 'Informatica', 'leonardo', 1111),
(15, 'IVAN', 'ivan_45@hotmail.es', '956842357', 'Administracion', 'ivan', 1111),
(16, 'MANUEL', 'manuel.199@hotmail.com', '965234144', 'Informatica', 'manuel', 1111),
(17, 'VALERIA', 'valeria_195@hotmail.es', '956874234', 'Informatica', 'valeria', 1111),
(18, 'ARTURO', 'arturo_61@hotmail.es', '985472657', 'Administracion', 'arturo', 1111);

-- -----------------------------------------------------
-- Table `relacion`.`proy`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`proy` (
  `NUMERO` INT(4) NOT NULL ,
  `TITULO` VARCHAR(20) NOT NULL ,
  `DURACION` VARCHAR(20) NOT NULL ,
  `DESCRIPCION` VARCHAR(200) NOT NULL ,
  `TIPO` VARCHAR(20) NOT NULL ,
  `FASES` VARCHAR(20) NOT NULL ,
  `INICIO` VARCHAR(20) NOT NULL ,
  `FIN` VARCHAR(20) NOT NULL ,
  `GASTOS` VARCHAR(20) NOT NULL ,
  `CODJEFE` INT(11) NOT NULL ,
  PRIMARY KEY (`NUMERO`) ,
  UNIQUE INDEX `CODJEFE` (`CODJEFE` ASC) ,
  CONSTRAINT `fk_proyecto_jefe`
    FOREIGN KEY (`CODJEFE` )
    REFERENCES `relacion`.`jefe` (`CODJEFE` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `proy` (`NUMERO`, `TITULO`, `DURACION`, `DESCRIPCION`, `TIPO`, `FASES`, `INICIO`, `FIN`, `GASTOS`, `CODJEFE`) VALUES
(3, 'Proyecto3', '3 meses', 'Sobrecarga  de energia', 'Normalizados', '3', '2016-11-04', '2017-02-16', '$1500', 3),
(2, 'Proyecto2', '8 meses', 'Aumento de ganancias', 'Privados', '4', '2016-05-02', '2017-01-16', '$1500', 2),
(1, 'Proyecto1', '11meses', 'Aumento de ganancias', 'Experimentales', '3', '2016-11-17', '2017-03-08', '$1500', 1),
(4, 'Proyecto4', '9 meses', 'Aumento de ganacia', 'Normalizados', '3', '2016-07-31', '2017-04-04', '$1200', 11),
(5, 'Proyecto5', '5 meses', 'Sobrecarga de energia', 'Productivos', '4', '2016-04-03', '2016-09-05', '$1000', 10),
(6, 'Proyecto6', '10 meses', 'Aumento de ganancia ', 'Privados', '4', '2016-09-07', '2017-07-06', '$1500', 14),
(7, 'proyecto7', '6 meses', 'Sobrecarga de energia', 'Productivos', '4', '2016-05-03', '2016-12-22', '$1250', 15),
(8, 'proyecto8', '4 meses', 'Aumento de ganancia', 'Sociales', '5', '2016-02-20', '2016-07-30', '$1825', 18),
(9, 'Proyecto9', '7 meses', 'Sobrecarga de energia', 'Investigacion', '2', '2016-06-05', '2016-01-03', '$1650', 17),
(10, 'Proyecto10', '2 meses', 'Aumento de ganacia', 'Privados', '4', '2016-06-04', '2016-08-18', '$900', 4),
(11, 'Proyecto11', '3 meses', 'Sobrecarga de energia', 'Normalizados', '2', '2016-10-25', '2017-01-08', '$1300', 9),
(12, 'Proyecto12', '6 meses', 'Aumento de ganancia', 'Normalizados', '4', '2016-07-20', '2017-02-04', '$1300', 5),
(13, 'Proyecto13', '5 meses', 'Sobrecarga de energia', 'Normalizados', '3', '2016-04-03', '2016-09-28', '$1000', 13),
(14, 'Proyecto14', '5 meses', 'Aumento de ganancia', 'Productivos', '4', '2016-10-19', '2017-03-20', '$1200', 7);


-- -----------------------------------------------------
-- Table `relacion`.`actividades`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`actividades` (
  `numero` INT(11) NOT NULL ,
  `actividad` VARCHAR(100) NOT NULL ,
  `duracion` VARCHAR(20) NOT NULL ,
  `reponsable` VARCHAR(30) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`numero`) ,
  INDEX `fk_actividades_proyecto_idx` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_actividades_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `actividades` (`numero`, `actividad`, `duracion`, `reponsable`, `NUMPROY`) VALUES
(1, 'Encuestas al publico', '2 semanas', 'Anibal', 1),
(2, 'Encuesta al publico', '2 semanas', 'pedro', 2),
(3, 'Encuesta al publico', '3 semanas', 'michael', 3),
(4, 'Encuesta al publico', '3 semanas', 'kevin', 4),
(5, 'Encuesta al publico', '4 semanas', 'Alejandro', 5),
(6, 'Encuesta al publico', '1 semana', 'Cristhian', 6),
(7, 'Encuesta al publico', '4 semanas', 'Jhonatan', 7),
(8, 'Encuesta al publico', '3 semanas', 'piero', 8),
(9, 'Encuesta al publico', '5 semanas', 'Juancarlos', 9),
(10, 'Encuesta al publico', '2 semanas', 'Jampool', 10),
(11, 'Encuesta al publico', '1 semana', 'Yuber', 11),
(12, 'Encuesta al publico', '2 semanas', 'Nimer', 12),
(13, 'Encuesta al publico', '1 semana', 'Lisandro', 13),
(14, 'Encuesta al publico', '2 semana', 'Yordy', 14),
(15, 'Encuesta al publico', '2 semana', 'Yerson', 15);

-- -----------------------------------------------------
-- Table `relacion`.`cambios`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`cambios` (
  `NUMERO` INT(11) NOT NULL ,
  `FECHA` VARCHAR(50) NOT NULL ,
  `PROPOSITO` VARCHAR(200) NOT NULL ,
  `IMPORTANCIA` VARCHAR(200) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`NUMERO`) ,
  INDEX `fk_cambios_proyecto_idx` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_cambios_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `cambios` (`NUMERO`, `FECHA`, `PROPOSITO`, `IMPORTANCIA`, `NUMPROY`) VALUES
(1, '2016-03-05', 'Interes', 'Ganancias', 1),
(2, '2016-07-14', 'Interes', 'Ganancias', 2),
(3, '2016-09-17', 'Interes', 'Ganancias', 3),
(4, '2016-10-29', 'Interes', 'Ganancias', 4),
(5, '2016-09-07', 'Interes', 'Ganancias', 5),
(6, '2016-09-22', 'Interes', 'Ganancias', 6),
(7, '2016-12-21', 'Interes', 'Ganancias', 7),
(8, '2016-12-20', 'Interes', 'Ganancias', 8),
(9, '2016-02-23', 'Interes', 'Ganancias', 9),
(10, '2016-12-20', 'Interes', 'Ganancias', 10),
(11, '2016-12-19', 'Interes', 'Ganancias', 11),
(12, '2016-12-23', 'Interes', 'Ganancias', 12),
(13, '2016-12-20', 'Interes', 'Ganancias', 13),
(14, '2016-10-26', 'Interes', 'Ganancias', 14),
(15, '2016-12-17', 'Interes', 'Ganancias', 15);

-- -----------------------------------------------------
-- Table `relacion`.`controldecalidad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`controldecalidad` (
  `numero` INT(11) NOT NULL ,
  `plandegestion` VARCHAR(100) NOT NULL ,
  `plandemejoradecalidad` VARCHAR(100) NOT NULL ,
  `metricasdecalidad` VARCHAR(100) NOT NULL ,
  `actualizacionesdeladocumentacion` VARCHAR(100) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`numero`) ,
  INDEX `fk_controldecalidad_proy_idx` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_controldecalidad_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `controldecalidad` (`numero`, `plandegestion`, `plandemejoradecalidad`, `metricasdecalidad`, `actualizacionesdeladocumentacion`, `NUMPROY`) VALUES
(1, 'Orden', 'Respuestas al admin', 'Correccion - Mantenimiento - Facilidad de uso - Integridad', 'problemas solucionados      ', 1),
(2, 'Orden', 'Respuestas al admin', 'Operacion - Revision - Transicion', 'Problemas solucionados ', 2),
(3, ' Orden', 'Respuesta al admin', 'Ninguna metrica Realizada', 'Problemas solucionados', 3),
(4, 'Orden', 'Respuesta al admin', 'Numero de Errores - Defectos Encontrados', 'Problemas solucionados', 4),
(5, 'Orden', 'Respuesta al admin', 'Operacion - Revision - Transicion', 'Problemas solucionados', 5),
(6, 'Orden', 'Respuesta al admin', 'Operacion - Revision - Transicion', 'Problemas solucionados', 6),
(7, 'Orden', 'Respuesta al admin', 'Correccion - Mantenimiento - Facilidad de uso - Integridad', 'Problemas solucionados', 7),
(8, 'Orden', 'Respuesta Admin', 'Ninguna metrica Realizada', 'Problemas  solucionados', 8),
(9, 'Orden', 'Respuesta al admin', 'Operacion - Revision - Transicion', 'Problemas solucionados', 9),
(10, 'Orden', 'Respuesta al admin', 'Operacion - Revision - Transicion', 'Problemas solucionados', 10),
(11, 'Orden ', 'Respuesta al admin', 'Operacion - Revision - Transicion', 'Problemas solucionados', 11),
(12, 'Orden', 'Respuesta al admin', 'Numero de Errores - Defectos Encontrados', 'Problemas solucionados', 12),
(13, 'Orden ', 'Respuesta al admin', 'Operacion - Revision - Transicion', 'Problemas solucionados', 13),
(14, 'Orden ', 'Respuesta al admin', 'Correccion - Mantenimiento - Facilidad de uso - Integridad', 'Problemas solucionados', 14),
(15, 'Orden', 'Respuesta al admin', 'Operacion - Revision - Transicion', 'Problemas solucionados', 15);



-- -----------------------------------------------------
-- Table `relacion`.`interesados`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`interesados` (
  `NUMERO` INT(4) NOT NULL ,
  `NOMBRE` VARCHAR(30) NOT NULL ,
  `IMPORTE` VARCHAR(50) NOT NULL ,
  `NECESIDADES` VARCHAR(50) NOT NULL ,
  `INTERES` VARCHAR(50) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`NUMERO`) ,
  INDEX `fk_interesados_proy_idx` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_interesados_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `interesados` (`NUMERO`, `NOMBRE`, `IMPORTE`, `NECESIDADES`, `INTERES`, `NUMPROY`) VALUES
(1, 'Giampieer  ', 'Rapidez en buscar soluciones', 'Colaborativo', 'Finaciero', 1),
(2, 'carlos', 'Implementador de diseño', 'Colaborativo ', 'Finaciero', 2),
(3, 'marcos', 'Rapidez en buscar soluciones', 'colaborativo', 'interez', 3),
(4, 'luis', 'implementador de diseño', 'Colaborativo', 'Finaciero', 4),
(14, 'manuel', 'Rapidez en buscar soluciones', 'Colaborativo', 'Finaciero', 14),
(5, 'pablo', 'Rapidez en buscar soluciones', 'Colaborativo', 'Finaciero', 5),
(6, 'omar', 'Implentador de diseño', 'Colaborativo', 'Finaciero', 6),
(7, 'Francisco', 'Rapidez en reportar soluciones', 'Colaborativo', 'Finaciero', 7),
(8, 'ivan', 'Implementador d diseño', 'Colaborativo', 'Finaciero', 8),
(9, 'Emiliano', 'Rapidez en reportar soluciones', 'Colaborativo', 'Finaciero', 9),
(10, 'valeria', 'Implementador de diseño', 'Colaborativo', 'Finaciero', 10),
(11, 'leonardo', 'Rapidez en buscar soluciones', 'Colaborativo', 'Finaciero', 11),
(12, 'jose', 'Rapidez en buscar soluciones', 'Colaborativo', 'Finaciero', 12),
(13, 'maria', 'Implementador de diseño', 'Colaborativo', 'Finaciero', 13),
(15, 'pedro', 'Implementador de diseño', 'Colaborativo', 'Finaciero', 15);

-- -----------------------------------------------------
-- Table `relacion`.`objetivo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`objetivo` (
  `NUMERO` INT(11) NOT NULL ,
  `NIVEL` VARCHAR(20) NOT NULL ,
  `DESCRIPCION` VARCHAR(200) NOT NULL ,
  `FINALIDAD` VARCHAR(200) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`NUMERO`) ,
  UNIQUE INDEX `NUMPROY` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_objetivo_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `objetivo` (`NUMERO`, `NIVEL`, `DESCRIPCION`, `FINALIDAD`, `NUMPROY`) VALUES
(3, 'Grave', 'Buscar las posibles causas de fugas', 'Satisfaccion del personal', 3),
(2, 'Grave', 'Despido del personal', 'Solucion en los pagos', 2),
(1, 'Grave', 'Generar Ingresos Electricos ', 'Satisfaccion del clientes', 1),
(4, 'Grave', 'Generar ingresos  Electricos', 'Satisfacion del cliente', 4),
(5, 'Leve', 'Despido del personal', 'Solucion en los pagos', 5),
(6, 'Muy Grave', 'Generar ingresos Electricos', 'Satisfacion  del cliente', 6),
(7, 'Grave', 'Despido del personal', 'Solucion en los pagos', 7),
(8, 'Grave', 'Generar ingresos Electricos', 'Satisfacion del clientes', 8),
(9, 'Leve', 'Despido del personal', 'Satisfacion en los pagos', 9),
(10, 'Leve', 'Busacar las posibles causas de fugas', 'satisfacion del personal', 10),
(11, 'Grave', 'Despido del personal', 'Satisfacion en los pagos', 11),
(12, 'Grave', 'Generar ingresos Electricos', 'Satisfacion del cliente', 12),
(13, 'Leve', 'Buscar las posibles causas de la fuga', 'satisfacion del personal', 13),
(14, 'Grave', 'Despido del personal', 'Satisfacion en los pagos', 14),
(15, 'Muy Grave', 'Generar ingresos Electricos', 'Satisfacion al  cliente', 15);

-- -----------------------------------------------------
-- Table `relacion`.`personal`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`personal` (
  `CODPERSONAL` INT(11) NOT NULL ,
  `NOMBPERSONAL` VARCHAR(40) NOT NULL ,
  `EMAPERSONAL` VARCHAR(40) NOT NULL ,
  `TELFPERSONAL` VARCHAR(9) NOT NULL ,
  `HORAS` VARCHAR(10) NOT NULL ,
  `DIAS` VARCHAR(10) NOT NULL ,
  `ID` VARCHAR(20) NOT NULL ,
  `PASS` VARCHAR(4) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`CODPERSONAL`) ,
  UNIQUE INDEX `ID` (`ID` ASC) ,
  INDEX `fk_personal_proyecto_idx` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_personal_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `personal` (`CODPERSONAL`, `NOMBPERSONAL`, `EMAPERSONAL`, `TELFPERSONAL`, `HORAS`, `DIAS`, `ID`, `PASS`, `NUMPROY`) VALUES
(1, 'Marcos', 'marco_valega_ramirez@hotmail.com', '988985595', '1', '2', 'marcos', '1111', 1),
(2, 'Ronal', 'ronal@hotmail.es', '976585558', '2', '2', 'ronal', '1111', 2),
(3, 'Giampieer', 'giampieer.92@hotmail.es', '956458224', '4', '4', 'giampieer', '1111', 3),
(4, 'Luis', 'luis._12@hotmail.com', '956485225', '2', '3', 'luis', '1111', 4),
(5, 'CARLOS', 'carlos_94@hotmail.es', '976716625', '1', '2', 'carlos', '1111', 5),
(6, 'PABLO', 'pablo_45@hotmail.com', '965485754', '1', '2', 'pablo', '1111', 6),
(7, 'MARIA', 'maria_55@hotmail.es', '965412584', '1', '2', 'maria', '1111', 7),
(8, 'JUAN', 'juan_85@hotmail.es', '958746567', '3', '3', 'juan', '1111', 8),
(9, 'FRANCISCO', 'fran_33@hotmil.es', '979546635', '6', '4', 'francisco', '1111', 9),
(10, 'LEONARDO', 'leonardo_25@hotmail.es', '954789634', '4', '5', 'leonardo', '1111', 10),
(11, 'ARTURO', 'arturo2@hotmail.es', '95681835', '3', '5', 'arturo', '1111', 11),
(12, 'BRUNO', 'bruno_2@hotmail.com', '999958687', '4', '2', 'bruno', '1111', 12),
(13, 'VALERIA', 'valeria_325@hotmail.es', '969858886', '5', '6', 'valeria', '1111', 13),
(14, 'EMILIANO', 'emiliano_65@hotmail.es', '956548864', '3', '5', 'emiliano', '1111', 14),
(15, 'IVAN', 'ivan_52@hotmail.es', '956855875', '4', '6', 'ivan', '1111', 15);

-- -----------------------------------------------------
-- Table `relacion`.`problema`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`problema` (
  `NUMERO` INT(4) NOT NULL ,
  `NIVEL` VARCHAR(20) NOT NULL ,
  `DESCRIPCION` VARCHAR(200) NOT NULL ,
  `PERJUDICADO` VARCHAR(200) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`NUMERO`) ,
  UNIQUE INDEX `NUMPROY` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_problema_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `problema` (`NUMERO`, `NIVEL`, `DESCRIPCION`, `PERJUDICADO`, `NUMPROY`) VALUES
(3, 'Grave', 'Fugas de Electricidad', '3 trabajadores', 3),
(2, 'Muy Grave', 'Aumento de ganancias', '2 trabajadores', 2),
(1, 'Grave', 'Perdida en ganacias', '13 trabajadores', 1),
(4, 'Grave', 'Perdida de ganancias', '4 trabajadores', 4),
(5, 'Leve', 'Perdida de ganancias', '2 trabajadores', 5),
(6, 'Grave', 'Aumento de ganancias', '5 trabajadores', 6),
(7, 'Leve', 'Perdida de ganancias ', '2 trabajadores', 7),
(8, 'Leve', 'Perdida de ganancias', '2 trabajadores', 8),
(9, 'Grave', 'Fuga de electicidad', '5 trabajadores', 9),
(10, 'Grave', 'Aumento de ganancias ', '3 trabajadores', 10),
(11, 'Leve', 'Fuga de electricidad', '5 trabajadores', 11),
(12, 'Grave', 'Perdida de ganancias', '4 trabajadores', 12),
(13, 'Grave', 'Fuga de electricidad', '6 trabajadores', 13),
(14, 'Leve', 'Perdida de ganancias', '2 trabajadores', 14),
(15, 'Leve', 'Aumento de ganancias', '2 trabajadores', 15);

-- -----------------------------------------------------
-- Table `relacion`.`requisito`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`requisito` (
  `NUMERO` INT(4) NOT NULL ,
  `ALCANCE` VARCHAR(50) NOT NULL ,
  `PERSONAL` INT(4) NOT NULL ,
  `REUNIONES` INT(4) NOT NULL ,
  `DESCRIPCION` VARCHAR(50) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`NUMERO`) ,
  UNIQUE INDEX `NUMPROY` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_requisito_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `requisito` (`NUMERO`, `ALCANCE`, `PERSONAL`, `REUNIONES`, `DESCRIPCION`, `NUMPROY`) VALUES
(3, 'Medio', 4, 8, 'Aumento de ganancias', 3),
(2, 'Menor', 6, 5, 'Aumento de ganancias', 2),
(1, 'Medio', 12, 21, 'Gente colaborartiva', 1),
(4, 'Medio', 7, 3, 'Gente colaborativa', 4),
(5, 'Menor', 4, 2, 'Gente colaborativa', 5),
(6, 'Medio', 4, 3, 'Gente colaborativa', 6),
(7, 'Medio', 3, 3, 'Aumento de ganacia', 7),
(8, 'Menor', 5, 2, 'Gente colaborativa', 8),
(9, 'Medio', 3, 4, 'Aumento de ganacia', 9),
(10, 'Medio', 4, 4, 'Aumento de ganacia', 10),
(11, 'Medio', 5, 2, 'Gente colaborativa', 11),
(12, 'Menor', 3, 4, 'Aumenta de ganacia', 12),
(13, 'Menor', 3, 2, 'Aumento de ganacia', 13),
(14, 'Medio', 3, 4, 'Aumento de ganacia', 14),
(15, 'Menor', 2, 4, 'Gente colaborativa', 15);

-- -----------------------------------------------------
-- Table `relacion`.`reuniones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`reuniones` (
  `NUMERO` INT(11) NOT NULL ,
  `PERSONAL` VARCHAR(40) NOT NULL ,
  `FECHA` VARCHAR(50) NOT NULL ,
  `ACUERDOS` VARCHAR(50) NOT NULL ,
  `REUNION` VARCHAR(50) NOT NULL ,
  `DURACION` VARCHAR(50) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`NUMERO`) ,
  INDEX `fk_reuniones_proyecto_idx` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_reuniones_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `reuniones` (`NUMERO`, `PERSONAL`, `FECHA`, `ACUERDOS`, `REUNION`, `DURACION`, `NUMPROY`) VALUES
(2, '23', '2016-11-02', 'Cambiar horarios laborales', '2016-11-16', '5 horas', 2),
(1, '17', '2016-11-17', 'Cambiar horarios laborales', '2016-11-16', '11 horas', 1),
(3, '9', '2016-11-09', 'Negociacion Internacional', '2016-11-17', '2 horas', 3),
(4, '32', '2016-11-02', 'Cambiar horarios laborales', '2017-01-12', '11 horas', 4),
(5, '12', '2016-11-11', 'Cambiar personal laboral', '2016-11-20', '4 horas', 5),
(6, '10', '2016-11-10', 'Registro de consumo de energia', '2017-01-24', '5 horas', 6),
(7, '13', '2016-03-02', 'Cambiar personal laboral', '2016-04-02', '2 horas', 7),
(8, '14', '2016-05-29', 'Negozacion internacional', '2016-06-28', '3 horas', 8),
(9, '6 ', '2016-06-04', 'Cambiar personal laboral', '2016-08-04', '3 horas', 9),
(10, '6', '2016-10-27', 'Cambiar personal laboral', '2016-11-08', '5 horas', 10),
(11, '7', '2016-10-28', 'Registro de consumo de energia', '2016-12-09', '3 horas', 11),
(12, '9', '2016-11-29', 'cambiar horarios laborales', '2016-12-21', '2 horas', 12),
(13, '11', '2016-09-07', 'Cambiar horarios laborales', '2016-12-17', '6 horas', 13),
(14, '16', '2016-05-10', 'Registro de consumo de energia ', '2016-08-11', '6 horas', 14),
(15, '14', '2016-05-04', 'Cambiar horarios laborables', '2016-08-03', '6 horas', 15);

-- -----------------------------------------------------
-- Table `relacion`.`riesgos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`riesgos` (
  `numero` INT(11) NOT NULL ,
  `nivel` VARCHAR(20) NOT NULL ,
  `descripcion` VARCHAR(200) NOT NULL ,
  `NUMPROY` INT(4) NOT NULL ,
  PRIMARY KEY (`numero`) ,
  INDEX `fk_riesgos_proy_idx` (`NUMPROY` ASC) ,
  CONSTRAINT `fk_riesgos_proyecto`
    FOREIGN KEY (`NUMPROY` )
    REFERENCES `relacion`.`proy` (`NUMERO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `riesgos` (`numero`, `nivel`, `descripcion`, `NUMPROY`) VALUES
(3, 'Leve', 'Poca iluminacion', 3),
(2, 'Grave', 'Poca energia', 2),
(1, 'Muy Grave', 'Falta del personal', 1),
(4, 'Leve', 'Poca implementacion', 4),
(5, 'Grave', 'Falta de materiales', 5),
(6, 'Leve', 'Falta de recursos', 6),
(7, 'Grave', 'Poco empeño', 7),
(8, 'Muy Grave', 'Falta de administrador', 8),
(9, 'Leve', 'Poca  informacion', 9),
(10, 'Leve', 'Falta empleados', 10),
(11, 'Leve', 'Poco mantenimiento', 11),
(12, 'Grave', 'Poca importancia', 12),
(13, 'Leve', 'Falta de interez', 13),
(14, 'Leve', 'Poco compromiso', 14),
(15, 'Grave', 'Poca animacion', 15);

-- -----------------------------------------------------
-- Table `relacion`.`solucion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `relacion`.`solucion` (
  `numero` INT(11) NOT NULL ,
  `nivel` VARCHAR(20) NOT NULL ,
  `descripcion` VARCHAR(200) NOT NULL ,
  `NUMRIESGO` INT(11) NOT NULL ,
  PRIMARY KEY (`numero`) ,
  INDEX `fk_solucion_riesgos_idx` (`NUMRIESGO` ASC) ,
  CONSTRAINT `fk_solucion_riesgos`
    FOREIGN KEY (`NUMRIESGO` )
    REFERENCES `relacion`.`riesgos` (`numero` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `solucion` (`numero`, `nivel`, `descripcion`, `NUMRIESGO`) VALUES
(2, 'Intermedio', 'invertir en el mantenimiento', 2),
(1, 'Intermedio', 'Advertencia o despido', 1),
(3, 'Intermedio', 'advertencia o despido', 3),
(4, 'Intermedio', 'invertir en el mantenimiento', 4),
(5, 'Intermedio', 'Advertencia o despido', 5),
(6, 'Intermedio', 'Advertencia o despido', 6),
(7, 'Complejo ', 'Invertir en el mantenimiento', 7),
(8, 'Intermedio', 'advertencia o despido', 8),
(9, 'Intermedio', 'Invertir en el mantenimiento', 9),
(10, 'Complejo', 'Advertencia o despido', 10),
(11, 'Complejo', 'Advertencia o despido', 11),
(12, 'Intermedio', 'Invertir en el mantenimiento', 12),
(13, 'Intermedio', 'Advertencia o despido', 13),
(14, 'Complejo', 'Invertir en el Mantenimiento', 14),
(15, 'Complejo', 'Advertencia o despido', 15);

USE `relacion` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;