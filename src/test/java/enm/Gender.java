package enm;

import java.util.Random;

public enum Gender {

    Male,Female,Other;

    private static final Random RAND = new Random();

    public static Gender getRandom() {
        return values()[RAND.nextInt(Gender.values().length)];
    }
}
