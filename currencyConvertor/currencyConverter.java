import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class CurrencyConverter {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the live Currency Converter");
        System.out.println("From(eg. USD, PKR, EUR etc) : ");
        String fromCurrency = sc.next().toUpperCase();
        System.out.println("Amount : ");
        double amount = sc.nextDouble();
        System.out.println("TO :");
        String toCurrency = sc.next().toUpperCase();

        try {
            // FIXED: Matches the exact name of the method below now
            double rate = fetchExchangeRate(fromCurrency, toCurrency);
            
            if (rate == -1) {
                System.out.println("\nError: Could not retrieve valid exchange rates. Check currency codes.");
            } else {
                double convertedAmount = amount * rate;
                System.out.printf("\nResult: %.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
                System.out.printf("(Live Exchange Rate: 1 %s = %.4f %s)\n", fromCurrency, rate, toCurrency);
            }
        } catch (Exception e) {
            System.out.println("\nNetwork/Connection Error: " + e.getMessage());
        }

        sc.close();
    }

    // FIXED: Changed name to fetchExchangeRate and added the 'double' return type
    private static double fetchExchangeRate(String from , String to) throws Exception {
        // URL construction
        String urlString = "https://open.er-api.com/v6/latest/" + from;
        URL url = new URL(urlString);
        
        // Open HTTP connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000); 
        connection.setReadTimeout(5000);
        int responseCode = connection.getResponseCode();

        // If the request isn't successful (HTTP 200 OK), exit early
        if (responseCode != 200) {
            return -1;
        }

        // Read the API textual stream response line by line
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseText = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            responseText.append(line);
        }
        reader.close();

        // Convert response data to a clean string
        String jsonResponse = responseText.toString();
        
        String searchTarget = "\"" + to + "\":";
        int targetIndex = jsonResponse.indexOf(searchTarget);
        if (targetIndex == -1) {
            return -1; 
        }

        // Cut the string starting immediately after the ":" sign up to the closing bracket "}"
        int startIndex = targetIndex + searchTarget.length();
        int endIndex = jsonResponse.indexOf("}", startIndex);
        String rateString = jsonResponse.substring(startIndex, endIndex).trim();

        // Convert raw string text back into a mathematical double
        return Double.parseDouble(rateString);
    }
}