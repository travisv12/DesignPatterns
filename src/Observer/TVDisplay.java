package Observer;

public class TVDisplay implements WeatherObserver {
    private String name;

    public TVDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " (TV Display): Weather update: " + temperature + "°C");
    }
}
