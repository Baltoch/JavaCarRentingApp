/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;
import java.sql.Date;
/**
 *
 * @author balth
 */
public class Move {
    private Date moveDate;
    private Employee employee;
    private Car car;
    private Location oldLocation;
    private Location newLocation;
    
    public Move(Date moveDate, Employee employee, Car car, Location oldLocation, Location newLocation) {
        this.moveDate = moveDate;
        this.employee = employee;
        this.car = car;
        this.oldLocation = oldLocation;
        this.newLocation = newLocation;
    }
            
    public void addToDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("");
        connection.close();
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("");
        connection.close();
    }
}
