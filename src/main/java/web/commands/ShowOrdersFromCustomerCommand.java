package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrdersFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowOrdersFromCustomerCommand extends CommandProtectedPage
{
    OrdersFacade ordersFacade;
    UserFacade userFacade;

    public ShowOrdersFromCustomerCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.ordersFacade = new OrdersFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        List<Order> ordersFromUser = ordersFacade.getOrders(userId);
        if (!(ordersFromUser.size() > 0))
        {
            request.setAttribute("error", "Could not retrieve any orders, perhaps this user has not ordered anything yet.");
        }
        request.setAttribute("ordersFromUser", ordersFromUser);
        return pageToShow;
    }
}
