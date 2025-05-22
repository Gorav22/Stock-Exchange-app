package StockExchangeApp.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiUtils {
    private static final String API_KEY = "TTG08E3Y7XF3IWO8";

    public static double getStockPrice(String symbol) {
        try {
            String urlString = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + API_KEY;
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String jsonResponse = response.toString();

            String searchKey = "\"05. price\": \"";
            int index = jsonResponse.indexOf(searchKey);
            if (index != -1) {
                int start = index + searchKey.length();
                int end = jsonResponse.indexOf("\"", start);
                String priceStr = jsonResponse.substring(start, end);
                return Double.parseDouble(priceStr);
            } else {
                System.out.println("Price not found for " + symbol);
                return 0.0;
            }

        } catch (Exception e) {
            System.out.println("Error fetching stock price for " + symbol);
            e.printStackTrace();
            return 0.0;
        }
    }
}
