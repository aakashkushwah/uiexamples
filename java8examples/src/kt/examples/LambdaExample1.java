package kt.examples;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
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
		
		LocalDate date = LocalDate.now();
		System.out.println(date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMAN));
		System.out.println(date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
		System.out.println(date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("en")));

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