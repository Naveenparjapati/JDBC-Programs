package navi.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fgd", "root", "root");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the student name to search (leave blank for all records):");
        String searchName = scanner.nextLine();

        String sql;
        PreparedStatement pstmt;
        
        if (searchName.isEmpty()) {
            // Fetch all records
            sql = "SELECT * FROM student";
            pstmt = c.prepareStatement(sql);
        } else {
            // Fetch records matching the name
            sql = "SELECT * FROM student WHERE NAME LIKE ?";
            pstmt = c.prepareStatement(sql);
            pstmt.setString(1, "%" + searchName + "%");
        }

        ResultSet rs = pstmt.executeQuery();
        
        // Print header
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();
        
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(meta.getColumnName(i) + "\t");
        }
        System.out.println();
        
        // Print data rows
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }

        // Close resources
        rs.close();
        pstmt.close();
        c.close();
        scanner.close();
    }
}
