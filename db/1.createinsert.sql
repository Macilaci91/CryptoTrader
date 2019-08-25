CREATE USER 'rollnrock'@'localhost' IDENTIFIED BY 'iddqd';GRANT ALL PRIVILEGES ON * . * TO 'rollnrock'@'localhost';
CREATE DATABASE IF NOT EXISTS `cryptotrader`;
USE `cryptotrader`;

DROP TABLE IF EXISTS `crypto`;
CREATE TABLE IF NOT EXISTS `crypto` (
  `name` char(200) PRIMARY KEY,
  `value` float(10)
);

DROP TABLE IF EXISTS `wallett`;
CREATE TABLE IF NOT EXISTS `wallett` (
  `name` char(100) PRIMARY KEY,
  `quantity` float(10),
  `bought` float(10)
);


INSERT INTO `wallett` (`name`, `quantity`, `bought`) VALUES
('USD', 10000, 0);

INSERT INTO `crypto` (`name`, `value`) VALUES
('ADA', 10000),
('BAT', 10000),
('BCH', 10000),
('BSV', 10000),
('BTC', 10000),
('DGB', 10000),
('EDR', 10000),
('ETC', 10000),
('ETH', 10000),
('KMD', 10000),
('LTC', 10000),
('PAX', 10000),
('SC', 10000),
('SPND', 10000),
('TRX', 10000),
('TUSD', 10000),
('USDS', 10000),
('USDT', 10000),
('XRP', 10000),
('ZEC', 10000),
('ZEN', 10000),
('ZRX', 10000);