package Facade;

import java.io.IOException;

public class ApiClientDemo {
    public static void main(String[] args) {
        ApiFacade apiFacade = new ApiFacade();

        try {
            // Chuck Norris joke
            String joke = apiFacade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris Joke:\n" + joke + "\n");

            // Retrieve a fact about cat
            String catFact = apiFacade.getAttributeValueFromJson(
                    "https://catfact.ninja/fact", "fact");
            System.out.println("Cat Fact:\n" + catFact);

        } catch (IllegalArgumentException e) {
            System.err.println("Missing attribute: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("API error: " + e.getMessage());
        }
    }
}

