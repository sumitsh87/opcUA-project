package com.example.testuirenderxml;


import java.util.ArrayList;
import java.util.List;

import org.fdi._2010.client.ActionT;
import org.fdi._2010.client.EnumerationItemListT;
import org.fdi._2010.client.EnumerationItemT;
import org.fdi._2010.client.GroupT;
import org.fdi._2010.client.HandlingT;
import org.fdi._2010.client.LayoutT;
import org.fdi._2010.client.PageT;
import org.fdi._2010.client.ParameterT;
import org.fdi._2010.client.UiTemplateT;

import ae.javax.xml.bind.JAXBElement;
import android.R.color;
import android.R.string;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class ArrayListFragment extends Fragment 
{
	ParameterT parameter;
	ActionT action;
	JAXBElement<?> groupSubItem;
	 RelativeLayout relativeLayout;
	 ViewGroup globalContainer;
    public static ArrayListFragment newInstance(Bundle args) 
    {
    	Log.v("sumit"," making a new fragment for the group inside viewpager");
		ArrayListFragment fragment = new ArrayListFragment();
    	Log.v("sumit"," created");

		fragment.setArguments(args);
		return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
    	
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
    {
		Log.v("sumit","creating layout for each group in each page of the viewpager");

		relativeLayout = new RelativeLayout(container.getContext());
          // Defining the RelativeLayout layout parameters.
	        // In this case I want to fill its parent
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
							                RelativeLayout.LayoutParams.MATCH_PARENT,
							                RelativeLayout.LayoutParams.MATCH_PARENT);
      
        globalContainer =container;
    	
      	Log.v("sumit","adding parameters and other views into the layout of each group");
		int listIndex=getArguments().getInt("List Index");
		int isPageList=getArguments().getInt("isPageList");
		int position = getArguments().getInt("POSITION_KEY");
		if(isPageList==1)
		{
			PageT pageObject=BrowseMenuFragment.ListPageT.get(listIndex);
			GroupT groupObject= (GroupT)(pageObject.getItemList().getWindowOrDialogOrPage().get(position).getValue());
			List<JAXBElement<?>> groupItemList=groupObject.getItemList().getWindowOrDialogOrPage();
			 
			for(int i=0;i< groupItemList.size();i++)
			{
			
				String groupSubType =groupItemList.get(i).getDeclaredType().toString();
				if(groupSubType.contentEquals(Constants.PARAMETER))
				{
					parameter=(ParameterT)groupItemList.get(i).getValue();
					renderParam(parameter);				
				}
				else if(groupSubType.contentEquals(Constants.ACTION))
				{
					action=(ActionT)groupItemList.get(i).getValue();
					renderButton(action);
				}
			}	
		}
		else
		{
			GroupT groupObject=BrowseMenuFragment.ListGroupT.get(listIndex);
			List<JAXBElement<?>> groupItemList=groupObject.getItemList().getWindowOrDialogOrPage();
			 
			for(int i=0;i<groupItemList.size();i++)
			{
			
				String groupSubType =groupItemList.get(i).getDeclaredType().toString();
				if(groupSubType.contentEquals(Constants.PARAMETER))
				{
					parameter=(ParameterT)groupSubItem.getValue();
					renderParam(parameter);				
				}
				else if(groupSubType.contentEquals(Constants.ACTION))
				{
					action=(ActionT)groupSubItem.getValue();
					renderButton(action);
				}
			}	
			
			
		}
		
		return relativeLayout;
		

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) 
    {
		
		
    }

    
    @SuppressLint("NewApi")
	private  void renderParam(ParameterT parameter)
	{
    	
      
        // Defining the LinearLayout layout parameters to fill the parent.
    	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
	
 
       
    	String paramName = parameter.getLabel();
		UiTemplateT uiTemplate=parameter.getUITemplate();
		HandlingT handling= parameter.getHandling();
		System.out.println("A simple EditText : "+paramName);
		
	
		final TextView tView = new TextView(globalContainer.getContext());
		tView.setBackgroundColor(color.white);
		tView.setTextColor(0xFF000000);
		tView.setTypeface(null, Typeface.BOLD);
		tView.setText(parameter.getLabel());
		tView.setGravity(Gravity.LEFT);
		//tView.setWidth();
		relativeLayout.addView(tView);
		
		if(uiTemplate==null)
		{
			
			
		   final EditText eText = new EditText(globalContainer.getContext());
		    eText.setBackgroundColor(color.white);
		    eText.setTextColor(0xFF000000);
		    eText.setTypeface(null, Typeface.BOLD);
		    eText.setText(parameter.getNodeId().toString());
		    eText.setHint(parameter.getHelp());
		    eText.setGravity(Gravity.RIGHT);
		    
		    if(parameter.getHandling().toString().contentEquals("ro"))
		    	eText.setEnabled(false);
		    else
		    	eText.setEnabled(true);
		
		    eText.setLayoutParams(lp);
			// Adding the views to the LinearLayout as a child
			//linearLayout.addView(eText);
			
		}
		else
		{
			System.out.println("A simple DropDown List : "+paramName);
			EnumerationItemListT enumList=uiTemplate.getEnumeration();
			List<EnumerationItemT> enumItems=enumList.getEnumerationItem();
			ArrayList<String> spinnerArray=new ArrayList<String>();
			for(int i=0;i<enumItems.size();i++)
			{
				spinnerArray.add(enumItems.get(i).getDescription().toString());
			}
			Spinner spinner = new Spinner(globalContainer.getContext());
			ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(globalContainer.getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerArray);
			spinner.setAdapter(spinnerArrayAdapter);
			spinner.setLayoutParams(lp);
			spinner.setBackgroundColor(color.white);
			spinner.setGravity(Gravity.RIGHT);
			//linearLayout.addView(spinner);
		}
	}
	
	private  void renderButton(ActionT action)
	{
		System.out.println("Button : "+action.getName());
	}
    
}

