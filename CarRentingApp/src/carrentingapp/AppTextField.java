/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author balth
 */
public class AppTextField extends JTextField {
    
    public AppTextField(String text)
    {
        super(); 
        this.setFont(new java.awt.Font("Arial", 0, 16)); 
        this.setForeground(AppWindow.CARROT_ORANGE);
        this.setOpaque(false);
        this.setBackground(new Color(0,0,0,0));
        this.setText(text);
        this.setBorder(BorderFactory.createLineBorder(AppWindow.CARROT_ORANGE, 1, true));
    }
    
    public AppTextField(String text, int x, int y, int width, int height)
    {
        this(text);
        this.setBounds(x, y, width, height);
    }
    
}
