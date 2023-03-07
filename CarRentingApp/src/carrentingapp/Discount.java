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
public class Discount {
    private double discountLevel;
    private Date startingDate;
    private Date endingDate;
    private Employee employee;
    private Car car;

    public Discount(double discountLevel, Date startingDate, Date endingDate, Employee employee, Car car) {
        this.discountLevel = discountLevel;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.employee = employee;
        this.car = car;
    }

    public double getDiscountLevel() {
        return discountLevel;
    }

    public void setDiscountLevel(double discountLevel) {
        this.discountLevel = discountLevel;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    public void addToDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeINSERTQuery("INSERT INTO Discount (employee, car, discountLevel, startingDate, endingDate) VALUES (\""+employee.getEmail()+"\", \""+car.getRegistrationNumber()+"\", "+discountLevel+", \""+startingDate+"\", \""+endingDate+"\")");
        connection.close();
    }
    
    public void removeFromDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("DELETE FROM Discount WHERE startingDate=\""+startingDate+"\" AND car=\""+car.getRegistrationNumber()+"\"");
        connection.close();
    }
    
    public void updateInDB()
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE Discount SET employee=\""+employee.getEmail()+"\", discountLevel="+discountLevel+", endingDate=\""+endingDate+"\" WHERE startingDate=\""+startingDate+"\" AND car=\""+car.getRegistrationNumber()+"\"");
        connection.close();
    }
    
    public void updateInDB(Date newStartingDate, String newRegistrationNumber)
    {
        MySqlConnection connection = new MySqlConnection();
        connection.executeUPDATEQuery("UPDATE Discount SET employee=\""+employee.getEmail()+"\", car=\""+newRegistrationNumber+"\", discountLevel="+discountLevel+", startingDate=\""+newStartingDate+"\", endingDate=\""+endingDate+"\" WHERE startingDate=\""+startingDate+"\" AND car=\""+car.getRegistrationNumber()+"\"");
        connection.close();
    }
}
