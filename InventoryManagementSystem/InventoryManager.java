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