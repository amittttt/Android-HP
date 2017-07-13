package com.example.seekbarwithmusicplayer;



import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;

public class MainActivity extends Activity {
	SeekBar sb;
	MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = (SeekBar) findViewById(R.id.seekbar);
        Thread th = new Thread();
        mp=MediaPlayer.create(this,R.raw.d);
        
       
    }

   
    public void run()
    {
    	while(true)
    	{
    		if(mp!=null)
    		
    			sb.setProgress(mp.getCurrentPosition());
    		
    		else
    			
    			sb.setProgress(0);
    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
