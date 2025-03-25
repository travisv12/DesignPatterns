package Observer;

import java.util.Random;

public class WeatherStation extends Observable implements Runnable {
    private int temperature;
    private final int MIN_TEMP = -10;
    private final int MAX_TEMP = 40;
    private Random random = new Random();

    public WeatherStation() {
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000); // Random delay (1-5 sec)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int change = random.nextBoolean() ? 1 : -1;
            temperature = Math.max(MIN_TEMP, Math.min(MAX_TEMP, temperature + change));

            System.out.println("WeatherStation: New temperature = " + temperature + "°C");
            notifyObservers(temperature);
        }
    }
}
