package com.akushwah.java8.exceptions;

public class ExcTest {
	public static void main(String[] args) {
		try {
			throw new Exc1();
		} catch (Exc e) {
			System.out.println("Catch");
		}finally {
			System.out.println("finally");
		}
		
	}
}
