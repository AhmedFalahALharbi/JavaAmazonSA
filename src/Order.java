import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private int userID;
    private List<OrderDetails> orderDetailsList;

    public Order(int orderID, int userID) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDetailsList = new ArrayList<>();
    }

    public void addOrderDetail(OrderDetails orderDetail) {
        this.orderDetailsList.add(orderDetail);
    }

    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }
    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", orderDetailsList=" + orderDetailsList +
                '}';
    }
}
