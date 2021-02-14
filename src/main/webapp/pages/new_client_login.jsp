<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="">
    <title>adminPage</title>
    <link rel="stylesheet" href="<c:url value="styles/new_client_login.css"/>">
</head>
<body>
<section>
        <%session.getAttribute("readyOrders");%>
        <c:forEach var="orders" items="${sessionScope.orderList}">
            <c:set var="count" value="${pageScope.count+1}"/>

            <div>
                <label for="price"></label>
                <input type="text" id="price" name="price" placeholder="price">
            </div>


            <a href="new_client_login.jsp?index=${count}">
                <form action="${pageContext.request.contextPath}/taxi" method="get">

                <ul>
                    <label>
                        <textarea id="status" name="status" contenteditable="false" aria-multiline="false"
                                  autocomplete="off" rows="1">${orders.source}</textarea>
                    </label>

                    <div>
                        <input type="submit" name="taxi_orders" value="accept">
                    </div>

                    <div>
                        <input type="submit" name="delete" value="delete">
                    </div>

                </ul>
                    <input type="hidden" name="command" value="taxi_order_acceptance">
                </form>

            </a>

        </c:forEach>
        <%--                <div>--%>
        <%--                    <input type="submit" name="decline" value="decline">--%>
        <%--                </div>--%>
</section>
</body>
</html>