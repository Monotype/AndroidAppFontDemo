package com.fontfont.appfontdemo;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewDemoActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewdemo);

		WebView mWebView = (WebView) findViewById(R.id.webview);
		mWebView.loadUrl("file:///android_asset/test.html");
	}
}
