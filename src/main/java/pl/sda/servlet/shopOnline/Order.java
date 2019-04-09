package pl.sda.servlet.shopOnline;

import java.util.Map;

public class Order {
    private String adress;
    private String email;
    private long orderId;
    private Map<Product, Integer> orderMap;

    public Order(String adress, String email, long orderId, Map<Product, Integer> orderMap) {
        this.adress = adress;
        this.email = email;
        this.orderId = orderId;
        this.orderMap = orderMap;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Map<Product, Integer> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Product, Integer> orderMap) {
        this.orderMap = orderMap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Order{" +
                "adress='" + adress + '\'' +
                ", orderId=" + orderId +
                ", userId=" +
                ", orderMap=" + orderMap +
                '}';
    }
}
