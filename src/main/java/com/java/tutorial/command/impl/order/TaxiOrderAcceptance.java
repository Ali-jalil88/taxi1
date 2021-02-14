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
import java.util.Arrays;
import java.util.List;

public class TaxiOrderAcceptance implements Command {

    private OrderService orderService;

    public TaxiOrderAcceptance(OrderService orderService) {
        this.orderService = orderService;
    }

    List<Order> orderList = new ArrayList<>();
    LocationService locationService = new LocationService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/new_client_login.jsp", true);
        Order order = new Order();

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        System.out.println(account + "account brought from session in TaxiOrderAcceptance");
        Location location = locationService.getLocationByTaxiId(account.getId());
        System.out.println(location + "checking if the location id in account in TaxiOrderAcceptance is working");

        System.out.println("a");
        order = orderService.readUnfinishedOrders(location.getAccount_id(), OrderStatus.WAITING);
        System.out.println(order);
        System.out.println("b");

//        order.setStatus();
//        System.out.println(order.getStatus() + "checking if the status brought from jsp in TaxiOrderAcceptance is working");
//        order.setClientId();
//        System.out.println(order.getClientId() + "checking if the clientId brought from jsp in TaxiOrderAcceptance is working");


        order.setTaxiId(account.getId());
        System.out.println(order + "checking if the taxiId in order working in TaxiOrderAcceptance");

        order.setPrice(Double.parseDouble(request.getParameter("price")));
        System.out.println(order.getPrice() + "checking if the price brought from jsp in TaxiOrderAcceptance is working");


        System.out.println(order + "checking for full order in TaxiOrderAcceptance");
//        orderList.add(order);
//        nearestTaxiSorting(location, orderList);
//        session.setAttribute("readyOrders", orderList);
        return page;

    }

//    public void nearestTaxiSorting(Location s, List<Order> ll) throws ServiceException {
//        double client = s.getLat() + s.getLng();
//        Order[] orderArray = new Order[ll.size()];
//        orderArray = (Order[]) ll.toArray();
//        double temp = 0;
//        double total;
//
//        for (int i = 0; i >= orderArray.length; i++){
//            Order order = orderArray[i];
//            Location location = locationService.readById();
//            double taxi = location.getLat() + location.getLng();
//
//            total = client - taxi;
//            if (temp == 0) {
//                temp = total;
//            }
//            if (temp != total) {
//                if (temp > total) {
//                    temp = total;
//                } else {
//                    orderArray[orderArray.length - 1] = order;
//                }
//            }
//        }
//        orderList = Arrays.asList(orderArray);
//    }
}