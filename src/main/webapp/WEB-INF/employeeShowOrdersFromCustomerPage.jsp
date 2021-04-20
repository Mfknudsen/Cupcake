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
            <table class="table table-striped">
                <thead><th>Order number</th><th>Topping</th><th>Bottom</th><th>Price</th><th>Date</th></thead>
                <c:forEach var="user" items="${requestScope.listOfOrdersByUserId}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.topping}</td>
                        <td>${user.bottom}</td>
                        <td>${user.price}</td>
                        <td>${user.date}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="col-sm-4"></div>

    </jsp:body>
</t:genericpage>
