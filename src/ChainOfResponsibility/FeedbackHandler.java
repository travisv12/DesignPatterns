package ChainOfResponsibility;

public abstract class FeedbackHandler {
    private FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(FeedbackMessage message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        } else {
            System.out.println("No handler found for message type: " + message.getType());
        }
    }

    public String getNextHandlerName() {
        return nextHandler != null ? nextHandler.getClass().getSimpleName() : "None";
    }
}