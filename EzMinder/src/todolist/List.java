package todolist;

import java.io.Serializable;
import java.util.ArrayList;

public class List implements Serializable {
    private int listID;
    private String title;
    private ArrayList tasks = new ArrayList();

    List(String title) {
        this.title = title;
    }
    
    List(String title, int listID) {
        this.title = title;
        this.listID = listID;
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }
    
    public void updateListID(int listID, String listName) { //needs an identifying characteristic
        this.listID = listID;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setTitle(String title, int listID) {
        this.title = title;
    }
    
    public void addTask(String title, String description, boolean completed) {
        tasks.add(new Task(title, description, completed));
    }
    
    public void addTask(String title, String description, boolean completed, int listID) {
        tasks.add(new Task(title, description, completed, listID));
    }
    
    public void addTask(String title, String description, boolean completed, int taskID, int listID) {
        tasks.add(new Task(title, description, completed, listID));
    }
    
    public ArrayList getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList tasks) {
        this.tasks = tasks;
    }
}