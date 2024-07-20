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

    public void takeOrder(Order order) {
        System.out.println("Order taken: " + order.getOrderDetails());
    }
}