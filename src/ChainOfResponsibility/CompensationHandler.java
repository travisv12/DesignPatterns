package ChainOfResponsibility;

public class CompensationHandler extends FeedbackHandler {
    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("CompensationHandler: Reviewing compensation claim from " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());
            System.out.println("Decision: Claim approved.\n");
        } else {
            System.out.println("Forward feedback to the next handler: " + this.getNextHandlerName());
            super.handle(message);
        }
    }
}