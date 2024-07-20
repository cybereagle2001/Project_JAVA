import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
