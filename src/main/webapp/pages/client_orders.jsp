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

        <a href="my_orders.jsp">myOrders</a>

        <input type="hidden" name="command" value="command_read_order">

        <div>
            <input type="submit" name="order" value="Order">
        </div>

    </form>
</section>
</body>
</html>
