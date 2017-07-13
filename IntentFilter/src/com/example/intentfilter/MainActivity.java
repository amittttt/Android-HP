package com.example.intentfilter;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	ListView lv;
	final String[] course = {"A","B","C","D"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.activity_list_item,course);
        setListAdapter(adapter);
        
    }

    protected void onListItemClick(ListView l, View v, int position, long id)
    {
    	Intent intent = new Intent("a");
    	Intent intent1 = new Intent("b");
    	Intent intent2 = new Intent("c");
    	Intent intent3 = new Intent("d");
    	startActivity(intent);
    	}
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
