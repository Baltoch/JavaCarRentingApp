/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;
import java.sql.Date;
/**
 *
 * @author balth
 */
public class Rental {
    private int rentalId;
    private Date startingDate;
    private Date endingDate;
    private int mileage;
    private Employee validationOfficer;
    private User renter;
    private Transaction transaction;
    private Car car;
    private Location pickUpLocation;
    private Location returnLocation;
    private Insurance insurance;
    
    public Rental()
    {
        
    }

    public Rental(int rentalId, Date startingDate, Date endingDate, int mileage, Employee validationOfficer, User renter, Transaction transaction, Car car, Location pickUpLocation, Location returnLocation, Insurance insurance) {
        this.rentalId = rentalId;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.mileage = mileage;
        this.validationOfficer = validationOfficer;
        this.renter = renter;
        this.transaction = transaction;
        this.car = car;
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
        this.insurance = insurance;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Employee getValidationOfficer() {
        return validationOfficer;
    }

    public void setValidationOfficer(Employee validationOfficer) {
        this.validationOfficer = validationOfficer;
    }

    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Location getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(Location returnLocation) {
        this.returnLocation = returnLocation;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
    
    public void addToDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO Rental (startingDate, endingDate, mileage, validationOfficer, car, pickUpLocation, returnLocation, insurance, renter) VALUES ("+startingDate+", "+endingDate+", "+mileage+", \""+validationOfficer.getEmail()+"\", \""+car.getRegistrationNumber()+"\", "+pickUpLocation.getId()+", "+returnLocation.getId()+", "+insurance.getContractNumber()+",  \""+renter.getEmail()+"\")");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("DELETE FROM Rental WHERE rentalId="+rentalId);
        connection.close();
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE Rental SET startingDate=\""+startingDate+"\", endingDate=\""+endingDate+"\", mileage="+mileage+", validationOfficer=\""+validationOfficer.getEmail()+"\", car=\""+car.getRegistrationNumber()+"\", pickUpLocation="+pickUpLocation.getId()+", returnLocation="+returnLocation.getId()+", insurance="+insurance.getContractNumber()+", renter=\""+renter.getEmail()+"\" WHERE rentalId="+rentalId);
        connection.close();
    }
    
    public double computePrice()
    {
        return insurance.getPrice() + car.getModel().getDailyRate() * (endingDate.getTime() - startingDate.getTime())/86400000 + car.getModel().getMilePrice() * mileage;
    }
    
    public Car[] browseCar()
    {
        
    }
    
    public Insurance[] browseInsurance()
    {
        
    }
    
    public Review[] browseReview()
    {
        
    }
}
