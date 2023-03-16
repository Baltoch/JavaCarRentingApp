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
public class VLine extends JPanel {
    
    public VLine(int x, int y, int length)
    {
        super();
        this.setBackground(AppWindow.CARROT_ORANGE);
        this.setBounds(x, y, 1, length);
    }
}
