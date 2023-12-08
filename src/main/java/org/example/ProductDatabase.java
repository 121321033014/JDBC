package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Class.forName;
//Must first paste the code that's present in https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.2.0
// url to the pom.xml file and then refresh in the maven tab present at right side of the window
//later proceed the coding part
public class ProductDatabase {
    public static void main (String[] agrs) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return;
        }
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/rohini","root","Rohini$39")){
            String createTable="CREATE TABLE PRODUCTS"+
                    "(id INT AUTO_INCREMENT PRIMARY KEY,"+
                    "product_id INT,"+
                    "product_name VARCHAR(255),"+
                    "product_description VARCHAR(255),"+
                    "product_price Double NoT NULL)";
try(Statement statement =connection.createStatement()){
    statement.executeUpdate(createTable);
}
String insertData="insert into products(product_id,product_name,product_description,product_price)"+
        "values(1234,'laptop','hp laptop',70000.00)";
       try(Statement statement=connection.createStatement()){
           statement.executeUpdate(insertData);
       }
       System.out.println("product table created successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
