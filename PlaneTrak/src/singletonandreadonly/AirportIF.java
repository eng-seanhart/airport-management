package singletonandreadonly;

import planes.PlaneIF;

import java.util.List;

public interface AirportIF {

    public int getCargoAtAirport();

    public int getPassengersAtAirport();

    public List<PlaneIF> getPlanesAtAirport();

    public void printListOfPlanes();
}
