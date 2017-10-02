import java.util.Scanner;

public class GCDofInts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =  new Scanner(System.in);
		
		int num1;
		int num2;
		
		System.out.print("Enter the first non-negative integer: ");
		num1 = scan.nextInt();
		
		while(posCheck(num1) != true) {
			System.out.print("Please enter a non-negative integer: ");
			num1 = scan.nextInt();
		}
		
		System.out.print("Enter the second non-negative integer: ");
		num2 = scan.nextInt();
		
		while(posCheck(num2) != true) {
			System.out.print("Please enter a non-negative integer: ");
			num2 = scan.nextInt();
		}
		
		int gcd = numGCD(num1, num2);
		
		System.out.println("The GCD of " + num1 + " and " + num2 + " is " + gcd + ".");
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
