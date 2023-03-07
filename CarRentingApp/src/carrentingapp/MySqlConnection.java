/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author balth
 */
public class MySqlConnection {
    private Connection conn;
    
    public MySqlConnection()
    {
        conn = null;
        try {
            // db parameters - ptest is the name of the database
            String url       = "jdbc:mysql://localhost:3306/carrentingapp";
            String user      = "root";
            String password  = "";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password); 
        } 
        catch(SQLException e) {
           System.out.println(e.getMessage());
        } 
    }
    
    public ResultSet executeSELECTQuery(String query)
    {
        try
        {
            Statement stmt=conn.createStatement();
            return stmt.executeQuery(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void executeINSERTQuery(String query)
    {
        try
        {
            Statement stmt=conn.createStatement();
            int rows = stmt.executeUpdate(query);
            if(rows>1) throw new SQLException("Error: Multiple rows modified");
            else if(rows<1) throw new SQLException("Error: No rows modified");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void executeUPDATEQuery(String query)
    {
        try
        {
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void close()
    {
        try {
            if(conn != null) {
                conn.close();
                conn = null;
            }
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
