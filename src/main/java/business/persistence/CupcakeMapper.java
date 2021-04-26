package business.persistence;

import business.entities.Cupcake_Bottom;
import business.entities.Cupcake_Topping;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CupcakeMapper
{
    private Database database;

    public CupcakeMapper(Database database)
    {
        this.database = database;
    }

    public List<Cupcake_Topping> getToppings() throws UserException
    {
        List<Cupcake_Topping> toppingList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM `cupcake_topping`;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("topping_id");
                    String name = rs.getString("name");
                    float price = rs.getFloat("price");
                    toppingList.add(new Cupcake_Topping(id, name, price));
                }
                return toppingList;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<Cupcake_Bottom> getBottoms() throws UserException
    {
        List<Cupcake_Bottom> bottomList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM `cupcake_bottom`;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("bottom_id");
                    String name = rs.getString("name");
                    float price = rs.getFloat("price");
                    bottomList.add(new Cupcake_Bottom(id, name, price));
                }
                return bottomList;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }
}
