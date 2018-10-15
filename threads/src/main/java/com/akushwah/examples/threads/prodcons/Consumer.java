package com.akushwah.examples.threads.prodcons;

import java.util.Queue;

public class Consumer implements Runnable {

	private Queue<Integer> queue = null;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is empty");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				int number = queue.poll();
				System.out.println("Removing element " + number);
				queue.notify();
			}

		}

	}

}
