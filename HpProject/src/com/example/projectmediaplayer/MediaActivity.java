package com.example.projectmediaplayer;

import java.io.File;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MediaActivity extends Activity {
ListView lv;
String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        lv=(ListView)findViewById(R.id.lv1);
        
        final ArrayList<File> mySongs=findSongs(Environment.getExternalStorageDirectory());
        items = new String[ mySongs.size() ];
        for(int i=0 ; i<mySongs.size() ; i++)
        {
        	items[i]=mySongs.get(i).getName().toString();
        }
        ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(),R.layout.song_layout,R.id.textView1,items);
        lv.setAdapter(ad);
        
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),PlayerActivity.class).putExtra("pos", position).putExtra("songList", mySongs));
			}
		});
        
        
    }
public ArrayList<File> findSongs(File Music)
{
	ArrayList<File> al=new ArrayList<File>();
	File[] files=Music.listFiles();
	for(File singleFile : files)
	{
		if(singleFile.isDirectory() && !singleFile.isHidden())
		{
			al.addAll(findSongs(singleFile));
		}
		else
		{
			if(singleFile.getName().endsWith(".mp3"))
			{
				al.add(singleFile);
			}
		}
	}
	return al;
	
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.media, menu);
        return true;
    }
    
}
