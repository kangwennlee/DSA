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
            case 1: //Add User
                scan.nextLine();
                System.out.println("Please enter the following details:");
                System.out.print("User Name: ");
                name = scan.nextLine();
                System.out.print("User Contact Number: ");
                contactNo = scan.nextLine();
                if (userList.addUser(name, contactNo)) {
                    System.out.println("User " + name + " added!");
                } else {
                    System.out.println("User existed in the list!");
                }
                break;
            case 2: //Print List of users
                scan.nextLine();
                System.out.print(userList.printUserList());
                break;
            case 3: //Delete User
                scan.nextLine();
                System.out.print(userList.printUserList());
                System.out.print("Which user do you want to delete? (number): ");
                choice = scan.nextInt();
                if (userList.removeUser(choice) == true) {
                    System.out.println("User Successfully deleted!");
                    System.out.print(userList.printUserList());
                }else{
                    System.out.println("User does not exists in the list!");
                }
                break;
            case 4: //Add Guard
                scan.nextLine();
                System.out.println("Please enter the following details:");
                System.out.print("Guard Name: ");
                name = scan.nextLine();
                System.out.print("Guard Contact Number: ");
                contactNo = scan.nextLine();
                System.out.print("Guard Work ID: ");
                workID = scan.nextLine();
                if (userList.addGuard(name, contactNo, workID)) {
                    System.out.println("Guard " + name + "added!");
                } else {
                    System.out.println("Guard existed in the list!");
                }
                break;
            case 5: //Print List of Guard
                scan.nextLine();
                System.out.print(userList.printGuardList());
                break;
            case 6: //Delete Guard
                scan.nextLine();
                System.out.print(userList.printGuardList());
                System.out.print("Which gaurd you do you want to delete? (number): ");
                choice = scan.nextInt();
                if (userList.removeGuard(choice) == true) {
                    System.out.println("Guard Successfully deleted!");
                    System.out.print(userList.printGuardList());
                }else{
                    System.out.println("Guard does not exists in the list!");
                }
                break;
            case 7: //Return to main menu
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

    public static void initializeEmergency() {
        emergencyService.initialiseTypeOfEmergency();
        emergencyService.addEmergency(userList.getUserByName("Yang Poh Yee"), 1, "CITC");
        emergencyService.addEmergency(userList.getUserByName("Chan Peck Hui"), 2, "Block D");
        emergencyService.addEmergency(userList.getUserByName("Derrick Liew"), 4, "Block K");
        emergencyService.addEmergency(userList.getUserByName("Lee Kang Wenn"), 6, "Block M");
        emergencyService.addEmergency(userList.getUserByName("Shim Hiu Yin"), 3, "Block A");
        emergencyService.addEmergency(userList.getUserByName("Loh Kai Xuan"), 5, "Block L");
        emergencyService.addTools("Stretcher", "Carry person");
        emergencyService.addTools("First Aid Kit", "Material needed for first aid");
        emergencyService.addTools("Rope", "To save people");
        emergencyService.addTools("Tape", "To stick 2 object together");
        emergencyService.addTools("Dehydrate Salt", "To rehydrate");
    }

    public static void emergencyModule() {
        printLine();
        String name;
        User victim = null;
        String toolName, toolUsage;
        int ans;

        System.out.print("Please select the following option:");
        System.out.print("\n1. Add emergency alert\n2. Remove emergency alert\n3. Display Emergency List\n4. Display Victim List\n5. Add tools\n6. Remove tools\n7. Display Tools List\n8. Return to main menu");
        System.out.print("\nEnter your choice: ");
        switch (scan.nextInt()) {
            case 1: //Add Emergency Alert
                scan.nextLine();
                do {
                    System.out.print("User name: ");
                    name = scan.nextLine();
                    if (userList.getUserByName(name) == null) {
                        System.out.println("This user does not exist, please re-enter another name.");
                    }
                } while (userList.getUserByName(name) == null);
                victim = userList.getUserByName(name);
                if (emergencyService.getEmergencyByUser(victim) == null) {
                    int typeOfEmergency;
                    do {
                        emergencyService.printTypeOfEmergencyList();
                        System.out.print("\nEnter selection: ");
                        typeOfEmergency = scan.nextInt();
                        if (typeOfEmergency < 1 || typeOfEmergency > emergencyService.getTypeOfEmergencyListSize()) {
                            System.out.println("selection must be an integer number between 1-6");
                        }
                    } while (typeOfEmergency < 1 || typeOfEmergency > emergencyService.getTypeOfEmergencyListSize());

                    System.out.print("Current location: ");
                    scan.nextLine();
                    String location = scan.nextLine();
                    emergencyService.addEmergency(victim, typeOfEmergency, location);
                    System.out.println("Emergency Added!");
                    printLine();
                    System.out.print(emergencyService.printEmergencyQueue());
                } else {
                    System.out.println("User already has an emergency in the queue!");
                }
                break;
            case 2: //Remove emergency Alert
                scan.nextLine();
                if (emergencyService.getEmergencyQueueSize() <= 0) {
                    System.out.print("There are currently no emergency to be removed");
                    break;
                }

                System.out.print(emergencyService.printEmergencyQueue());
                System.out.print("Which emergency do you want to remove? ");
                ans = scan.nextInt();
                emergencyService.removeEmergency(ans);
                System.out.print(emergencyService.printEmergencyQueue());
                break;
            case 3: //Print emergency Queue
                System.out.print(emergencyService.printEmergencyQueue());
                break;
            case 4: //Print victim list
                System.out.print(emergencyService.printVictimsList());
                break;
            case 5: //Add tool
                scan.nextLine();
                System.out.print("Tool name: ");
                toolName = scan.nextLine();
                System.out.print("Tool usages: ");
                toolUsage = scan.nextLine();
                emergencyService.addTools(toolName, toolUsage);
                System.out.println("Tool Added!");
                System.out.print(emergencyService.printToolList());
                break;
            case 6: //delete tool
                scan.nextLine();
                if (emergencyService.getToolListSize() <= 0) {
                    System.out.print("There are no tools available to be removed");
                    break;
                }
                System.out.print(emergencyService.printToolList());
                System.out.print("Which tool do you want to remove?: ");
                ans = scan.nextInt();
                if (ans <= emergencyService.getToolListSize()) {
                    emergencyService.removeTools(ans);
                    System.out.print(emergencyService.printToolList());
                }
                break;
            case 7: //print tool list
                System.out.print(emergencyService.printToolList());
                break;
            case 8: //return to main menu
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
            case 1:
                scan.nextLine();
                System.out.print(userList.printAvailableGuard());
                System.out.print("Enter guard's choice: ");
                Guard guard = userList.getGuard(scan.nextInt());
                Emergency emergency = emergencyService.retrieveEmergency();
                if (emergency != null) {
                    System.out.println(emergency);
                    System.out.print(emergencyService.printToolList());
                    System.out.print("Please choose the suitable tools to be used: ");
                    int choice = scan.nextInt();
                    Tools tools = emergencyService.getToolByPosition(choice);
                    taskAssignment.addTask(emergency, guard, tools);
                    System.out.println("Task assigned successfully!");
                    taskAssignment.printPendingTask();
                }else{
                    System.out.println("No more task to be assigned!");
                }
                break;
            case 2: // update task status
                scan.nextLine();
                taskAssignment.printPendingTask();
                System.out.print("Please select the task that is completed: ");
                if (taskAssignment.updateTaskStatus(scan.nextInt()) == true) {
                    System.out.println("Update task completed!");
                }
                taskAssignment.printCompletedTaskList();
                break;
            case 3: // print pending task
                scan.nextLine();
                taskAssignment.printPendingTask();
                break;
            case 4: // print completed task
                scan.nextLine();
                taskAssignment.printCompletedTaskList();
                break;
            case 5: // clear completed task
                scan.nextLine();
                taskAssignment.clearCompletedTask();
                System.out.println("Completed Task List is cleared!");
                break;
            case 6: //return to main menu
                scan.nextLine();
                repeatOption = false;
                break;
            default:
                System.out.println("Invalid number. Please try again.");
                break;
        }

    }

    public static void reportModule() {
        printLine();
        System.out.print("Please select the following option:");
        System.out.print("\n1. Print List of Users\n2. Print List of Guards\n3. Print Emergency Queue\n4. Print List of Tools\n5. Print Victim List\n6. Print Completed Task\n7. Print Pending Task\n8. Return to Main Menu");
        System.out.print("\nEnter your choice: ");
        switch (scan.nextInt()) {
            case 1:
                System.out.print(userList.printUserList());
                break;
            case 2:
                System.out.print(userList.printGuardList());
                break;
            case 3:
                System.out.print(emergencyService.printEmergencyQueue());
                break;
            case 4:
                System.out.print(emergencyService.printToolList());
                break;
            case 5:
                System.out.print(emergencyService.printVictimsList());
                break;
            case 6:
                taskAssignment.printCompletedTaskList();
                break;
            case 7:
                taskAssignment.printPendingTask();
                break;
            case 8:
                repeatOption = false;
                break;
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
