package com.fontfont.appfontdemo;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;

public class ButtonDemoActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buttondemo);
		Typeface font = Typeface.createFromAsset(getAssets(),
				"fonts/BasicGothicMobiPro-BlackItalic.ttf");

		LinearLayout layout = (LinearLayout) findViewById(R.id.buttonDemoLayout);
		/*
		 * Recursively set all sublayouts of layout and their text
		 * based elements to our font. See TypefaceSetter.java
		 * for implementation details.
		 */
		TypefaceSetter.setTypeFace(layout, font);
	}
}
