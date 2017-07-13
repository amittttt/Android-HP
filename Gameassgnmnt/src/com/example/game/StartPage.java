package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class StartPage extends Activity {
	SQLiteDatabase db;
  Button b1,b2,b3,b4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_page);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
		b4=(Button) findViewById(R.id.button4);
		db=openOrCreateDatabase("players", MODE_PRIVATE, null);
		if(db!=null)
		{
			try{
				
				db.execSQL("create table highscore(score number(3));");
			}
			catch(Exception e)
			{
				
			}
			
		}
	}
	public void start(View v)
	{
		Intent game=new Intent(this,NewGame.class);
		startActivity(game);
	}
	public void rules(View v)
	{
		Intent rules=new Intent(this,Rules.class);
		startActivity(rules);
	}
	public void highscore(View v)
	{
		Intent score=new Intent(this,HighScore.class);
		startActivity(score);
	}
	public void settings(View v)
	{
		//android.os.Process.killProcess(android.os.Process.myPid());
		moveTaskToBack(true);
	    android.os.Process.killProcess(android.os.Process.myPid());
	    System.exit(1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_page, menu);
		return true;
	}

}