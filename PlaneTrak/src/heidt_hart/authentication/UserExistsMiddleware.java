package heidt_hart.authentication;

import heidt_hart.AirportSingleton;

public class UserExistsMiddleware extends Middleware {
    private AirportSingleton airportSingleton;

    public UserExistsMiddleware(AirportSingleton airportSingleton) {
        this.airportSingleton = airportSingleton;
    }

    public boolean check(String email, String password) {
        if (!airportSingleton.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!airportSingleton.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
