package com.akushwah.java8.examples.lambda;

public class LambdaExample1 {

	private static void doSomething(Process process) {
		process.perform();
	}

	public static void main(String[] args) {
		Process process = new ProcessImpl();
		doSomething(process);
		doSomething(new Process() {
			
			@Override
			public void perform() {
				System.out.println("Performing in Anonymous Inner Class");
			}
		});
		
		doSomething(()->System.out.println("Processing in Lambda"));

	}
}

interface Process {
	void perform();
}

class ProcessImpl implements Process {
	public void perform() {
		System.out.println("Processing in Process Implementation");
	}
}