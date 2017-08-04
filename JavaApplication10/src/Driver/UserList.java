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
    public boolean addUser(String name, String contactNo) {
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
        return listU.remove(position)!=null;
    }

    public String printUserList() {
        String str ="";
        str +="List of users:\nNo.\tName\t\tContact Number\n";
        for (int i = 1; i <= listU.getLength(); i++) {
            str+=i + ".\t" + listU.getEntry(i).toString() + "\n";
        }
        return str;
    }
    
    public User getUser(int choice){
        return listU.getEntry(choice);
    }
    
    public User getUserByName(String name) {
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
        return listG.remove(position)!=null;
    }

    public String printGuardList() {
        String str = "";
        str += "List of users:\nNo.\tName\t\tContact Number\tStaff ID\tBusy?\n";
        for (int i = 1; i <= listG.getLength(); i++) {
            str+= i + ".\t" + listG.getEntry(i).toString()+"\n";
        }
        return str;
    }
    
    public String printAvailableGuard(){
        String str = "";
        str += "List of users:\nNo.\tName\t\tContact Number\tStaff ID\tBusy?\n";
        for (int i = 1; i <= listG.getLength(); i++) {
            if(listG.getEntry(i).busy==false)
                str+= i + ".\t" + listG.getEntry(i).toString()+"\n";
        }
        return str;
    }
    
    public Guard getGuard(int choice){
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
