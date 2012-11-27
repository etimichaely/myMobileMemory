package com.example.mymobilememory;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTaskActivity extends Activity {

	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);								//set the activity content from a layout resource-set the view
        Button createButtonActivity = (Button) findViewById(R.id.create_task);	//button "Create Task"
        createButtonActivity.setOnClickListener(new View.OnClickListener() {	//listener to the "Create Task" button
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText taskText = (EditText) findViewById(R.id.edit_task);	//create the text field
				Task newTask = new Task(taskText.getText().toString());			//save the text of the task
				arrayTaskList myArray = arrayTaskList.getInstance();
				myArray.addNewTask(newTask);									//add the new task to the list				
				finish();
			}
		});
    }
	
	/**
	 @Override
    //Called when the activity is first created
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    public void createTask(View view) {			// Called when the user clicks the Create button(createTask-the name of the button in the xml file) 
    	Intent intent = new Intent(this, My_Memory_app.class);
    	startActivity(intent);
    }*/

}
