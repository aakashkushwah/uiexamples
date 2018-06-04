package com.akushwah.java8.examples.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoStream {
	public static void main(String[] args) {
		List<Integer> values = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			values.add(i);
		}
		
		List<Integer> evens = new ArrayList<>();
		System.out.println(values.parallelStream().filter(i-> i%2 == 0).count());
		evens = values.parallelStream().filter(i-> i%2 == 0).collect(Collectors.toList());
		evens.forEach(System.out::print);
		System.out.println(values.parallelStream().filter(i-> i%2 == 0).collect(Collectors.toList()));
	}
}
