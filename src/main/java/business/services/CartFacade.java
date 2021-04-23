package business.services;

import business.persistence.Database;
import business.persistence.PriceMapper;

import java.util.List;

public class CartFacade {
    private PriceMapper mapper;

    public CartFacade(Database database) {
        this.mapper = new PriceMapper(database);
    }

    public Float[] getToppingPrices(){
        try {
            return mapper.getToppingPrices();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Float[0];
    }

    public Float[] getBottomPrices(){
        try {
            return mapper.getBottomPrices();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Float[0];
    }
}
