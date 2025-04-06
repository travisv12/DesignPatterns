package ChainOfResponsibility;

public class SuggestionHandler extends FeedbackHandler {
    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.SUGGESTION) {
            System.out.println("SuggestionHandler: Logging suggestion from " + message.getSenderEmail());
            System.out.println("Suggestion: " + message.getContent());
            System.out.println("Status: Added to product roadmap.\n");
        } else {
            System.out.println("Forward feedback to the next handler: " + this.getNextHandlerName());
            super.handle(message);
        }
    }
}