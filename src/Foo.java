import java.util.HashMap;
import java.util.Map;

public class Foo {
    private final Service service;

    public Foo(Service service) {
        this.service = service;
    }

    public void bar() {
        Map<String, ?> params = getParams();
        service.activate(params);
    }

    private Map<String, ?> getParams() {
        // something interesting goes here
        return new HashMap<>();
    }
}