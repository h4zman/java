
package javaapplication5;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class CheckDB {
    DataB bdd = new DataB(); // DataBase parameters
    Connection conn = null;
    
    String insert; //to communicate with database
    boolean success = false; // true if the registration or the log in succeeded
    
    
    public CheckDB(String name, String mNo, char[] password) { //used for registration
      try{ // try the connection

            conn = DriverManager.getConnection(DataB.CONN_STRING, DataB.USERNAME, DataB.PASSWORD); //Connection
            System.out.println("Connect !");
                    
            insert = "INSERT INTO project.student(name, matric_id, password) VALUES ('"+name+"', '"+mNo+"', '"+conChartoString(password)+"')"; //insert new value
            Statement stmt = (Statement) conn.createStatement();
            //prest= "SELECT * FROM student WHERE name='Yannus'";
            stmt.executeUpdate(insert);
            success = true; //
            
    }catch (SQLException ex) {          // If Matric number already exists
        System.out.println("It seems you already registered. Try to log in with this Matric No");
        //r.center.add(r.alreadyRegistered);
        success = false;
      }
    }
    
    
    public CheckDB(String username, char[] password){ //used for log in
        try {
            
            conn = DriverManager.getConnection(DataB.CONN_STRING, DataB.USERNAME, DataB.PASSWORD); //Connection
            
            Statement stmt = (Statement) conn.createStatement();
            String pass = conChartoString(password);
            
            ResultSet result = stmt.executeQuery("SELECT * FROM student WHERE Stu_id='"+username+"' AND password='"+pass+"'");

            System.out.println("Username entered : "+username);
            System.out.println("password entered : "+pass);
            System.out.println(""); //jump ligne
            
            
            while(result.next()){
                System.out.println("\n\n"+result.getString(1)+result.getString(2)+result.getString(3));  //print name, ma_No & password
                if (result.getString(1).equals(username) && result.getString(3).equals(pass)){ //if ma_No & password corresponds to something in the database
                    System.out.println("GOOD");
                    this.success = true; //access allowed
                }
              };
            
            
        } catch (SQLException ex) { //if does not connect
            Logger.getLogger(CheckDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CRASH !");
            this.success = false;
        }
                    
    }
    
    public boolean getSuccess(){ 
        return success;
    }
    
    public static String conChartoString(char[] charArray){ 
                            
            String wordString = "";  
            String c;
            for(int i=0;i < charArray.length;i++){  //Cast password to String
                c = String.valueOf(charArray[i]);
                wordString = wordString + c;
            }
        System.out.println(wordString);
        return wordString;
    }
    
}
