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
    
     /**
     * Constructs a Person object with the specified task details.
     *
     * taskName    The name of the task.
     * description The description of the task.
     * time        The time required for the task.
     * status      The status of the task.
     * devName     The name of the developer assigned to the task.
     */
    
    
    
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

    
     /**
     Retrieves the name of the task.
     @return The task name.
     */
    
    
    public String getTaskName() {
        return taskName;
    }
    /**
     Retrieves the description of the task. 
      @return The task description.
     */
    public String getDescription() {
        return description;
    }
    
     //Retrieves the time required for the task.

    public String getTime() {
        return time;
    }

    private static int currentTaskNumber = 0;

    // Other class members and methods...

    public String getID() {
        
        
        /**
Generates and returns the unique task ID.
 The task ID in the format "XX:Y:ZZZ",
        where XX is the first two characters of the task name,
        Y is the current task number,
        and ZZZ is the last three characters of the developer's surname.
     */
        
        
        
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
    
  //Retrieves the status of the task assigned.
    
    public String getStatus() {
        return status;
    }

        //Retrieves the name of the developer assigned to the task.
    public String getDevName() {
        return devName;
    }
}
