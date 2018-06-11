package com.akushwah.java8.examples.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import com.akushwah.java8.examples.Employee;
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
		}).ifPresent(System.out::println);

		map.keySet().stream().forEach(x -> System.out.print(
				Optional.ofNullable(map.get(x)).map(Supplier::get).filter(a -> a.getName().length() > 3).map(s -> {
					s.setName(s.getName().replaceAll("A", "Z"));
					return s;
				}).get() + " "));

		Map<Class<?>, Supplier<?>> yoMap = new HashMap<>();
		yoMap.put(Person.class, ()-> new Person("Joker", 31));
		yoMap.put(Employee.class, ()-> new Employee("Joker", "Singh", 31));

		yoMap.keySet().stream().forEach(x -> Optional.ofNullable(map.get(x)).map(Supplier::get).ifPresent(y-> System.out.println(y)));

		
		ParameterProvider provider = ParameterProvider.of( (s)->{Person p = new Person(s, 31);return p;});
		ParameterProvider.of(new Function<String, Object>() {
			
			@Override
			public Object apply(String t) {
				Person p = new Person(t, 31);
				return p;
			}
		});
		
		System.out.println(provider.get(Person.class, "Aakash"));
		
	}
}
