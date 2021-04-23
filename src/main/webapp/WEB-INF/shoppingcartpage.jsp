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
        <p>Hello ${sessionScope.email} </p>
        <p>You are now viewing your shopping cart.</p>
        <c:set value="${sessionScope.cart.items}" var="itemsMap"/>
        <c:if test="${itemsMap.keySet().size() > 0}">
            <table class="table table-striped">
                <thead>
                <th>Cupcake:</th>
                <th>Price Per:</th>
                <th>Quantity:</th>
                </thead>
                <c:forEach var="item" items="${itemsMap.keySet()}">
                    <tr>
                        <td>"${item.getTopping()} and ${item.getBottom()}"</td>
                        <td>
                            "${(sessionScope.toppingPrices[item.GetToppingID()] + sessionScope.bottomPrices[item.GetBottomID()])}
                            kr."
                        </td>
                        <td>
                            <input id="number${item.GetToppingID()+""+item.GetBottomID()}" type="number" value="${itemsMap.get(item)}" step="1" min="0" max="99">
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button class="btn btn-primary" type="submit" value="Buy">Buy</button>
        </c:if>
    </jsp:body>

</t:genericpage>

