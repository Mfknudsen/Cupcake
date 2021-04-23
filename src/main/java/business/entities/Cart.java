package business.entities;

import java.util.HashMap;

public class Cart {
    private HashMap<Item, Integer> items = new HashMap();

    public void EditItems(Item item, int q){
        boolean found = false;

        for (Item t: items.keySet()) {
            if(t.GetBottomID() == item.GetBottomID() && t.GetToppingID() == item.GetToppingID()){
                items.put(t, items.get(t) + q);
                found = true;
            }
        }

        if(!found){
            items.put(item, q);
        }
    }

    public HashMap<Item, Integer> getItems() {
        return items;
    }
}
