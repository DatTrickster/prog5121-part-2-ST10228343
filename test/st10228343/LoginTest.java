/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10228343;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;



/**
 *
 * @author Extinction
 */
public class LoginTest {
 
    
    // Task 1
String taskName1 = "Login Feature";
String taskDescription1 = "Create Login to authenticate users";
String developerDetails1 = "Robyn Harrison";
int taskDuration1 = 8;

String taskStatus1 = "To Do";

// Task 2
String taskName2 = "Add Task Feature";
String taskDescription2 = "Create Add Task feature to add task users";
String developerDetails2 = "Mike Smith";
int taskDuration2 = 10;
String taskStatus2 = "Doing";
    

@Test    
public void TaskDescriptionCheckerFailed() {
    
    String description = "Create Login to authenticate users";
    int characterLimit = 50;

    if (description.length() <= characterLimit) {
        assertEquals(true, true); // Test passes if description length is within the limit
    } else {
        fail("Description length exceeds the character limit of 50 characters.");
    }
}


@Test
public void testCreateTaskID() {
    String taskName = "Login Feature";
    String description = "Create Login to authenticate users";
    String time = "8hrs";
    String status = "To Do";
    String devName = "Robyn Harrison";
    String taskNumber = "2";

    String expectedTaskID = taskName.substring(0, 2) + ":" + taskNumber + ":" + devName.substring(0, 3);

    String actualTaskID = taskName.substring(0, 2) + ":" + taskNumber + ":" + devName.substring(0, 3);

    assertTrue(actualTaskID.equals(expectedTaskID));
    System.out.println(actualTaskID);
}

    // unit test for total duration of the loop 
 
       @Test // test for task 1 and 2 = 18hours total
    public void testLastIterationOfLoop() {
        int numTasks = 2;
        int[] durations = {10, 8,};

        int expectedLastIteration = 18;
        int actualLastIteration = getLastIterationOfLoop(numTasks, durations);

        assertEquals(expectedLastIteration, actualLastIteration);
    }

    @Test // test for 5 task in an array 
    public void testTotalDuration() {
        int[] durations = {10, 12, 55, 11, 1};

        int expectedTotalDuration = 89;
        int actualTotalDuration = calculateTotalDuration(durations);

        assertEquals(expectedTotalDuration, actualTotalDuration);
    }

    private int getLastIterationOfLoop(int numTasks, int[] durations) {
        int lastIteration = 0;
        int startIndex = durations.length - numTasks;
        for (int i = startIndex; i < durations.length; i++) {
            lastIteration += durations[i];
        }
        return lastIteration;
    }

    private int calculateTotalDuration(int[] durations) {
        int totalDuration = 0;
        for (int duration : durations) {
            totalDuration += duration;
        }
        return totalDuration;
    }


      @Test
    public void TaskDescriptionCheckerSuccess() {
        String description = "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv";
        // this contains 50 characters of dummy text
        int characterLimit = 50;
        //will heck if the amount is <= to 50 which is the limit an output true 
        assertEquals(true, description.length() <= characterLimit);
    }

@Test    
public void TaskDescriptionChecker() {
    String description = "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv";
    int characterLimit = 50;

    assertEquals(true, description.length() > characterLimit); 


    System.out.println("Description length exceeds the character limit of 50 characters."
    +"\n"+"the amount of v was = "+description.length()
    );
}
       

    
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



 
