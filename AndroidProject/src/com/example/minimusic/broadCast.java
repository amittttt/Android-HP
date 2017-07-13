package com.example.minimusic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class broadCast extends BroadcastReceiver{
     MusicService sr;
	@Override
	public void onReceive(Context context, Intent intent) {
		
		
		if(intent.getAction().equals("com.play"))
		{
			Intent start=new Intent(context,MusicService.class);
			start.putExtra("start", "play");
			context.startService(start);
		}
		else if(intent.getAction().equals("com.next"))
		{
			Intent next=new Intent(context,MusicService.class);
			next.setAction("next");
			context.startService(next);
		}
		else if(intent.getAction().equals("com.prev"))
		{
			Intent prev=new Intent(context,MusicService.class);
			prev.setAction("prev");
			context.startService(prev);
		}
	}

}
