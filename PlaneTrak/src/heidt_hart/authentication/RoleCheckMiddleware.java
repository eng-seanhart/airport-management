package heidt_hart.authentication;

public class RoleCheckMiddleware extends Middleware {
    public boolean check(String id, String password) {
        if (id.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(id, password);
    }
}
