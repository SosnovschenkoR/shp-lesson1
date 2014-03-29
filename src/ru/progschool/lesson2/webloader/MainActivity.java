package ru.progschool.lesson2.webloader;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;


public class MainActivity extends Activity /*implements OnClickListener*/ implements OnTabChangeListener {

    private static Jokes jokesListView;
    private static ParseBashLink parser;
    
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
		webView.loadUrl("file:///android_asset/bash.htm"); // ������� #1
		//webView.loadUrl("http://bigwood.ru"); // ������� #2		
		/**/
				
		setContentView(R.layout.main);

        jokesListView = (Jokes) findViewById(R.id.custom_list);
        
		TabHost tabHost = (TabHost) findViewById(R.id.tabhost3);
		tabHost.setup();
        
        //tab creation
        TabHost.TabSpec spec;
        
        spec = tabHost.newTabSpec(getResources().getString(R.string.textAbyss));
        spec.setIndicator(getResources().getString(R.string.textAbyss));
        spec.setContent(R.id.custom_list);
        tabHost.addTab(spec);
       
        spec = tabHost.newTabSpec(getResources().getString(R.string.textBest)).setIndicator(getResources().getString(R.string.textBest)).setContent(R.id.custom_list);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec(getResources().getString(R.string.textRandom)).setIndicator(getResources().getString(R.string.textRandom)).setContent(R.id.custom_list);
        tabHost.addTab(spec);
        
        tabHost.setOnTabChangedListener(this);
        
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
	 * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
	 */
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		Log.d(this.getClass().getName(), ">>> tabId: " + tabId);
        String[] jokes = null;
        if (parser != null) {
        	parser.cancel(true);
        }
        if (tabId.equals(getResources().getString(R.string.textAbyss))) {
        	parser = new ParseBashLink();
        	parser.execute("http://bash.im/abyss");
            jokes = getResources().getStringArray(R.array.Jokes_Abyss);
        }
        if (tabId.equals(getResources().getString(R.string.textBest))) {
        	parser = new ParseBashLink();
        	parser.execute("http://bash.im/best");
            jokes = getResources().getStringArray(R.array.Jokes_Best);
        }
        if (tabId.equals(getResources().getString(R.string.textRandom))) {
        	parser = new ParseBashLink();
        	parser.execute("http://bash.im/random");
            jokes = getResources().getStringArray(R.array.Jokes_Random);
        }
        jokesListView.setAdapter(jokes);
	}	
		
	private class ParseBashLink extends AsyncTask<String, Void, Void> {
		protected Void doInBackground(String... urls) {			
			Document doc = null;
			try {
				doc = Jsoup.connect(urls[0]).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (doc != null) {
				Log.d(this.getClass().getName(), "PageTitle: " + doc.title());        	
	        	Elements jokesElements = doc.getElementsByClass("text");
	        	Elements ids = doc.getElementsByClass("id");
	        	//Elements dates = doc.select("span[class=abysstop-date]");
	        	
	        	
	        	if (jokesElements != null) {
	        		int i=0;
	        		for (Element joke : jokesElements) {
	        			if (isCancelled()) return null;
	        	        Log.d(this.getClass().getName(), "isCancelled: " + isCancelled());
	        	        Log.d(this.getClass().getName(), "joke["+i+"]: " + joke.text()+", id="+ids.get(i).text());	        	        
	        			i++;
	                }
	        		
	        	}
	        	
			}
			return null;
			
		}
		
		protected void onProgressUpdate(Void... progress) {
	         //setProgressPercent(progress[0]);
	    }
		
		protected void onPostExecute(Void result) {
			if (isCancelled()) {
				return;
			}
	         //showDialog("Downloaded " + result + " bytes");
	    }
	}
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
