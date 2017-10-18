package factorial;
import java.util.Scanner;
import java.util.Stack;

public class recursFactorial {

	static Stack<Integer> callStack = new Stack<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num;
		int choice = 0;
		
		
		System.out.print("1. Factorial\n2. Fibonacci\nWhich do you want to do? ");
		choice = scan.nextInt();
		
		if (choice == 1) {
			System.out.print("Enter the number you wish to factorial: ");
			num = scan.nextInt();
			
			int product = Factorial(num);
			
			System.out.print("\nThe factorial of " + num + " is: " + product);
		
		}
		else if(choice == 2) {
			System.out.print("Enter the number you wish to see the Fibonacci sequence from: ");
			num = scan.nextInt();
			
			
			
			
			System.out.println("The Fibonacci number for " + num + " is: " + Fib(num));
									
		}
		else { 
			System.out.println("Invalid entry.");
		}
	}

	public static int Factorial(int n) {
		int product;
		callStack.push(n);
		
		if (n <= 1) {
			System.out.println(callStack.toString());
			callStack.pop();
			System.out.println(callStack.toString());
			return 1;
		}
				
		System.out.println(callStack.toString());
		
		product = n * Factorial(n - 1);
		callStack.pop();
		System.out.println(callStack.toString());
		return product;
		
	}
	
	public static int Fib(int n) {
		callStack.push(n);		
		if (n == 0 || n == 1) {
			System.out.println(callStack.toString());
			callStack.pop();
			return n;
		}
		System.out.println(callStack.toString());
		callStack.pop();
		return (Fib(n - 1) + Fib(n - 2));
	}
}

