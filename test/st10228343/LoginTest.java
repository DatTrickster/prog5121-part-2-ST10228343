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
 * JUnit test class for Login functionality
 */
public class LoginTest {

    // Task 1
    // Define task details
    String taskName1 = "Login Feature";
    String taskDescription1 = "Create Login to authenticate users";
    String developerDetails1 = "Robyn Harrison";
    int taskDuration1 = 8;
    String taskStatus1 = "To Do";

    // Task 2
    // Define task details
    String taskName2 = "Add Task Feature";
    String taskDescription2 = "Create Add Task feature to add task users";
    String developerDetails2 = "Mike Smith";
    int taskDuration2 = 10;
    String taskStatus2 = "Doing";

    // Test for checking if task description length is within the character limit
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

    // Test for creating task ID in the specified format
    @Test
    public void testCreateTaskID() {
        String taskName = "Show Feature";
        String description = "Create a Show feature";
        String time = "8hrs";
        String status = "To Do";
        String devName = "Robyn Harrison";
        String taskNumber = "0";

        String expectedTaskID = "Lo:0:son";
        String actualTaskID = taskName.substring(0, 2) + ":" + taskNumber + ":" + devName.substring(devName.length() - 3);

        assertTrue(actualTaskID.equals(expectedTaskID));
        System.out.println(actualTaskID);
    }

    // Test for calculating the last iteration of a loop based on number of tasks and durations
    @Test
    public void testLastIterationOfLoop() {
        int numTasks = 2;
        int[] durations = {10, 8};

        int expectedLastIteration = 18;
        int actualLastIteration = getLastIterationOfLoop(numTasks, durations);

        assertEquals(expectedLastIteration, actualLastIteration);
    }

    // Test for calculating the total duration of tasks
    @Test
    public void testTotalDuration() {
        int[] durations = {10, 12, 55, 11, 1};

        int expectedTotalDuration = 89;
        int actualTotalDuration = calculateTotalDuration(durations);

        assertEquals(expectedTotalDuration, actualTotalDuration);
    }

    // Helper method to calculate the last iteration of a loop
    private int getLastIterationOfLoop(int numTasks, int[] durations) {
        int lastIteration = 0;
        int startIndex = durations.length - numTasks;
        for (int i = startIndex; i < durations.length; i++) {
            lastIteration += durations[i];
        }
        return lastIteration;
    }

    // Helper method to calculate the total duration of tasks
    private int calculateTotalDuration(int[] durations) {
        int totalDuration = 0;
        for (int duration : durations) {
            totalDuration += duration;
        }
        return totalDuration;
    }

    // Test for checking if a task description is within the character limit
    @Test
    public void TaskDescriptionCheckerSuccess() {
        String description = "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv";
        // This contains 50 characters of dummy text
        int characterLimit = 50;
        // Check if the amount is <= 50, which is the limit, and output true
        assertEquals(true, description.length() <= characterLimit);
    }

    // Test for checking if a task description exceeds the character limit
    @Test
    public void TaskDescriptionCheckerFailer() {
        String description = "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv";
        int characterLimit = 50;
        // The opposite of the above test, checking if limit is exceeded
        assertEquals(true, description.length() > characterLimit);
        System.out.println("Description length exceeds the character limit of 50 characters.\n"
                + "The amount of 'v' was = " + description.length());
    }

    // Test for validating a username
    @Test
    public void testValidUsername() {
        String userName = "kyl_1";
        boolean usernameValidation;
        // Check if username contains an underscore and is no more than 5 characters
        usernameValidation = userName.contains("_") && userName.length() <= 5;
        assertTrue(usernameValidation);
    }

    // Test for invalid username
    @Test
    public void testINValidUsername() {
        String userName = "kyle!!!!!!";
        boolean usernameValidation;
        // Check if username contains an underscore and is no more than 5 characters
        usernameValidation = userName.contains("_") && userName.length() <= 5;
        assertFalse(usernameValidation);
    }

    // Test for setting a valid password
    @Test
    public void testSetPasswordValid() {
        boolean passwordValidation;
        String specialChars = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*., ?]).+$";
        // Compile the special characters
        Pattern pattern = Pattern.compile(specialChars);
        String password = "Ch&&sec@ke99!";
        // Check if the string contains the required characters
        Matcher matcher = pattern.matcher(password);
        // Check if the password is more than 8 characters and matches the pattern
        passwordValidation = !(password.length() >= 8 && matcher.matches());
        assertFalse(passwordValidation);
    }

    // Test for setting an invalid password
    @Test
    public void testSetPasswordInvalid() {
        boolean passwordValidation;
        String specialChars = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*., ?]).+$";
        // Compile the special characters
        Pattern pattern = Pattern.compile(specialChars);
        String password = "password";
        // Check if the string contains the required characters
        Matcher matcher = pattern.matcher(password);
        // Check if the password is more than 8 characters and matches the pattern
        passwordValidation = password.length() >= 8 && matcher.matches();
        assertFalse(passwordValidation);
    }

    // Test for valid user login details
    @Test
    public void testLoginUserisValid() {
        boolean userLoginDetails;
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        // Check if the username and password are valid
        userLoginDetails = username.equals("kyl_1") && password.equals("Ch&&sec@ke99!");
        assertTrue(userLoginDetails);
    }

    // Test for invalid user login details
    @Test
    public void testLoginUserisInvalid() {
        boolean userLoginDetails;
        String username = "kyl_1";
        String password = "password";
        // Check if the username and password are valid
        userLoginDetails = username.equals("kyl_1") && password.equals("Ch&&sec@ke99!");
        assertFalse(userLoginDetails);
    }
}



 
