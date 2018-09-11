package org.ea.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
 
    public static void main(String[] args) {
 
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433/TestDB","sa","secret");
            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}