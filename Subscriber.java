/*
An interface of Subscriber. The same can be extended by multiple subscribers to dequeue from the queue.
*/
public interface Subscriber {
	public void receive();
}