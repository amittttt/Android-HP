package com.example.notification;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	NotificationManager nm;
	Notification n ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void notifyme(View V)
    {
    	n = new Notification(R.drawable.ic_launcher,"Message Recevied" , System.currentTimeMillis());
    	Intent i = new Intent(this,Second.class);
    	n.flags = Notification.FLAG_AUTO_CANCEL;
    	n.defaults = Notification.DEFAULT_ALL;
    	PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
    	n.setLatestEventInfo(this, "7064266836", "Message for Alkayda", pi);
    	nm.notify((int)System.currentTimeMillis(),n);
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
