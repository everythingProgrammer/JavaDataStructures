package someJava;

interface Player{
	final int id = 10;
	
	 static void move() {
		System.out.println("Something just like this");
	};
}


public class SomeInterfaces implements Player{
	int id = 9;
	
	public void move() {
		System.out.println(id);
		return ;
		
	}
	public static void main(String args[]) {
		System.out.println(Player.id);
		Player.move();
	}
}
