package heidt_hart.planes;

public abstract class PassengerPlane implements PlaneIF{
    private int passengerCount;

    public int getPassengerCount(){
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount){
        this.passengerCount = passengerCount;
    }
}
