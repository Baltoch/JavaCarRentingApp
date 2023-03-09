/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author balth
 */
public class AppWindow extends JFrame{
    private static final Color CARROT_ORANGE = new Color(245, 153, 35);
    private static final Color ALLOY_ORANGE = new Color(198, 93, 10);
    private static final Color BARN_RED = new Color(109, 36, 14);
    private static final Color BISTRE = new Color(76, 48, 36);
    private static final Color EERIE_BLACK = new Color(23, 23, 25);
    
    public AppWindow()
    {
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new CardLayout());
        
        ImageIcon bImage  = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Rework_goneho9589_Paris_landscape_high_resolution_8b5e126f-33cd-4337-b2d4-65d10764978f.png")); 
        JLabel backgroundImage = new JLabel();
        backgroundImage.setBounds(0, 0, 1280, 720);
        backgroundImage.setIcon(new ImageIcon(bImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
        
        JLayeredPane layeredPane = getLayeredPane();
        
        //ImageIcon uImage  = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Crop_goneho9589_car_renting_software_sign_up_form_page_high_resoluti_1439b2d0-4281-4cc6-aab4-bfd0e2357b99.png")); 
        JLabel upperImage = new JLabel();
        upperImage.setBounds(100, 0, 1080, 567);
        upperImage.setBackground(EERIE_BLACK);
        //upperImage.setIcon(new ImageIcon(uImage.getImage().getScaledInstance(upperImage.getWidth(), upperImage.getHeight(), Image.SCALE_DEFAULT)));
        
        JLabel welcomeText = new JLabel();
        welcomeText.setFont(new java.awt.Font("Arial", 1, 36)); 
        welcomeText.setForeground(Color.WHITE);
        welcomeText.setText("Welcome Back !");
        welcomeText.setBounds(142, 132, 276, 44);
        
        JTextField Email = new JTextField(); 
        Email.setFont(new java.awt.Font("Arial", 0, 16)); 
        Email.setForeground(CARROT_ORANGE);
        Email.setText("Email");
        Email.setBounds(138, 236,283, 37);
        
        JPasswordField Password = new JPasswordField();
        Password.setFont(new java.awt.Font("Arial", 0, 16)); 
        Password.setForeground(CARROT_ORANGE);
        Password.setText("Password");
        Password.setBounds(138, 293, 283, 37);
        
        
        JButton signIn = new JButton();
        signIn.setBackground(CARROT_ORANGE);
        signIn.setFont(new java.awt.Font("Arial", 1, 20)); 
        signIn.setForeground(Color.WHITE);
        signIn.setText("Sign In");
        signIn.setBounds(138, 379, 283, 37);
        
        JLabel optionText = new JLabel();
        optionText.setText("Don't have an acount ?");
        optionText.setFont(new Font("Arial", 1, 20));
        optionText.setForeground(CARROT_ORANGE);
        optionText.setBounds(525, 577, 231, 24);
        
        JButton signUp = new JButton();
        signUp.setBackground(CARROT_ORANGE);
        signUp.setFont(new java.awt.Font("Arial", 1, 16)); 
        signUp.setForeground(Color.WHITE);
        signUp.setText("Sign Up");
        signUp.setBounds(565, 611, 150, 24);
        
        layeredPane.add(welcomeText);
        layeredPane.add(Email);
        layeredPane.add(Password);
        layeredPane.add(signIn);
        layeredPane.add(optionText);
        layeredPane.add(signUp);
        layeredPane.add(upperImage);
        layeredPane.add(backgroundImage);
        
        this.setVisible(true);
        /*
                        Date time = new Date();
                        long start = time.getTime();
                        long t = new Date().getTime()-start;
                        long f = 0;
                        Random random = new Random();
                        while(t<10000)
                        {
                            t = new Date().getTime()-start;
                            System.out.println(time.getTime());
                            if(t>f) 
                            {
                                optionText.setLocation(optionText.getLocation().x-random.nextInt(45), optionText.getLocation().y-random.nextInt(59));
                                f+=100;
                            } 
                        }

                        layeredPane.setVisible(false);
                        */
    }
}

class BackgroundPanel extends JPanel {
 
    private static final long serialVersionUID = 1L;
    private ImageIcon background;
   
    public BackgroundPanel(String fileName) {
        super();
        this.setLayout(new GridBagLayout());
        this.background = new ImageIcon(fileName);
    }
 
    public void setBackground(ImageIcon background) {
        this.background = background;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, this);
    }
}