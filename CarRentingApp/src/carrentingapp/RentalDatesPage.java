/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author balth
 */
public class RentalDatesPage extends Page {
    
    AppCalendar pickUpDate;
    AppCalendar dropOffDate;
    
    JLabel pickUpDateTitle;
    JLabel dropOffDateTitle;
    
    AppButton1 toNext;
    AppButton3 toPrev;
    
    NavBar nav;
    
    AppBackground background;
    
    public RentalDatesPage(AppWindow appWindow, Rental rental)
    {
        super(appWindow);
        
        double widthRatio = window.getWidth()/1280.0;
        double heightRatio = window.getHeight()/720.0;
        
        pickUpDateTitle = new JLabel("Choose The Pick Up Date");
        pickUpDateTitle.setForeground(AppWindow.OFF_WHITE);
        pickUpDateTitle.setHorizontalAlignment(JLabel.CENTER);
        pickUpDateTitle.setVerticalAlignment(JLabel.CENTER);
        pickUpDateTitle.setFont(new Font("Arial", Font.BOLD, 24));
        pickUpDateTitle.setBounds(120, 125, 500, 29);
        
        dropOffDateTitle = new JLabel("Choose The Drop Off Date");
        dropOffDateTitle.setForeground(AppWindow.OFF_WHITE);
        dropOffDateTitle.setHorizontalAlignment(JLabel.CENTER);
        dropOffDateTitle.setVerticalAlignment(JLabel.CENTER);
        dropOffDateTitle.setFont(new Font("Arial", Font.BOLD, 24));
        dropOffDateTitle.setBounds(662, 125, 500, 29);
        
        pickUpDate = new AppCalendar(210, 182, 320, 355);
        dropOffDate = new AppCalendar(738, 182, 320, 355);
        
        toNext = new AppButton1("Next", (int) (widthRatio*661), (int) (heightRatio*563), (int) (widthRatio*187), (int) (heightRatio*37));
        
        toPrev = new AppButton3("Back", (int) (widthRatio*440), (int) (heightRatio*563), (int) (widthRatio*187), (int) (heightRatio*37));
        toPrev.addActionListener((ActionEvent evt) -> {
            rental.setStartingDate(new Date(pickUpDate.getSelectedDate().getTime()));
            rental.setEndingDate(new Date(dropOffDate.getSelectedDate().getTime()));
            window.page = prev;
            window.getLayeredPane().removeAll();
            prev.addToLayeredPane();
            prev.setVisible(false);
            prev.setVisible(true);
        });
        
        nav = new NavBar(window);
        
        background = new AppBackground(window.getWidth(), window.getHeight(), new ImageIcon(getClass().getResource("/carrentingapp/img/RentalDatesBackground.png")));
    }

    @Override
    public void addToLayeredPane() {
        JLayeredPane layeredPane = window.getLayeredPane();
        pickUpDate.addToLayeredPane(layeredPane);
        dropOffDate.addToLayeredPane(layeredPane);
        layeredPane.add(pickUpDateTitle);
        layeredPane.add(dropOffDateTitle);
        layeredPane.add(toNext);
        layeredPane.add(toPrev);
        nav.addToLayeredPane();
        background.addToLayeredPane(layeredPane);
    }

    @Override
    public void removeFromLayeredPane() {
        JLayeredPane layeredPane = window.getLayeredPane();
        pickUpDate.removeFromLayeredPane(layeredPane);
        dropOffDate.removeFromLayeredPane(layeredPane);
        layeredPane.remove(pickUpDateTitle);
        layeredPane.remove(dropOffDateTitle);
        layeredPane.remove(toNext);
        layeredPane.remove(toPrev);
        nav.removeFromLayeredPane();
        background.removeFromLayeredPane(layeredPane);
    }

    @Override
    public void setVisible(boolean visible) {
        pickUpDate.setVisible(visible);
        dropOffDate.setVisible(visible);
        pickUpDateTitle.setVisible(visible);
        dropOffDateTitle.setVisible(visible);
        toNext.setVisible(visible);
        toPrev.setVisible(visible);
        nav.setVisible(visible);
        background.setVisible(visible);
    }
    
}
