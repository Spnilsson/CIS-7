import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class towerOfHanoiRecurs {

	static Tower towerA = new Tower("A");
	static Tower towerB = new Tower("B");
	static Tower towerC = new Tower("C");
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n;
	
		
		System.out.print("Enter the number of disks you want to use in the Tower of Hanoi: ");
		n = scan.nextInt();
		for(Integer i = n; i > 0; i--) { 
			towerA.disks.push(i);
		}
		printTower();
		
		move(n, towerA, towerB, towerC);
		printTower();
		
	}
	public static void move(int n, Tower start, Tower end, Tower aux) {
		String dummy;
		Scanner scan = new Scanner(System.in);
		
		if (n == 1) {
			System.out.println("\nMove " + start.name + " to " + end.name + ".");
			end.disks.push(start.disks.pop());
			printTower();
			
			System.out.println("\nMove disc from tower " + start.name + " to tower " + end.name + ". \n(Press enter to clear screen and continue)");
			dummy = scan.nextLine();
		}
		else {
			move(n - 1, start, aux, end);
			end.disks.push(start.disks.pop());
			printTower();
	        System.out.println("\nMove disc from tower " + start.name + " to tower " + end.name + ". \n(Press enter to clear screen and continue)");
	        dummy = scan.nextLine();
	        move(n - 1, aux, end, start);
		}	
		
	
	}
	
	public static void printTower() {
		
		System.out.print("\nTower A: " );
		for (Integer i : towerA.disks)
			System.out.print(i.toString() + ' ');
		System.out.print("\nTower B: " );
		for (Integer i : towerB.disks)
			System.out.print(i.toString() + ' ');
		System.out.print("\nTower C: " );
		for (Integer i : towerC.disks)
			System.out.print(i.toString() + ' ');
		
	}
}
