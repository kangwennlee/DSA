/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

/**
 *
 * @author User
 */
public class Task implements Comparable<Task>{
    Emergency emergency;
    Guard guard;
    Tools tools;
    boolean completed;
    
    
    public Task(Emergency emergency, Guard guard, Tools tools){
        this.emergency = emergency;
        this.guard = guard;
        this.tools = tools;        
        this.completed = false;
        this.guard.busy = true;
    }

    @Override
    public int compareTo(Task o) {
       return emergency.typeOfEmergency.compareTo(o.emergency.typeOfEmergency);
    }
    
    @Override
    public String toString(){
        return (emergency.victim.name+"\t"+emergency.typeOfEmergency+"\t"+guard.name+"\t"+tools.toolName+"\t"+completed);       
    }
}
