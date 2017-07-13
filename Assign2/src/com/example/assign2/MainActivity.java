package com.example.assign2;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button login,signup;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
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
	
		
		if(v.getId()==login.getId())
		{
			
		}
		if(v.getId()==signup.getId())
		{
			Intent intent = new Intent(this,Signup.class);
			startActivity(intent);
		}
	}


	
}
