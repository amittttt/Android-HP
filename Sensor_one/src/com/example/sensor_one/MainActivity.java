package com.example.sensor_one;

import java.util.List;

import org.xml.sax.Parser;



import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
	SensorManager sm;
	Sensor sensor;
	TextView tv;
	Button b ;
	private boolean isLandscape;
	String list="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView1);
        b = (Button) findViewById(R.id.button1); 
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    
    }

    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	sm.registerListener(this, sensor, sm.SENSOR_DELAY_NORMAL);
    }
    
  
    
    public void listsensor(View v)
    {
    	List<Sensor> s = sm.getSensorList(sensor.TYPE_ALL);
    	for(Sensor l:s)
    	{
    		list = list + "" +l.getName()+"" + l.getType()+"\n"; 
    	}
    	tv.setText(list);
    }
    
   
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		try
		{
		float[] f= event.values;
		Float x = f[0];
		Float y = f[1];
		Float z = f[2];
		String s= "x ="+Float.toString(x)+"\n"+ "y= "+Float.toString(y)+"\n" + "z = "+Float.toString(z);
		tv.setText(s);
		//  int angle = (int) (Math.atan2(x,y)/(Math.PI/180));
		  //int a = (int)(x/y);
		  //int count = 0;
		  //String b = Float.toString(x);
		  //int c = Integer.parseInt(b);
		 // if(count==0)
		  
			 if(x==0)
			 {
				 	Toast.makeText(this, "hello songs pause", Toast.LENGTH_SHORT).show();
			 }
			 if(x==5)
			 {
				 	Toast.makeText(this, "hello songs start", Toast.LENGTH_SHORT).show();
			 }
		}
		catch(Exception e)
		{
			Toast.makeText(this, "ec"+e, Toast.LENGTH_SHORT).show();
		}
	/*	  
		  if((x <= 6 && x >= -6) && y > 5){
		        isLandscape = false; 
		        }
		        else if(x >= 6 || x<= -6){
		        isLandscape = true;
		        }*/
		  
		/*  if(x==0)
		  {
			  Intent intent = new Intent(this,Second.class);
			  startActivity(intent);
			  
		  }*/
		
		  
	}
	  public void onPause()
	    {
	    	super.onPause();
	    	sm.unregisterListener(this);
	    }
}
