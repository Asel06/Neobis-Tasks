import java.util.Scanner;

public class Third {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		
		input.close();
		
		if (number % 2 == 1) {
			System.out.println("Weird");
		} else if (number >= 2 && number <= 5) {
			System.out.println("Not Weird");
		} else if (number >= 6 && number <= 20) {
			System.out.println("Weird");
		} else if (number > 20) {
			System.out.println("Not Weird");
		}
	}
}
