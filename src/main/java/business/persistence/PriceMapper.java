package business.persistence;

import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PriceMapper {
    Database database;

    public PriceMapper(Database database) {
        this.database = database;
    }

    public Float[] getToppingPrices() throws Exception{
        List<Float> result = new ArrayList<Float>();

        try(Connection connection = database.connect()) {
            String sql = "select price from cupcake_topping;";

            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    result.add(rs.getFloat("price"));
                }
                return result.toArray(new Float[0]);
            }

        }
        catch (Exception e){
            throw new UserException("Connection to database could not be established");
        }
    }

    public Float[] getBottomPrices() throws Exception{
        List<Float> result = new ArrayList<Float>();

        try(Connection connection = database.connect()) {
            String sql = "select price from cupcake_bottom;";

            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    result.add(rs.getFloat("price"));
                }
                return result.toArray(new Float[0]);
            }

        }
        catch (Exception e){
            throw new UserException("Connection to database could not be established");
        }
    }
}
