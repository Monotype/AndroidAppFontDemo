package com.fontfont.appfontdemo;

import java.util.Vector;

import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;

/*
 *  Find and list all the fonts in "assets/fonts"
 *  as well as system font/style combinations
 */
public class FontListDemoActivity extends ListActivity {

	final String[] systemFontNames = { "Default", "Monospace", "Sans Serif",
			"Serif" };
	final Typeface[] systemFonts = { Typeface.DEFAULT, Typeface.MONOSPACE,
			Typeface.SANS_SERIF, Typeface.SERIF };
	final String[] styleNames = { "normal", "italic", "bold", "bold italic" };
	final int[] styles = { Typeface.NORMAL, Typeface.ITALIC, Typeface.BOLD,
			Typeface.BOLD_ITALIC };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Vector<Typeface> fonts = new Vector<Typeface>();
		Vector<String> fontnames = new Vector<String>();

		try {
			for (String filename : getAssets().list("fonts")) {
				fonts.add(Typeface.createFromAsset(getAssets(), "fonts/"
						+ filename));
				fontnames.add(filename.replace(".otf", "").replace(".ttf", ""));
			}
		} catch (Exception e) {
		}

		/*
		 * Add system fonts
		 */
		for (int i = 0; i < systemFonts.length; i++) {
			for (int j = 0; j < styles.length; j++) {
				Typeface font = Typeface.create(systemFonts[i], styles[j]);
				if (font.getStyle() == styles[j]) {
					fonts.add(font);
					fontnames.add(systemFontNames[i] + " " + styleNames[j]);
				}
			}
		}

		setListAdapter(new IndividualFontsArrayAdapter<String>(this,
				R.layout.standard_list_item,
				fontnames.toArray(new String[fontnames.size()]),
				fonts.toArray(new Typeface[fonts.size()])));

	}
}
