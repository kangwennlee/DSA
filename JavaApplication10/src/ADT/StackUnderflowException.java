/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author kangw
 */
public class StackUnderflowException extends RuntimeException{
    public StackUnderflowException(){
        super();
    }
    
    public StackUnderflowException(String message){
        super(message);
    }
}
