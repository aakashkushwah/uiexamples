package com.akushwah.examples.threads.prodcons;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable{

	private Queue<Integer> queue = null;
	private int maxSize;
	
	public Producer(Queue<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				while(queue.size() == maxSize) {
					try {
						System.out.println("Queue is full");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Random random = new Random(); 
                int number = random.nextInt(100);
                System.out.println("Producing value " + number);
                queue.add(number);
                queue.notify();
			}
		}
	}

}
