package com.akushwah.java8.examples.lambda;

public class RunnableExample {

	public static void main(String[] args) {
		RunnableExample re = new RunnableExample();
		Thread t1 = new Thread(re::doSomething);
		Thread t2 = new Thread(re::doSomething);
		t1.start();
		t2.start();
		Thread t3 = new Thread(RunnableExample::doSomethingStatic);
		Thread t4 = new Thread(RunnableExample::doSomethingStatic);
		t3.start();
		t4.start();
		
		Thread t5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Job Done in Anonymoust Inner Class by "+Thread.currentThread().getName());
			}
		});
		t5.start();
		
		Thread t6 = new Thread(()->System.out.println("Job Done by Lambda "+Thread.currentThread().getName()));
		t6.start();
	}
	
	private void doSomething(){
		System.out.println("Job done by "+Thread.currentThread().getName());
	}
	
	private static void doSomethingStatic(){
		System.out.println("Static Job Done by "+Thread.currentThread().getName());
	}

}
