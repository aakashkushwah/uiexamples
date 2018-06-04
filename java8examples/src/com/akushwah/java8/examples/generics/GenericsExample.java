package com.akushwah.java8.examples.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsExample {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("A", "B", "C");
		List<Integer> list2 = Arrays.asList(1, 2, 3, 5);
		printList1(list2);
		printList1(list1);
		printList2(list2);
		printList2(list1);

		List<? extends Integer> intList = new ArrayList<>();
		List<? extends Number> numList = intList; // OK. List<? extends Integer>
													// is a subtype of List<?
													// extends Number>
		
		List<EvenNumber> le = new ArrayList<>();
		List<? extends NaturalNumber> ln = le;
//		ln.add(new NaturalNumber(35));  // compile-time error
		le.add(new EvenNumber(35));  // compile-time error

	}

	public static void printList1(List<? extends Object> list) {
		for (Object object : list) {
			System.out.print(object + " ");
		}
		System.out.println();
	}

	public static void printList2(List<?> list) {
		for (Object object : list) {
			System.out.print(object + " ");
		}
		System.out.println();
	}
}

class NaturalNumber {

	private int i;

	public NaturalNumber(int i) {
		this.i = i;
	}
}

class EvenNumber extends NaturalNumber {

	public EvenNumber(int i) {
		super(i);
	}
}
