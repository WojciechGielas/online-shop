package pl.sda.servlet.shopOnline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderDb {

    private static OrderDb db;
    private List<Order> orders;
    private static long currentId = 0;

    private OrderDb(){
        this.orders = new ArrayList<>();
    }

    public long addNewOrder(final Map<Product, Integer> cart, final String adress, final String email) {
        final Order order = new Order(adress, email, currentId, cart);
        this.orders.add(order);
        return currentId++;
    }

    public List<Order> getOrdersForUserId(final String email){
        return orders.stream()
                .filter(i-> i.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    public static OrderDb getInstance() {
        if (db == null) {
            db = new OrderDb();
        }
        return db;
    }


}
