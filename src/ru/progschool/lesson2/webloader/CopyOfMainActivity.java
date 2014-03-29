package ru.progschool.lesson2.webloader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TextView;


public class CopyOfMainActivity extends Activity/*Activity implements OnClickListener*/{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*setContentView(R.layout.activity_main);
		Button btn = (Button) findViewById(R.id.btnAbyss);
		btn.setOnClickListener(this);
		btn = (Button) findViewById(R.id.btnRandom);
		btn.setOnClickListener(this);
		btn = (Button) findViewById(R.id.btnBest);
		btn.setOnClickListener(this);
		
		webView = (WebView) findViewById(R.id.webView);		
		webView.loadUrl("file:///android_asset/bash.htm"); // вариант #1
		//webView.loadUrl("http://bigwood.ru"); // вариант #2		
		/**/
				
		setContentView(R.layout.main);
		
		TabHost tabHost = (TabHost) findViewById(R.id.tabhost3);
		
		tabHost.setup();
		
		/*TabHost.TabSpec rssListSpec = tabHost.newTabSpec("RSS list");
        rssListSpec.setIndicator("RSS List");
        rssListSpec.setContent(R.id.rssListLayout);             
		
        TabHost.TabSpec rssOutputSpec = tabHost.newTabSpec("Feed");
        rssOutputSpec.setIndicator("Feed");
        rssOutputSpec.setContent(R.id.rssOutputLayout);
        
        TabHost.TabSpec settingsLayoutSpec = tabHost.newTabSpec("Settings");
        settingsLayoutSpec.setIndicator("Settings");
        settingsLayoutSpec.setContent(R.id.settingsLayout);
        
        tabHost.addTab(rssListSpec);
        tabHost.addTab(rssOutputSpec);
        tabHost.addTab(settingsLayoutSpec);
        /**/
        
        //tab creation
        TabHost.TabSpec spec;
        spec = tabHost.newTabSpec("Tab 1 Tag");
        spec.setIndicator("Tab 1");
        spec.setContent(R.id.custom_list);
        tabHost.addTab(spec);
       
        spec = tabHost.newTabSpec("Tab 2 Tag").setIndicator("Tab 2").setContent(R.id.custom_list);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(1);
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
	        TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
	        tv.setTextSize(10);
	    }
	    /**/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/* (non-Javadoc)
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
//	@Override
//	protected void onListItemClick(ListView l, View v, int position, long id) {
//		// TODO Auto-generated method stub
//		super.onListItemClick(l, v, position, id);
//	
//		int duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(getApplicationContext(), "OnItemClick", duration);
//        toast.show();		
//	}
	

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	/*@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btnAbyss:
			webView.loadUrl("http://bash.im/abyss");	
			break;
			
		case R.id.btnRandom:
			webView.loadUrl("http://bash.im/random"); 
			break;
			
		case R.id.btnBest:
			webView.loadUrl("http://bash.im/best"); 
			break;
		default:
			break;
		} 
		
	}
	/**/
	

}
