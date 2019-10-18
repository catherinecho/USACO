package dfs;
import java.util.*;
import java.io.*;
public class redgreenmed {
	//hi
	static int n;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static String[][] grid;
	static String[][] clone;
	static Scanner in = new Scanner (System.in);
	static int R = 0;
	static int G= 0; 
	static int B = 0;
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
		String num = in.nextLine();
		
		n = Integer.parseInt(num);
		clone = new String[n][n];
		grid = new String[n][n];
		for(int i = 0; i <n ;i++) {
			String st = (in.nextLine());
			for(int j = 0; j < n; j++) {
				
				grid[i][j] = st.charAt(j) +"";
				clone[i][j] = st.charAt(j) + "";
			}
			
			
		}
		
		/*
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = clone[i][j];
			}
		}
		*/
		
		in.close();
		
	}
	public static String solve() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!grid[i][j].equals("0")) {
					if(grid[i][j].equals("R")) {
						dfs(grid[i][j], i,j);
						R++;
					}else if(grid[i][j].equals("G")) {
						dfs(grid[i][j],i,j);
						G++;
					}else {
						dfs(grid[i][j],i,j);
						B++;
					}
				}
			}
		}
		int add = R + G + B;
		String ans = add + "";
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(clone[i][j].equals("G")) {
					grid[i][j] = "R";
				}else {
					grid[i][j] = clone[i][j];
				}
			}
		}
		R = 0;
		B = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!grid[i][j].equals("0")) {
					
					if(grid[i][j].equals("R")) {
						dfs("R", i,j);
						R++;
					}else {
						dfs(grid[i][j],i,j);
						B++;
					}
				}
			}
		}
		
		add = R + B;
		ans = ans + " " + add;
		return ans;
		
	}
	static void dfs(String a, int i, int j) {
		grid[i][j] = "0";
		for(int x = 0; x < 4; x++) {
			int nr = i+ dr[x];
			int nc= j + dc[x];
			if(nr < 0 || nr >= n || nc < 0 || nc >= n || !grid[nr][nc].equals(a)) {
				continue;
			}else {
				dfs(a,nr,nc);
			}
		}
		
	}
	
}
