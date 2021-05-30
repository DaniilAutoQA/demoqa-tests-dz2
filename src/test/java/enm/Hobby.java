package enm;

import java.util.Random;

public enum Hobby {

    Sports,Reading,Music;

    private static final Random RAND = new Random();

    public static Hobby getRandom() {
        return values()[RAND.nextInt(Hobby.values().length)];
    }
}
