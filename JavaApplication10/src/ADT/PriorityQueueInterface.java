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
public interface PriorityQueueInterface<T> {
    void enqueue (T element);
    //add element to the rear of this queue.
    
    T dequeue() throws QueueUnderflowException;
    //Throws QueueUnderflowException if this queue is empty;
    // otherwise, remove front element from this queue and returns it.
    
    public T getFront();
    /**
   * Task: Retrieves the entry at the front of the queue.
   *
   * @return either the object at the front of the queue or, if the queue is
   * empty, null
   */
    
    boolean isEmpty();
    // Returns true if this queue is empty;
    // otherwise, return false.
    
    int size();
    // Returns the number of elements in this queue.
    
    public void clear();
     /**
   * Task: Removes all entries from the queue.
     * @param entry
   */
    
    public void remove(T entry);
    //remove the entry from the queue
    //precondition: queue must contain this element
    //postcondition: removed entry from queue
    
    public boolean contains(T entry);
    //check if entry exists in the queue
    //postconsition: queue unchanged
    //return : true if entry is in queue; false otherwise
    
    public T getEntry(int position);
    //retrieve entry of position from queue/
   // precondition : 1<=position <=numEelements
    //postcondition :unchag
    //return entryof position in queue
    
}
