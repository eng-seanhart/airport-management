package heidt_hart;

import heidt_hart.planefactories.AirbusA380Factory;
import heidt_hart.planefactories.Boeing757Factory;
import heidt_hart.planefactories.CessnaCitationXFactory;
import heidt_hart.planefactories.PlaneFactoryIF;
import heidt_hart.planes.PlaneIF;

public class Main {
    public static void main(String[] args) {

        //create singleton instance
        AirportSingleton myAirportSingleton = AirportSingleton.getAirport();

        //create observer object
        Observer observer = new Observer();

        //add observer to singleton
        myAirportSingleton.addPropertyChangeListener(observer);

        //create plane factories
        PlaneFactoryIF myAirbusFactory = new AirbusA380Factory();
        PlaneFactoryIF myCessnaFactory = new CessnaCitationXFactory();
        PlaneFactoryIF myBoeingFactory = new Boeing757Factory();

        //create heidt_hart.planes for test
        PlaneIF myAirbus = myAirbusFactory.createPlane(400);
        PlaneIF myCessna = myCessnaFactory.createPlane(10);
        PlaneIF myBoeing = myBoeingFactory.createPlane(6000);

        //add heidt_hart.planes to airport
        myAirportSingleton.addPlaneToAirport(myAirbus);
        myAirportSingleton.addPlaneToAirport(myCessna);
        myAirportSingleton.addPlaneToAirport(myBoeing);

        //print cargo and passenger counts after heidt_hart.planes created above have arrived
        System.out.println("Current Passengers Count at airport: " + myAirportSingleton.getPassengersAtAirport());
        System.out.println("Current Cargo Tonnage at airport: " + myAirportSingleton.getCargoAtAirport());

        //print heidt_hart.planes at airport
        myAirportSingleton.printListOfPlanes();

        //demonstrate that if there are too few passengers or not enough cargo at airport,
        // the function handles correctly
        myAirportSingleton.removePlaneFromAirport(0, 600);
        myAirportSingleton.removePlaneFromAirport(2, 10000);

        myAirportSingleton.removePlaneFromAirport(0, 200);
        myAirportSingleton.printListOfPlanes();
        myAirportSingleton.removePlaneFromAirport(0, 20);
        myAirportSingleton.printListOfPlanes();
        myAirportSingleton.removePlaneFromAirport(0, 2500);

        //Print heidt_hart.planes and cargo now that heidt_hart.planes have left airport
        myAirportSingleton.printListOfPlanes();
        System.out.println("Current Passengers Count at airport: " + myAirportSingleton.getPassengersAtAirport());
        System.out.println("Current Cargo Tonnage at airport: " + myAirportSingleton.getCargoAtAirport());

    }
}