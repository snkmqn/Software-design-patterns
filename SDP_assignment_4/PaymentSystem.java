package SDP_assignment_4;

public class PaymentSystem {
    public interface PaymentStrategy{
        void processPayment(double amount);
    }
    public class CreditCardPayment implements PaymentStrategy{
        private String cardNumber;

        public CreditCardPayment(String cardNumber){
            this.cardNumber = cardNumber;
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("Processing credit card payment of $" + amount + " using card: " + cardNumber);
        }
    }
    public class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount + " using PayPal account: " + email);
        }
    }
    public class CryptoPayment implements PaymentStrategy {
        private String walletAddress;

        public CryptoPayment(String walletAddress) {
            this.walletAddress = walletAddress;
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("Processing cryptocurrency payment of $" + amount + " using wallet: " + walletAddress);
        }
    }
    public class ShoppingCart{
        private PaymentStrategy paymentStrategy;
        public void setPaymentStrategy(PaymentStrategy paymentStrategy){
            this.paymentStrategy = paymentStrategy;
        }
        public void checkout(double amount){
            if (paymentStrategy == null){
                System.out.println("No payment strategy selected.");
            } else{
                paymentStrategy.processPayment(amount);
            }
        }
    }
}
