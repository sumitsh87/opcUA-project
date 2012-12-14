package com.example.testuirenderxml;




import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TabHostFragment extends Fragment 
{

	private FragmentTabHost mTabHost;
	private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
    	Log.v("sumit","inside the fragment to host tab"+"pagelist size : "+BrowseMenuFragment.ListPageT.size()+"grouplist size : "+BrowseMenuFragment.ListGroupT.size());
    	view=inflater.inflate(R.layout.tab_host_fragment, container, false);
    	mTabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
    	mTabHost.setup(getActivity().getApplicationContext(), getActivity().getSupportFragmentManager(), R.id.tabcontent);
    	int isPageList=1;
    	for(int i=0;i<BrowseMenuFragment.ListPageT.size();i++)
    	{
    		
    		Bundle arg=new Bundle();
    		arg.putInt("List Index", i);
    		arg.putInt("isPageList", isPageList);
    		
    		mTabHost.addTab(mTabHost.newTabSpec(BrowseMenuFragment.ListPageT.get(i).getLabel()).setIndicator(BrowseMenuFragment.ListPageT.get(i).getLabel()),
			ParentFragment.class, arg);
			Log.v("sumit","setup complete for the fragment to host tab"+"Number of pages is : "+BrowseMenuFragment.ListPageT.size()+"present page is :"+i);
			//getActivity().getSupportFragmentManager().executePendingTransactions();
    	}
    	isPageList=0;
    	for(int i=0;i<BrowseMenuFragment.ListGroupT.size();i++)
    	{
    		Bundle arg=new Bundle();
    		arg.putInt("List Index", i);
    		arg.putInt("isPageList", isPageList);
    		mTabHost.addTab(mTabHost.newTabSpec(BrowseMenuFragment.ListGroupT.get(i).getLabel()).setIndicator(BrowseMenuFragment.ListGroupT.get(i).getLabel()),
			ParentFragment.class,arg);
			Log.v("sumit","setup complete for the fragment to host tab");
			//getActivity().getSupportFragmentManager().executePendingTransactions();
    	}
		return view;
    }
    
    

   

  
	
}
