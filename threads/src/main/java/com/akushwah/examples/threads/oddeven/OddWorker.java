package com.akushwah.examples.threads.oddeven;

public class OddWorker implements Runnable{

	private Printer p;
	private int n;
	
	public OddWorker(Printer p, int n) {
		this.p = p;
		this.n =n ;
	}

	public void run() {
		
		while(n<=App.MAX){
			synchronized (p) {
				if (n % 2 == 0 || p.isOddPrinted()) {
					try {
						p.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.print("printing odd ");
				p.print(n);
				p.setOddPrinted(true);
				n = n + 2;
				p.notifyAll();
			}
		}
		
	}

}
