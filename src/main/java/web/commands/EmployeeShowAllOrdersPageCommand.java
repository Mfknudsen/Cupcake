package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrdersFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EmployeeShowAllOrdersPageCommand extends CommandProtectedPage
{
    OrdersFacade ordersFacade;

    public EmployeeShowAllOrdersPageCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.ordersFacade = new OrdersFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        List<Order> listAllOrders = ordersFacade.getAllOrders();
        request.setAttribute("listAllOrders", listAllOrders);
        return pageToShow;
    }
}
