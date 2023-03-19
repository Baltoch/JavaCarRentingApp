/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author balth
 */
public class MenuNavBar {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    
    private AppWindow window;
    
    public MenuNavBar(AppWindow appWindow)
    {   
        window = appWindow;
        
        double widthRatio = 1280/window.getWidth();
        double heightRatio = 720/window.getHeight();
        
        ImageIcon image1 = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Button/HomeThin.png"));
        ImageIcon hoverImage1 = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Button/HomeHover.png"));
        button1 = new JButton();
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        button1.setBounds((int) (widthRatio*1211), (int) (heightRatio*228), (int) (widthRatio*40), (int) (heightRatio*40));
        button1.setIcon(new ImageIcon(image1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_SMOOTH)));
        button1.setRolloverIcon(new ImageIcon(hoverImage1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_SMOOTH)));
        button1.addActionListener((ActionEvent evt) -> {
            window.page.removeFromLayeredPane();
            while(window.page.prev != null)
            {
                window.page = window.page.prev;
                window.page.next = null;
            }
            window.getLayeredPane().removeAll();
            window.page.addToLayeredPane();
            window.page.setVisible(false);
            window.page.setVisible(true);
        });
        
        ImageIcon image2 = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Button/XThin.png"));
        ImageIcon hoverImage2 = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Button/XHover.png"));
        button2 = new JButton();
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setContentAreaFilled(false);
        button2.setBounds((int) (widthRatio*1211), (int) (heightRatio*284), (int) (widthRatio*40), (int) (heightRatio*40));
        button2.setIcon(new ImageIcon(image2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_SMOOTH)));
        button2.setRolloverIcon(new ImageIcon(hoverImage2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_SMOOTH)));
        button2.addActionListener((ActionEvent evt) -> {
            window.page = window.page.prev;
            window.page.next = window.page.next.next;
            window.getLayeredPane().removeAll();
            window.page.addToLayeredPane();
            window.page.setVisible(false);
            window.page.setVisible(true);
            
        });
        
        ImageIcon image3 = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Button/PowerOffThin.png"));
        ImageIcon hoverImage3 = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Button/PowerOffHover.png"));
        button3 = new JButton();
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setContentAreaFilled(false);
        button3.setBounds((int) (widthRatio*1211), (int) (heightRatio*341), (int) (widthRatio*40), (int) (heightRatio*40));
        button3.setIcon(new ImageIcon(image3.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_SMOOTH)));
        button3.setRolloverIcon(new ImageIcon(hoverImage3.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_SMOOTH)));
        button3.addActionListener((ActionEvent evt) -> {
            System.exit(0);
        });
    }
    
    public void addToLayeredPane()
    {
        JLayeredPane layeredPane = window.getLayeredPane();
        layeredPane.add(button1);
        layeredPane.add(button2);
        layeredPane.add(button3);
    }
    
    public void removeFromLayeredPane()
    {
        JLayeredPane layeredPane = window.getLayeredPane();
        layeredPane.remove(button1);
        layeredPane.remove(button2);
        layeredPane.remove(button3);
    }
    
    public void setVisible(boolean visible)
    {
        button1.setVisible(visible);
        button2.setVisible(visible);
        button3.setVisible(visible);
    }
    
}
