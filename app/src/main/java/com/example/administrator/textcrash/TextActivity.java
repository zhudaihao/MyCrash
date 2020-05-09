package com.example.administrator.textcrash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
    }

    public void black(View view) {
        finish();
    }

    public void test(View view) {
        Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
    }
}
