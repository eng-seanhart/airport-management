package heidt_hart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Observer implements PropertyChangeListener {

    private int averageCargoDeliverySize;
    private int numOfCargoDeliveries;
    private int totalCargoDelivered;
    private int averagePassengerLoad;
    private int numOfPassengerArrivals;
    private int totalPassengersArrived;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propName = evt.getPropertyName();
        if(propName.equals("passengersArrived")){
            newPassengerArrival((int) evt.getNewValue());
            calcAveragePassengerArrival();
        }else if(propName.equals("cargoDelivered")){
            newCargoDelivery((int) evt.getNewValue());
            calcAverageCargoDeliverySize();
        }
    }

    private void calcAverageCargoDeliverySize(){
        setAverageCargoDeliverySize(totalCargoDelivered/numOfCargoDeliveries);
    }

    private void calcAveragePassengerArrival(){
        setAveragePassengerLoad(totalPassengersArrived / numOfPassengerArrivals);
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

    private void newPassengerArrival(int passengerCount){
        totalPassengersArrived += passengerCount;
        numOfPassengerArrivals++;
    }

    private void newCargoDelivery(int cargoTonnage){
        totalCargoDelivered += cargoTonnage;
        numOfCargoDeliveries++;
    }
}
