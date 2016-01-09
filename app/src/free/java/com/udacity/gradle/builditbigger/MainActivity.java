package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.JavaJokester;
import com.javierarboleda.androidjokester.AndroidJokesterActivity;

public class MainActivity extends ActionBarActivity implements EndpointsAsyncTask.AsyncCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJavaLibraryJoke(View view){

        String joke = JavaJokester.tellMeAJoke();

        Intent intent = new Intent(this, AndroidJokesterActivity.class);
        intent.putExtra(AndroidJokesterActivity.EXTRA_JOKE, joke);

        startActivity(intent);

    }

    public void tellGceModuleJoke(View view) {
        // TODO: 12/10/2015 finish this here method
        new EndpointsAsyncTask().execute(this);
    }


    @Override
    public void jokeDownloadedCallback(String joke) {

        Intent intent = new Intent(this, AndroidJokesterActivity.class);
        intent.putExtra(AndroidJokesterActivity.EXTRA_JOKE, joke);

        startActivity(intent);
    }

}
