/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author balth
 */
public class AppButton1 extends JButton{
    
    public AppButton1(String text)
    {
        super();
        this.setBackground(AppWindow.CARROT_ORANGE);
        this.setFont(new java.awt.Font("Arial", 1, 20)); 
        this.setForeground(Color.WHITE);
        this.setText(text);
    }
    
    public AppButton1(String text, int x, int y, int width, int height)
    {
        this(text);
        this.setBounds(x, y, width, height);
    }
    
    public AppButton1(String text, int x, int y, int width, int height, int fontSize)
    {
        this(text, x, y, width, height);
        this.setFont(new java.awt.Font("Arial", 1, fontSize));
    }
}
