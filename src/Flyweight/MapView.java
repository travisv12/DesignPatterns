package Flyweight;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MapView extends Application {

    private static final int TILE_SIZE = 64; // pixel size of one tile

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RPG Map Generator");

        // UI Elements
        Label mapTypeLabel = new Label("Select Map Type:");
        ComboBox<String> mapTypeComboBox = new ComboBox<>();
        mapTypeComboBox.getItems().addAll("City", "Wilderness");
        mapTypeComboBox.getSelectionModel().selectFirst();

        Label widthLabel = new Label("Map Width:");
        TextField widthField = new TextField("10");

        Label heightLabel = new Label("Map Height:");
        TextField heightField = new TextField("5");

        Button generateButton = new Button("Generate Map");

        // Layout
        VBox vbox = new VBox(10, mapTypeLabel, mapTypeComboBox, widthLabel, widthField, heightLabel, heightField, generateButton);
        vbox.setPadding(new Insets(20));
        vbox.setPrefWidth(300);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Button Action
        generateButton.setOnAction(e -> {
            try {
                int width = Integer.parseInt(widthField.getText());
                int height = Integer.parseInt(heightField.getText());
                String selectedType = mapTypeComboBox.getValue().toLowerCase();

                if (width <= 0 || height <= 0) {
                    showAlert("Width and height must be positive integers.");
                    return;
                }

                Map map = createMap(selectedType, width, height);
                if (map == null) {
                    showAlert("Invalid map type selected.");
                    return;
                }

                showGeneratedMap(map);

            } catch (NumberFormatException ex) {
                showAlert("Please enter valid integers for width and height.");
            }
        });
    }

    private Map createMap(String type, int width, int height) {
        return switch (type) {
            case "city" -> new CityMap(width, height);
            case "wilderness" -> new WildernessMap(width, height);
            default -> null;
        };
    }

    private void showGeneratedMap(Map map) {
        Stage mapStage = new Stage();
        mapStage.setTitle("Generated " + map.getClass().getSimpleName());

        int canvasWidth = map.width * TILE_SIZE;
        int canvasHeight = map.height * TILE_SIZE;

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Drawing
        for (int i = 0; i < map.height; i++) {
            for (int j = 0; j < map.width; j++) {
                Tile tile = map.tiles[i][j];
                TileGraphic graphic = TileGraphicFactory.getTileGraphic(tile.getType());
                gc.drawImage(graphic.getImage(), j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        mapStage.setScene(new Scene(root));
        mapStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
