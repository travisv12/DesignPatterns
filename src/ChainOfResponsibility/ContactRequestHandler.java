package ChainOfResponsibility;

public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.CONTACT) {
            System.out.println("ContactRequestHandler: Forwarding contact request to support team.");
            System.out.println("Email: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent() + "\n");
        } else {
            System.out.println("Forward feedback to the next handler: " + this.getNextHandlerName());
            super.handle(message);
        }
    }
}