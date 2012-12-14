package com.example.testuirenderxml;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabHostFragment extends Fragment 
	{

	
	private View view;

	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	    {
	    	Log.v("sumit","inside the fragment to host tab"+"pagelist size : "+RenderXml.ListPageT.size()+"grouplist size : "+RenderXml.ListGroupT.size());
	    	view=inflater.inflate(R.layout.tab_host_fragment, container, false);
	    	RenderXml.mTabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
	    	RenderXml.mTabHost.setup(getActivity().getApplicationContext(),RenderXml.fragmentManager, R.layout.tab_host_fragment);
	    	int isPageList=1;
	    	for(int i=0;i<RenderXml.ListPageT.size();i++)
	    	{
	    		
	    		Bundle arg=new Bundle();
	    		arg.putInt("List Index", i);
	    		arg.putInt("isPageList", isPageList);
	    		
	    		RenderXml.mTabHost.addTab(RenderXml.mTabHost.newTabSpec(RenderXml.ListPageT.get(i).getLabel()).setIndicator(RenderXml.ListPageT.get(i).getLabel()),
				ParentFragment.class, arg);
				Log.v("sumit","setup complete for the fragment to host tab"+"Number of pages is : "+RenderXml.ListPageT.size()+"present page is :"+i);
				
	    	}
	    	isPageList=0;
	    	for(int i=0;i<RenderXml.ListGroupT.size();i++)
	    	{
	    		Bundle arg=new Bundle();
	    		arg.putInt("List Index", i);
	    		arg.putInt("isPageList", isPageList);
	    		RenderXml.mTabHost.addTab(RenderXml.mTabHost.newTabSpec(RenderXml.ListGroupT.get(i).getLabel()).setIndicator(RenderXml.ListGroupT.get(i).getLabel()),
				ParentFragment.class,arg);
				Log.v("sumit","setup complete for the fragment to host tab");
	    	}
			return view;
	    }
	    
	}   
