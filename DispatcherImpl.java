import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Dispatcher implementation
class DispatcherImpl implements Dispatcher {
    private final List<Taxi> taxis = new ArrayList<>();
    private final BlockingQueue<String> orderQueue = new LinkedBlockingQueue<>();

    public void addTaxi(Taxi taxi) {
        synchronized (taxis) {
            taxis.add(taxi);
            taxis.notify(); // Notify dispatcher that a taxi is available
        }
    }

    @Override
    public void placeOrder(String order) {
        try {
            synchronized (taxis) {
                while (taxis.isEmpty()) {
                    taxis.wait(); // Wait for a taxi to become available
                }
                Taxi taxi = taxis.remove(0); // Get the first available taxi
                new Thread(() -> taxi.placeOrder(order)).start(); // Place order in a new thread
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void start() {
        new Thread(() -> {
            int orderCount = 0;
            while (true) {
                try {
                    Thread.sleep(5000); // Place a new order every 5 seconds
                    placeOrder("Order #" + (++orderCount));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}