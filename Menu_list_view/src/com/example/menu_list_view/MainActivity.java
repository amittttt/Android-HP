package com.example.menu_list_view;



import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView lv;
	String data[] = {"Core Java","Andriod","J2EEE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv;
        lv = (ListView) findViewById(R.id.listView1);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	// TODO Auto-generated method stub
    	super.onCreateContextMenu(menu, v, menuInfo);
    	getMenuInflater().inflate(R.menu.compositemenu, menu);
    	
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	//adapter se value select
    	AdapterContextMenuInfo info=(AdapterContextMenuInfo) item.getMenuInfo();
    	if(item.getTitle().equals("Class"))
    	{
    		Toast.makeText(this,data[(int)info.id], Toast.LENGTH_SHORT).show();
    	}
    	
    	if(item.getTitle().equals("Batch"))
    	{
    		Toast.makeText(this, data[(int)info.id], Toast.LENGTH_SHORT).show();
    	}
    	
    	if(item.getTitle().equals("Summertraining"))
    	{
    		Toast.makeText(this, data[(int)info.id], Toast.LENGTH_SHORT).show();
    	}
    	return super.onContextItemSelected(item);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
  
}