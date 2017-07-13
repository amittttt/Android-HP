package com.example.dialoguebox;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	AlertDialog.Builder adb;
	Button bn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn = (Button)findViewById(R.id.button1);
        
    }
    public void Move(View V)
    {
    	 adb = new AlertDialog.Builder(this);
    	 adb.setTitle("Alert !!!");
    	 adb.setMessage("Do you want to move login page ??");
    	adb.setNegativeButton("Cancel", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
					
			}
		});
    	 	adb.setPositiveButton("OK", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Intent intent= new Intent(MainActivity.this, LoginActivity.class);
					startActivity(intent);
				}
			});
    	AlertDialog ad = adb.create();
    	
    	ad.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    } 
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
    
}
