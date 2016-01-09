package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.example.JavaJokester;
import com.example.javierarboleda.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.javierarboleda.androidjokester.AndroidJokesterActivity;

import java.io.IOException;

/**
 * Created by javierarboleda on 12/10/15.
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    public interface AsyncCallback {
        void jokeDownloadedCallback(String joke);
    }

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokes-app-backend.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        if (context != null) {
            ((AsyncCallback) context).jokeDownloadedCallback(result);
        }


    }
}