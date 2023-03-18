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
    
    JLabel title;
    JLabel locationName;
    LeftArrowButton leftArrow;
    RightArrowButton rightArrow;
    AppButton1 toNext;
    NavBar nav;
    AppBackground background;
    
    String[][] locations;
    int displayedIndex;
    
    public RentalPickUpLocationPage(AppWindow appWindow)
    {
        super(appWindow);
        
        double widthRatio = window.getWidth()/1280;
        double heightRatio = window.getHeight()/720;
        
        displayedIndex = 0;
        
        MySqlConnection conn = new MySqlConnection();
        ResultSet res = conn.executeSELECTQuery("SELECT COUNT(*) FROM Locations");
        try {
            res.next();
            locations = new String[2][res.getInt(1)];
        } catch (SQLException ex) {
            Logger.getLogger(RentalPickUpLocationPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        res = conn.executeSELECTQuery("SELECT name, image FROM Locations;");
        try {
            int i = 0;
            while(res.next())
            {
                locations[0][i] = res.getString(1);
                locations[1][i] = res.getString(2); 
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
        title.setBounds((int) (widthRatio*353), (int) (heightRatio*150), (int) (widthRatio*575), (int) (heightRatio*48));
        
        locationName = new JLabel();
        locationName.setText(locations[0][displayedIndex]);
        locationName.setForeground(AppWindow.OFF_WHITE);
        locationName.setFont(new Font("Arial", Font.PLAIN, (int) (heightRatio*64)));
        locationName.setHorizontalAlignment(JLabel.CENTER);
        locationName.setVerticalAlignment(JLabel.CENTER);
        locationName.setBounds((int) (widthRatio*309), (int) (heightRatio*322), (int) (widthRatio*620), (int) (heightRatio*77));

        leftArrow = new LeftArrowButton((int) (widthRatio*229), (int) (heightRatio*320), (int) (widthRatio*80), (int) (heightRatio*80));
        leftArrow.addActionListener((ActionEvent evt) -> {
            displayedIndex -= 1;
            if(displayedIndex == -1) displayedIndex += locations[0].length;
            locationName.setText(locations[0][displayedIndex]);
            background.changeImage(new ImageIcon(getClass().getResource(locations[1][displayedIndex])));
        });
                
        rightArrow = new RightArrowButton((int) (widthRatio*929), (int) (heightRatio*320), (int) (widthRatio*80), (int) (heightRatio*80));
        rightArrow.addActionListener((ActionEvent evt) -> {
            displayedIndex += 1;
            if(displayedIndex == locations[0].length) displayedIndex -= locations[0].length;
            locationName.setText(locations[0][displayedIndex]);
            background.changeImage(new ImageIcon(getClass().getResource(locations[1][displayedIndex])));
        });
                
        toNext = new AppButton1("Next", (int) (widthRatio*472), (int) (heightRatio*533), (int) (widthRatio*336), (int) (heightRatio*37));
                
        nav = new NavBar(window);
                
        background = new AppBackground(window.getWidth(), window.getHeight(), new ImageIcon(getClass().getResource(locations[1][displayedIndex])));
        
        
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
