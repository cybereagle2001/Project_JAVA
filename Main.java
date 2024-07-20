import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void CRUD_Customer(Restaurant restaurant) throws SQLException {
        Scanner answer = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("***       Welcome to CRUD Customer         ***");
        System.out.println("*** With Our software handle your business ***");
        System.out.println("**********************************************");
        System.out.println("\n");
        System.out.println("Please choose an option: \n 1) ADD CUSTOMER \n 2) UPDATE CUSTOMER \n 3) REMOVE CUSTOMER \n 4) DISPLAY CUSTOMERS \n 5) GO BACK");
        System.out.printf("user > ");
        int option = answer.nextInt();
        answer.nextLine();  // Consume newline

        switch (option) {
            case 1:
                System.out.printf("Name: ");
                String name_customer = answer.nextLine();
                System.out.printf("Contact Info: ");
                String contact_info = answer.nextLine();
                System.out.printf("Customer ID: ");
                String customer_id = answer.nextLine();
                Customer customer = new Customer(name_customer, contact_info, customer_id);
                restaurant.addCustomer(customer);
                CRUD_Customer(restaurant);
                break;
            case 2:
                System.out.printf("Customer ID to update: ");
                String update_id = answer.nextLine();
                System.out.printf("New Name: ");
                String new_name = answer.nextLine();
                System.out.printf("New Contact Info: ");
                String new_contact_info = answer.nextLine();
                restaurant.updateCustomer(update_id, new_name, new_contact_info);
                CRUD_Customer(restaurant);
                break;
            case 3:
                System.out.printf("Customer ID to remove: ");
                String remove_id = answer.nextLine();
                restaurant.removeCustomer(remove_id);
                CRUD_Customer(restaurant);
                break;
            case 4:
                restaurant.displayAllCustomers();
                CRUD_Customer(restaurant);
                break;
            case 5:
                CRUD_MENU(restaurant);
                break;
            default:
                System.out.println("Invalid option.");
                CRUD_Customer(restaurant);
                break;
        }
    }

    public static void CRUD_WAITER(Restaurant restaurant) throws SQLException {
        Scanner answer = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("***        Welcome to CRUD Waiter          ***");
        System.out.println("*** With Our software handle your business ***");
        System.out.println("**********************************************");
        System.out.println("\n");
        System.out.println("Please choose an option: \n 1) ADD WAITER \n 2) UPDATE WAITER \n 3) REMOVE WAITER \n 4) DISPLAY WAITERS \n 5) GO BACK");
        System.out.printf("user > ");
        int option = answer.nextInt();
        answer.nextLine();  // Consume newline

        switch (option) {
            case 1:
                System.out.printf("Name: ");
                String name_waiter = answer.nextLine();
                System.out.printf("Contact Info: ");
                String contact_info = answer.nextLine();
                System.out.printf("Employee ID: ");
                String employee_id = answer.nextLine();
                Waiter waiter = new Waiter(name_waiter, contact_info, employee_id);
                restaurant.addWaiter(waiter);
                CRUD_WAITER(restaurant);
                break;
            case 2:
                System.out.printf("Employee ID to update: ");
                String update_id = answer.nextLine();
                System.out.printf("New Name: ");
                String new_name = answer.nextLine();
                System.out.printf("New Contact Info: ");
                String new_contact_info = answer.nextLine();
                restaurant.updateWaiter(update_id, new_name, new_contact_info);
                CRUD_WAITER(restaurant);
                break;
            case 3:
                System.out.printf("Employee ID to remove: ");
                String remove_id = answer.nextLine();
                restaurant.removeWaiter(remove_id);
                CRUD_WAITER(restaurant);
                break;
            case 4:
                restaurant.displayAllWaiters();
                CRUD_WAITER(restaurant);
                break;
            case 5:
                CRUD_MENU(restaurant);
                break;
            default:
                System.out.println("Invalid option.");
                CRUD_WAITER(restaurant);
                break;
        }
    }

    public static void CRUD_ORDER(Restaurant restaurant) throws SQLException {
        Scanner answer = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("***         Welcome to CRUD Order          ***");
        System.out.println("*** With Our software handle your business ***");
        System.out.println("**********************************************");
        System.out.println("\n");
        System.out.println("Please choose an option: \n 1) ADD ORDER \n 2) UPDATE ORDER \n 3) REMOVE ORDER \n 4) DISPLAY ORDERS \n 5) GO BACK");
        System.out.printf("user > ");
        int option = answer.nextInt();
        answer.nextLine();  // Consume newline

        switch (option) {
            case 1:
                System.out.printf("Order Details: ");
                String order_details = answer.nextLine();
                System.out.printf("Order ID: ");
                String order_id = answer.nextLine();
                Order order = new Order(order_id, order_details);
                restaurant.addOrder(order);
                CRUD_ORDER(restaurant);
                break;
            case 2:
                System.out.printf("Order ID to update: ");
                String update_id = answer.nextLine();
                System.out.printf("New Order Details: ");
                String new_order_details = answer.nextLine();
                restaurant.updateOrder(update_id, new_order_details);
                CRUD_ORDER(restaurant);
                break;
            case 3:
                System.out.printf("Order ID to remove: ");
                String remove_id = answer.nextLine();
                restaurant.removeOrder(remove_id);
                CRUD_ORDER(restaurant);
                break;
            case 4:
                restaurant.displayAllOrders();
                CRUD_ORDER(restaurant);
                break;
            case 5:
                CRUD_MENU(restaurant);
                break;
            default:
                System.out.println("Invalid option.");
                CRUD_ORDER(restaurant);
                break;
        }
    }

    public static void CRUD_MENU(Restaurant restaurant) throws SQLException {
        Scanner answer = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("***           Welcome to CRUD              ***");
        System.out.println("*** With Our software handle your business ***");
        System.out.println("**********************************************");
        System.out.println("\n");
        System.out.println("Please choose an option: \n 1) CRUD Waiter \n 2) CRUD Customer \n 3) CRUD Orders \n 4) Exit");
        System.out.printf("user > ");
        int x = answer.nextInt();

        switch (x) {
            case 1:
                CRUD_WAITER(restaurant);
                break;
            case 2:
                CRUD_Customer(restaurant);
                break;
            case 3:
                CRUD_ORDER(restaurant);
                break;
            case 4:
                System.exit(0); // the zero status stops execution with code: kill process
                break;
            default:
                System.out.println("Invalid option.");
                CRUD_MENU(restaurant);
                break;
        }
    }

    public static void menu(Restaurant restaurant) throws SQLException {
        Scanner answer = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("***          Handle Your Restaurant        ***");
        System.out.println("***               Group TIC-1-P            ***");
        System.out.println("** Oussama BHD, Imed BRAHMI, Adem BELGHITH **");
        System.out.println("**              Amine Jlassi                **");
        System.out.println("**********************************************");
        System.out.println("\n");
        System.out.println("Please choose an option: \n 1) Write Y to continue \n 2) Write N to leave");
        System.out.printf("user > ");
        String x = answer.nextLine();
        switch (x) {
            case "Y":
                CRUD_MENU(restaurant);
                break;
            case "N":
                System.exit(0); // the zero status stops execution with code: kill process
                break;
            default:
                menu(restaurant);
                break;
        }
    }

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/RestaurantDB";
        String user = "root";
        String password = "";
        Restaurant restaurant = new Restaurant(dbUrl, user, password);
        menu(restaurant);
    }
}
