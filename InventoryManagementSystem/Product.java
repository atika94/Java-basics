import java.util.*;
public class Product {
    public static void main(String[] args){
        System.out.println("This is the product list.");
        private int id;
        private String name;
        private double price;
        private int quantity;
        private int threshold;
        private String supplierName;


        //constructor
        public Product(int id, String name, double price, int quantity, int threshold, String supplierName){
                this.id = id;
                this.name = name;
                this.price = price;
                this.quantity = quantity;
                this.threshold = threshold;
                this.supplierName = supplierName;
               }
    }
}