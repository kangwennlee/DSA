/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Kangwenn
 */
public interface StackInterface<T> {
    void push(T element);
    // Places element at the top of this stack.
    
    T pop() throws StackUnderflowException;
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    
    T peek() throws StackUnderflowException;
    //Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element of this stack.
    
    boolean isEmpty();
    // Returns true if this stack is empty, otherwise returns false.
}
