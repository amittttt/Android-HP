package com.example.modifiydialoguebox;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	AlertDialog.Builder adb;
	Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button1);
       final String button[] = {"OK","CANCEL","DO NOTHING"};
    }
    
    public void move(View V)
    {
    	adb = new AlertDialog.Builder(this);
    	adb.setTitle("Alert !!!!");
    	adb.setItems("OK", new OnClickListener() 
    	{
			
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
    
}
