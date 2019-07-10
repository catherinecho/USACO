package day13;
import java.util.*;
public class pathfind {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int m = in.nextInt();
	static Queue<Integer> q = new LinkedList<Integer>();
	static int[][] map = new int[n][n];
	static boolean[] visited = new boolean[n];
	static int[] dist = new int[n+5];
	static int max = -1;
	public static void main(String[] args) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
			}
		}
		q.add(m-1);
		visited[m-1] = true;
		dist[m-1] = 0;
		bfs();
			
		System.out.println(m);
		for(int i=1; i<=max; i++) {
			for(int j=0; j<n; j++) {
				if(dist[j] == i)
					System.out.print(j+1 + " ");
			}
			System.out.println();
		}
	}
	public static void bfs() {
		
		while(!q.isEmpty()) {
			int current = q.remove();
			for(int i=0; i<n; i++) {
				if(map[current][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					dist[i] = dist[current]+1;
					max = Math.max(max, dist[i]);
				}
			}
		}
		
	}
}
