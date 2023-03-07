/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class Photo {
    private String accessLink;
    private Car car;

    public Photo(String accessLink, Car car) {
        this.accessLink = accessLink;
        this.car = car;
    }
            
    public void addToDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO Photos (accessLink, car) Values (\""+accessLink+"\", \""+car.getRegistrationNumber()+"\")");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("DELETE FROM Photos WHERE accessLink=\""+accessLink+"\"");
        connection.close();
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE Photos SET car=\""+car.getRegistrationNumber()+"\" WHERE accessLink=\""+accessLink+"\"");
        connection.close();
    }
}
