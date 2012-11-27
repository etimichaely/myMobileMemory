package com.example.mymobilememory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class My_Memory_app extends Activity 
{
	
	private ListView listView;
	private taskListAdapter adapter;
	private arrayTaskList tasksList;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);									
        setContentView(R.layout.activity_my_memory_app);					//set the activity content from a layout resource-set the view
        listView = (ListView) findViewById(R.id.listView_new);				//create the listView
        tasksList = arrayTaskList.getInstance();							//create the list-list of tasks
        adapter = new taskListAdapter(this);
        listView.setAdapter(adapter);										//set adapter to the listView
        Button addTaskButton = (Button) findViewById(R.id.buttonToCreate);	//create "Add Task" button
        addTaskButton.setOnClickListener(new View.OnClickListener() {		//listener to the "Add Task" button
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(), AddTaskActivity.class);
				startActivity(intent);
			}
		});
    }
	
	public void onResume()
	{
		super.onResume();
		adapter.notifyDataSetChanged();
	}
	
	
	
/**
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_memory_app);
    }
    
    // Called when the user clicks the "Add Task" button(addTask-the name of the button in the xml file) 
    public void addTask(View view) {
    	Intent intent = new Intent(this, AddTaskActivity.class);
    	startActivity(intent);
    }*/
}
