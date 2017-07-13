package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TextView;

public class HighScore extends Activity {
  TextView tv;
  int max=0,i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high_score);
		tv=(TextView) findViewById(R.id.textView1);
		SQLiteDatabase db=openOrCreateDatabase("players",MODE_PRIVATE, null);
		Cursor c=db.rawQuery("select * from highscore;", null);
		while(c.moveToNext())
		{
			i=Integer.parseInt(c.getString(0));
			if(i>max)
			{
				max=i;
			}
			
		}
		tv.setText("High Score:"+max);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.high_score, menu);
		return true;
	}

}
