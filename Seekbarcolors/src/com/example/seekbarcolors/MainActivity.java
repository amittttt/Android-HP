package com.example.seekbarcolors;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	RelativeLayout rl;
	SeekBar sk;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sk = (SeekBar) findViewById(R.id.seekBar1);
        rl = (RelativeLayout) findViewById(R.id.rl);
        sk.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				Toast.makeText(MainActivity.this, "SeekbarRelase", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
				Toast.makeText(MainActivity.this, "SeekbarStart", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if(progress==1)
				{
					rl.setBackgroundColor(Color.RED);
				}
				if(progress==2)
				{
					rl.setBackgroundColor(Color.GREEN);
				}
				if(progress==3)
				{
					rl.setBackgroundColor(Color.BLACK);
				}
				if(progress==4)
				{
					rl.setBackgroundColor(Color.BLUE);
				}
				if(progress==5)
				{
					rl.setBackgroundColor(Color.CYAN);
				}
				if(progress==6)
				{
					rl.setBackgroundColor(Color.YELLOW);
				}
				if(progress==7)
				{
					rl.setBackgroundColor(Color.GRAY);
				}
				if(progress==8)
				{
					rl.setBackgroundColor(Color.LTGRAY);
				}
				if(progress==9)
				{
					rl.setBackgroundColor(Color.MAGENTA);
				}
				if(progress==10)
				{
					rl.setBackgroundColor(Color.DKGRAY);
				}
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
