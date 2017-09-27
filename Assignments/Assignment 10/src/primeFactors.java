import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class primeFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int number;
		
		System.out.print("Enter a number you want to see the prime factors of: ");
		number = scan.nextInt();
		
		primeFactors(number);
		
		
		
	}
	public static void primeFactors(int number) {
		
		while(number % 2 == 0) {
			System.out.print(2 + " ");
			number /= 2;
		}
		
		for(int i = 3; i < Math.sqrt(number); i += 2) {
			 while (number % i == 0)
	            {
	                System.out.print(i + " ");
	                number /= i;
	            }
		}
		
		 if (number > 2)
	            System.out.print(number);
	}
	
}
