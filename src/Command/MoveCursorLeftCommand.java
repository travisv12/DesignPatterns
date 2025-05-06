package Command;

public class MoveCursorLeftCommand implements Command {
    private final PixelGrid grid;

    public MoveCursorLeftCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveLeft();
    }
}

