package Command;

public class MoveCursorDownCommand implements Command {
    private final PixelGrid grid;

    public MoveCursorDownCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveDown();
    }
}

