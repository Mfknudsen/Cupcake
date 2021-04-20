package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrdersFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EmployeeShowOrdersFromCustomerPageCommand extends CommandProtectedPage
{
    OrdersFacade ordersFacade;
    UserFacade userFacade;

    public EmployeeShowOrdersFromCustomerPageCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.ordersFacade = new OrdersFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String userId = request.getParameter("userId");

        List<Order> listOfOrdersByUserId = ordersFacade.getOrdersDataByUserId(Integer.parseInt(userId));
        request.setAttribute("listOfOrdersByUserId", listOfOrdersByUserId);
        return pageToShow;
    }
}
