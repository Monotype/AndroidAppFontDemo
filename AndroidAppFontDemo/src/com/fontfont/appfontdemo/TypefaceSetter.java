package com.fontfont.appfontdemo;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TypefaceSetter {

	/*
	 * Set Typeface recursively for all views inside a ViewGroup and in
	 * ViewGroups contained in it and so forth
	 */
	public static void setTypeFace(ViewGroup view, Typeface font) {
		View v;
		for (int i = 0; i < view.getChildCount(); i++) {
			v = view.getChildAt(i);
			if (TextView.class.isAssignableFrom(v.getClass()))
				((TextView) v).setTypeface(font);
			if (ViewGroup.class.isAssignableFrom(v.getClass()))
				setTypeFace((ViewGroup) v, font);
		}
	}
}
