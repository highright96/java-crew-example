package singleton;

public class Example {

    public static final Example example = new Example();

    private Example() {
        System.err.println("example create");
    }

    public static Example getInstance() {
        System.err.println("getInstance");
        return example;
    }

    public static void commonsMethod() {
        System.err.println("commonsMethod");
    }
}
