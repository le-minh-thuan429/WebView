package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Bai1 extends AppCompatActivity {

    WebView wv;
    String html = "<html><body><h1>Welcome to CD3.COM</h1></body></html>";
    String url = "https://www.google.com.vn";
    Button String,File,URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1y1);
        wv = (WebView) findViewById(R.id.webviewdemo);
        String=findViewById(R.id.LoadString);
        File=findViewById(R.id.Loadfile);
        URL=findViewById(R.id.LoadURL);

        String.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadString();
            }
        });
        File.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadFile();
            }
        });
        URL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadURL();
            }
        });
    }
    public void LoadString(){
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadData(html,"text/html","UTF-8");
    }
    public void LoadFile(){
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/_Layout.html");

    }
    public void LoadURL(){
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.setWebViewClient(new MyWebViewClient());
        wv.loadUrl(url);

    }
    public class MyWebViewClient extends WebViewClient {

        // Khi bạn click vào link bên trong trình duyệt (Webview)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;
        }
    }

    @Override
    public void onBackPressed() {
        if(wv!=null&& wv.canGoBack()){
            wv.canGoBack();
        }
        else {
            super.onBackPressed();
        }

    }
}