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
public class Rental {
    private int rentalId;
    private Date startingDate;
    private Date endingDate;
    private int mileage;
    private Employee reviewer;
    private User renter;
    private Transaction transaction;
    private Car car;
    private Location pickUpLocation;
    private Location returnLocation;
    private Insurance insurance;
    
        
    public void addToDB()
    {
        
    }
    
    public void removeFromDB()
    {
        
    }
    
    public void updateInDB()
    {
        
    }
    
    public double computePrice()
    {
        
    }
    
    public Car[] browseCar()
    {
        
    }
    
    public Insurance[] browseInsurance()
    {
        
    }
    
    public Review[] browseReview()
    {
        
    }
}
