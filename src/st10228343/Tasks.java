/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Tasks {
    
    public String descrio;
    
    public static void entry() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        List<Person> userList = new ArrayList<>();
        boolean endProgram = false;

        while (!endProgram) {
            Object[] options = {"Add task", "Show report", "Quit"};

            int choice = JOptionPane.showOptionDialog(null,
                    "Select an option" + "\n" + "\n1. Add task" + "\n2. Show report" + "\n3. Quit",
                    "Option Panel",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0: {
                    System.out.println("Option 1 selected");
                    String taskNumStr;
                    while (true) {
                        taskNumStr = JOptionPane.showInputDialog("How many tasks would you like (enter a numeric value)");

                        if (taskNumStr == null) {
                            System.out.println("Cancel button clicked. Going back to the main menu.");
                            entry();
                            break;
                        }

                        if (taskNumStr.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Task number cannot be blank.");
                            continue;
                        }

                        // Check if the input is a valid numeric value
                        if (taskNumStr.matches("\\d+")) {
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value for the task number.");
                        }
                    }

                    int taskNum = Integer.parseInt(taskNumStr);

                    for (int i = 0; i < taskNum; i++) {

                        String developerName = JOptionPane.showInputDialog("Development name (format: Firstname Lastname)");

                        if (developerName == null) {
                            System.out.println("Cancel button clicked. Going back to the main menu.");
                            entry();
                            break;
                        }

                        if (developerName.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Developer name cannot be blank.");
                            i--; // Decrement i to repeat the current iteration
                            continue;
                        }

                        String[] nameParts = developerName.split(" ");
                        if (nameParts.length < 2) {
                            JOptionPane.showMessageDialog(null, "Invalid input format. Please enter the full name (firstname lastname).");
                            i--; // Decrement i to repeat the current iteration
                            continue;
                        }

                        String firstName = nameParts[0];
                        String lastName = nameParts[nameParts.length - 1];

                        if (lastName.length() <= 4) {
                            JOptionPane.showMessageDialog(null, "Surname should have more than 4 characters.");
                            i--; // Decrement i to repeat the current iteration
                            continue;
                        }

                        String taskName = JOptionPane.showInputDialog("Task name");

                        // Check if task name is blank or null
                        if (taskName == null) {
                            System.out.println("Cancel button clicked. Going back to the main menu.");
                            entry();
                            break;
                        }
                        if (taskName.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Task name cannot be blank.");
                            i--; // Decrement i to repeat the current iteration
                            continue;
                        }

                        String description;
                        while (true) {
                            description = JOptionPane.showInputDialog("Task description");
                            if (description == null) {
                                System.out.println("Cancel button clicked. Going back to the main menu.");
                                entry();
                                break;
                            }

                            if (checkTaskDescription(description)) {
                                break;
                            }
                        }

                        String time;
                        while (true) {
                            time = JOptionPane.showInputDialog("Time in minutes (enter a numeric value)");
                            if (time == null) {
                                System.out.println("Cancel button clicked. Going back to the main menu.");
                                entry();
                                break;
                            }
                            if (time.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Time cannot be blank.");
                                continue;
                            }

                            // Check if the input is a valid numeric value
                            if (time.matches("\\d+")) {
                                double convertedTime = Double.parseDouble(time) / 60;
                                time = String.valueOf(convertedTime);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value for time.");
                            }
                        }

                        Object[] statusOptions = {"Done", "Doing", "To Do"};
                        int statusChoice = JOptionPane.showOptionDialog(
                                null,
                                "Select the status for the task",
                                "Status",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                statusOptions,
                                statusOptions[0]
                        );

                        String status;

                        switch (statusChoice) {
                            case 0:
                                status = "Done";
                                break;
                            case 1:
                                status = "Doing";
                                break;
                            case 2:
                                status = "To Do";
                                break;
                            default:
                                status = "To Do";
                                break;
                        }
                        Person user = new Person(taskName, description, time, status, developerName);
                        userList.add(user);
                        System.out.println(userList);
                    }

                    // Display the ArrayList
                    StringBuilder displayer = new StringBuilder();
                    double totalTime = 0;
                    int index = 1; // Counter variable for array index
                    for (Person user : userList) {
                        displayer.append("Task Number: ").append(index).append("\n"); // Display the array index
                        displayer.append("Task ID: ").append(user.getID()).append("\n");
                        displayer.append("Task Name: ").append(user.getTaskName()).append("\n");
                        displayer.append("Description: ").append(user.getDescription()).append("\n");
                        displayer.append("Time Allocation (Hours): ").append(user.getTime()).append("\n");
                        displayer.append("Status: ").append(user.getStatus()).append("\n");
                        displayer.append("---------------------------\n");

                        totalTime += Double.parseDouble(user.getTime());
                        index++; // Increment the array index
                    }
                    displayer.append("Total Time: ").append(totalTime).append(" Hours");
                    JOptionPane.showMessageDialog(null, displayer.toString());
                    continue;
                }

                case 1: {
                    System.out.println("report currently in development");
                    JOptionPane.showMessageDialog(null, "Feature still in development");
                    continue;
                }
                case 2: {
                    System.out.println("program was ended");
                    endProgram = true;
                    System.out.println(endProgram);
                    System.exit(0);
                }
                default:
                    System.out.println("No option selected");
            }
        }
    }

    public static boolean checkTaskDescription(String description) {
        // Check if task description is blank or null
        if (description.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Task description cannot be blank.");
            return false;
        }

        if (description.length() > 50) {
            JOptionPane.showMessageDialog(null, "EXCEEDED number of characters allowed limit is 50");
            return false;
        } else {
            System.out.println("in range of 50");
            return true;
        }
    }
}

class Person {
    private String taskName;
    private String description;
    private String time;
    private String status;
    private String devName;

    public Person(String taskName, String description, String time, String status, String devName) {
        this.taskName = taskName;
        this.description = description;
        this.time = time;
        this.status = status;
        this.devName = devName;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    private static int currentTaskNumber = 0;

    // Other class members and methods...

    public String getID() {
        int taskNumber = currentTaskNumber++;
        String taskNamePrefix = taskName.substring(0, Math.min(taskName.length(), 2));

        // Extract the surname from the developer's full name
        String[] fullNameParts = devName.split(" ");
        String developerSurname = "";
        if (fullNameParts.length > 1) {
            String surname = fullNameParts[fullNameParts.length - 1];
            developerSurname = surname.substring(Math.max(surname.length() - 3, 0));
        }

        StringBuilder displayer = new StringBuilder();
        displayer.append(taskNamePrefix).append(":").append(taskNumber).append(":").append(developerSurname);
        return displayer.toString();
    }

    public String getStatus() {
        return status;
    }

    public String getDevName() {
        return devName;
    }
}
