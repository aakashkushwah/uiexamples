package com.akushwah.java8.examples.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class DemoExceptionHandling {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(23, 43, 56, 78, 1, 2, 3, 0, 4);
		int divider = 2000;
		
		process(numbers, divider, (i, j) -> System.out.println(j / i));
		
		System.out.println("*******************************************");
		
		process(numbers, divider, wrapperPassThrough((i, j) -> System.out.println(j / i)));
		
		System.out.println("*******************************************");
		process(numbers, divider, wrapper((i, j) -> System.out.println(j / i)));
	}

	private static void process(List<Integer> list, int divider, BiConsumer<Integer, Integer> consumer) {
		for (Integer integer : list) {
			consumer.accept(integer, divider);
		}
	}

	private static BiConsumer<Integer, Integer> wrapperPassThrough(BiConsumer<Integer, Integer> consumer) {
		return consumer;
	}

	private static BiConsumer<Integer, Integer> wrapper(BiConsumer<Integer, Integer> consumer) {
		return (i, j) -> {
			try {
				System.out.print("Doing from Wrapper ");
				consumer.accept(i, j);
			} catch (Exception e) {
				System.out.println("Wrond division parameters");
			}

		};
	}
}
