import java.util.*;
import java.util.concurrent.*;

public class Subscriber1 implements Subscriber, Runnable {
	private int threadNo;
    private LinkedBlockingQueue<Message> queue;
    private int RAND_NUMBER_RANGE = 1000;

    public Subscriber1 (LinkedBlockingQueue<Message> queue, int threadNo) {
        this.threadNo = threadNo;
        this.queue = queue;
    }

    public void run() {
    	receive();
    }

	public void receive() {
	   while(true) {
		    try {
	            int numberExtractedOut = queue.take().getMessage();
	            System.out.println("Consumed: "+ " Th" + threadNo + "-" + numberExtractedOut);
	        } catch (final Exception e) {
	           e.printStackTrace();
	        }
	   }
	}
}