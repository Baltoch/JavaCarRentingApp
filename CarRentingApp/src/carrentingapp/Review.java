/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class Review {
    private int reviewId;
    private String message;
    private Rental rental;
    private User user;

    public Review(int reviewId, String message, Rental rental, User user) {
        this.reviewId = reviewId;
        this.message = message;
        this.rental = rental;
        this.user = user;
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
