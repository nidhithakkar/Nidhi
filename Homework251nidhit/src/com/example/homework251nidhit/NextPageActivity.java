package com.example.homework251nidhit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class NextPageActivity extends Activity {
	
	TextView emailaddress, password;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next_page);
		
		emailaddress=(TextView) findViewById(R.id.id);
		password=(TextView) findViewById(R.id.password);
		Bundle i=getIntent().getExtras();
		String getemail=i.getString("emailadr");
		String getpass=i.getString("addpass");
		emailaddress.setText(getemail.toString());
		password.setText(getpass.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next_page, menu);
		return true;
	}

}
