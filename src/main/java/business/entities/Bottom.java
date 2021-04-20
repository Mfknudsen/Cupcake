package business.entities;

public enum Bottom {
    Chhocolate(0),
    Vanilla(1),
    Nutmeg(2),
    Pistacio(3),
    Almond(4);

    private final int value;

    private Bottom(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
