package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLbai1 extends AppCompatActivity {

    public TextView txtcontent;
    String url;
    Button btnread;
    //String html = "<html><body><h1>Welcome to CD3.COM</h1></body></html>";
    //String url=
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        if(Build.VERSION.SDK_INT>9){
           // ThreadPolicy policy=new ThreadPolicy().Builder.permitAll().build();
            //StrictMode.setThreadPolicy(policy);
        }
        btnread=findViewById(R.id.btnread);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // DocNoiDung()
            }
        });
    }
    private String DocNoiDung( String theurl){
        StringBuilder content=new StringBuilder();
        try{
            URL url=new URL(theurl);
            URLConnection  urlConnection=url.openConnection();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while((line=bufferedReader.readLine())!= null){
                content.append(line+"\n");
            }
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
            return content.toString();
    }
}