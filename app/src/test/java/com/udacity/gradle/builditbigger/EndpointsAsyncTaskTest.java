package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by javierarboleda on 12/16/15.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    private EndpointsAsyncTask endpointsAsyncTask;

    private JokeDownloadedCallback mJokeDownloadedCallback;

    private String mJoke;

    private boolean mJokeDownloaded;

    protected void setUp() throws Exception {
        super.setUp();

        endpointsAsyncTask = new EndpointsAsyncTask();

        mJokeDownloadedCallback = new JokeDownloadedCallback() {
            @Override
            public void jokeDownloaded(String joke) {
                mJoke = joke;
                mJokeDownloaded = true;
            }
        };
    }

    public void testGceEndpoint() throws InterruptedException, ExecutionException {
        mJoke = endpointsAsyncTask.execute(mJokeDownloadedCallback).get();

        // need to check if downloaded for 10 seconds

//        for(int i = 0; i < 10; i++) {
//            Thread.sleep(500);
//            if(mJokeDownloaded) {
//                assertNotNull(mJoke);
//                assertFalse(mJoke.isEmpty());
//                break;
//            }
//        }


        assertNotNull(mJoke);
        assertFalse(mJoke.isEmpty());

        // if not downloaded in 10 seconds, then fail test due to timeout

    }

}
