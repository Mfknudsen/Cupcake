package business.services;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrdersMapper;

import java.util.List;

public class OrdersFacade
{
    private OrdersMapper ordersMapper;

    public OrdersFacade(Database database)
    {
        this.ordersMapper = new OrdersMapper(database);
    }

    public List<Order> getAllOrders() throws UserException
    {
        return ordersMapper.getAllOrders();
    }

    public List<Order> getOrders(int userId) throws UserException
    {
        return ordersMapper.getOrders(userId);
    }

    public List<Order> getOrder(int userId, int orderId) throws UserException {
        return ordersMapper.getOrder(userId, orderId);
    }
}
