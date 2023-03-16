/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import javax.swing.JPanel;

/**
 *
 * @author balth
 */
public class HLine extends JPanel {
    
    public HLine(int x, int y, int length)
    {
        super();
        this.setBackground(AppWindow.CARROT_ORANGE);
        this.setBounds(x, y, length, 1);
    }
}
