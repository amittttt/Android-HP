package com.example.minimusic;

import java.util.ArrayList;
import java.util.Random;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service implements OnPreparedListener,OnErrorListener,OnCompletionListener {
	
	MediaPlayer player;
	ArrayList<Song> songs;
	int songPosn;
	final IBinder musicBind = new MusicBinder();
	private String songTitle="";
	private static final int NOTIFY_ID=1;
	private boolean shuffle=false;
	private Random rand;
	NotificationManager nm;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		songPosn=0;
		player=new MediaPlayer();
		player.setOnPreparedListener(this);
		player.setOnCompletionListener(this);
		player.setOnErrorListener(this);
		initMusicPlayer();
		rand=new Random();
		nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	
	//Toast.makeText(getApplicationContext(), , duration)
		
	}
	
	
	public void setList(ArrayList<Song> theSongs){
		  songs=theSongs;
		}
	
	
	public class MusicBinder extends Binder {
		  MusicService getService() {
		    return MusicService.this;
		  }
		}
	
	
	public void initMusicPlayer()
	{
	player.setWakeMode(getApplicationContext(),PowerManager.PARTIAL_WAKE_LOCK);
	player.setAudioStreamType(AudioManager.STREAM_MUSIC);
	
	}
	
	
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return musicBind;
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		mp.start();
		Intent notIntent = new Intent(this, MainActivity.class);
		notIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendInt = PendingIntent.getActivity(this, 0,
		  notIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		 
		Notification.Builder builder = new Notification.Builder(this);
		 
		builder.setContentIntent(pendInt)
		  .setSmallIcon(R.drawable.ic_launcher)
		  .setTicker(songTitle)
		  .setOngoing(true)
		  .setContentTitle("Playing")
		  .setContentText(songTitle);
		//Notification not = builder.build();
		Intent i1=new Intent("com.play");
		
		Intent i2=new Intent("com.pause");
		Intent i3=new Intent("com.prev");
		//PendingIntent pi1=PendingIntent.getBroadcast(this,(int)System.currentTimeMillis(),i1,0);
		PendingIntent pi1=PendingIntent.getBroadcast(this,(int)System.currentTimeMillis(),i1,0);
		PendingIntent pi2=PendingIntent.getBroadcast(this,(int)System.currentTimeMillis(),i2,0);
		PendingIntent pi3=PendingIntent.getBroadcast(this,(int)System.currentTimeMillis(),i3,0);
		 builder.addAction(android.R.drawable.ic_media_previous,"",pi1);
			builder.addAction(android.R.drawable.ic_media_pause,"",pi2);
			builder.addAction(android.R.drawable.ic_media_next,"",pi3);
			Notification n=builder.build();
			nm.notify(1,n);
		//startForeground(NOTIFY_ID, not);
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		 if(player.getCurrentPosition()>0){
			    mp.reset();
			    playNext();
			  }
		
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		 mp.reset();
		  return false;
	}
	
	
@Override
public boolean onUnbind(Intent intent) {
	player.stop();
	player.release();
	return false;
}


@Override
public void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	stopForeground(true);
}

public void playSong(){
	player.reset();
	Song playSong = songs.get(songPosn);
	songTitle=playSong.getTitle();
	//get id
	long currSong = playSong.getID();
	//set uri
	Uri trackUri = ContentUris.withAppendedId(
	  android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
	  currSong);
	try{
		  player.setDataSource(getApplicationContext(), trackUri);
		}
		catch(Exception e){
		  Log.e("MUSIC SERVICE", "Error setting data source", e);
		}
	player.prepareAsync();
}


public void setSong(int songIndex){
	  songPosn=songIndex;
	}


public void setShuffle(){
	  if(shuffle) shuffle=false;
	  else shuffle=true;
	}


public int getPosn(){
	  return player.getCurrentPosition();
	}
	 
	public int getDur(){
	  return player.getDuration();
	}
	 
	public boolean isPng(){
	  return player.isPlaying();
	}
	 
	public void pausePlayer(){
	  player.pause();
	}
	 
	public void seek(int posn){
	  player.seekTo(posn);
	}
	 
	public void go(){
	  player.start();
	}
	
	
	public void playPrev(){
		  songPosn--;
		  if(songPosn<0) songPosn=songs.size()-1;
		  playSong();
		}
	
	
	public void playNext(){
		 if(shuffle){
			    int newSong = songPosn;
			    while(newSong==songPosn){
			      newSong=rand.nextInt(songs.size());
			    }
			    songPosn=newSong;
			  }
			  else{
			    songPosn++;
			    if(songPosn>=songs.size()) songPosn=0;
			  }
			  playSong();
		}
	
	


}
