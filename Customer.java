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
}