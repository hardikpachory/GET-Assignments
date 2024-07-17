package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


import practice.jdbc.dao.FetchShippedOrdersResponse;

public class MainProgram {
	
	public static void main(String[] args) throws SQLException{
	
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "experiment";
		String mySqlUrl = host+dbName;
		String userId = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class Loaded successfully!");
		} catch (ClassNotFoundException e) {
			System.out.println("Error Loading Driver: "+e);
		}
		
		try {
			// Connecting to Database
			Connection connection = DriverManager.getConnection(mySqlUrl, userId, password);
			System.out.println("Connection to DB Successfull");
			
			// Assignment 1
			System.out.println("Enter the user id - ");
			Scanner sc = new Scanner(System.in);
			int id = sc.nextInt();
			sc.close();
			
			// Writing and Preparing our SQL query
			String query = "SELECT orderid, OrderDate, OrderTotal FROM experiment.Order WHERE shopperId = ? AND OrderStatus = 'shipped' ORDER BY OrderDate";
			PreparedStatement ps = connection.prepareStatement(query);
			
			// Injecting Dynamic Values
			ps.setInt(1, id);
			
			// Executing our prepared statement
			ResultSet resultSet = ps.executeQuery();
			
			// Iterating over the result set and storing it into POJO
			List<FetchShippedOrdersResponse> orders = new LinkedList<FetchShippedOrdersResponse>();
			System.out.println("List of Shipped Orders for userId " + id +" are - ");
	
			int orderid;
			String orderdate;
			float ordertotal;
			System.out.println("OrderId\t   OrderDate\tOrderTotal");
			while(resultSet.next()) {
				orderid = resultSet.getInt(1);
				orderdate = resultSet.getDate(2).toString();
				ordertotal = resultSet.getFloat(3);
				System.out.println(orderid + "\t   " + orderdate + "\t" + ordertotal);
				FetchShippedOrdersResponse order = new FetchShippedOrdersResponse(
						resultSet.getInt("orderid"), 
						resultSet.getDate("orderdate").toString(), 
						resultSet.getFloat("ordertotal")
						);
				orders.add(order);
			}
			
//			Assignment 2
			System.out.println("Assignment 2 Begins");
			List<String> urls = new ArrayList<String>();
			urls.add("https://play-lh.googleusercontent.com/PCpXdqvUWfCW1mXhH1Y_98yBpgsWxuTSTofy3NGMo9yBTATDyzVkqU580bfSln50bFU");
			urls.add("https://play-lh.googleusercontent.com/PCpXdqvUWfCW1mXhH1Y_98yBpgsWxuTSTofy3NGMo9yBTATDyzVkqU580bfSln50bFU");
			urls.add("https://play-lh.googleusercontent.com/PCpXdqvUWfCW1mXhH1Y_98yBpgsWxuTSTofy3NGMo9yBTATDyzVkqU580bfSln50bFU");
			urls.add("https://play-lh.googleusercontent.com/PCpXdqvUWfCW1mXhH1Y_98yBpgsWxuTSTofy3NGMo9yBTATDyzVkqU580bfSln50bFU");
			urls.add("https://play-lh.googleusercontent.com/PCpXdqvUWfCW1mXhH1Y_98yBpgsWxuTSTofy3NGMo9yBTATDyzVkqU580bfSln50bFU");
			urls.add("https://play-lh.googleusercontent.com/PCpXdqvUWfCW1mXhH1Y_98yBpgsWxuTSTofy3NGMo9yBTATDyzVkqU580bfSln50bFU");
			
			query = "insert into experiment.image(imageURL, productid) values( ? , 3 );";
			
			PreparedStatement ps2 = connection.prepareStatement(query);
			for(String url: urls) {
				ps2.setString(1,url);
				ps2.toString();
				ps2.addBatch();
			}
			ps2.executeBatch();
			
//			Assignment 3
			String findProductsQuery = "SELECT ProductId FROM Product WHERE ProductId NOT IN (SELECT DISTINCT ProductId FROM Orders WHERE OrderDate >= DATE_SUB(NOW(), INTERVAL 1 YEAR))";
            PreparedStatement findProductsStatement = connection.prepareStatement(findProductsQuery);
            ResultSet productsResultSet = findProductsStatement.executeQuery();
            
            int deletedProductCount = 0;

            // Step 2: Delete the products
            String deleteProductQuery = "DELETE FROM Product WHERE ProductId = ?";
            PreparedStatement deleteProductStatement = connection.prepareStatement(deleteProductQuery);
            
            while (productsResultSet.next()) {
                int productId = productsResultSet.getInt("ProductId");
                deleteProductStatement.setInt(1, productId);
                int rowsAffected = deleteProductStatement.executeUpdate();
                deletedProductCount += rowsAffected;
            }

            // Step 3: Return the number of products deleted
            System.out.println("Number of products deleted: " + deletedProductCount);
			
            
            
//             Assignment 4
            
            query = "SELECT parent.name AS parent_category, COUNT(child.categoryid) AS child_count " +
                    "FROM categories AS parent " +
                    "LEFT JOIN categories AS child ON parent.categoryid = child.parentid " +
                    "WHERE parent.parentid = 0 " +
                    "GROUP BY parent.categoryid " +
                    "ORDER BY parent.name ASC";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet1 = preparedStatement.executeQuery();

            while (resultSet1.next()) {
            	String parentCategory = resultSet.getString("parent_category");
            	int childCount = resultSet.getInt("child_count");
            	System.out.println("Parent Category: " + parentCategory + ", Child Count: " + childCount);
            }

            
            
			connection.close();
		} catch (Exception e) {
			System.out.println("Connection to DB Failed: " + e );
		}
	}
  	 
}
