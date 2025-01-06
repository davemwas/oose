/*

State interface: Defines a method handleRequest() that will be implemented by concrete states.
ConcreteStateA & ConcreteStateB: These are two concrete implementations of the State interface. Each one provides a specific implementation of the handleRequest() method.
Context class: Maintains a reference to the current state and delegates the handleRequest() call to the current state. It allows the state to be changed dynamically via setState().
StatePatternDemo class: Demonstrates the state transition by creating a Context object and switching between two states (ConcreteStateA and ConcreteStateB).

*/


// State Interface
interface State {
    void handleRequest();
}

// Concrete States
class ConcreteStateA implements State {
    @Override
    public void handleRequest() {
        System.out.println("Handling request in State A");
    }
}

class ConcreteStateB implements State {
    @Override
    public void handleRequest() {
        System.out.println("Handling request in State B");
    }
}

// Context Class
class Context {
    private State currentState;

    public Context(State initialState) {
        this.currentState = initialState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handleRequest();
    }
}

// Client Code
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());

        context.request(); // Outputs: Handling request in State A
        
        context.setState(new ConcreteStateB());
        context.request(); // Outputs: Handling request in State B
    }
}
