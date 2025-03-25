package Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        PhoneDisplay phone1 = new PhoneDisplay("Phone 1");
        PhoneDisplay phone2 = new PhoneDisplay("Phone 2");
        TVDisplay tv1 = new TVDisplay("TV 1");

        // Register observers
        station.addObserver(phone1);
        station.addObserver(phone2);
        station.addObserver(tv1);

        // Start the weather station thread
        Thread weatherThread = new Thread(station);
        weatherThread.start();

        // Let the simulation run for 15 seconds, then remove an observer
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Removing Phone 1 from observers...");
        station.removeObserver(phone1);
    }
}
