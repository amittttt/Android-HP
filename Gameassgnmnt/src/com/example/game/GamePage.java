package com.example.game;

import java.util.concurrent.CountDownLatch;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GamePage extends Activity {

	 SQLiteDatabase db;
	 ImageView img;
	 TextView tv1,tv2;
	 Button b1,b2;
	 AlertDialog.Builder adb;
	 int score=0,r=0,upper=15,lower=0;
	 int images[]={R.drawable.m1,R.drawable.m2,R.drawable.m3,
			 R.drawable.m4,R.drawable.m1,
			 R.drawable.m5,
			 R.drawable.m6,R.drawable.m7,R.drawable.m1,R.drawable.m4,
			 R.drawable.m3,R.drawable.m8,R.drawable.m9,R.drawable.m10,R.drawable.m11,R.drawable.m12};
	 CountDownTimer ct;
	 int prev=images[0];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_page);
		db=openOrCreateDatabase("players",MODE_PRIVATE, null);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		tv1=(TextView) findViewById(R.id.textView1);
		tv2=(TextView) findViewById(R.id.textView2);
		img=(ImageView) findViewById(R.id.imageView2);
		tv1.setText("Score:"+score);
		r=(int)(Math.random()*(upper-lower))+lower;
		img.setImageResource(images[r]);
		ct=new CountDownTimer(60000,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tv2.setText("Time Left:"+millisUntilFinished/1000);
				
			}
			
			@Override
			public void onFinish() {
				String st=""+score;
				adb=new AlertDialog.Builder(GamePage.this);
				adb.setTitle("Game Over");
				adb.setMessage("Your Score:"+st);
				adb.setPositiveButton("OK", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String s="Insert into highscore values('"+score+"');";
						try{
							db.execSQL(s);
						}
						catch(Exception e)
						{
							
						}
						Intent intent=new Intent("gamemenu");
						startActivity(intent);
					}
				});
				adb.show();
			}
		};
		ct.start();
	}

	public void match(View v)
	{
		if(images[r]==prev)
		{
			score++;
			r=(int)(Math.random()*(upper-lower))+lower;
			img.setImageResource(images[r]);
			tv1.setText("Score:"+score);
		}
		else
		{
			String st=""+score;
			adb=new AlertDialog.Builder(GamePage.this);
			adb.setTitle("Game Over");
			adb.setMessage("Your Score:"+st);
			adb.setPositiveButton("OK", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					String s="Insert into highscore values('"+score+"');";
					try{
						db.execSQL(s);
					}
					catch(Exception e)
					{
						
					}
					Intent intent=new Intent("gamemenu");
					startActivity(intent);
				}
			});
			adb.show();
		}
		
	}
	public void notmatch(View v)
	{
		if(images[r]==prev)
		{
			String st=""+score;
			adb=new AlertDialog.Builder(GamePage.this);
			adb.setTitle("Game Over");
			adb.setMessage("Your Score:"+st);
			adb.setPositiveButton("OK", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					String s="Insert into highscore values('"+score+"');";
					try{
						db.execSQL(s);
					}
					catch(Exception e)
					{
						
					}
					Intent intent=new Intent("gamemenu");
					startActivity(intent);
				}
			});
			adb.show();
		}
		else
		{
			score++;
			r=(int)(Math.random()*(upper-lower))+lower;
			img.setImageResource(images[r]);
			tv1.setText("Score:"+score);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_page, menu);
		return true;
	}

}
