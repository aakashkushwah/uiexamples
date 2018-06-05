package kt.examples;

public class InterfaceExample {
	public static void main(String[] args) {
		A a = new SampleImplementation();
		a.process("abc");
		a.dfltExample("sdf");
		a.dfltExample2("asd");
		A.staticExample();
		B b = new SampleImplementation();
	
	}
}

interface A{
	void process(String s);
	
	default void dfltExample(String s){
		System.out.println("Default method example "+s);
	}
	
	default void dfltExample2(String s){
		System.out.println("Default method example "+s);
	}
	
	static void staticExample(){
		System.out.println("static example");
	}
}

interface B{
	void process1(String s);
	void process(String s);
	
	default void dfltExample(String s){
		System.out.println("Default method example "+s);
	}
}

class SampleImplementation implements A, B{

	@Override
	public void process(String s) {
		System.out.println("Sample implementation process");
	}

	@Override
	public void process1(String s) {
		System.out.println("From B");
		
	}

	@Override
	public void dfltExample(String s) {
		System.out.println("asdf");
		A.super.dfltExample(s);
		B.super.dfltExample(s);
	}
	
}
