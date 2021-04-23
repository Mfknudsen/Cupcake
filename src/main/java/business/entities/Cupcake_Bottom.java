package business.entities;

public class Cupcake_Bottom
{
    private int bottomId;
    String name;
    float price;

    public Cupcake_Bottom(int bottomId, String name, float price)
    {
        this.bottomId = bottomId;
        this.name = name;
        this.price = price;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
