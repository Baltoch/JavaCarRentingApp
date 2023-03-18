/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentingapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author balth
 */
public class AppWindow extends JFrame{
    public static final Color CARROT_ORANGE = new Color(245, 153, 35);
    public static final Color ALLOY_ORANGE = new Color(198, 93, 10);
    public static final Color BARN_RED = new Color(109, 36, 14);
    public static final Color BISTRE = new Color(76, 48, 36);
    public static final Color EERIE_BLACK = new Color(23, 23, 25);
    public static final Color OFF_WHITE = new Color(219, 199, 186);
    
    public Page page;
    
    public User user;
    
    public AppWindow()
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Auto Rental");
        this.setLayout(new CardLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/carrentingapp/testimg/Logo.png")).getImage());
        
        /*
                        JLabel displaySize = new JLabel();
                        displaySize.setText("width: "+screen.width+" heigth: "+screen.height);
                        displaySize.setFont(new java.awt.Font("Arial", 0, 35)); 
                        displaySize.setBounds(50, 50, displaySize.getPreferredSize().width, displaySize.getPreferredSize().height);
                        */
        JLayeredPane layeredPane = getLayeredPane();
        
        //layeredPane.add(displaySize);
        
        NavBar nav = new NavBar(this);
        nav.addToLayeredPane();
        
        page = new LandingPage(this);
 
        page.addToLayeredPane();
                
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
    
    public static String toHash(String s) throws NoSuchAlgorithmException 
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        StringBuilder out = new StringBuilder();
        for (byte b : md.digest(s.getBytes(StandardCharsets.UTF_8))) {
            out.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return out.toString();
    }
}

class LandingPage extends Page {
    
    private JLabel welcomeText;
    private AppTextField Email;
    private AppPasswordField Password;
    private JButton signIn;
    private JLabel optionText;
    private JButton toSignUp;
    private JLabel upperImage;
    private JPanel upperPart;
    
    private JLabel signUpUpperImage;
    private JLabel signUpWelcomeText;
    private AppTextField firstName;
    private AppTextField lastName;
    private AppTextField signUpEmail;
    private AppPasswordField signUpPassword;
    private AppTextField driverLicense;
    private JLabel toLoginOptionText;
    private JButton toLogIn;
    private JButton signUp;
    private JPanel signUpUpperPart;
    
    private JLabel backgroundImage;
    
    public LandingPage(AppWindow appWindow)
    {
        super(appWindow);
        double widthRatio = window.getWidth()/1280.0;
        double heightRatio = window.getHeight()/720.0;
        // Signing In Components
        
        ImageIcon uImage  = new ImageIcon(getClass().getResource("/carrentingapp/testimg/signInUpperImage.png")); 
        upperImage = new JLabel();
        upperImage.setBounds((int) (widthRatio*460), (int) (heightRatio*0), (int) (widthRatio*720), (int) (heightRatio*567));
        upperImage.setBackground(AppWindow.EERIE_BLACK);
        upperImage.setIcon(new ImageIcon(uImage.getImage().getScaledInstance(upperImage.getWidth(), upperImage.getHeight(), Image.SCALE_DEFAULT)));
        
        welcomeText = new JLabel();
        welcomeText.setFont(new java.awt.Font("Arial", 1, 36)); 
        welcomeText.setForeground(Color.WHITE);
        welcomeText.setText("Welcome Back !");
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setBounds((int) (widthRatio*142), (int) (heightRatio*132), (int) (widthRatio*276), (int) (heightRatio*44));
        
        Email = new AppTextField("Email", (int) (widthRatio*138), (int) (heightRatio*236),(int) (widthRatio*283), (int) (heightRatio*37));
        /*
                        Email.setFont(new java.awt.Font("Arial", 0, 16)); 
                        Email.setForeground(AppWindow.CARROT_ORANGE);
                        Email.setText("Email");
                        Email.setBounds((int) (widthRatio*138), (int) (heightRatio*236),(int) (widthRatio*283), (int) (heightRatio*37));
                        */
        
        Password = new AppPasswordField("Password", (int) (widthRatio*138), (int) (heightRatio*293), (int) (widthRatio*283), (int) (heightRatio*37));
        /*
                        Password.setFont(new java.awt.Font("Arial", 0, 16)); 
                        Password.setForeground(AppWindow.CARROT_ORANGE);
                        Password.setText("Password");
                        Password.setBounds((int) (widthRatio*138), (int) (heightRatio*293), (int) (widthRatio*283), (int) (heightRatio*37));
                        */
        
        signIn = new JButton();
        signIn.setBackground(AppWindow.CARROT_ORANGE);
        signIn.setFont(new java.awt.Font("Arial", 1, 20)); 
        signIn.setForeground(Color.WHITE);
        signIn.setText("Sign In");
        signIn.setBounds((int) (widthRatio*138), (int) (heightRatio*379), (int) (widthRatio*283), (int) (heightRatio*37));
        
        optionText = new JLabel();
        optionText.setText("Don't have an acount ?");
        optionText.setHorizontalAlignment(JLabel.CENTER);
        optionText.setFont(new Font("Arial", 1, 20));
        optionText.setForeground(Color.WHITE);
        optionText.setBounds((int) (widthRatio*529), (int) (heightRatio*577), (int) (widthRatio*222), (int) (heightRatio*24));
        
        toSignUp = new JButton();
        toSignUp.setBackground(AppWindow.CARROT_ORANGE);
        toSignUp.setFont(new java.awt.Font("Arial", 1, 16)); 
        toSignUp.setForeground(Color.WHITE);
        toSignUp.setText("Sign Up");
        toSignUp.setBounds((int) (widthRatio*565), (int) (heightRatio*611), (int) (widthRatio*150), (int) (heightRatio*24));
        toSignUp.addActionListener((ActionEvent evt) -> {
            welcomeText.setVisible(false);
            Email.setVisible(false);
            Password.setVisible(false);
            signIn.setVisible(false);
            optionText.setVisible(false);
            toSignUp.setVisible(false);
            upperImage.setVisible(false);
            upperPart.setVisible(false);
            
            signUpUpperImage.setVisible(true);
            signUpWelcomeText.setVisible(true);
            firstName.setVisible(true);
            lastName.setVisible(true);
            signUpEmail.setVisible(true);
            signUpPassword.setVisible(true);
            driverLicense.setVisible(true);
            toLoginOptionText.setVisible(true);
            toLogIn.setVisible(true);
            signUp.setVisible(true);
            signUpUpperPart.setVisible(true);
        });
        
        upperPart = new JPanel();
        upperPart.setBackground(AppWindow.EERIE_BLACK);
        upperPart.setBounds((int) (widthRatio*100), (int) (heightRatio*0), (int) (widthRatio*360), (int) (heightRatio*567));
        
        // Signing Up components
        
        ImageIcon signUpUImage  = new ImageIcon(getClass().getResource("/carrentingapp/testimg/signUpUpperImage.png")); 
        signUpUpperImage = new JLabel();
        signUpUpperImage.setBounds((int) (widthRatio*100), (int) (heightRatio*0), (int) (widthRatio*720), (int) (heightRatio*567));
        signUpUpperImage.setBackground(AppWindow.EERIE_BLACK);
        signUpUpperImage.setIcon(new ImageIcon(signUpUImage.getImage().getScaledInstance(signUpUpperImage.getWidth(), signUpUpperImage.getHeight(), Image.SCALE_DEFAULT)));
        
        signUpWelcomeText = new JLabel();
        signUpWelcomeText.setFont(new java.awt.Font("Arial", 1, 48)); 
        signUpWelcomeText.setForeground(Color.WHITE);
        signUpWelcomeText.setText("Welcome !");
        signUpWelcomeText.setHorizontalAlignment(JLabel.CENTER);
        signUpWelcomeText.setBounds((int) (widthRatio*883), (int) (heightRatio*54), (int) (widthRatio*242), (int) (heightRatio*58));
        
        firstName = new AppTextField("First Name", (int) (widthRatio*858), (int) (heightRatio*151),(int) (widthRatio*283), (int) (heightRatio*37)); 
        /*
        firstName.setFont(new java.awt.Font("Arial", 0, 16)); 
        firstName.setForeground(AppWindow.CARROT_ORANGE);
        firstName.setText("First Name");
        firstName.setBounds((int) (widthRatio*858), (int) (heightRatio*151),(int) (widthRatio*283), (int) (heightRatio*37));
        */
        lastName = new AppTextField("Last Name", (int) (widthRatio*858), (int) (heightRatio*208),(int) (widthRatio*283), (int) (heightRatio*37));
        /*
        lastName.setFont(new java.awt.Font("Arial", 0, 16)); 
        lastName.setForeground(AppWindow.CARROT_ORANGE);
        lastName.setText("Last Name");
        lastName.setBounds((int) (widthRatio*858), (int) (heightRatio*208),(int) (widthRatio*283), (int) (heightRatio*37));
        */
        signUpEmail = new AppTextField("Email", (int) (widthRatio*858), (int) (heightRatio*264),(int) (widthRatio*283), (int) (heightRatio*37)); 
        /*
        signUpEmail.setFont(new java.awt.Font("Arial", 0, 16)); 
        signUpEmail.setForeground(AppWindow.CARROT_ORANGE);
        signUpEmail.setText("Email");
        signUpEmail.setBounds((int) (widthRatio*858), (int) (heightRatio*264),(int) (widthRatio*283), (int) (heightRatio*37));
        */
        signUpPassword = new AppPasswordField("Password", (int) (widthRatio*858), (int) (heightRatio*321), (int) (widthRatio*283), (int) (heightRatio*37));
        /*
        signUpPassword.setFont(new java.awt.Font("Arial", 0, 16)); 
        signUpPassword.setForeground(AppWindow.CARROT_ORANGE);
        signUpPassword.setText("Password");
        signUpPassword.setBounds((int) (widthRatio*858), (int) (heightRatio*321), (int) (widthRatio*283), (int) (heightRatio*37));
        */
        driverLicense = new AppTextField("Driver License Number", (int) (widthRatio*858), (int) (heightRatio*378),(int) (widthRatio*283), (int) (heightRatio*37)); 
        /*
        driverLicense.setFont(new java.awt.Font("Arial", 0, 16)); 
        driverLicense.setForeground(AppWindow.CARROT_ORANGE);
        driverLicense.setText("Driver License Number");
        driverLicense.setBounds((int) (widthRatio*858), (int) (heightRatio*378),(int) (widthRatio*283), (int) (heightRatio*37));
        */
        signUp = new JButton();
        signUp.setBackground(AppWindow.CARROT_ORANGE);
        signUp.setFont(new java.awt.Font("Arial", 1, 20)); 
        signUp.setForeground(Color.WHITE);
        signUp.setText("Sign Up");
        signUp.setBounds((int) (widthRatio*858), (int) (heightRatio*450), (int) (widthRatio*283), (int) (heightRatio*37));
        signUp.addActionListener((ActionEvent evt) -> {
            try { 
            String tempEmail = signUpEmail.getText();
            String tempPassword = AppWindow.toHash(signUpPassword.getText());
            String tempFirstName = firstName.getText();
            String tempLastName = lastName.getText();
            DriverLicense tempDriverLicense = new DriverLicense(driverLicense.getText());
            User tempUser = new User(tempEmail, tempPassword, tempFirstName, tempLastName, tempDriverLicense);
            tempUser.addToDB();
            window.page.removeFromLayeredPane();
            window.page.setVisible(false);
            window.user = tempUser;
            window.page = new HomePage(window);
            window.page.addToLayeredPane();
            window.page.setVisible(true);
            window.getLayeredPane().setVisible(false);
            window.getLayeredPane().setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        });
        
        toLoginOptionText = new JLabel();
        toLoginOptionText.setText("Already got an acount ?");
        toLoginOptionText.setFont(new Font("Arial", 1, 20));
        toLoginOptionText.setForeground(Color.WHITE);
        toLoginOptionText.setHorizontalAlignment(JLabel.CENTER);
        toLoginOptionText.setBounds((int) (widthRatio*525), (int) (heightRatio*577), (int) (widthRatio*231), (int) (heightRatio*24));
        
        toLogIn = new JButton();
        toLogIn.setBackground(AppWindow.CARROT_ORANGE);
        toLogIn.setFont(new java.awt.Font("Arial", 1, 16)); 
        toLogIn.setForeground(Color.WHITE);
        toLogIn.setText("Log In");
        toLogIn.setBounds((int) (widthRatio*565), (int) (heightRatio*611), (int) (widthRatio*150), (int) (heightRatio*24));
        toLogIn.addActionListener((ActionEvent evt) -> {
            welcomeText.setVisible(true);
            Email.setVisible(true);
            Password.setVisible(true);
            signIn.setVisible(true);
            optionText.setVisible(true);
            toSignUp.setVisible(true);
            upperImage.setVisible(true);
            upperPart.setVisible(true);
            
            signUpUpperImage.setVisible(false);
            signUpWelcomeText.setVisible(false);
            firstName.setVisible(false);
            lastName.setVisible(false);
            signUpEmail.setVisible(false);
            signUpPassword.setVisible(false);
            driverLicense.setVisible(false);
            toLoginOptionText.setVisible(false);
            toLogIn.setVisible(false);
            signUp.setVisible(false);
            signUpUpperPart.setVisible(false);
        });
        
        signUpUpperPart = new JPanel();
        signUpUpperPart.setBackground(AppWindow.EERIE_BLACK);
        signUpUpperPart.setBounds((int) (widthRatio*821), (int) (heightRatio*0), (int) (widthRatio*360), (int) (heightRatio*567));
        
        ImageIcon bImage  = new ImageIcon(getClass().getResource("/carrentingapp/testimg/Rework_goneho9589_Paris_landscape_high_resolution_8b5e126f-33cd-4337-b2d4-65d10764978f.png")); 
        backgroundImage = new JLabel();
        backgroundImage.setBounds(0, 0, window.getWidth(), window.getHeight());
        backgroundImage.setIcon(new ImageIcon(bImage.getImage().getScaledInstance(backgroundImage.getWidth(), backgroundImage.getHeight(), Image.SCALE_DEFAULT)));
        
        // Set default display to Sign In
        
        signUpUpperImage.setVisible(false);
        signUpWelcomeText.setVisible(false);
        firstName.setVisible(false);
        lastName.setVisible(false);
        signUpEmail.setVisible(false);
        signUpPassword.setVisible(false);
        driverLicense.setVisible(false);
        toLoginOptionText.setVisible(false);
        toLogIn.setVisible(false);
        signUp.setVisible(false);
        signUpUpperPart.setVisible(false);
    }
    
    public void addToLayeredPane(JLayeredPane layeredPane)
    {
        layeredPane.add(welcomeText);
        layeredPane.add(Email);
        layeredPane.add(Password);
        layeredPane.add(signIn);
        layeredPane.add(optionText);
        layeredPane.add(toSignUp);
        layeredPane.add(upperImage);
        layeredPane.add(upperPart);
        
        layeredPane.add(signUpUpperImage);
        layeredPane.add(signUpWelcomeText);
        layeredPane.add(firstName);
        layeredPane.add(lastName);
        layeredPane.add(signUpEmail);
        layeredPane.add(signUpPassword);
        layeredPane.add(driverLicense);
        layeredPane.add(toLoginOptionText);
        layeredPane.add(toLogIn);
        layeredPane.add(signUp);
        layeredPane.add(signUpUpperPart);
        
        layeredPane.add(backgroundImage);
    }

    @Override
    public void addToLayeredPane() {
        JLayeredPane layeredPane = window.getLayeredPane();
        layeredPane.add(welcomeText);
        layeredPane.add(Email);
        layeredPane.add(Password);
        layeredPane.add(signIn);
        layeredPane.add(optionText);
        layeredPane.add(toSignUp);
        layeredPane.add(upperImage);
        layeredPane.add(upperPart);
        
        layeredPane.add(signUpUpperImage);
        layeredPane.add(signUpWelcomeText);
        layeredPane.add(firstName);
        layeredPane.add(lastName);
        layeredPane.add(signUpEmail);
        layeredPane.add(signUpPassword);
        layeredPane.add(driverLicense);
        layeredPane.add(toLoginOptionText);
        layeredPane.add(toLogIn);
        layeredPane.add(signUp);
        layeredPane.add(signUpUpperPart);
        
        layeredPane.add(backgroundImage);
    }

    @Override
    public void removeFromLayeredPane() {
        JLayeredPane layeredPane = window.getLayeredPane();
        layeredPane.remove(welcomeText);
        layeredPane.remove(Email);
        layeredPane.remove(Password);
        layeredPane.remove(signIn);
        layeredPane.remove(optionText);
        layeredPane.remove(toSignUp);
        layeredPane.remove(upperImage);
        layeredPane.remove(upperPart);
        
        layeredPane.remove(signUpUpperImage);
        layeredPane.remove(signUpWelcomeText);
        layeredPane.remove(firstName);
        layeredPane.remove(lastName);
        layeredPane.remove(signUpEmail);
        layeredPane.remove(signUpPassword);
        layeredPane.remove(driverLicense);
        layeredPane.remove(toLoginOptionText);
        layeredPane.remove(toLogIn);
        layeredPane.remove(signUp);
        layeredPane.remove(signUpUpperPart);
        
        layeredPane.remove(backgroundImage);
    }

    @Override
    public void setVisible(boolean visible) {
        welcomeText.setVisible(visible);
        Email.setVisible(visible);
        Password.setVisible(visible);
        signIn.setVisible(visible);
        optionText.setVisible(visible);
        toSignUp.setVisible(visible);
        upperImage.setVisible(visible);
        upperPart.setVisible(visible);
        signUpUpperImage.setVisible(visible);
        signUpWelcomeText.setVisible(visible);
        firstName.setVisible(visible);
        lastName.setVisible(visible);
        signUpEmail.setVisible(visible);
        signUpPassword.setVisible(visible);
        driverLicense.setVisible(visible);
        toLoginOptionText.setVisible(visible);
        toLogIn.setVisible(visible);
        signUp.setVisible(visible);
        signUpUpperPart.setVisible(visible);
        
        backgroundImage.setVisible(visible);
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