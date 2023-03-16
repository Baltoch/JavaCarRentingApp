/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author balth
 */
public class RightArrowButton extends JButton {
    public RightArrowButton(int x, int y, int width, int height)
    {
        super();
        ImageIcon image = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Button/rightArrow.png"));
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setBounds(x, y, width, height);
        this.setIcon(new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
}
