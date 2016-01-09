package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by javierarboleda on 12/16/15.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    public void testGceEndpoint() {
        Context context = null;
        try {
            String joke = new EndpointsAsyncTask().execute(context).get();
            assertNotNull(joke);
            assertFalse(joke.isEmpty());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
