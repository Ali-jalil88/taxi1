package com.java.tutorial.command.impl.order;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.OrderStatus;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AdminOrders implements Command {

    private OrderService orderService;

    public AdminOrders(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("pages/admin_login.jsp", true);
        List<Order> orderList = new ArrayList<>();
        orderList = orderService.readFinishedOrders(OrderStatus.SUCCESSFUL);
        HttpSession session = request.getSession();
        session.setAttribute("finishedOrders", orderList);
        return page;
    }
}
