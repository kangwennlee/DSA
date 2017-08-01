/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import ADT.*;

/**
 *
 * @author kangw
 */
public class UserList {

    SortedListInterface<Guard> listG = new SortedLinkList<>();
    SortedListInterface<User> listU = new SortedLinkList<>();

    //addUser, removeUser, printUserDetail, printUserList, getUserByName
    //addGuard, removeGuard, printGuardDetail, printGuardList, getGuardByName
    public void addUser(String name, String contactNo) {
        User user = getUserByName(name);
        if (user == null) {
            User newUser = new User(name, contactNo);
            listU.add(newUser);
        } else {
            System.out.println("User existed in the list!");
        }
    }

    public void removeUser(int position) {
        listU.remove(position);
    }

    public void printUserList() {
        System.out.print("List of users:\nNo.\tName\t\tContact Number\n");
        for (int i = 1; i <= listU.getLength(); i++) {
            System.out.print(i + ".\t" + listU.getEntry(i).name + "\t" + listU.getEntry(i).contactNo + "\n");
        }
    }

    public User getUserByName(String name) {
        for (int i = 1; i <= listU.getLength(); i++) {
            if (listU.getEntry(i).name.equals(name)) {
                return listU.getEntry(i);
            }
        }
        return null;
    }

    public void addGuard(String name, String contactNo, String workID) {
        Guard guard = getGuardByName(name);
        if (guard == null) {
            Guard newGuard = new Guard(name, contactNo, workID);
            listG.add(newGuard);
        } else {
            System.out.println("Guard existed in the list!");
        }
    }

    public void removeGuard(int position) {
        listG.remove(position);
    }

    public void printGuardList() {
        System.out.print("List of users:\nNo.\tName\t\tContact Number\tStaff ID\tBusy?\n");
        for (int i = 1; i <= listG.getLength(); i++) {
            System.out.print(i + ".\t" 
                    + listG.getEntry(i).name 
                    + "\t" + listG.getEntry(i).contactNo 
                    + "\t" + listG.getEntry(i).workID 
                    + "\t\t" + listG.getEntry(i).busy
                    + "\n");
        }
    }

    public Guard getGuardByName(String name) {
        for (int i = 1; i <= listG.getLength(); i++) {
            if (listG.getEntry(i).name.equals(name)) {
                return listG.getEntry(i);
            }
        }
        return null;
    }

}
