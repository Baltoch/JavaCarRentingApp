/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import javax.swing.JButton;
import javax.swing.BorderFactory;

/**
 *
 * @author balth
 */
public class AppButton2 extends JButton{
    
    public AppButton2(String text)
    {
        super();
        this.setFont(new java.awt.Font("Arial", 1, 20)); 
        this.setForeground(AppWindow.CARROT_ORANGE);
        this.setText(text);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setBorder(BorderFactory.createLineBorder(AppWindow.CARROT_ORANGE, 1, true));
    }
    
    public AppButton2(String text, int x, int y, int width, int height)
    {
        this(text);
        this.setBounds(x, y, width, height);
    }
    
    public AppButton2(String text, int x, int y, int width, int height, int fontSize)
    {
        this(text, x, y, width, height);
        this.setFont(new java.awt.Font("Arial", 1, fontSize));
    }
}
