package com.example.layout1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
	EditText t1,t2;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		t1= (EditText) findViewById(R.id.editText1);
		t2 = (EditText) findViewById(R.id.editText2);
		b1= (Button) findViewById(R.id.button1);
	}

	public void Login(View V)
	{
		if(t1.getText()==t2.getText())
		{
			
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
