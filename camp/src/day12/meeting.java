package day12;
import java.util.*;

import day12.daisy.Graph;
public class meeting {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int m = in.nextInt();
	static int[] bspeed = new int[m];
	static int[] espeed = new int[m];
	static class Graph{
		int V;
		LinkedList<Integer> adjListArray[];
		Graph(int V){
			this.V = V;
			adjListArray = new LinkedList[V+1];
			for(int i = 1; i <= V; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	static void addEdge(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}
	public static void main(String[] args) {
		Graph graph = new Graph(n);
		for(int i = 0; i < m; i++) {
			addEdge(graph,in.nextInt(), in.nextInt());
			bspeed[i] = in.nextInt();
			espeed[i] = in.nextInt();
		}
	}
}
