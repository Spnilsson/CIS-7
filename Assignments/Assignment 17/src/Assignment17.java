import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Assignment17 {
	
	enum VertexState {
        White, Gray, Black 
    }
   
	
	public static int vertNum = 0;
	public static int edgeNum = 0;
	static ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
	static ArrayList<VertexState> state = new ArrayList<VertexState>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char choice = ' ';	
				
		do {
			menu();
		}while (choice != '3');
		
		return;
	}

	
	
	public static char menu() {
		char choice = ' ';
		String strChoice;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("The graph currently contains " + vertNum + " vertices and " + edgeNum + " edges.");
		
		if(vertNum == 0 || edgeNum == 0) {
			System.out.println("The vertex with the highest degree is: null");
		}

		else {
			System.out.println("The vertex with the highest degree is: " + highDegree());
		}
		
		System.out.println("There are " + numIsolateVert() + " isolated verticies.");
		
		System.out.println("There are " + numLoop() + " loops.");
		
		if(isComplete() == false) {
			System.out.println("The graph is not complete.");
		}
		else
			System.out.println("The graph is complete.");
		
		if (numIsolateVert() > 0 || edgeNum == 0 || isConnected() == false) {
			System.out.println("The graph is not connected.");
		}
		else {
			System.out.println("The graph is connected.");
		}
		//put the highest degree, # of isolated vertices, # of loops and 
		//whether the graph is connected and or complete here
		
		
		System.out.println("Choose an option:");
		System.out.println("1. Add a vertex.");
		System.out.println("2. Add an edge.");
		System.out.println("3. Quit");
		System.out.print("Enter your choice: ");
		strChoice = scan.nextLine();
		
		choice = strChoice.charAt(0);
		
		switch (choice) {
			case '1':
				addVert();
				break;
			case '2':
				addEdge();
				break;
			case '3':
				System.exit(0);
		}
		
		return choice;
	}

	public static int highDegree() {
		// TODO Auto-generated method stub
		if(vertNum == 1) {
			return matrix.get(0).get(0);
		}
		
		int v1 = degree(0);
		int v2 = degree(1);
		
		for(int i = 0; i < vertNum; i++) {			
			if(v2 >= v1) {
				v1 = v2;
			}
			v2 = degree(i);
		}
		
		return v1;
	}
	
	public static int degree(int i) {
		int value = matrix.get(i).get(0);
		
		for(int j = 1; j < vertNum; j++) {
			
			value += matrix.get(i).get(j);
		}
		
		return value;
	}


	public static int numIsolateVert() {
		// TODO Auto-generated method stub
		int total = 0;
		
		for(int i = 0; i < vertNum; i++) {
			if(isoComp(i) == true) {
				total++;
			}
		}
		
		return total;
	}
	
	public static int numLoop() {
		int total = 0;
		
		for(int i = 0; i < vertNum; i++) {
			for(int j = 0; j < vertNum; j++) {
				int value = matrix.get(i).get(j);
				if(value > 0 && i == j) {
					total++;
				}
			}
		}
		
		return total;
	}

	public static boolean isoComp(int i) {
		for(int j = 0; j < vertNum; j++) {
			if(matrix.get(i).get(j) > 0 && i != j) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isComplete() {
		
		for(int i = 0; i < vertNum; i++) {
			for(int j = 0; j < vertNum; j++) {
				if(matrix.get(i).get(j) == 0 && i != j) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isConnected() {
		if(vertNum == 1) {
			return true; 
		}
		else
			DFS();
		
		for(int i = 0; i < vertNum; i++) {
			if(state.get(i) != VertexState.Black) {
				return false;
			}
		}
		return true;
	}
	
	
    public static void DFS()
    {
    	state.ensureCapacity(vertNum);
        for (int i = 0; i < vertNum; i++) {
        	state.add(i, VertexState.White);
        }
        runDFS(0);
    }
   
    public static void runDFS(int u)
    {
          state.set(u, VertexState.Gray);
          for (int v = 0; v < vertNum; v++) {
                if (isEdge(u, v) && state.get(v) == VertexState.White) {
                      runDFS(v);
                }
          }
          state.set(u, VertexState.Black);
    }

	public static boolean isEdge(int u, int v) {
		if(matrix.get(u).get(v) == 0 && u != v) {
			return false;
		}
		return true;
	}



	public static void addVert() {
		vertNum++;
		
		matrix.add(new ArrayList<Integer>(Collections.nCopies(vertNum, 0)));
		
		for(int i = vertNum - 2; i >= 0; i--) {
			matrix.get(i).add(0);
		}
	}
	
	public static void addEdge() {
		edgeNum++;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nEnter the first vertex you want to connect with an edge "
				+ "(remember that the first list is recorded at 0): ");
		
		int v1 = scan.nextInt();
		
		System.out.print("\nEnter the second vertex you want to connect with an edge : ");
		
		int v2 = scan.nextInt();
		
		int value = matrix.get(v1).get(v2);
		value++;
		if(v1 == v2){
			value++;
		}
		matrix.get(v1).set(v2, value);
		matrix.get(v2).set(v1, value);
		
	}
}
