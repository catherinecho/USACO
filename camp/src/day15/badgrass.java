package day15;
import java.util.*;
public class badgrass {
	static Scanner in = new Scanner(System.in);
	static StringTokenizer st = new StringTokenizer(in.nextLine());
	static int n = Integer.parseInt(st.nextToken());
	static int m = Integer.parseInt(st.nextToken());
	static int[][] grid=  new int[n][m];
	static int[] dr = {0, 0, 1, -1, 1, 1, -1,-1};
	static int[] dc = {1, -1, 0, 0, 1, -1, 1,-1};
	public static void main(String[] args) {
		for(int i = 0;i < n; i++) {
			for(int j = 0; j <m; j++) {
				int a = in.nextInt();
				if(a == 0) {
					grid[i][j] = -1;
				}else {
					grid[i][j] = 0;
				}
			}
		}
		
		int id = 1;
		int max = -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 0) {
					max = Math.max(max, floodfill(i,j,id));
					id++;
				}
			}
		}
		
		System.out.println(id-1);
				
	}
	public static int floodfill(int x, int y, int id) {
		int c = 1;
		grid[x][y] = id;
		Queue<grass> q = new LinkedList<grass>();
		q.add(new grass(x,y));
		while(!q.isEmpty()) {
			grass cur = q.remove();
			for(int i =0; i < 8; i++) {
				int nr = cur.row +dr[i];
				int nc = cur.col + dc[i];
				if(inbound(nr,nc) && grid[nr][nc] == 0) {
					grid[nr][nc] = id;
					q.add(new grass(nr,nc));
					c++;
				}
			}
		}
		return c;
	}
	public static boolean inbound(int nr, int nc) {
		if(nr <0 || nc < 0 || nr >= n || nc >= m) {
			return false;
		}
		return true;
	}
	
}
class grass{
	int row;
	int col;

	public grass(int r, int c) {
		this.row = r;
		this.col = c;
	}
}
