package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<WeatherObserver> observers = new ArrayList<>();

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(int temperature) {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}