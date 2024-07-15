--    *********     Assignment 1 Begins    *********

-- Display the list of products (Id, Title, Count of Categories) 
-- which fall in more than one Category.
SELECT 
	p.productid, 
	p.name, 
	COUNT(pc.category_id) AS CategoryCount
FROM
	product p
JOIN
	category pc ON p.productid=pc.productid
GROUP BY
	p.productid, p.name
HAVING
	CategoryCount>1;
	
-- Display Count of products as per below price range
SELECT 
    CASE
        WHEN price BETWEEN 0 AND 100 THEN '0 - 100'
        WHEN price BETWEEN 101 AND 500 THEN '101 - 500'
        WHEN price > 500 THEN 'Above 500'
    END AS PriceRange,
    COUNT(*) AS Count
FROM 
    products
GROUP BY 
    CASE
        WHEN price BETWEEN 0 AND 100 THEN '0 - 100'
        WHEN price BETWEEN 101 AND 500 THEN '101 - 500'
        WHEN price > 500 THEN 'Above 500'
    END;
	

-- Display the Categories along with number of products 
-- under each category.
SELECT
	c.name,
	COUNT(pc.productid) AS NumberOfProducts
FROM
	category c
LEFT JOIN
	product_category pc on c.categoryid = pc.categoryid
GROUP BY
	c.name;
	

--    *********     Assignment 2 Begins    *********

--Display Shopper’s information along with number of orders 
-- he/she placed during last 30 days.
SELECT 
    s.shopperid,
    s.name,
    COUNT(o.orderid) AS NumberOfOrders
FROM 
    shopper s
JOIN 
    storefront.order o ON s.shopperid = o.shopperid
WHERE 
    o.orderdate >= NOW() - INTERVAL 30 DAY
GROUP BY 
    s.ShopperId, s.ShopperName;
	
-- Display the top 10 Shoppers who generated maximum 
-- number of revenue in last 30 days.
SELECT 
    s.shopperid,
    s.name,
    SUM(o.total) AS TotalRevenue
FROM 
    shopper s
JOIN 
    Orders o ON s.shopperid = o.shopperid
WHERE 
    o.orderdate >= NOW() - INTERVAL 30 DAY
GROUP BY 
    s.shopperid, s.name
ORDER BY 
    TotalRevenue DESC
LIMIT 10;

-- Display top 20 Products which are ordered most 
-- in last 60 days along with numbers.
SELECT 
    p.productid,
    p.name,
    COUNT(op.orderid) AS NumberOfOrders
FROM 
    product p
JOIN 
    orderproduct op ON p.productid = op.productid
JOIN 
    orders o ON op.orderid = o.orderid
WHERE 
    o.orderdate >= NOW() - INTERVAL 60 DAY
GROUP BY 
    p.productid, p.name
ORDER BY 
    NumberOfOrders DESC
LIMIT 20;

-- Display Monthly sales revenue of the StoreFront for last 6 months.
-- It should display each month’s sale.
SELECT 
    DATE_FORMAT(orderdate, '%Y-%m') AS Month,
    SUM(total) AS MonthlySales
FROM 
    Orders
WHERE 
    orderdate >= DATE_SUB(NOW(), INTERVAL 6 MONTH)
GROUP BY 
    DATE_FORMAT(orderdate, '%Y-%m')
ORDER BY 
    Month;
	
-- Mark the products as Inactive which are not ordered in last 90 days.
UPDATE product
SET status = 'Inactive'
WHERE productid NOT IN (
    SELECT DISTINCT productid
    FROM orders
    WHERE orderdate >= DATEADD(day, -90, GETDATE())
);

-- Given a category search keyword, display all the Products 
-- present in this category/categories. 
SELECT p.name, c.name
FROM product p
JOIN productcategory pc ON p.productid = pc.productid
JOIN category c ON pc.categoryid = c.categoryid
WHERE c.name LIKE '%search_word%';

-- Display top 10 Items which were cancelled most.
SELECT p.name, COUNT(*) AS CancellationCount
FROM Orders o
JOIN productorders po ON o.orderid = po.orderid
JOIN Products p ON po.productid = p.productid
WHERE o.status = 'Cancelled'
GROUP BY p.name
ORDER BY CancellationCount DESC
LIMIT 10;


--    *********     Assignment 3 Begins    *********

-- Create appropriate tables and relationships for the same and write a SQL
-- query for that returns a Resultset containing Zip Code, City Names and
-- States ordered by State Name and City Name.


CREATE TABLE States (
    StateId INT PRIMARY KEY,
    StateName VARCHAR(100) NOT NULL
);

CREATE TABLE Cities (
    CityId INT PRIMARY KEY,
    CityName VARCHAR(100) NOT NULL,
    StateId INT,
    FOREIGN KEY (StateId) REFERENCES States(StateId)
);

CREATE TABLE ZipCodes (
    ZipCode VARCHAR(10) PRIMARY KEY,
    CityId INT,
    FOREIGN KEY (CityId) REFERENCES Cities(CityId)
);


SELECT 
    z.ZipCode, 
    c.CityName, 
    s.StateName
FROM 
    ZipCodes z
JOIN 
    Cities c ON z.CityId = c.CityId
JOIN 
    States s ON c.StateId = s.StateId
ORDER BY 
    s.StateName, 
    c.CityName;
		
--    *********     Assignment 4 Begins    *********

-- Create a view displaying the order information 
-- (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
-- with latest ordered items should be displayed first for last 60 days.
CREATE VIEW RecentOrders AS
SELECT 
    o.OrderId, 
    p.Title, 
    p.Price, 
    s.ShopperName, 
    s.Email, 
    o.OrderDate, 
    o.Status
FROM 
    Orders o
JOIN 
    OrderProducts op ON o.OrderId = op.OrderId
JOIN 
    Products p ON op.ProductId = p.ProductId
JOIN 
    Shoppers s ON o.ShopperId = s.ShopperId
WHERE 
    o.OrderDate >= NOW() - INTERVAL 60 DAY
ORDER BY 
    o.OrderDate DESC;

-- Use the above view to display the Products(Items) 
-- which are in ‘shipped’ state.
SELECT 
    *
FROM 
    RecentOrders
WHERE 
    Status = 'shipped';

-- Use the above view to display the top 5 most selling products.
SELECT 
    Title, 
    COUNT(*) AS NumberOfOrders
FROM 
    RecentOrders
GROUP BY 
    Title
ORDER BY 
    NumberOfOrders DESC
LIMIT 5;