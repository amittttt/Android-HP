package com.example.app_one;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SecondActivityApp_one extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_activity_app_one);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_activity_app_one, menu);
		return true;
	}

}
