package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.JavaJokester;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.javierarboleda.androidjokester.AndroidJokesterActivity;

public class MainActivity extends ActionBarActivity {

    private Button mGceJokeButton;
    private Button mJavaJokeButton;
    private InterstitialAd mInterstitialAd;
    private Intent mIntent;
    private ProgressBar mSpinner;

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

        mIntent = intent;

        mGceJokeButton.setEnabled(false);
        mJavaJokeButton.setEnabled(false);

        loadInterstitialAd();
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

                loadInterstitialAd();

            }
        });
    }


//    @Override
//    public void jokeDownloadedCallback(String joke) {
//
//        Intent intent = new Intent(this, AndroidJokesterActivity.class);
//        intent.putExtra(AndroidJokesterActivity.EXTRA_JOKE, joke);
//
//        mIntent = intent;
//
//        loadInterstitialAd();
//    }

    public void loadInterstitialAd() {

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                mSpinner.setVisibility(View.GONE);
                mJavaJokeButton.setEnabled(true);
                mGceJokeButton.setEnabled(true);
                startActivity(mIntent);
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                mSpinner.setVisibility(View.GONE);
                mJavaJokeButton.setEnabled(true);
                mGceJokeButton.setEnabled(true);
                startActivity(mIntent);
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);



    }

}
