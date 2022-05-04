package heidt_hart.authentication;

public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String id, String password);

    protected boolean checkNext(String id, String password) {
        if (next == null) {
            return true;
        }
        return next.check(id, password);
    }
}
