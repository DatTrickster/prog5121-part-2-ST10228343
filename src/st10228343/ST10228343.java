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
        
        
        
             Login methods = new Login();
             Tasks task=new Tasks();
        String name=methods.name;
      
        //this method is used to run the other methods 
     methods.setName(name);
     methods.setSurname();
     String username=methods.getUsername();
     methods.setUsername(username);
     String password=methods.getPassword();
     methods.setPassword(password);
     methods.confirm(username, password);
      task.entry();
       
    }
    
    
    public static void main(String[] args) {
    
  
            String[] options = { "YES", "NO",};
            // gives the option of yes or no to make an account or not if yes then process will start if no then the program will end
    var selection = JOptionPane.showOptionDialog(null, "would you like to create an account ?","", 
                                                      0, 2, null, options, options[0]);
    if (selection == 0) {
        start();
    }
    if (selection == 1) { 
      JOptionPane.showMessageDialog(null, "Good bye");
    }

   
     
    }  
 
    
}


