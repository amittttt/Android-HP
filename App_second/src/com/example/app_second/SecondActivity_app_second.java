package com.example.app_second;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SecondActivity_app_second extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_activity_app_second);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_activity_app_second, menu);
		return true;
	}

}
