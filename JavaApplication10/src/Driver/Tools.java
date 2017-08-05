package Driver;

public class Tools implements Comparable<Tools> {

    String toolName;
    String toolUsage;

    public Tools(String toolName, String toolUsage) {
        this.toolName = toolName;
        this.toolUsage = toolUsage;
    }

    @Override
    public int compareTo(Tools t) {
        return this.toolName.compareTo(t.toolName);
    }

    @Override
    public String toString() {
        return toolName + "\t\t" + toolUsage;
    }
}
