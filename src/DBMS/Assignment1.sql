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

--      **************         Assignment 1 Ends       ************



--      **************         Assignment 2 BEGINS       ************

-- Display Id, Title, Category Title, Price of the products which are Active and 
-- recently added products should be at top.
select p.productid, p.name, p.price, c.name as Category
from product p 
left join category c on p.productid=c.productid
order by p.productid desc  -- Ordering by productid as it is auto-incrimented. Item inserted at last
limit 5;                   -- will be having maxing id.  

-- Display the list of products which don't have any images.
select productid, name, price 
from product
where productid NOT IN
(
  select p.productid
  from product p
  inner join image on p.productid=image.productid
);

-- Display all Id, Title and Parent Category Title for all the Categories listed, sorted by 
-- Parent Category Title and then Category Title. (If Category is top category then Parent 
-- Category Title column should display “Top Category” as value.)
SELECT c.cateogryid, c.name, 
       IF(c.parentCategoryId IS NULL, "Top Category", c.parentCategoryId) as ParentCategory
FROM categoryone c
LEFT JOIN categoryone cp ON cp.cateogryid = c.parentCategoryId
ORDER BY ParentCategory, c.name;

-- Display Id, Title, Parent Category Title of all the leaf Categories 
-- (categories which are not parent of any other category)
select categoryid, name, parentCategoryId
from category
where categoryid not in(
  select distinct parentCategoryId 
  from category where parentCategoryId is not null
);

-- Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
select p.name, price,c.name, description
from product p
inner join category c on c.productid = p.productid
where c.name="Optimum";

-- Display the list of Products whose Quantity on hand (Inventory) is under 50.
select productid, name, description, price
from product
where stockQuantity<50;

--      **************         Assignment 2 Complete       ************    


--      **************         Assignment 3 BEGINS       ************

--Display Recent 50 Orders placed (Id, Order Date, Order Total).
select orderid, orderdate, ordertotal
from order
order by orderdate desc
limit 50;

-- Display 10 most expensive Orders.
select orderid, orderdate, ordertotal
from order
order by ordertotal desc
limit 10;

-- Display all the Orders which are placed more than 10 days old and one 
-- or more items from those orders are still not shipped.
select orderid, orderdate, ordertotal
from order
where DATEDIFF(CURDATE(), DATE(orderdate))>10 and orderstatus='P';

-- Display list of shoppers which haven't ordered anything since last month.
SELECT c.customer_id, c.customer_name
FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id AND o.order_date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
WHERE o.order_id IS NULL;

-- Display list of shopper along with orders placed by them in last 15 days. 
SELECT O.orderID, U.username, O.dateOfOrder
FROM userOrder O
LEFT JOIN websiteUser U
ON U.userID = O.userID
WHERE O.dateOfOrder > CURRENT_DATE - 15;

-- Display list of order items which are in “shipped” state for 
-- particular Order Id (i.e.: 1020))
SELECT P.name
FROM userOrder O    
LEFT JOIN product P
ON P.productID = O.productID
WHERE O.orderID = 1020  AND orderStatus = 'S';

-- Display list of order items along with order placed date which 
-- fall between Rs 20 to Rs 50 price.
SELECT O.dateOfOrder, P.name
FROM userOrder O    
LEFT JOIN product P
ON P.productID = O.productID
WHERE O.totalCost between 20 AND 50;


--      **************         Assignment 3 End         ************
