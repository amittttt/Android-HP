package com.example.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button play,stop,pause;
	MediaPlayer mp; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play= (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.Stop);
    	mp=MediaPlayer.create(this,R.raw.lol);
    }

    public void play(View V)
    {
    	if(mp==null)
    	{
    		mp = MediaPlayer.create(this,R.raw.lol);
    		//mp.start();
    	}
    	mp.start();
    }	
    	public void stop(View V)
    	
    	{ 
    		if(mp.isPlaying())
    		{	
    		mp.stop();
    		mp=null;
    		}
    	}
    	
    	public void pause(View V)
    	{
    		mp.pause();
    	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
