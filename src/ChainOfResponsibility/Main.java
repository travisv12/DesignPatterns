package ChainOfResponsibility;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create handlers
        FeedbackHandler compensation = new CompensationHandler();
        FeedbackHandler contact = new ContactRequestHandler();
        FeedbackHandler suggestion = new SuggestionHandler();
        FeedbackHandler general = new GeneralFeedbackHandler();

        // Set up the chain
        compensation.setNextHandler(contact);
        contact.setNextHandler(suggestion);
        suggestion.setNextHandler(general);

        // Create test messages
        List<FeedbackMessage> messages = List.of(
                new FeedbackMessage(MessageType.COMPENSATION, "I want a refund for a faulty product.", "alice@example.com"),
                new FeedbackMessage(MessageType.CONTACT, "Please call me about my account.", "bob@example.com"),
                new FeedbackMessage(MessageType.SUGGESTION, "Add dark mode to the app!", "charlie@example.com"),
                new FeedbackMessage(MessageType.GENERAL, "Great customer service!", "diana@example.com"),
                new FeedbackMessage(null, "This message has an undefined type.", "unknown@example.com")
        );

        // Handle messages
        for (FeedbackMessage msg : messages) {
            System.out.println("Processing new feedback...");
            try {
                compensation.handle(msg);
            } catch (Exception e) {
                System.out.println("Error processing message: " + e.getMessage());
            }
        }
    }
}