public class HelloWorld {

    public String greeting() {
        return "Hello World";
    }

    public String greeting(String name) {
        String firstLetter = name.substring(0, 1).toUpperCase();
        return "Hello " + firstLetter + name.substring(1, name.length());
    }
}
