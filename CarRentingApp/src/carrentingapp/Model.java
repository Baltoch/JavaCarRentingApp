/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class Model {
    private String model;
    private String brand;
    private double dailyRate;
    private int numOfSeats;
    private int bootVolume;
    private double additionalMilePrice;
    private char transmissionType;
    private int horsePower;
    private String type;

    public Model(String model, String brand, double dailyRate, int numOfSeats, int bootVolume, double additionalMilePrice, char transmissionType, int horsePower, String type) {
        this.model = model;
        this.brand = brand;
        this.dailyRate = dailyRate;
        this.numOfSeats = numOfSeats;
        this.bootVolume = bootVolume;
        this.additionalMilePrice = additionalMilePrice;
        this.transmissionType = transmissionType;
        this.horsePower = horsePower;
        this.type = type;
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
