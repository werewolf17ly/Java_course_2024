Task 4. Multithreaded Taxi (15 points)
Soft deadline - 18 December
Hard deadline - 22 December

Implement a simplified Taxi application that must work correctly in a multithreaded environment.


1. Implement two interfaces Taxi (taxi) and Dispatcher (dispatcher). For simplicity, the dispatcher always works alone, whereas the number of taxi drivers is unset.
2. Each of the taxis, as well as the dispatcher, have to work via their own thread. The dispatcher knows about all available taxis.
3. During an iteration, he takes the first available taxi and places an order for him using the placeOrder method.
4. After that, the taxi driver begins to fulfill the order (to emulate the execution of the order, you can post some info about the order and then sleep for a random time from a given range).
5. As far as the task is completed, the driver notifies the Dispatcher, being added to the queue of free Taxis.
