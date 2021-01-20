package producer.interfaces;
import observer.interfaces.Observer;

public interface Observable {
    public void subscribe(Observer o);
    public void unsubscribe(Observer o);
}
