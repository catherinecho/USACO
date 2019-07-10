package day13;
import java.util.*;
public class kcow {
	static Scanner in = new Scanner(System.in);
	static int x = in.nextInt();
	static int y = in.nextInt();
	static char[][] grid = new char[y][x];
	static Queue<cow> q = new LinkedList<cow>();
	static int[] dr = {-2, -1, 1,2,2,1,-1,-2};
	static int[] dc = {1,2,2,1,-1,-2,-2,-1};
 	public static void main(String[] args) {
		int rk = 0;
		int rc = 0;
		int rh = 0;
		int ch = 0;
		in.nextLine();
		for(int i= 0; i < y; i++) {
			String line = in.nextLine();
			for(int j = 0; j < x; j++) {
				grid[i][j] = line.charAt(j);
				if(line.charAt(j) == 'K') {
					rk = i;
					rc= j;
				}
				if(line.charAt(j) == 'H') {
					rh = i;
					ch= j;
				}
			}
		}
		q.add(new cow(rk, rc, 0));
		grid[rk][rc] = '*';
		while(!q.isEmpty()) {
			cow cur = q.remove();
			if(cur.row == rh && cur.col == ch) {
				System.out.println(cur.steps);
				break;
			}
			for(int i = 0; i < 8; i++) {
				int nr = cur.row+dr[i];
				int nc = cur.col + dc[i];
				if(valid(nr,nc)) {
					q.add(new cow(nr, nc, cur.steps + 1));
					grid[nr][nc] = '*';
				}
			}
		}
		
		
	}
 	public static boolean valid(int r, int c) {
 		if(r>=0 && r<y && c>=0 && c<x && grid[r][c] != '*') {
 			return true;
 		}
 		return false;
 	}
}
class cow{
	int row;
	int col;
	int steps;
	public cow(int r, int c, int s) {
		this.row = r; 
		this.col = c;
		this.steps = s;
	}
}