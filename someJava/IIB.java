package someJava;
import java.util.*;
public class IIB {
	
	static int zero ;
	
	
	public IIB() {
		System.out.println("constructor?");
	}
	
	{
//		zero = 0;
		System.out.println("IIB  Hello?");
	}
	
	public static void main(String args[]) {
		IIB abc = new IIB();
		IIB abc2 = new IIB();
	}
	
}
/*		Output 
 * 		Hello?
 *		constructor?
*/


