package com.javierarboleda.androidjokester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AndroidJokesterActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "com.javierarboleda.androidjokester.JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_jokester);
    }
}
