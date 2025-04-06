package ChainOfResponsibility;

public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.GENERAL) {
            System.out.println("GeneralFeedbackHandler: Analyzing general feedback.");
            System.out.println("From: " + message.getSenderEmail());
            System.out.println("Feedback: " + message.getContent());
            System.out.println("Response: Thank you for your feedback!\n");
        } else {
            System.out.println("Forward feedback to the next handler: " + this.getNextHandlerName());
            super.handle(message);
        }
    }
}