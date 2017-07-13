package com.example.broadcastrecevier;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class FirstBoradcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String s = intent.getStringExtra("msg");
		Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
	}

}
