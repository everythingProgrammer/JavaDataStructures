package someJava;


class A{
	
	public static void print( ) {
		System.out.println("This is A");
	}
}


class B extends A{
	public static void print() {
		System.out.println("This is B");
		
	}
}

class C extends B{
	public static void print() {
		System.out.println("This is C");
	}
}
public class DynamicMethodDispatch {

	public static void main(String args[]) {
//		C obj = new C();
//		obj.print(5);
		A obj = new C();
		obj.print();
	}

}

