package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    ProgressBar pgbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
       pgbar= findViewById(R.id.pgbar);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url); // Load the URL in the WebView itself
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
        pgbar.setVisibility(View.GONE);
        super.onPageFinished(view,url);
            }
        });


        webView.loadUrl("https://openai.com/blog/chatgpt");
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
