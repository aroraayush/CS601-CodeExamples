package concurrency;

import java.util.LinkedList;

/** BlockingQueue example - demonstrates the use of wait() and notify().
 * From http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
 */
public class BlockingQueue {
	private LinkedList<Integer> queue = new LinkedList<>();
	private int capacity;

	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Waits until there is space in the queue, then adds an element to the queue
	 * @param element the element to be added to the queue
	 * @throws InterruptedException
	 */
	public synchronized void enqueue(Integer element) throws InterruptedException {

		// already full
		if(queue.size() == capacity)
			System.out.println(Thread.currentThread().getName() + " is waiting to enqueue because queue is full");
		// done to prevent spurious wakeup
		while (queue.size() == capacity) {
			System.out.println(Thread.currentThread().getName() + " is waiting...");
			this.wait();
		}
		queue.add(element);
		System.out.println("Inserting " + element); //should be using Logger instead

		//System.out.println(Thread.currentThread().getName() + " is notifying all...");
		this.notifyAll();
	}

	/**
	 * Waits until the queue has something to dequeue, then dequeues it and returns the element.
	 * @return the first element from the queue
	 * @throws InterruptedException
	 */
	public synchronized Integer dequeue() throws InterruptedException {
		while (queue.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " is waiting to dequeue as the queue is empty...");
            this.wait();
		}

		Integer item = queue.remove();
		System.out.println("Removing " + item + " " + Thread.currentThread().getName() + " is notifying all as atleast 1 slot is empty..."); // should be using Logger instead
		this.notifyAll();
		return item;
	}
}
