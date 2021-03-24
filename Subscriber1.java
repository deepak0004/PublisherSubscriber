import java.util.*;
import java.util.concurrent.*;

public class Subscriber1 implements Subscriber, Runnable {
	private int threadNo;
    private QueueImpl queue;
    private int RAND_NUMBER_RANGE = 1000;

    public Subscriber1 (QueueImpl queue, int threadNo) {
        this.threadNo = threadNo;
        this.queue = queue;
    }

    public void run() {
    	receive();
    }

	public void receive() {
		while (true) {
			try {
				Message message = queue.getMessage();
				int numberExtractedOut = message.getMessage();
				System.out.println("Consumed: " + " Th" + threadNo + "-" + numberExtractedOut);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}
}