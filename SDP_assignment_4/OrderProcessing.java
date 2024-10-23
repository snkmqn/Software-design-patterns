package SDP_assignment_4;

public class OrderProcessing {
    interface OrderState {
        void payOrder(Order order);
        void shipOrder(Order order);
        void deliverOrder(Order order);
        void cancelOrder(Order order);
    }
    class Order {
        private OrderState currentState;

        public Order() {
            this.currentState = new NewOrderState();
        }

        public void setState(OrderState state) {
            this.currentState = state;
        }

        public void payOrder() {
            currentState.payOrder(this);
        }

        public void shipOrder() {
            currentState.shipOrder(this);
        }

        public void deliverOrder() {
            currentState.deliverOrder(this);
        }

        public void cancelOrder() {
            currentState.cancelOrder(this);
        }
    }
    class NewOrderState implements OrderState {
        @Override
        public void payOrder(Order order) {
            System.out.println("Order has been paid.");
            order.setState(new PaidOrderState());
        }

        @Override
        public void shipOrder(Order order) {
            System.out.println("Order cannot be shipped until it is paid.");
        }

        @Override
        public void deliverOrder(Order order) {
            System.out.println("Order cannot be delivered until it is shipped.");
        }

        @Override
        public void cancelOrder(Order order) {
            System.out.println("Order has been cancelled.");
            order.setState(new CancelledOrderState());
        }
    }
    class PaidOrderState implements OrderState {
        @Override
        public void payOrder(Order order) {
            System.out.println("Order has already been paid.");
        }

        @Override
        public void shipOrder(Order order) {
            System.out.println("Order has been shipped.");
            order.setState(new ShippedOrderState());
        }

        @Override
        public void deliverOrder(Order order) {
            System.out.println("Order cannot be delivered until it is shipped.");
        }

        @Override
        public void cancelOrder(Order order) {
            System.out.println("Order has been cancelled.");
            order.setState(new CancelledOrderState());
        }
    }
    class ShippedOrderState implements OrderState {
        @Override
        public void payOrder(Order order) {
            System.out.println("Order has already been paid.");
        }

        @Override
        public void shipOrder(Order order) {
            System.out.println("Order has already been shipped.");
        }

        @Override
        public void deliverOrder(Order order) {
            System.out.println("Order has been delivered.");
            order.setState(new DeliveredOrderState());
        }

        @Override
        public void cancelOrder(Order order) {
            System.out.println("Order cannot be cancelled as it has already been shipped.");
        }
    }
    class DeliveredOrderState implements OrderState {
        @Override
        public void payOrder(Order order) {
            System.out.println("Order has already been paid.");
        }

        @Override
        public void shipOrder(Order order) {
            System.out.println("Order has already been shipped.");
        }

        @Override
        public void deliverOrder(Order order) {
            System.out.println("Order has already been delivered.");
        }

        @Override
        public void cancelOrder(Order order) {
            System.out.println("Order cannot be cancelled as it has been delivered.");
        }
    }

    class CancelledOrderState implements OrderState {
        @Override
        public void payOrder(Order order) {
            System.out.println("Cancelled order cannot be paid.");
        }

        @Override
        public void shipOrder(Order order) {
            System.out.println("Cancelled order cannot be shipped.");
        }

        @Override
        public void deliverOrder(Order order) {
            System.out.println("Cancelled order cannot be delivered.");
        }

        @Override
        public void cancelOrder(Order order) {
            System.out.println("Order has already been cancelled.");
        }
    }
}
