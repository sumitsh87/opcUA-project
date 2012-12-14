package com.example.testuirenderxml;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class RenderXml extends FragmentActivity
{
    public static FragmentManager fragmentManager;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_render_xml);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            BrowseMenuFragment firstFragment = new BrowseMenuFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());
            fragmentManager= getSupportFragmentManager();
            // Add the fragment to the 'fragment_container' FrameLayout
            fragmentManager.beginTransaction().add(R.id.fragment_container, firstFragment).commit();
            
         }
        else
        {
        	//BrowseMenuFragment firstFragment=(BrowseMenuFragment) getSupportFragmentManager().findFragmentById(R.id.browse_menu_fragment);
        }
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_render_xml, menu);
        return true;
    }
    
   
	
}
