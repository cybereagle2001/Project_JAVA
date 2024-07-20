public class Order implements Orderable {
    private String orderId;
    private String orderDetails;

    public Order(String orderId, String orderDetails) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    @Override
    public void placeOrder() {
        System.out.println("Order placed: " + orderDetails);
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order cancelled: " + orderDetails);
    }

    public String getOrderId() {
        return orderId;
    }
}