package com.akushwah.java8.examples.lambda;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceExample {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("xyz");
		
		list.stream().forEach(s-> System.out.print(" "+s));
		list.stream().forEach(MethodReferenceExample::print);
	}
	
	
	private static void print(String s) {
		System.out.println("ak "+s);
	}
	
}
