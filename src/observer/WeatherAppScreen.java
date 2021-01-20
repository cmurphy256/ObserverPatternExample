package observer;

import observer.interfaces.Observer;
import producer.WeatherBaseStation;

public class WeatherAppScreen implements Observer {

    private WeatherBaseStation baseStation;
    private double currentTemperature;
    private double previousTemperature;

    public WeatherAppScreen(WeatherBaseStation station){
        this.baseStation = station;
        this.subscribe();
    }

    @Override
    public void update() {
        this.previousTemperature = this.currentTemperature;
        this.currentTemperature = this.baseStation.getTemperature();
        display();
    }

    public void subscribe(){
        this.baseStation.subscribe(this);
    }

    public void unsubscribe(){
        this.baseStation.unsubscribe(this);
    }

    public void setBaseStation(WeatherBaseStation baseStation) {
        this.baseStation = baseStation;
    }

    public void display(){
        System.out.println("--------------------------------------------------------");
        System.out.println("The current temperature is : "+ this.currentTemperature + "\u00B0 F");
        System.out.println("The previous temperature is : "+ this.previousTemperature + "\u00B0 F");
        System.out.println("--------------------------------------------------------");
    }
}
