package com.example.administrator.textcrash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickNullPointerException(View view) {

       throw new NullPointerException();
    }

    public void clickIndexOutOfBoundsException(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                throw new IndexOutOfBoundsException();
            }
        }).start();
    }

    public void clickANR(View view) {

    }

    public void clickStartActivity(View view) {
        Intent intent = new Intent(MainActivity.this, TextActivity.class);
        startActivity(intent);
    }
}
