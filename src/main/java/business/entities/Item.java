package business.entities;

public class Item {
    private Topping topping;
    private Bottom bottom;

    public Item(Topping topping, Bottom bottom) {
        this.topping = topping;
        this.bottom = bottom;
    }
    
    public int GetToppingID(){
        return topping.getValue();
    }

    public int GetBottomID(){
        return bottom.getValue();
    }
}
