package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NewGame extends Activity {
  Button b1,b2;
  ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_game);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		img=(ImageView) findViewById(R.id.imageView1);
	}
	public void start(View v)
	{
		Intent intent=new Intent(this,GamePage.class);
		startActivity(intent); 
	}
	public void back(View v)
	{
		Intent intent=new Intent(this,StartPage.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_game, menu);
		return true;
	}

}
