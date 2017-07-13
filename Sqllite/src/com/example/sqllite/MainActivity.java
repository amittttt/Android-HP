package com.example.sqllite;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	SQLiteDatabase db;
	EditText fname,lname,add;
    Button binsert,bupdate,bsearch,bdelete;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = (EditText)findViewById(R.id.fname);
        lname = (EditText)findViewById(R.id.lname);
        add = (EditText)findViewById(R.id.add);
      binsert = (Button) findViewById(R.id.insert); 
       bupdate = (Button) findViewById(R.id.update);
        bsearch = (Button) findViewById(R.id.show);
        bdelete = (Button) findViewById(R.id.delete);
        
         db = openOrCreateDatabase("KIIT",MODE_PRIVATE,null);
        
        if(db!=null)
        {
        	Toast.makeText(this, "Database Created", Toast.LENGTH_LONG).show();
        }
    try
        {
        	db.execSQL("create table if not exists student (first_name varchar(23), last_name varchar(20),address varchar(150));");
        	Toast.makeText(this, "Table Created", Toast.LENGTH_LONG).show();		
        }
        catch (Exception e) {
			// TODO: handle exception
        	Toast.makeText(this, "Table Not Created", Toast.LENGTH_LONG).show();
		}
    }

	public void insertdata(View v)
	{
		String fn = fname.getText().toString().trim();
		String ln =  lname.getText().toString().trim();
		String ad =  add.getText().toString().trim();
		if(fn.length()==0||ln.length()==0||ad.length()==0)
		{
			Toast.makeText(this, "Insert Some Data", Toast.LENGTH_LONG).show();
		}
		else
		{
			try
			{
				 fn = fname.getText().toString().trim();
				 ln =  lname.getText().toString().trim();
				 ad =  add.getText().toString().trim();
				Toast.makeText(this, fn, Toast.LENGTH_SHORT).show();
				Toast.makeText(this, ln, Toast.LENGTH_SHORT).show();
				Toast.makeText(this, ad, Toast.LENGTH_SHORT).show();
			  db.execSQL("insert into student values ('"+fn+"','"+ln+"','"+ad+"')");
			Toast.makeText(this, "Data Insert Succesfully", Toast.LENGTH_SHORT).show();
			}
			catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(this, "Inseration Failed"+e, Toast.LENGTH_SHORT).show();
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
