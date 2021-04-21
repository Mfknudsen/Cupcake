package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrdersFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EmployeeShowOrderByIdCommand extends CommandProtectedPage
{
    OrdersFacade ordersFacade;
    UserFacade userFacade;

    public EmployeeShowOrderByIdCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.ordersFacade = new OrdersFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        List<Order> listOrderByOrderId = ordersFacade.getOrder(userId, orderId);
        return pageToShow;
    }
}
