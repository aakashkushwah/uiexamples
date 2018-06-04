package com.akushwah.java8.examples.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExample2 {
	public static void main(String args[]) {
		List<Employee> peoples = new ArrayList<>();
		peoples.add(new Employee(101, "Victor", 23));
		peoples.add(new Employee(102, "Rick", 21));
		peoples.add(new Employee(103, "Sam", 25));
		peoples.add(new Employee(104, "John", 27));
		peoples.add(new Employee(105, "Grover", 23));
		peoples.add(new Employee(106, "Adam", 22));
		peoples.add(new Employee(107, "Samy", 224));
		peoples.add(new Employee(108, "Duke", 29));
		
		double average = calculateAverage(peoples);
		
		System.out.println("Average age of employees are (classic way) : " + average);
		average = average(peoples);
		System.out.println("Average age of employees are (lambda way) : " + average);
		peoples.forEach(p -> {System.out.println(p.getName());});
		System.out.println("Total Age: "+total(peoples));
		
		System.out.println("***************************************** Map Example");
		peoples.stream().map(p -> p.getAge()).forEach(i -> System.out.println("Age is "+i));
		
		System.out.println("***************************************** Flat Map Example");
		flatMap();
		
		System.out.println("***************************************** Sort Example");
		sortMap();
		
		System.out.println("***************************************** Any Match Example");
		anyMatch();
		
		System.out.println("***************************************** Distinct Example");
		distinct();
		
		System.out.println("***************************************** find Any Example");
		findAny();
		
		System.out.println("***************************************** skip Example");
		skip();
		
		System.out.println("***************************************** Reduce Example");
		System.out.println(peoples.stream().map(p -> p.getAge()).reduce(0, (i,j) -> (i+j)));
		System.out.println(peoples.stream().map(p -> p.getAge()).reduce((i,j) -> (i+j)));
		
		System.out.println("***************************************** Collect Example");
		peoples.stream().map(p -> p.getAge()).collect(Collectors.toList()).forEach(System.out::println);
	}
	
	private static void flatMap(){
		 String[][] data = new String[][]{{"Aakash", "Jagdeep"}, {"Anmol", "Peeyush"}, {"Rajat", "Prateek"}};
		 Arrays.stream(data).flatMap(x -> Arrays.stream(x)).filter(s -> s.startsWith("A")).forEach(System.out::println);
	}
	
	private static void sortMap(){
		 String[] data = new String[]{"Aakash", "Jagdeep", "Anmol", "Peeyush", "Rajat", "Prateek"};
		 Arrays.stream(data).sorted((x,y) -> ((Integer)x.length()).compareTo(y.length())).forEach(System.out::println);
	}
	
	private static void anyMatch(){
		 String[] data = new String[]{"Aakash", "Jagdeep", "Anmol", "Peeyush", "Rajat", "Prateek"};
		 System.out.println(Arrays.stream(data).anyMatch(s -> s.contains("ee")));
	}
	
	private static void distinct(){
		 String[] data = new String[]{"A", "B", "C", "D", "A", "B"};
		 Arrays.stream(data).distinct().forEach(System.out::println);
	}
	
	private static void findAny(){
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
	    Optional<Integer> result = list
	      .stream().parallel()
	      .filter(num -> num < 4).findAny();
	    result.ifPresent(System.out::println);
	}
	
	private static void skip(){
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
	    list.stream().skip(2).forEach(System.out::println);
	    System.out.println("Limit");
	    list.stream().parallel().limit(2).forEach(System.out::println);
	}

	private static double calculateAverage(List<? extends Employee> employees) {
		int totalEmployee = employees.size();
		double sum = 0;
		for (Employee e : employees) {
			sum += e.getAge();
		}
		double average = sum / totalEmployee;
		return average;
	}

	/**
	 * * Java method which uses map reduce to calculate average of list of
	 * employees * in JDK 8. * @param peoples * @return average age of given
	 * list of Employees
	 */
	private static double average(List<? extends Employee> peoples) {
		return peoples.stream().mapToInt(p -> p.getAge()).average().getAsDouble();
	}
	
	private static double total(List<? extends Employee> peoples) {
		return peoples.stream().mapToInt(p -> p.getAge()).sum();
	}
}

class Employee {
	private final int id;
	private final String name;
	private final int age;

	public Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
