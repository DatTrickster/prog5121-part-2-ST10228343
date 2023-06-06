/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343;

import java.util.regex.*;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Extinction
 */
public final class Login {
       
    public String name,surname,password,username;
    

    public String getName() {
        // gets the name values
        return name;
    }

    public String getSurname() {
        //gets the surname values
        return surname;
    }

    public String getPassword() {
        // gets the password values
        return password;
    }

    public String getUsername() {
        // gets the username values
        return username;
    }



    public void setName() {
        //JUST sets the name
        name = JOptionPane.showInputDialog(null, "enter name");
       if (name.isBlank()) {
            // if the button is pressed an field is empty will loop back an display warning 
            JOptionPane.showMessageDialog(null, "Its Blank");
             setName();
        }
         else{
         // will be trigged if name is inputted 
          System.out.println("name caputured successfully");
         }
    }   
    public void setSurname(){
        //justs sets the surname
        surname = JOptionPane.showInputDialog(null, "enter surname");
        if (surname.isBlank()) {
               JOptionPane.showMessageDialog(null, "Its Blank");
               setSurname();
               
        }
         else{
          // will be trigged if Surname is inputted 
             System.out.println("surname captured successfully");
             
             
             
         }
     
    }
    
public boolean setUsername(String Username) {
  
        Username = JOptionPane.showInputDialog(null, "Set Username");
        if (Username.length() >= 5 && Username.contains("_")) {
            System.out.println("Username accepted is working as expected: " + Username);
            username=Username;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username is less than 5 or missing _");
            setUsername(Username);
            return false;
        }
    
}
    
    public boolean setPassword(String Password) {
        
           
           
          // reference user for this code https://stackoverflow.com/questions/8107030/regular-expression-java 
           
               String SpecialChars = "^(?=.*[a-z])(?=."
                       + "*[A-Z])(?=.*\\d)"
                       + "(?=.*[-+_!@#$%^&*., ?]).+$";
 
        // Compile the Special ChARACTERS!!!
        
        Pattern p = Pattern.compile(SpecialChars);

     
      
        
        Password = JOptionPane.showInputDialog(null, "Set password");
        
        // check the string contains the characters
           Matcher m = p.matcher(Password);
           
 //checks if the password is more than 8 characters an that its contains special characters and numerics values
        
//PASSWORD PASSWORD.LENGTH()>=8 AND CATERS FOR STRING 
          if (Password.length()>=8 && m.matches() ) {
             System.out.println("password accepted: "+Password);
             password=Password;
             return true;
             
        }
         else{
              
           JOptionPane.showMessageDialog(null,"too short or missing characters"+
                     "\n"
                     + " password should contain numbers ,upper and lowercase and special characters  ");
             //output when falls an loops back to try again
               setPassword(Password);
               return false;
           
         }
        
    }

    
    public void confirm(){
        
           
       
  
                  JTextField user = new JTextField(10);
    JTextField Password = new JTextField(10);
    // creates the interface objects for username password input fields
    JPanel Confirm = new JPanel();
           //main username input
 Confirm.add(new JLabel("Username"));
    Confirm.add(user);
           // main password input
    Confirm.add(new JLabel("Password"));
    Confirm.add(Password);
    Confirm.add(Box.createHorizontalStrut(30)); // a spacer
   // main layout for j field text Password and username 
  
    
    int result = JOptionPane.showConfirmDialog(null, Confirm,
        "enter your username and password", JOptionPane.OK_CANCEL_OPTION);
    // send user to re-enter the username and password 
    
    if (result == JOptionPane.OK_OPTION) {
        
     String USER = user.getText();
           
    String PASS = Password.getText();
    // the user input that is need for validation
    // check if password and username match in order to display final results
     if(  USER.equals(username) && PASS.equals(password)){
         
           JOptionPane.showMessageDialog(null,"welcome "+  username);
           JOptionPane.showMessageDialog(null,
                   "RESULTS"+"\n"+
          "................................................................."+"\n"
                   +
                     "Name:"+ name + "\n"+
                     "Surname: "+surname +"\n"+
                      "Username: "+username+"\n"+
                      "Password: "+password +"\n"
           
           
           
           
           
           );
     
          
      }
     else{
         // if either username or password incorrect this will loop back to allow user to try again 
            JOptionPane.showMessageDialog(null,"password or username incorrect");
             confirm();
           }
     
    }
    else{
        
        // if the cancel button was pressed will end the program
        System.out.println("cancelled");
    }
    }
}

