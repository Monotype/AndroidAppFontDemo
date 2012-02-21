package com.fontfont.appfontdemo;


import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/*
 * Custom ArrayAdapter that takes a Typeface as constructor parameter
 * and sets that Typeface when constructing items
 * 
 */
public class IndividualFontsArrayAdapter<T> extends ArrayAdapter<T> {

	private Typeface[] fonts;
	
	/*
	 * Custom constructor that takes a font as additional parameter.
	 * You can implement additional constructors like that as variations
	 * of the other standard constructors.
	 */
	public IndividualFontsArrayAdapter(Context context, int textViewResourceId,
			T[] objects, Typeface[] menuFont) {
		super(context, textViewResourceId, objects);
		fonts = menuFont;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = super.getView(position, convertView, parent);
		if (fonts != null && TextView.class.isAssignableFrom(v.getClass()))
			((TextView) v).setTypeface(fonts[position]);
		return v;
	}

}