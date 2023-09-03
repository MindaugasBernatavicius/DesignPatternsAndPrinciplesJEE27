package cf.mindaugas._02_designPatterns._01_creational;

public class _01_DependencyInjection {
    public static void main(String[] args) {

    }
}

class Car {
    private Engine engine = new Engine(); // no DI

    // Constructor dependency injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    // Setting dependency injection
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}

class Engine {}
class DesielEngine extends Engine {}