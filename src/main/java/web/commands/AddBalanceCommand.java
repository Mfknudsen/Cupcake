package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrdersFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddBalanceCommand extends CommandProtectedPage
{
    UserFacade userFacade;

    public AddBalanceCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        float amount = Float.parseFloat(request.getParameter("amount"));

        int affectedRows = userFacade.addBalance(amount, userId);
        if (!(affectedRows > 0))
        {
            request.setAttribute("error", "Could not find the user");
            return pageToShow;
        }
        request.setAttribute("addBalanceSuccess", "Selected user now has: " + userFacade.getBalance(userId));
        return pageToShow;
    }
}
