package com.example.testuirenderxml;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

public class TabHostFragment extends Fragment {

    private FragmentTabHost mTabHost;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
    	
    	View view=inflater.inflate(R.layout.tab_host_fragment, container, false);
    	mTabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
    
    
	//mTabHost = new FragmentTabHost(this.getActivity().getApplicationContext());
	//setContentView(mTabHost);
    	//mTabHost.setup();
	mTabHost.setup(this.getActivity().getApplicationContext(), getChildFragmentManager(), R.layout.tab_host_fragment);
	mTabHost.addTab(mTabHost.newTabSpec("ParentViewPagerFragment").setIndicator("View Pager"),
		ParentFragment.class, null);
	return view;
	
    }

  
}
