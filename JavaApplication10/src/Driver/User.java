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
public class User implements Comparable<User>{

    protected String name;
    protected String contactNo;

    User(String name, String contactNo) {
        this.name = name;
        this.contactNo = contactNo;
    }
    
    @Override
    public int compareTo(User user){
        return this.name.compareTo(user.name);
    }
    
    @Override
    public String toString(){
        return name +"\t"+contactNo;
    }
   
}
