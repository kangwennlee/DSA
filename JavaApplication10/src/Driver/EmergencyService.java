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

    PriorityQueueInterface<Emergency> emergencyQueue = new LinkedQueue<>();
    SortedListInterface<Tools> toolsList = new SortedLinkList<>();
    SortedListInterface<String> typeOfEmergencyList = new SortedLinkList<>();
    
    public void initialiseTypeOfEmergency(){
        typeOfEmergencyList.add("Argument");
        typeOfEmergencyList.add("Missing items");
        typeOfEmergencyList.add("Figthing");
        typeOfEmergencyList.add("Food poisoning");
        typeOfEmergencyList.add("Fainting");
        typeOfEmergencyList.add("Suicide case");
    }
    public void printTypeOfEmergencyList(){
        System.out.print("Type of emergency: \n");
        for (int i =1; i<=typeOfEmergencyList.getLength();i++){
            System.out.print(i+ ". ");
            System.out.print(typeOfEmergencyList.getEntry(i)+ "\n");
        }
    }
    public String getTypeOfEmergencyByPosition(int position){
        return typeOfEmergencyList.getEntry(position);
    }
    
    public int getTypeOfEmergencyListSize(){
        return typeOfEmergencyList.getLength();
    }
    
    public void addEmergency(User victim, int selection, String location) {
        String typeOfEmergency = getTypeOfEmergencyByPosition(selection);
        
        Emergency newCase = new Emergency(victim, typeOfEmergency, location, selection);
            emergencyQueue.enqueue(newCase);
    }
    
    public Emergency retrieveEmergency(){
        return emergencyQueue.dequeue();
    }

    public void removeEmergency(int positionOfEmergency) {
        Emergency temp = getEmergencyByPosition(positionOfEmergency);
        emergencyQueue.remove(temp);
    }
    
    public Emergency getEmergencyByPosition(int positionOfEmergency){
        return emergencyQueue.getEntry(positionOfEmergency);
    }
    
    public int getEmergencyQueueSize(){
        return emergencyQueue.size();
    }

    public Emergency getEmergencyByUser(User user) {
        Emergency myEmergency = null;
        for (int i = 1; i <= emergencyQueue.size(); i++) {
            Emergency temp = emergencyQueue.getEntry(i);
            if (temp.victim == user) {
                myEmergency = temp;
            }
        }
        
        return myEmergency;
    }

    public String printEmergencyQueue() {
        String str ="";
        str +="Emergency Queue:\nNo.\tType Of Emergency\tLocation of Emergency\tVictim Name\tVictim Contact No.\n";
        for (int i = 1; i <= emergencyQueue.size(); i++) {
            str+=i + ".\t" + emergencyQueue.getEntry(i).toString() + "\n";
        }
        return str;
        
    }
    
    public String printVictimsList(){
        String str ="";
        str +="Victims List:\nNo.\tVictim Name\tVictim Contact No.\n";
        for (int i = 1; i <= emergencyQueue.size(); i++) {
            str+=i + ".\t" + emergencyQueue.getEntry(i).victim.toString() + "\n";
        }
        return str;
    }

    public void addTools(String toolName, String toolUsage) {
        toolsList.add(new Tools(toolName, toolUsage));
    }

    public void removeTools(int position) {
        toolsList.remove(toolsList.getEntry(position));
    }
    
    public int getToolListSize(){
        return toolsList.getLength();
    }

    public Tools getToolByName(String toolName) {
        for (int i = 1; i <= toolsList.getLength(); i++) {
            if (toolsList.getEntry(i).toolName == toolName) {
                return toolsList.getEntry(i);
            }

        }
        return null;
    }

    public String printToolList() {
        
        String str ="";
        str +="Tools List:\nNo.\tTools Name\t\t\tTools Usages\n";
        for (int i = 1; i <= toolsList.getLength(); i++) {
            str+=i + ".\t" + toolsList.getEntry(i).toString() + "\n";
        }
        return str;
        
    }
}
