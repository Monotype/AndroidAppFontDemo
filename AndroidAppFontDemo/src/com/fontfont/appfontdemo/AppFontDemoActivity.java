package com.fontfont.appfontdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class AppFontDemoActivity extends Activity {

	final String[] menuItems = { "Buttons", "Text views", "Available fonts", "Web View" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final boolean customTitleSupported = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main);
		ListView mainMenu = (ListView) findViewById(R.id.mainMenu);

		/*
		 * Load your typeface from assets
		 */
		Typeface font = Typeface.createFromAsset(getAssets(),
				"fonts/BasicGothicMobiPro-BlackItalic.ttf");

		/*
		 * Set custom title layout and typeface
		 */
		if (customTitleSupported) {
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
					R.layout.sampleheader);
			final TextView myTitleText = (TextView) findViewById(R.id.mainTitleText);
			myTitleText.setTypeface(font);
			myTitleText.setShadowLayer(3, 0, 0, Color.DKGRAY);
		}

		/*
		 * To assign our font to ListView menu entries, we have to implement a
		 * custom ArrayAdapter (CustomFontArrayAdapter)
		 */
		mainMenu.setAdapter(new CustomFontArrayAdapter<String>(this,
				R.layout.standard_list_item, menuItems, font));

		mainMenu.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					startDemo(ButtonDemoActivity.class);
					break;
				case 1:
					startDemo(TextViewDemoActivity.class);
					break;
				case 2:
					startDemo(FontListDemoActivity.class);
					break;
				case 3:
					startDemo(WebViewDemoActivity.class);
					break;
				}
			}
		});
	}

	private void startDemo(java.lang.Class<? extends Activity> demoClass) {
		startActivity(new Intent(AppFontDemoActivity.this, demoClass));
	}
}