package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Bai2 extends AppCompatActivity {

    WebView wv;
   // String url = "https://www.google.com";
    //String html = "<html><body><h1>Welcome to CD3.COM</h1></body></html>";

    private EditText addressBar;

    private WebView webView;
    private Button buttonGo;
    private ImageButton imageButtonDelete;
    private Button buttonStatic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //wv = (WebView) findViewById(R.id.webviewdemo);
        //wv.getSettings().setJavaScriptEnabled(true);
        //wv.loadUrl(url);
        //wv.loadData(html,"text/html","UTF-8");
        imageButtonDelete = (ImageButton) findViewById(R.id.imageButtonDelete);
        buttonGo = (Button) findViewById(R.id.button_go);
        buttonStatic = (Button) findViewById(R.id.button_static);

        addressBar = (EditText) findViewById(R.id.editText_addressBar);
        webView = (WebView) findViewById(R.id.webView);


        // Tùy biến WebViewClient để điều khiển các sự kiện trên WebView
        webView.setWebViewClient(new MyWebViewClient(addressBar));

        imageButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addressBar.setText("");
            }
        });
        buttonGo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                goUrl();
            }
        });

        buttonStatic.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStaticContent();
            }
        });
    }

    private void goUrl() {
        String url = addressBar.getText().toString().trim();
        if(!url.toString().contains("http"))
            url="http://"+url;
        if(url.isEmpty()) {
            Toast.makeText(this,"Please enter url", Toast.LENGTH_SHORT).show();
            return;
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }

    private void showStaticContent() {
        String staticContent="<h2>Select web page</h2>"
                +"<ul><li><a href='http://google.com'>Google</a></li>"
                +"<ul><li><a href='http://youtube.com'>Youtube</a></li>"  + "<li><a href='http://utehy.edu.vn/'>UTEHY</a></li>"
                + "<li><a href='http://fit.utehy.edu.vn/'>FIT</a></li>"
                + "<li><a href='http://dantri.com.vn/'>Dantri</a></li>"
                + "<li><a href='http://vnexpress.net/'>vnexpress</a></li>"
                + "<li><a href='http://www.24h.com.vn/'>24h</a></li>"
                + "<li><a href='https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier'>gmail</a></li>"
                +"<li><a href='http://fit.utehy.edu.vn/Intro.aspx?id=27'>Vanban</a></li></ul>";
        webView.loadData(staticContent, "text/html", "UTF-8");
    }
}

