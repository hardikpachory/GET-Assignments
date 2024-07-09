-- Assignment 1

-- Creating a new Database 
create schema if not exists storefront;

-- Using the recently
use storefront;

-- Creating Product Table
CREATE TABLE IF NOT EXISTS `storefront`.`product` (
  `productid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `description` TEXT NULL,
  `price` FLOAT NULL,
  `stockQuantity` INT NULL,
  PRIMARY KEY (`productid`));

--   Image Table
  CREATE TABLE IF NOT EXISTS `storefront`.`image` (
  `imageid` INT NOT NULL AUTO_INCREMENT,
  `imageURL` TEXT NOT NULL,
  `productid` INT NOT NULL,
  PRIMARY KEY (`imageid`),
  INDEX `productid_idx` (`productid` ASC) VISIBLE,
    FOREIGN KEY (`productid`)
    REFERENCES `storefront`.`product` (`productid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Category Table
CREATE TABLE IF NOT EXISTS `category` (
  `cateogryid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `parentCategoryId` varchar(45) DEFAULT NULL,
  `productid` int NOT NULL,
  PRIMARY KEY (`cateogryid`),
  KEY `productid_idx` (`productid`),
  FOREIGN KEY (`productid`) 
  REFERENCES `product` (`productid`)
);

-- Applying the Self Referencing property of the Category
ALTER TABLE `storefront`.`category` 
DROP FOREIGN KEY ``;
ALTER TABLE `storefront`.`category` 
CHANGE COLUMN `parentCategoryId` `parentCategoryId` INT NULL DEFAULT NULL ,
ADD INDEX `categoryTocategory_idx` (`parentCategoryId` ASC) VISIBLE;
;
ALTER TABLE `storefront`.`category` 
ADD CONSTRAINT `productTocategory`
  FOREIGN KEY (`productid`)
  REFERENCES `storefront`.`product` (`productid`),
ADD CONSTRAINT `categoryTocategory`
  FOREIGN KEY (`parentCategoryId`)
  REFERENCES `storefront`.`category` (`cateogryid`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- User Table   
CREATE TABLE IF NOT EXISTS `storefront`.`user` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `mobileNo` CHAR(10) NOT NULL,
  `dateOfBirth` DATE NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `age` INT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`userid`));

-- Shopper Table
CREATE TABLE IF NOT EXISTS `storefront`.`shopper` (
  `shopperid` INT NOT NULL AUTO_INCREMENT,
  `userid` INT NOT NULL,
  PRIMARY KEY (`shopperid`),
  INDEX `shopperTouser_idx` (`userid` ASC) VISIBLE,
    FOREIGN KEY (`userid`)
    REFERENCES `storefront`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Administrator Table
CREATE TABLE IF NOT EXISTS `storefront`.`administrator` (
  `administratorid` INT NOT NULL AUTO_INCREMENT,
  `userid` INT NOT NULL,
  PRIMARY KEY (`administratorid`),
  INDEX `adminTouser_idx` (`userid` ASC) VISIBLE,
    FOREIGN KEY (`userid`)
    REFERENCES `storefront`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- shippingAddress Table
CREATE TABLE IF NOT EXISTS `storefront`.`shippingaddress` (
  `shippingaddressid` INT NOT NULL AUTO_INCREMENT,
  `shopperid` INT NOT NULL,
  `addresslineone` TEXT NULL,
  `addresslinetwo` TEXT NULL,
  `state` VARCHAR(25) NULL,
  `city` VARCHAR(25) NULL,
  `pincode` CHAR(6) NULL,
  PRIMARY KEY (`shippingaddressid`),
  INDEX `addressToshopper_idx` (`shopperid` ASC) VISIBLE,
    FOREIGN KEY (`shopperid`)
    REFERENCES `storefront`.`shopper` (`shopperid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Order Table
CREATE TABLE IF NOT EXISTS `storefront`.`order` (
  `orderid` INT NOT NULL AUTO_INCREMENT,
  `shopperid` INT NOT NULL,
  `shippingaddressid` INT NOT NULL,
  `productid` INT NOT NULL,
  `status` CHAR(1) NULL,
  PRIMARY KEY (`orderid`),
  INDEX `orderToshopper_idx` (`shopperid` ASC) VISIBLE,
  INDEX `orderToaddress_idx` (`shippingaddressid` ASC) VISIBLE,
  INDEX `orderToproduct_idx` (`productid` ASC) VISIBLE,
  CONSTRAINT `orderToshopper`
    FOREIGN KEY (`shopperid`)
    REFERENCES `storefront`.`shopper` (`shopperid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orderToaddress`
    FOREIGN KEY (`shippingaddressid`)
    REFERENCES `storefront`.`shippingaddress` (`shippingaddressid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orderToproduct`
    FOREIGN KEY (`productid`)
    REFERENCES `storefront`.`product` (`productid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Assignment 1 Complete