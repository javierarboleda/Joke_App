package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.javierarboleda.androidjokester.AndroidJokesterActivity;
import com.example.JavaJokester;

public class MainActivity extends ActionBarActivity {

    private Button mGceJokeButton;
    private Button mJavaJokeButton;
    private ProgressBar mSpinner;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGceJokeButton = (Button) findViewById(R.id.gce_joke_button);
        mJavaJokeButton = (Button) findViewById(R.id.java_jokester_button);

        mSpinner = (ProgressBar) findViewById(R.id.progressBar1);
        mSpinner.setVisibility(View.GONE);
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

        mGceJokeButton.setEnabled(false);
        mJavaJokeButton.setEnabled(false);

        mSpinner.setVisibility(View.VISIBLE);

        mIntent = new Intent(this, AndroidJokesterActivity.class);

        new EndpointsAsyncTask().execute(new JokeDownloadedCallback() {
            @Override
            public void jokeDownloaded(String joke) {
                mIntent.putExtra(AndroidJokesterActivity.EXTRA_JOKE, joke);

                mSpinner.setVisibility(View.GONE);

                startActivity(mIntent);

                mGceJokeButton.setEnabled(true);
                mJavaJokeButton.setEnabled(true);
            }
        });
    }


//    @Override
//    public void jokeDownloadedCallback(String joke) {
//
//        Intent intent = new Intent(this, AndroidJokesterActivity.class);
//        intent.putExtra(AndroidJokesterActivity.EXTRA_JOKE, joke);
//
//        mSpinner.setVisibility(View.GONE);
//
//        startActivity(intent);
//
//        mGceJokeButton.setEnabled(true);
//        mJavaJokeButton.setEnabled(true);
//    }

}
