/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author balth
 */
public class AppPasswordField extends JPasswordField {
    
    private String original;
    
    public AppPasswordField(String text)
    {
        super(); 
        original = text;
        this.setFont(new java.awt.Font("Arial", 0, 16)); 
        this.setForeground(AppWindow.CARROT_ORANGE);
        this.setSelectionColor(AppWindow.CARROT_ORANGE);
        this.setSelectedTextColor(Color.WHITE);
        this.setOpaque(false);
        this.setBackground(new Color(0,0,0,0));
        this.setText(text);
        this.setBorder(BorderFactory.createLineBorder(AppWindow.CARROT_ORANGE, 1, true));
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                if(getText().equalsIgnoreCase(original))
                {
                    setText("");
                    setBorder(BorderFactory.createTitledBorder(getBorder(), original, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.PLAIN, 12), AppWindow.CARROT_ORANGE));
                } 
            }
            
            @Override
            public void focusLost(FocusEvent evt)
            {
                if(getText().equalsIgnoreCase(""))
                {
                    setText(original);
                    setBorder(BorderFactory.createLineBorder(AppWindow.CARROT_ORANGE, 1, true));
                } 
            }
        });
    }
    
    public AppPasswordField(String text, int x, int y, int width, int height)
    {
        this(text);
        this.setBounds(x, y, width, height);
    }
    
}
