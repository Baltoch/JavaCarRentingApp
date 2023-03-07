/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class Member extends User {
    private String type;
    private double discountLevel;
    private Membership membership;

    public Member(String type, double discountLevel, Membership membership, String email, String password, String firstName, String lastName, DriverLicense driverLicense) {
        super(email, password, firstName, lastName, driverLicense);
        this.type = type;
        this.discountLevel = discountLevel;
        this.membership = membership;
    }
    
    public void addToDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO Members (email, discountLevel, membership) VALUES (\""+email+"\", "+discountLevel+", \""+membership.getMemebershipType()+"\")");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("DELETE FROM Users WHERE email=\""+email+"\"");
        connection.close();
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE Users SET type=\""+type+"\", discountLevel="+discountLevel+", membership=\""+membership.getMemebershipType()+"\" WHERE email=\""+email+"\"");
        connection.close();
    }
    
    public Membership[] browseMembership()
    {
        
    }
    
    public void subscribe(Membership membership)
    {
        this.membership = membership;
        this.updateInDB();
    }
}
