package web.commands;

import business.entities.Cart;
import business.entities.Item;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCartCommand extends CommandUnprotectedPage
{

    public ShoppingCartCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Cart cart = (Cart) request.getAttribute("cart");

        for (Item i: cart.getItems().keySet()) {
            int count = Integer.parseInt(request.getParameter("number" +i.GetToppingID()+""+i.GetBottomID()));
            cart.EditItems(i, count);
        }

        session.setAttribute("cart", cart);

        return pageToShow;
    }
}
