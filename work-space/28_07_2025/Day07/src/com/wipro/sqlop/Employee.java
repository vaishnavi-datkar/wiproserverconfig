package com.wipro.sqlop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee {

    public static void main(String[] args) {
     
        String url = "jdbc:mysql://localhost:3306/query1";
        String user = "root"; 
        String password = "Root"; 

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

          
            conn = DriverManager.getConnection(url, user, password);

         
            String sql = "INSERT INTO employee (emp_name, department) VALUES (?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "vd");
            pstmt.setString(2, "IT");

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee inserted successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
