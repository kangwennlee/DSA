/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import ADT.*;
/**
 *
 * @author User
 */
public class TaskAssignment {
    SortedListInterface <Task> completedTaskList = new SortedLinkList <> ();
    QueueInterface <Task> taskQueue = new LinkedQueue <> ();
    
    public void addTask(Emergency emergency, Guard guard, Tools tools){
        Task newTask = new Task(emergency, guard, tools);
        taskQueue.enqueue(newTask);
        guard.busy = true;
    }
    
    public void updateTaskStatus(){
        Task temp = taskQueue.dequeue();
        temp.guard.busy = false;
        temp.completed = true;
        completedTaskList.add(temp);        
    }
    
    public void printPendingTask(){
        for(int i=1; i<=taskQueue.size();i++){
            Task temp = taskQueue.getEntry(i);
            System.out.println(i+ "." + temp.toString());
        }
    }
    
    public void printCompletedTaskList(){
        System.out.println();
        for(int i=1;i<=completedTaskList.getLength();i++){
            Task temp = completedTaskList.getEntry(i);
            System.out.print(i+". "+temp.toString());
        }
    }
    
     public void clearCompletedTask(){
        completedTaskList.clear();
    }    
}
