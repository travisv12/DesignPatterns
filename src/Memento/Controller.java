package Memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;
    private List<IMemento> redoHistory;
    private HistoryWindow historyWindow; // Reference to the history window
    private int currentIndex = -1;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        redoHistory.clear();
        model.setOption(optionNumber, choice);
        closeHistoryWindow(); // Close the history window
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        redoHistory.clear();
        model.setIsSelected(isSelected);
        closeHistoryWindow(); // Close the history window
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            IMemento currentState = model.createMemento();
            redoHistory.add(currentState);
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            IMemento currentState = model.createMemento();
            history.add(currentState);
            IMemento redoState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(redoState);
            gui.updateGui();
        }
    }

    public void restoreFromHistory(int index) {
        List<IMemento> combinedHistory = new ArrayList<>();
        combinedHistory.addAll(history);
        combinedHistory.addAll(redoHistory);
        if (index >= 0 && index < combinedHistory.size()) {
            if (currentIndex == -1) {
                currentIndex = combinedHistory.size() - 1; // Initialize to the last index
            }
            int steps = index - currentIndex;
            if (steps < 0) {
                // Perform undo() for negative steps
                for (int i = 0; i < Math.abs(steps); i++) {
                    undo();
                }
            } else if (steps > 0) {
                // Perform redo() for positive steps
                for (int i = 0; i < steps; i++) {
                    redo();
                }
            }
            currentIndex = index; // Update the current index
        }
    }

    public List<IMemento> getHistory() {
        return history;
    }

    public List<IMemento> getRedoHistory() {
        return redoHistory;
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    public void setHistoryWindow(HistoryWindow historyWindow) {
        this.historyWindow = historyWindow;
    }

    private void closeHistoryWindow() {
        if (historyWindow != null) {
            historyWindow.close();
            historyWindow = null;
        }
    }
}