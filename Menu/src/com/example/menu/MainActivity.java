package com.example.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button1);
        registerForContextMenu(b);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	// TODO Auto-generated method stub
    	super.onCreateContextMenu(menu, v, menuInfo);
    	getMenuInflater().inflate(R.menu.compositemenu, menu);
    	
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	if(item.getTitle().equals("Add"))
    	{
    		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    	}
    	
    	if(item.getTitle().equals("Substract"))
    	{
    		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    	}
    	
    	if(item.getTitle().equals("Multiplication"))
    	{
    		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    	}
    	return super.onContextItemSelected(item);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
   
    	if(item.getTitle().equals("Profile"))
    	{
    		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    	}
    	if(item.getTitle().equals("Status"))
    	{
    		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    	}
    	if(item.getTitle().equals("Messgage"))
    	{
    		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    	}
    	if(item.getTitle().equals("action_settings"))
    	{
    		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    	}
    	return super.onOptionsItemSelected(item);
    }
    
}
