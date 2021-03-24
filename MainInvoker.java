import java.util.*;
import java.util.concurrent.*;

public class MainInvoker {
    public static void main (String[] args) { 
         int QUEUE_MAX_SIZE = 100;

         // Creating a queue of max size 100 
         Message[] queueList = new Message[110];
         QueueImpl queue = new QueueImpl(0, 0, 0, QUEUE_MAX_SIZE, queueList);

         ExecutorService publisher = Executors.newFixedThreadPool(3);
         ExecutorService subscriber = Executors.newFixedThreadPool(2);

         // Publisher threads
         publisher.submit(new Publisher1(queue, 1));
         publisher.submit(new Publisher1(queue, 2));
         publisher.submit(new Publisher1(queue, 3));

         // Subscriber threads
         subscriber.submit(new Subscriber1(queue, 1));
         subscriber.submit(new Subscriber1(queue, 2));

         publisher.shutdown();
         subscriber.shutdown();
    }
}