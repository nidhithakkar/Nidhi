package com.example.homework251nidhit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button logIn;
	EditText Email, Password;
	String toastemail="Enter email address";
	String toastpassword="Enter password";
	String addemail, addpassword;
	Toast toast;
	int duration= Toast.LENGTH_SHORT;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Email=(EditText) findViewById(R.id.email);
		Password=(EditText) findViewById(R.id.password);
		logIn= (Button) findViewById(R.id.login);
		
		logIn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				addemail=Email.getText().toString();
				addpassword=Password.getText().toString();
				if(!Email.getText().toString().equals("") && !Password.getText().toString().equals(""))
				{
				Intent intent;
				intent=new Intent(MainActivity.this, NextPageActivity.class);
				intent.putExtra("emailadr",addemail);
				intent.putExtra("addpass", addpassword);
				startActivity(intent);
				}
				if(Email.getText().toString().equals(""))
				{
					Context context = getApplicationContext();
					toast=Toast.makeText(context, toastemail, duration);
					toast.show();
				}
				if(Password.getText().toString().equals(""))
				{
					Context context = getApplicationContext();
					toast=Toast.makeText(context, toastpassword, duration);
					toast.show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
