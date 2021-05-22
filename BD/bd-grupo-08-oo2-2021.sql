-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bd-grupo-08-oo2-2021
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd-grupo-08-oo2-2021
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd-grupo-08-oo2-2021` DEFAULT CHARACTER SET utf8 ;
USE `bd-grupo-08-oo2-2021` ;

-- -----------------------------------------------------
-- Table `bd-grupo-08-oo2-2021`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-grupo-08-oo2-2021`.`persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nroDocumento` INT(11) NULL,
  `tipoDocumento` VARCHAR(45) NULL,
  PRIMARY KEY (`idPersona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-grupo-08-oo2-2021`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-grupo-08-oo2-2021`.`perfil` (
  `idPerfil` INT NOT NULL AUTO_INCREMENT,
  `tipoDePerfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPerfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-grupo-08-oo2-2021`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-grupo-08-oo2-2021`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `idPersona` INT NOT NULL,
  `idPerfil` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_persona_idx` (`idPersona` ASC),
  INDEX `fk_usuario_perfil_idx` (`idPerfil` ASC),
  CONSTRAINT `fk_usuario_persona`
    FOREIGN KEY (`idPersona`)
    REFERENCES `bd-grupo-08-oo2-2021`.`persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_perfil`
    FOREIGN KEY (`idPerfil`)
    REFERENCES `bd-grupo-08-oo2-2021`.`perfil` (`idPerfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
