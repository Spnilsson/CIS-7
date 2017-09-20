import java.util.Scanner;

public class PrimeNum {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num;
		int guessPrime;
		int primes = 0;
		int i;
		boolean prime2 = false;
		
		System.out.print("Enter a number that is greater than 0: ");
		num = scan.nextInt();
		
		System.out.print("How many prime numbers do you think is between 0 and " + num + "? ");
		guessPrime = scan.nextInt();
		
		for(i = 0; i <= num; i++)
		{
			prime2 = isPrime(i);
			if(prime2 == true) {
				primes++;
				System.out.println(i + " is a prime number.");
			}
			
		}
		
		if(guessPrime == primes)
			System.out.println("You guessed the correct amount of prime numbers!");
		else
			System.out.println("The correct number of prime numbers between 0 and " + num + " is " + primes + ".");
	}
	
	
	public static boolean isPrime(int i) {
		int temp;
		if (i <= 1)
			return false;
		else
			for(int j = 2; j <= i/2 ; j++) {
			temp = i % j;
				   if(temp==0)
				   {
				      return false;
				   }
			}
		return true;
	}

}

