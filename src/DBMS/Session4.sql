-- ************     Session 4 Assignment Begins       ***************

-- Create a function to calculate number of orders in a month. 
-- Month and year will be input parameter to function

DELIMITER $$

CREATE FUNCTION OrdersInMonth(input_year INT, input_month INT)
RETURNS INT
BEGIN
	DECLARE orderCount INT DEFAULT 0;
	
	SELECT COUNT(*) INTO orderCount
	FROM storefront.order
	WHERE YEAR(order_date) = input_year AND MONTH(order_date) = input_month;
	
	RETURN orderCount;
END $$

DELIMITER ;

-- Create a function to return month in a year having maximum orders. 
-- Year will be input parameter

DELIMITER $$

CREATE FUNCTION MaxOrderMonth(input_year INT)
RETURNS INT
BEGIN
	DECLARE maxMonth INT DEFAULT 0;
	
	SELECT MONTH(order_date) INTO maxMonth
	FROM storefront.order
	WHERE YEAR(order_date) = input_year
	GROUP BY MONTH(order_date)
	ORDER BY COUNT(*) DESC
	LIMIT 1;
	
	RETURN maxMonth;
END $$

DELIMITER ;


-- ***************     Assignment 2 Begins     ***************


-- Create a Stored procedure to retrieve average sales of each product in a month. 
-- Month and year will be input parameter to function.

DELIMITER $$

CREATE PROCEDURE ProductAvgSales(IN input_year INT, IN input_month INT)
BEGIN
    SELECT po.product_id, AVG(po.quantity * p.price) AS average_sales
    FROM storefront.order o
    JOIN productorder po ON o.order_id = po.order_id
    JOIN products p ON po.product_id = p.product_id
    WHERE YEAR(o.order_date) = input_year
      AND MONTH(o.order_date) = input_month
    GROUP BY po.product_id;
END $$

DELIMITER ;


-- Create a stored procedure to retrieve table having order detail 
-- with status for a given period. Start date and end date will be 
-- input parameter. Put validation on input dates like start date 
-- is less than end date. If start date is greater than end date 
-- take first date of month as start date.

DELIMITER $$

CREATE PROCEDURE get_order_details(IN start_date DATE, IN end_date DATE)
BEGIN
	-- Date Validation
	IF start_date > end_date THEN
		SET start_date = DATE_FORMAT(start_date, '%Y-%m_01');
	END IF;
	
	SELECT o.order_id, o.order_date, o.shopper_id, po.product_id, po.quantity, o.status
	FROM storefront.order o
	JOIN productorder po ON o.order_id = po.order_id
	WHERE o.order_date BETWEEN start_date and end_date;

END $$

DELIMITER ;


--    ************       Assignment 3 Begins   ********


-- It would be significant to make indexes on following columns- 

-- Orders Table:
-- 		order_id: Primary key, automatically indexed.
-- 		order_date: Often used in date range queries.
-- 		customer_id: Frequently used in queries to filter orders by customer.
-- Products Table:
-- 		product_id: Primary key, automatically indexed.
-- 		category_id: Used to filter products by category.
-- 		price: If used frequently in range queries or sorting.
-- Categories Table:
-- 		category_id: Primary key, automatically indexed.
-- 		category_name: If used frequently in search queries.

-- Indexes for orders table
CREATE INDEX idx_order_date ON orders(order_date);
CREATE INDEX idx_customer_id ON orders(customer_id);

-- Indexes for products table
CREATE INDEX idx_category_id ON products(category_id);
CREATE INDEX idx_price ON products(price);

-- Indexes for categories table
CREATE INDEX idx_category_name ON categories(category_name);