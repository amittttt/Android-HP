package com.example.smscalling;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends Activity {
	EditText msg,phn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);
		msg = (EditText) findViewById(R.id.msg);
		phn = (EditText) findViewById(R.id.phn);
	   String m = msg.getText().toString();
	   String p = phn.getText().toString();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sms, menu);
		return true;
	}
	public void sendsms(View V)
	{
		
		String m = msg.getText().toString();
		String p = phn.getText().toString();
		
		//Toast.makeText(this, "num"+p, Toast.LENGTH_SHORT).show();
		//Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("sms:"+p));
		intent.putExtra("sms_body",m);
		startActivity(intent);
		
	}
}
