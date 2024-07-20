import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void addOrder(Connection connection) throws SQLException {
        String sql = "INSERT INTO Orders (orderId, orderDetails) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, orderId);
            pstmt.setString(2, orderDetails);
            pstmt.executeUpdate();
        }
    }

    public void updateOrder(Connection connection, String newOrderDetails) throws SQLException {
        String sql = "UPDATE Orders SET orderDetails = ? WHERE orderId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newOrderDetails);
            pstmt.setString(2, orderId);
            pstmt.executeUpdate();
        }
    }

    public void removeOrder(Connection connection) throws SQLException {
        String sql = "DELETE FROM Orders WHERE orderId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, orderId);
            pstmt.executeUpdate();
        }
    }
}
