import java.util.Scanner;

public class Second {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int first = input.nextInt();
		int second = input.nextInt();
		int third = input.nextInt();
		
		input.close();
		
		System.out.printf("%d%n%d%n%d%n", first, second, third);
	}
}
