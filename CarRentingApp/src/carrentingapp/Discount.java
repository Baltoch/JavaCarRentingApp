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
public class Discount {
    private double discountLevel;
    private Date startingDate;
    private Date endingDate;
    private Employee employee;
    private Car car;

    public Discount(double discountLevel, Date startingDate, Date endingDate, Employee employee, Car car) {
        this.discountLevel = discountLevel;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.employee = employee;
        this.car = car;
    }
            
    public void addToDB()
    {
        
    }
    
    public void removeFromDB()
    {
        
    }
    
    public void updateInDB()
    {
        
    }
}
