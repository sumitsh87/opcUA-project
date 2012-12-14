package com.example.testuirenderxml;

import org.fdi._2010.client.GroupT;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ParentFragment extends Fragment {
	private static ViewPager mViewPager;
    public static final String TAG = ParentFragment.class.getSimpleName();
    static int listIndex;
    static int isPageList;
    public static ParentFragment newInstance() {
	return new ParentFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
    {
    return inflater.inflate(R.layout.fragment_parent, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
	super.onViewCreated(view, savedInstanceState);
	Log.v("sumit","inside the parentFragment to create the viewpager ");
	listIndex=getArguments().getInt("List Index");
	isPageList=getArguments().getInt("isPageList");
	mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
	mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
    }
    public static class MyAdapter extends FragmentPagerAdapter {
	public MyAdapter(FragmentManager fm) {
	    super(fm);
	}

	@Override
	public int getCount() {
		int size=RenderXml.ListPageT.get(listIndex).getItemList().getWindowOrDialogOrPage().size();
		Log.v("sumit","inside getcount to send the number of groups to be added in the viewpager :"+size);
		if(isPageList==1)
	    return size;
		else
		return 1;// RenderXml.ListGroupT.get(listIndex).getItemList().getWindowOrDialogOrPage().size();
				
	}

	@Override
	public Fragment getItem(int position) 
	{
	
		Log.v("sumit","inside get item");
		Bundle args = new Bundle();
	    args.putInt("POSITION_KEY", position);
	    args.putInt("List Index",listIndex);
	    args.putInt("isPageList",isPageList);
		Log.v("sumit","argument created successfully");

		return ArrayListFragment.newInstance(args);
		
	}

	@Override
	public CharSequence getPageTitle(int position) 
	{
		if(isPageList==1)
			return((GroupT)RenderXml.ListPageT.get(listIndex).getItemList().getWindowOrDialogOrPage().get(position).getValue()).getLabel() ;
		else
			return RenderXml.ListGroupT.get(listIndex).getLabel() ;
	}

    }

}
