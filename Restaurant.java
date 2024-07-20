import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Customer> customers;
    private List<Waiter> waiters;
    private List<Order> orders;

    private Connection connection;

    public Restaurant(String dbUrl, String user, String password) throws SQLException {
        customers = new ArrayList<>();
        waiters = new ArrayList<>();
        orders = new ArrayList<>();
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public void addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO Customers (customerId, name, contactInfo) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customer.getCustomerId());
            pstmt.setString(2, customer.getName());
            pstmt.setString(3, customer.getContactInfo());
            pstmt.executeUpdate();
        }
        customers.add(customer);
    }

    public void addWaiter(Waiter waiter) throws SQLException {
        String sql = "INSERT INTO Waiters (employeeId, name, contactInfo) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, waiter.getEmployeeId());
            pstmt.setString(2, waiter.getName());
            pstmt.setString(3, waiter.getContactInfo());
            pstmt.executeUpdate();
        }
        waiters.add(waiter);
    }

    public void addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO Orders (orderId, orderDetails) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, order.getOrderId());
            pstmt.setString(2, order.getOrderDetails());
            pstmt.executeUpdate();
        }
        orders.add(order);
    }

    public void displayAllCustomers() {
        for (Customer customer : customers) {
            customer.displayInfo();
        }
    }

    public void displayAllWaiters() {
        for (Waiter waiter : waiters) {
            waiter.displayInfo();
        }
    }

    public void displayAllOrders() {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Details: " + order.getOrderDetails());
        }
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}