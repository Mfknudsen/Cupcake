package business.entities;

import java.util.Date;

public class Order
{
    private int id, topping, bottom;
    private float price;
    private String userName;
    private Date date;

    public Order(int id, String userName, Date date) {
       this.id = id;
       this.userName = userName;
       this.date = date;
    }

    public Order(int id, int topping, int bottom, float price, Date date) {
       this.id = id;
       this.topping = topping;
       this.bottom = bottom;
       this.price = price;
       this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
