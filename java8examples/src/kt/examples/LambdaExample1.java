package kt.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.akushwah.java8.examples.Person;

public class LambdaExample1 {
	public static void main(String[] args) {
		String s = "abc";
		doProcessConsumer(s, a -> System.out.println("Hello from consumer " + s));
		doProcessConsumer(s, t -> {
			System.out.println("asdfasfd " + t);
			System.out.println("sadf");
		});

		Person person = doProcessSupplier(() -> new Person("Aakash", 31));

		Person person2 = doProcessSupplier(() -> {
			Person p = new Person();
			p.setAge(21);
			p.setName("ABC");
			return p;
		});

		printPersonAge(person);
		printPersonAge(person2);

		int length = getNameLength(person, p -> {return p.getName().length();});
		System.out.println(length);

		setAge(person, p -> {
			p.setAge(30);
			return p;
		});
		
		
		doSomething(a->System.out.println(a), s);
		doSomething(a->{System.out.println(a); System.out.println("asdf");}, s);

		System.out.println(doSomethingFunction(a -> {return a+"123";}, "456"));
		
		String suffix= "0";
		doSomethingFunction(new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t+"123";
			}
		}, s);
		
		
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("xyz");
		
		
		
		System.out.println(doSomethingFunction1( l -> l.get(0)+suffix, list));
		System.out.println(doSomethingFunction1( l -> l.get(1)+suffix, list));
		
		
		System.out.println(checkPredicate(l-> l.size() ==2, list));
		
		
		System.out.println(checkPredicate(l-> l.get(0).startsWith("a"), list));
		System.out.println(checkPredicate(l-> l.get(0).startsWith("x"), list));
	}

	
	private static boolean checkPredicate(Predicate<List<String>> p, List<String> t) {
		return p.test(t);
	}
	
	private static void doSomething(Consumer<String> consumer, String s) {
		consumer.accept(s);
	}
	
	private static String doSomethingFunction(Function<String,String> f, String xyz) {
		return f.apply(xyz);
	}
	
	private static String doSomethingFunction1(Function<List<String>,String> f, List<String> xyz) {
		return f.apply(xyz);
	}
	
	private static void doProcessConsumer(String s, Consumer<String> consumer) {
		consumer.accept(s);
	}

	private static Person doProcessSupplier(Supplier<Person> supplier) {
		return supplier.get();
	}

	private static void printPersonAge(Person p) {
		System.out.println(p.getAge());
	}

	private static int getNameLength(Person p, Function<Person, Integer> function) {
		return function.apply(p);
	}

	private static Person setAge(Person p, Function<Person, Person> function) {
		return function.apply(p);
	}
	
	
	
	
}

@FunctionalInterface
interface ProcessTrandition{
	String perform(String s);
}

class ProcessImpl implements ProcessTrandition{

	@Override
	public String perform(String s) {
		System.out.println("doing via interface method "+s);
		return s;
	}
	
}