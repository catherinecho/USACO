package day8;
import java.util.*;
// out of memory so create an arrayList somewhere...
public class greatrevegetation {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int m = in.nextInt();
//	static boolean[][] M = new boolean[n+1][n+1];
 	static int ans = 0;
	static boolean[] vis = new boolean[n+1];
	static ArrayList<Integer>[] M = new ArrayList[n+1];
	// number of ds have to even
	static int d = 0;
	public static void main(String[] args) {
		for(int i=0; i<=n; i++)
			M[i] = new ArrayList<Integer>();

		for(int i = 1; i <= m; i++) {
			String r = in.next();
			if(r.equals("D")) {
				d++;
			}
			int x = in.nextInt();
			int y = in.nextInt();
			M[x].add(y);
			M[y].add(x);
		}
		for(int i = 1; i <= n; i++) {
			if(vis[i] == false) {
				dfs(i);
				ans++;
			}
		}
		if(d %2 ==0|| d <= n) {
			System.out.print(1);
			for(int i = 1; i <= ans; i++) {
				System.out.print(0);
			}
			System.out.println();
		}else {
			System.out.println(0);
		}
		
	}
	public static void dfs(int curr) {
		vis[curr]  = true;
		for(int i = 0; i < M[curr].size(); i++) {
			if(vis[M[curr].get(i)] == false) {
				dfs(M[curr].get(i));
			}
		}
	}
	
	
}