package business.persistence;

import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersMapper
{
    private Database database;

    public OrdersMapper(Database database) {
        this.database = database;
    }

    public List<Order> getAllOrders() throws UserException
    {
        List<Order> ordersList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT `u`.`user_id` as 'userId', `o`.`order_id` as 'Order number', `u`.`email` as 'User name', date(`o`.`dateTime`) as 'Date' " +
                    "FROM `orders` AS `o` " +
                    "INNER JOIN `user` AS `u` " +
                    "ON `u`.`user_id` = `o`.`user_id`;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int userId = rs.getInt("userId");
                    int orderId = rs.getInt("Order number");
                    String userName = rs.getString("User name");
                    Date date = rs.getDate("Date");

                    ordersList.add(new Order(
                            userId,orderId, userName, date));
                }
                return ordersList;
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

    public List<Order> getOrders(int userId) throws UserException
    {
        List<Order> ordersList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT " +
                    "`o`.`order_id` as 'Order number', " +
                    "`c`.`topping_id` as 'Topping', " +
                    "`c`.`bottom_id` as 'Bottom', " +
                    "(`ct`.`price` + `cb`.`price`) as 'Price', " +
                    "date(`o`.`dateTime`) as 'Date' " +
                    "FROM `user` as `u` " +
                    "INNER JOIN `orders` AS `o` " +
                    "ON `u`.`user_id` = `o`.`user_id` " +
                    "INNER JOIN `cupcake` AS `c` " +
                    "ON `o`.`order_id` = `c`.`order_id` " +
                    "INNER JOIN `cupcake_bottom` as `cb` " +
                    "ON `c`.`bottom_id` = `cb`.`bottom_id` " +
                    "INNER JOIN `cupcake_topping` as `ct` " +
                    "ON `c`.`topping_id` = `ct`.`topping_id` " +
                    "WHERE `u`.`user_id` = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int orderId = rs.getInt("Order number");
                    int topping = rs.getInt("Topping");
                    int bottom = rs.getInt("Bottom");
                    float price = rs.getFloat("Price");
                    Date date = rs.getDate("Date");

                    ordersList.add(new Order(
                            orderId, topping, bottom,
                            price, date));
                }
                return ordersList;
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

    public List<Order> getOrder(int userId, int orderId) throws UserException
    {
        List<Order> ordersList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT " +
                    "`o`.`order_id` as 'Order number', " +
                    "`c`.`topping_id` as 'Topping', " +
                    "`c`.`bottom_id` as 'Bottom', " +
                    "(`ct`.`price` + `cb`.`price`) as 'Price', " +
                    "date(`o`.`dateTime`) as 'Date' " +
                    "FROM `user` as `u` " +
                    "INNER JOIN `orders` AS `o` " +
                    "ON `u`.`user_id` = `o`.`user_id` " +
                    "INNER JOIN `cupcake` AS `c` " +
                    "ON `o`.`order_id` = `c`.`order_id` " +
                    "INNER JOIN `cupcake_bottom` as `cb` " +
                    "ON `c`.`bottom_id` = `cb`.`bottom_id` " +
                    "INNER JOIN `cupcake_topping` as `ct` " +
                    "ON `c`.`topping_id` = `ct`.`topping_id` " +
                    "WHERE `u`.`user_id` = ? AND `o`.`order_id` = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, userId);
                ps.setInt(2, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("Order number");
                    int topping = rs.getInt("Topping");
                    int bottom = rs.getInt("Bottom");
                    float price = rs.getFloat("Price");
                    Date date = rs.getDate("Date");

                    ordersList.add(new Order(
                            id, topping, bottom,
                            price, date));
                }
                return ordersList;
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
