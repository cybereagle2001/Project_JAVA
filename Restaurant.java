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
        customer.addCustomer(connection);
        customers.add(customer);
    }

    public void updateCustomer(String customerId, String newName, String newContactInfo) throws SQLException {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                customer.updateCustomer(connection, newName, newContactInfo);
                break;
            }
        }
    }

    public void removeCustomer(String customerId) throws SQLException {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                customer.removeCustomer(connection);
                customers.remove(customer);
                break;
            }
        }
    }

    public void addWaiter(Waiter waiter) throws SQLException {
        waiter.addWaiter(connection);
        waiters.add(waiter);
    }

    public void updateWaiter(String employeeId, String newName, String newContactInfo) throws SQLException {
        for (Waiter waiter : waiters) {
            if (waiter.getEmployeeId().equals(employeeId)) {
                waiter.updateWaiter(connection, newName, newContactInfo);
                break;
            }
        }
    }

    public void removeWaiter(String employeeId) throws SQLException {
        for (Waiter waiter : waiters) {
            if (waiter.getEmployeeId().equals(employeeId)) {
                waiter.removeWaiter(connection);
                waiters.remove(waiter);
                break;
            }
        }
    }

    public void addOrder(Order order) throws SQLException {
        order.addOrder(connection);
        orders.add(order);
    }

    public void updateOrder(String orderId, String newOrderDetails) throws SQLException {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                order.updateOrder(connection, newOrderDetails);
                break;
            }
        }
    }

    public void removeOrder(String orderId) throws SQLException {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                order.removeOrder(connection);
                orders.remove(order);
                break;
            }
        }
    }

    public void displayAllCustomers() throws SQLException {
        String query = "SELECT * FROM Customers";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println("Customer ID: " + resultSet.getString("customerId") +
                        ", Name: " + resultSet.getString("name") +
                        ", Contact Info: " + resultSet.getString("contactInfo"));
            }
        }
    }

    public void displayAllWaiters() throws SQLException {
        String query = "SELECT * FROM Waiters";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getString("employeeId") +
                        ", Name: " + resultSet.getString("name") +
                        ", Contact Info: " + resultSet.getString("contactInfo"));
            }
        }
    }

    public void displayAllOrders() throws SQLException {
        String query = "SELECT * FROM Orders";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println("Order ID: " + resultSet.getString("orderId") +
                        ", Details: " + resultSet.getString("orderDetails"));
            }
        }
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
