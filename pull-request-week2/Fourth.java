import java.util.Scanner;

public class Fourth {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		
		input.close();
		
		for (int x = 1; x <= 10; x++) {
			System.out.println(number + " x " + x + " = " + number*x);
		}
	}
}
