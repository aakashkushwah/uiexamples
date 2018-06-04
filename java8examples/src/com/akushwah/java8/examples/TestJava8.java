package com.akushwah.java8.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestJava8 {

	public static void main(String[] args) {

		List<String> alpha = Arrays.asList("a", "b", "c", "d");

		// Before Java8
		List<String> alphaUpper = new ArrayList<>();
		for (String s : alpha) {
			alphaUpper.add(s.toUpperCase());
		}

		System.out.println(alpha); // [a, b, c, d]
		System.out.println(alphaUpper); // [A, B, C, D]

		// Java 8
		List<String> collect8List = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(collect8List); // [A, B, C, D]

		// Extra, streams apply to any data type.
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
		System.out.println(collect1); // [2, 4, 6, 8, 10]

		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		items.forEach((k, v) -> {
			System.out.println("Key:" + k + ", value:" + v);
		});

		List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
				new Person("lawrence", 40));

		Person result1 = persons.stream() // Convert to steam
				.filter(x -> "jack".equals(x.getName())) // we want "jack" only
				.findAny() // If 'findAny' then return found
				.orElse(null); // If not found, return null

		System.out.println(result1);

		Person result2 = persons.stream().filter(x -> "ahmook".equals(x.getName())).findAny().orElse(null);

		System.out.println(result2);
		
		String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
        
        List<String> collect2 = persons.stream()
                .map(p -> {System.out.println("transforming "+p);
                	return p.getName()+" "+p.getAge();})
                .collect(Collectors.toList());

        collect2.forEach(System.out::println);
	}

}
