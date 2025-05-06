package Command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtEditorGUI extends Application {

    private final Rectangle[][] cellViews = new Rectangle[8][8];
    private final PixelGrid grid = new PixelGrid();

    private final Command moveUp = new MoveCursorUpCommand(grid);
    private final Command moveDown = new MoveCursorDownCommand(grid);
    private final Command moveLeft = new MoveCursorLeftCommand(grid);
    private final Command moveRight = new MoveCursorRightCommand(grid);
    private final Command togglePixel = new TogglePixelCommand(grid);
    private final Command generateCode = new GenerateCodeCommand(grid);

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle rect = new Rectangle(40, 40);
                rect.setStroke(Color.GRAY);
                rect.setFill(Color.WHITE);
                gridPane.add(rect, col, row);
                cellViews[row][col] = rect;
            }
        }

        Button codeButton = new Button("Create Code");
        codeButton.setOnAction(e -> generateCode.execute());
        codeButton.setFocusTraversable(false);

        BorderPane root = new BorderPane();
        root.setCenter(gridPane);
        root.setBottom(codeButton);

        Scene scene = new Scene(root, 350, 400);

        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            switch (code) {
                case UP -> moveUp.execute();
                case DOWN -> moveDown.execute();
                case LEFT -> moveLeft.execute();
                case RIGHT -> moveRight.execute();
                case SPACE -> togglePixel.execute();
                default -> {}
            }
            updateView();
        });

        updateView();
        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateView() {
        int[][] pixels = grid.getGrid();
        int cursorRow = grid.getCursorRow();
        int cursorCol = grid.getCursorCol();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle rect = cellViews[row][col];
                if (pixels[row][col] == 1) {
                    rect.setFill(Color.BLACK);
                } else {
                    rect.setFill(Color.WHITE);
                }

                // Cursor highlight
                if (row == cursorRow && col == cursorCol) {
                    rect.setStroke(Color.RED);
                    rect.setStrokeWidth(3);
                    rect.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
                } else {
                    rect.setStroke(Color.GRAY);
                    rect.setStrokeWidth(1);
                    rect.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
                }
            }
        }
    }

}
