public class Main {
    public static void main(String[] args) {
        PayPal paypal = new PayPal();
        PaymentProcessor paypalAdapter = new PayPalAdapter(paypal);
        paypalAdapter.processPayment(100);

        // Stripe
        Stripe stripe = new Stripe();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        stripeAdapter.processPayment(200);

        // Bank Transfer
        Banktransfer bankTransfer = new Banktransfer();
        PaymentProcessor bankTransferAdapter = new BankAdapter(bankTransfer);
        bankTransferAdapter.processPayment(300);

    }
}


// Adaptee Classes
class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Sending " + amount + " using PayPal.");
    }
}

class Stripe {
    public void sendPayment(double amount) {
        System.out.println("Sending " + amount + " using Stripe.");
    }
}

class Banktransfer {
    public void sendpayment(double amount) {
        System.out.println("Sending " + amount + " using BankTransfer.");
    }
}

// Adaptres

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal paypal;

    PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.sendPayment(amount);
    }
}

class BankAdapter implements PaymentProcessor {
    private Banktransfer banktransfer;

    BankAdapter(Banktransfer banktransfer) {
        this.banktransfer = banktransfer;
    }

    @Override
    public void processPayment(double amount) {
        banktransfer.sendpayment(amount);
    }
}



