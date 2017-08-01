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
public class Guard extends User{

    protected String workID;
    protected boolean busy;

    Guard(String name, String contactNo, String workID) {
        super(name, contactNo);
        this.workID = workID;
        this.busy = false;
    }

    /**
     * @return the busy
     */
    public boolean isBusy() {
        return busy;
    }

    /**
     * @param busy the busy to set
     */
    public void setBusy(boolean busy) {
        this.busy = busy;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\t"+workID+"\t\t"+busy;
    }
}
