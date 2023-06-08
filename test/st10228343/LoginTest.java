/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10228343;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author Extinction
 */
public class LoginTest {
    
 
    
    @Test // tests if username is valid
        public void testValidUsername() {
              String UserName = "kyl_1";
              
           boolean UsernameValidation;
        
           UsernameValidation = UserName.contains("_") && UserName.length() <= 5;
           
        assertTrue(UsernameValidation);
      
    }
      
    @Test // test username it is invalid
      public void testINValidUsername() {
   
          String UserName = "kyle!!!!!!";
          
        boolean UsernameValidation;
        
        UsernameValidation = UserName.contains("_") && UserName.length() <= 5;
           
        assertFalse(UsernameValidation);
      
    }

    @Test //test for password valid
    public void testSetPasswordValid() {
         boolean PasswordValidation; 
        String SpecialChars = "^(?=.*[a-z])(?=."
                       + "*[A-Z])(?=.*\\d)"
                       + "(?=.*[-+_!@#$%^&*., ?]).+$";
 
        // Compile the Special ChARACTERS!!!
        
        Pattern p = Pattern.compile(SpecialChars);

     
      
      
     String   Password = "Ch&&sec@ke99!";
        
        // check the string contains the characters
           Matcher m = p.matcher(Password);
           
        //checks if the password is more than 8 characters an that its contains special characters and numerics values
        PasswordValidation = !(Password.length()>=8 && m.matches());
         assertFalse( PasswordValidation);
        
        
    }
    
    @Test//test for password invalid details
    public void testSetPasswordInvalid() {
         boolean PasswordValidation; 
        String SpecialChars = "^(?=.*[a-z])(?=."
                       + "*[A-Z])(?=.*\\d)"
                       + "(?=.*[-+_!@#$%^&*., ?]).+$";
 
        // Compile the Special ChARACTERS!!!
        
        Pattern p = Pattern.compile(SpecialChars);

     
      
      
     String   Password = "password";
        
        // check the string contains the characters
           Matcher m = p.matcher(Password);
           
        //checks if the password is more than 8 characters an that its contains special characters and numerics values
        PasswordValidation = Password.length()>=8 && m.matches();
        
           assertFalse( PasswordValidation);
        
    }
    
    @Test //Testing for Valid Login Details
    public void testLoginUserisValid() {   
            
        
            boolean userLoginDetails;
                String Username="kyl_1";
            String Password="Ch&&sec@ke99!";
            String enter_Username = "kyl_1";        
            String enter_Password ="Ch&&sec@ke99!";
        
            userLoginDetails = Username.equals(enter_Username) && Password.equals(enter_Password);
        assertTrue(userLoginDetails);
    }
     
    @Test //Testing for Invalid Login Details
    public void testLoginUserisInvalid() {   
            
            String Username="kyl_1";
            String Password="Ch&&sec@ke99!";
            boolean userLoginDetails;
            String enterUsername = "user_12";        
            String enterPassword ="Password123#";
        
            userLoginDetails = Username.equals(enterUsername) && Password.equals(enterPassword);
        assertFalse(userLoginDetails);
    }

    @Test  //Returning a Welcome Message for Valid and Invalid Username
    public void testUserNameFormatMessage() {

        String userFirstName = "Bob";
        String userLastName = "gnome";
        String userNameRegistered = "Use_1";
         String  userNameMessage ;
        boolean userNameBoolean;
        
      
        
        if (userNameRegistered.length() <= 5 && userNameRegistered.contains("_")) {
            userNameMessage = "Welcome " +userFirstName + " " +userLastName +" welcome back.";
            System.out.println(userNameMessage);
            userNameBoolean = true;
    } else {
         
            userNameMessage = "Username is not correctly formatted, please ensure that your username contains an underscore"
                    + "and is no more than 5 characters in length";
            System.out.println(userNameMessage);
            userNameBoolean = false;
        }
                
        assertTrue(userNameBoolean);
    }
    
    @Test //Returning a Welcome Message for Valid and Invalid Password
    public void testUserPasswordFormatMessage() {


        
        String userPasswordMessage;

        String SpecialChars = "^(?=.*[a-z])(?=."
                       + "*[A-Z])(?=.*\\d)"
                       + "(?=.*[-+_!@#$%^&*., ?]).+$";
 
        // Compile the Special ChARACTERS!!!
        
        Pattern p = Pattern.compile(SpecialChars);

     
      
      
     String   Password = "Ch&&sec@ke99!";
        
        // check the string contains the characters
           Matcher m = p.matcher(Password);
           
 //checks if the password is more than 8 characters an that its contains special characters and numerics values
        
          if (Password.length()>=8 && m.matches() ) {
        
     userPasswordMessage = "password captured correctly";
              System.out.println(userPasswordMessage);
        }
         else{
                     // if it is invalid this message will be triggered
                  userPasswordMessage = "Password is not corrextly formatted, please ensure that the password contains at least 8 "
                + "characters, a capital letter, a number and a special character"; 
                  System.out.println(userPasswordMessage);
   
         }     
    } 
    
    
}
