package dfs;
import java.util.*;
import java.io.*;

public class DFS01 {
	//hi
	static int n, m, cnt;
	static int[][] grid;
	static Scanner in = new Scanner (System.in);
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) {
	
		try {
			init();
			System.out.println(solve());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	private static void init () {
	
		n = in.nextInt();
		m = in.nextInt();
		grid = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		
		in.close();
		
	}
	
	private static String solve () {
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 1) {
					dfs(i,j);
					ans++;
				}
			}
		}
		return ans+"";
	
	}
	static void dfs(int i, int j) {
		grid[i][j] = 0;
		for(int x = 0; x < 4; x++) {
			int nr = i+ dr[x];
			int nc= j + dc[x];
			if(nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] == 0) {
				continue;
			}else {
				dfs(nr,nc);
			}
		}
	}

}

