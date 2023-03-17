/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author balth
 */
public class UserMenu extends Page {
    
    private JLabel rentalsTitle;
    private MenuLink rental1;
    private MenuLink rental2;
    private MenuLink rental3;
    
    private JLabel membershipTitle;
    private MenuLink membership1;
    private MenuLink membership2;
    private MenuLink membership3;
    
    private JLabel accountTitle;
    private MenuLink account1;
    private MenuLink account2;
    private MenuLink account3;
    
    private MenuNavBar nav;
    
    private AppBackground background;
    
    public UserMenu(AppWindow appWindow)
    {
        super(appWindow);
        rentalsTitle = new JLabel();
        rentalsTitle.setText("Rentals");
        rentalsTitle.setFont(new Font("Arial", Font.BOLD, 32));
        rentalsTitle.setForeground(Color.WHITE);
        rentalsTitle.setBounds(221, 250, 118, 39);
        
        rental1 = new MenuLink("Lorem ipsum", 229, 331, 101, 19, 16);
        rental2 = new MenuLink("Lorem ipsum", 229, 392, 101, 19, 16);
        rental3 = new MenuLink("Lorem ipsum", 229, 453, 101, 19, 16);
        
        membershipTitle = new JLabel();
        membershipTitle.setText("Memberships");
        membershipTitle.setFont(new Font("Arial", Font.BOLD, 32));
        membershipTitle.setForeground(Color.WHITE);
        membershipTitle.setBounds(534, 250, 216, 39);
        
        membership1 = new MenuLink("Lorem ipsum", 590, 331, 101, 19, 16);
        membership2 = new MenuLink("Lorem ipsum", 590, 392, 101, 19, 16);
        membership3 = new MenuLink("Lorem ipsum", 590, 453, 101, 19, 16);
        
        accountTitle = new JLabel();
        accountTitle.setText("My Account");
        accountTitle.setFont(new Font("Arial", Font.BOLD, 32));
        accountTitle.setForeground(Color.WHITE);
        accountTitle.setBounds(908, 250, 188, 39);
        
        account1 = new MenuLink("Lorem ipsum", 951, 331, 101, 19, 16);
        account2 = new MenuLink("Lorem ipsum", 951, 392, 101, 19, 16);
        account3 = new MenuLink("Lorem ipsum", 951, 453, 101, 19, 16);
        
        nav = new MenuNavBar(window);
        
        background = new AppBackground(window.getWidth(), window.getHeight());
    }

    @Override
    public void addToLayeredPane() {
        JLayeredPane layeredPane = window.getLayeredPane();
        layeredPane.add(rentalsTitle);
        layeredPane.add(rental1);
        layeredPane.add(rental2);
        layeredPane.add(rental3);
        layeredPane.add(membershipTitle);
        layeredPane.add(membership1);
        layeredPane.add(membership2);
        layeredPane.add(membership3);
        layeredPane.add(accountTitle);
        layeredPane.add(account1);
        layeredPane.add(account2);
        layeredPane.add(account3);
        nav.addToLayeredPane();
        background.addToLayeredPane(layeredPane);
    }

    @Override
    public void removeFromLayeredPane() {
        JLayeredPane layeredPane = window.getLayeredPane();
        layeredPane.remove(rentalsTitle);
        layeredPane.remove(rental1);
        layeredPane.remove(rental2);
        layeredPane.remove(rental3);
        layeredPane.remove(membershipTitle);
        layeredPane.remove(membership1);
        layeredPane.remove(membership2);
        layeredPane.remove(membership3);
        layeredPane.remove(accountTitle);
        layeredPane.remove(account1);
        layeredPane.remove(account2);
        layeredPane.remove(account3);
        nav.removeFromLayeredPane();
        background.removeFromLayeredPane(layeredPane);
    }

    @Override
    public void setVisible(boolean visible) {
        window.setVisible(visible);
        rentalsTitle.setVisible(visible);
        rental1.setVisible(visible);
        rental2.setVisible(visible);
        rental3.setVisible(visible);
        membershipTitle.setVisible(visible);
        membership1.setVisible(visible);
        membership2.setVisible(visible);
        membership3.setVisible(visible);
        accountTitle.setVisible(visible);
        account1.setVisible(visible);
        account2.setVisible(visible);
        account3.setVisible(visible);
        nav.setVisible(visible);
        background.setVisible(visible);
    }
}
