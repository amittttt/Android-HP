package com.example.smscalling;

import java.util.List;

import android.os.Bundle;
import android.renderscript.Int2;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.lv1);
        final String[] setting = {"SendSMS","Call"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,setting);
        lv.setAdapter(ad);
        
        lv.setOnItemClickListener(new OnItemClickListener() 
        {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				// TODO Auto-generated method stub
				String item = arg0.getItemAtPosition(arg2).toString();
				Intent intent = new Intent(item);
				startActivity(intent);
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
