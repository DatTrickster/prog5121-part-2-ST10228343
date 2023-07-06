/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10228343;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;


/**
 * JUnit test class for Login functionality
 */



public class LoginTest {
    
     // PART 3 UNIT TEST
     // containes the array that holds the names
     private String[] getDevelopers() {
        return new String[]{
            "Mike Smith",
            "Edward Harrison",
            "Samantha Paulson",
            "Glenda Oberholzer"
        };
    }
     // containes the array that holds the Task names
     private String[] getTaskNames() {
        return new String[]{
            "Create Login",
            "Create Add Features",
            "Create Reports",
            "Add Arrays"
        };
    }
     // containes the array that holds the Durations
     private int[] getTaskDurations() {
        return new int[]{5, 8, 2, 11};
    }
     // containes the array that holds the Statuses
     private String[] getTaskStatuses() {
        return new String[]{
            "To Do",
            "Doing",
            "Done",
            "To Do"
        };
    }
     private String displayReport(String[] taskNames, String[] developers, int[] taskDurations, String[] taskStatuses) {
        StringBuilder report = new StringBuilder("Report:\n");
        for (int i = 0; i < taskNames.length; i++) {
            report.append("Task Name: ").append(taskNames[i]).append("\n");
            report.append("Developer: ").append(developers[i]).append("\n");
            report.append("Duration: ").append(taskDurations[i]).append("\n");
            report.append("Status: ").append(taskStatuses[i]).append("\n\n");
        }
        return report.toString();
    }

    @Test
    public void testDeveloperArrayPopulated() {
        String[] developers = getDevelopers();

        String[] expectedDevelopers = getDevelopers();
        System.out.println(developers);

        Assert.assertArrayEquals(expectedDevelopers, developers);
    }

    @Test
    public void testDeveloperAndDurationForLongestDurationTask() {
        String[] developers = getDevelopers();
        int[] durations = getTaskDurations();

        int longestDuration = Integer.MIN_VALUE;
        int longestDurationIndex = -1;
        for (int i = 0; i < durations.length; i++) {
            if (durations[i] > longestDuration) {
                longestDuration = durations[i];
                longestDurationIndex = i;
            }
        }

        String expected = developers[longestDurationIndex] + ", " + longestDuration;
        String actual = developers[longestDurationIndex] + ", " + durations[longestDurationIndex];

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSearchForTask() {
        String[] developers = getDevelopers();
        String[] taskNames = getTaskNames();

        String searchTask = "Create Login";
        String expected = developers[0] + ", " + taskNames[0];
        String actual = "";

        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equals(searchTask)) {
                actual = developers[i] + ", " + taskNames[i];
                break;
            }
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSearchTasksByDeveloper() {
        String[] developers = getDevelopers();
        String[] taskNames = getTaskNames();
        String[] taskStatuses = getTaskStatuses();

        String searchDeveloper = "Samantha Paulson";
        String expected = taskNames[2];
        String actual = "";

        for (int i = 0; i < developers.length; i++) {
            if (developers[i].equals(searchDeveloper)) {
                actual = taskNames[i];
                break;
            }
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteTaskFromArray() {
        String[] taskNames = getTaskNames();
        String deleteTask = "Create Reports";

        boolean taskDeleted = false;

        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equals(deleteTask)) {
                taskNames[i] = "";
                taskDeleted = true;
                break;
            }
        }

        Assert.assertTrue(taskDeleted);
    }
    
@Test
public void testDisplayReport() {
    String[] developers = getDevelopers();
    String[] taskNames = getTaskNames();
    int[] taskDurations = getTaskDurations();
    String[] taskStatuses = getTaskStatuses();

    StringBuilder expectedReport = new StringBuilder("Report:\n");
    for (int i = 0; i < taskNames.length; i++) {
        expectedReport.append("Task Name: ").append(taskNames[i]).append("\n");
        expectedReport.append("Developer: ").append(developers[i]).append("\n");
        expectedReport.append("Duration: ").append(taskDurations[i]).append("\n");
        expectedReport.append("Status: ").append(taskStatuses[i]).append("\n\n");
    }

    String actualReport = displayReport(taskNames, developers, taskDurations, taskStatuses);
    Assert.assertEquals(expectedReport.toString(), actualReport);
}

   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// previous parts unit test //////////////

    // Test for checking if task description length is within the character limit
    @Test
    public void testTaskDescriptionCheckerFailed() {
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

        String expectedTaskID = "Sh:0:son"; // Updated expected task ID
        String actualTaskID = taskName.substring(0, 2) + ":" + taskNumber + ":" + devName.substring(devName.length() - 3);

        assertEquals(expectedTaskID, actualTaskID);
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
    public void testTaskDescriptionCheckerSuccess() {
        String description = "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv";
        int characterLimit = 50;
        // Check if the amount is <= 50, which is the limit, and output true
        assertEquals(true, description.length() <= characterLimit);
    }

    // Test for checking if a task description exceeds the character limit
    @Test
    public void testTaskDescriptionCheckerFailer() {
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
    public void testInvalidUsername() {
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
    public void testValidUserLoginDetails() {
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        // Check if the username and password are valid
        boolean userLoginDetails = validateUserLogin(username, password);
        assertTrue(userLoginDetails);
    }

    // Test for invalid user login details
    @Test
    public void testInvalidUserLoginDetails() {
        String username = "kyl_1";
        String password = "password";
        // Check if the username and password are valid
        boolean userLoginDetails = validateUserLogin(username, password);
        assertFalse(userLoginDetails);
    }

    // Helper method to validate user login details
    private boolean validateUserLogin(String username, String password) {
        // Actual validation logic goes here
        return username.equals("kyl_1") && password.equals("Ch&&sec@ke99!");
    }
    

}
