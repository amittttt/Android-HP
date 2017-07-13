package com.example.smscalling;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Call extends Activity {
	EditText phn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		phn = (EditText) findViewById(R.id.editText1);
		
	}
		public void makecall(View V)
		{
			String p = phn.getText().toString();
			
			
			if(p.trim().length()<10)
			{
				Toast.makeText(this, "Please Enter 10 Digit Mobile no", Toast.LENGTH_LONG).show();
			}
			
			else
			{
			Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+p));
			startActivity(intent);
			}
			
			
		}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.call, menu);
		return true;
	}

}
