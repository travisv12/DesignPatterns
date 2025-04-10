package Memento;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class HistoryWindow {

    private List<IMemento> history;
    private List<IMemento> redoHistory;
    private Controller controller;
    private Stage stage;

    public HistoryWindow(List<IMemento> history, List<IMemento> redoHistory, Controller controller) {
        this.history = history;
        this.redoHistory = redoHistory;
        this.controller = controller;
        showWindow();
        controller.setHistoryWindow(this);
    }

    private void showWindow() {
        this.stage = new Stage();
        stage.setTitle("History");

        ListView<String> listView = new ListView<>();
        for (int i = 0; i < history.size(); i++) {
            IMemento m = history.get(i);
            listView.getItems().add(i + ": " + m.getTimestampFormatted());
        }
        for (int i = 0; i < redoHistory.size(); i++) {
            IMemento m = redoHistory.get(i);
            listView.getItems().add(i + ": " + m.getTimestampFormatted());
        }

        listView.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            int index = newVal.intValue();
            controller.restoreFromHistory(index);
        });

        VBox vbox = new VBox(listView);
        stage.setScene(new Scene(vbox, 300, 400));
        stage.show();
    }

    public void close() {
        if (stage != null) {
            stage.close(); // Close the stage
        }
    }
}
