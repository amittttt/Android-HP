package com.example.project1;

import android.os.Bundle;


import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button b1,b2;
	Intent i1,i2,i3,i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        registerForContextMenu(b1);
        registerForContextMenu(b2);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                openContextMenu(v);
            }   
        });

        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                openContextMenu(v);
            }   

        });


            }
    
    public void startGame(View v)
    {
    		 i1=new Intent(this,PrimaryActivity.class);
             startActivity(i1);
    }
    public void exit(View v)
    {
    	android.os.Process.killProcess(android.os.Process.myPid());	
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
	super.onCreateContextMenu(menu, v, menuInfo);
		/*menu.setHeaderTitle("Context Menu");
		menu.add(0, v.getId(), 0, "Adjust Brightness");
		menu.add(0, v.getId(), 0, "High Score");*/
		 if(v.getId() == R.id.button2)
		 {
			 menu.setHeaderTitle("Context Menu");
				menu.add(0, v.getId(), 0, "Adjust Brightness");
				
		 }
        else if(v.getId() == R.id.button3)
        {
        	menu.setHeaderTitle("Context Menu");
			menu.add(0, v.getId(), 0, "Primary");
			menu.add(0, v.getId(), 0, "Expert"); 
        }
	}
    @Override
	public boolean onContextItemSelected(MenuItem item) {
   
       	if(item.getTitle()=="Adjust Brightness")
       	{
         i2=new Intent(this,BrightnessActivity.class);
         startActivity(i2);
       	}
    	
    	else if(item.getTitle()=="Primary")
    	       	{
    	         i3=new Intent(this,PrimaryActivity.class);
    	         startActivity(i3);
    	       	}
    	    	else if(item.getTitle()=="Expert")
    	    	{
    	    		i4=new Intent(this,ExpertActivity.class);
       	         startActivity(i4);
    	    		}
    	    	else 
    	    	{
    	    		return false;
    	    	}
    	
	return true;
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
