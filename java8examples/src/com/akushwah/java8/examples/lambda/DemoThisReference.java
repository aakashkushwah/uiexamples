package com.akushwah.java8.examples.lambda;

public class DemoThisReference {
	public static void main(String[] args) {
		DemoThisReference reference = new DemoThisReference();
		reference.doProcess(10, new ThisProcess() {
			
			@Override
			public void perform(int i) {
				System.out.println("Value is "+i+" "+this);
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "Anonymous Inner Class";
				
			}
		});
		
//		reference.doProcess(30, i -> System.out.println("Value is "+i+" "+this));
		reference.execute();
	}
	
	private void doProcess(int i, ThisProcess p){
		p.perform(i);
	}
	
	public void execute(){
		doProcess(30, i -> System.out.println("Value is "+i+" "+this));
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DemoThisReference Class";
		
	}
}

interface ThisProcess{
	void perform(int i);
		
}