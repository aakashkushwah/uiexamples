package com.akushwah.java8.examples.optional;

import java.util.List;

//@FunctionalInterface
public interface ParameterProvider2 {
	<T> void set(List<T> t, String key);
	<T> void set2(T t);
}

class Impl implements ParameterProvider2{

	@Override
	public <T> void set(List<T> t, String key) {
		
	}

	@Override
	public <T> void set2(T t) {
		// TODO Auto-generated method stub
		
	}


	
	
}