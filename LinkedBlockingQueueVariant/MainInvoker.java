import java.util.*;
import java.util.concurrent.*;

public class MainInvoker {
    public static void main (String[] args) {
         LinkedBlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
         ExecutorService producer = Executors.newFixedThreadPool(3);
         ExecutorService consumer = Executors.newFixedThreadPool(2);

         producer.submit(new Publisher1(queue, 1));
         producer.submit(new Publisher1(queue, 2));
         producer.submit(new Publisher1(queue, 3));
         consumer.submit(new Subscriber1(queue, 1));
         consumer.submit(new Subscriber1(queue, 2));

         producer.shutdown();
         consumer.shutdown();
    }
}