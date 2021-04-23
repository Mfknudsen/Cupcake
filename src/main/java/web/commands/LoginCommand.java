package web.commands;

import business.entities.*;
import business.persistence.PriceMapper;
import business.services.CartFacade;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;
    private CartFacade cartFacade;

    public LoginCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
        cartFacade = new CartFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userFacade.login(email, password);
            HttpSession session = request.getSession();

            session.setAttribute("toppingPrices", cartFacade.getToppingPrices());
            session.setAttribute("bottomPrices", cartFacade.getBottomPrices());

            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("email", email);

            Cart cart = new Cart();
            cart.EditItems(new Item(Topping.Bluecheese, Bottom.Almond), 3);
            cart.EditItems(new Item(Topping.Chocolate, Bottom.Nutmeg), 5);
            session.setAttribute("cart", cart);

            String pageToShow = user.getRole() + "page";
            return REDIRECT_INDICATOR + pageToShow;
        } catch (UserException ex) {
            request.setAttribute("error", "Wrong username or password!");
            return "loginpage";
        }
    }

}
