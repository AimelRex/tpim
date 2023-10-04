-- phpMyAdmin SQL Dump
-- version 4.9.10
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 04 oct. 2023 à 14:42
-- Version du serveur : 10.1.48-MariaDB-0+deb9u2
-- Version de PHP : 7.0.33-0+deb9u12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `logsTpImmo`
--

-- --------------------------------------------------------

--
-- Structure de la table `Logs`
--

CREATE TABLE `Logs` (
  `id` int(11) NOT NULL,
  `message` varchar(2550) NOT NULL,
  `stackTrace` varchar(2550) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `app` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Logs`
--

INSERT INTO `Logs` (`id`, `message`, `stackTrace`, `date`, `app`) VALUES
(9, 'Erreur lors du chargement des biens. Unsupported conversion from DATE to java.lang.Integer', 'SQLLogException: Erreur lors du chargement des biens. Unsupported conversion from DATE to java.lang.Integer\r\n	at DataBase.loadBiens(DataBase.java:73)\r\n	at DataBase.init(DataBase.java:21)\r\n	at main.main(main.java:6)\r\n', '2023-10-04', 'TP Agence Immo (cli)'),
(10, 'Erreur lors de l\'upload d\'un bien. Before start of result set', 'SQLLogException: Erreur lors de l\'upload d\'un bien. Before start of result set\r\n	at DataBase.uploadBien(DataBase.java:113)\r\n	at main.main(main.java:11)\r\n', '2023-10-04', 'TP Agence Immo (cli)');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Logs`
--
ALTER TABLE `Logs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Logs`
--
ALTER TABLE `Logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
