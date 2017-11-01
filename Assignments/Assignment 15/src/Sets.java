import java.util.ArrayList;
import java.util.Scanner;


public class Sets {
	
	static ArrayList<String> setA = new ArrayList<String>();
	static ArrayList<String> setB = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char choice = ' ';
		menu();
		
		do {
			doAgain();
		}while (choice != 'Q');
		
		return;
	}
	
	public static void menu() {
		char choice = ' ';
		String strChoice;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Below is a list of options to make with the sets, choose an option:");
		System.out.println("A. Add a value to A");
		System.out.println("B. Add a value to B");
		System.out.println("C. Show the interset of A and B");
		System.out.println("D. Show the union of A and B");
		System.out.println("E. Show the difference between A and B");
		System.out.println("F. Show the difference between B and A");
		System.out.println("G. Show the power set of A");
		System.out.println("H. Show the power set of B");
		System.out.println("Q. Quit");
		System.out.print("Enter your choice: ");
		strChoice = scan.nextLine();
			
		strChoice = strChoice.toUpperCase();
		choice = strChoice.charAt(0);
			
		switch (choice) {
			case 'A': 
				addValue(setA);
				break;
			case 'B':
				addValue(setB);
				break;
			case 'C':
				interSet(setA, setB);
				break;
			case 'D':
				unionSet(setA, setB);
				break;
			case 'E':
				diffSet(setA, setB);
				break;
			case 'F':
				diffSet(setB, setA);
				break;
			case 'G':
				powerSet(setA);
				break;
			case 'H':
				powerSet(setB);
				break;
			case 'Q':
				System.exit(0);
		}
		
		return;
	}

	public static void addValue(ArrayList<String> set) {
		Scanner scan = new Scanner(System.in);
		String addition = " ";
		
		System.out.print("Enter the data you want to add to the set: ");
		addition = scan.nextLine();
		
		set.add(addition);
		
		return;
	}
	
	public static void interSet(ArrayList<String> set1, ArrayList<String> set2) {
		
		int size = 0;
		
		for(int i = 0; i < set1.size(); i++) {
			for(int j = 0; j < set2.size(); j++) {
				if (set1.get(i).equals(set2.get(j))) {
					size++;
				}
			}
		}
		
		String set3[] = new String[size];
		int it = 0;
		for(int i = 0; i < set1.size(); i++) {
			for(int j = 0; j < set2.size(); j++) {
				if (set1.get(i).equals(set2.get(j))) {
					set3[it] = set1.get(i);
					it++;
				}
			}
		}
		
		System.out.print("The intersection of sets A and B is {");
		for(int i = 0; i < set3.length; i++) {
			if (i == set3.length - 1) {
				System.out.print(set3[i] + "}");
			}
			else {
				System.out.print(set3[i] + ", ");
			}
		}
		
		return;		
	}
	
	public static void unionSet(ArrayList<String> set1, ArrayList<String> set2) {
		int size = set1.size() + set2.size();
		
		for(int i = 0; i < set1.size(); i++) {
			for(int j = 0; j < set2.size(); j++) {
				if (set1.get(i).equals(set2.get(j))) {
					size--;
				}
			}
		}
		
		String set3[] = new String[size];
		int it = 0;
		
		for(int i = 0; i < set1.size(); i++) {
			set3[it] = set1.get(i);
			it++;
		}
		
		for(int i = 0; i < set2.size(); i++) {
			String variable = set2.get(i);
			String setTemp[] = new String[set2.size()];
			set2.toArray(setTemp);
			
			boolean areSame = variableComp(variable, setTemp);
			
			if(areSame == false) {
				set3[it] = variable;
				it++;
			}
		}
		
		System.out.print("The union between sets A and B is: {");
		for(int i = 0; i < set3.length; i++) {
			if ( i == set3.length - 1)
				System.out.print(set3[i] + "}");
			else
				System.out.print(set3[i] + ", ");
		}
		
	}
	
	public static boolean variableComp(String variable, String[] set) {
		for(int i = 0; i < set.length; i++) {
			if(variable.equals(set[i])) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public static void diffSet(ArrayList<String> set1, ArrayList<String> set2) {
		int size = set1.size();
		
		for(int i = 0; i < set1.size(); i++) {
			for(int j = 0; j < set2.size(); j++) {
				if (set1.get(i).equals(set2.get(j))) {
					size--;
				}
			}
		}
		
		String set3[] = new String[size];
		int it = 0;
		
		for(int i = 0; i < set1.size(); i++) {
			String variable = set1.get(i);
			String setTemp[] = new String[set2.size()];
			set2.toArray(setTemp);
			
			boolean areSame = variableComp(variable, setTemp);
			
			if(areSame == false) {
				set3[it] = variable;
				it++;
			}
		}
		
		if(set1 == setA) {
			System.out.print("The difference between sets A and B is: {");
			for(int i = 0; i < set3.length; i++) {
				if ( i == set3.length - 1)
					System.out.print(set3[i] + "}");
				else
					System.out.print(set3[i] + ", ");
			}
		}
		
		else {
			System.out.print("The difference between sets B and A is: {");
			for(int i = 0; i < set3.length; i++) {
				if ( i == set3.length - 1)
					System.out.print(set3[i] + "}");
				else
					System.out.print(set3[i] + ", ");
			}
		}
	}

	public static void powerSet(ArrayList<String> set) {
		if(set == setA) {
			System.out.println("The powerset of set A is: ");
		}
		else {
			System.out.println("The powerset of set B is: ");
		}
		 int n = set.size();
		 
	        // Run a loop for printing all 2^n
	        // subsets one by obe
	        for (int i = 0; i < (1<<n); i++)
	        {
	            System.out.print("{ ");
	 
	            // Print current subset
	            for (int j = 0; j < n; j++)
	 
	                // (1<<j) is a number with jth bit 1
	                // so when we 'and' them with the
	                // subset number we get which numbers
	                // are present in the subset and which
	                // are not
	                if ((i & (1 << j)) > 0)
	                    System.out.print(set.get(j) + " ");
	 
	            System.out.println("}");
	        }
		
		
	}
	
	public static char doAgain() {
		String strChoice;
		char choice = ' ';
		Scanner scan = new Scanner(System.in);
		System.out.print("\nDo you wish to continue (c to continue q to quit)?");
		strChoice = scan.nextLine();
		strChoice = strChoice.toUpperCase();
		
		choice = strChoice.charAt(0);
		
		if (choice == 'C') {
			menu();
		}
		else if(choice == 'Q') {
			return choice;
		}
		else {
			doAgain();
		}
		
		
		return choice;
	}
}
