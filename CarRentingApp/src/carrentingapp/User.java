/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class User {
    protected String email;
    private String password;
    private String firstName;
    private String lastName;
    private DriverLicense driverLicense;

    public User(String email, String password, String firstName, String lastName, DriverLicense driverLicense) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.driverLicense = driverLicense;
    }
    
    public void addToDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO Users (email, password, firstName, lastName) VALUES (\""+email+"\", \""+password+"\", \""+firstName+"\", \""+lastName+"\");");
        connection.close();
    }
    
    public void removeFromDB()
    {
        
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("");
        connection.close();
    }
    
    public Rental bookRental()
    {
        
    }
    
    public void pay()
    {
        
    }
    
    public void review()
    {
        
    }
}