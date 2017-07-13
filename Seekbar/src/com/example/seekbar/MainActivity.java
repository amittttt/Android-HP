package com.example.seekbar;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	SeekBar seekbar;
	AudioManager am;
	TextView tv;
    @Override
    	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am=(AudioManager) getSystemService(AUDIO_SERVICE);
        int max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int current = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekbar = (SeekBar) findViewById(R.id.seekBar1);
        seekbar.setMax(max);
        seekbar.setProgress(current);
       
        seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		
		
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "SeekbarRelase", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "SeekbarTouch", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
			}
		});
    }	
    
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
