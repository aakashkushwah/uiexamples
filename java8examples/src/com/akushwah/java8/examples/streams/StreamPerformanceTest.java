package com.akushwah.java8.examples.streams;

import java.util.Arrays;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StreamPerformanceTest {

	public static void main(String[] args) {

		String[] inputArray = getStrArray("Aakash", 20000);
		final Integer[] integerArray = getIntArray(20000);
		String[] randomStrArr = getRandomStrings(500000);

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				long l = System.currentTimeMillis();
				// TODO Auto-generated method stub
				Arrays.asList(inputArray).stream().reduce("", (a, b) -> (a + b));

				System.out.println("Time Taken in String reduce: " + (System.currentTimeMillis() - l));

				l = System.currentTimeMillis();
				int ans = Arrays.asList(integerArray).stream().reduce(0, (a, b) -> (a + b), (a, b) -> (a + b));
				System.out.println(ans);
				System.out.println("Time Taken in int reduce: " + (System.currentTimeMillis() - l));
				l = System.currentTimeMillis();
				System.out.println(
						Arrays.asList(randomStrArr).stream().reduce((s1, s2) -> s1.compareTo(s2) > 0 ? s1 : s2));
				System.out.println(
						Arrays.asList(randomStrArr).stream().reduce((s1, s2) -> s1.compareTo(s2) > 0 ? s2 : s1));
				System.out.println("Time Taken in max min reduce: " + (System.currentTimeMillis() - l));
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				long l = System.currentTimeMillis();
				// TODO Auto-generated method stub
				Arrays.asList(inputArray).stream().collect(StringBuilder::new, StringBuilder::append,
						StringBuilder::append);

				System.out.println("Time Taken in Collect: " + (System.currentTimeMillis() - l));

				l = System.currentTimeMillis();
				// Arrays.asList(integerArray).stream().collect(Collectors.summingInt(Integer::intValue));
				System.out.println(Arrays.asList(integerArray).stream().mapToInt(Integer::intValue).sum());

				System.out.println("Time Taken in int collect: " + (System.currentTimeMillis() - l));

				l = System.currentTimeMillis();
				MaxMinFinder mmf = Arrays.asList(randomStrArr).stream().collect(MaxMinFinder::new,
						MaxMinFinder::accumulate, MaxMinFinder::combine);
				System.out.println(mmf.getMax() + " " + mmf.getMin());
				System.out.println("Time Taken in max min collect: " + (System.currentTimeMillis() - l));
			}

		});

		t1.start();
		t2.start();

		String[] inputArray2 = new String[] { "Aakash", "Joker", "Anmol", "Ac", "Jagdeep" };
		// System.out.println(Arrays.asList(inputArray2).stream().reduce((s1, s2) ->
		// s1.compareTo(s2) > 0 ? s1 : s2));
		// System.out.println(Arrays.asList(inputArray2).stream().reduce((s1, s2) ->
		// s1.compareTo(s2) > 0 ? s2 : s1));
		//
		MaxMinFinder mmf = Arrays.asList(inputArray2).stream().collect(MaxMinFinder::new, MaxMinFinder::accumulate,
				MaxMinFinder::combine);
		System.out.println("In Main: " + mmf.getMax() + " " + mmf.getMin());

		mmf = Arrays.asList(inputArray2).stream().collect(() -> new MaxMinFinder(),
				(MaxMinFinder m, String s) -> m.accumulate(s), (MaxMinFinder j, MaxMinFinder k) -> j.combine(k));
		System.out.println("In Main: " + mmf.getMax() + " " + mmf.getMin());

		int i = Stream.of("2", "3", "4", "5").parallel().reduce(0, new BiFunction<Integer, String, Integer>() {
			@Override
			public Integer apply(Integer integer, String s) {
				return Integer.sum(integer, Integer.parseInt(s));
			}
		}, new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer integer, Integer integer2) {
				return Integer.sum(integer, integer2);
			}
		});

		i = Stream.of("2", "3", "4", "5").parallel().reduce(0,
				(integer, s) -> Integer.sum(integer, Integer.parseInt(s)), (a, b) -> a + b);

		System.out.println(i);

	}

	private static String[] getStrArray(String name, int number) {
		String[] result = new String[number];
		for (int i = 0; i < number; i++) {
			result[i] = name + i;
		}
		return result;
	}

	private static String[] getRandomStrings(int number) {
		String[] result = new String[number];
		String[] input = new String[] { "Aakash", "Joker", "Anmol", "Ac", "Jagdeep" };
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			int index = random.nextInt(4);
			result[i] = input[index] + i;
		}
		return result;
	}

	private static Integer[] getIntArray(int number) {
		Integer[] result = new Integer[number];
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			result[i] = random.nextInt(100);
		}
		return result;
	}

}
