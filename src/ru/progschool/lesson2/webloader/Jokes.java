package ru.progschool.lesson2.webloader;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import ru.progschool.lesson2.webloader.viewpagerJokes;

import java.security.InvalidParameterException;

public class Jokes extends ListView {
	private ArrayAdapter<String> test;
	String [] JokeItems= getResources().getStringArray(R.array.Jokes_Abyss);

  
	//If built programmatically
	public Jokes(Context context) {
		super(context);
		init();
	}
	 
	//This example uses this method since being built from XML
	public Jokes(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
  
	//Build from XML layout 
	public Jokes(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
  
	public void init() {
		test = new ArrayAdapter<String>(getContext(), R.layout.simple_item, R.id.textJoke , JokeItems);
		setAdapter(test);
		setOnItemClickListener(new ListSelection());
	}
 
	private class ListSelection implements OnItemClickListener {
 
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			/*AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
		   	builder.setMessage("You pressed item #" + (position+1));
		   	builder.setPositiveButton("OK", null);
		   	builder.show();
		   	/**/
	   
			Intent myIntent1 = new Intent(view.getContext(), viewpagerJokes.class);
			String joke = ((TextView) view.findViewById(R.id.textJoke)).getText().toString();
			myIntent1.putExtra("JOKE", joke);			
			myIntent1.putExtra("JOKES", JokeItems);
			view.getContext().startActivity(myIntent1);	   
		}
	}

	public void setAdapter(String[] jokes) {
		if (jokes == null) {
			throw new InvalidParameterException("Jokes list is null");
		}
		JokeItems = jokes;
		setAdapter(new ArrayAdapter<String>(getContext(), R.layout.simple_item, R.id.textJoke, jokes));
	}
}