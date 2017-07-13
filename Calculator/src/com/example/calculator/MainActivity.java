package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	TextView tv,tv1;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bsub,bmul,bdiv,bequal,bmod,bclear,bopen,bclose,bdecimal;
	float num1,num2;
	boolean Addition , Subtract ,Multiplication ,Division ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.button13);
        b2= (Button) findViewById(R.id.button16);
        b3= (Button) findViewById(R.id.button17);
        b4= (Button) findViewById(R.id.button9);
        b5= (Button) findViewById(R.id.button10);
        b6= (Button) findViewById(R.id.button7);
        b7= (Button) findViewById(R.id.button1);
        b8= (Button) findViewById(R.id.button2);
        b9= (Button) findViewById(R.id.button3);
        b0=(Button) findViewById(R.id.button14);
        badd=(Button) findViewById(R.id.button12);
        bsub=(Button) findViewById(R.id.button22);
        bmul=(Button) findViewById(R.id.button8);
        bdiv=(Button) findViewById(R.id.button4);
        bequal=(Button) findViewById(R.id.button5);
        bmod=(Button) findViewById(R.id.button6);
        bclear=(Button) findViewById(R.id.button18);
        bopen=(Button) findViewById(R.id.button11);
        bclose=(Button) findViewById(R.id.button15);
        bdecimal=(Button) findViewById(R.id.button20);
        tv = (TextView) findViewById(R.id.textView1);
        
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        badd.setOnClickListener(this);
        bsub.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bequal.setOnClickListener(this);
        bmod.setOnClickListener(this);
        bclear.setOnClickListener(this);
        bopen.setOnClickListener(this);
        bclose.setOnClickListener(this);
        bdecimal.setOnClickListener(this);
       
    }

    @Override
	public void onClick(View v)
    {
    	if(v.getId()==b1.getId())
    	{
    		  tv.setText(tv.getText()+"1");
    	}
    	if(v.getId()==b2.getId())
    	{
    		  tv.setText(tv.getText()+"2");
    	}
    	if(v.getId()==b3.getId())
    	{
    		  tv.setText(tv.getText()+"3");
    	}
    	if(v.getId()==b4.getId())
    	{
    		  tv.setText(tv.getText()+"4");
    	}
    	if(v.getId()==b5.getId())
    	{
    		  tv.setText(tv.getText()+"5");
    	}
    	if(v.getId()==b6.getId())
    	{
    		  tv.setText(tv.getText()+"6");
    	}
    	if(v.getId()==b7.getId())
    	{
    		  tv.setText(tv.getText()+"7");
    	}
    	if(v.getId()==b8.getId())
    	{
    		  tv.setText(tv.getText()+"8");
    	}
    	if(v.getId()==b9.getId())
    	{
    		  tv.setText(tv.getText()+"9");
    	}
    	if(v.getId()==b0.getId())
    	{
    		  tv.setText(tv.getText()+"0");
    	}
    	if(v.getId()==bopen.getId())
    	{
    		tv.setText(tv.getText()+"(");
    	}
    	if(v.getId()==bclose.getId())
    	{
    		tv.setText(tv.getText()+")");
    	}
    	if(v.getId()==bmod.getId())
    	{
    		tv.setText(tv.getText()+"%");
    	}
    	if(v.getId()==bclear.getId())
    	{
    		tv.setText("");
    	}
    	
    	/*if(v.getId()==badd.getId())
    	{
    		tv.setText(tv.getText()+"+");
    	}
    	if(v.getId()==bsub.getId())
    	{
    		tv.setText(tv.getText()+"-");
    	}
    	if(v.getId()==bmul.getId())
    	{
    		tv.setText(tv.getText()+"*");
    	}
    	if(v.getId()==bdiv.getId())
    	{
    		tv.setText(tv.getText()+"/");
    	}*/
    	if(v.getId()==bdecimal.getId())
    	{
    		tv.setText(tv.getText()+".");
    	}
    	if(v.getId()==badd.getId())
    	{
    		if(tv==null)
    		{
    			tv.setText("");
    		}
    		else
    		{
    			
    			num1=Float.parseFloat(tv.getText()+"");
    			Addition = true;
    			tv.setText(null);
    		}
    	}
    	
    	if(v.getId()==bsub.getId())
    	{
    		if(tv==null)
    		{
    			tv.setText("");
    		}
    		else
    		{
    			
    			num1=Float.parseFloat(tv.getText()+"");
    			Subtract = true;
    			tv.setText(null);
    		}
    	}
    	
    	if(v.getId()==bmul.getId())
    	{
    		if(tv==null)
    		{
    			tv.setText("");
    		}
    		else
    		{
    			
    			num1=Float.parseFloat(tv.getText()+"");
    			Multiplication = true;
    			tv.setText(null);
    		}
    	}
    	
    	if(v.getId()==bdiv.getId())
    	{
    		if(tv==null)
    		{
    			tv.setText("");
    		}
    		else
    		{
    			
    			num1=Float.parseFloat(tv.getText()+"");
    			Division = true;
    			tv.setText(null);
    		}
    	}
    	
    	if(v.getId()==bequal.getId())
    	{
    		num2 = Float.parseFloat(tv.getText()+"");
    		if(Addition==true)
    		{
    			tv.setText(num1+num2+"");
    			Addition = false;
    		}
    		
    		if(Subtract==true)
    		{
    			tv.setText(num1-num2+"");
    			Subtract = false;
    		}
    		if(Multiplication==true)
    		{
    			tv.setText(num1*num2+"");
    			Multiplication = false;
    		}
    		if(Division==true)
    		{
    			tv.setText(num1/num2+"");
    			Division = false;
    		}
    	}
    	
    	
    }


    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	
    
}
