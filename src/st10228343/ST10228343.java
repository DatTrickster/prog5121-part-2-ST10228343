/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package st10228343;

import javax.swing.JOptionPane;

/**
 *
 * @author Extinction
 */
public class ST10228343 {

   
   // START method contains all function to be launched
    
    public static void start() {
        
        //this method is used to run the other methods 
     Login methods = new Login(); 
       // input method for name
     methods.setName();
       // input method for surname
     methods.setSurname();
       //input method for username
     String username=methods.getUsername();
     methods.setUsername(username);
       //input method for password
     String password=methods.getPassword();
      methods.setPassword(password);
       // final results method were user would need to re-enter username and password to view results
      methods.confirm();
    }
    
    // main class 
    public static void main(String[] args) {
         
            String[] options = { "YES", "NO",};
            // gives the option of yes or no to make an account or not if yes then process will start if no then the program will end
    var selection = JOptionPane.showOptionDialog(null, "would you like to create an account ?","", 
                                                      0, 2, null, options, options[0]);
       // triggers the program to run the start method which hold the input methods 
    if (selection == 0) {
        start();
    }
    if (selection == 1) { 
       // happens when "NO" was pressed
      JOptionPane.showMessageDialog(null, "Good bye");
    }

   
     
    }
    
}


