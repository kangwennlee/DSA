package Driver;

public class Emergency implements Comparable<Emergency> {

    String typeOfEmergency;
    String location;
    User victim;
    Integer severity; //higher value, higher priorty

    public Emergency(User victim, String typeofEmergency, String location, int severity) {
        this.location = location;
        this.typeOfEmergency = typeofEmergency;
        this.victim = victim;
        this.severity = severity;
    }
    
    @Override
    public int compareTo(Emergency emergency) {
        return this.severity.compareTo(emergency.severity);
    }

    @Override
    public String toString() {
        return typeOfEmergency + "\t\t" + location + "\t\t\t" + victim;
    }
}
