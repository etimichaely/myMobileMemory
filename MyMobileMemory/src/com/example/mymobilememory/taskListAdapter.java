package com.example.mymobilememory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class taskListAdapter extends BaseAdapter 
{
	
	private LayoutInflater l_Inflater;			//Responsible of creating the appropriate size of each element
	private arrayTaskList tasksList;
	
	
	public taskListAdapter(Context context) {
		super();
		this.tasksList = arrayTaskList.getInstance();		//get reference of the list 
		this.l_Inflater = LayoutInflater.from(context);		//context=represents the location of the list
	}
	
	
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		final int index = position;
		ViewHolder holder;
		if (convertView == null) 
		{
			convertView = l_Inflater.inflate(R.layout.list_item, null);//the hierarchy of the view
			holder = new ViewHolder();
			holder.nameOfTask = (TextView) convertView.findViewById(R.id.textViewOfTask);
			holder.buttonDone = (Button) convertView.findViewById(R.id.donebutton);
			convertView.setTag(holder);
			
		} else 
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.nameOfTask.setText(tasksList.getTask(position).getMyTaskName());
		holder.buttonDone.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				tasksList.deleteTask(index);
				notifyDataSetChanged();				//Notifies the attached observers that the underlying data has been changed and any View reflecting the data set should refresh itself
			}
		});
		

		return convertView;
	}

	static class ViewHolder			//All components of our view
	{
		TextView nameOfTask;
		Button buttonDone = null;
	}


	public int getCount() {
		return tasksList.getListSize();
	}


	public Object getItem(int index) {
		
		return tasksList.getTask(index);
	}


	public long getItemId(int index) {
		
		return index;
	}





	
	

}
