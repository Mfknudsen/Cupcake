package business.entities;

import java.util.Date;

public class Order
{
    private int userId ,orderId, topping, bottom;
    private float price;
    private String userName;
    private Date date;

    public Order(int userId, int orderId, String userName, Date date) {
       this.userId = userId;
       this.orderId = orderId;
       this.userName = userName;
       this.date = date;
    }

    public Order(int orderId, int topping, int bottom, float price, Date date) {
       this.orderId = orderId;
       this.topping = topping;
       this.bottom = bottom;
       this.price = price;
       this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTopping() {
        return topping;
    }

    public void setTopping(int topping) {
        this.topping = topping;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
