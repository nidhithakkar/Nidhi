package com.example.homework252nidhit;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;

public class MainActivity extends Activity implements ActionBar.TabListener {
	
	private ActionBar add, remove;
	private ListFragment list;
	private boolean mDualPane;
	private int count=1;
	ArrayList<String> tasklist;	
	ArrayAdapter<String> dataAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		tasklist= new ArrayList<String>();	
		View detailsframe = findViewById(R.id.detailsframelayout);
		mDualPane=detailsframe!=null && detailsframe.getVisibility()==View.VISIBLE;
		
		
		
			  }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		getMenuInflater().inflate(R.menu.activity_main_menu, menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Handle clicks on action bar
		switch(item.getItemId())
		{
		case R.id.action_add:		
			tasklist.add("Task "+count++);
			dataAdapter.notifyDataSetChanged();			
			return true;
			
		case R.id.action_remove:
			if(tasklist.size()>0)
			{
			tasklist.remove(tasklist.size()-1);
			dataAdapter.notifyDataSetChanged();
			count--;
			}
			return true;
		
		
	default: return super.onOptionsItemSelected(item);
		}	
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		displaylistview();
		
		ListView mylistView = (ListView) findViewById(R.id.list);
		mylistView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

				TextView myTextView = (TextView)view;
				String thisistheitemclicked = myTextView.getText().toString();
				
				
				
				ItemHasBeenClicked(thisistheitemclicked);
			}

			private void ItemHasBeenClicked(String task) {
				// TODO Auto-generated method stub
				if(mDualPane)
				{
					TextView myDetailsTextView = (TextView)findViewById(R.id.detailsTextView);
					if(myDetailsTextView!=null)
					{
						myDetailsTextView.setText(task);
			
					}
					
				}
				else
				{
					//Intent intent = new Intent(MainActivity.this, lass);
				
				}
				}
			
		});
		
		super.onStart();
	}
	
	
	
	
	public void displaylistview(){
		ListView listView = (ListView) findViewById(R.id.list);
		
		if(listView.getAdapter()==null)
		{
		//create an ArrayAdaptar from the String Array
		  dataAdapter = new ArrayAdapter<String>(this,
				  android.R.layout.simple_list_item_1, tasklist);
		  
		  // Assign adapter to ListView
		  listView.setAdapter(dataAdapter);
		}
		  	   
	}

}
