import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/RestaurantDB";
        String user = "root";
        String password = "";

        try {
            Restaurant restaurant = new Restaurant(dbUrl, user, password);

            // Ajouter des clients
            Customer customer1 = new Customer("Alice", "alice@example.com", "C001");
            Customer customer2 = new Customer("Bob", "bob@example.com", "C002");
            restaurant.addCustomer(customer1);
            restaurant.addCustomer(customer2);

            // Ajouter des serveurs
            Waiter waiter1 = new Waiter("Charlie", "charlie@example.com", "W001");
            Waiter waiter2 = new Waiter("Dave", "dave@example.com", "W002");
            restaurant.addWaiter(waiter1);
            restaurant.addWaiter(waiter2);

            // Ajouter des commandes
            Order order1 = new Order("O001", "Pasta, Salad");
            Order order2 = new Order("O002", "Pizza, Coke");
            restaurant.addOrder(order1);
            restaurant.addOrder(order2);

            // Afficher tous les clients
            System.out.println("Customers:");
            restaurant.displayAllCustomers();

            // Afficher tous les serveurs
            System.out.println("Waiters:");
            restaurant.displayAllWaiters();

            // Afficher toutes les commandes
            System.out.println("Orders:");
            restaurant.displayAllOrders();

            restaurant.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
