package com.akushwah.java8.examples.lambda;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> System.out.println("Yo Yo "+Thread.currentThread().getName()));
		thread.start();
		
		thread = new Thread(MethodReferenceExample::process);
		thread.start();
	}
	
	private static void process(){
		System.out.println("Yo Yo "+Thread.currentThread().getName());
	}
}
