package com.java.tutorial.command.impl.order;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.OrderStatus;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class OrderFinish implements Command {

    private OrderService orderService;

    public OrderFinish(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("pages/my_orders.jsp", true);
        HttpSession session = request.getSession();
        Order order = new Order();

        order = (Order) session.getAttribute("order");
        order.setStatus(OrderStatus.SUCCESSFUL);

        orderService.update(order);
        return page;
    }
}
