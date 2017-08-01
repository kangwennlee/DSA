package Application;

import java.util.Scanner;
import Driver.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kangwenn
 */
public class security_system {

    /**
     * @param args the command line arguments
     */
    //For menu / module
    static Scanner scan = new Scanner(System.in);
    static boolean repeatMenu = true;
    static boolean repeatOption = true;
    //Create Driver
    static UserList userList = new UserList();
    static EmergencyService emergencyService = new EmergencyService();
    static TaskAssignment taskAssignment = new TaskAssignment();

    public static void main(String[] args) {
        // TODO code application logic here
        initializeUser();
        initializeEmergency();

        while (repeatMenu == true) {
            repeatOption = true;
            printLine();
            switch (mainMenu()) {
                case 1:
                    while (repeatOption == true) {
                        userModule();
                    }
                    break;
                case 2:
                    while (repeatOption == true) {
                        emergencyModule();
                    }
                    break;
                case 3:
                    while (repeatOption == true) {
                        taskModule();
                    }
                    break;
                case 4:
                    while (repeatOption == true) {
                        reportModule();
                    }
                    break;
                case 5:
                    repeatMenu = false;
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
                    break;
            }
        }

    }

    public static int mainMenu() {
        System.out.println("Welcome to TARUC security management program!");
        System.out.println("Please select the following module:");
        System.out.print("1. Maintain user and guard\n2. Maintain emergency service\n3. Maintain task assignment\n4. Reporting features\n5. Quit the program\n");
        System.out.print("Enter your choice: ");
        return scan.nextInt();
    }

    public static void userModule() {
        String name, contactNo, workID;
        int choice;
        printLine();
        System.out.print("Please select the following option:");
        System.out.print("\n1. Add User\n2. Print List of users\n3. Delete User\n4. Add Guard\n5. Print List of Guards\n6. Delete Guard\n7. Return to main menu");
        System.out.print("\nEnter your choice: ");
        switch (scan.nextInt()) {
            case 1:
                scan.nextLine();
                System.out.println("Please enter the following details:");
                System.out.print("User Name: ");
                name = scan.nextLine();
                System.out.print("User Contact Number: ");
                contactNo = scan.nextLine();
                if(userList.addUser(name, contactNo))
                    System.out.println("User " + name + "added!");
                else
                    System.out.println("User existed in the list!");
                break;
            case 2:
                scan.nextLine();
                 System.out.print(userList.printUserList());
                break;
            case 3:
                scan.nextLine();
                 System.out.print(userList.printUserList());
                System.out.print("Which user do you want to delete? (number): ");
                choice= scan.nextInt();
                if(userList.removeUser(choice)==true){
                    System.out.println("User Successfully deleted!");
                    System.out.print(userList.printUserList());
                }                    
                break;
            case 4:
                scan.nextLine();
                System.out.println("Please enter the following details:");
                System.out.print("Guard Name: ");
                name = scan.nextLine();
                System.out.print("Guard Contact Number: ");
                contactNo = scan.nextLine();
                System.out.print("Guard Work ID: ");
                workID = scan.nextLine();
                if(userList.addGuard(name, contactNo,workID))
                    System.out.println("Guard " + name + "added!");
                else
                    System.out.println("Guard existed in the list!");
                break;
            case 5:
                scan.nextLine();
                System.out.print(userList.printGuardList());
                break;
            case 6:
                scan.nextLine();
                System.out.print(userList.printGuardList());
                System.out.print("Which gaurd you do you want to delete? (number): ");
                choice = scan.nextInt();
                if(userList.removeGuard(choice)==true){
                    System.out.println("Guard Successfully deleted!");
                    System.out.print(userList.printGuardList());
                }
                break;
            case 7:
                repeatOption = false;
                break;
            default:
                System.out.println("Invalid number. Please try again.");
        }
    }

    public static void initializeUser() {
        userList.addUser("Lee Kang Wenn", "017-2205785");
        userList.addUser("Chan Peck Hui", "014-6589215");
        userList.addUser("Yang Poh Yee", "016-1389874");
        userList.addUser("Derrick Liew", "016-9413787");
        userList.addUser("Loh Kai Xuan", "016-5721234");
        //
        userList.addGuard("Andy Lim", "012-8092220", "1607165");
        userList.addGuard("Harry Lee", "014-6967064", "1308521");
        userList.addGuard("Thomson Lam", "013-7549981", "1568431");
        userList.addGuard("Aaron Lum", "019-4895166", "1048645");
        userList.addGuard("Boston Lom", "017-6465032", "1200104");
    }

    public static void initializeEmergency(){
        emergencyService.addEmergency(userList.getUserByName("Yang Poh Yee"), 1, "Bangunan Tan Siew Sin");
        emergencyService.addEmergency(userList.getUserByName("Chan Peck Hui"), 2, "Block D");
        emergencyService.addEmergency(userList.getUserByName("Derrick Liew"), 4, "Block K");
        emergencyService.addTools("Fire Extinguisher", "Put off fire");
        emergencyService.addTools("First Aid Kit", "Material needed for first aid");
    }

    public static void emergencyModule() {
        printLine();
        String name;
        User victim = null;
        String toolName, toolUsage;

        System.out.print("Please select the following option:");
        System.out.print("\n1. Add emergency alert\n2. Remove emergency alert\n3. Add tools\n4. Remove tools\n5. Add emergency contact\n6. Remove emergency contact\n7. Return to main menu");
        System.out.print("\nEnter your choice: ");
        switch (scan.nextInt()) {
            case 1:
                scan.nextLine();
                do {
                    System.out.print("User name: ");
                    name = scan.nextLine();
                    if (userList.getUserByName(name) == null) {
                        System.out.println("This user does not exist, please re-enter another name.");
                    }
                } while (userList.getUserByName(name) == null);
                victim = userList.getUserByName(name);

                int typeOfEmergency = 0;
                do {
                    System.out.print("Type of emergency: \n");
                    System.out.print("1. Suicide case\n2. Fainting\n3. Food poisoning\n4. Figthing\n5. Missing items\n6. Argument");
                    System.out.print("\nEnter selection: ");
                    typeOfEmergency = scan.nextInt();
                    if (typeOfEmergency < 1 || typeOfEmergency > 6) {
                        System.out.println("selection must be an integer number between 1-6");
                    }
                } while (typeOfEmergency < 1 || typeOfEmergency > 6);

                System.out.print("Current location: ");
                scan.nextLine();
                String location = scan.nextLine();
                emergencyService.addEmergency(victim, typeOfEmergency, location);
                System.out.println("Emergency Added!");
                emergencyService.printEmergencyQueue();
                break;
            case 2:
                scan.nextLine();
                do {
                    System.out.print("User name: ");
                    name = scan.nextLine();
                    if (userList.getUserByName(name) == null) {
                        System.out.println("This user does not exist, please re-enter another name.");
                    }
                } while (userList.getUserByName(name) == null);
                victim = userList.getUserByName(name);
                Emergency emergency = emergencyService.getEmergencyByUser(victim);
                emergencyService.removeEmergency(emergency);
                emergencyService.printEmergencyQueue();
                break;
            case 3:
                scan.nextLine();
                System.out.print("Tool name: ");
                toolName = scan.nextLine();
                System.out.print("Tool usages: ");
                toolUsage = scan.nextLine();
                emergencyService.addTools(toolName, toolUsage);
                emergencyService.printToolList();
                break;
            case 4:
                scan.nextLine();
                int ans;
                emergencyService.printToolList();
                System.out.print("Which tool do you want to delete?: ");
                ans = scan.nextInt();
                emergencyService.removeTools(ans);
                emergencyService.printToolList();
                break;
            case 5:
                System.out.print("Please enter user's name: ");
                scan.nextLine();
                break;
            case 6:

                break;
            case 7:
                repeatOption = false;
                break;
            default:
                System.out.println("Invalid number. Please try again.");
                break;
        }

    }

    public static void taskModule() {
        printLine();
        System.out.println("Please select the following option");
        System.out.println("1. Assign Task to Guard \n2. Update Task Status \n3. Print Pending Task \n4. Print Completed Task \n5. Clear Completed Task \n6. Return to Main Menu");
        System.out.print("Enter your choice: ");
        switch (scan.nextInt()) {
            case 1: //assign task to guard
                scan.nextLine();

                emergencyService.printEmergencyQueue();
                System.out.print("Enter Victim's Name: ");
                Emergency emergencyCase = emergencyService.getEmergencyByUser(userList.getUserByName(scan.nextLine()));

                userList.printGuardList();
                System.out.println("You should choose the not busy guard.");
                System.out.print("Enter Guard's Name: ");
                Guard guard = userList.getGuardByName(scan.nextLine());

                emergencyService.printToolList();
                System.out.print("Enter the tools used: ");
                Tools tools = emergencyService.getToolByName(scan.nextLine());

                taskAssignment.addTask(emergencyCase, guard, tools);
                System.out.println("Task added to the guard!");
                break;

            case 2: //update Task Status
                scan.nextLine();
               // System.out.println("Is this task completed? ");
               // System.out.println("If yes. please choose 1. \nIf no, please choose 2.");
               // switch(scan.nextInt()){
               //     case 1:
                        taskAssignment.updateTaskStatus();
               //     break;
                 //   case 2:
                   //     break;
                //}
                break;

            case 3:  //Print Pending Task
                scan.nextLine();
               // System.out.println("Do you want to print current pending task? ");
               // System.out.println("If yes. please choose 1. \nIf no, please choose 2.");
               // switch(scan.nextInt()){
               //     case 1:
                        taskAssignment.printPendingTask();
               //     break;
               //     case 2:
               //         break;
               // }
                break;

            case 4:  //Print Completed Task
                scan.nextLine();
              //  System.out.println("Do you want to print completed task? ");
               // System.out.println("If yes. please choose 1. \nIf no, please choose 2.");
               // switch(scan.nextInt()){
               //     case 1:
                        taskAssignment.printCompletedTaskList();
               //     break;
               //     case 2:
               //         break;
                //}
                break;

            case 5: //Clear Completed Task
                scan.nextLine();
            //    System.out.println("Do you want to clear completed task list? ");
            //    System.out.println("If yes. please choose 1. \nIf no, please choose 2.");
            //    switch(scan.nextInt()){
            //        case 1:
                        taskAssignment.clearCompletedTask();
            //        break;
             //       case 2:
               //         break;
               // }
                break;
            case 6:
                repeatOption = false;
                break;
            default:
                System.out.println("Invalid number. Please try again.");

        }

    }

    public static void reportModule() {
        printLine();
        System.out.print("Please select the following option:");
        System.out.print("\n1. Print List of Users\n2. Print List of Guards\n3. Print Emergency Queue");
        System.out.print("\nEnter your choice: ");
        switch (scan.nextInt()) {
            case 1:
                userList.printUserList();
                break;
            case 2:
                userList.printGuardList();
                break;
            case 3:

        }
    }

    public static void printLine() {
        System.out.println("");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

}
