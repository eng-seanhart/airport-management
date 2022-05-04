package heidt_hart.authentication;

public class RequestHandlingMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public RequestHandlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    public boolean check(String id, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(id, password);
    }
}
