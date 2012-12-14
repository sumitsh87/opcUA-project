package com.prosysopc.ua.android;



import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ActionMenu extends Activity 
{
   
	Context myContext;
	   @Override
	    public void onCreate(Bundle savedInstanceState) 
		    {
    		   myContext= getApplicationContext();
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.main);
		       
		        
		    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu)
		    {
		    	 MenuInflater inflater = getMenuInflater();
		    	    inflater.inflate(R.menu.main, menu);
		    	    Log.v("sumit","inside create");
		    	    return true;
		    }
    
   
		@Override
	    public boolean onOptionsItemSelected(MenuItem item)
	    {
	    	
	    	if (item.getItemId() == R.id.topology) {
	            //startActivity(new Intent(this, CoursesActivity.class));
	            Log.v("sumit","Topology selected");
	           // invalidateOptionsMenu();
	        }
	        if (item.getItemId() == R.id.devices) {
	            //startActivity(new Intent(this, ScoresActivity.class));
	            Log.v("sumit","Devices selected");
	        }
	        if (item.getItemId() == R.id.server) {
	            //startActivity(new Intent(this, HandicapActivity.class));
	        	Log.v("sumit","Server selected");
	        	Intent intent = new Intent(myContext, ServerActivity.class);
	   	      	startActivity(intent);
	        	
	        	 
	        }
	
	        return super.onOptionsItemSelected(item);
	    }
	
	      public boolean writeToSDCard()
	      {
	    	  
	    	  
			return false;
	    	  
	      }
	    	
	    	
}

	  
