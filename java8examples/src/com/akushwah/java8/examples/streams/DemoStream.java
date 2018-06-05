package com.akushwah.java8.examples.streams;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		
		List<String> list = Arrays.asList("Aakash", "Anmol", "Jagdeep", "LessDeep", "MoreDeep");
		System.out.println(list.stream().mapToInt(s -> s.length()).reduce((a,b) -> (a+b)).getAsInt());
		System.out.println(list.stream().mapToInt(s -> s.length()).reduce(0, (a,b) -> (a+b)));
		System.out.println(list.stream().reduce(0, (l,b)->l+b.length(), (a,b) -> (a+b)));
		System.out.println(list.stream().parallel().reduce("", (a,b)->a+b));
		System.out.println(list.stream().parallel().reduce("", (l,b)->l+b.length(), (a,b) -> (a+b)));
		
		System.out.println(list.stream().parallel().collect(Collectors.joining()));
		System.out.println(list.stream().collect( () -> new StringBuilder() , (StringBuilder l, String b)->l.append(b), (StringBuilder a, StringBuilder b)->(a.append(b)).toString()));
		
		System.out.println(list.stream().collect( () -> new StringBuffer() , (StringBuffer l, String b)->l.append(b), (StringBuffer a, StringBuffer b)->(a.append(b)).toString()));
		
		System.out.println(list.stream().parallel().collect( () -> new StringBuffer() , (StringBuffer l, String b)->l.append(b), (StringBuffer a, StringBuffer b)->(a.append(b)).toString()));
		
		System.out.println(list.stream().parallel().collect( StringBuffer::new , StringBuffer::append, StringBuffer::append));
	}
}
