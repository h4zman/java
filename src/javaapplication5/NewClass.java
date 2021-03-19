package javaapplication5;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NewClass  extends JFrame implements ActionListener{
    
    
    public Panneau pan = new Panneau();
    
    JButton back = new JButton();
    int length = pan.length;
    int width = pan.width;
    
    ConnPage cp = new ConnPage(); //object type ConnPage
    JPanel connPage = cp.connPan(); //Layout of connection page
    
    Regist r = new Regist(); //object type Regist
    JPanel registerPage = r.regPan(); // Layout of registration page
    
    JPanel loginPage = new JPanel(); //optional
    
      
    public NewClass(){   
        ImageIcon icon = new ImageIcon(new ImageIcon("C:\\Users\\Hazman\\Desktop\\JavaApplication5\\src\\javaapplication5\\arrow.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        
        back.setIcon(icon);
            //Window parameters    
        this.setTitle("Animation");  //How is the window
        this.setSize(width, length);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    
        JLabel connected = new JLabel("You connected successfully"); // For the page after login successfull
        loginPage.add(back);
        loginPage.add(connected);
        
                
        this.setContentPane(connPage); // main page is connection page
        this.setVisible(true); 
        back.addActionListener(this);
        
        r.back.addActionListener(this);     // buttons used in this class
        r.register.addActionListener(this);
        cp.LogIn.addActionListener(this);
        cp.register.addActionListener(this);

    }
    
    
    @Override
    public void actionPerformed(ActionEvent arg0) { // What the buttons do
        
  if(arg0.getSource() == cp.LogIn){             //"log in" in main page
        System.out.println("bouton login");
        
        String name = cp.mNo.getText();
        char[] password = cp.pass.getPassword();
        
        CheckDB log = new CheckDB(name, password);
        if (log.success){   //if good password & matric number
            this.setContentPane(this.loginPage); // access the website
            log.success = false;
        }
        else if (name.equals("") || "".equals(CheckDB.conChartoString(password))){   //if good password & matric number
            removePan();
            cp.center.add(cp.fillFields);
            log.success = false;
        }
        else{ //if not, print it is wrong
            removePan();
            cp.center.add(cp.wrong);
        }
        System.out.println(log.success);
        this.revalidate();
        this.repaint();
  }
  if(arg0.getSource() == cp.register){  //"register" in main page
        System.out.println("bouton register");
        r.nameField.setText("");  //Put all fields empty
        r.mNoField.setText("");
        r.passField.setText("");
        r.pass2Field.setText("");
        this.setContentPane(this.registerPage);
        this.revalidate();
       }
  
  if(arg0.getSource() == back || arg0.getSource() == r.back){ //"back" --> go to the main page
        System.out.println("bouton back");
        this.setContentPane(this.connPage);
        this.revalidate();
        cp.mNo.setText("");         // put empty fields 
        cp.pass.setText("");
        removePan();
  }
  if(arg0.getSource() == r.register){ //"register" in registration page
        System.out.println(r.passSame);
        r.nameT = r.nameField.getText(); //put into these datas what entered in the fields
        r.mNoT = r.mNoField.getText();
        r.passT = r.passField.getPassword();
        r.pass2T = r.pass2Field.getPassword();
        removePan();


        if("".equals(r.nameField.getText()) || "".equals(r.mNoField.getText()) || "".equals(CheckDB.conChartoString(r.passT)) || "".equals(CheckDB.conChartoString(r.pass2T))){ //If one of the fields empty
    
            r.jop2.showMessageDialog(null, "Please fill all the fields", "Empty fields", JOptionPane.WARNING_MESSAGE); //message
        }
        else if(!(r.pass2T.length == r.passT.length)){ //if pw not same length
                r.jop2.showMessageDialog(null, "Your passwords must be the same", "Different passwords", JOptionPane.WARNING_MESSAGE); //Show message
        }

        else if((r.pass2T.length == r.passT.length)){ //if pw  same length
            int count = 0; //counter of right char
            for(int i = 0;i<r.passT.length;i++){ //check for the whole length, if char are the same
                if (r.passT[i] == r.pass2T[i]) // check char for pw
                    count++; 
              }//END FOR
            if (!(count == r.passT.length)){  //if not all char are equals --> wrong pw
                r.jop2.showMessageDialog(null, "Your passwords must be the same", "Different passwords", JOptionPane.WARNING_MESSAGE); //Show message
            }
            else { //pw are the same

            CheckDB reg = new CheckDB(r.nameT,r.mNoT, r.passT);  //Check if registration possible (if ma_No not already exists)
            if (reg.getSuccess()){    //data inserted
                r.jop2.showMessageDialog(null, "Successfully Registered", "Registration", JOptionPane.INFORMATION_MESSAGE); //show message
                cp.mNo.setText(r.mNoField.getText());
                removePan();
                cp.center.add(cp.connNow);
              //cp.pass.setPassword(r.passField.getPassword());
              
            }
            else{  //data not inserted --> maNo already exists
                cp.mNo.setText(r.mNoField.getText());
                cp.center.add(r.alreadyRegistered);
            }
            r.nameField.setText("");
            r.mNoField.setText("");
            r.passField.setText("");
            r.pass2Field.setText("");
            System.out.println(reg.getSuccess());
            System.out.println("Back after registration");
            this.setContentPane(this.connPage);
            this.revalidate();
          }
            
       }
    }//END BUTTON FUNCTION
    
    }
    
    public void removePan(){
        cp.center.remove(cp.fillFields);
        cp.center.remove(cp.wrong);
        cp.center.remove(r.alreadyRegistered);
        cp.center.remove(cp.connNow);
        
    }

}
