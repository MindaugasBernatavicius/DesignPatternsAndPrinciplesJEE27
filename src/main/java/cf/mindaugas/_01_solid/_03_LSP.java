package cf.mindaugas._01_solid;

public class _03_LSP {
    public static void being(Vehicle v) {
        v.startEngine();
    }

    public static void main(String[] args) {
        being(new Bicycle());
    }
}

class Engine {
    State state;
    enum State {ON, OFF}
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
}

class Vehicle {
    String name;
    Double speed;
    Engine engine; // has-a / composition

    void startEngine() {
        this.engine.setState(Engine.State.ON);
    }
}

class Bicycle extends Vehicle {
    @Override
    void startEngine() {} // bicycle, does not have an engine, so it does not make sense!
}

// ... another example: https://www.baeldung.com/java-liskov-substitution-principle