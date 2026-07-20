public class Patterns{
    public static void main(String[] args) {
        int n = 5; // Number of rows



        //pattern rectangle
        for (int i = 1; i <= 4; i++){
            for (int j = 1; j <= 5; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println(" \n ");



        //pattern holow rectangle
        for (int i = 1; i <= 4; i++){
            for (int j = 1; j<= 5; j++){
                if(i==1 || i == 4 || j==1 || j==5 ){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }



        System.out.println(" \n ");



        //pattern Right angle triangle 
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println(" \n ");

        //pattern Inverted right angle triangle
        for(int i = 1; i <= 4 ; i++){
            for(int j = 4; j >= i; j--){
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println(" \n ");


        //pattern 180 rotated right anle triangle 
        for(int i = 1; i <= 4; i++){
            for(int j = 3; j >= i; j--){
                System.out.print(" ");
            }
            for(int k = 1; k <= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }











        // // Pattern 3: Pyramid
        // System.out.println("\nPattern 3:");
        // for (int i = 1; i <= n; i++) {
        //     for (int j = n; j > i; j--) {
        //         System.out.print(" ");
        //     }
        //     for (int k = 1; k <= (2 * i - 1); k++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // // Pattern 4: Diamond
        // System.out.println("\nPattern 4:");
        // for (int i = 1; i <= n; i++) {
        //     for (int j = n; j > i; j--) {
        //         System.out.print(" ");
        //     }
        //     for (int k = 1; k <= (2 * i - 1); k++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // for (int i = n - 1; i >= 1; i--) {
        //     for (int j = n; j > i; j--) {
        //         System.out.print(" ");
        //     }
        //     for (int k = 1; k <= (2 * i - 1); k++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
    }
}