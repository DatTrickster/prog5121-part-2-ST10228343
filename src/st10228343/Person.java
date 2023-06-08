/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343;

/**
 *
 * @author Extinction
 */
public class Person {
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
