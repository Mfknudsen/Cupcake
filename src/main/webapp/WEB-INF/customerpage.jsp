<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <div>

            <h1>Hello ${sessionScope.email} </h1>
            <p>You are now logged in as a Customer of our wonderful site. <br>
                Role: ${sessionScope.role}</p>

            <div id="Bottom" role="application" style="float:left; padding:15px;

            <form action="shoppingCartPage.jsp">

            <label for="selectBottom">Select a Bottom</label>
            <select name="selectBottom" id="selectBottom">
                <option value="Chocolate">Chocolate</option>
                <option value="Vanilla">Vanilla</option>
                <option value="Nutmeg">Nutmeg</option>
                <option value="Pistacio">Pistacio</option>
                <option value="Almond">Almond</option>
            </select>

                <%--                        <button type="button">Add to cart</button>--%>
            </form>
        </div>

        <div id="Topping" role="application" style="float:left;padding:15px;

        <form action="shoppingCartPage.jsp">

        <label for="selectTopping">Select a Topping</label>
        <select name="selectTopping" id="selectTopping">
            <option value="Chocolate">Chocolate</option>
            <option value="Blueberry">Blueberry</option>
            <option value="Rasberry">Rasberry</option>
            <option value="Crispy">Crispy</option>
            <option value="Strawberry">Strawberry</option>
            <option value="Rum/Raisin">Rum/Raisin</option>
            <option value="Orange">Orange</option>
            <option value="Lemon">Lemon</option>
            <option value="Blue cheese">Blue cheese</option>
        </select>
        <%--                        <button type="button">Add to cart</button>--%>
        </form>
        </div>

        <div id="Quantity" role="application" style="float:left;padding:15px;

        <form action="shoppingCartPage.jsp">

        <label for ="Quantity">Quantity</label>
        <input name="Quantity" id="Quantity" type="number">

        </div>

        <div id="Price" role="application" style="float:left;padding:15px;
        <form action="shoppingCartPage.jsp">

        <p>Price: N/A</p>

        </div>

        <br><br>
        <button type="button">Add to cart</button>

        </div>

    </jsp:body>

</t:genericpage>

