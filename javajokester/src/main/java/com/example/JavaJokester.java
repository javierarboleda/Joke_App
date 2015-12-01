package com.example;

import java.util.concurrent.ThreadLocalRandom;

public class JavaJokester {


    private int mNumOfJokes = 5;

    public String tellMeAJoke() {
        switch (ThreadLocalRandom.current().nextInt(0, mNumOfJokes)) {
            case 0:
                return "Joke 1";
            case 1:
                return "Joke 2";
            case 2:
                return "Joke 3";
            case 3:
                return "Joke 4";
            case 4:
                return "Joke 5";
        }

        return "Error: You've reached the anti-joke!";

    }


}
