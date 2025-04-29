package Mediator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClientUI {

    private String username;
    private ClientController controller;

    private TextArea messageArea;

    public ChatClientUI(String username, ClientController controller) {
        this.username = username;
        this.controller = controller;
    }

    public void start(Stage stage) {
        messageArea = new TextArea();
        messageArea.setEditable(false);

        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient username");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter your message...");

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String recipient = recipientField.getText().trim();
            String msg = inputField.getText().trim();
            if (!recipient.isEmpty() && !msg.isEmpty()) {
                controller.sendMessage(recipient, msg);
                appendMessage("You to " + recipient + ": " + msg);
                inputField.clear();
            }
        });

        VBox root = new VBox(10, messageArea, recipientField, inputField, sendButton);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Chat - " + username);
        stage.show();
    }

    public void appendMessage(String msg) {
        messageArea.appendText(msg + "\n");
    }
}

