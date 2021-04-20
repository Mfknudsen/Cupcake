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
        <h1>Hello ${sessionScope.email} </h1>
        <p>You are now logged in as a EMPLOYEE of our wonderful site.</p>

        <div>
            <form method="post" action="${pageContext.request.contextPath}/fc/showallorders">
                <button type="submit" class="btn btn-primary">Show all orders</button>
            </form>
        </div>

        <div>
            <form method="post" action="${pageContext.request.contextPath}/fc/showcustomerorders">

                <div class="form-group mt-2">
                    <label class="form-check-label" for="userList">Select user: </label>

                    <select name="userList" id="userList" class="form-select" style="width: auto">
                        <c:forEach var="user" items="${applicationScope.userList}">
                            <option value="${user.id}">${user.email}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary mt-2">Show all orders</button>
            </form>
        </div>

    </jsp:body>
</t:genericpage>
