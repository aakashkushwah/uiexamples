package com.akushwah.java8.examples.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoStream {
	public static void main(String[] args) {
		List<Integer> values = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			values.add(i);
		}

		List<Integer> evens = new ArrayList<>();
		System.out.println(values.parallelStream().filter(i -> i % 2 == 0).count());
		evens = values.parallelStream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("\n1**********************************");
		evens.forEach(System.out::print);
		System.out.println("\n2**********************************");
		System.out.println(values.parallelStream().filter(i -> i % 2 == 0).collect(Collectors.toList()));

		System.out.println("\n3**********************************");
		List<String> list = Arrays.asList("Aakash", "Anmol", "Jagdeep", "LessDeep", "MoreDeep");
		int sum = 0;
		for (String string : list) {
			sum += string.length();
		}
		
		System.out.println("\n4**********************************");
		System.out.println(list.parallelStream().mapToInt(s -> s.length()).reduce((a, b) -> (a + b)).getAsInt());
		
		List<Integer> letterCountList = list.stream().map(s -> s.length()).collect(Collectors.toList());
		
		list.stream().map(s -> s.length()).forEach(System.out::println);
		
		System.out.println("\n5**********************************");
		System.out.println(list.stream().mapToInt(s -> s.length()).reduce(0, (a, b) -> (a + b)));
		System.out.println("\n6**********************************");
		System.out.println(list.stream().reduce(0, (l, b) -> l + b.length(), (a, b) -> (a + b)));
		System.out.println("\n7**********************************");
		System.out.println(list.stream().parallel().reduce("", (a, b) -> a + b));
		System.out.println("\n8********************************** ordered operations in reduce");
		System.out.println(list.stream().parallel().reduce(0, (l, b) -> l + b.length(), (a, b) -> (a + b)));
		System.out.println(list.stream().parallel().reduce("", (l, b) -> l + b.length(), (a, b) -> (a + b)));
		System.out.println("\n9**********************************");
		System.out.println(list.stream().parallel().collect(Collectors.joining()));
		System.out.println("\n10**********************************");
		System.out.println(list.stream().collect(() -> new StringBuilder(), (StringBuilder l, String b) -> l.append(b),
				(StringBuilder a, StringBuilder b) -> (a.append(b)).toString()));
		System.out.println("\n11**********************************");
		System.out.println(list.stream().collect(() -> new StringBuffer(), (StringBuffer l, String b) -> l.append(b),
				(StringBuffer a, StringBuffer b) -> (a.append(b)).toString()));
		System.out.println("\n12**********************************");
		System.out.println(
				list.stream().parallel().collect(() -> new StringBuffer(), (StringBuffer l, String b) -> l.append(b),
						(StringBuffer a, StringBuffer b) -> (a.append(b)).toString()));
		System.out.println("\n13**********************************");
		System.out.println(
				list.stream().parallel().collect(StringBuffer::new, StringBuffer::append, StringBuffer::append));
		System.out.println("\n14**********************************");
		IntStream.rangeClosed(1, 20).forEach(System.out::print);
		
		

		
	}
}
