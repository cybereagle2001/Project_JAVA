import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer extends Person {
    private String customerId;

    public Customer(String name, String contactInfo, String customerId) {
        super(name, contactInfo);
        this.customerId = customerId;
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + getName());
        System.out.println("Contact Info: " + getContactInfo());
    }

    public String getCustomerId() {
        return customerId;
    }

    public void addCustomer(Connection connection) throws SQLException {
        String sql = "INSERT INTO Customers (customerId, name, contactInfo) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customerId);
            pstmt.setString(2, this.getName());
            pstmt.setString(3, this.getContactInfo());
            pstmt.executeUpdate();
        }
    }

    public void updateCustomer(Connection connection, String newName, String newContactInfo) throws SQLException {
        String sql = "UPDATE Customers SET name = ?, contactInfo = ? WHERE customerId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newContactInfo);
            pstmt.setString(3, customerId);
            pstmt.executeUpdate();
        }
    }

    public void removeCustomer(Connection connection) throws SQLException {
        String sql = "DELETE FROM Customers WHERE customerId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customerId);
            pstmt.executeUpdate();
        }
    }
}
