/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
    
    NavBar nav;
    
    public HomePage(AppWindow appWindow)
    {
        super(appWindow);
        
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
        rentNow.addActionListener((ActionEvent evt) -> {
            window.page.next = new RentalPickUpLocationPage(window);
            window.page.next.prev = window.page;
            window.page = window.page.next;
            window.getLayeredPane().removeAll();
            window.page.addToLayeredPane();
            window.page.setVisible(false);
            window.page.setVisible(true);
        });
        
        browseMembership = new AppButton2("Browse Membership", 337, 512, 250, 50, 20);
        
        background = new AppBackground(window.getWidth(), window.getHeight());
        
        nav = new NavBar(window);
    }
    
    @Override
    public void addToLayeredPane()
    {
        window.getLayeredPane().add(title);
        window.getLayeredPane().add(subTitle);
        window.getLayeredPane().add(rentNow);
        window.getLayeredPane().add(browseMembership);
        nav.addToLayeredPane();
        background.addToLayeredPane(window.getLayeredPane());
    }
    
    @Override
    public void removeFromLayeredPane()
    {
        window.getLayeredPane().remove(title);
        window.getLayeredPane().remove(subTitle);
        window.getLayeredPane().remove(rentNow);
        window.getLayeredPane().remove(browseMembership);
        nav.removeFromLayeredPane();
        background.removeFromLayeredPane(window.getLayeredPane());
    }
    
    @Override
    public void setVisible(boolean visible)
    {
        title.setVisible(visible);
        subTitle.setVisible(visible);
        rentNow.setVisible(visible);
        browseMembership.setVisible(visible);
        nav.setVisible(visible);
        background.setVisible(visible);        
    }
    
}
