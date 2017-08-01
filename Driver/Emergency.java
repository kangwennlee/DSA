/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

/**
 *
 * @author Kangwenn
 */
public class Emergency implements Comparable<Emergency> {
        String typeOfEmergency;
        String location;
        User victim;
        
        public Emergency(User victim,String typeofEmergency, String location){
            this.location = location;
            this.typeOfEmergency = typeofEmergency;
            this.victim = victim;
        }
        

    @Override
    public int compareTo(Emergency emergency) {
        return this.typeOfEmergency.compareTo(emergency.typeOfEmergency);
    }
    
    public String toString(){
        return "Type Of Emergency: " + typeOfEmergency + "\nLocation: " + location + "\nVictim: " + victim;
    }
}
