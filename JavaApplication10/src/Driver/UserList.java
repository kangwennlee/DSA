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

    //addUser, removeUser, printUserList, getUser, getUserByName
    //addGuard, removeGuard, printGuardList, getGuard, getGuardByName
    public boolean addUser(String name, String contactNo) {
        //Create a new user and add the user into the list
        User user = getUserByName(name);
        if (user == null) {
            User newUser = new User(name, contactNo);
            listU.add(newUser);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeUser(int position) {
        //remove the user from the list based on the position
        return listU.remove(position) != null;
    }

    public boolean updateUserName(User user, String newName) {
        if (user != null) {
            user.name = newName;
            return true;
        } else{
            return false;
        }
    }

    public boolean updateUserContact(User user, String contact) {
        if (user != null) {
            user.contactNo = contact;
            return true;
        } else{
            return false;
        }
    }

    public String printUserList() {
        //Get all the entry from the list and print out all the entry(user)
        String str = "";
        str += "List of users:\nNo.\tName\t\tContact Number\n";
        for (int i = 1; i <= listU.getLength(); i++) {
            str += i + ".\t" + listU.getEntry(i).toString() + "\n";
        }
        return str;
    }

    public User getUser(int choice) {
        //retrive the entry(user) from the list
        return listU.getEntry(choice);
    }

    public User getUserByName(String name) {
        //Searach for the user based on the name given in the list
        for (int i = 1; i <= listU.getLength(); i++) {
            if (listU.getEntry(i).name.equals(name)) {
                return listU.getEntry(i);
            }
        }
        return null;
    }

    public boolean addGuard(String name, String contactNo, String workID) {
        Guard guard = getGuardByName(name);
        if (guard == null) {
            Guard newGuard = new Guard(name, contactNo, workID);
            listG.add(newGuard);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeGuard(int position) {
        return listG.remove(position) != null;
    }

    public String printGuardList() {
        String str = "";
        str += "List of guards:\nNo.\tName\t\tContact Number\tStaff ID\tBusy?\n";
        for (int i = 1; i <= listG.getLength(); i++) {
            str += i + ".\t" + listG.getEntry(i).toString() + "\n";
        }
        return str;
    }

    public String printAvailableGuard() {
        //only print guard with the variable busy equal to false
        String str = "";
        str += "List of users:\nNo.\tName\t\tContact Number\tStaff ID\tBusy?\n";
        for (int i = 1; i <= listG.getLength(); i++) {
            if (listG.getEntry(i).busy == false) {
                str += i + ".\t" + listG.getEntry(i).toString() + "\n";
            }
        }
        return str;
    }

    public Guard getGuard(int choice) {
        return listG.getEntry(choice);
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
