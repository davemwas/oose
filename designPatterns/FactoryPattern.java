/*
 
Product interface: This defines a create() method that is implemented by concrete products (ConcreteProductA and ConcreteProductB).
ConcreteProductA & ConcreteProductB: These are two specific implementations of the Product interface.
Creator class: This abstract class contains the factoryMethod() which is responsible for object creation. The createProduct() method calls this factory method to get the desired product.
ConcreteCreatorA & ConcreteCreatorB: These classes override the factoryMethod() to create specific products. Each creator class is responsible for creating a particular type of product.
FactoryPatternDemo class: Demonstrates the Factory pattern by using ConcreteCreatorA and ConcreteCreatorB to create different products. 
  
 */

// Product Interface
interface Product {
    void create();
}

// Concrete Product 1
class ConcreteProductA implements Product {
    @Override
    public void create() {
        System.out.println("Product A created");
    }
}

// Concrete Product 2
class ConcreteProductB implements Product {
    @Override
    public void create() {
        System.out.println("Product B created");
    }
}

abstract class Creator {
    public abstract Product factoryMethod();
    
    // Client code interacts with this method, unaware of the specific product type
    public void createProduct() {
        Product product = factoryMethod();
        product.create();
    }
}

// Concrete Creator 1
class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA(); 
    }
}

// Concrete Creator 2
class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}


public class FactoryPattern {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        creatorA.createProduct(); // Outputs: Product A created

        Creator creatorB = new ConcreteCreatorB();
        creatorB.createProduct(); // Outputs: Product B created
    }
}
