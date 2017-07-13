package com.example.exam;

import android.R.string;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	TextView tv,tv1,tv2,tv3;
	Button b1,b2;
	ToggleButton tb;
	MediaPlayer mp;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp=MediaPlayer.create(this,R.raw.a);
        tv1 = (TextView) findViewById(R.id.first);
        tv2 = (TextView) findViewById(R.id.second);
        tv3 = (TextView) findViewById(R.id.three);
        tv = (TextView) findViewById(R.id.fourth);
        tb = (ToggleButton) findViewById(R.id.toggleButton1);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
       
    }
    public void play()
    {
    	if(mp==null)
    	{
    		 mp=MediaPlayer.create(this,R.raw.a);
    	}
    	mp.start();
    }
	
	
	public void next()
	{
	
	}
    
	public void prev()
	{
		
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
