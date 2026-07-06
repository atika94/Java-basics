public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Laptop", 50000, 5, 3, "YZ Traders"));
        manager.addProduct(new Product(102, "Mouse", 1500, 10, 5, "ABC Traders"));
        manager.addProduct(new Product(103, "Keyboard", 3500, 20, 5, "XYZ Suppliers"));
        manager.addProduct(new Product(104, "Monitor", 20000, 8, 4, "LMN Distributors"));
        manager.addProduct(new Product(105, "Printer", 15000, 12, 6, "PQR Suppliers"));

        System.out.println("===== All Products =====");
        manager.displayProducts();

        System.out.println("\n===== Search Product =====");

        Product found = manager.searchProduct(103);

        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\n===== Update Product =====");

        if (manager.updateProduct(102, 1200, 15, 7, "New Supplier")) {
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\n===== Updated Inventory =====");

        manager.displayProducts();
    }
}