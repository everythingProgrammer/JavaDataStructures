package someJava;

/*Overriding methods*/
class RandomClass{
	int abc =0;
	public  void printSomething() {
		System.out.print("Something just like this.");
	}
}

class RandomClass2 extends RandomClass{
	int abc =0;
	public  void printSomething() {
		int abc = 0;
		System.out.println("Something just like this 2");
		super.printSomething();
		System.out.println(super.abc);
		
		
	}
}

public class OverridingMethods  {
	
	public static void main(String args[]) {
		
		RandomClass2 obj =new RandomClass2();
		obj.printSomething();
	}
	
}
