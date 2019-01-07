package com.example.abelweldareguy.todolist;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.lang.reflect.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abel Weldaregay
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    ArrayList<Task> tasks = new ArrayList<>();
    /**
     *
     * @param view
     */
    public void addTaskClicked(View view) {

        EditText taskTitleEditText = (EditText) findViewById(R.id.taskTitleEditText);
        EditText taskDescriptionEditText = (EditText) findViewById(R.id.taskDescEditText);

        String taskTitle = taskTitleEditText.getText().toString();
        String taskDescription = taskDescriptionEditText.getText().toString();

        taskTitleEditText.setText("");
        taskDescriptionEditText.setText("");
        Task newTask = new Task(taskTitle, taskDescription);
        tasks.add(newTask);
        saveData();
        TaskAdapter adapter = new TaskAdapter(this, R.layout.adapter_view_laylout, tasks);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //listView.setAdapter(adapter);

    }


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        final ListView listView = findViewById(R.id.listView);
        loadData();
        final TaskAdapter adapter = new TaskAdapter(this, R.layout.adapter_view_laylout, tasks);
        listView.setAdapter(adapter);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                tasks.remove(position);
                saveData();

                TaskAdapter adapter1 = new TaskAdapter(MainActivity.this, R.layout.adapter_view_laylout, tasks);
                listView.setAdapter(adapter);

                Toast.makeText(MainActivity.this, "Task Completed", Toast.LENGTH_SHORT).show();



                return false;
            }
        });





    }


    private void saveData(){

        SharedPreferences sharedPreferences = getSharedPreferences("shared prefrences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        String json = gson.toJson(tasks);
        editor.putString("task list", json);
        editor.apply();

    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared prefrences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken< ArrayList<Task> >() {}.getType();
        tasks = gson.fromJson(json, type);

        if(tasks == null) {
            tasks = new ArrayList<Task>();
        }

    }




}
