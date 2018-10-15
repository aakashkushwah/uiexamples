package com.akushwah.examples.threads.prodcons;

import java.util.LinkedList;
import java.util.Queue;

public class App {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<>();
		Producer p = new Producer(queue,4);
		Consumer c = new Consumer(queue);
		new Thread(p).start();
		new Thread(c).start();
		
	
	}
}
