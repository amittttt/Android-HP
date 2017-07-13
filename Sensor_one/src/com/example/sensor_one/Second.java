package com.example.sensor_one;

import android.hardware.SensorEvent;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Second extends MainActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		
		float[] f= event.values;
		Float x = f[0];
		Float y = f[1];
		Float z = f[2];
		String s= "x ="+Float.toString(x)+"\n"+ "y= "+Float.toString(y)+"\n" + "z = "+Float.toString(z);
		tv.setText(s);
		  double angle = Math.atan2(x,y)/(Math.PI/180);
		  int a = (int)(x/y);
	/*		if(angle >= 90 && angle <= 180)
		{	
			
			Toast.makeText(this, "you" , Toast.LENGTH_LONG).show();
		}
	}
		  
		  if((x <= 6 && x >= -6) && y > 5){
		        isLandscape = false; 
		        }
		        else if(x >= 6 || x<= -6){
		        isLandscape = true;
		        }*/
		  
		  if(x==1)
		  {
			  Intent intent = new Intent(this,MainActivity.class);
			  startActivity(intent);
			  
		  }
		  
			  
		  
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	
	
}
