<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="">
    <title>adminPage</title>
    <link rel="stylesheet" href="<c:url value="styles/administrator.css"/>">
</head>
<body>
<section>

    <label>
        <textarea>${sessionScope.order.price}</textarea>
    </label>


    <form action="${pageContext.request.contextPath}/taxi" method="get">

        <p>${sessionScope.order}</p>

        <input type="hidden" name="command" value="command_finish_order">

        <div>
            <input type="submit" name="order" value="Accept">
        </div>

    </form>
    <form action="${pageContext.request.contextPath}/taxi" method="get">

        <input type="hidden" name="command" value="command_order_relist">

        <div>
            <input type="submit" name="order" value="Decline">
        </div>

    </form>
</section>
</body>
</html>