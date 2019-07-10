package day13;
import java.util.*;
public class metor {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int[][] grid = new int[305][305];
	static int[] power = new int[n];
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static Queue<cows1> q = new LinkedList<cows1>();
	public static void main(String[] args) {
		int safe = Integer.MAX_VALUE;
		for(int i = 0; i <= 301; i++) {
			for(int j = 0; j <= 301; j++) {
				grid[i][j] = safe;
			}
		}
		for(int i = 0; i < n; i++) {
			int r = in.nextInt();
			int c = in.nextInt();
			int t = in.nextInt();
			grid[r][c]= Math.min(grid[r][c], t);
			for(int j =0;j < 4; j++) {
				int nr = r + dr[j];
				int nc = c + dc[j];
				if(valid(nr,nc)) {
					grid[nr][nc] = Math.min(grid[nr][nc], t);
				}
			}
		}
		q.add(new cows1(0, 0, 0));
		if(grid[0][0] == safe) {
			System.out.println(0);
			return;
		}
		grid[0][0] = 0;
		while(!q.isEmpty()) {
			cows1 cur = q.remove();
			if(grid[cur.row][cur.col] == safe) {
				System.out.println(cur.steps);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int nr = cur.row + dr[i];
				int nc = cur.col + dc[i];
				if(nr >= 0 && nc >= 0 && cur.steps +1 < grid[nr][nc]) {
					q.add(new cows1(nr, nc, cur.steps+1));
					if(grid[nr][nc] != safe) {
						grid[nr][nc] = 0;
					}
					
				}
			}
		}
		
		System.out.println(-1);
	}
	public static boolean valid(int nr, int nc) {
		if(nr <0 || nc < 0) {
			return false;
		}
		return true;
	}
}
class cows1{
	int row;
	int col;
	int steps;
	public cows1(int r, int c, int s) {
		this.row = r; 
		this.col = c;
		this.steps = s;
	}
}