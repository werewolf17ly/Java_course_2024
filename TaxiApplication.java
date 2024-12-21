import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaxiApplication {

    public interface Taxi {
        void placeOrder(String order);
        String getStatus();
    }

    public interface Dispatcher {
        void addTaxi(Taxi taxi);
        void dispatchOrder(String order);
    }

    private static class TaxiImpl implements Taxi {
        private final String name;
        private volatile boolean isAvailable = true;
        private final Random random = new Random();

        public TaxiImpl(String name) {
            this.name = name;
        }

        @Override
        public synchronized void placeOrder(String order) {
            isAvailable = false;
            System.out.println("Taxi " + name + " received order: " + order);
            try {
                Thread.sleep(random.nextInt(3000) + 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            isAvailable = true;
            System.out.println("Taxi " + name + " completed order: " + order);
        }

        @Override
        public synchronized String getStatus() {
            return isAvailable ? "Available" : "Busy";
        }
    }

    private static class DispatcherImpl implements Dispatcher {
        private final BlockingQueue < Taxi > availableTaxis = new LinkedBlockingQueue < > ();

        @Override
        public void addTaxi(Taxi taxi) {
            availableTaxis.offer(taxi);
        }

        @Override
        public void dispatchOrder(String order) {
            try {
                Taxi taxi = availableTaxis.take();
                taxi.placeOrder(order);
                availableTaxis.offer(taxi);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Dispatcher dispatcher = new DispatcherImpl();
        Taxi taxi1 = new TaxiImpl("Taxi 1");
        Taxi taxi2 = new TaxiImpl("Taxi 2");

        dispatcher.addTaxi(taxi1);
        dispatcher.addTaxi(taxi2);

        new Thread(() -> dispatcher.dispatchOrder("Order 1")).start();
        new Thread(() -> dispatcher.dispatchOrder("Order 2")).start();
        new Thread(() -> dispatcher.dispatchOrder("Order 3")).start();
    }
}