package arena;

import java.util.Random;

public class Dice {
    private static final Random RANDOM = new Random();

    public static int roll(int sides) {
        return RANDOM.nextInt(sides) + 1;
    }
}
