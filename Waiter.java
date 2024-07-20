import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Waiter extends Person {
    private String employeeId;

    public Waiter(String name, String contactInfo, String employeeId) {
        super(name, contactInfo);
        this.employeeId = employeeId;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + getName());
        System.out.println("Contact Info: " + getContactInfo());
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void addWaiter(Connection connection) throws SQLException {
        String sql = "INSERT INTO Waiters (employeeId, name, contactInfo) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, employeeId);
            pstmt.setString(2, this.getName());
            pstmt.setString(3, this.getContactInfo());
            pstmt.executeUpdate();
        }
    }

    public void updateWaiter(Connection connection, String newName, String newContactInfo) throws SQLException {
        String sql = "UPDATE Waiters SET name = ?, contactInfo = ? WHERE employeeId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newContactInfo);
            pstmt.setString(3, employeeId);
            pstmt.executeUpdate();
        }
    }

    public void removeWaiter(Connection connection) throws SQLException {
        String sql = "DELETE FROM Waiters WHERE employeeId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, employeeId);
            pstmt.executeUpdate();
        }
    }
}
