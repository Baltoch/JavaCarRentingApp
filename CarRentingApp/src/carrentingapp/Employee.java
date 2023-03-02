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
public class Employee extends User {
    private double baseSalary;
    private String jobTitle;

    public Employee(double baseSalary, String jobTitle, String email, String password, String firstName, String lastName, DriverLicense driverLicense) {
        super(email, password, firstName, lastName, driverLicense);
        this.baseSalary = baseSalary;
        this.jobTitle = jobTitle;
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
    
    public void moveCar(Date date, Car car, Location oldLocation, Location newLocation)
    {
        Move move = new Move(date, this, car, oldLocation, newLocation);
        move.addToDB();
    }
    
    public void addCar(String registrationNumber, int mileage, Location location, Model model)
    {
        Car car = new Car(registrationNumber, mileage, location, model);
        car.addToDB();
    }
    
    public void addCar(Car car)
    {
        car.addToDB();
    }
    
    public void removeCar(Car car)
    {
        car.removeFromDB();
    }
    
    public void updateCar(Car car, int mileage, Location location)
    {
        car.setMileage(mileage);
        car.setLocation(location);
        car.updateInDB();
    }
    public void reviewRental(Rental rental)
    {
        rental.setValidationOfficer(this);
        rental.updateInDB();
    }
    
    public void addLocation(int locationId, String name)
    {
        Location location = new Location(locationId, name);
        location.addToDB();
    }
    
    public void addLocation(Location location)
    {
        location.addToDB();
    }
    
    public void removeLocation(Location location)
    {
        location.removeFromDB();
    }
    
    public double computeCurrentBonus()
    {
        
    }
    
    public double computeEstimatedSalary()
    {
        
    }
    
    public void addDiscount(double discountLevel, Date startingDate, Date endingDate, Car car)
    {
        Discount discount = new Discount(discountLevel, startingDate, endingDate, this, car);
        discount.addToDB();
    }
    
    public void addDiscount(Discount discount)
    {
        discount.setEmployee(this);
        discount.addToDB();
    }
    
    public void removeDiscount(Discount discount)
    {
        discount.removeFromDB();
    }
    
    public void updateDiscount(Discount discount)
    {
        discount.setEmployee(this);
        discount.updateInDB();
    }
    
    public void addMember()
    {
        
    }
    
    public void updateMember()
    {
        
    }
    
    public void removeMember()
    {
        
    }
    
    public void updateRental()
    {
        
    }
    
    public void removeRental()
    {
        
    }
    
    public void addRental()
    {
        
    }
    
    public void addInsurance()
    {
        
    }
    
    public void updateInsurance()
    {
        
    }
    
    public void removeInsurance()
    {
        
    }
}
