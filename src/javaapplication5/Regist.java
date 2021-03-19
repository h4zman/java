// LIGN 65 & 68 & 71 INSERT PATH

package javaapplication5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Regist{


     public JButton delete = new JButton("Delete"); // 3 buttons
     public JButton register = new JButton("Register");
     public JButton back = new JButton();
     public CheckDB inDB; //TO CHANGE
     
    public JTextField nameField = new JTextField(""); //champs a remplir
    public JTextField mNoField = new JTextField(""); //champs a remplir
    public JPasswordField passField = new JPasswordField(""); //champs a remplir
    public JPasswordField pass2Field = new JPasswordField(""); //champs a remplir
    
    public String nameT; //data after entered in the fields
    public String mNoT;
    public char[] passT;
    public char[] pass2T;
    
    
    public JLabel alreadyRegistered = new JLabel("<html><body>It seems you already registered.<br/> Try to log in with this Matric No</html></body>");
    public JLabel registration = new JLabel("Registration");
    public JLabel name = new JLabel("Name : ");
    public JLabel mNo = new JLabel("Matric Number : ");
    public JLabel password = new JLabel("Password : ");
    public JLabel password2 = new JLabel("Repeat password : "); 
    public JLabel blank = new JLabel(""); // to help for the layout
    
    public Font police = new Font("Tahoma", Font.BOLD, 20);     
    public Color color = new Color(110,11,22);
    public JOptionPane jop2 = new JOptionPane(); //Message
    
    boolean passSame = false; //If passwords (pass & repeated pass) are equals
    
    public JPanel top = new JPanel();
    public JPanel center = new JPanel();
    public JPanel south = new JPanel(); 
    public JPanel container = new JPanel(); 
    public JPanel buttons = new JPanel(); 
     
    public Regist(){         
        ImageIcon icon = new ImageIcon(new ImageIcon("C:\\Users\\Hazman\\Desktop\\JavaApplication5\\src\\javaapplication5\\arrow.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        back.setIcon(icon);
        
        ImageIcon del = new ImageIcon(new ImageIcon("C:\\Users\\Hazman\\Desktop\\JavaApplication5\\src\\javaapplication5\\cross.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        delete.setIcon(del);
        
        ImageIcon reg = new ImageIcon(new ImageIcon("C:\\Users\\Hazman\\Desktop\\JavaApplication5\\src\\javaapplication5\\registr.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        register.setIcon(reg);
        
        registration.setForeground(color);
        registration.setFont(police);
        registration.setHorizontalAlignment(JLabel.CENTER);
        top.setLayout(new BorderLayout());
        JPanel b = new JPanel();
        b.add(back);
        top.add(b, BorderLayout.WEST);
        JPanel e = new JPanel();
        e.add(blank);
        blank.setPreferredSize(new Dimension(45,30));
        top.add(e, BorderLayout.EAST);
        back.setPreferredSize(new Dimension(45,30));
        back.setLocation(0,0);
        registration.setLocation(45,30);
        top.setPreferredSize(new Dimension(340,50));
        top.add(registration);
        center.setLayout(new GridLayout(15,1));
        center.add(name);
        center.add(nameField);
        center.add(mNo);
        center.add(mNoField);
        center.add(password);
        center.add(passField);
        center.add(password2);
        center.add(pass2Field);
        name.setHorizontalAlignment(JLabel.CENTER);
        password.setHorizontalAlignment(JLabel.CENTER);
        mNo.setHorizontalAlignment(JLabel.CENTER);
        password2.setHorizontalAlignment(JLabel.CENTER);
        buttons.setPreferredSize(new Dimension(340,50));
        buttons.add(register);       
        buttons.add(delete);

        south.add(buttons);
        container.setLayout(new BorderLayout());
        container.add(south, BorderLayout.SOUTH);
        container.add(top, BorderLayout.NORTH);
        container.add(center, BorderLayout.CENTER);
        
        
                            
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(arg0.getSource() == delete){
                    System.out.println("bouton delete");
                    nameField.setText("");
                    mNoField.setText("");
                    passField.setText("");
                    pass2Field.setText("");
                }
            }
        });
         
     }
     public boolean setPassSame(boolean passSame){
         this.passSame = passSame;
         return passSame;
     }
    
    
     public JPanel regPan(){
         return container;
     }
     
//     public void passFields(String name, String maNo, char[] pass, char[] pass2){
//         if("".equals(nameField.getText()) || "".equals(mNoField.getText()) || "".equals(passField.getPassword()) || "".equals(pass2Field.getPassword())){ //If one of the fields empty
//    
//            jop2.showMessageDialog(null, "Please fill all the fields", "Empty fields", JOptionPane.WARNING_MESSAGE); //message
//        }
//        else if(!(pass2.length == pass.length)){ //if pw not same length
//                jop2.showMessageDialog(null, "Your passwords must be the same", "Different passwords", JOptionPane.WARNING_MESSAGE); //Show message
//        }
//
//        else if((pass2.length == pass.length)){ //if pw  same length
//            int count = 0; //counter of right char
//            for(int i = 0;i<passT.length;i++){ //check for the whole length, if char are the same
//                if (pass[i] == pass2[i]) // check char for pw
//                    count++; 
//              }//END FOR
//            if (!(count == pass.length)){  //if not all char are equals --> wrong pw
//                jop2.showMessageDialog(null, "Your passwords must be the same", "Different passwords", JOptionPane.WARNING_MESSAGE); //Show message
//            }
//         
//     }
//   }

    
}
