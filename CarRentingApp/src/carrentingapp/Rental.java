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
    private Employee validationOfficer;
    private User renter;
    private Transaction transaction;
    private Car car;
    private Location pickUpLocation;
    private Location returnLocation;
    private Insurance insurance;

    public Rental(int rentalId, Date startingDate, Date endingDate, int mileage, Employee validationOfficer, User renter, Transaction transaction, Car car, Location pickUpLocation, Location returnLocation, Insurance insurance) {
        this.rentalId = rentalId;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.mileage = mileage;
        this.validationOfficer = validationOfficer;
        this.renter = renter;
        this.transaction = transaction;
        this.car = car;
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
        this.insurance = insurance;
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
