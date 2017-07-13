package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Rules extends Activity {
  Button b1;
  TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rules);
		b1=(Button) findViewById(R.id.button1);
		tv=(TextView) findViewById(R.id.textView2);
		String s=" There are also special memory decks available with matching pictures. They are usually have a theme like fish or animals. " +
				"These may be best when playing with really young children..\n\n\n SAB MOH MAYA HAI" ;
		tv.setText(s);
	}

	public void back(View v)
	{
		Intent intent=new Intent(this,StartPage.class);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rules, menu);
		return true;
	}

}
