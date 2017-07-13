package com.example.minimusic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.minimusic.MusicService.MusicBinder;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.MediaController.MediaPlayerControl;

public class MainActivity extends Activity implements MediaPlayerControl,SensorEventListener{
	ArrayList<Song> songList;
	ListView songView;
	SongAdapter songAdt;
	MusicController controller;
	MusicService musicSrv;
	Intent playIntent;
	Sensor sr,sr1,sensor;
	SensorManager sm;
	Boolean musicBound=false;
	private boolean paused=false, playbackPaused=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songView=(ListView) findViewById(R.id.listView1);
        songList=new ArrayList<Song>();
        getSongList();
        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        sr=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sr1=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        Collections.sort(songList, new Comparator<Song>(){
        	  public int compare(Song a, Song b){
        	    return a.getTitle().compareTo(b.getTitle());
        	  }
        	});
        songAdt=new SongAdapter(this, songList);
        songView.setAdapter(songAdt);
        setController();
    }
    
    
  protected void onStart() {
	  super.onStart();
	  if(playIntent==null){
		    playIntent = new Intent(this, MusicService.class);
		    bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
		    startService(playIntent);
		  }
  }
  
  
  @Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	sm.unregisterListener( this);
	paused=true;
}
  
  @Override
protected void onResume() {
	super.onResume();
	if(paused){
	    setController();
	    paused=false;
	  }
}
  
  public void songPicked(View view){
	  musicSrv.setSong(Integer.parseInt(view.getTag().toString()));
	  musicSrv.playSong();
	  if(playbackPaused){
	    setController();
	    playbackPaused=false;
	  }
	  controller.show(0);
	}
    
    
    
ServiceConnection musicConnection=new ServiceConnection() {
	
	@Override
	public void onServiceDisconnected(ComponentName name) {
		musicBound=false;
		
	}
	
	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		// TODO Auto-generated method stub
		MusicBinder binder=(MusicBinder) service;
		musicSrv=binder.getService();
		musicSrv.setList(songList);
		musicBound=true;
	}
};



   public void setController() {
	   controller = new MusicController(this);
	   controller.setPrevNextListeners(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			playNext();
			
		}
	}, new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			playPrev();
			
		}
	});
	   controller.setMediaPlayer(this);
	   controller.setAnchorView(findViewById(R.id.listView1));
	   controller.setEnabled(true);
}
   
public void getSongList() 
{
	ContentResolver musicResolver = getContentResolver();
	Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
	Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);
	if(musicCursor!=null && musicCursor.moveToFirst()){
		  //get columns
		  int titleColumn = musicCursor.getColumnIndex
		    (android.provider.MediaStore.Audio.Media.TITLE);
		  int idColumn = musicCursor.getColumnIndex
		    (android.provider.MediaStore.Audio.Media._ID);
		  int artistColumn = musicCursor.getColumnIndex
		    (android.provider.MediaStore.Audio.Media.ARTIST);
		 
		  do {
		    long thisId = musicCursor.getLong(idColumn);
		    String thisTitle = musicCursor.getString(titleColumn);
		    String thisArtist = musicCursor.getString(artistColumn);
		   // Bitmap thisalbum_art=musicCursor.get
		    songList.add(new Song(thisId, thisTitle, thisArtist));
		  }
		  while (musicCursor.moveToNext());
		}
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	@Override
	public boolean canPause() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean canSeekBackward() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean canSeekForward() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public int getBufferPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getCurrentPosition() {
		if(musicSrv!=null && musicBound && musicSrv.isPng())
		    return musicSrv.getPosn();
		  else return 0;
	}
	@Override
	public int getDuration() {
		 if(musicSrv!=null && musicBound && musicSrv.isPng())
			    return musicSrv.getDur();
			  else return 0;
	}
	@Override
	public boolean isPlaying() {
		if(musicSrv!=null && musicBound)
		    return musicSrv.isPng();
		  return false;
	}
	@Override
	public void pause() {
		playbackPaused=true;
		  musicSrv.pausePlayer();
	}
	@Override
	public void seekTo(int pos) {
		musicSrv.seek(pos);
		
	}
	@Override
	public void start() {
		musicSrv.go();
		
	}
	@Override
	protected void onStop() {
		controller.hide();
		super.onStop();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_shuffle:
			musicSrv.setShuffle();
			  break;
		case R.id.action_end:
		  stopService(playIntent);
		  musicSrv=null;
		  System.exit(0);
		  break;
		case R.id.action_sensor:
			sm.registerListener( this, sr, sm.SENSOR_DELAY_NORMAL);
			sm.registerListener(this, sr1, sm.SENSOR_DELAY_NORMAL);
			
		}
		return super.onOptionsItemSelected(item);
		//return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onDestroy() {
		stopService(playIntent);
		  musicSrv=null;
		super.onDestroy();
	}
	
	
	
	
	private void playNext(){
		 musicSrv.playNext();
		  if(playbackPaused){
		    setController();
		    playbackPaused=false;
		  }
		  controller.show(0);
		}
		 
		//play previous
		private void playPrev(){
			 musicSrv.playPrev();
			  if(playbackPaused){
			    setController();
			    playbackPaused=false;
			  }
			  controller.show(0);
		}


		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onSensorChanged(SensorEvent event) {
			sensor=event.sensor;
			if(sensor.getType()==Sensor.TYPE_ACCELEROMETER)
			{
			float f[]=event.values;
			
			
			float x=f[0];
			
			int xc=(int)x;
			
			
			if(xc==8)
			{
				playPrev();
			}
			else if(xc==-8)
				{
				playNext();
				}
			else
			{
				
			}
			
			}
			else if(sensor.getType()==Sensor.TYPE_PROXIMITY)
			{
				float f[]=event.values;
				if(f[0]==0)
				{
					pause();
				}
				else
				{
					start();
				}
				
			}
		}
    
}
