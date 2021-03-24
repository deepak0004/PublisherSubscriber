/*
An interface of Publisher. The same can be extended by multiple publishers to enque into the queue.
*/
public interface Publisher {
	public void notifyMessage();
}