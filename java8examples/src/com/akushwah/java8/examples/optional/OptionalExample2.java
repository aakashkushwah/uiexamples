package com.akushwah.java8.examples.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.akushwah.java8.examples.Person;

public class OptionalExample2 {
	public static void main(String[] args) {
		Map<String, Supplier<Person>> map = new HashMap<>();

		map.put("Aakash", () -> new Person("Aakash", 31));
		map.put("Anmol", () -> new Person("Anmol", 31));
		map.put("Aavi", () -> {
			Person p = new Person();
			p.setName("Aavi");
			return p;
		});

		String key = "Aavi";
		Optional.ofNullable(map.get(key)).map(Supplier::get).filter(a -> a.getName().length() > 5).map(s -> {
			s.setName(s.getName().replaceAll("A", "Z"));
			return s;
		}). ifPresent(System.out::println);

		map.keySet().stream().forEach(x -> System.out.print(
				Optional.ofNullable(map.get(x)).map(Supplier::get).filter(a -> a.getName().length() > 3).map(s -> {
					s.setName(s.getName().replaceAll("A", "Z"));
					return s;
				}).get() + " "));

	}
}
