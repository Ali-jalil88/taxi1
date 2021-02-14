import com.java.tutorial.dao.impl.AccountDAO;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.Location;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.OrderStatus;
import com.java.tutorial.exceptions.DAOException;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.AccountService;
import com.java.tutorial.service.impl.LocationService;
import com.java.tutorial.service.impl.OrderService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        LocationService locationService = new LocationService();

        try {
            Order order = new Order();

            Location location = new Location();
            location.setLat(27.556276);
            location.setLng(53.902606);
            location.setAccount_id(-1);

            Location location1 = new Location();
            location1.setLat(27.556276);
            location1.setLng(53.902606);
            location1.setAccount_id(-1);

//            order.setSource(location);
//            order.setDestination(location1);
//            order.setClientId(4);
//            order.setDate(String.valueOf(LocalDate.now()));
//            order.setTaxiId(-1);
//            order.setPrice(0);
//            order.setTransactionId(-1);
//            order.setStatus(OrderStatus.WAITING);
            order = orderService.readUnfinishedOrders(2, OrderStatus.WAITING);


        } catch (ServiceException e) {
            e.getMessage();
        }

    }
}
