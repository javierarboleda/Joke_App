package com.example;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class JavaJokester {


    private static int sNumOfJokes = 5;

    public static String tellMeAJoke() {
        switch (new Random().nextInt(sNumOfJokes)) {
            case 0:
                return "Q. Why did the orange use suntan lotion? A. He started to peel.";
            case 1:
                return "Q: How do you know if a restaurant has a clown as a chef?" +
                        " A: When the food tastes funny";
            case 2:
                return "Q. When were vowels invented? A. When u and i were born.";
            case 3:
                return "Q. What's orange and sounds like a parrot? A. A carrot.";
            case 4:
                return "Q. What goes ha, ha plonk? A. Someone laughing their head off.";
        }

        return "Error: You've reached the anti-joke!";

    }


}
