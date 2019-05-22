package com.example.grouppager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GroupCreateActivity extends AppCompatActivity {

    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_create);
        reff = FirebaseDatabase.getInstance().getReference().child("Active Groups");
        CheckBox professor_checkbox = findViewById(R.id.professor_checkbox);
        CheckBox type_checkbox = findViewById(R.id.type_checkbox);
        CheckBox course_no_checkbox = findViewById(R.id.course_number_checkbox);
        CheckBox department_checkbox = findViewById(R.id.department_checkbox);
    }

    public void addGroup(View view){
        String group_name = ((EditText) findViewById(R.id.group_name)).getText().toString();
        String type = ((EditText) findViewById(R.id.type_input)).getText().toString();
        String professor = ((EditText) findViewById(R.id.professor_input)).getText().toString();
        String course_no = ((EditText) findViewById(R.id.course_number_input)).getText().toString();
        String department = ((EditText) findViewById(R.id.department_input)).getText().toString();
        Group g = new Group(group_name, type, department, course_no, professor);
        reff.push().setValue(g);
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }


    public void cancel(View view){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

}
