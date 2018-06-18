package no.adonis.Utils;

import java.util.Random;

public class Randomizer {
    private static Random rand = new Random();

    public static int getRandomInt(){
        return rand.nextInt(Integer.MAX_VALUE);
    }
}
