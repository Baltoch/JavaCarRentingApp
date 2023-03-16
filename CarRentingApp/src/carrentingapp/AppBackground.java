/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author balth
 */
public class AppBackground {
    
    private HLine line1;
    private HLine line2;
    private HLine line3;
    private VLine line4;
    private VLine line5;
    private JLabel label;
    private JPanel background;
    
    public AppBackground(int screenWidth, int screenHeight)
    {
        double widthRatio = screenWidth/1280.0;
        double heightRatio = screenHeight/720.0;
        line1 = new HLine((int) (widthRatio*220), (int) (heightRatio*50), (int) (widthRatio*110));
        line2 = new HLine((int) (widthRatio*220), (int) (heightRatio*61), (int) (widthRatio*110));
        line3 = new HLine((int) (widthRatio*202), (int) (heightRatio*669), (int) (widthRatio*150));
        line4 = new VLine((int) (widthRatio*89), (int) (heightRatio*100), (int) (heightRatio*174));
        line5 = new VLine((int) (widthRatio*1189), (int) (heightRatio*348), (int) (heightRatio*205));
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setOpaque(false);
        label.setBackground(new Color(0,0,0,0));
        label.setBorder(BorderFactory.createLineBorder(AppWindow.CARROT_ORANGE, 2, true));
        label.setBounds((int) (widthRatio*98), (int) (heightRatio*55), (int) (widthRatio*1083), (int) (heightRatio*609));
        
        background = new JPanel();
        background.setBackground(AppWindow.EERIE_BLACK);
        background.setBounds(0, 0, screenWidth, screenHeight);

    }
    
    public AppBackground(int screenWidth, int screenHeight, ImageIcon image)
    {
        this(screenWidth, screenHeight);
        label.setIcon(new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void changeImage(ImageIcon image)
    {
        label.setIcon(new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void addToLayeredPane(JLayeredPane layeredPane)
    {
        layeredPane.add(line1);
        layeredPane.add(line2);
        layeredPane.add(line3);
        layeredPane.add(line4);
        layeredPane.add(line5);
        layeredPane.add(label);
        layeredPane.add(background);
    }
    
    public void removeFromLayeredPane(JLayeredPane layeredPane)
    {
        layeredPane.remove(line1);
        layeredPane.remove(line2);
        layeredPane.remove(line3);
        layeredPane.remove(line4);
        layeredPane.remove(line5);
        layeredPane.remove(label);
        layeredPane.remove(background);
    }
    
    public void setVisible(boolean visible)
    {
        line1.setVisible(visible);
        line2.setVisible(visible);
        line3.setVisible(visible);
        line4.setVisible(visible);
        line5.setVisible(visible);
        label.setVisible(visible);
        background.setVisible(visible);
    }
}
