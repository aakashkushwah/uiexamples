package com.akushwah.java8.examples.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.akushwah.java8.examples.Employee;

public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee("Aakash", "Kushwah", 13), new Employee("Anmol", "Dutta", 10),
				new Employee("Jagdeep", "Singh", 20), new Employee("Harpreet", "Kalsi", 34),
				new Employee("Amit", "Shukla", 20));

		Collections.sort(emps, (e1, e2) -> e1.getLastName().compareTo(e2.getLastName()));
		System.out.println("Printing all employees with surname starting with k");
		printConditionally(emps, e -> e.getLastName().startsWith("K"));
		printConditionally(emps, e -> e.getFirstName().startsWith("K"));
		
		System.out.println("*******************************************");
		System.out.println("Printing all employees");
		
		printAll(emps);
		
		System.out.println("*******************************************");
		System.out.println("Printing all employees via universal condition");
		printConditionallyPredicate(emps, p -> true);

		List<Employee> supplierEmps = Arrays.asList(getInstance(() -> new Employee("Jane", "Doe", 12)),
				getInstance(() -> new Employee("John", "Dean", 18)));
		System.out.println("*******************************************");
		demoConsumer(supplierEmps, e-> e.setCity("Noida"));
		demoConsumer(supplierEmps, e-> { if (e.getSalary() > 15) e.setLevel("E3"); else e.setLevel("E2");});
		printConditionallyPredicate(supplierEmps, p -> true);
		
//		System.out.println("******************************************* METHOD REFERENCE");
//		demoConsumer(supplierEmps, System.out::println);
		
		System.out.println("*******************************************");
		int totalSalary = demoFunction1(supplierEmps, e->e.getSalary());
		System.out.println(totalSalary);
		System.out.println("*******************************************");
		demoFunction2(supplierEmps, e -> {if(e.getSalary()<15) return "Noida"; else return "Delhi";});
		
		printConditionallyPredicate(supplierEmps, p -> true);
	}
	
	private static void printConditionally1(List<Employee> list) {
		for (Employee employee : list) {
			if (employee.getLastName().startsWith("k")) {
				System.out.println(employee);
			}
		}
	}

	private static void printConditionally(List<Employee> list, Condition condition) {
		for (Employee employee : list) {
			if (condition.test(employee)) {
				System.out.println(employee);
			}
		}
	}

	private static void printConditionallyPredicate(List<Employee> list, Predicate<Employee> predicate) {
		for (Employee employee : list) {
			if (predicate.test(employee)) {
				System.out.println(employee);
			}
		}
	}

	private static void printAll(List<Employee> emps) {
		emps.forEach(System.out::println);
		emps.forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee t) {
				System.out.println(t);				
			}
		});
		emps.forEach(e -> System.out.println(e+" asdfs fd"));
	}

	private static Employee getInstance(Supplier<Employee> supplier) {
		return supplier.get();
	}
	
	private static void demoConsumer(List<Employee> emps, Consumer<Employee> consumer){
		emps.forEach(consumer::accept);
	}
	
	private static Integer demoFunction1(List<Employee> emps, Function<Employee, Integer> function){
		int salaryAggregate = 0;
		for (Employee employee : emps) {
			salaryAggregate += function.apply(employee); 
		}
		return salaryAggregate;
	}
	
	private static void demoFunction2(List<Employee> emps, Function<Employee, String> function){
		for (Employee employee : emps) {
			employee.setCity(function.apply(employee));
		}
	}
	

}

interface Condition {
	boolean test(Employee e);
}
