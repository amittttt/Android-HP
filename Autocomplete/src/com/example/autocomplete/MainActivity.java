package com.example.autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
    	AutoCompleteTextView ac;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac= (AutoCompleteTextView) findViewById(R.id.ac);
        final String[] auto = {"Core Java","Core Java with Android","Php","php with wordpress","J2EEE","Networking","Core","WebDesging"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,auto);
        ac.setAdapter(adapter);
       // ac.setThreshold(1);
        //by default value of set threshold is 2
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
