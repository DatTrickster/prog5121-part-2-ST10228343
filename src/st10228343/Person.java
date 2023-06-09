/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343;

/**
 *
 * @author Extinction
 */

// main object that stores the information needed to push to arraylist

public class Person {
    private String taskName;
    private String description;
    private String time;
    private String status;
    private String devName;

//constructor used for 5he private variables

    public Person(String taskName, String description, String time, String status, String devName) {
        this.taskName = taskName;
        this.description = description;
        this.time = time;
        this.status = status;
        this.devName = devName;
    }
// returns task name
    public String getTaskName() {
        return taskName;
    }
// returns description
    public String getDescription() {
        return description;
    }
//returns the time 

    public String getTime() {
        return time;
    }
// counter to start incrementing the numbe each time new task is added initial 0
    private static int currentTaskNumber = 0;

    // Other class members and methods...

    public String getID() {
        int taskNumber = currentTaskNumber++;
        String taskNamePrefix = taskName.substring(0, Math.min(taskName.length(), 2));

 // Extract the surname from the developer's full name

//splits the full name of the dev into name and surname used the last 3 lettera of surname to put into id generation methods

        String[] fullNameParts = devName.split(" ");
        String developerSurname = "";
        if (fullNameParts.length > 1) {
            String surname = fullNameParts[fullNameParts.length - 1];
            developerSurname = surname.substring(Math.max(surname.length() - 3, 0));
        }

        StringBuilder displayer = new StringBuilder();
     // builds the format of the strings  displayer.append(taskNamePrefix).append(":").append(taskNumber).append(":").append(developerSurname);
        return displayer.toString();
    }

    public String getStatus() {
// returns the status done doing ToDo
        return status;
    }

// returns the devs name an surname

    public String getDevName() {
        return devName;
    }
}
