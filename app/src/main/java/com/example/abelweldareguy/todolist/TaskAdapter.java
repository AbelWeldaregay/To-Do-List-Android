package com.example.abelweldareguy.todolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

    public static final String TAG = "TaskAdapter";
    private Context mContext;
    private  int mResource;
    /**
     *
     * @param context
     * @param resource
     * @param objects
     */
    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;

    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String taskTitle = getItem(position).getTaskTitle();
        String taskDescription = getItem(position).getTaskDescription();


        Task task = new Task(taskTitle, taskDescription);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView taskTitleTextView = (TextView) convertView.findViewById(R.id.taskTitle);
        TextView taskDescTextView = (TextView) convertView.findViewById(R.id.taskDescription);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
        checkBox.setTag(position);

        taskTitleTextView.setText(taskTitle);
        taskDescTextView.setText(taskDescription);

        return convertView;

    }







}
