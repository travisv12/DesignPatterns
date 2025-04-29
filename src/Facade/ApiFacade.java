package Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {

    /**
     * Makes a GET request to the given URL and retrieves a specific attribute value from the JSON response.
     *
     * @param urlString The API endpoint URL
     * @param attributeName The attribute name to extract from the JSON
     * @return The value of the attribute as a String
     * @throws IllegalArgumentException if the attribute is not found
     * @throws IOException if the URL is invalid or the request fails
     */
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        try {
            String json = fetchJson(urlString);
            return extractAttributeFromJson(json, attributeName);
        } catch (ParseException e) {
            throw new IOException("Failed to parse JSON", e);
        }
    }

    private String fetchJson(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))
        ) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        } finally {
            connection.disconnect();
        }
    }

    private String extractAttributeFromJson(String json, String attributeName)
            throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(json);
        Object value = obj.get(attributeName);
        if (value == null) {
            throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in the response.");
        }
        return value.toString();
    }
}
