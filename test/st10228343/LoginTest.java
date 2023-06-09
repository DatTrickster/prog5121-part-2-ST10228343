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

        Person person = new Person(taskName, description, time, status, devName);

        String expectedTaskID = "Lo:0:son";
        String actualTaskID = person.getTaskID();

        assertEquals(expectedTaskID, actualTaskID);
    }

    @Test
    public void testLastIterationOfLoop() {
        int numTasks = 2;
        int[] durations = {10, 8};

        int expectedLastIteration = 18;
        int actualLastIteration = getLastIterationOfLoop(numTasks, durations);

        assertEquals(expectedLastIteration, actualLastIteration);
    }

    @Test
    public void testTotalDuration() {
        int[] durations = {10, 12, 55, 11, 1};

        int expectedTotalDuration = 89;
        int actualTotalDuration = calculateTotalDuration(durations);

        assertEquals(expectedTotalDuration, actualTotalDuration);
    }

    @Test
    public void TaskDescriptionCheckerSuccess() {
        String description = "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv";
        int characterLimit = 50;

        assertEquals(true, description.length() <= characterLimit);
    }

    @Test
    public void TaskDescriptionChecker() {
        String description = "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv";
        int characterLimit = 50;

        assertEquals(true, description.length() > characterLimit);

        System.out.println("Description length exceeds the character limit of 50 characters."
                + "\n" + "the amount of v was = " + description.length());
    }

    @Test
    public void testValidUsername() {
        String UserName = "kyl_1";

        boolean UsernameValidation;

        UsernameValidation = UserName.contains("_") && UserName.length() <= 5;

        assertTrue(UsernameValidation);
    }

    @Test
    public void testINValidUsername() {

        String UserName = "KylieJones";

        boolean UsernameValidation;

        UsernameValidation = UserName.contains("_") && UserName.length() <= 5;

        assertFalse(UsernameValidation);
    }

    @Test
    public void testUserNameFormatMessage() {
        String UserName = "KylieJones";

        boolean UsernameValidation;

        UsernameValidation = UserName.contains("_") && UserName.length() <= 5;

        assertFalse(UsernameValidation);

        if (!UsernameValidation) {
            System.out.println("Invalid Username Format");
        }
    }

    @Test
    public void testUserPasswordFormatMessage() {
        String password = "pass123";

        boolean PasswordValidation;

        PasswordValidation = password.length() > 6 && password.length() <= 12;

        assertTrue(PasswordValidation);

        if (!PasswordValidation) {
            System.out.println("Invalid Password Format");
        }
    }

    @Test
    public void testSetPasswordValid() {
        String password = "pass123";

        boolean PasswordValidation;

        PasswordValidation = password.length() > 6 && password.length() <= 12;

        assertTrue(PasswordValidation);
    }

    @Test
    public void testSetPasswordInvalid() {
        String password = "pass";

        boolean PasswordValidation;

        PasswordValidation = password.length() > 6 && password.length() <= 12;

        assertFalse(PasswordValidation);
    }

    @Test
    public void testLoginUserisValid() {
        String username = "kylie_1";
        String password = "pass123";

        boolean isValidUser = validateUser(username, password);

        assertTrue(isValidUser);
    }

    @Test
    public void testLoginUserisInvalid() {
        String username = "kylie_1";
        String password = "pass";

        boolean isValidUser = validateUser(username, password);

        assertFalse(isValidUser);
    }

    public class Person {
        private String taskID;

        public Person(String taskName, String description, String time, String status, String devName) {
            this.taskID = generateTaskID(taskName, description, time, status, devName);
        }

        public String getTaskID() {
            return taskID;
        }

        private String generateTaskID(String taskName, String description, String time, String status, String devName) {
            String taskID = "";

            // Generate task ID based on the provided information
            String[] taskNameSplit = taskName.split(" ");
            StringBuilder initials = new StringBuilder();

            for (String namePart : taskNameSplit) {
                initials.append(namePart.charAt(0));
            }

            String[] developerNameSplit = devName.split(" ");
            StringBuilder devInitials = new StringBuilder();

            for (String namePart : developerNameSplit) {
                devInitials.append(namePart.charAt(0));
            }

            taskID = initials.toString() + ":" + time.length() + ":" + devInitials.toString();

            return taskID;
        }
    }

    public int getLastIterationOfLoop(int numTasks, int[] durations) {
        int lastIteration = 0;

        for (int i = 0; i < numTasks; i++) {
            lastIteration += durations[i];
        }

        return lastIteration;
    }

    public int calculateTotalDuration(int[] durations) {
        int totalDuration = 0;

        for (int duration : durations) {
            totalDuration += duration;
        }

        return totalDuration;
    }

    public boolean validateUser(String username, String password) {
        String usernameRegex = "^[a-zA-Z0-9_]+$";
        String passwordRegex = "^[a-zA-Z0-9@#$%^&+=]+$";

        Pattern usernamePattern = Pattern.compile(usernameRegex);
        Pattern passwordPattern = Pattern.compile(passwordRegex);

        Matcher usernameMatcher = usernamePattern.matcher(username);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        return usernameMatcher.matches() && passwordMatcher.matches();
    }
}


 
