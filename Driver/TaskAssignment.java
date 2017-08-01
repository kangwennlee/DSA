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

    SortedListInterface<Task> taskList = new SortedLinkList<>();
    //QueueInterface <Task> task = new LinkedQueue <> ();

    public void addTask(Emergency emergency, Guard guard, Tools tools) {
        Task newTask = new Task(emergency, guard, tools);
        taskList.add(newTask);
    }

    public boolean updateTaskStatus(int choice) {
        if (choice > 0 && choice <=taskList.getLength()) {
            taskList.getEntry(choice).completed = true;
            taskList.getEntry(choice).guard.busy = false;
            return true;
        }
        else return false;
    }

    public void printPendingTask() {
        int index = 1;
        for (int i = 1; i <= taskList.getLength(); i++) {
            if (taskList.getEntry(i).completed == false) {
                System.out.println(index++ + "." + taskList.getEntry(i).toString());
            }
        }
    }

    public void printCompletedTaskList() {
        int index = 1;
        for (int i = 1; i <= taskList.getLength(); i++) {
            if (taskList.getEntry(i).completed == true) {
                System.out.println(index++ + "." + taskList.getEntry(i).toString());
            }
        }
    }

    public void clearCompletedTask() {
        
    }
}
