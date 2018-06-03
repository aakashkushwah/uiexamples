package com.akushwah.java8.examples;

public class InterfaceExample {

	public static void main(String[] args) {
		Target target = new Target();
		System.out.println(target.doSomething("abc"));
		target.show("show");
		target.showAgain("fgt");
		A.staticExample("aakash");
		
	}
}

interface A {
	String doSomething(String str);

	default void show(String str) {
		System.out.println("Default " + str);
	}

	default void showAgain(String str) {
		System.out.println("Default Show Again " + str);
	}

	static void staticExample(String str) {
		System.out.println("static " + str);
	}
}

interface B {
	String doSomething(String str);
	
	default void show(String str){
		System.out.println(" Default in B");
	}
}

class Target implements A, B {
	@Override
	public String doSomething(String str) {
		return str.toUpperCase();
	}

	@Override
	public void show(String str) {
		// TODO Auto-generated method stub
		A.super.show(str);
	}
}
