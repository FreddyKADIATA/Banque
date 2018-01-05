-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 05 Janvier 2018 à 05:12
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `banque`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(45) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `postNom` varchar(45) NOT NULL,
  `adresse` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `prenom`, `nom`, `postNom`, `adresse`, `telephone`) VALUES
(2, 'DHOM', 'NGAY TIN', 'LUKERA', 'av. lulia, Q/Maluku, 240', '0992342120'),
(5, 'DHOM', 'NGAY TIN', 'LUKERA', 'av. lulia, Q/Maluku, 240', '0992342120'),
(6, 'Freddy', 'KADIATA', 'ILUNGA', 'av. Idiofa, Q/Maluku, 900', '0992342110');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `code` varchar(20) NOT NULL,
  `dateCreation` date NOT NULL,
  `solde` double NOT NULL,
  `codeClient` int(11) NOT NULL,
  `decouvert` double DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `typeCpte` varchar(10) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`code`, `dateCreation`, `solde`, `codeClient`, `decouvert`, `taux`, `typeCpte`) VALUES
('cp1', '2018-01-01', 8700, 6, NULL, 1000, 'CE'),
('cp2', '2018-01-01', 640, 6, 500, NULL, 'CC'),
('cpt220', '2018-01-01', 56000000, 5, 400000, NULL, 'CC'),
('cpt230', '2018-01-01', 25000000, 6, NULL, 3000000, 'CE');

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE IF NOT EXISTS `operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `montant` double NOT NULL,
  `typeOp` varchar(10) NOT NULL,
  `dateOp` date NOT NULL,
  `numCpte` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=65 ;

--
-- Contenu de la table `operation`
--

INSERT INTO `operation` (`id`, `montant`, `typeOp`, `dateOp`, `numCpte`) VALUES
(42, 200, 'VER', '2018-01-04', 'cp1'),
(43, 200, 'RET', '2018-01-04', 'cp2'),
(44, 200, 'VER', '2018-01-04', 'cp1'),
(45, 200, 'RET', '2018-01-04', 'cp2'),
(46, 200, 'VER', '2018-01-04', 'cp1'),
(47, 200, 'RET', '2018-01-04', 'cp2'),
(48, 200, 'VER', '2018-01-04', 'cp1'),
(49, 200, 'RET', '2018-01-04', 'cp2'),
(50, 200, 'VER', '2018-01-04', 'cp1'),
(51, 200, 'RET', '2018-01-04', 'cp2'),
(52, 200, 'VER', '2018-01-04', 'cp1'),
(53, 200, 'RET', '2018-01-04', 'cp2'),
(54, 200, 'VER', '2018-01-04', 'cp1'),
(55, 200, 'RET', '2018-01-04', 'cp2'),
(56, 200, 'VER', '2018-01-04', 'cp1'),
(57, 500, 'RET', '2018-01-04', 'cp2'),
(58, 500, 'VER', '2018-01-04', 'cp1'),
(59, 500, 'VER', '2018-01-05', 'cp1'),
(60, 250, 'RET', '2018-01-05', 'cp1'),
(61, 690, 'VER', '2018-01-05', 'cp2'),
(62, 100, 'RET', '2018-01-05', 'cp2'),
(63, 50, 'RET', '2018-01-05', 'cp1'),
(64, 50, 'VER', '2018-01-05', 'cp2');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
