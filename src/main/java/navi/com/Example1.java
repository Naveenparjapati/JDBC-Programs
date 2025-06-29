package navi.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fgd", "root", "root");

        Scanner scanner = new Scanner(System.in);
        
        // Prepare the SQL statement with column names
        String sql = "INSERT INTO student (NAME, MARKS, ADDRESS, PHONE_NUMBER) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = c.prepareStatement(sql);

        System.out.println("Enter the name:");
        pstmt.setString(1, scanner.nextLine());
        
        System.out.println("Enter the marks:");
        pstmt.setDouble(2, scanner.nextDouble());
        scanner.nextLine(); // Consume the newline character
        
        System.out.println("Enter the address:");
        pstmt.setString(3, scanner.nextLine());
        
        System.out.println("Enter the phone number:");
        pstmt.setString(4, scanner.nextLine());

        // Execute the update
        int rowsAffected = pstmt.executeUpdate();
        System.out.println(rowsAffected + " row(s) inserted.");

        // Close resources
        pstmt.close();
        c.close();
        scanner.close();
    }
}
