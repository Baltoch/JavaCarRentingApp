/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

/**
 *
 * @author balth
 */
public class Transaction {
    private String transactionId;
    private String status;
    private double amount;
    private double paidAmount;
    private User debtor;

    public Transaction(String transactionId, String status, double amount, double paidAmount, User debtor) {
        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
        this.paidAmount = paidAmount;
        this.debtor = debtor;
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
