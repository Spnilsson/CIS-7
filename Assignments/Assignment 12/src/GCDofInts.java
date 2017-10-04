//With Euclid theorem method included

import java.util.Scanner;

public class GCDofInts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =  new Scanner(System.in);
		
		int num1;
		int num2;
		
		int bGCD;			//gcd found by brute force
		int eGCD;			//gcd found by euclid theorem
		
		System.out.print("Enter the first non-negative integer: ");
		num1 = scan.nextInt();
		
		while(posCheck(num1) != true) {				//checks that num1 is positive
			System.out.print("Please enter a non-negative integer: ");
			num1 = scan.nextInt();
		}
		
		System.out.print("Enter the second non-negative integer: ");
		num2 = scan.nextInt();
		
		while(posCheck(num2) != true) {
			System.out.print("Please enter a non-negative integer: ");
			num2 = scan.nextInt();
		}
		
		long euclidTimeStart = System.nanoTime();
		eGCD = euclidGCD(num1, num2);				//finding GCD with euclid theorem and timing it
		long euclidTimeStop = System.nanoTime();
			
		long euclidTimeDuration = euclidTimeStop - euclidTimeStart;
		
		long bruteTimeStart = System.nanoTime();
		bGCD = numGCD(num1, num2);					//finding gcd by brute force and timing it
		long bruteTimeStop = System.nanoTime();
			
		long bruteTimeDuration = bruteTimeStop - bruteTimeStart;
		
		
		System.out.println("The GCD of " + num1 + " and " + num2 + " is " + eGCD + " and the Eclidean Algorithm took "
					+ euclidTimeDuration + " nanoseconds, and the Brute Force Method took "	+ bruteTimeDuration +" nanoseconds.");
	}

	private static int euclidGCD(int n1, int n2) {
		int t;
		while(n2 != 0) {
			t = n2;
			n2 = n1 % n2;
			n1 = t;
		} 
				
		return n1;
	}

	public static boolean posCheck(int number) {
		
		if (number <= 0)
			return false;
		else 
			return true;
	}
	
	
	public static int numGCD(int n1, int n2) {
		int GCD = 0;
		int numMin = Math.min(n1, n2);
		
		for(int i = 1; i <= numMin; i++) {
			if((n1 % i == 0) && (n2 % i == 0)) {
				GCD = i;
			}
		}
		
		return GCD;
	}
}
