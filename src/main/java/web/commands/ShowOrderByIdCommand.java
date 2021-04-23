package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrdersFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowOrderByIdCommand extends CommandProtectedPage
{
    OrdersFacade ordersFacade;
    UserFacade userFacade;

    public ShowOrderByIdCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.ordersFacade = new OrdersFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        List<Order> specificOrder = ordersFacade.getOrder(userId, orderId);
        if (!(specificOrder.size() > 0))
        {
            request.setAttribute("error", "Could not retrieve any orders, possible problem could be that the order or user does not exist anymore.");
        }
        request.setAttribute("specificOrder", specificOrder);
        return pageToShow;
    }
}
