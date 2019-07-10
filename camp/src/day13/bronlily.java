package day13;
import java.util.*;
public class bronlily {
	static Scanner in = new Scanner(System.in);
	static int x = in.nextInt();
	static int y = in.nextInt();
	static int m1 = in.nextInt();
	static int m2 = in.nextInt();
	static int[][] grid = new int[x][y];
	static Queue<cows> q = new LinkedList<cows>();
	static int[] dr = {-m2,-m1,m1,m2,m2,m1,-m1,-m2};
	static int[] dc = {m1,m2,m2,m1,-m1,-m2,-m2,-m1};
 	public static void main(String[] args) {
		int rk = 0;
		int ch = 0;
		int rh = 0;
		int ck = 0;
		in.nextLine();
		for(int i= 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				grid[i][j] = in.nextInt();
				if(grid[i][j] == 3) {
					rk = i;
					ck= j;
				}
				if(grid[i][j] == 4) {
					rh = i;
					ch= j;
				}
			}
		}
		q.add(new cows(rk, ck, 0));
		grid[rk][ck] = 0;
		while(!q.isEmpty()) {
			cows cur = q.remove();
			if(cur.row == rh && cur.col == ch) {
				System.out.println(cur.steps);
				break;
			}
			for(int i = 0; i < 8; i++) {
				int nr = cur.row+dr[i];
				int nc = cur.col + dc[i];
				if(nr>=0 && nr<x && nc>=0 && nc<y && grid[nr][nc] != 2&& grid[nr][nc] != 0 ) {
					q.add(new cows(nr, nc, cur.steps + 1));
					if (nr != rh || nc != ch) {
						grid[nr][nc] = 0;
					}
				}
			}
		}
		
	}
}
class cows{
	int row;
	int col;
	int steps;
	public cows(int r, int c, int s) {
		this.row = r; 
		this.col = c;
		this.steps = s;
	}
}