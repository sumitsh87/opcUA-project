package com.example.testuirenderxml;



import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.fdi._2010.client.AbortRequestT;
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
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


@TargetApi(11)
public class RenderXml extends FragmentActivity
{

	private static String choice;
	private static final String MENU="class org.fdi._2010.client.MenuT";
	private static final String WINDOW="class org.fdi._2010.client.WindowT";
	private static final String DIALOG="class org.fdi._2010.client.DialogT";
	private static final String PAGE="class org.fdi._2010.client.PageT";
	private static final String GROUP="class org.fdi._2010.client.GroupT";
	public static final String PARAMETER="class org.fdi._2010.client.ParameterT";
	public static final String ACTION="class org.fdi._2010.client.ActionT";
	private static final String TABLE="class org.fdi._2010.client.TableT";
	private static final String CHART="class org.fdi._2010.client.ChartT";
	private static final String GRAPH="class org.fdi._2010.client.GraphT";
	private static final String IMAGE="class org.fdi._2010.client.ImageT";
	private static final String TEXT="class org.fdi._2010.client.TextT";
	private static final String PLUGIN="class org.fdi._2010.client.PluginT";
	private static final String EDIT_DISPLAY="class org.fdi._2010.client.EditDisplayT";
	private static final String ROW_BREAK="RowBreak";
	private static final String COLUMN_BREAK="ColumnBreak";
	private static final String SEPARATOR="Separator";
	private  ArrayList<String> firstMenu=new ArrayList<String>();
	private  ArrayList<String> nextMenu=new ArrayList<String>();	
	private  List<Object> myList;
	private  ArrayAdapter<String> firstAdapter;
	private  ArrayAdapter<String> nextAdapter;
	private  ListView listView;
	private static boolean isfirstList=true;
	private LayoutT browseObject;
	private List<JAXBElement<?>> items;
	private LayoutItemsT itemList;
	private JAXBContext jc;
	private Unmarshaller unmarshaller;
	private FragmentTabHost mTabHost;
	private View view;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private MainFrameFragment mainFrameFragment;
	 static ArrayList<PageT> ListPageT=new ArrayList<PageT>() ;
	 static ArrayList<GroupT> ListGroupT=new ArrayList<GroupT>() ;

	
	
	public void generateFirstMenu() throws JAXBException, ae.javax.xml.bind.JAXBException
	{
	    Log.v("sumit","entering the firstmenu");
		jc = JAXBContext.newInstance("org.fdi._2010.client");

	    Log.v("sumit","JAXB context created");
		unmarshaller = jc.createUnmarshaller();

		//StreamSource vStreamSource = new StreamSource(new FileInputStream(testDataResource.getFile()));
		
		
	    Log.v("sumit","Unmarshaller created");
		InputSource inputXml=new InputSource(new StringReader(XmlString.xmlString));
	    Log.v("sumit","Input source being read");

		UidLayoutInformation myLayout=(UidLayoutInformation)unmarshaller.unmarshal(inputXml);
		  Log.v("sumit","unmarshalling done");
		myList=myLayout.getMenuOrPageOrGroup();
	
		if(!firstMenu.isEmpty())
			 firstMenu.clear();
		for(int i=0;i<myList.size();i++)
		{
			firstMenu.add(((LayoutObjectT)(myList.get(i))).getLabel());
						
		}
		
	    firstAdapter = new ArrayAdapter<String>(this,
		      	 android.R.layout.simple_list_item_1, firstMenu);
	    
	    
		listView.setAdapter(firstAdapter);
	
		listView.setOnItemClickListener(myListener);
		
	
	}
	
	
    @TargetApi(11)
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RuntimeInlineAnnotationReader.cachePackageAnnotation(AbortRequestT.class.getPackage(), new XmlSchemaMine("http://fdi.org/2010/client"));
		fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
	    mainFrameFragment=new MainFrameFragment();
		fragmentTransaction.add(R.id.list_fragment_container, mainFrameFragment, "HELLO");
		fragmentTransaction.commit();	
	
    }
    
		

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_render_xml, menu);
        return true;
    }
    
    void browse(LayoutT browseObj)
	{
    	browseObject=browseObj;
    	Log.v("sumit","2nd menu object is"+browseObject);
    	itemList=browseObj.getItemList();
	
		items=itemList.getWindowOrDialogOrPage();
		
		if(!nextMenu.isEmpty())
			nextMenu.clear();
		for(int i=0;i<items.size();i++)
		{	
			nextMenu.add(((LayoutT)(items.get(i).getValue())).getLabel());			
		}
		Log.v("sumit","2nd Menu updated, List :"+nextMenu);
		if(nextAdapter==null)
		{
			nextAdapter = new ArrayAdapter<String>(this,
			      	 android.R.layout.simple_list_item_1, nextMenu);
			listView.setAdapter(nextAdapter);
		}
		nextAdapter.notifyDataSetChanged();
		
				//		int ch=0;
				//		while(true)
				//		{
				//			try
				//			{
				//			    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				//			    choice = bufferRead.readLine();
				//		 	}
				//			catch(IOException e)
				//			{
				//				e.printStackTrace();
				//			}
				//			
				//			try
				//			{
				//				ch=Integer.parseInt(choice);
				//				if(ch>items.size())
				//				{
				//					System.out.println("The input is incorrect, Please enter again");
				//				}
				//			}
				//			catch(NumberFormatException e)
				//			{
				//				if(choice.equalsIgnoreCase("x"))
				//				{
				//					System.exit(0);					
				//				}
				//				System.out.println("The input should be a number, Please enter again");
				//			}
				//			if(ch==0)
				//			{
				//				if(browseObj.parentNode==null)
				//				{
				//					System.out.println("You are viewing the root node menu, Cannot go back Please enter again");
				//				}
				//				else
				//				{
				//					browse((LayoutT)(browseObj.parentNode));
				//				}
				//			}
				//			else
				//			{
				//				
				//			}
				//		}
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
	    		LayoutT browseMe=(LayoutT)(items.get(position).getValue());
	    		Log.v("sumit","item size : "+items.size()+"position is : "+position);
	    		JAXBElement<?> clickedElement=items.get(position);
				String elementType= clickedElement.getDeclaredType().toString();
				if(elementType.contentEquals(MENU))
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
					if(elementType.contentEquals(GROUP))
					{
						System.out.println("RENDERABLE!! I am a "+elementType);
						GroupT renderMe = (GroupT)(clickedElement.getValue());
						renderGroup(renderMe);
					}
					else if(elementType.contentEquals(PAGE))
					{
						
						PageT renderMe = (PageT)(clickedElement.getValue());
						renderPage(renderMe);
						
						
					}
					else if(elementType.contentEquals(WINDOW))
					{
						System.out.println("RENDERABLE!! I am a "+elementType);
						WindowT renderMe = (WindowT)(clickedElement.getValue());
						renderWindow(renderMe);
					}
					else if(elementType.contentEquals(DIALOG))
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
		 mTabHost.addTab(mTabHost.newTabSpec("ParentViewPagerFragment").setIndicator(page.getLabel()),
		    ParentFragment.class, null);
		Log.v("sumit","setup complete for the fragment to host tab");
		
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
			
			if(itemType.contentEquals(PAGE))
			{
				page=(PageT)item.getValue();
				//renderPage(page);
				ListPageT.add(page);
				Log.v("sumit","page added");
				
			}
			
			else if(itemType.contentEquals(GROUP))
			{
				group=(GroupT)item.getValue();
				ListGroupT.add(group);
				Log.v("sumit","Independent Group added");
			}
		
		}
		
		Log.v("sumit","Rendering Window : "+window.getLabel());
	    Log.v("sumit","new tab host view set up");
	    fragmentTransaction = fragmentManager.beginTransaction();
	    TabHostFragment tabFrag=new TabHostFragment();
	     if (this.findViewById(R.id.rendering_fragment_container) != null)
	    {
	    	fragmentTransaction.add(R.id.rendering_fragment_container,tabFrag);
	    }
	    else
	    {
	    	fragmentTransaction.replace(R.id.list_fragment_container,tabFrag);
	    }
		fragmentTransaction.commit();
		fragmentManager.executePendingTransactions();
		
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
			if(itemType.contentEquals(PARAMETER))
			{
				parameter=(ParameterT)item.getValue();
				renderParam(parameter);				
			}
			else if(itemType.contentEquals(ACTION))
			{
				action=(ActionT)item.getValue();
				renderButton(action);
			}
			else if(itemType.contentEquals(WINDOW))
			{
				window=(WindowT)item.getValue();
				renderWindow(window);
			}
			else if(itemType.contentEquals(PAGE))
			{
				page=(PageT)item.getValue();
				renderPage(page);
			}
			else if(itemType.contentEquals(DIALOG))
			{
				dialog=(DialogT)item.getValue();
				renderDialog(dialog);
			}
			else if(itemType.contentEquals(GROUP))
			{
				group=(GroupT)item.getValue();
				String objectType=thisObjectsList.getClass().toString();
				if(objectType.contentEquals(PAGE))
				{
					renderGroup(group);
				}
				else
				{
					renderGroup(group);
				}
				
				
				
			}
			else if(itemType.contentEquals(GRAPH))
			{
				graph=(GraphT)item.getValue();
				renderGraph(graph);
			}
			else if(itemType.contentEquals(CHART))
			{
				chart=(ChartT)item.getValue();
				renderChart(chart);
			}
			else if(itemType.contentEquals(TABLE))
			{
				table=(TableT)item.getValue();
				renderTable(table);
			}
			else if(itemType.contentEquals(IMAGE))
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
	
	
	public class MainFrameFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
		{
			/** Inflating the layout for this fragment **/
			 view = inflater.inflate(R.layout.activity_render_xml, null);
			 Log.v("sumit", "fragment setup intitially");
			listView = (ListView)view.findViewById(R.id.mainListView);
	       
			//RuntimeInlineAnnotationReader.cachePackageAnnotation(RenderXml.class.getPackage(), new XmlSchemaMine(""));
	        try {
				generateFirstMenu();
			}  
	        catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		       
		    return view;
		}
		
		
	}
	public class TabHostFragment extends Fragment 
	{

	 

	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	    {
	    	Log.v("sumit","inside the fragment to host tab"+"pagelist size : "+ListPageT.size()+"grouplist size : "+ListGroupT.size());
	    	view=inflater.inflate(R.layout.tab_host_fragment, container, false);
	    	mTabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
	    	mTabHost.setup(this.getActivity().getApplicationContext(), getSupportFragmentManager(), R.layout.tab_host_fragment);
	    	int isPageList=1;
	    	for(int i=0;i<ListPageT.size();i++)
	    	{
	    		
	    		Bundle arg=new Bundle();
	    		arg.putInt("List Index", i);
	    		arg.putInt("isPageList", isPageList);
	    		
	    		mTabHost.addTab(mTabHost.newTabSpec(ListPageT.get(i).getLabel()).setIndicator(ListPageT.get(i).getLabel()),
				ParentFragment.class, arg);
				Log.v("sumit","setup complete for the fragment to host tab"+"Number of pages is : "+ListPageT.size()+"present page is :"+i);
				
	    	}
	    	isPageList=0;
	    	for(int i=0;i<ListGroupT.size();i++)
	    	{
	    		Bundle arg=new Bundle();
	    		arg.putInt("List Index", i);
	    		arg.putInt("isPageList", isPageList);
	    		mTabHost.addTab(mTabHost.newTabSpec(ListGroupT.get(i).getLabel()).setIndicator(ListGroupT.get(i).getLabel()),
				ParentFragment.class,arg);
				Log.v("sumit","setup complete for the fragment to host tab");
	    	}
			return view;
	    }
	    
	    

	}

	
	

	

}



