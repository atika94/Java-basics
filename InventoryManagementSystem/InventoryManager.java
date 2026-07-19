import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

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
        } 
        else {
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








  // file handling  saving and loading data from csv file
  // Method to save inventory data to a CSV file

  public void saveToCSV(String filename) {
   try ( FileWriter writer = new FileWriter(filename)){
    for(Product product : inventory){
      String line = product.getId() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity() + "," + product.getThreshold() + "," + product.getSupplierName() + "\n";
      writer.write(line + "\n" );
    }
      System.out.println("Inventory saved successfully to " + filename);

   }
   catch (IOException e) {
        System.out.println("Error saving file." + e.getMessage());
    }
  }


  public void loadFromCSV(String filename) {
    try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
      inventory.clear(); // Clear existing inventory before loading new data
      String line;
      while((line = reader.readLine()) != null){
        if (line.trim().isEmpty()) {
          continue; // Skip empty lines
        }
        String[] data = line.split(",");
        int id = Integer.parseInt(data[0]);
        double price = Double.parseDouble(data[2]);
        int quantity = Integer.parseInt(data[3]);
        int threshold = Integer.parseInt(data[4]);
        String supplierName = data[5];
        String name = data[1];
        Product product = new Product(id, name, price, quantity, threshold, supplierName);
        inventory.add(product);
      }
      System.out.println("Inventory loaded successfully from " + filename);
    }
    catch(IOException e) {
        System.out.println("Error loading file: " + e.getMessage());
    }
  } 

}