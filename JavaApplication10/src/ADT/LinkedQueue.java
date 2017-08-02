/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;
/**
 *
 * @author Kangwenn
 * @param <T>
 */
public class LinkedQueue<T extends Comparable<? super T>> implements QueueInterface<T> {
    protected Node<T> front;
    protected Node<T> rear;
    protected int numElements = 0;
    
    public LinkedQueue()
    {
        front = null;
        rear = null;
    }

    @Override
    public void enqueue(T element){
        front = enqueue(element, front);
        numElements++;
    }
    
    private Node enqueue(T newEntry, Node currNode) {
        if (currNode == null){
            currNode = new Node(newEntry);
            rear = currNode;
        }
        else if (newEntry.compareTo((T) currNode.getData()) > 0){
            currNode = new Node(newEntry, currNode);
            
        } else {
            Node nodeAfter = enqueue(newEntry, currNode.getNext());
            currNode.setNext(nodeAfter);
        }
        return currNode;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if(isEmpty())
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        else
        {
            T element;
            element = front.getData();
            front = front.getNext();
            if(front == null)
                rear = null;
            numElements--;
            return element;
        }
    }

    @Override
    public T getFront() {
        return front.getData();
    }
    
    @Override
    public boolean isEmpty()
    // Returns true if this queue is empty; otherwise, returns false
    {
        return (numElements==0);
    }
    
    @Override
    public int size() {
        return numElements;
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        numElements=0;
    }

    @Override
    public void remove(T entry) {
        if(isEmpty())
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        
        else if(!contains(entry)){
            throw new QueueUnderflowException("This queue does not contains element " + entry);
        }
        else
        {
            if (front.getData() == entry){
                dequeue();
            }
            else{
                front = remove(entry, front);
                numElements--;
            }
            
        }
    }
    
    private Node remove(T entry, Node currNode) {
        if(currNode.getData() == entry){
            currNode = currNode.getNext();
        }
        else{
            Node nodeAfter = remove(entry, currNode.getNext());
            if (nodeAfter == null){
                rear = currNode;
            }
            currNode.setNext(nodeAfter);
        }
        return currNode;
    }

    @Override
    public boolean contains(T entry) {
        boolean contain = false;
           Node tempNode = front;
        while(tempNode != null){
            if (tempNode.getData() == entry){
                contain = true;
            }
            tempNode = tempNode.getNext();
        }
        return contain;
    }

    @Override
    public T getEntry(int position) {
        T result = null;

        if ((position >= 1) && (position <= numElements)) {
            Node currentNode = front;
            for (int i = 0; i < position - 1; ++i) {
                currentNode = currentNode.getNext();		// advance currentNode to next node
            }
            result = (T) currentNode.getData();	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }
    
    
}
