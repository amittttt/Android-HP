package com.example.broadcastrecevier;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button bwifi,bblue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bwifi = (Button) findViewById(R.id.button1);
    }
    public void checkwifi(View V)
    {
    	Intent intent = new Intent();
    	intent.putExtra("msg","Wifi Disconnected");
    	intent.setAction("hp.boradcast.first.wifi_check");
    	sendBroadcast(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}