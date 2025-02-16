// Main class to run the application
public class TaxiApplication {
    public static void main(String[] args) {
        DispatcherImpl dispatcher = new DispatcherImpl();

        // Create and start taxis
        for (int i = 1; i <= 5; i++) {
            Taxi taxi = new TaxiImpl(dispatcher, "Taxi " + i);
            taxi.start(); // Start the taxi thread
            dispatcher.addTaxi(taxi); // Add taxi to the dispatcher
        }

        // Start the dispatcher to place orders
        dispatcher.start();

        // Keep the main thread alive for a while to observe the output
        try {
            Thread.sleep(30000); // Run for 30 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Shutting down the application.");
    }
}