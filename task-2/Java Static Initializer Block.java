import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static Scanner scanner = new Scanner(System.in);
    static int B = scanner.nextInt();
    static int H = scanner.nextInt();
    static boolean flag = (B >= 0 && H >= 0);
 static {
     if (B < 0 || H < 0) {
        System.out.println("java.lang.Exception: Breadth and height must be positive");
    }
 }
    

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class