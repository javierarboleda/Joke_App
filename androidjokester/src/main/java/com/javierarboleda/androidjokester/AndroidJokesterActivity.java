package com.javierarboleda.androidjokester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AndroidJokesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_jokester);
    }

    public void launchJokesterActivity(String joke) {
        Intent intent = new Intent(this, AndroidJokesterActivity.class);
        startActivity(intent);
    }
}
