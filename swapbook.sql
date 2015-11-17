-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu versiyonu:             5.5.44 - MySQL Community Server (GPL)
-- Sunucu İşletim Sistemi:       Win32
-- HeidiSQL Sürüm:               9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- swapbook için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `swapbook` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `swapbook`;


-- tablo yapısı dökülüyor swapbook.deneme
CREATE TABLE IF NOT EXISTS `deneme` (
  `ad` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Veri çıktısı seçilmemişti


-- tablo yapısı dökülüyor swapbook.guvenilirlik
CREATE TABLE IF NOT EXISTS `guvenilirlik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guven_sahibi` int(11) NOT NULL,
  `guven_veren` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Veri çıktısı seçilmemişti


-- tablo yapısı dökülüyor swapbook.kitaplar
CREATE TABLE IF NOT EXISTS `kitaplar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proid` int(11) NOT NULL,
  `adi` text NOT NULL,
  `kategori` varchar(30) NOT NULL,
  `yazar` text NOT NULL,
  `takasdurum` bit(1) DEFAULT NULL,
  `takascount` int(11) NOT NULL DEFAULT '0',
  `takasuser` int(11) DEFAULT NULL,
  `yorum` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Veri çıktısı seçilmemişti


-- tablo yapısı dökülüyor swapbook.mesajlar
CREATE TABLE IF NOT EXISTS `mesajlar` (
  `mesajid` int(11) NOT NULL AUTO_INCREMENT,
  `mesajsahibi` int(11) NOT NULL,
  `mesajatan` int(11) NOT NULL,
  `mesaj` text NOT NULL,
  `viewstatus` bit(1) DEFAULT b'1',
  PRIMARY KEY (`mesajid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Veri çıktısı seçilmemişti


-- tablo yapısı dökülüyor swapbook.satilikbook
CREATE TABLE IF NOT EXISTS `satilikbook` (
  `id` int(11) NOT NULL,
  `kitapID` int(11) NOT NULL,
  `kitapAD` int(11) NOT NULL,
  `fiyat` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Veri çıktısı seçilmemişti


-- tablo yapısı dökülüyor swapbook.takaslar
CREATE TABLE IF NOT EXISTS `takaslar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kitapsahibi` int(11) NOT NULL DEFAULT '0',
  `kitapid` int(11) NOT NULL DEFAULT '0',
  `kitapadi` text,
  `isteksahibi` int(11) NOT NULL DEFAULT '0',
  `viewdurum` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Veri çıktısı seçilmemişti


-- tablo yapısı dökülüyor swapbook.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adsoyad` text CHARACTER SET utf8 NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 NOT NULL,
  `email` text CHARACTER SET utf8 NOT NULL,
  `okul` text CHARACTER SET utf8 NOT NULL,
  `bolum` text CHARACTER SET utf8 NOT NULL,
  `dogumtarih` date DEFAULT NULL,
  `cinsiyet` text CHARACTER SET utf8,
  `avatar` text CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Veri çıktısı seçilmemişti
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
