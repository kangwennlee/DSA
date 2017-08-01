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
public class LinkedQueue<T> implements QueueInterface<T> {

    protected Node<T> front;
    protected Node<T> rear;
    protected int numElements = 0;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    @Override
    public void enqueue(T element) throws QueueUnderflowException {
        Node<T> newNode = new Node<T>(element);
        if (rear == null) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        numElements++;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        } else {
            T element;
            element = front.getData();
            front = front.getNext();
            if (front == null) {
                rear = null;
            }
            numElements--;
            return element;
        }
    }

    @Override
    public T getFront() {
        return front.getData();
    }

    @Override
    public boolean isEmpty() // Returns true if this queue is empty; otherwise, returns false
    {
        return (numElements == 0);
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        numElements = 0;
    }

    @Override
    public void remove(T entry) {
        Node tempNode = front;
        if (tempNode.getData() == entry) {
            front = front.getNext();
        } else if (rear.getData() == entry) {
            for (int i = 1; i < numElements; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(null);
            numElements--;
        } else {
            while (tempNode.getNext() != null) {

            }
            if (tempNode.getNext().getData() == entry) {
                tempNode.setNext(tempNode.getNext().getNext());
                numElements--;
            } else {
                tempNode = tempNode.getNext();
            }
        }

    }

    @Override
    public boolean contains(T entry) {
        Node tempNode = front;
        while (tempNode.getNext() != null) {
            if (tempNode.getData() == entry) {
                return true;
            } else {
                tempNode = tempNode.getNext();
            }
        }
        return false;
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
