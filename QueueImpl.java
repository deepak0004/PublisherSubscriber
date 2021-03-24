import java.util.*;

public class QueueImpl {
    Message[] queue = new Message[100];
    private static int putReference, takeReference, currentQueueSize, totalQueueLimit;

    public QueueImpl (int putReference, int takeReference, 
        int currentQueueSize, int totalQueueLimit, Message queue[]) {
        this.putReference = putReference;
        this.takeReference = takeReference;
        this.currentQueueSize = currentQueueSize;
        this.totalQueueLimit = totalQueueLimit;
        this.queue = queue;
    }

    public synchronized void putMessage(Message message) throws InterruptedException {
        while (currentQueueSize == totalQueueLimit) {
            wait(); 
        }
        queue[putReference++] = message;
        if (putReference >= totalQueueLimit) {
            putReference = 0;
        }
        ++currentQueueSize;
        notify();
    }

    public synchronized Message getMessage() throws InterruptedException {
        while (currentQueueSize == 0) {
            wait();
        }

        if (takeReference >= currentQueueSize) {
            takeReference = 0;
        }
        Message message = queue[takeReference++];
        --currentQueueSize;
        notify();
        return message;
    }
}