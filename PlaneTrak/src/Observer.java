import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Observer implements PropertyChangeListener {

    private int averageCargoDeliverySize;
    private int numOfCargoDeliveries;
    private int averagePassengerLoad;
    private int numOfPassengerArrivals;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public int getAverageCargoDeliverySize() {
        return averageCargoDeliverySize;
    }

    public void setAverageCargoDeliverySize(int averageCargoDeliverySize) {
        this.averageCargoDeliverySize = averageCargoDeliverySize;
    }

    public int getAveragePassengerLoad() {
        return averagePassengerLoad;
    }

    public void setAveragePassengerLoad(int averagePassengerLoad) {
        this.averagePassengerLoad = averagePassengerLoad;
    }
}
