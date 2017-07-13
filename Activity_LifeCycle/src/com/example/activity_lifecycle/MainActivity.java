package com.example.activity_lifecycle;

import android.os.Bundle;
import android.renderscript.Int2;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate First Activity",Toast.LENGTH_LONG).show();
    
    }
    public void move(View v)
    {
    	Intent intent = new Intent(this,Second.class);
    	startActivity(intent);
    }
    public void onStart()
    {
    	super.onStart();
    	Toast.makeText(this, "OnStart First Activity", Toast.LENGTH_LONG).show();
    }

    public void onRestart()
    {
    	super.onRestart();
    	Toast.makeText(this, "OnRestart First Activity", Toast.LENGTH_LONG).show();
    }
    
    public void onResume()
    {
    	super.onResume();
    	Toast.makeText(this, "OnResume First Activity", Toast.LENGTH_LONG).show();
    }
    public void onPause()
    {
    	super.onPause();
    	Toast.makeText(this, "OnPause First Activity", Toast.LENGTH_LONG).show();
    }
    public void onStop()
    {
    	super.onStop();
    	Toast.makeText(this, "OnStop First Activity", Toast.LENGTH_LONG).show();
    }
    	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
