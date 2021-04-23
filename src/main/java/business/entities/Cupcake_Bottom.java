package business.entities;

import java.util.Date;

public class Cupcake
{
    private int cupcakeId ,toppingId, bottomId, orderId, quantity;

    public Cupcake(int cupcakeId, int toppingId, int bottomId, int quantity)
    {
        this.cupcakeId = cupcakeId;
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.quantity = quantity;
    }

    public int getCupcakeId() {
        return cupcakeId;
    }

    public void setCupcakeId(int cupcakeId) {
        this.cupcakeId = cupcakeId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
