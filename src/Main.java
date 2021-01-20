import observer.WeatherAppScreen;
import producer.WeatherBaseStation;
import producer.interfaces.Observable;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        WeatherBaseStation station = new WeatherBaseStation();
        WeatherBaseStation station2 = new WeatherBaseStation();

        WeatherAppScreen app1 = new WeatherAppScreen(station);
        WeatherAppScreen app2 = new WeatherAppScreen(station);

        Thread t1 = new Thread(station);
        Thread t2 = new Thread(station2);
        t1.start();
        t2.start();

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("================================================================================================================");

        app2.unsubscribe();
        app2.setBaseStation(station2);
        app2.subscribe();
    }
}
