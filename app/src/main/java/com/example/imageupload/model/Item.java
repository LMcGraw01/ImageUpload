package com.example.imageupload.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
// each checklist item along with boolean functionality

@Entity

public class Item {
    @Id
    public long id;
    public String text;
    private boolean isChecked;
    private String time;

    // GEORGINA: adding a due date field for me to process in the Calendar
    // using a Long so that I can enter due dates as a timestamp in milliseconds
    public Long dueAt;

    // no arg constructor for ObjectBox
    public Item(){}

    public Item(boolean isChecked, String text, String time)
    {
        this.isChecked = isChecked;
        this.text = text;
        this.time = time;
        // GEORGINA: adding a default value so that old entries without this field still work
        this.dueAt = null;
    }

    // GEORGINA: adding a second constructor that takes in a due date dueAt
    public Item(boolean isChecked, String text, String time, Long dueAt){
        this.isChecked = isChecked;
        this.text = text;
        this.time = time;
        this.dueAt = dueAt;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // GEORGINA: adding getter and setter methods for dueAt field
    public Long getDueAt(){
        return dueAt;
    }
    public void setDueAt(Long dueAt){
        this.dueAt = dueAt;
    }
}