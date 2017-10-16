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
