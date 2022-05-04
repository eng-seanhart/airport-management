package heidt_hart.authentication;

public class RoleCheckMiddleware extends Middleware {
    @Override
    public boolean check(String id, String password) {
        String pattern = "a(\\w){4}";
        if (id.matches(pattern)) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(id, password);
    }
}
