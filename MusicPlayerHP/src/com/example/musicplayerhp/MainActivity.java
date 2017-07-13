package com.example.musicplayerhp;

import java.io.File;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView lv;
	ImageButton bplay,bprev,pnext;
	ArrayAdapter< String> adapter ;
	MediaPlayer mp;
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView1);
        bplay = (ImageButton) findViewById(R.id.play);
       
      //  File f = new File("/SD card/Songs");
      //  String list[] = {"A","B","C","D","E", "f" , "g","A","B","C","D","E", "f" , "g" };
        File f = Environment.getExternalStoragePublicDirectory("music");
       final String list[] = f.list();
      
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        Uri myUri = Uri.parse("list");

        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override  
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				
				 // int resId = songPos[arg2];
				  Toast.makeText(getApplicationContext(), "Your BMI is " + arg2,  Toast.LENGTH_SHORT).show();
				 // mp = MediaPlayer.create(MainActivity.this, arg2); 
				 // Toast.makeText(getApplicationContext(), "Your BMI is " ,  Toast.LENGTH_SHORT).show();
				  //mp.start();
			}
		});
        
    }
	private ListView getListView() {
		// TODO Auto-generated method stub
		return null;
	}
	int count=0;
	/*	public void play(View v) 
		{
			
			
			if(mp.isPlaying())
			{
				//btPlay.setText(">");
				mp.pause();
			}
			else
			{ 
				mp.start();
				//btPlay.setText("||");
			}
		}
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
