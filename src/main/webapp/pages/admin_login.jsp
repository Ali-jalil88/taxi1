<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="">
    <title>adminPage</title>
    <link rel="stylesheet" href="<c:url value="styles/administrator.css"/>">
</head>
<body>
<section>
    <form action="${pageContext.request.contextPath}/taxi" method="post">
        <div>
            <input type="submit" name="logout" value="logout">
        </div>
        <input type="hidden" name="command" value="logout">
    </form>
    <div>
        <c:if test="${sessionScope.account.type == 'ADMIN'}">
            <%session.getAttribute("readyOrders");%>
            <c:forEach var="orders" items="${sessionScope.orderList}">
                 <div>
                        <ul>
                            <label>
                        <textarea id="status" name="status" contenteditable="false" aria-multiline="false"
                                  autocomplete="off" rows="1">${orders.source}</textarea>
                            </label>

                            <label>
                        <textarea id="id" name="id" contenteditable="false" aria-multiline="false"
                                  autocomplete="off" rows="1" hidden>${orders.id}</textarea>
                            </label>
                        </ul>
                 </div>
            </c:forEach>
        </c:if>
        <c:if test="${sessionScope.account.type == 'CLIENT'}">


                <a href="client_orders.jsp" type="submit">fuck</a>



            <form action="${pageContext.request.contextPath}/taxi" method="post">
                <div>

                        <%--@declare id="location"--%><label for="location"></label>
                    <input type="text" id="l-lng" name="l-lng" placeholder="lng" required>
                    <input type="text" id="l-lat" name="l-lat" placeholder="lat" required>
                </div>
                <div>
                        <%--@declare id="destination"--%><label for="destination"></label>
                    <input type="text" id="d-lng" name="d-lng" placeholder="lng" required>
                    <input type="text" id="d-lat" name="d-lat" placeholder="lat" required>
                </div>

                <input type="hidden" name="command" value="command_create_location">

                <div>
                    <input type="submit" name="location" value="Order">
                </div>
            </form>
        </c:if>

        <c:if test="${sessionScope.account.type == 'TAXI'}">
            <form action="${pageContext.request.contextPath}/taxi" method="post">

                <a href="new_client_login.jsp">fuck</a>


                <input type="hidden" name="command" value="command_taxi_order">

                <div>
                    <input type="submit" name="location" value="print">
                </div>

            </form>
        </c:if>
    </div>

</section>
</body>
</html>