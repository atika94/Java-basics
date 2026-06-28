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

            @
        public String toString() {
            return "ID: " + id +
           "\nName: " + name +
           "\nPrice: " + price +
           "\nQuantity: " + quantity +
           "\nThreshold: " + threshold +
           "\nSupplier: " + supplierName;
        }

        public static void main(String[] args){            
            Product obj = new Product(
                    101,
                    "Laptop",
                    85000,
                    15,
                    5,
                    "ABC Traders"
            );           
             System.out.println(obj.toString()); 
        }

}