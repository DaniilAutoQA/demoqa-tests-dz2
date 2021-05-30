package enm;

public enum Gender {

    Male,Female,Other;

    public static Gender getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
