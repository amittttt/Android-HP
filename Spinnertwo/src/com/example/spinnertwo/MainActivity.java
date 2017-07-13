package com.example.spinnertwo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	Spinner sp1,sp2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1= (Spinner) findViewById(R.id.spinner1);
        sp2= (Spinner) findViewById(R.id.spinner2);
        sp1.setPrompt("Select Location");
        
        final String[] location = {"Allahabad" , "Delhi" , "BBS"};
    	final String[] courseald  ={"Android","Java","J2EEE","PHP"};
    	final String[] coursebbs = {".Net","Core JAva","Phython"};
    	final String[] coursedelhi = {".Net","Core JAva","php with wordpress"};
     	ArrayAdapter<String> ad1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,location);
    	sp1.setAdapter(ad1);
    	sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
      	
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3)
			{
				if(arg0.getItemAtPosition(position).toString().equals("Allahabad"))
				{
					ArrayAdapter<String> ad2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,courseald);
					sp2.setAdapter(ad2);
					sp2.setPrompt("Courses");
				}
				if(arg0.getItemAtPosition(position).toString().equals("Delhi"))
				{
					ArrayAdapter<String> ad3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,coursedelhi);
					sp2.setAdapter(ad3);
					sp2.setPrompt("Courses");
				
				}
				if(arg0.getItemAtPosition(position).toString().equals("BBS"))
				{
					ArrayAdapter<String> ad4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,coursebbs);
					sp2.setAdapter(ad4);
					sp2.setPrompt("Courses");
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
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
