package business.entities;

import java.util.HashMap;

public class Cart {
    private HashMap<Item, Integer> items = new HashMap();

    public Cart(Item item, int q) {
        items.put(item, q);
    }

    public void EditItems(Item item, int q){
        for (Item t: items.keySet()) {
            if(t.GetBottomID() == item.GetBottomID() && t.GetToppingID() == item.GetToppingID()){
                items.put(t, items.get(t) + q);
            }
        }
    }

    public HashMap<Item, Integer> getItems() {
        return items;
    }
}
