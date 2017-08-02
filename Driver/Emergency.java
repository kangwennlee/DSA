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
        Integer severity;
        
        public Emergency(User victim,String typeofEmergency, String location, int severity){
            this.location = location;
            this.typeOfEmergency = typeofEmergency;
            this.victim = victim;
            this.severity = severity;
        }
        

    @Override
    public int compareTo(Emergency emergency) {
        return this.severity.compareTo(emergency.severity);
    }
    
    public String toString(){
        return "Type Of Emergency: " + typeOfEmergency + "\nLocation: " + location + "\nVictim: " + victim;
    }
}
