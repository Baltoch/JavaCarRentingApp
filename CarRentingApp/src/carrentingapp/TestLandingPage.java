/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;

/**
 *
 * @author balth
 */
public class TestLandingPage extends JPanel{
    
    public TestLandingPage()
    {
        this.setSize(1920, 1080);
        this.setLayout(null);
        
        JLayeredPane layeredPane = new JLayeredPane();
        
        JLabel optionText = new JLabel();
        optionText.setText("Don't have an acount ?");
        optionText.setForeground(Color.red);
        optionText.setBackground(Color.black);
        optionText.setBounds(739, 900, 443, 48);
        
        layeredPane.add(optionText, 1);
        
        this.add(layeredPane);
        this.setVisible(true);
    }
    
}
