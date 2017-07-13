package com.example.layout1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.sax.StartElementListener;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity  {
	RadioButton  r1,r2,r3,r4;
	RelativeLayout r;
	ToggleButton tb;
	TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=(RadioButton) findViewById(R.id.radio0);
        r2=(RadioButton) findViewById(R.id.radio2);
        r3=(RadioButton) findViewById(R.id.radio1);
        r4=(RadioButton) findViewById(R.id.radio3);
        r = (RelativeLayout) findViewById(R.id.r1);
        tb = (ToggleButton) findViewById(R.id.toggleButton1);
        t=(TextView) findViewById(R.id.textView2);
        tb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				if(tb.getText().toString().equals("Show"))
				{
					t.setTransformationMethod(PasswordTransformationMethod.getInstance());
				}
				if(tb.getText().toString().equals("Hide"))
				{
					t.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				}
			}
		});
    }
   
    public void Movetonext(View V)
    {
    	Intent intent =  new Intent(this,SecondActivity.class);
    	startActivity(intent);
    }
    public void Setcolor(View V)
    {
    	if(r1.isChecked())
    	{
    		Toast.makeText(MainActivity.this, r1.getText().toString(), Toast.LENGTH_LONG).show();
    		r.setBackgroundColor(Color.BLUE);
    	}
   
    
    	if(r2.isChecked())
    	{
    		Toast.makeText(MainActivity.this, r2.getText().toString(), Toast.LENGTH_LONG).show();
    		r.setBackgroundColor(Color.GREEN);
    	}
    	
    	if(r3.isChecked())
    	{
    		Toast.makeText(MainActivity.this, r2.getText().toString(), Toast.LENGTH_LONG).show();
    		r.setBackgroundColor(Color.RED);
    	}
    	
    	if(r4.isChecked())
    	{
    		Toast.makeText(MainActivity.this, r2.getText().toString(), Toast.LENGTH_LONG).show();
    		r.setBackgroundColor(Color.BLACK);
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
