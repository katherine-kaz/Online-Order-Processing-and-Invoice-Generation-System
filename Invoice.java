public class Invoice {
    public static void generateInvoice(Order order) {
        System.out.println("\n------ INVOICE ------");
        order.displayOrder();
        System.out.println("---------------------");
    }
}