package day15;
import java.util.*;
public class space {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int[][] grid=  new int[n][n];
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	public static void main(String[] args) {
		in.nextLine();
		for(int i = 0;i < n; i++) {
			String line= in.nextLine();
			for(int j = 0; j < n; j++) {
				if(line.charAt(j) == '.') {
					grid[i][j] = -1;
				}else {
					grid[i][j] = 0;
				}
			}
		}
		int id = 1;
		int max = -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 0) {
					max = Math.max(max, floodfill(i,j,id));
					id++;
				}
			}
		}
		System.out.println(id-1);
		/*
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		*/
		
				
	}
	public static int floodfill(int x, int y, int id) {
		int c = 1;
		grid[x][y] = id;
		Queue<cspace> q = new LinkedList<cspace>();
		q.add(new cspace(x,y));
		while(!q.isEmpty()) {
			cspace cur = q.remove();
			for(int i =0; i < 4; i++) {
				int nr = cur.row +dr[i];
				int nc = cur.col + dc[i];
				if(inbound(nr,nc) && grid[nr][nc] == 0) {
					grid[nr][nc] = id;
					q.add(new cspace(nr,nc));
					c++;
				}
			}
		}
		return c;
	}
	public static boolean inbound(int nr, int nc) {
		if(nr <0 || nc < 0 || nr >= n || nc >= n) {
			return false;
		}
		return true;
	}
	
}
class cspace{
	int row;
	int col;

	public cspace(int r, int c) {
		this.row = r;
		this.col = c;
	}
}
