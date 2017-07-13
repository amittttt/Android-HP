package com.example.musicplayerassgnment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener {
	MediaPlayer mp;
	ToggleButton tb;
	Button bnext,bprev;
	MediaPlayer mpa[] = new MediaPlayer[4]; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Creating the objects
        mpa[0] = MediaPlayer.create(this,R.raw.a);
        mpa[1] = MediaPlayer.create(this,R.raw.b);
        mpa[2] = MediaPlayer.create(this,R.raw.c);
        mpa[3] = MediaPlayer.create(this,R.raw.d);
        bnext = (Button) findViewById(R.id.next);
        bprev = (Button) findViewById(R.id.prev);
        tb = (ToggleButton) findViewById(R.id.toggleButton1);
        bnext.setOnClickListener(this);
        bprev.setOnClickListener(this);
        tb.setOnClickListener(this);
        //assign the value of object which helps to take new value
        mp = mpa[0];
    }
    	

    @Override
         public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		//if user
		if(v.getId()==tb.getId())
		{
			
			if(tb.getText().toString().equals("PAUSE"))
			{	
				if(mp ==null)
				{
				mp = mpa[0];
				}
				mp.start();
				//mp.pause();
			}
			if(tb.getText().toString().equals("PLAY"))
			{
				mp.pause();
			}
		}
		
		if(v.getId()==bnext.getId())
		{	
			mp.stop();
			if(mp==mpa[0])
			{
				mp = mpa[1];
				mp.play();
				
			}
			
			if(mp==mpa[1])
			{
				mp = mpa[2];
				mp.start();
			}

			if(mp==mpa[2])
			{
				mp = mpa[3];
				mp.start();
			}
				
			if(mp==mpa[3])
			{
				mp = mpa[0];
				mp.start();
			}
		}
		
		if(v.getId()==bprev.getId())
		{	
			mp.stop();
			if(mp==mpa[0])
			{
				mp = mpa[3];
				mp.start();
			}
			if(mp==mpa[1])
			{
				mp = mpa[0];
				mp.start();
			}
			if(mp==mpa[2])
			{
				mp = mpa[1];
				mp.start();
			}
			if(mp==mpa[3])
			{
				mp = mpa[2];
				mp.start();
			}
		}
	}
    
}
