/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class Insurance {
    private int contractNumber;
    private String coverage;
    private String conditions;
    private double price;

    public Insurance(int contractNumber, String coverage, String conditions, double price) {
        this.contractNumber = contractNumber;
        this.coverage = coverage;
        this.conditions = conditions;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
    public void addToDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO Insurance (coverage, conditions, price) VALUES (\""+coverage+"\", \""+conditions+"\", "+price+"");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("DELETE FROM Insurance WHERE contractNumber="+contractNumber);
        connection.close();
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE Insurance SET coverage=\""+coverage+"\", conditions=\""+conditions+"\", price="+price+" WHERE contractNumber="+contractNumber);
        connection.close();
    }
}
