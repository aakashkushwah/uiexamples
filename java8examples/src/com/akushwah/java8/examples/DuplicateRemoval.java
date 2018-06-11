package com.akushwah.java8.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateRemoval<T> {
	public static void main(String[] args) {
		DuplicateRemoval<Integer> dr = new DuplicateRemoval<>();
		List<Integer> list1 = Arrays.asList(1, 4, 5, 6, 3, 2, 1, 2, 3, 2, 4, 5, 5);
		dr.removeDuplicate(list1).forEach(System.out::println);
		list1.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("******************");
		Map<Integer, Integer> map = new HashMap<>();
		list1.stream().forEach(x -> map.put(x, (map.get(x) != null) ? (map.get(x)+1) : 1));
		map.keySet().forEach(x-> System.out.println(x+" "+map.get(x)));

		System.out.println("\n******************");
		DuplicateRemoval<Employee> dr2 = new DuplicateRemoval<>();
		List<Employee> emps = Arrays.asList(new Employee("Aakash", "Kushwah", 13), new Employee("Anmol", "Dutta", 10),
				new Employee("Jagdeep", "Singh", 20), new Employee("Harpreet", "Kalsi", 34),
				new Employee("Amit", "Shukla", 20), new Employee("Aakash", "Kushwah", 13));
		dr2.removeDuplicate(emps).forEach(e -> System.out.println(e.getFirstName()));
		emps.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

	}

	public List<T> removeDuplicate(List<T> list, Comparator<T> comparator) {
		Collections.sort(list, comparator);
		return list.stream().distinct().collect(Collectors.toList());
	}

	public List<T> removeDuplicate(List<T> list) {
		return list.stream().distinct().collect(Collectors.toList());
	}
}
