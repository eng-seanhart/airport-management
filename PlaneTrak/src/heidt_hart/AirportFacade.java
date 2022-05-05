package heidt_hart;

import heidt_hart.authentication.CredentialMiddleware;
import heidt_hart.authentication.Middleware;
import heidt_hart.authentication.RequestHandlingMiddleware;
import heidt_hart.authentication.RoleCheckMiddleware;
import heidt_hart.planefactories.AirbusA380Factory;
import heidt_hart.planefactories.Boeing757Factory;
import heidt_hart.planefactories.CessnaCitationXFactory;
import heidt_hart.planefactories.PlaneFactoryIF;
import heidt_hart.planes.PlaneIF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AirportFacade {
    AirportSingleton airportSingleton;
    Observer observer;
    BufferedReader reader;
    Middleware middleware;
    private final String CYAN_BOLD = "\033[1;96m";
    private static final String RESET = "\033[0m";
    PlaneFactoryIF airbusFactory = new AirbusA380Factory();
    PlaneFactoryIF cessnaFactory = new CessnaCitationXFactory();
    PlaneFactoryIF boeingFactory = new Boeing757Factory();


    public AirportFacade() throws IOException {
        init();
    }

    private void init() throws IOException {
        airportSingleton = AirportSingleton.getAirport();
        observer = new Observer();
        reader = new BufferedReader(new InputStreamReader(System.in));
        airportSingleton.addPropertyChangeListener(observer);
        airportSingleton.register("ab52s", "admin_pass");
        airportSingleton.register("jbl55", "user_pass");
        middleware = new RequestHandlingMiddleware(5);
        middleware.linkWith(new CredentialMiddleware(airportSingleton))
                .linkWith(new RoleCheckMiddleware());
        airportSingleton.setMiddleware(middleware);
        airbusFactory = new AirbusA380Factory();
        cessnaFactory = new CessnaCitationXFactory();
        boeingFactory = new Boeing757Factory();
        System.out.println(CYAN_BOLD + "----- Welcome to PlaneTrak -----" + RESET);
        System.out.println("Would you like to login [y/n]?");
        char response = reader.readLine().charAt(0);
        if(response == 'y'){
            login();
        }else{
            close();
        }
    }

    public void login() throws IOException {
        boolean success = true;
        do {
            System.out.print("Enter id: ");
            String id = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = airportSingleton.logIn(id, password);
        } while (!success);
        run();
    }

    private void run() throws IOException {
        while (true){
            System.out.println("Perform one of these operations:" +
                    "\n1. Create and Add Plane" +
                    "\n2. Print Planes, Passengers, and Cargo" +
                    "\n3. Remove Plane" +
                    "\n4. Close");
            int response = Integer.parseInt(reader.readLine());
            switch (response) {
                case 1:
                    System.out.println("Which model airplane (airbus, cessna, boeing)?");
                    String model = reader.readLine().trim();
                    System.out.println("How much cargo/passengers (int)?");
                    int value = Integer.parseInt(reader.readLine());
                    createAndAddPlane(model, value);
                    System.out.println("Plane added successfully!");
                    break;
                case 2:
                    printPlanesPassengersCargo();
                    break;
                case 3:
                    airportSingleton.printListOfPlanes();
                    System.out.println("Remove the airplane in which position (0 .. n - 1)?");
                    int position = Integer.parseInt(reader.readLine());
                    System.out.println("How much cargo/passengers (int)?");
                    int count = Integer.parseInt(reader.readLine());
                    removePlane(position, count);
                    break;
                case 4:
                    close();
                    break;
                default:
                    System.out.println("Invalid response model. Shutting down.");
            }
        }
    }

    private void createAndAddPlane(String model, int carryValue){
        PlaneIF newPlane;
        switch (model) {
            case "airbus":
                newPlane = airbusFactory.createPlane(carryValue);
                break;
            case "cessna":
                newPlane = cessnaFactory.createPlane(carryValue);
                break;
            case "boeing":
                newPlane = boeingFactory.createPlane(carryValue);
                break;
            default:
                newPlane = null;
                System.out.println("Invalid plane model. Shutting down.");
        }
        airportSingleton.addPlaneToAirport(newPlane);
    }

    private void printPlanesPassengersCargo(){
        System.out.print("\nList of planes: ");
        airportSingleton.printListOfPlanes();
        System.out.println("Current number of passengers: " + airportSingleton.getPassengersAtAirport());
        System.out.println("Current tonnage of cargo: " + airportSingleton.getCargoAtAirport());
        System.out.println();
    }

    private void removePlane(int position, int carryValue){
        airportSingleton.printListOfPlanes();
        airportSingleton.removePlaneFromAirport(position, carryValue);
    }

    private void close(){
        System.out.println(CYAN_BOLD + "----- Closing PlaneTrak -----" + RESET);
        System.exit(0);
    }
}
