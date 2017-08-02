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
public class Tools implements Comparable<Tools>{

    String toolName;
    String toolUsage;
    
    public Tools(String toolName, String toolUsage){
        this.toolName = toolName;
        this.toolUsage = toolUsage;
    }

    @Override
    public int compareTo(Tools t) {
        return this.toolName.compareTo(t.toolName);
    }
    
    public String toString(){
        return toolName + "\t\t" + toolUsage;
    }
}
