package com.akushwah.java8.examples.optional;

import java.util.Optional;
import java.util.function.Function;

public class OptionalExample {

	public static void main(String[] args) {

		Function<String, String> getSecondWord =  s -> {
			return s.split(" ").length > 1 ? s.split(" ")[1] : null;
		};
		
		Function<String, Integer> getLetterCount= s -> s.length();
		
		Integer count = getSecondWord.andThen(getLetterCount).apply("Aakash Kushwah");
		System.out.println(count);
		
		Optional<String> myOpt = Optional.ofNullable(getSecondWord.apply("Jake Gyllenhall"));
		if(myOpt.isPresent()){
			System.out.println("My Value: "+myOpt.get());
			myOpt.ifPresent(System.out::println);
		}else{
			myOpt.orElse("No Value");
			System.out.println("No Value");
		}
		
		Optional.ofNullable(getSecondWord.apply("Bat Man")).map(getLetterCount).ifPresent(System.out::println);
		Integer countNew = Optional.ofNullable(getSecondWord.apply("Bat")).map(getLetterCount).orElse(0);
		System.out.println("Count New "+countNew);
		
		Function<String, Optional<String>> getSecondWordBetter =  s -> {
			return s.split(" ").length > 1 ? Optional.ofNullable(s.split(" ")[1]) : Optional.of("");
		};
		
		Function<Optional<String>, Integer> getLetterCountBetter = s-> (s.get().length());
		System.out.println(getSecondWordBetter.andThen(getLetterCountBetter).apply("Aakash"));
		
		
	}

}
