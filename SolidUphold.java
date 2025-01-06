/*

Single Responsibility Principle (SRP) - Responsibilities are clearly separated: PaymentProcessor handles payment processing, and ReceiptPrinter is responsible for printing receipts.
Open/Closed Principle (OCP) - Adding a new payment type involves creating a new class implementing PaymentProcessor, without modifying existing code.
Liskov Substitution Principle (LSP) - Any PaymentProcessor implementation can be used in place of the PaymentProcessor interface without altering behavior.
Interface Segregation Principle (ISP) - Interfaces are specific to the behavior they represent, avoiding forcing classes to implement unused methods.
Dependency Inversion Principle (DIP) - PaymentService depends on the PaymentProcessor and ReceiptPrinter abstractions, not concrete implementations.

 */

// Define an abstraction for payment processing.
interface PaymentProcessor {
    void processPayment(double amount);
}

// Implementation for CreditCard payment processing.
class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

// Implementation for PayPal payment processing.
class PayPalPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

// Implementation for Cash payment processing.
class CashPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount);
    }
}

// Define a separate service for printing receipts, adhering to SRP.
class ReceiptPrinter {
    public void printReceipt(double amount) {
        System.out.println("Receipt: Payment of $" + amount + " has been processed.");
    }
}

// High-level class depends on abstractions, adhering to DIP.
class PaymentService {
    private final PaymentProcessor paymentProcessor;
    private final ReceiptPrinter receiptPrinter;

    public PaymentService(PaymentProcessor paymentProcessor, ReceiptPrinter receiptPrinter) {
        this.paymentProcessor = paymentProcessor;
        this.receiptPrinter = receiptPrinter;
    }

    public void handlePayment(double amount) {
        paymentProcessor.processPayment(amount);
        receiptPrinter.printReceipt(amount);
    }
}

public class SolidUphold {
    public static void main(String[] args) {
        // Adheres to DIP: High-level module depends on abstractions.
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();

        PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();
        PaymentService creditCardService = new PaymentService(creditCardProcessor, receiptPrinter);
        creditCardService.handlePayment(100.0);

        PaymentProcessor paypalProcessor = new PayPalPaymentProcessor();
        PaymentService paypalService = new PaymentService(paypalProcessor, receiptPrinter);
        paypalService.handlePayment(150.0);

        PaymentProcessor cashProcessor = new CashPaymentProcessor();
        PaymentService cashService = new PaymentService(cashProcessor, receiptPrinter);
        cashService.handlePayment(50.0);
    }
}
