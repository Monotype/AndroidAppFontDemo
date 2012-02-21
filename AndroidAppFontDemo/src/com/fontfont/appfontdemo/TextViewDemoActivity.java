package com.fontfont.appfontdemo;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextViewDemoActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textviewdemo);
		Typeface font = Typeface.createFromAsset(getAssets(),
				"fonts/BasicGothicMobiPro-BlackItalic.ttf");

		/*
		 * Because all elements with text are subclasses of TextView, we can
		 * easily iterate over all text children of the layout and assign our
		 * font
		 */
		LinearLayout layout = (LinearLayout) findViewById(R.id.sampleEditViews);
		View v;
		for (int i = 0; i < layout.getChildCount(); i++) {
			v = layout.getChildAt(i);
			if (TextView.class.isAssignableFrom(v.getClass()))
				((TextView) v).setTypeface(font);
		}
	}
}
