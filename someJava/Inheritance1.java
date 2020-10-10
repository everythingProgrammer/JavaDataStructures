package someJava;

class One{
	int a ; 
	int b; 
	public One(int x){
		a = 0;
		b = 0;
	}
	public void print() {
		System.out.println("One");
	}

}

class Two extends One{
	int c;
	int d;
	
	Two( int a){
		super(0);
		c = 0;
		d = 0;
		
		
	}
	public void print() {
		System.out.println("TWO");
	}
	public static void main(String args[]) {
//		Two ab  = new One();
		One ab = new Two(5);
		One abc = new One(2);
		One temp ;
		temp = ab;
		temp.print();
		temp = abc ;
		temp.print() ;
	}
}


public class Inheritance1 {
	
	public static void main(String args[]) {
		One ab = new Two(5);
		One abc = new One(2);
		Two temp ;
		temp = (Two) ab;
		temp.print();
//		temp = abc ;
		temp.print() ; 
	}
}
