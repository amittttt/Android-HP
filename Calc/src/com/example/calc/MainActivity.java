package com.example.calc;

import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	Button b1,b2,b3,b4,b5,b6,b7;
	TextView v1,v2,v3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        v1 = (TextView) findViewById(R.id.editText1);
        v2 = (TextView) findViewById(R.id.editText2);
        v3 = (TextView) findViewById(R.id.textView1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        
    }
    
   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==b1.getId())
    	{
    		int n1 = Integer.parseInt(v1.getText().toString());
    		int n2 = Integer.parseInt(v2.getText().toString());
    		int sum = n1+n2;
    		v3.setText(Integer.toString(sum));
    	}
		
	}
    

}

