package com.example.musicplayer;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
	TextView start,stop,track;
	SensorManager sm;
	Sensor sen;
	String filegot="",filename="";
	SeekBar pb;
	MediaPlayer mp;
	ImageButton play,pause,list;
	Drawable d1,d2;
	Thread th,th1;
	Intent i;
	int temp=0,m=0,count=0,c=0;
	int xyz=0,xyz1=0;
	Intent inte;
	SharedPreferences sf;
	String fts="",ss="";
	CheckBox cb;
	Notification n;
	NotificationManager nm;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		track=(TextView) findViewById(R.id.track);
		stop=(TextView) findViewById(R.id.endtime);
		list=(ImageButton) findViewById(R.id.list);
		cb=(CheckBox) findViewById(R.id.checkBox1);
		play=(ImageButton) findViewById(R.id.play);
		pb=(SeekBar)findViewById(R.id.seekBar1);
		sf=getSharedPreferences("home", MODE_PRIVATE);
		play.setBackgroundResource(R.drawable.ic_action_name);
		inte=getIntent();
		String s=sf.getString("song", "");
		play.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(filename.equals(""))
					Toast.makeText(MainActivity.this, "select song", Toast.LENGTH_LONG).show();
				if(mp!=null)
					play(filegot);
				 
			}
		});
		
		cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
				sm=(SensorManager)getSystemService(SENSOR_SERVICE);
				sen=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
				sm.registerListener(MainActivity.this,sen,sm.SENSOR_DELAY_UI);
			}
			if(!isChecked){
				if(sen!=null)
				sm.unregisterListener(MainActivity.this);
			}
			}
		});
		
		
	}
	@Override
	public void onDestroy()
	{try{ super.onDestroy();
		mp.stop();nm.cancel(104);
		Toast.makeText(MainActivity.this, "app closed", Toast.LENGTH_LONG).show();
		}catch(Exception E){Toast.makeText(MainActivity.this, "app closed", Toast.LENGTH_LONG).show();}
		}
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	
	}
	public void list(View v)
	{
			Intent i=new Intent(MainActivity.this,com.example.musicplayer.List.class);
		startActivityForResult(i, 104);
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data)  
	  {super.onActivityResult(requestCode, resultCode, data);  
	  try{ if(requestCode==104)
		  {
			  filegot=data.getStringExtra("file");
			  filename=data.getStringExtra("name");
			  track.setText(filename);
			 if(mp!=null)
			  {
				  m=0;
					mp.stop();
					mp.release();
					mp=null;
					if(play.getTag().equals("pause"))
					{
						play.setBackgroundResource(R.drawable.ic_action_name);
						play.setTag("play");
					}
			  }
			  play(filegot);
			  
		  }
		  else
		  {
			  
		  }}catch(Exception E){}
	  }
	public void stop(View v)
	{   nm.cancel(104);
		if(mp!=null)
		{m=0;
		mp.stop();
		mp.release();
		mp=null;
		//  track.setText("");
		//filename=null;
		if(play.getTag().equals("pause"))
		{
			play.setBackgroundResource(R.drawable.ic_action_name);
			play.setTag("play");
		}
		}
	}
	public void play(String fi)
	{ final String s=fi;
		

		if(play.getTag().equals("play"))
		{View n = null;
		
		if(mp==null&&m==0)
			mp=MediaPlayer.create(MainActivity.this,Uri.parse(s));
			mp.start();
			m++;
			notify();
			play.setBackgroundResource(R.drawable.ic_action_pause);
			play.setTag("pause");
			 int t=mp.getDuration();
			 fts="";ss="";
			  int hours = (int)( t / (1000*60*60));
	           int minutes = (int)(t % (1000*60*60)) / (1000*60);
	           int seconds = (int) ((t % (1000*60*60)) % (1000*60) / 1000);
	           if(hours > 0){
	               fts = hours + ":";
	           }
	           if(seconds < 10){
	               ss = "0" + seconds;
	           }else{
	               ss = "" + seconds;}
	 
	           fts = fts + minutes + ":" + ss;
			stop.setText(fts);
			pb.setMax(t);
			th=new Thread(){
				public void run() {
					int c=0;
					if(c==0)
					{
					long totalDuration = mp.getDuration();
		               long currentDuration = mp.getCurrentPosition();
		               int t=mp.getCurrentPosition();
		               
		               try{ while(totalDuration!=currentDuration)
		            	   {
		            	   
		            	currentDuration = mp.getCurrentPosition();
		 
		         //   	start.setText(String.valueOf(mp.getCurrentPosition()));
		               pb.setProgress((int) currentDuration);
		            	  
		            	   }c++;
		            	   }catch(Exception e){}
					}
		               else
		               {
		            	   
		               }
				
		       }
			};
			th.start();
			temp=1;
			pb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
							temp=1;
				}
					@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					temp=0;
				}
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
					if(mp!=null && temp==0)
					{mp.seekTo(progress);
					
					}
				}
			});
		}
		else {
		mp.pause();
		temp=0;
		play.setBackgroundResource(R.drawable.ic_action_name);
		play.setTag("play");
	}	
	}
		
	

	/*@Override
	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/
	public void nextsong(View v)
	{if(!filename.equals(null))
	{
		Iterator it= Data.hm.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			String key = (String) entry.getKey();
		    String value = (String) entry.getValue();
			   if( filename.equals(key))
				 try{  {if(it.hasNext());
			     entry = (Map.Entry)it.next();
			     String key1 = (String) entry.getKey();
				    String value1 = (String) entry.getValue();
				    filename=key1;
				    track.setText(filename);
				    stop(v);
				   play(value1);
			   }
	}catch(Exception e){Toast.makeText(MainActivity.this, "no next song", Toast.LENGTH_LONG).show();}
		}
	}
	}
	public void previous(View v)
	{if(!filename.equals(null))
	{
	try{	Iterator it= Data.hm.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			String key = (String) entry.getKey();
		    String value = (String) entry.getValue();
			   if( filename.equals(key))
			   {stop(v);
				   play(value);
			   }
	}
	}catch(Exception e){Toast.makeText(MainActivity.this, "no previous song", Toast.LENGTH_LONG).show();}
	}
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		String s="";
		float value[]=event.values;
		float x=value[0];
		float y=value[1];
		float z=value[2];
		try{
		if(z>9)
		{xyz=0;
			if(xyz1==0)
			{
			try{if(!mp.isPlaying())
				if(filegot!=null)
					play(filegot);}catch(Exception E){
						Toast.makeText(getApplicationContext(), "select song", Toast.LENGTH_LONG).show();
				xyz1++;	}
		}}
		if(z<-8)
		{try{xyz=0;
			xyz1=0;
		if(mp.isPlaying())
			mp.pause();}catch(Exception e){Toast.makeText(getApplicationContext(), "select song", Toast.LENGTH_LONG).show();}
		}
		if(x>9&&xyz==0)
		{	View v = null;
		xyz1=0;
			previous(v);
			xyz++;
		}if(x<-8&&xyz==0)
		{	View v = null;
		xyz1=0;
		nextsong(v);
		xyz++;
	}
		if(y>7)
		{
			xyz=0;xyz1=0;
		}}catch(Exception e){}
	}
	
	
}