package hspc2019;
import java.util.*;
import java.io.*;
public class strokesRequired {
	static char[][] grid;
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		n = Integer.parseInt(in.nextLine());
		String line = in.nextLine();
		m = line.length();
		grid = new char[n][m];
		for(int i = 0; i < n; i++) {
			if(i !=0) {
				line = in.nextLine();
			}
			for(int j = 0; j <m; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		int ans = 0;
		for(int i = 0; i  < n; i++) {
			for(int j = 0;j  < m; j++) {
				if(grid[i][j] != '0') {
					dfs(grid[i][j], i, j);
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}
	public static void dfs(char id, int i, int j ) {
		if(grid[i][j] == '0' || grid[i][j] != id) {
			return;
		}
		grid[i][j] = '0';
		for(int x = 0; x < 4; x++) {
			int currx = i + dr[x];
			int curry = j + dc[x];
			if(valid(currx, curry)) {
				dfs(id, currx, curry);
			}
		}
	}
	public static boolean valid(int x, int y) {
		if(x < n  && x >=0 && y < m && y >= 0) {
			return true;
		}
		return false;
	}
}
