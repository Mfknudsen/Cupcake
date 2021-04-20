<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <meta name="theme-color" content="#7952b3">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
</head>
<body>
<!--
    This header is inspired by this bootstrap
    example: https://getbootstrap.com/docs/5.0/examples/pricing/
-->
<div class="container rm-xp-xs rm-xp-sm rm-xp-md" style="max-width: 1280px;">

    <div>
        <img src="${pageContext.request.contextPath}/resources/images/olskercupcakes.png" class="img-fluid"/>
    </div>

    <div>
        <div class="d-flex align-items-center py-2 px-2 my-2 bg-gray container-fluid">

            <nav class="my-2 my-md-0 me-md-3">
                <c:if test="${sessionScope.user != null}">

                    <c:if test="${sessionScope.user.role == 'customer'}">
                        <a class="p-2 text-dark" href="#">Mine ordrer</a>
                    </c:if>

                    <c:if test="${sessionScope.user.role == 'employee'}">
                        <a class="p-2 text-dark" href="#">Ordrer</a>
                        <a class="p-2 text-dark" href="#">Kunder</a>
                    </c:if>

                </c:if>
            </nav>

            <div class="me-md-auto"></div>

            <div>
                <c:if test="${sessionScope.user != null }">
                    ${sessionScope.user.email}
                </c:if>

                <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
                <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
                <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

                <c:if test="${isNotLoginPage && isNotRegisterPage}">

                    <c:if test="${sessionScope.user != null }">
                        <a type="button" class="btn btn-sm  btn-outline-secondary"
                           href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
                    </c:if>

                    <c:if test="${sessionScope.user == null }">
                        <a type="button" class="btn btn-sm  btn-outline-secondary"
                           href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                        <a type="button" class="btn btn-sm  btn-outline-secondary"
                           href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>
                    </c:if>
                </c:if>
            </div>
        </div>
    </div>

    <div id="body" class="bg-gray rounded d-flex container-fluid" style="height: 100vh;">
        <jsp:doBody/>
    </div>

</div>

    <jsp:invoke fragment="footer"/>

</body>
</html>