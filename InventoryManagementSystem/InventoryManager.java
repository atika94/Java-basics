import java.util.ArrayList;

public class InventoryManager{
// implementing the inventory manager using arraylist
// Stores all products in the inventory
   private ArrayList<Product> inventory;

   //constructor
   public InventoryManager(){
        inventory = new ArrayList<>();
   }

   public void addProduct(Product product) {

     inventory.add(product);
   }


   public void displayProducts() {

   }


   public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Product laptop = new Product(101, "DELL", 50000, 5, 3, "YZ Traders");
        Product mouse = new Product(102, "Logitech", 1500, 10, 5, "ABC Traders");
        Product keyboard = new Product(103, "HP", 3500, 20, 5, "XYZ Suppliers");
        manager.addProduct(laptop);
        manager.addProduct(mouse);
        manager.addProduct(keyboard);
        manager.displayProducts();
   }
}