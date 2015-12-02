package com.javierarboleda.androidjokester;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidJokesterFragment extends Fragment {


    public AndroidJokesterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_android_jokester, container, false);
        TextView jokeTextView = (TextView) rootView.findViewById(R.id.joke_textView);
        String joke = getActivity().getIntent().getStringExtra(AndroidJokesterActivity.EXTRA_JOKE);
        jokeTextView.setText(joke);
        return rootView;

    }

}
