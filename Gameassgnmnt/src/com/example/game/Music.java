package com.example.game;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Music extends Service{
  MediaPlayer mp;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
 @Override
public void onCreate() {
	// TODO Auto-generated method stub
	 mp=MediaPlayer.create(this,R.raw.abc);
	 
	super.onCreate();
	
}
 @Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
	 mp.start();
	 mp.setLooping(true);
		return super.onStartCommand(intent, flags, startId);
	}
 @Override
	public void onDestroy() {
		// TODO Auto-generated method stub
	 mp.stop();
	 mp=null;
		super.onDestroy();
	}
}
