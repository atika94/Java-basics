import java.util.ArrayList;

public class InventoryManager{
  // implementing the inventory manager using arraylist
  // Stores all products in the inventory
  private ArrayList<Product> inventory;

  //constructor
  public InventoryManager(){

    inventory = new ArrayList<>();
    
  }



   //Method to add the produt as an object
  public void addProduct(Product product) {

    inventory.add(product);

  }


  //Method to remove the product from the inventory
  public boolean removeProduct(int id) {

    Product product = searchProduct(id);

    if (product == null) {
      return false;
    }

    inventory.remove(product);
    return true;
  }





  public void displayLowStock(){
    
    boolean lowStockFound = false;

    for(Product product : inventory) {
      if(product.getQuantity() <= product.getThreshold()) {
        System.out.println(product);
        System.out.println("-----------------------------");
        lowStockFound = true;
      }
    }

    if (!lowStockFound) {
      System.out.println("No products are below the threshold.");
    }
  }






  
   //Method to display Product
  public void displayProducts() {

    if (inventory.isEmpty()) {
      System.out.println("No products available.");
       return;
    }

    for(Product product : inventory) {
      System.out.println("Product ID: " + product.getId());
      System.out.println("Product Name: " + product.getName());
      System.out.println("Product Price: " + product.getPrice());
      System.out.println("Product Quantity: " + product.getQuantity());
      System.out.println("Product Threshold: " + product.getThreshold());
      System.out.println("Supplier Name: " + product.getSupplierName());
      System.out.println("-----------------------------");
    }

  }


   
  // For Searching Product 
  public Product searchProduct(int id) {

    for(Product product : inventory) {
      if(product.getId() == id) {
        return product;
      }
    }
    return null;

  }


  // Method to generate restock report

  public void generateRestockReport() {

    boolean restockNeeded = false;

    System.out.println("\n========== RESTOCK REPORT ==========");

    for (Product product : inventory) {

        if (product.getQuantity() <= product.getThreshold()) {

            restockNeeded = true;

            int orderQuantity = product.getThreshold() - product.getQuantity();

            String status;

            if (product.getQuantity() == 0) {
                status = "OUT OF STOCK";
            } else {
                status = "LOW STOCK";
            }

            System.out.println("--------------------------------------");
            System.out.println("Product ID        : " + product.getId());
            System.out.println("Product Name      : " + product.getName());
            System.out.println("Status            : " + status);
            System.out.println("Current Quantity  : " + product.getQuantity());
            System.out.println("Threshold         : " + product.getThreshold());
            System.out.println("Suggested Order   : " + orderQuantity + " units");
        }
    }

    if (!restockNeeded) {
        System.out.println("All products are sufficiently stocked.");
    }

    System.out.println("======================================");
  }





   //Update Product
  public boolean updateProduct(int id, double newprice, int newquantity, int newthreshold, String newsupplier){

    Product product = searchProduct(id);

    if (product == null) {
      return false;
    }

    else {
      product.setPrice(newprice);
      product.setQuantity(newquantity);
      product.setThreshold(newthreshold);
      product.setSupplierName(newsupplier);

      return true;
    }

  }
  
}