package producer;

import observer.interfaces.Observer;
import producer.interfaces.Observable;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class WeatherBaseStation implements Observable, Runnable {

    private ArrayList<Observer> observers;
    private double temperature;
    private int humidity;

    public WeatherBaseStation() {
        this.observers = new ArrayList<>();
    }

    public WeatherBaseStation(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public void generateWeather(){
        this.temperature = Math.random()*212;
        //this.humidity = 30;
        notifyAllObservers();
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyAllObservers();
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        notifyAllObservers();
    }

    @Override
    public void subscribe(Observer o) {
        observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    private void notifyAllObservers(){
        observers.forEach(Observer::update);
    }

    @Override
    public void run() {
        while(true){
            generateWeather();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
