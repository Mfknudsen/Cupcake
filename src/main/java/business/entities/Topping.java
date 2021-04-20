package business.entities;

public enum Topping {
    Chocolate(0),
    Blueberry(1),
    Rasberry(2),
    Crispy(3),
    Strawberry(4),
    Rum_Raisin(5),
    Orange(6),
    Lemon(7),
    Bluecheese(8);

    private final int value;
    Topping(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
