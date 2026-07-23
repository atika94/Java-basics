public class Product {

        // Encapsulation

        private int id;
        private String name;
        private double price;
        private int quantity;
        private int threshold;
        private String supplierName;

        //getter method
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getThreshold() {
            return threshold;
        }

        public String getSupplierName() {
            return supplierName;
        }


        //setters

        public void setId(int id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setPrice(double price) {
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }

        public void setSupplierName(String supplierName) {
            this.supplierName = supplierName;
        }


        //constructor
        public Product(int id, String name, double price, int quantity, int threshold, String supplierName){

                this.id = id;
                this.name = name;
                this.price = price;
                this.quantity = quantity;
                this.threshold = threshold;
                this.supplierName = supplierName;

            }

            @Override
        public String toString() {
            return "ID: " + id +
           "\nName: " + name +
           "\nPrice: " + price +
           "\nQuantity: " + quantity +
           "\nThreshold: " + threshold +
           "\nSupplier: " + supplierName;
        }

    public boolean isLowStock() {
    return quantity <= threshold;
    }

        // public static void main(String[] args){            
        //     Product obj1 = new Product(101, "Laptop", 85000, 15, 5, "ABC Traders");   
        //     Product obj2 = new Product(102, "Mouse", 1200, 30, 10, "Logitech");
        //     Product obj3 = new Product( 103, "Keyboard", 3500, 20, 5, "HP");

        //     System.out.println("                 Product 1");
        //     System.out.println(obj1.toString()); 
        //     System.out.println("                 Product 2");
        //     System.out.println(obj2.toString()); 
        //     System.out.println("                 Product 3");
        //     System.out.println(obj3.toString()); 

        // }

}