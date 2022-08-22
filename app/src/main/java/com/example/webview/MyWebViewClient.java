package com.example.webview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MyWebViewClient extends WebViewClient {
    private EditText addressBar;

    public MyWebViewClient(EditText addressBar) {
        this.addressBar= addressBar;
    }


    // Khi bạn click vào link bên trong trình duyệt (Webview)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        addressBar.setText(url);
        return super.shouldOverrideUrlLoading(view, url);
    }


    // Khi trang bắt đầu được tải
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }
    // Khi trang tải xong
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }
    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }
}


