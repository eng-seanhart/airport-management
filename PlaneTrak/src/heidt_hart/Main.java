package heidt_hart;

import heidt_hart.authentication.Middleware;
import heidt_hart.authentication.RoleCheckMiddleware;
import heidt_hart.authentication.RequestHandlingMiddleware;
import heidt_hart.authentication.CredentialMiddleware;
import heidt_hart.planefactories.AirbusA380Factory;
import heidt_hart.planefactories.Boeing757Factory;
import heidt_hart.planefactories.CessnaCitationXFactory;
import heidt_hart.planefactories.PlaneFactoryIF;
import heidt_hart.planes.PlaneIF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        AirportFacade facade = new AirportFacade();
        facade.login();
    }
}