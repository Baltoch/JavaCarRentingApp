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
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO Car (registrationNumber, mileage, location, model, brand) VALUES (\""+registrationNumber+"\", "+mileage+", "+location.getId()+", \""+model.getModel()+"\", "+model.getBrand()+")");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("DELETE FROM Car WHERE registrationNumber=\""+registrationNumber+"\"");
        connection.close();
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE Car SET mileage="+mileage+", location="+location.getId()+", model=\""+model.getModel()+"\", brand=\""+model.getBrand()+"\" WHERE registrationNumber=\""+registrationNumber+"\"");
        connection.close();
    }
}
