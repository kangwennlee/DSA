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
        return o.emergency.severity.compareTo(emergency.severity);
       //return emergency.severity.compareTo(o.emergency.severity);
    }
    
    @Override
    public String toString(){
        return (emergency.victim.name+"\t"+emergency.typeOfEmergency+"\t\t"+guard.name+"\t"+tools.toolName+"\t"+completed);       
    }
}
