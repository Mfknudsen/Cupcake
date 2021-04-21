package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrdersFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowOrdersFromCustomerPageCommand extends CommandProtectedPage
{
    OrdersFacade ordersFacade;
    UserFacade userFacade;

    public ShowOrdersFromCustomerPageCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.ordersFacade = new OrdersFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        List<Order> listOfOrdersByUserId = ordersFacade.getOrdersDataByUserId(userId);
        if (!(listOfOrdersByUserId.size() > 0))
        {
            request.setAttribute("error", "Could not receive any orders, perhaps this user has not ordered anything yet.");
        }
        request.setAttribute("listOfOrdersByUserId", listOfOrdersByUserId);
        return pageToShow;
    }
}
