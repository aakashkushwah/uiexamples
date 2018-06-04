package com.akushwah.java8.examples.lambda;

public class ClosureExample {
	public static void main(String[] args) {
		int a = 10;
		int b = 90;
		doProcess(a, new ClosureProcess() {
			
			@Override
			public void perform(int i) {
				System.out.println(i+b);
			}
		});
		System.out.println("**************************************");
		doProcess(a, i -> System.out.println(i+b));
	}
	
	private static void doProcess(int i, ClosureProcess p){
		p.perform(i);
	}
}

interface ClosureProcess{
	void perform(int i);
}
