/*
 
Strategy interface: Defines the execute() method that all concrete strategies will implement.
ConcreteStrategyA & ConcreteStrategyB: Two concrete strategies implementing the Strategy interface, each providing a different implementation of the execute() method.
Context class: The context class maintains a reference to a Strategy object and delegates the execution of the strategy to the current strategy object. It also allows changing the strategy dynamically using the setStrategy() method.
StrategyPatternDemo class: The client code demonstrates the Strategy pattern by creating a Context object and switching between ConcreteStrategyA and ConcreteStrategyB at runtime. 

 */


// Strategy Interface
interface Strategy {
    void execute();
}

// Concrete Strategy 1
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy A");
    }
}

// Concrete Strategy 2
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy B");
    }
}

// Context Class
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // Set the strategy dynamically at runtime
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}

// Client Code
public class StrategyPattern {
    public static void main(String[] args) {
        // Initially setting strategy A
        Context context = new Context(new ConcreteStrategyA());
        context.executeStrategy(); // Outputs: Executing strategy A
        
        // Changing strategy to B at runtime
        context.setStrategy(new ConcreteStrategyB());
        context.executeStrategy(); // Outputs: Executing strategy B
    }
}
