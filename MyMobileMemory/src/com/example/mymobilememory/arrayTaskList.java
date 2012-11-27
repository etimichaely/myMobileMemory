package com.example.mymobilememory;

import java.util.ArrayList;

//Singleton class - one list of all the tasks

public class arrayTaskList 
{
	
	private static arrayTaskList myArray;
	private ArrayList<Task> taskArray;
	
	
	private arrayTaskList() 							//private con't
	{	
		this.taskArray = new ArrayList<Task>();
	}
	
	
	public static arrayTaskList getInstance()
	{
		if(myArray == null)								//check if this instance is already exist
		{
			myArray = new arrayTaskList();				
		}
		return myArray;
	}
	
	
	/*add new task to the head of the array*/
	public void addNewTask(Task taskToAdd)			
	{
		taskArray.add(0, taskToAdd);
	}
	
	
	/*get the index of the task that we want to delete*/
	public void deleteTask(int index)				
	{
		taskArray.remove(index);
	}
	
	public Task getTask(int index)
	{ 
		 return taskArray.get(index);
	}
	
	
	public int getListSize()
	{
		return taskArray.size();
		
	}
	
	

}
