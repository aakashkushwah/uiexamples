package com.akushwah.examples.threads.oddeven;

public class EvenWorker implements Runnable {

	private Printer p;
	private int n;

	public EvenWorker(Printer p, int n) {
		this.p = p;
		this.n = n;
	}

	public void run() {

		while (n <= App.MAX) {
			synchronized (p) {
				if (n % 2 != 0 || !p.isOddPrinted()) {
					try {
						p.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.print("printing even ");
				p.print(n);
				p.setOddPrinted(false);
				n = n + 2;
				p.notifyAll();
			}
		}

	}

}
