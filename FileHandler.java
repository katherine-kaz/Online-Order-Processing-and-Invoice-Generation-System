import java.io.*;

public class FileHandler {

    public static void saveOrder(Order order) {
        try {
            FileWriter fw = new FileWriter("orders.txt", true);
            fw.write("Order Saved\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    public static void readOrders() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("orders.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}