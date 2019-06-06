package todolist;

import java.io.Serializable;

public class Task implements Serializable {

    private String title, description;
    private int listID;
    private int taskID;
    private boolean completed = false;
    
    Task(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }
    
    Task(String title, String description, boolean completed, int listID) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.listID = listID;
    }
    
    Task(String title, String description, boolean completed, int taskID, int listID) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.listID = listID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    
    public int getListID() {
        return listID;
    }

    public void setListID(int listID){//figure this out (don't you need to)
        this.listID = listID;
    }    
    
    public void updateListID(int listID, String taskName){
        this.listID = listID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title, int listID) {
        this.title = title;
    }
    
    public void updateTitle(String title, int listID) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description, int listID) {
        this.description = description;
    }
    
    public void updateDescription(String description, int listID) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
