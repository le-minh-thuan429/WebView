package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btnNetworkStatus);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected())
                    Toast.makeText(MainActivity.this, "Mạng đã được kết nối", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Ko có mạng internet", Toast.LENGTH_LONG).show();
            }
        });
    }

    protected Boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Service.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null) {
                if (info.getState() == NetworkInfo.State.CONNECTED)
                    return true;
            }
        }
        return false;
    }
}

