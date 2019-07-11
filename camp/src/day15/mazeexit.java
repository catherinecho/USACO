package day15;
import java.util.*;
public class mazeexit {
	static Scanner in = new Scanner(System.in);
	static StringTokenizer st = new StringTokenizer(in.nextLine());
	static int m = Integer.parseInt(st.nextToken());
	static int n =Integer.parseInt(st.nextToken());
	static int x = Integer.parseInt(st.nextToken()) -1;
	static int y = Integer.parseInt(st.nextToken())-1 ;
	static int[][] grid = new int[m][n];
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static int exits = 0;
	static ArrayList<cow> e = new ArrayList<cow>();
	static 	Queue<cow> q  = new LinkedList<cow>();
	public static void main(String[] args) {
		for(int i = 0; i < m; i++) {
			String line= in.nextLine();
			for(int j = 0;j < n; j++) {
				grid[i][j] = Integer.parseInt(line.substring(j, j+1));
				if((i ==0 || j==0 || i == m-1 || j == n-1) && grid[i][j] == 0) {
					exits++;
					e.add(new cow(i,j));
				}
				if(grid[i][j] == 0)
					grid[i][j] = -2;
				else
					grid[i][j] = -1;
			}
		}
		
		floodfill(x, y, -2, 0);
		
		
		
		int min = Integer.MAX_VALUE;
		int ansx = 0;
		int ansy = 0;
		for(int i = 0; i < e.size(); i++) {
			if(grid[e.get(i).row][e.get(i).col] != -1){
				if(grid[e.get(i).row][e.get(i).col] < min) {
					min = grid[e.get(i).row][e.get(i).col];
					ansx = e.get(i).row;
					ansy = e.get(i).col;
				}
			}
		}
		
		System.out.println(ansx+1 + " "+ (ansy+1));
		System.out.println(grid[ansx][ansy]);
		System.out.println(exits);

	}
	public static void floodfill(int r, int c, int prev, int p) {
		grid[r][c] = p;
		q.add(new cow(r,c));
		while(!q.isEmpty()) {
			cow cur = q.remove();	
			for(int i = 0; i < 4; i++) {
				int nr = cur.row + dr[i];
				int nc = cur.col + dc[i];
				if(inbound(nr, nc) && grid[nr][nc] == prev) {
					grid[nr][nc] = grid[cur.row][cur.col] + 1;
					q.add(new cow(nr,nc));
				}
			}
		}
	}
	public static boolean inbound(int nr, int nc) {
		if(nr <0 || nc < 0 || nr >= m || nc >= n) {
			return false;
		}
		return true;
	}
}
class cow{
	int row;
	int col;

	public cow(int r, int c) {
		this.row = r;
		this.col = c;
	}
}