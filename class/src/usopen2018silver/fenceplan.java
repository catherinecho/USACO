package usopen2018silver;
import java.util.*;
import java.io.*;
public class fenceplan {
	static int maxx = 0;
	static int minx = 100000001;
	static int maxy = 0;
	static int miny = 100000001;

	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File ("fenceplan.in"));
		PrintWriter out = new PrintWriter(new File("fenceplan.out"));
		Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		int N = in.nextInt();
		int M = in.nextInt();
		boolean[] visited = new boolean[N];
		for(int x = 1; x <= N; x++) {
			int i = in.nextInt();
			int j = in.nextInt();
			coordinates.add(new Coordinate(i, j));
			visited[x-1] = false;
		}
		for(int x = 1; x <= M; x++) {
			int cow1 = in.nextInt();
			int cow2 = in.nextInt();
			if(!adj.containsKey(cow1)) {
				adj.put(cow1, new ArrayList<Integer>());
			}
			if(!adj.containsKey(cow2)) {
				adj.put(cow2, new ArrayList<Integer>());
			}
			// constructing adjacency list
			adj.get(cow1).add(cow2);
			adj.get(cow2).add(cow1);
		}
		int perimeter = Integer.MAX_VALUE;
		for(int x = 1; x <= N; x++) {
			backtrack(x, adj, coordinates, visited);
			// calculate perimeter and find minimum using global variables
			// reset the global variables for future use
			perimeter = Math.min(perimeter,2*((Math.abs(maxx - minx))+(Math.abs(maxy-miny))));
			maxx = 0;
			minx = 100000001;
			maxy = 0;
			miny = 100000001;
		}
		out.println(perimeter);
		in.close();
		out.close();
	}
	public static void backtrack(int start, Map<Integer, ArrayList<Integer>> adj, ArrayList<Coordinate> coordinates, boolean[] visited) {
		// base case, return
		if(visited[start-1]== true)
			return;
		// general case, the usual dfs to visit the other cows in the same moonet
		visited[start-1] = true;
		maxx = Math.max(maxx, coordinates.get(start-1).x);
		minx = Math.min(minx, coordinates.get(start-1).x);
		maxy = Math.max(maxy, coordinates.get(start-1).y);
		miny = Math.min (miny, coordinates.get(start-1).y);
		for(int i = 1; i <= adj.get(start).size(); i++){
			backtrack(adj.get(start).get(i-1), adj, coordinates, visited); 
		}
	}


}
class Coordinate {
	public int x;
	public int y;
	public Coordinate(int xx, int yy) {
		x = xx;
		y = yy;
	}
}
