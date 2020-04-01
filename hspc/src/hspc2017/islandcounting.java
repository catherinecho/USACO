package hspc2017;
import java.util.*;
public class islandcounting {
	static int[][] grid;
	static int n;
	static int m;
	static int[] dr = {1, -1, 0 , 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = Integer.parseInt(in.nextLine());
		m = Integer.parseInt(in.nextLine());
		grid= new int[n][m];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.nextLine());
			for(int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 1) {
					dfs(i,j);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	public static void dfs(int i, int j) {
		if(grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		for(int x = 0; x < 4; x++) {
			int curR = i + dr[x];
			int curC = j + dc[x];
			if(valid(curR, curC)) {
				dfs(curR, curC);
			}
		}
	}
	public static boolean valid(int i, int j) {
		if(i >=0 && i <n && j >= 0 && j < m) {
			return true;
		}
		return false;
	}
}
