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

    }

    //Connects to the Frankfurter API, requests data, and parses the rate.
    private static exchangeRateFetch(String from , String to){
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
    }

}