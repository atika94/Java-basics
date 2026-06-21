import java.util.*;
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



    //Connects to the Frankfurter API, requests data, and parses the rate.
    private static exchangeRateFetch(String from , String to) throws Exception{
        // URL construction
        String urlString = "https://api.frankfurter.dev/v1/latest?base=" + from + "&symbols=" + to;
        URL url = new URL(urlString);
        // Open HTTP connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000); // Stop waiting after 5 seconds if connection is dead
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
        // Pure Java String Parsing Twist: 
        // We look for the position of our target currency inside the JSON string 
        // Example slice: "rates":{"EUR":0.9334}
        String searchTarget = "\"" + to + "\":";
        int targetIndex = jsonResponse.indexOf(searchTarget);
        if (targetIndex == -1) {
            return -1; // Target currency key not found in response
        }

        // Cut the string starting immediately after the ":" sign up to the closing bracket "}"
        int startIndex = targetIndex + searchTarget.length();
        int endIndex = jsonResponse.indexOf("}", startIndex);
        String rateString = jsonResponse.substring(startIndex, endIndex).trim();

        // Convert raw string text back into a mathematical double
        return Double.parseDouble(rateString);
    }

}