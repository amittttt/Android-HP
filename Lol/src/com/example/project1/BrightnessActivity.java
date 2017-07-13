package com.example.project1;

import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class BrightnessActivity extends Activity {

   private SeekBar sb;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_brightness);
   sb = (SeekBar) findViewById(R.id.seekBar1);
   sb.setMax(255);

   float curBrightnessValue = 0;
   try 
   {
   curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(),android.provider.Settings.System.SCREEN_BRIGHTNESS);
   } 
   catch (SettingNotFoundException e) 
   {
   e.printStackTrace();
   }

   int screen_brightness = (int) curBrightnessValue;
   sb.setProgress(screen_brightness);
   sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
   int progress = 0;

   @Override
   public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
   progress = progresValue;
    
   }

   @Override
   public void onStartTrackingTouch(SeekBar seekBar) {
    	
   }

   @Override
   public void onStopTrackingTouch(SeekBar seekBar) {
   android.provider.Settings.System.putInt(getContentResolver(),android.provider.Settings.System.SCREEN_BRIGHTNESS,progress);
   }
  });
 }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
  // Inflate the menu; this adds items to the action bar if it is present.
  getMenuInflater().inflate(R.menu.main, menu);
  return true;
 }

}