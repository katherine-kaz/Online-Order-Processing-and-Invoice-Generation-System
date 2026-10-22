import java.util.*;

public class Main {
    static List<Product> productList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("\n1. Add Product");
                System.out.println("2. Place Order");
                System.out.println("3. View Orders");
                System.out.println("4. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        placeOrder();
                        break;
                    case 3:
                        FileHandler.readOrders();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }

    public static void addProduct() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        productList.add(new Product(id, name, price));
    }

    public static void placeOrder() {
        System.out.print("Enter Customer Name: ");
        sc.nextLine();
        String cname = sc.nextLine();

        Customer c = new Customer(1, cname);
        Order order = new Order(new Random().nextInt(1000), c);

        for (Product p : productList) {
            p.display();
        }

        System.out.print("Enter product ID to add: ");
        int pid = sc.nextInt();

        for (Product p : productList) {
            if (p.getProductId() == pid) {
                order.addProduct(p);
            }
        }

        Invoice.generateInvoice(order);
        FileHandler.saveOrder(order);
    }
}