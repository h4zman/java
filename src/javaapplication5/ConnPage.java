// LIGN 53 & 56 INSERT PATH

package javaapplication5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class ConnPage {   
    
    
    public JButton LogIn = new JButton("Log In"); // 2 buttons
    public JButton register = new JButton("Register");
    Color colorButton = new Color(110,11,20);
    public Panneau pan = new Panneau();

    public JPanel container = new JPanel();
    JPanel top = new JPanel();
    JPanel center = new JPanel();
    JPanel south = new JPanel(); 
    
    public JLabel Connexion = new JLabel("Connexion");
    public JLabel connNow = new JLabel("You can connect now.");
    public JLabel username = new JLabel("Username / Matric Number : ");
    public JLabel password = new JLabel("Password : ");
    public JLabel title = new JLabel("UPM Classroom Locator");  
    public JLabel info = new JLabel("<html><body>If you already have an account, please log in.<br/>Otherwise, please register</body></html>");
    public JLabel wrong = new JLabel("Invalid Matric Number or password  ");
    public JLabel fillFields = new JLabel("Please fill all the fields");
    
    public JTextField mNo = new JTextField(""); //champs a remplir
    public JPasswordField pass = new JPasswordField(""); //champs a remplir
    public JComboBox combo = new JComboBox();
    Font police = new Font("Tahoma", Font.BOLD, 20);
    Font policeTitle = new Font("Tahoma", Font.BOLD, 25);
    
    public ConnPage(){  
        
        ImageIcon log = new ImageIcon(new ImageIcon("C:\\Users\\Hazman\\Desktop\\JavaApplication5\\src\\javaapplication5\\login.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        LogIn.setIcon(log);
        
        ImageIcon regi = new ImageIcon(new ImageIcon("C:\\Users\\inesd\\OneDrive\\Documents\\M1\\Advanced_Programming\\registr.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        register.setIcon(regi);
        
            //TOP
        title.setFont(policeTitle);
        title.setForeground(colorButton);
        Connexion.setFont(police);
        Connexion.setForeground(Color.blue);
        top.add(title);
        top.add(Connexion);
        top.setPreferredSize(new Dimension(70,90));
            //SOUTH
        LogIn.setForeground(colorButton);
        register.setForeground(colorButton);
        LogIn.setBackground(new Color(239,239,239));
        register.setBackground(new Color(239,239,239));
        south.setPreferredSize(new Dimension(50,50));
        south.add(LogIn);
        south.add(register);
            //CENTER
        center.setLayout(new GridLayout(9,1, 10,12));
        mNo.setPreferredSize(new Dimension(150, 30));
        username.setPreferredSize(new Dimension(20,20));
        mNo.setPreferredSize(new Dimension(20,20));
        password.setPreferredSize(new Dimension(20,20));
        pass.setPreferredSize(new Dimension(20,20));
        username.setHorizontalAlignment(JLabel.CENTER);
        password.setHorizontalAlignment(JLabel.CENTER);
        center.add(username);
        center.add(mNo);
        center.add(password);
        center.add(pass);
        center.setMinimumSize(new Dimension (200,200));
        center.add(info);
        
            //WHOLE WINDOW
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        
        container.add(top, BorderLayout.NORTH);
        container.add(south, BorderLayout.SOUTH);
        container.add(center, BorderLayout.CENTER);
        
    }
    public JPanel connPan(){
        return container;
    }
    
}
