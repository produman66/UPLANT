package edu.example.uplant.data.data_sources.category.models;

public class TaskModel {
    private String title;
    private boolean completed;

    public String getTitle() {
        return title;
    }

    public TaskModel(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
