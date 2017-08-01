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
public class LinkedStack<T> implements StackInterface<T>
{
        protected Node<T> top;
        
        public LinkedStack()
        {
            top = null;
        }
        
        @Override
        public void push(T element)
        {
            Node<T> newNode = new Node<T>(element);
            newNode.setNext(top);
            top = newNode;
        }
        
        @Override
        public T pop() throws StackUnderflowException
        // Throws StackUnderflowException if this stack is empty,
        // otherwise removes top element from this stack.
        {
            T popTop;
            if(isEmpty())
                throw new StackUnderflowException("Pop attempted on an empty stack.");
            else
            {
                popTop = top.getData();
                top = top.getNext();
            }
                
             return popTop;  
        }
        
        @Override
        public T peek() throws StackUnderflowException
        //Throws StackUnderflowsException if this stack is empty.
        //otherwise returns top element of this stack.
        {
            if(isEmpty())
                throw new StackUnderflowException("Peek attempted on an empty stack.");
            else
                return top.getData();
        }
        
        @Override
        public boolean isEmpty()
        // Returns true is this stack is empty, otherwise returns false.
        {
            return (top == null);
        }
}
