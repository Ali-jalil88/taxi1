package com.java.tutorial.command.impl.order;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.Location;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.OrderStatus;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.LocationService;
import com.java.tutorial.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class OrderInProgress implements Command {

    private OrderService orderService;
    private LocationService locationService = new LocationService();

    public OrderInProgress(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        System.out.println("order in progress page");
        Page page = new Page("/pages/client_orders.jsp", true);
        Order order = new Order();
        Location location = new Location();

        HttpSession session = request.getSession();

        Account account = new Account();
        account = (Account) session.getAttribute("account");

        long clientId = account.getId();

        System.out.println(orderService.readUnfinishedOrders(clientId, OrderStatus.IN_PROGRESS, -1));

        order = orderService.readUnfinishedOrders(clientId, OrderStatus.IN_PROGRESS, -1);
        System.out.println(order);
        location = order.getSource();
        location = locationService.readById(location.getId());
        System.out.println("source " + location);
        order.setSource(location);
        location = order.getDestination();
        location = locationService.readById(location.getId());
        System.out.println("destination " + location);
        order.setDestination(location);
        session.setAttribute("order", order);
        return page;
    }
}
