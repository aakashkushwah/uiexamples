package com.akushwah.java8.examples.generics;

import java.util.List;

public class WildcardError {
	void foo(List<?> i) {
//		i.set(0, i.get(0));
		fooHelper(i);
	}

	private <T> void fooHelper(List<T> l) {
		l.set(0, l.get(0));
	}
}
