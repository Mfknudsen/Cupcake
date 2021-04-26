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
            <form method="post" action="${pageContext.request.contextPath}/fc/allorders">
                <button type="submit" class="btn btn-primary">Show all orders</button>
            </form>
        </div>

        <div>
            <form method="post" action="${pageContext.request.contextPath}/fc/ordersfromcustomer">

                <div class="form-group mt-2">
                    <label class="form-check-label" for="userId">Select user: </label>

                    <select name="userId" id="userId" class="form-select" style="width: auto">
                        <c:forEach var="user" items="${applicationScope.userList}">
                            <option value="${user.id}">${user.email}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary mt-2">Show all orders</button>
            </form>
        </div>

        <div>
            <form method="post" action="${pageContext.request.contextPath}/fc/addbalance">

                <div class="form-group mt-2">
                    <label class="form-check-label" for="balance">Select user to add balance: </label>

                    <select name="userId" id="balance" class="form-select" style="width: auto">
                        <c:forEach var="user" items="${applicationScope.userList}">
                            <option value="${user.id}">${user.email}</option>
                        </c:forEach>
                    </select>

                    <label class="form-check-label" for="amount">Amount: </label>
                    <input type="text" name="amount" id="amount" class="form-control" style="width: 100px;">
                </div>

                <button type="submit" class="btn btn-primary mt-2">Submit</button>
            </form>
        </div>

        <c:if test="${requestScope.addBalanceSuccess != null }">
            <p style="color:lawngreen">
                    ${requestScope.addBalanceSuccess}
            </p>
        </c:if>

        <c:if test="${requestScope.error != null }">
            <p style="color:red">
                    ${requestScope.error}
            </p>
        </c:if>

    </jsp:body>
</t:genericpage>
