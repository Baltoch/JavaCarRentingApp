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
    private double milePrice;
    private double additionalMilePrice;
    private char transmissionType;
    private int horsePower;
    private String type;

    public Model(String model, String brand, double dailyRate, int numOfSeats, int bootVolume, double milePrice, double additionalMilePrice, char transmissionType, int horsePower, String type) {
        this.model = model;
        this.brand = brand;
        this.dailyRate = dailyRate;
        this.numOfSeats = numOfSeats;
        this.bootVolume = bootVolume;
        this.milePrice = milePrice;
        this.additionalMilePrice = additionalMilePrice;
        this.transmissionType = transmissionType;
        this.horsePower = horsePower;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public int getBootVolume() {
        return bootVolume;
    }

    public double getMilePrice() {
        return milePrice;
    }

    public double getAdditionalMilePrice() {
        return additionalMilePrice;
    }

    public char getTransmissionType() {
        return transmissionType;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getType() {
        return type;
    }
            
    public void addToDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO Model (model, brand, dailyRate, numOfSeats, bootVolume, milePrice, additionalMilePrice, transmissionType, horsePower, type) VALUES (\""+model+"\", \""+brand+"\", "+dailyRate+", "+numOfSeats+", "+bootVolume+", "+milePrice+", "+additionalMilePrice+", \""+transmissionType+"\", "+horsePower+", \""+type+"\")");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("DELETE FROM Model WHERE model=\""+model+"\" AND brand=\""+brand+"\"");
        connection.close();
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE Model SET dailyRate="+dailyRate+", numOfSeats="+numOfSeats+", bootVolume="+bootVolume+", milePrice="+milePrice+", additionalMilePrice="+additionalMilePrice+", transmissionType=\""+transmissionType+"\", horsePower="+horsePower+", type=\""+type+"\" WHERE model=\""+model+"\" AND brand=\""+brand+"\"");
        connection.close();
    }
}
