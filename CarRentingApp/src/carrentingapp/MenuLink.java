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
public class MenuLink extends JButton {
    
    public MenuLink(String text)
    {
        super();
        this.setFont(new java.awt.Font("Arial", 1, 20)); 
        this.setForeground(Color.WHITE);
        this.setText(text);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
    }
    
    public MenuLink(String text, int x, int y, int width, int height)
    {
        this(text);
        this.setBounds(x, y, width, height);
    }
    
    public MenuLink(String text, int x, int y, int width, int height, int fontSize)
    {
        this(text, x, y, width, height);
        this.setFont(new java.awt.Font("Arial", 1, fontSize));
    }
}
