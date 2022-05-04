package heidt_hart;

import heidt_hart.authentication.Middleware;
import heidt_hart.planes.CargoPlane;
import heidt_hart.planes.PassengerPlane;
import heidt_hart.planes.PlaneIF;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportSingleton{

    private static AirportSingleton airport = null;

    private List<PlaneIF> planesAtAirport = new ArrayList<>();

    private int cargoAtAirport;

    private int passengersAtAirport;

    private static PropertyChangeSupport support;
    private AirportSingleton(){
        support = new PropertyChangeSupport(this);
    }

    public static AirportSingleton getAirport(){
        if(airport == null){
            airport = new AirportSingleton();
        }
        return airport;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl){
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl){
        support.removePropertyChangeListener(pcl);
    }

    public void addPlaneToAirport(PlaneIF plane){
        if(plane instanceof CargoPlane){
            plane = (CargoPlane) plane;
            addCargoToAirport(((CargoPlane) plane).getCargoTonnage());
            support.firePropertyChange("cargoDelivered", cargoAtAirport -
                    ((CargoPlane) plane).getCargoTonnage(), cargoAtAirport);
            ((CargoPlane) plane).setCargoTonnage(0);
        }else{
            plane = (PassengerPlane) plane;
            addPassengersToAirport(((PassengerPlane) plane).getPassengerCount());
            support.firePropertyChange("passengersArrived", passengersAtAirport -
                    ((PassengerPlane) plane).getPassengerCount(), passengersAtAirport);
            ((PassengerPlane) plane).setPassengerCount(0);
        }
        planesAtAirport.add(plane);
    }

    public PlaneIF removePlaneFromAirport(int arrayListSpot, int planeCarryValue){
        if(planesAtAirport.size() == 0){
            System.out.println("No heidt_hart.planes at airport.");
            return null;
        }

        PlaneIF plane = planesAtAirport.get(arrayListSpot);
        if(plane instanceof CargoPlane){
            if(getCargoAtAirport() < planeCarryValue){
                System.out.println("Not enough cargo at airport.");
                return null;
            }
            removeCargoFromAirport(planeCarryValue);
            ((CargoPlane) plane).setCargoTonnage(planeCarryValue);
        }else{
            if(passengersAtAirport < planeCarryValue){
                System.out.println("Not enough passengers at airport.");
                return null;
            }
            removePassengersFromAirport(planeCarryValue);
            ((PassengerPlane) plane).setPassengerCount(planeCarryValue);
        }
        planesAtAirport.remove(arrayListSpot);
        return plane;
    }

    public int getCargoAtAirport(){
        return cargoAtAirport;
    }

    public void addCargoToAirport(int cargo){
        this.cargoAtAirport += cargo;
    }

    public void removeCargoFromAirport(int cargo){
        this.cargoAtAirport -= cargo;
    }

    public int getPassengersAtAirport(){
        return passengersAtAirport;
    }

    public void addPassengersToAirport(int passengers){
        this.passengersAtAirport += passengers;
    }

    public void removePassengersFromAirport(int passengers){
        this.passengersAtAirport -= passengers;
    }

    public void printListOfPlanes(){
        System.out.println(planesAtAirport.toString());
    }

    public List<PlaneIF> getPlanesAtAirport(){
        return planesAtAirport;
    }

    // Server
    // Chain of Command
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    /**
     * Client passes a chain of object to server. This improves flexibility and
     * makes testing the server class easier.
     */
    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    /**
     * Server gets email and password from client and sends the authorization
     * request to the chain.
     */
    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.

            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }




}
