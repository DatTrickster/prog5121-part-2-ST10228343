/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343;

import java.util.regex.*;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Extinction
 */
public class Login {
       
    public String name,surname,password,username;





    public void setName(String Name) {
        //JUST sets the name
        name = JOptionPane.showInputDialog(null, "enter name");
       if (name.isBlank()) {
            // if the button is pressed an field is empty will loop back an display warning 
            JOptionPane.showMessageDialog(null, "Its Blank");
             setName(name);
        }
         else{
           Name=name;
         // will be trigged if name is inputted 
          System.out.println("name caputured successfully");
           System.out.println(getName());
         }
    }   
    public void setSurname(){
        //justs sets the surname
        surname = JOptionPane.showInputDialog(null, "enter surname");
        if (surname.isBlank()) {
               JOptionPane.showMessageDialog(null, "Its Blank");
               setSurname();
               
        }
         else{
          // will be trigged if Surname is inputted 
             System.out.println("surname captured successfully");
             
             
             
         }
     
    }
    public boolean setUsername(String Username) {
  
        Username = JOptionPane.showInputDialog(null, "Set Username");
        if (Username.length() >= 5 && Username.contains("_")) {
            System.out.println("Username accepted is working as expected: " + Username);
            username=Username;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username is less than 5 or missing _");
            setUsername(Username);
            return false;
        }
    
}  
    public boolean setPassword(String Password) {
        
               String SpecialChars = "^(?=.*[a-z])(?=."
                       + "*[A-Z])(?=.*\\d)"
                       + "(?=.*[-+_!@#$%^&*., ?]).+$";
 
        // Compile the Special ChARACTERS!!!
        
        Pattern p = Pattern.compile(SpecialChars);

     
      
        
        Password = JOptionPane.showInputDialog(null, "Set password");
        
        // check the string contains the characters
           Matcher m = p.matcher(Password);
           
 //checks if the password is more than 8 characters an that its contains special characters and numerics values
        
//PASSWORD PASSWORD.LENGTH()>=8 AND CATERS FOR STRING 
          if (Password.length()>=8 && m.matches() ) {
             System.out.println("password accepted: "+Password);
             password=Password;
             return true;
             
        }
         else{
              
           JOptionPane.showMessageDialog(null,"too short or missing characters"+
                     "\n"
                     + " password should contain numbers ,upper and lowercase and special characters  ");
             
               setPassword(Password);
               return false;
           
         }
        
    }
    public void confirm(String USER, String PASS){
        
              
       
  
                  JTextField user = new JTextField(10);
    JTextField Password = new JTextField(10);
    
    JPanel Confirm = new JPanel();
 Confirm.add(new JLabel("Username"));
    Confirm.add(user);
    Confirm.add(new JLabel("Password"));
    Confirm.add(Password);
    Confirm.add(Box.createHorizontalStrut(30)); // a spacer
   // main layout for j field text Password and username 
  
    
    int result = JOptionPane.showConfirmDialog(null, Confirm,
        "enter your username and password", JOptionPane.OK_CANCEL_OPTION);
    // send user to re-enter the username and password 
    
    if (result == JOptionPane.OK_OPTION) {
        
     USER = user.getText();
    PASS = Password.getText();
    // the user input that is need for validation
    // check if password and username match in order to display final results
    
     if(  USER.equals(username) && PASS.equals(password)){
       
          
           JOptionPane.showMessageDialog(null,"welcome "+  username);
           
           JOptionPane.showMessageDialog(null,
                   "RESULTS"+"\n"+
          "................................................................."+"\n"
                   +
                     "Name:"+ name + "\n"+
                     "Surname: "+surname +"\n"+
                      "Username: "+username+"\n"+
                      "Password: "+password +"\n"
           
           
           
           
           
           );
     
          
      }
     else{
         // if either username or password incorrect this will loop back to allow user to try again 
            JOptionPane.showMessageDialog(null,"password or username incorrect");
             confirm(USER, PASS);
           }
     
    }
    else{
        
        // if the cancel button was pressed will end the program
        System.out.println("cancelled");
    }
    }
    
    public String getName() {
        // gets the name values
        return name;
    }

    public String getSurname() {
        //gets the surname values
        return surname;
    }

    public String getPassword() {
        // gets the password values
        return password;
    }

    public String getUsername() {
        // gets the username values
        return username;
    }


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
                case 0 -> {
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

                        String developerName = JOptionPane.showInputDialog("Development name");

                        if (developerName == null) {
                             System.out.println("Cancel button clicked. Going back to the main menu.");
                            entry();
                            break;
                        }
                            if (developerName.matches(".*\\d.*")) {
                             JOptionPane.showMessageDialog(null, "Invalid input. Numeric values are not allowed.");
                        }
                        if(developerName.isEmpty()){
                          JOptionPane.showMessageDialog(null, "Developer name cannot be blank.");
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
                        if (taskName.isEmpty()){
                         JOptionPane.showMessageDialog(null, "Task name cannot be blank.");
                            i--; // Decrement i to repeat the current iteration
                            continue;
                        }

                        String taskDescription = JOptionPane.showInputDialog("Description");

                        // Check if task description is blank or null
                        if (taskDescription == null) {
                                System.out.println("Cancel button clicked. Going back to the main menu.");
                            entry();
                            break;
                        }
                        if(taskDescription.isEmpty()){
                              JOptionPane.showMessageDialog(null, "Task description cannot be blank.");
                            i--; // Decrement i to repeat the current iteration
                            continue;
                        }
                              if(taskDescription.length()>50){
                              JOptionPane.showMessageDialog(null, "EXCEEDED number of characters allowed limit is 50");
                            i--; // Decrement i to repeat the current iteration
                            continue;
                        }

                        String time;
                        while (true) {
                            time = JOptionPane.showInputDialog("Time in minutes (enter a numeric value)");
                            if (time==null){
                            
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
                        int statusChoice = JOptionPane.showOptionDialog(null,
                                "Selet the status for the task",
                                "Status",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                statusOptions,
                                statusOptions[0]);

                        String status = switch (statusChoice) {
                            case 0 -> "Done";
                            case 1 -> "Doing";
                            case 2 -> "To Do";
                            default -> "To Do";
                        };

                        Person user = new Person(taskName, taskDescription, time, status, developerName);
                        userList.add(user);
                        System.out.println(userList);
                    }

                    // Display the ArrayList
                    StringBuilder Displayer = new StringBuilder();
                    double totalTime = 0;
                    int index = 1; // Counter variable for array index
                    for (Person user : userList) {
                        Displayer.append("Task Number: ").append(index).append("\n"); // Display the array index
                        Displayer.append("Task ID: ").append(user.getID()).append("\n");
                        Displayer.append("Task Name: ").append(user.getTaskName()).append("\n");
                        Displayer.append("Description: ").append(user.getDescription()).append("\n");
                        Displayer.append("Time Allocation (Hours): ").append(user.getTime()).append("\n");
                        Displayer.append("Status: ").append(user.getStatus()).append("\n");
                        Displayer.append("---------------------------\n");

                        totalTime += Double.parseDouble(user.getTime());
                        index++; // Increment the array index
                    }
                    Displayer.append("Total Time: ").append(totalTime).append(" Hours");
                    JOptionPane.showMessageDialog(null, Displayer.toString());
                }

                case 1 -> {
                    System.out.println("report currently in development");
                    JOptionPane.showMessageDialog(null, "Feature still in development");
                }
                case 2 -> {
                    System.out.println("program was ended");
                    endProgram = true;
                    System.out.println(endProgram);
                    System.exit(0);
                }
                default -> System.out.println("No option selected");
            }
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

    public String getID() {
        Random random = new Random();
        int taskNumber = random.nextInt(999);
        String taskNamePrefix = taskName.substring(0, Math.min(taskName.length(), 2));
        String developerSuffix = devName.substring(Math.max(devName.length() - 3, 0));
        StringBuilder displayer = new StringBuilder();
        displayer.append(taskNamePrefix).append(":").append(taskNumber).append(":").append(developerSuffix);
        return displayer.toString();
    }

    public String getStatus() {
        return status;
    }

    public String getDevName() {
        return devName;
    }
}
