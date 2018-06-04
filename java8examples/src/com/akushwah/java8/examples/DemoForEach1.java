package com.akushwah.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConsumerImpl implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println("Via Implementation "+t);		
	}
	
}


public class DemoForEach1 {
	private static Consumer<Integer> action = i -> System.out.println("Via Consumer "+i);
			
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(4,7,5,2,3,12,43,56,76,23);
		//external loops
		for (Integer integer : values) {
			System.out.print(integer+" ");
		}
		System.out.println("\n*************************************************************");
		//internal loops
		values.forEach(i -> System.out.print(i+" "));
		System.out.println("\n*************************************************************");
		//method reference
		values.forEach(System.out::print);
		System.out.println("\n*************************************************************");
		values.forEach(action);
		System.out.println("\n*************************************************************");
		values.forEach(new ConsumerImpl());
	}
}
