/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.*;

/**
 *
 * @author balth
 */
public class RentalPage {
    
    private JLabel pickUpLocationTitle;
    private JLabel location;
    private JLabel locationImage;
    private JLabel leftArrow;
    private JLabel rightArrow;
    private JButton nextButton;
    
    public RentalPage(int width, int height)
    {
        double widthRatio = width/1080.0;
        double heightRatio = height/720.0;
        
        pickUpLocationTitle = new JLabel();
        pickUpLocationTitle.setText("Choose The Pick Up Location");
        pickUpLocationTitle.setFont(new Font("Arial", Font.BOLD, 40));
        pickUpLocationTitle.setBounds(353, 150, 575, 48);
        pickUpLocationTitle.setHorizontalAlignment(JLabel.CENTER);
        pickUpLocationTitle.setBorder(BorderFactory.createLineBorder(AppWindow.EERIE_BLACK, 3));
        
        
        location = new JLabel();
        location.setText("Paris");
        location.setFont(new Font("Arial", Font.BOLD, 64));
        location.setBounds(559, 322, 162, 77);
        location.setHorizontalAlignment(JLabel.CENTER);
        location.setBorder(BorderFactory.createLineBorder(AppWindow.EERIE_BLACK, 3));
                
        locationImage = new JLabel();
        locationImage.setIcon(new ImageIcon(getClass().getResource("/carrentingapp/testimg/Paris.png")));
        locationImage.setHorizontalAlignment(JLabel.CENTER);
        locationImage.setVerticalAlignment(JLabel.CENTER);
        locationImage.setBorder(BorderFactory.createLineBorder(AppWindow.CARROT_ORANGE, 1, true));
        locationImage.setBounds(98, 56, 1083, 609);
              
        ImageIcon imageLeftArrow = new ImageIcon(getClass().getResource("/carrentingapp/testimg/leftArrow.png"));
        leftArrow = new JLabel();
        leftArrow.setBounds(242, 320, 80, 80);
        leftArrow.setIcon(new ImageIcon(imageLeftArrow.getImage().getScaledInstance(leftArrow.getWidth(), leftArrow.getHeight(), Image.SCALE_SMOOTH)));
        leftArrow.setHorizontalAlignment(JLabel.CENTER);
        leftArrow.setVerticalAlignment(JLabel.CENTER);
        
        ImageIcon imageRightArrow = new ImageIcon(getClass().getResource("/carrentingapp/testimg/rightArrow.png"));
        rightArrow = new JLabel();
        rightArrow.setBounds(957, 320, 80, 80);
        rightArrow.setIcon(new ImageIcon(imageLeftArrow.getImage().getScaledInstance(leftArrow.getWidth(), leftArrow.getHeight(), Image.SCALE_SMOOTH)));
        rightArrow.setHorizontalAlignment(JLabel.CENTER);
        rightArrow.setVerticalAlignment(JLabel.CENTER);
               
        nextButton = new JButton();
        nextButton.setText("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.setBackground(AppWindow.CARROT_ORANGE);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(472, 533, 336, 37);
        
        
    }
}
