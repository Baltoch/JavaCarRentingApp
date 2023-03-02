/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class Car {
    private String registrationNumber;
    private int mileage;
    private Location location;
    private Model model;

    public Car(String registrationNumber, int mileage, Location location, Model model) {
        this.registrationNumber = registrationNumber;
        this.mileage = mileage;
        this.location = location;
        this.model = model;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public Location getLocation() {
        return location;
    }

    public Model getModel() {
        return model;
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
