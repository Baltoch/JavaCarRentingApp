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

    public Member(String type, double discountLevel, Membership membership) {
        this.type = type;
        this.discountLevel = discountLevel;
        this.membership = membership;
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
    
    public Membership[] browseMembership()
    {
        
    }
    
    public void subscribe()
    {
        
    }
}
