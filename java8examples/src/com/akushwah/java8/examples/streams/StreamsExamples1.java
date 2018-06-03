package com.akushwah.java8.examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.akushwah.java8.examples.Employee;

public class StreamsExamples1 {
	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee("Aakash", "Kushwah", 13), new Employee("Anmol", "Dutta", 10),
				new Employee("Jagdeep", "Singh", 20), new Employee("Harpreet", "Kalsi", 34),
				new Employee("Amit", "Shukla", 20));

		emps.stream().filter(e -> e.getFirstName().startsWith("A")).forEach(System.out::println);
		System.out.println("************************************");
		Optional<Integer> value = emps.stream().filter(e -> e.getSalary() > 15).map(e -> e.getSalary())
				.reduce((t, u) -> t + u);
		System.out.println(value.get());
		Averager averager = emps.stream().
				filter(p -> p.getSalary() > 13).
				map(Employee::getSalary).
				collect(Averager::new, Averager::accept,Averager::combine);
		System.out.println(averager.average());
		emps.stream().
		filter(p -> p.getSalary() > 13).
		map(Employee::getSalary).
		collect(Collectors.toList()).forEach(i->System.out.print(" "+i));
		

	}
}

class Averager implements Consumer<Integer> {
	private int total = 0;
	private int count = 0;

	public double average() {
		return count > 0 ? ((double) total) / count : 0;
	}

	public void accept(Integer i) {
		total += i;
		count++;
	}

	public void combine(Averager other) {
		total += other.total;
		count += other.count;
	}
}
