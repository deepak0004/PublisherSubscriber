import java.util.*;
import java.util.concurrent.*;

public class Publisher1 implements Publisher, Runnable {
	private int threadNo;
    private LinkedBlockingQueue<Message> queue;
    private int RAND_NUMBER_RANGE = 1000;

	public Publisher1(LinkedBlockingQueue<Message> queue, int threadNo) {
        this.threadNo = threadNo;
        this.queue = queue;
	}

    public void run() {
       	 notifyMessage();
	}

	public void notifyMessage() {
		 while(true) {
            try {
    	        // Generate random integers in range 0 to 999
                Random rand = new Random();
                int numberProduced = rand.nextInt(RAND_NUMBER_RANGE);

                System.out.println("Th" + threadNo + "-" + numberProduced);
    			Thread.sleep(1000);

                Message message = new Message(numberProduced);
                queue.put(message);
            } catch (final Exception e) {
                e.printStackTrace();
            }
	     }
	}
}