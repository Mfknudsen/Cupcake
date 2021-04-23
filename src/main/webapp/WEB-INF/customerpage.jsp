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
        <h1>Hello ${sessionScope.email} </h1>
        <p>You are now logged in as a Customer of our wonderful site. <br>
            Role: ${sessionScope.role}</p>


        <form method="post" action="${pageContext.request.contextPath}/fc/shoppingcart">

            <div class="form-group mt-2">
                <label class="form-check-label" for="bottom">Select bottom: </label>

                <select name="bottom" id="bottom" class="form-select bottom" style="width: auto" onchange="setBottomValue(this)">
                    <option value="">-- Select --</option>
                    <c:forEach var="bottom" items="${applicationScope.bottoms}">
                        <option value="${bottom.bottomId}" data-price="${bottom.price}">${bottom.name}: ${bottom.price}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group mt-2">
                <label class="form-check-label" for="topping">Select topping: </label>

                <select name="topping" id="topping" class="form-select" style="width: auto" onchange="setToppingValue(this)">
                    <option value="">-- Select --</option>
                    <c:forEach var="topping" items="${applicationScope.toppings}">
                        <option value="${topping.toppingId}" data-price="${topping.price}">${topping.name}: ${topping.price}</option>
                    </c:forEach>
                </select>
            </div>

            <div>
                <label class="form-check-label" for="quantity">Quantity: </label>
                <input onchange="setQuantityValue(this)" type="text" name="quantity" id="quantity" class="form-control" style="width: 100px">
            </div>

            <div>
                <label class="form-check-label" for="price">Price: </label>
                <input type="text" name="price" id="price" class="form-control" style="width: 100px" disabled>
            </div>

            <button type="submit" class="btn btn-primary mt-2">Add to cart</button>
        </form>

        <script type="text/javascript">

            var bottomValue;
            var toppingValue;
            var quantityValue;


            function setBottomValue(bottom)
            {
                bottomValue = parseFloat(bottom.options[bottom.selectedIndex].getAttribute('data-price'));
                executePrice();
            }

            function setToppingValue(topping)
            {
                toppingValue  = parseFloat(topping.options[topping.selectedIndex].getAttribute('data-price'));
                executePrice();
            }

            function setQuantityValue(quantity)
            {
                quantityValue = parseInt(quantity.value);
                executePrice();
            }


            function executePrice()
            {
                let sum;
                sum = String((bottomValue + toppingValue) * (quantityValue));

                document.getElementById("price").setAttribute('value', sum);
            }
        </script>

    </jsp:body>

</t:genericpage>

