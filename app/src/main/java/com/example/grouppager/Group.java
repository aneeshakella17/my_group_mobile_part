package com.example.grouppager;

import android.widget.EditText;

public class Group {
    String name;
    String type;
    String department;
    String course_no;
    String prof;
    boolean active;

    public Group(){}

    public Group(String name, String type, String department, String course_no, String prof){
        this.name = name;
        this.type = type;
        this.department = department;
        this.course_no = course_no;
        this.prof = prof;
    }

    public String getName(){
        return name;
    }
}
