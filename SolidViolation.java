/*

Single Responsibility Principle (SRP) - PaymentService has multiple unrelated responsibilities, including payment processing, receipt printing, and discount application.
Open/Closed Principle (OCP) - Adding new payment methods requires modifying the processPayment method.
Liskov Substitution Principle (LSP) - CashPaymentService cannot meaningfully implement some methods of the parent class, breaking substitutability.
Interface Segregation Principle (ISP) - The applyDiscount method forces all subclasses to implement it, even when not applicable (e.g., cash payments).
Dependency Inversion Principle (DIP) - The Main class directly depends on the concrete PaymentService and CashPaymentService implementations instead of an abstraction.

*/

// Base class that violates LSP by providing methods that subclasses cannot meaningfully implement.
class PaymentService {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Processing credit card payment of $" + amount);
        } else if (paymentType.equals("PayPal")) {
            System.out.println("Processing PayPal payment of $" + amount);
        } else {
            System.out.println("Unknown payment type!");
        }
    }

    public void printReceipt(double amount) {
        System.out.println("Receipt: Payment of $" + amount + " has been processed.");
    }

    // Added method violates ISP by forcing all subclasses to implement it, even if unnecessary.
    public void applyDiscount(double discount) {
        System.out.println("Applying discount of $" + discount);
    }
}

// Subclass that violates LSP because it cannot fulfill the contract of the parent class meaningfully.
class CashPaymentService extends PaymentService {
    @Override
    public void processPayment(String paymentType, double amount) {
        // Cash payment does not need payment type, but the method forces its use.
        System.out.println("Processing cash payment of $" + amount);
    }

    @Override
    public void applyDiscount(double discount) {
        // Cash payments do not have discounts, but this method must be implemented.
        System.out.println("Discounts not applicable for cash payments.");
    }
}

public class SolidViolation {
    public static void main(String[] args) {
        // Violates DIP: Main depends on concrete classes instead of abstractions.
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("CreditCard", 100.0);
        paymentService.printReceipt(100.0);

        // Violates LSP: Using a subclass that does not fulfill the parent class's expected behavior.
        PaymentService cashService = new CashPaymentService();
        cashService.processPayment("", 50.0); // "paymentType" is irrelevant for CashPaymentService.
        cashService.applyDiscount(5.0); // Forced implementation with no real functionality.
    }
}
