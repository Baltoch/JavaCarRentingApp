/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class DriverLicense {
    private String driverLicenseNumber;
    

    public DriverLicense(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }
    
    public void addToDB(String driverEmail)
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO DriverLicense (driverLicenseNumber, driver) VALUES (\""+driverLicenseNumber+"\", \""+driverEmail+"\")");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("DELETE FROM DriverLicense WHERE driverLicenseNumber=\""+driverLicenseNumber+"\"");
        connection.close();
    }
    
    public void updateInDB(String newDriverLicenseNumber, String driverEmail)
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE DriverLicense SET driverLicenseNumber\""+newDriverLicenseNumber+"\", driver=\""+driverEmail+"\" WHERE driverLicenseNumber=\""+driverLicenseNumber+"\"");
        connection.close();
    }
}
