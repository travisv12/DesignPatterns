package Mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChatAppLauncher extends Application {

    private ChatMediator mediator = new ChatServer();

    @Override
    public void start(Stage primaryStage) {
        launchClientWindow("Alice");
        launchClientWindow("Bob");
        launchClientWindow("Charlie");
    }

    private void launchClientWindow(String username) {
        ClientController controller = new ClientController(username, mediator);
        ChatClientUI ui = new ChatClientUI(username, controller);
        controller.setUI(ui);
        ui.start(new Stage());
    }
}
