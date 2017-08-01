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
public class EmergencyService {

    QueueInterface<Emergency> emergencyQueue1 = new LinkedQueue<>();
    QueueInterface<Emergency> emergencyQueue2 = new LinkedQueue<>();
    QueueInterface<Emergency> emergencyQueue3 = new LinkedQueue<>();
    SortedListInterface<Tools> toolsList = new SortedLinkList<>();

    public void addEmergency(User victim, int typeOfEmergency, String location) {
        String type = "";
        switch (typeOfEmergency) {
            case 1:
                type = "Suicide case";
                break;
            case 2:
                type = "Fainting";
                break;
            case 3:
                type = "Food poisoning";
                break;
            case 4:
                type = "Figthing";
                break;
            case 5:
                type = "Missing items";
                break;
            default:
                type = "Argument";
        }
        Emergency newCase = new Emergency(victim, type, location);

        if (typeOfEmergency == 1 || typeOfEmergency == 2) {
            emergencyQueue1.enqueue(newCase);
        } else if (typeOfEmergency == 3 || typeOfEmergency == 4) {
            emergencyQueue2.enqueue(newCase);
        } else {
            emergencyQueue3.enqueue(newCase);
        }

    }

    public void removeEmergency(Emergency emergency) {
        
        if (emergencyQueue1.contains(emergency)) {
            emergencyQueue1.remove(emergency);
        } else if (emergencyQueue2.contains(emergency)) {
            emergencyQueue2.remove(emergency);
        } else {
            emergencyQueue3.remove(emergency);
        }

    }

    public Emergency getEmergencyByUser(User user) {
        Emergency myEmergency = null;
        for (int i = 1; i <= emergencyQueue1.size(); i++) {
            Emergency temp = emergencyQueue1.getEntry(i);
            if (temp.victim == user) {
                myEmergency = temp;
            }
        }
        for (int i = 1; i <= emergencyQueue2.size(); i++) {
            Emergency temp = emergencyQueue2.getEntry(i);
            if (temp.victim == user) {
                myEmergency = temp;
            }
        }
        for (int i = 1; i <= emergencyQueue2.size(); i++) {
            Emergency temp = emergencyQueue2.getEntry(i);
            if (temp.victim == user) {
                myEmergency = temp;
            }
        }
        return myEmergency;
    }

    public void printEmergencyQueue() {
        System.out.println("Emergency Queue: ");
        int index = 1;
        for (int i = 1; i <= emergencyQueue1.size(); i++) {
            System.out.print(index++ + ". \n");
            System.out.print(emergencyQueue1.getEntry(i));
        }
        for (int i = 1; i <= emergencyQueue2.size(); i++) {
            System.out.print(index++ + ". \n");
            System.out.println(emergencyQueue2.getEntry(i));
        }
        for (int i = 1; i <= emergencyQueue3.size(); i++) {
            System.out.print(index++ + ". \n");
            System.out.println(emergencyQueue3.getEntry(i));
        }
    }

    public void addTools(String toolName, String toolUsage) {
        toolsList.add(new Tools(toolName, toolUsage));
    }

    public void removeTools(int position) {
        toolsList.remove(toolsList.getEntry(position));
    }

    public Tools getToolByName(String toolName) {
        for (int i = 1; i <= toolsList.getLength(); i++) {
            if (toolsList.getEntry(i).toolName.equals(toolName)) {
                return toolsList.getEntry(i);
            }

        }
        return null;
    }

    public void printToolList() {
        System.out.println("Tool List: ");
        for (int i = 1; i <= toolsList.getLength(); i++) {
            System.out.print(i + ". \n");
            System.out.print(toolsList.getEntry(i));
        }
    }
}
