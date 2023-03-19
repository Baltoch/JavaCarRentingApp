/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class Location {
    private int locationId;
    private String name;
    private String image;

    public Location(int locationId, String name, String image) {
        this.locationId = locationId;
        this.name = name;
        this.image = image;
    }
            
    public void addToDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO Locations (name, image) VALUES (\""+name+"\", \""+image+"\")");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("DELETE FROM Locations WHERE locationId="+locationId);
        connection.close();
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE Locations SET name=\""+name+"\", image=\""+image+"\" WHERE locationId="+locationId);
        connection.close();
    }

    public int getId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
    
    
}
