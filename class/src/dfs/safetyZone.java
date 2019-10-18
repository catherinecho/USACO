package dfs;
import java.util.*;
import java.io.*;
public class safetyZone {
	//hi
	static int n;
	static int[][] grid;
	static int[][] clone;
	static Scanner in = new Scanner (System.in);
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int max; 
	static int[] list;
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
		grid = new int[n][n];
		clone = new int[n][n];
		max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int b= in.nextInt();
				clone[i][j] = b;
				grid[i][j] = b;
				if(b > max) {
					max = b;
				}
			}
		}
		
		list = new int[max];
		in.close();
		
	}
	private static String solve () {
		int maxans=0;
		for(int s = 1; s <= max; s++) {
			int ans = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(grid[i][j] > s) {
						dfs(i,j,s);
						ans++;
					}
				}
			}
			//System.out.println(Arrays.deepToString(grid));
			maxans=Math.max(maxans, ans);
			//System.out.println(Arrays.deepToString(clone));
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					
					grid[i][j] = clone[i][j];
					
					
				}
			}
			//System.out.println(Arrays.deepToString(grid));
		}
		int e = 0;
		for(int i = 0 ;i < list.length; i++) {
			if(list[i] > e) {
				e= list[i];
			}
		}
		return maxans+"";
	
	}
	static void dfs(int i, int j, int s) {
		grid[i][j] = 0;
		for(int x = 0; x < 4; x++) {
			int nr = i+ dr[x];
			int nc= j + dc[x];
			if(nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] <=s) {
				continue;
			}else {
				dfs(nr,nc, s);
			}
		}
	}
}
