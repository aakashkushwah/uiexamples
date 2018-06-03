package com.akushwah.java8.examples.lambda;

public class TypeInferenceExample {
	public static void main(String[] args) {
		SqRootLambda ex = (int i) ->  {return Math.sqrt(i);};
		System.out.println(ex.cube(345));
		
	}
	
	
}

interface SqRootLambda{
	double cube(int number);
}