import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Laptop", 50000, 5, 3, "YZ Traders"));
        manager.addProduct(new Product(102, "Mouse", 1500, 10, 5, "ABC Traders"));
        manager.addProduct(new Product(103, "Keyboard", 3500, 20, 5, "XYZ Suppliers"));
        manager.addProduct(new Product(104, "Monitor", 20000, 8, 4, "LMN Distributors"));
        manager.addProduct(new Product(105, "Printer", 15000, 12, 6, "PQR Suppliers"));

        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Inventory Management System");
            System.out.println("1. Display Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Search Product");
            System.out.println("5. Update Product");
            System.out.println("6. Generate Restock Report");
            System.out.println("7. Display Low Stock Products");
            System.out.println("8. Save Inventory to CSV");
            System.out.println("9. Load Inventory from CSV");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    manager.displayProducts();
                    break;
                case 2:
                    // Code to add product
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter Threshold: ");
                    int threshold = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Supplier Name: ");
                    String supplier = sc.nextLine();

                    Product product = new Product(id, name, price, quantity, threshold, supplier);

                    manager.addProduct(product);

                    System.out.println("Product added successfully.");
                    break;
                case 3:
                    // Code to remove product
                    break;
                case 4:
                    // Code to search product
                    break;
                case 5:
                    // Code to update product
                    break;
                case 6:
                    manager.generateRestockReport();
                    break;
                case 7:
                    manager.displayLowStock();
                    break;
                case 8:
                    // Code to save inventory to CSV
                    break;
                case 9:
                    // Code to load inventory from CSV
                    break;
                
                case 10:
                    System.out.println("Exiting.Thank you for using the Inventory Management System.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }   
}