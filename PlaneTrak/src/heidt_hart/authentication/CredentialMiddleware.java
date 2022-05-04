package heidt_hart.authentication;

import heidt_hart.AirportSingleton;

public class CredentialMiddleware extends Middleware {
    private AirportSingleton airportSingleton;

    public CredentialMiddleware(AirportSingleton airportSingleton) {
        this.airportSingleton = airportSingleton;
    }

    public boolean check(String id, String password) {
        if (!airportSingleton.hasEmail(id)) {
            System.out.println("This id is not registered!");
            return false;
        }
        if (!airportSingleton.isValidPassword(id, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(id, password);
    }
}
