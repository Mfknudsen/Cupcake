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

            <c:if test="${requestScope.listAllOrders.size() > 0 }">
                <table class="table table-striped">
                    <thead><th>Order number</th><th>Username</th><th>Date</th><th></th></thead>
                    <c:forEach var="user" items="${requestScope.listAllOrders}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.userName}</td>
                            <td>${user.date}</td>
                            <td>
                                <form method="post" action="${pageContext.request.contextPath}/fc/showcustomerorders">
                                    <button name ="userList" type="submit" class="btn btn-outline-dark py-0 border-0" value="${user.id}">Vis</button>
                                </form>
                            </td>
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
