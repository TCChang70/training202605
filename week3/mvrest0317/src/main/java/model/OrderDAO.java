package model;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.Period;
import java.util.*;

public class OrderDAO{
    private  Map<Integer, Order> orders = new HashMap<>();
    private static OrderDAO  instance=new OrderDAO();
    public static OrderDAO getInstance(){
          return instance;
    }
    public OrderDAO() {
        Instant instant = OffsetDateTime.now().toInstant();
        for (int i = 1; i <= 5; i++) {
            Order order = new Order();
            order.setId(i);
            order.setItem("item " + i);
            order.setQty((int) (1 + Math.random() * 100));
            long millis = instant.minus(Period.ofDays(i))
                                 .toEpochMilli();
            order.setOrderDate(new Date(millis));
            orders.put(i, order);
        }
    }

    public Collection<Order> getAllOrders() {
        return new ArrayList<Order>(orders.values());
    }

    public boolean deleteOrderById(int orderId) {
    	    boolean flag=orders.remove(orderId) != null;
    	    System.out.println(orders.values());
        return flag;
    }

    public Order getOrderById(int id) {
        return orders.get(id);
    }
}


