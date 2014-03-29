package ru.progschool.lesson2.webloader;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class viewpagerJokes extends ActionBarActivity implements OnClickListener {
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	String[] jokes;
	
	@Override
		protected void onCreate(Bundle savedInstanceState)   {

			super.onCreate(savedInstanceState);
			
		    // Получаем сообщение из объекта intent
		    setContentView(R.layout.viewpagerjokes);
		    
			// Create the adapter that will return a fragment for each of the three
			// primary sections of the activity.
			mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

			// Set up the ViewPager with the sections adapter.
			mViewPager = (ViewPager) findViewById(R.id.pager);
			// 1 item visible and 1 at the left and right 
			mViewPager.setOffscreenPageLimit(1);
						
		    // Получаем сообщение из объекта intent
		    Intent intent = getIntent();
		    String joke = intent.getStringExtra("JOKE");
		    jokes = intent.getStringArrayExtra("JOKES");
		    
/*		    TextView jokeText = (TextView) findViewById(R.id.JokeFullText);
		    jokeText.setText(joke);		   		    
		    TextView oldGood = (TextView) findViewById(R.id.textOldGood); // [:||||:]
		    oldGood.setOnClickListener(this);
*/		    
		    mViewPager.setAdapter(mSectionsPagerAdapter);
		}

		/* (non-Javadoc)
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.textOldGood:
		        Toast toast = Toast.makeText(getApplicationContext(), "[:||||:]", Toast.LENGTH_SHORT);
		        toast.show();
			}
		}
		
		/**
		 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
		 * one of the sections/tabs/pages.
		 */
		public class SectionsPagerAdapter extends FragmentPagerAdapter {

			public SectionsPagerAdapter(FragmentManager fm) {
				super(fm);
			}

			@Override
			public Fragment getItem(int position) {
				// getItem is called to instantiate the fragment for the given page.
				// Return a PlaceholderFragment (defined as a static inner class
				// below).
				return PlaceholderFragment.newInstance(jokes[position]);
			}

			@Override
			public int getCount() {
				return jokes.length;
			}
			
			/* (non-Javadoc)
			 * @see android.support.v4.app.FragmentPagerAdapter#destroyItem(android.view.ViewGroup, int, java.lang.Object)
			 */
			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				// TODO Auto-generated method stub
				super.destroyItem(container, position, object);
				Log.d("destroyItem event", "position="+Integer.toString(position));
			}
						
		}

		/**
		 * A placeholder fragment containing a simple view.
		 */
		public static class PlaceholderFragment extends Fragment {
			/**
			 * The fragment argument representing the section number for this
			 * fragment.
			 */
			private static final String ARG_SECTION_NUMBER = "section_number";
			private static final String ARG_SECTION_TEXT = "section_text";

			/**
			 * Returns a new instance of this fragment for the given section number.
			 */
			public static PlaceholderFragment newInstance(String itemText) {
				PlaceholderFragment fragment = new PlaceholderFragment();
				Bundle args = new Bundle();
				args.putString(ARG_SECTION_TEXT, itemText);
				fragment.setArguments(args);
				return fragment;
			}

			public PlaceholderFragment() {
			}

			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
				View rootView = inflater.inflate(R.layout.fragment, container, false);
				TextView textView = (TextView) rootView.findViewById(R.id.JokeFullText);
				textView.setText(getArguments().getString(ARG_SECTION_TEXT));
				return rootView;
			}
		}

}
