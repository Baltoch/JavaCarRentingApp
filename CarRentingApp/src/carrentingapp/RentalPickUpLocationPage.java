/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

/**
 *
 * @author balth
 */
public class RentalPickUpLocationPage extends Page {
    
    private JLabel title;
    private JLabel locationName;
    private LeftArrowButton leftArrow;
    private RightArrowButton rightArrow;
    private AppButton1 toNext;
    private NavBar nav;
    private AppBackground background;
    
    private Location[] locations;
    private int displayedIndex;
    
    private Rental rental;
    
    public RentalPickUpLocationPage(AppWindow appWindow)
    {
        super(appWindow);
        
        double widthRatio = window.getWidth()/1280;
        double heightRatio = window.getHeight()/720;
        
        rental = new Rental();
        rental.setRenter(window.user);
        
        displayedIndex = 0;
        
        MySqlConnection conn = new MySqlConnection();
        ResultSet res = conn.executeSELECTQuery("SELECT COUNT(*) FROM Locations");
        try {
            res.next();
            locations = new Location[res.getInt(1)];
        } catch (SQLException ex) {
            Logger.getLogger(RentalPickUpLocationPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        res = conn.executeSELECTQuery("SELECT * FROM Locations;");
        try {
            int i = 0;
            while(res.next())
            {
                locations[i] = new Location(res.getInt("locationId"), res.getString("name"), res.getString("image"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RentalPickUpLocationPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        
        title = new JLabel();
        title.setText("Choose The Pick Up Location");
        title.setFont(new Font("Arial", Font.BOLD, (int) (heightRatio*40)));
        title.setForeground(AppWindow.OFF_WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setBounds((int) (widthRatio*190), (int) (heightRatio*150), (int) (widthRatio*900), (int) (heightRatio*48));
        
        locationName = new JLabel();
        locationName.setText(locations[displayedIndex].getName());
        locationName.setForeground(AppWindow.OFF_WHITE);
        locationName.setFont(new Font("Arial", Font.PLAIN, (int) (heightRatio*64)));
        locationName.setHorizontalAlignment(JLabel.CENTER);
        locationName.setVerticalAlignment(JLabel.CENTER);
        locationName.setBounds((int) (widthRatio*309), (int) (heightRatio*322), (int) (widthRatio*620), (int) (heightRatio*77));

        leftArrow = new LeftArrowButton((int) (widthRatio*229), (int) (heightRatio*320), (int) (widthRatio*80), (int) (heightRatio*80));
        leftArrow.addActionListener((ActionEvent evt) -> {
            displayedIndex -= 1;
            if(displayedIndex == -1) displayedIndex += locations.length;
            locationName.setText(locations[displayedIndex].getName());
            background.changeImage(new ImageIcon(getClass().getResource(locations[displayedIndex].getImage())));
        });
                
        rightArrow = new RightArrowButton((int) (widthRatio*929), (int) (heightRatio*320), (int) (widthRatio*80), (int) (heightRatio*80));
        rightArrow.addActionListener((ActionEvent evt) -> {
            displayedIndex += 1;
            if(displayedIndex == locations.length) displayedIndex -= locations.length;
            locationName.setText(locations[displayedIndex].getName());
            background.changeImage(new ImageIcon(getClass().getResource(locations[displayedIndex].getImage())));
        });
                
        toNext = new AppButton1("Next", (int) (widthRatio*472), (int) (heightRatio*533), (int) (widthRatio*336), (int) (heightRatio*37));
        toNext.addActionListener((ActionEvent evt) -> {
            rental.setPickUpLocation(locations[displayedIndex]);
            if(next == null) {
                next = new RentalDropOffLocationPage(window, rental, locations, displayedIndex);
                next.prev = this;
            }
            window.page = next;
            window.getLayeredPane().removeAll();
            next.addToLayeredPane();
            next.setVisible(false);
            next.setVisible(true);
        });
        
        
        nav = new NavBar(window);
                
        background = new AppBackground(window.getWidth(), window.getHeight(), new ImageIcon(getClass().getResource(locations[displayedIndex].getImage())));
        
        
    }

    @Override
    public void addToLayeredPane() {
        JLayeredPane layeredPane = window.getLayeredPane();
        layeredPane.add(title);
        layeredPane.add(locationName);
        layeredPane.add(leftArrow);
        layeredPane.add(rightArrow);
        layeredPane.add(toNext);
        nav.addToLayeredPane();
        background.addToLayeredPane(layeredPane);
        
    }

    @Override
    public void removeFromLayeredPane() {
        JLayeredPane layeredPane = window.getLayeredPane();
        layeredPane.remove(title);
        layeredPane.remove(locationName);
        layeredPane.remove(leftArrow);
        layeredPane.remove(rightArrow);
        layeredPane.remove(toNext);
        nav.removeFromLayeredPane();
        background.removeFromLayeredPane(layeredPane);
    }

    @Override
    public void setVisible(boolean visible) {
        title.setVisible(visible);
        locationName.setVisible(visible);
        leftArrow.setVisible(visible);
        rightArrow.setVisible(visible);
        toNext.setVisible(visible);
        nav.setVisible(visible);
        background.setVisible(visible);
    }
    
}
