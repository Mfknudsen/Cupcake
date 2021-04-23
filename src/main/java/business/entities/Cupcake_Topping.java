package business.entities;

public class Cupcake_Topping
{
    private int toppingId;
    String name;
    float price;

    public Cupcake_Topping(int toppingId, String name, float price)
    {
        this.toppingId = toppingId;
        this.name = name;
        this.price = price;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
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
