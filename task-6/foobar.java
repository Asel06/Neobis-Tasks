import java.io;
import java.util.Scanner;

public class foobar{
	public static void(String[] args){
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		scanner.close();
		if(number%2 == 0){
			System.out.println("foo " + number);
		}
		else {
			System.out.printl("bar " + number);
		}
	}
}