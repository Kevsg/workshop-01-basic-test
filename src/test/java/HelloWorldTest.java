import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void greeting_should_return_Hello_World() {
        HelloWorld h = new HelloWorld();
        String s = h.greeting();
        assertEquals("Hello World",s);
    }

    @Test
    public void greeting_with_john_should_return_Hello_John() {
        HelloWorld h = new HelloWorld();
        String s = h.greeting("john");
        assertEquals("Hello John",s);
    }

    @Test
    public void greeting_with_dan_should_return_Hello_Dan() {
        HelloWorld h = new HelloWorld();
        String s = h.greeting("dan");
        assertEquals("Hello Dan",s);
    }
}