package com.akushwah.examples.threads.oddeven;

public class Printer {
	
	public Printer(boolean value) {
		this.isOddPrinted = value;
	}
	
	private boolean isOddPrinted = false;

	public void print(int n){
		System.out.println(n);
	}
	
	public boolean isOddPrinted() {
		return isOddPrinted;
	}
	
	public void setOddPrinted(boolean isOddPrinted) {
		this.isOddPrinted = isOddPrinted;
	}
}
