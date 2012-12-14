package com.example.testuirenderxml;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.fdi._2010.client.ActionT;
import org.fdi._2010.client.ChartT;
import org.fdi._2010.client.DialogT;
import org.fdi._2010.client.EnumerationItemListT;
import org.fdi._2010.client.EnumerationItemT;
import org.fdi._2010.client.GraphT;
import org.fdi._2010.client.GridT;
import org.fdi._2010.client.GroupT;
import org.fdi._2010.client.HandlingT;
import org.fdi._2010.client.ImageT;
import org.fdi._2010.client.LayoutItemsT;
import org.fdi._2010.client.LayoutObjectT;
import org.fdi._2010.client.LayoutT;
import org.fdi._2010.client.PageT;
import org.fdi._2010.client.ParameterT;
import org.fdi._2010.client.PluginT;
import org.fdi._2010.client.TableT;
import org.fdi._2010.client.UiTemplateT;
import org.fdi._2010.client.UidLayoutInformation;
import org.fdi._2010.client.WindowT;
import org.xml.sax.InputSource;
import ae.com.sun.xml.bind.v2.model.annotation.RuntimeInlineAnnotationReader;
import ae.com.sun.xml.bind.v2.model.annotation.XmlSchemaMine;
import ae.javax.xml.bind.JAXBContext;
import ae.javax.xml.bind.JAXBElement;
import ae.javax.xml.bind.JAXBException;
import ae.javax.xml.bind.Unmarshaller;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BrowseMenuFragment extends Fragment {

	private static String choice;
	private  ArrayList<String> firstMenu=new ArrayList<String>();
	private  ArrayList<String> nextMenu=new ArrayList<String>();	
	private  List<Object> myList;
	private  ArrayAdapter<String> firstAdapter;
	private  ArrayAdapter<String> nextAdapter;
	private  ListView listView;
	private static boolean isfirstList=true;
	private LayoutT browseObject;
	private List<JAXBElement<?>> items;
	private JAXBContext jc;
	private Unmarshaller unmarshaller;
	private View v;

	private FragmentTransaction fragmentTransaction;
	public static ArrayList<PageT> ListPageT=new ArrayList<PageT>() ;
	public static ArrayList<GroupT> ListGroupT=new ArrayList<GroupT>() ;

	
	public void generateFirstMenu() throws JAXBException
	{
	   
		jc = JAXBContext.newInstance("org.fdi._2010.client");
		unmarshaller = jc.createUnmarshaller();
		
		InputSource xmlString = new InputSource(new StringReader(XmlString.xmlString));
		UidLayoutInformation myLayout=(UidLayoutInformation)unmarshaller.unmarshal(xmlString);
		RuntimeInlineAnnotationReader.cachePackageAnnotation(LayoutT.class.getPackage(), new XmlSchemaMine("http://fdi.org/2010/client"));
		
		myList=myLayout.getMenuOrPageOrGroup();
	
		if(!firstMenu.isEmpty())
			 firstMenu.clear();
		for(int i=0;i<myList.size();i++)
		{
			firstMenu.add(((LayoutObjectT)(myList.get(i))).getLabel());
						
		}
		
		// We need to use a different list item layout for devices older than Honeycomb
		
		int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        firstAdapter = new ArrayAdapter<String>(getActivity(),layout, firstMenu);
        
		listView.setAdapter(firstAdapter);
	
		listView.setOnItemClickListener(myListener);
		
	
	}
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        RuntimeInlineAnnotationReader.cachePackageAnnotation(WindowT.class.getPackage(), new XmlSchemaMine("http://fdi.org/2010/client"));
        
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            //mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
    	v= inflater.inflate(R.layout.menu_fragment_layout, null);
        listView = (ListView)v.findViewById(R.id.mainListView);
        
        try {
			generateFirstMenu();
		}  
        catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return v;
    }
	
    @Override
    public void onStart() {
        super.onStart();

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)
        //window_container will exist only in the two pane layout
        if (getActivity().findViewById(R.id.window_container) != null) {
            listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }
    
    
    void browse(LayoutT browseObj)
   	{
       	browseObject=browseObj;
       	LayoutItemsT itemList;
   		itemList=browseObj.getItemList();
   		items=itemList.getWindowOrDialogOrPage();
   		System.out.println("Please select one of the following :-");
   		if(!nextMenu.isEmpty())
   			nextMenu.clear();
   		for(int i=0;i<items.size();i++)
   		{	
   			nextMenu.add(((LayoutT)(items.get(i).getValue())).getLabel());			
   		}
   	
   		if(nextAdapter==null)
   		{
   			// We need to use a different list item layout for devices older than Honeycomb
   			
   			int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
   	                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
   			
   			nextAdapter = new ArrayAdapter<String>(getActivity(),layout, nextMenu);
   			listView.setAdapter(nextAdapter);
   		}
   		nextAdapter.notifyDataSetChanged();
   		
   	}
       
       
   	
   	
   	

    private  void renderGroup(GroupT group)
	{
		//View view1=mTabHost.getTabWidget().findViewWithTag(group.get);
		
		System.out.println("\n	Rendering Group : "+ group.getLabel());
		GroupT.ItemList groupItemList=group.getItemList();
		List<JAXBElement<?>> groupItems=groupItemList.getWindowOrDialogOrPage();
		callAptRenderMethod(groupItems,group);
	}
	
	private void renderPage(PageT page)
	{ 
		
		Log.v("sumit","trying to render page, but no tab added");
//		 mTabHost.addTab(mTabHost.newTabSpec("ParentViewPagerFragment").setIndicator(page.getLabel()),
//		    ParentFragment.class, null);
//		Log.v("sumit","setup complete for the fragment to host tab");
		
	}
	
	private void renderWindow(WindowT window)
	{
				
		WindowT.ItemList windowItemList=window.getItemList();
		List<JAXBElement<?>> windowItems=windowItemList.getWindowOrDialogOrPage();
		JAXBElement<?> item;
		String itemType;
		WindowT windows;
		PageT page;
		GroupT group;
		DialogT dialog;
		for(int i=0;i<windowItems.size();i++)
		{
			
			item=windowItems.get(i);
			itemType=item.getDeclaredType().toString();
			
			if(itemType.contentEquals(Constants.PAGE))
			{
				page=(PageT)item.getValue();
				//renderPage(page);
				ListPageT.add(page);
				Log.v("sumit","page added");
				
			}
			
			else if(itemType.contentEquals(Constants.GROUP))
			{
				group=(GroupT)item.getValue();
				ListGroupT.add(group);
				Log.v("sumit","Independent Group added");
			}
		
		}
		
		Log.v("sumit","Rendering Window : "+window.getLabel());
	    Log.v("sumit","new tab host view set up");
	    
	    
	    fragmentTransaction = RenderXml.fragmentManager.beginTransaction();
	    TabHostFragment tabFrag=new TabHostFragment();
	    if (getActivity().findViewById(R.id.window_container) != null)
	    {
	    	//fragmentTransaction.add(R.id.window_container,tabFrag);
	    }
	    else
	    {
	    	fragmentTransaction.replace(R.id.fragment_container,tabFrag);
	    }
		fragmentTransaction.commit();
		RenderXml.fragmentManager.executePendingTransactions();
		
		
	}
	

	private void renderDialog(DialogT dialog)
	{
		System.out.println("\n	Rendering Dialog : "+dialog.getLabel());
		DialogT.ItemList dialogItemList=dialog.getItemList();
		List<JAXBElement<?>> dialogItems=dialogItemList.getWindowOrDialogOrPage();
		callAptRenderMethod(dialogItems,dialog);
		
	}
	
	private  void callAptRenderMethod(List<JAXBElement<?>> items, LayoutT thisObjectsList)
	{
		JAXBElement<?> item;
		String itemType;
		ParameterT parameter;
		ActionT action;
		WindowT window;
		PageT page;
		GroupT group;
		DialogT dialog;
		TableT table;
		ChartT chart;
		GraphT graph;
		GridT grid;
		ImageT image;
		PluginT plugin;
		
		
		for(int i=0;i<items.size();i++)
		{
			item=items.get(i);
			itemType=item.getDeclaredType().toString();
			if(itemType.contentEquals(Constants.PARAMETER))
			{
				parameter=(ParameterT)item.getValue();
				renderParam(parameter);				
			}
			else if(itemType.contentEquals(Constants.ACTION))
			{
				action=(ActionT)item.getValue();
				renderButton(action);
			}
			else if(itemType.contentEquals(Constants.WINDOW))
			{
				window=(WindowT)item.getValue();
				renderWindow(window);
			}
			else if(itemType.contentEquals(Constants.PAGE))
			{
				page=(PageT)item.getValue();
				renderPage(page);
			}
			else if(itemType.contentEquals(Constants.DIALOG))
			{
				dialog=(DialogT)item.getValue();
				renderDialog(dialog);
			}
			else if(itemType.contentEquals(Constants.GROUP))
			{
				group=(GroupT)item.getValue();
				String objectType=thisObjectsList.getClass().toString();
				if(objectType.contentEquals(Constants.PAGE))
				{
					renderGroup(group);
				}
				else
				{
					renderGroup(group);
				}
				
				
				
			}
			else if(itemType.contentEquals(Constants.GRAPH))
			{
				graph=(GraphT)item.getValue();
				renderGraph(graph);
			}
			else if(itemType.contentEquals(Constants.CHART))
			{
				chart=(ChartT)item.getValue();
				renderChart(chart);
			}
			else if(itemType.contentEquals(Constants.TABLE))
			{
				table=(TableT)item.getValue();
				renderTable(table);
			}
			else if(itemType.contentEquals(Constants.IMAGE))
			{
				image=(ImageT)item.getValue();
				renderImage(image);
			}
			
		}
	}
	
	private static void renderParam(ParameterT parameter)
	{
		String paramName = parameter.getLabel();
		UiTemplateT uiTemplate=parameter.getUITemplate();
		HandlingT handling= parameter.getHandling();
		if(uiTemplate==null)
		{
			System.out.println("A simple EditText : "+paramName);
		}
		else
		{
			System.out.println("A simple DropDown List : "+paramName);
			EnumerationItemListT enumList=uiTemplate.getEnumeration();
			List<EnumerationItemT> enumItems=enumList.getEnumerationItem();
			for(int i=0;i<enumItems.size();i++)
			{
				
			}
		}
	}
	
	private static void renderButton(ActionT action)
	{
		System.out.println("Button : "+action.getName());
	}
	
	private static void renderGraph(GraphT graph)
	{
		System.out.println("Graph : "+graph.getLabel());
	}
	
	private static void renderChart(ChartT chart)
	{
		System.out.println("Chart : "+chart.getLabel());
	}
	
	private static void renderImage(ImageT image)
	{
		System.out.println("Image : "+image.getLabel());
	}
	
	private static void renderGrid(GridT grid)
	{
		System.out.println("Grid");
	}
	
	private static void renderTable(TableT table)
	{
		System.out.println("Table : "+table.getLabel());
	}
	
	
    
    OnItemClickListener myListener= new OnItemClickListener() 
	{
	    @Override
	    public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) 
	    {
	    	
	    	if(isfirstList)
	    	{
	    		LayoutT browseMe=(LayoutT)(myList.get(position));
	    		browseMe.parentNode=null;
				isfirstList=false;
				browse(browseMe);
	    	}
	    	else
	    	{	
	    		JAXBElement<?> clickedElement=items.get(position);
				String elementType= clickedElement.getDeclaredType().toString();
				if(elementType.contentEquals(Constants.MENU))
				{
					LayoutT browseChild=(LayoutT)(clickedElement.getValue());
					if(browseChild.parentNode==null)
					{
						browseChild.parentNode=browseObject;
					}
					browse(browseChild);
				}
				else 
				{
		//					TabHostFragment renderedFrag = (TabHostFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.rendered_fragment);
		//
		//			        if (renderedFrag != null) {
		//			            // If article frag is available, we're in two-pane layout...
		//
		//			            // Call a method in the ArticleFragment to update its content
		//			        	Log.v("Soup","Two Pane Layout New Render Window");
		//
		//			        } else {
		//			            // If the frag is not available, we're in the one-pane layout and must swap frags...
		//
		//			            // Create fragment and give it an argument for the selected article
		//			        	TabHostFragment newFragment = (TabHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.rendered_fragment);
		//			            Bundle args = new Bundle();
		//			            //args.putInt(ArticleFragment.ARG_POSITION, position);
		//			            newFragment.setArguments(args);
		//			            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
		//
		//			            // Replace whatever is in the fragment_container view with this fragment,
		//			            // and add the transaction to the back stack so the user can navigate back
		//			            transaction.replace(R.id.fragment_container, newFragment);
		//			            transaction.addToBackStack(null);
		//
		//			            // Commit the transaction
		//			            transaction.commit();
		//			        }
					if(elementType.contentEquals(Constants.GROUP))
					{
						System.out.println("RENDERABLE!! I am a "+elementType);
						GroupT renderMe = (GroupT)(clickedElement.getValue());
						renderGroup(renderMe);
					}
					else if(elementType.contentEquals(Constants.PAGE))
					{
						System.out.println("RENDERABLE!! I am a "+elementType);
						PageT renderMe = (PageT)(clickedElement.getValue());
						renderPage(renderMe);
					}
					else if(elementType.contentEquals(Constants.WINDOW))
					{
						System.out.println("RENDERABLE!! I am a "+elementType);
						WindowT renderMe = (WindowT)(clickedElement.getValue());
						renderWindow(renderMe);
					}
					else if(elementType.contentEquals(Constants.DIALOG))
					{
						System.out.println("RENDERABLE!! I am a "+elementType);
						DialogT renderMe = (DialogT)(clickedElement.getValue());
						renderDialog(renderMe);
					}
					System.out.println("Cannot browse deeper, Enter 0 and go back");
				}
	    	}
	   	}	
	    
	};
	
}
