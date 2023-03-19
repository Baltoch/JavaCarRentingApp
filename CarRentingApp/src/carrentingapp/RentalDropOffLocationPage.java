/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

/**
 *
 * @author balth
 */
public class RentalDropOffLocationPage extends Page {
    
    JLabel title;
    JLabel locationName;
    LeftArrowButton leftArrow;
    RightArrowButton rightArrow;
    AppButton1 toNext;
    AppButton3 toPrev;
    NavBar nav;
    AppBackground background;
    
    Location[] locations;
    int displayedIndex;
    
    private Rental rental;
    
    public RentalDropOffLocationPage(AppWindow appWindow, Rental tempRental, Location[] tempLocations, int tempDisplayedIndex)
    {
        super(appWindow);
        
        double widthRatio = window.getWidth()/1280.0;
        double heightRatio = window.getHeight()/720.0;
        
        displayedIndex = tempDisplayedIndex;
        
        rental = tempRental;
        
        locations = tempLocations;
        
        title = new JLabel();
        title.setText("Choose The Drop Off Location");
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
                
        toNext = new AppButton1("Next", (int) (widthRatio*661), (int) (heightRatio*533), (int) (widthRatio*187), (int) (heightRatio*37));
        toNext.addActionListener((ActionEvent evt) -> {
            rental.setReturnLocation(locations[displayedIndex]);
            if(next == null) {
                next = new RentalDatesPage(window, rental);
                next.prev = this;
            }
            window.page = next;
            window.getLayeredPane().removeAll();
            next.addToLayeredPane();
            next.setVisible(false);
            next.setVisible(true);
        });
        
        toPrev = new AppButton3("Back", (int) (widthRatio*440), (int) (heightRatio*533), (int) (widthRatio*187), (int) (heightRatio*37));
        toPrev.addActionListener((ActionEvent evt) -> {
            rental.setReturnLocation(locations[displayedIndex]);
            window.page = prev;
            window.getLayeredPane().removeAll();
            prev.addToLayeredPane();
            prev.setVisible(false);
            prev.setVisible(true);
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
        layeredPane.add(toPrev);
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
        layeredPane.remove(toPrev);
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
        toPrev.setVisible(visible);
        nav.setVisible(visible);
        background.setVisible(visible);
    }
    
}
