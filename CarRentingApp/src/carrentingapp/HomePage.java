/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author balth
 */
public class HomePage extends Page {
    
    JTextArea title;
    JTextArea subTitle;
    AppBackground background;
    AppButton1 rentNow;
    AppButton2 browseMembership;
    
    User user;
    
    public HomePage(AppWindow appWindow, User user)
    {
        super(appWindow);
        
        this.user = user;
        
        title = new JTextArea();
        title.setText("""
                        KEYS TO
                        MEMORABLE
                        JOURNEYS
                        """);
        title.setFont(new Font("Arial", 0, 64));
        title.setBounds(167, 160, 406, 231);
        title.setOpaque(false);
        title.setBackground(new Color(0,0,0,0));
        title.setEnabled(false);
        title.setDisabledTextColor(AppWindow.OFF_WHITE);
        
        subTitle = new JTextArea();
        subTitle.setText("""
                        Discover new destinations, create unforgettable
                        memories, and enjoy a journey that's tailored just
                        for you !
                        """);
        subTitle.setFont(new Font("Arial", 0, 16));
        subTitle.setBounds(167, 414, 394, 75);
        subTitle.setOpaque(false);
        subTitle.setBackground(new Color(0,0,0,0));
        subTitle.setEnabled(false);
        subTitle.setDisabledTextColor(AppWindow.OFF_WHITE);
        
        
        rentNow = new AppButton1("Rent Now", 167, 512, 150, 50, 20);
        
        browseMembership = new AppButton2("Browse Membership", 337, 512, 250, 50, 20);
        
        background = new AppBackground(window.getWidth(), window.getHeight());
    }
    
    @Override
    public void addToLayeredPane()
    {
        window.getLayeredPane().add(title);
        window.getLayeredPane().add(subTitle);
        window.getLayeredPane().add(rentNow);
        window.getLayeredPane().add(browseMembership);
        background.addToLayeredPane(window.getLayeredPane());
    }
    
    @Override
    public void removeFromLayeredPane()
    {
        window.getLayeredPane().remove(title);
        window.getLayeredPane().remove(subTitle);
        window.getLayeredPane().remove(rentNow);
        window.getLayeredPane().remove(browseMembership);
        background.removeFromLayeredPane(window.getLayeredPane());
    }
    
    @Override
    public void setVisible(boolean visible)
    {
        title.setVisible(visible);
        subTitle.setVisible(visible);
        rentNow.setVisible(visible);
        browseMembership.setVisible(visible);
        background.setVisible(visible);
    }
    
}
