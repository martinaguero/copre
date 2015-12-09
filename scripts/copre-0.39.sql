-- ----------------------------------------------------------------------------
-- Software        :  JPDB Admin for MariaDB - Free Edition [Linux]
-- Server Version  :  (Ubuntu) - 5.5.34-0ubuntu0.12.04.1
-- Database        :  copre
-- Host            :  localhost
-- Date/Time       :  02/26/2014 10:49:17 PM
-- ----------------------------------------------------------------------------

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';
SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT;
SET NAMES latin1;

DROP TABLE IF EXISTS `Bid`;
CREATE TABLE `Bid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `copre_id` int(11) NOT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `comment` text,
  `accepted` tinyint(1) DEFAULT NULL,
  `participant_id` int(11) DEFAULT NULL,
  `requirement_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

ALTER TABLE `Bid` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Bid` VALUES ('66', '0', '35000.00', 'Oferta al requerimiento #63', '1', '107', '63');
INSERT INTO `Bid` VALUES ('67', '0', '25000.00', 'Oferta al requerimiento #62', NULL, '107', '62');
INSERT INTO `Bid` VALUES ('68', '0', '47000.00', 'Oferta al requerimiento #59', NULL, '107', '59');
COMMIT;
ALTER TABLE `Bid` ENABLE KEYS;

DROP TABLE IF EXISTS `Brand`;
CREATE TABLE `Brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

ALTER TABLE `Brand` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Brand` VALUES ('1', 'Nestlé');
INSERT INTO `Brand` VALUES ('2', 'Calisa');
INSERT INTO `Brand` VALUES ('3', 'Arcor');
INSERT INTO `Brand` VALUES ('4', 'Granja del Sol');
INSERT INTO `Brand` VALUES ('5', 'SanCor');
INSERT INTO `Brand` VALUES ('6', 'Taragüí');
INSERT INTO `Brand` VALUES ('7', 'Bagley');
COMMIT;
ALTER TABLE `Brand` ENABLE KEYS;

DROP TABLE IF EXISTS `Category`;
CREATE TABLE `Category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `copre_id` int(11) NOT NULL,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

ALTER TABLE `Category` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Category` VALUES ('1', '0', 'Congelados');
INSERT INTO `Category` VALUES ('2', '0', 'Conservas');
INSERT INTO `Category` VALUES ('3', '0', 'Frescos');
INSERT INTO `Category` VALUES ('4', '0', 'Infusiones');
INSERT INTO `Category` VALUES ('5', '0', 'Galletitas');
COMMIT;
ALTER TABLE `Category` ENABLE KEYS;

DROP TABLE IF EXISTS `Category_product`;
CREATE TABLE `Category_product` (
  `category_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `Category_product` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Category_product` VALUES ('1', '37');
INSERT INTO `Category_product` VALUES ('2', '38');
INSERT INTO `Category_product` VALUES ('3', '39');
INSERT INTO `Category_product` VALUES ('2', '40');
INSERT INTO `Category_product` VALUES ('3', '41');
INSERT INTO `Category_product` VALUES ('4', '42');
INSERT INTO `Category_product` VALUES ('3', '43');
INSERT INTO `Category_product` VALUES ('3', '44');
INSERT INTO `Category_product` VALUES ('2', '45');
INSERT INTO `Category_product` VALUES ('3', '46');
INSERT INTO `Category_product` VALUES ('5', '47');
INSERT INTO `Category_product` VALUES ('5', '48');
INSERT INTO `Category_product` VALUES ('4', '49');
INSERT INTO `Category_product` VALUES ('5', '50');
INSERT INTO `Category_product` VALUES ('2', '51');
INSERT INTO `Category_product` VALUES ('1', '52');
INSERT INTO `Category_product` VALUES ('5', '53');
COMMIT;
ALTER TABLE `Category_product` ENABLE KEYS;

DROP TABLE IF EXISTS `Copre`;
CREATE TABLE `Copre` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `Copre` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Copre` VALUES ('0');
INSERT INTO `Copre` VALUES ('1');
COMMIT;
ALTER TABLE `Copre` ENABLE KEYS;

DROP TABLE IF EXISTS `Item`;
CREATE TABLE `Item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requirement_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `measure_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

ALTER TABLE `Item` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Item` VALUES ('76', '59', '200', '37', '1');
INSERT INTO `Item` VALUES ('77', '59', '100', '52', '1');
INSERT INTO `Item` VALUES ('78', '60', '50', '51', '1');
INSERT INTO `Item` VALUES ('79', '60', '100', '40', '1');
INSERT INTO `Item` VALUES ('80', '61', '50', '44', '1');
INSERT INTO `Item` VALUES ('81', '61', '50', '46', '1');
INSERT INTO `Item` VALUES ('82', '62', '50', '42', '1');
INSERT INTO `Item` VALUES ('83', '63', '24', '50', '2');
INSERT INTO `Item` VALUES ('84', '63', '10', '48', '2');
INSERT INTO `Item` VALUES ('85', '64', '35', '50', '1');
INSERT INTO `Item` VALUES ('86', '64', '50', '53', '1');
COMMIT;
ALTER TABLE `Item` ENABLE KEYS;

DROP TABLE IF EXISTS `Measure`;
CREATE TABLE `Measure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

ALTER TABLE `Measure` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Measure` VALUES ('1', 'unidades');
INSERT INTO `Measure` VALUES ('2', 'docenas');
INSERT INTO `Measure` VALUES ('3', 'litros');
INSERT INTO `Measure` VALUES ('4', 'kilos');
COMMIT;
ALTER TABLE `Measure` ENABLE KEYS;

DROP TABLE IF EXISTS `Participant`;
CREATE TABLE `Participant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `copre_id` int(11) NOT NULL,
  `company_name` text,
  `cuit` text,
  `address` text,
  `telephone` text,
  `email` text,
  `password` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

ALTER TABLE `Participant` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Participant` VALUES ('105', '0', 'mi nueva empresa SRL', '30-71213139-6', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '123456789');
INSERT INTO `Participant` VALUES ('106', '0', 'mi nueva empresa GMbH', '30-71213139-7', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('107', '0', 'mi nueva empresa GMbH', '30-71213139-8', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('108', '0', 'mi nueva empresa sociedad anonima', '30-71213139-9', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('109', '0', 'mi nueva empresa sociedad anonima', '30-71213139-10', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('110', '0', 'mi nueva empresa GMbH', '30-71213139-11', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('111', '0', 'mi nueva empresa GMbH', '30-71213139-12', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('112', '0', 'mi nueva empresa GMbH', '30-71213139-13', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('113', '0', 'mi nueva empresa GMbH', '30-71213139-14', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('114', '0', 'mi nueva empresa GMbH', '30-71213139-15', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('115', '0', 'mi nueva empresa GMbH', '30-71213139-16', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('116', '0', 'mi nueva empresa GMbH', '30-71213139-17', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('117', '0', 'mi nueva empresa GMbH', '30-71213139-18', 'Av. Siempre Viva 5544', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('118', '0', 'Empresa nueva', '30-71213139-19', 'mi dirección 3311', '11111111111', 'email@miempresa.com.ar', '123456789');
INSERT INTO `Participant` VALUES ('119', '0', 'Empresa nueva', '30-71213139-20', 'mi dirección 3311', '11111111111', 'email@miempresa.com.ar', '123456789');
INSERT INTO `Participant` VALUES ('120', '0', 'Empresa nueva', '30-71213139-21', 'mi dirección 3311', '11111111111', 'email@miempresa.com.ar', '123456789');
INSERT INTO `Participant` VALUES ('121', '0', 'Trimatec GMbH', '30-71213139-22', 'mi dirección 3311', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('122', '0', 'Trimatec GMbH', '30-71213139-23', 'mi dirección 3311', '4444-2222', 'email@miempresa.com.ar', '1111111111111111111111');
INSERT INTO `Participant` VALUES ('123', '0', 'La empresa SRL', '32341123122', 'Mario Bravo 1050', '444444444', 'email@palermo.edu', '123456789');
COMMIT;
ALTER TABLE `Participant` ENABLE KEYS;

DROP TABLE IF EXISTS `Participant_category`;
CREATE TABLE `Participant_category` (
  `participant_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `Participant_category` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Participant_category` VALUES ('105', '1');
INSERT INTO `Participant_category` VALUES ('105', '2');
INSERT INTO `Participant_category` VALUES ('106', '2');
INSERT INTO `Participant_category` VALUES ('107', '2');
INSERT INTO `Participant_category` VALUES ('108', '2');
INSERT INTO `Participant_category` VALUES ('109', '2');
INSERT INTO `Participant_category` VALUES ('110', '2');
INSERT INTO `Participant_category` VALUES ('111', '2');
INSERT INTO `Participant_category` VALUES ('112', '1');
INSERT INTO `Participant_category` VALUES ('113', '2');
INSERT INTO `Participant_category` VALUES ('114', '1');
INSERT INTO `Participant_category` VALUES ('115', '1');
INSERT INTO `Participant_category` VALUES ('116', '1');
INSERT INTO `Participant_category` VALUES ('117', '2');
INSERT INTO `Participant_category` VALUES ('118', '2');
INSERT INTO `Participant_category` VALUES ('119', '2');
INSERT INTO `Participant_category` VALUES ('120', '2');
INSERT INTO `Participant_category` VALUES ('121', '1');
INSERT INTO `Participant_category` VALUES ('122', '2');
INSERT INTO `Participant_category` VALUES ('123', '1');
COMMIT;
ALTER TABLE `Participant_category` ENABLE KEYS;

DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bar_code` text,
  `brand_id` int(11) DEFAULT NULL,
  `name` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

ALTER TABLE `Product` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Product` VALUES ('37', '123456789', '4', 'Patitas de pollo');
INSERT INTO `Product` VALUES ('38', '1234567890', '3', 'Jardinera');
INSERT INTO `Product` VALUES ('39', '12345678901', '2', 'Milanesas de pollo');
INSERT INTO `Product` VALUES ('40', '123456789012', '3', 'Garbanzos');
INSERT INTO `Product` VALUES ('41', '1234', '2', 'Huevos blancos');
INSERT INTO `Product` VALUES ('42', '12345', '1', 'Nescafé');
INSERT INTO `Product` VALUES ('43', '123456', '1', 'Flan casero');
INSERT INTO `Product` VALUES ('44', '1234567', '5', 'Leche entera');
INSERT INTO `Product` VALUES ('45', '12345678', '1', 'Leche en polvo');
INSERT INTO `Product` VALUES ('46', '1234567890123', '5', 'Yogur entero');
INSERT INTO `Product` VALUES ('47', '12345678901234', '3', 'Alfajor de chocolate');
INSERT INTO `Product` VALUES ('48', '123456789012345', '3', 'Cereal Mix');
INSERT INTO `Product` VALUES ('49', '1234567890123456', '6', 'Té');
INSERT INTO `Product` VALUES ('50', '12345678901234567', '3', 'Cerealitas');
INSERT INTO `Product` VALUES ('51', '123456789012345678', '3', 'Tomate perita');
INSERT INTO `Product` VALUES ('52', '1234567890123456789', '2', 'Milanesas de pollo');
INSERT INTO `Product` VALUES ('53', '123456789012345678901', '7', 'Galletitas Sonrisas');
COMMIT;
ALTER TABLE `Product` ENABLE KEYS;

DROP TABLE IF EXISTS `Requirement`;
CREATE TABLE `Requirement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `copre_id` int(11) NOT NULL,
  `participant_id` int(11) NOT NULL,
  `current_workflow_node_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

ALTER TABLE `Requirement` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `Requirement` VALUES ('59', '0', '105', '231');
INSERT INTO `Requirement` VALUES ('60', '0', '105', '222');
INSERT INTO `Requirement` VALUES ('61', '0', '105', '225');
INSERT INTO `Requirement` VALUES ('62', '0', '105', '230');
INSERT INTO `Requirement` VALUES ('63', '0', '105', '232');
INSERT INTO `Requirement` VALUES ('64', '0', '105', '233');
COMMIT;
ALTER TABLE `Requirement` ENABLE KEYS;

DROP TABLE IF EXISTS `WorkflowDescription`;
CREATE TABLE `WorkflowDescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text,
  `initial_node_description_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

ALTER TABLE `WorkflowDescription` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `WorkflowDescription` VALUES ('1', 'Workflow 1', '1');
COMMIT;
ALTER TABLE `WorkflowDescription` ENABLE KEYS;

DROP TABLE IF EXISTS `WorkflowLinkDescription`;
CREATE TABLE `WorkflowLinkDescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text,
  `initial_node_description_id` int(11) DEFAULT NULL,
  `final_node_description_id` int(11) DEFAULT NULL,
  `workflow_description_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

ALTER TABLE `WorkflowLinkDescription` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `WorkflowLinkDescription` VALUES ('1', 'Desde Nuevo a Exhibido', '1', '2', '1');
INSERT INTO `WorkflowLinkDescription` VALUES ('2', 'Desde Exhibido a Ofertado', '2', '3', '1');
INSERT INTO `WorkflowLinkDescription` VALUES ('3', 'Desde Ofertado a Exhibido', '3', '2', '1');
INSERT INTO `WorkflowLinkDescription` VALUES ('4', 'Desde Ofertado a Aceptado', '3', '4', '1');
INSERT INTO `WorkflowLinkDescription` VALUES ('5', 'Desde Aceptado a Exhibido', '4', '2', '1');
INSERT INTO `WorkflowLinkDescription` VALUES ('6', 'Desde Aceptado a Finalizado', '4', '5', '1');
COMMIT;
ALTER TABLE `WorkflowLinkDescription` ENABLE KEYS;

DROP TABLE IF EXISTS `WorkflowNode`;
CREATE TABLE `WorkflowNode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `init_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `requirement_id` int(11) DEFAULT NULL,
  `node_description_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8;

ALTER TABLE `WorkflowNode` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `WorkflowNode` VALUES ('209', '2014-02-25', '2014-02-25', '56', '2');
INSERT INTO `WorkflowNode` VALUES ('210', '2014-02-25', NULL, '57', '2');
INSERT INTO `WorkflowNode` VALUES ('211', '2014-02-25', NULL, '58', '2');
INSERT INTO `WorkflowNode` VALUES ('212', '2014-02-25', '2014-02-25', '56', '3');
INSERT INTO `WorkflowNode` VALUES ('213', '2014-02-25', '2014-02-25', '56', '3');
INSERT INTO `WorkflowNode` VALUES ('214', '2014-02-25', '2014-02-25', '56', '3');
INSERT INTO `WorkflowNode` VALUES ('215', '2014-02-25', '2014-02-25', '56', '4');
INSERT INTO `WorkflowNode` VALUES ('216', '2014-02-25', '2014-02-25', '56', '3');
INSERT INTO `WorkflowNode` VALUES ('217', '2014-02-25', '2014-02-25', '56', '3');
INSERT INTO `WorkflowNode` VALUES ('218', '2014-02-25', NULL, '56', '4');
INSERT INTO `WorkflowNode` VALUES ('219', '2014-02-25', '2014-02-25', '59', '1');
INSERT INTO `WorkflowNode` VALUES ('220', '2014-02-25', '2014-02-25', '59', '2');
INSERT INTO `WorkflowNode` VALUES ('221', '2014-02-25', '2014-02-25', '60', '1');
INSERT INTO `WorkflowNode` VALUES ('222', '2014-02-25', NULL, '60', '2');
INSERT INTO `WorkflowNode` VALUES ('223', '2014-02-25', '2014-02-25', '61', '1');
INSERT INTO `WorkflowNode` VALUES ('224', '2014-02-25', '2014-02-25', '62', '1');
INSERT INTO `WorkflowNode` VALUES ('225', '2014-02-25', NULL, '61', '2');
INSERT INTO `WorkflowNode` VALUES ('226', '2014-02-25', '2014-02-25', '62', '2');
INSERT INTO `WorkflowNode` VALUES ('227', '2014-02-25', '2014-02-25', '63', '1');
INSERT INTO `WorkflowNode` VALUES ('228', '2014-02-25', '2014-02-25', '63', '2');
INSERT INTO `WorkflowNode` VALUES ('229', '2014-02-25', '2014-02-25', '63', '3');
INSERT INTO `WorkflowNode` VALUES ('230', '2014-02-25', NULL, '62', '3');
INSERT INTO `WorkflowNode` VALUES ('231', '2014-02-25', NULL, '59', '3');
INSERT INTO `WorkflowNode` VALUES ('232', '2014-02-25', NULL, '63', '4');
INSERT INTO `WorkflowNode` VALUES ('233', '2014-02-26', NULL, '64', '1');
COMMIT;
ALTER TABLE `WorkflowNode` ENABLE KEYS;

DROP TABLE IF EXISTS `WorkflowNodeDescription`;
CREATE TABLE `WorkflowNodeDescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text,
  `is_final_node` tinyint(1) DEFAULT NULL,
  `workflow_description_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

ALTER TABLE `WorkflowNodeDescription` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `WorkflowNodeDescription` VALUES ('1', 'Nuevo', '0', '1');
INSERT INTO `WorkflowNodeDescription` VALUES ('2', 'Exhibido', '0', '1');
INSERT INTO `WorkflowNodeDescription` VALUES ('3', 'Ofertado', '0', '1');
INSERT INTO `WorkflowNodeDescription` VALUES ('4', 'Aceptado', '0', '1');
INSERT INTO `WorkflowNodeDescription` VALUES ('5', 'Finalizado', '1', '1');
COMMIT;
ALTER TABLE `WorkflowNodeDescription` ENABLE KEYS;

DROP TABLE IF EXISTS `WorkflowNode_Link`;
CREATE TABLE `WorkflowNode_Link` (
  `node_description_id` int(11) DEFAULT NULL,
  `link_description_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `WorkflowNode_Link` DISABLE KEYS;
SET AUTOCOMMIT=0;
INSERT INTO `WorkflowNode_Link` VALUES ('1', '1');
INSERT INTO `WorkflowNode_Link` VALUES ('2', '2');
INSERT INTO `WorkflowNode_Link` VALUES ('3', '3');
INSERT INTO `WorkflowNode_Link` VALUES ('3', '4');
INSERT INTO `WorkflowNode_Link` VALUES ('4', '5');
INSERT INTO `WorkflowNode_Link` VALUES ('4', '6');
COMMIT;
ALTER TABLE `WorkflowNode_Link` ENABLE KEYS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET SQL_MODE=@OLD_SQL_MODE;
SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT;
