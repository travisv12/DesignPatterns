package Mediator;

import javafx.application.Platform;

public class ClientController implements ChatClient {

    private String username;
    private ChatMediator mediator;
    private ChatClientUI ui;

    public ClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        this.mediator.registerClient(username, this);
    }

    public void sendMessage(String recipient, String message) {
        mediator.sendMessage(username, recipient, message);
    }

    public void setUI(ChatClientUI ui) {
        this.ui = ui;
    }

    @Override
    public void receiveMessage(String sender, String message) {
        Platform.runLater(() -> ui.appendMessage(sender + ": " + message));
    }
}

