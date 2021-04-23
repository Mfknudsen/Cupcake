<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="row">
            <div class="col-sm-4"></div>
        </div>

        <div class="col-sm-4">
            <h1>Hello ${sessionScope.email} </h1>
            You are now logged in as a EMPLOYEE of our wonderful site.

            <c:if test="${requestScope.specificOrder.size() > 0 }">
                <table class="table table-striped">
                    <thead><th>Order number</th><th>Topping</th><th>Bottom</th><th>Price</th><th>Date</th></thead>
                    <c:forEach var="order" items="${requestScope.specificOrder}">
                        <tr>
                            <td>${order.orderId}</td>
                            <td>${order.topping}</td>
                            <td>${order.bottom}</td>
                            <td>${order.price}</td>
                            <td>${order.date}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

        </div>

        <div class="col-sm-4"></div>

        <c:if test="${not empty requestScope.error}">
            <br>
            <p style="color:red; font-size: large">${requestScope.error}</p>
        </c:if>

    </jsp:body>
</t:genericpage>
