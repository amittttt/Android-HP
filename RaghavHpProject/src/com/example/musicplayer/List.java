package com.example.musicplayer;

import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends Activity {
	ListView l;
	File[] filelist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		l=(ListView)findViewById(R.id.listView99);
		try{	File f=Environment.getExternalStorageDirectory();
		//File f=new File("/sdcard");
			if(f.isDirectory())
			{
		//
			filelist=f.listFiles(new xyz());
			String[] names = new String[filelist.length];
			String[] path = new String[filelist.length];
			for (int i = 0; i < filelist.length; i++) {
			   names[i] = filelist[i].getName();
			   path[i]=filelist[i].getPath();
			   Data.hm.put(names[i], path[i]);
			}
			ArrayList<String> list = new ArrayList<String>(Data.hm.keySet());
			ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
			l.setAdapter(a);
		}}catch(Exception E){}
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				String s=arg0.getItemAtPosition(arg2).toString();
				for(String d: Data.hm.keySet()){
					   if( s.equals(d))
					   {
						   Intent intent=new Intent(List.this,MainActivity.class);
						   intent.putExtra("file",Data.hm.get(s));
						   intent.putExtra("name", s);
						   setResult(104, intent);
								   finish();
					   }
					   
					}
				
			}
		});
	
	
	
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

}
class xyz implements FileFilter
{

	@Override
	public boolean accept(File arg0) {
		// TODO Auto-generated method stub
		if(arg0.getName().endsWith(".mp3"))
			return true;
		else
		return false;
	}
	
}