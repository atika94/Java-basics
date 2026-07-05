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

   }
   public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Product laptop = new Product(104, "DELL", 50000, 05, 03, "YZ Traders");
        manager.addProduct(laptop);
   }
}