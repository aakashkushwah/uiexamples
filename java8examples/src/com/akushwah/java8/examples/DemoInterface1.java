package com.akushwah.java8.examples;

import java.util.function.Consumer;
import java.util.function.Supplier;


interface Phone{
	void call();
	default void message(){
		System.out.println("sent");
	}
}

class AndroidPhone implements Phone{
	public void call(){
		System.out.println("Calling");
	}
}
public class DemoInterface1 {
	
	public static void main(String[] args) {
		Phone p = new AndroidPhone();
		p.call();
		p.message();
		
		Consumer < String > consumer1 = (arg) -> { System.out.println(arg + "OK");};
        consumer1.accept("TestConsumerAccept - ");
        Consumer < String > consumer2 = (x) -> {
            System.out.println(x + "OK!!!");
        };
        consumer1.andThen(consumer2).accept("TestConsumerAfterThen - ");
        
        Supplier < Person > supplier = () -> {
            return new Person("Varun", 30);
        };
        Person person = supplier.get();
        System.out.println(person);
        
	}
}
