package com.example.seekbarassgnmnt;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button b1;
	TextView tv;
	ProgressBar pb;
	//Thread th;
	int t=1,pbv=0;
	Boolean flag=false;
	Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        tv=(TextView) findViewById(R.id.textView1);
        
        pb=(ProgressBar) findViewById(R.id.progressBar1);
        pb.setMax(100);
          handler = new Handler()
        {
        public void handleMessage(android.os.Message msg) 
        {
        if(flag)
        {
        pbv++;
        if(pbv==100)
        {	flag=false;
        	handler.removeMessages(0);
        	// toast to show file downloaded
        	b1.setText("Start Downloading");
        }
        }
        pb.setProgress(pbv);
        if(pbv==100)
           tv.setText("File Downloaded");
        else
        	tv.setText("Downloading "+pbv+"%");
        
        handler.sendEmptyMessageDelayed(0, 100);
        }
        };
        handler.sendEmptyMessage(0);
      
    }
  
    

 public void Start(View v)
 {
	 if(t==1)
	 {
		 flag=true;
		 b1.setText("Stop Downloading");
		 t=2;
	 }
	 else
		 if(t==2)
	 {
		 flag=false;
		 pbv=0;
		 pb.setProgress(0);
		 b1.setText("Start Downloading");
		 t=1;
	 }
 }
 

 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
