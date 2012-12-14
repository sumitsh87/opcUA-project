package com.prosysopc.ua.android;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.opcfoundation.ua.builtintypes.DataValue;
import org.opcfoundation.ua.builtintypes.DateTime;
import org.opcfoundation.ua.builtintypes.DiagnosticInfo;
import org.opcfoundation.ua.builtintypes.ExpandedNodeId;
import org.opcfoundation.ua.builtintypes.ExtensionObject;
import org.opcfoundation.ua.builtintypes.NodeId;
import org.opcfoundation.ua.builtintypes.QualifiedName;
import org.opcfoundation.ua.builtintypes.StatusCode;
import org.opcfoundation.ua.builtintypes.UnsignedInteger;
import org.opcfoundation.ua.builtintypes.Variant;
import org.opcfoundation.ua.common.ServiceResultException;
import org.opcfoundation.ua.core.Attributes;
import org.opcfoundation.ua.core.DataChangeFilter;
import org.opcfoundation.ua.core.DataChangeTrigger;
import org.opcfoundation.ua.core.DeadbandType;
import org.opcfoundation.ua.core.ElementOperand;
import org.opcfoundation.ua.core.EventFilter;
import org.opcfoundation.ua.core.FilterOperator;
import org.opcfoundation.ua.core.Identifiers;
import org.opcfoundation.ua.core.LiteralOperand;
import org.opcfoundation.ua.core.MonitoringMode;
import org.opcfoundation.ua.core.NotificationData;
import org.opcfoundation.ua.core.ReferenceDescription;
import org.opcfoundation.ua.core.SimpleAttributeOperand;


import com.prosysopc.ua.ContentFilterBuilder;
import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.client.AddressSpaceException;
import com.prosysopc.ua.client.MonitoredDataItem;
import com.prosysopc.ua.client.MonitoredDataItemListener;
import com.prosysopc.ua.client.MonitoredEventItem;
import com.prosysopc.ua.client.MonitoredEventItemListener;
import com.prosysopc.ua.client.Subscription;
import com.prosysopc.ua.client.SubscriptionAliveListener;
import com.prosysopc.ua.client.SubscriptionNotificationListener;
import com.prosysopc.ua.client.UaClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ServerActivity extends Activity
{  
	    private Spinner spinner;
	    private CheckBox cb_ServerManual;
	    private EditText textServerName;
	    private RadioButton rb_rememberMe;
	    private Button bn_connect;
        private ArrayList<String> serverList;
        private ArrayAdapter<String> serverAdap;
        private String itemSelected;
        private String serverName;
        public Button bn_killApp;
        private void storePrivateData(ArrayList<String> serverList) 
        {
       
        	
        	try {
        		if(!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
        		    Toast.makeText(this, "External SD card not mounted", Toast.LENGTH_LONG).show();
    			File myFile = new File("/sdcard/mysdfile.txt");
    			FileOutputStream fOut = new FileOutputStream(myFile);
    			DataOutputStream out =new DataOutputStream(fOut);
    			Log.v("sumit", "size of list "+serverList.size());
    			for(int i=0;i<serverList.size();i++)
    			{
	    			 out.writeUTF(serverList.get(i));
	    			 Log.v("sumit", "written to internal memory successfully");
    			}
    			 out.close();
    			 fOut.close();
    			Toast.makeText(getBaseContext(), "Done writing SD 'mysdfile.tmp'",Toast.LENGTH_SHORT).show();
    		   }
        	 catch (Exception e) {
    			
        		 Log.v("sumit", "error writing"+e);
    	}
			
		}
        
        @SuppressWarnings("null")
		private void readServerNames(ArrayList<String> serverList, String fileName) throws IOException 
        {
        	
        	try
        	{
	        	FileInputStream fos = new FileInputStream("/sdcard/mysdfile.txt");
	        	Log.v("sumit","filestream created and file found");
			    DataInputStream inp = new DataInputStream(fos);
	        	Log.v("sumit","dataInputstream created"+inp.available());
	        	while(inp.available()>0)
		        {

		          String tmpString=inp.readUTF();
		          Log.v("sumit","server names : "+ tmpString);
		          serverList.add(tmpString);
		          Log.v("sumit","new available: "+ inp.available());

		        }
		    	
	    	    inp.close();
        	} 
        	catch (Exception e) 
        	{    
        		 Log.v("sumit", "error reading"+e);
	       		
        	}
        	
	    
        }
		public void onCreate(Bundle savedInstanceState) 
	    {  
			super.onCreate(savedInstanceState);
			setContentView(R.layout.server);
			Log.v("sumit","server activity created");
			textServerName=(EditText)findViewById(R.id.serverName);
			cb_ServerManual=(CheckBox)findViewById(R.id.checkBox);
			rb_rememberMe=(RadioButton)findViewById(R.id.rememberMe);
			bn_connect=(Button)findViewById(R.id.connect);
			spinner =(Spinner)findViewById(R.id.spinner);
			textServerName.setEnabled(false);
			rb_rememberMe.setEnabled(false);
			cb_ServerManual.setOnCheckedChangeListener(new OnCheckedChangeListener() 
			{  
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					
					if (isChecked)
		            {
		            	Log.v("sumit","check box enabled");
		            	textServerName.setEnabled(true);
		    			rb_rememberMe.setEnabled(true);
		    			spinner.setEnabled(false);

		            }
		            else
		            {
		            	textServerName.setEnabled(false);
		    			rb_rememberMe.setEnabled(false);
		    			spinner.setEnabled(true);
		            	Log.v("sumit","check box disabled");
		            	
		            }
					
				}

			
			}
			);
			Log.v("sumit","server activity layout created");
		    serverList = new ArrayList<String>();
		    serverList.add("opc.tcp://10.0.2.2:52520/OPCUA/SampleConsoleServer");
		    serverList.add("opc.tcp://127.0.0.1:52520/OPCUA/SampleConsoleServer");
		    serverList.add("opc.tcp://localhost:52520/OPCUA/SampleConsoleServer");
		   
		    try {
				Log.v("sumit","trying to read recently used server names");
				readServerNames(serverList,"serverFile");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.v("sumit","error trying to read recently used server"+e);
			}
		    
		    Log.v("sumit","server List created");
	        serverAdap=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,serverList);
	        serverAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(serverAdap);
	   	    spinner.setOnItemSelectedListener(new OnItemSelectedListener()
    	       {  	             
    	    		public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) 
	    	            {
	    	    		   itemSelected = spinner.getSelectedItem().toString();
	    	               Log.v("sumit","item selected : "+itemSelected);
	    	                 	             
	    	            }
    	    		public void onNothingSelected(AdapterView<?> arg0) 
    	    		{}

    	       });
	   	  
	   	   
	   	    bn_connect.setOnClickListener(new OnClickListener() 
	   	       {
				public void onClick(View v)
				{
					if (cb_ServerManual.isChecked())
					{
						serverName = textServerName.getText().toString();
						if (rb_rememberMe.isChecked())
					    serverList.add(serverName);
					}
					else if (!cb_ServerManual.isChecked())
						serverName=itemSelected;
					//serverName="opc.tcp://10.0.2.2:52520/OPCUA/SampleConsoleServer";
					ConnectAndReadTimeTask task = new ConnectAndReadTimeTask(ServerActivity.this, "DemoAppForAndroid");
	        		task.execute(serverName);
	        			
				}

				
			  });

        	    
        	    
         }
		
		public void onDestroy() 
	    {  
			 storePrivateData(serverList);
             Log.v("sumit","serve rlist"+serverList +"updated");
            
	    }
}     	 