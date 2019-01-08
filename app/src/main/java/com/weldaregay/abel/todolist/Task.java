package com.weldaregay.abel.todolist;

/**
 * Represents a com.example.abelweldareguy.todolist.Task
 * @author Abel Weldaregay
 */
public class Task {

    private String taskTitle;
    private String taskDescription;

    /**
     * Default constructor
     */
    public Task(){
        this.taskTitle = "empty";
        this.taskDescription = "empty";
    }

    /**
     *
     * @param taskTitle
     * @param taskDescription
     */
    public Task(String taskTitle, String taskDescription) {

        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
    }

    public String getTaskTitle() {
        return this.taskTitle;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    /**
     *
     * @param taskTitle
     */
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    /**
     *
     * @param taskDescription
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
