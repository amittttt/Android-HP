package com.example.multiautocomplete;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {
	MultiAutoCompleteTextView mact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mact = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        final String[] course = {"Core","Core java","corejava with android","Networking","PHP with wordpress"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,course);
        mact.setAdapter(adapter);
        mact.setThreshold(1);
        mact.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
