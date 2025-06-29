package navi.com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Example1 {
	 public static void main(String[] args) throws Exception {
		  
			//Load and Register the Driver**
			   Class.forName("com.mysql.cj.jdbc.Driver");
			//Establish the Connection with Database**
			  // Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", "username", "password");
			   Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fgd", "root", "root");
 CallableStatement p=c.prepareCall("CREATE TABLE STUDENT2 (NAME VARCHAR(100) NOT NULL, MARKS DECIMAL(5,2),ADDRESS TEXT, PHONE_NUMBER VARCHAR(15));");
			   boolean e = p.execute();
			//Process the Request
			   System.out.println(e);
			//close the connection 
			     c.close();
	 }
	
}
