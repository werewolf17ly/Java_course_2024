import java.util.Random;

// Taxi implementation
class TaxiImpl implements Taxi {
    private final Dispatcher dispatcher;
    private final String taxiId;
    private final Random random = new Random();

    public TaxiImpl(Dispatcher dispatcher, String taxiId) {
        this.dispatcher = dispatcher;
        this.taxiId = taxiId;
    }

    @Override
    public void placeOrder(String order) {
        System.out.println(taxiId + " received order: " + order);
        // Simulate order execution time
        try {
            Thread.sleep(random.nextInt(3000) + 1000); // Sleep for 1 to 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(taxiId + " completed order: " + order);
        notifyDispatcher();
    }

    @Override
    public void notifyDispatcher() {
        dispatcher.addTaxi(this);
    }

    @Override
    public void start() {
        new Thread(() -> {
            while (true) {
                // Wait for an order to be placed
                try {
                    Thread.sleep(1000); // Check for orders every second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}