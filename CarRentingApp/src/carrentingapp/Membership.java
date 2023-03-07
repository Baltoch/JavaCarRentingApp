/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class Membership {
    private String memebershipType;
    private double price;
    private double additionalDiscount;

    public Membership(String memebershipType, double price, double additionalDiscount) {
        this.memebershipType = memebershipType;
        this.price = price;
        this.additionalDiscount = additionalDiscount;
    }

    public String getMemebershipType() {
        return memebershipType;
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
