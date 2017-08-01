/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import ADT.*;


/**
 *
 * @author kangw
 */
public class TestUser {

    public static void main(String[] args) {
        QueueInterface<String> myQueue = new LinkedQueue<>();
        myQueue.enqueue("10");
        myQueue.enqueue("20");
        myQueue.enqueue("30");
        myQueue.enqueue("40");
        
        myQueue.remove("30");
        myQueue.remove("40");
        
        System.out.println(myQueue.contains("20"));
        System.out.println(myQueue.contains("350"));
        
        for(int i=0; i<=myQueue.size();i++)
            System.out.println(myQueue.dequeue());
    }
}
