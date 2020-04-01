package hspc2019;
import java.util.*;
import java.io.*;
public class bobalice {
	static int[][] grid;
	static int n;
	static int m;
	static int[] dr = {1,-1,0,0};
	static int[] dc= {0,0,-1,1};
	static int ans = 0;
	static int aliceX;
	static int aliceY;
	static Queue<coordinate> q = new LinkedList<coordinate>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = Integer.parseInt(in.nextLine());
		m = Integer.parseInt(in.nextLine());
		grid = new int[n][m];
		for(int i = 0; i < n; i++) {
			StringTokenizer st= new StringTokenizer(in.nextLine());
			for(int j = 0;j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		aliceX = Integer.parseInt(in.nextLine());
		aliceY =Integer.parseInt(in.nextLine());
		q.add(new coordinate (0,0));
		bfs();
		
	}
	public static void bfs() {
		boolean check = false;
		while(!q.isEmpty()) {
			coordinate curr = q.remove();
			
			if(grid[curr.x][curr.y] == 0 ) {
				ans++;
			}
			if(grid[curr.x][curr.y] == 2) {
				check = true;
				ans++;
			}
			if(curr.x == aliceX && curr.y == aliceY) {
				if(check == true) {
					System.out.println(ans);
					return;
				}else {
					break;
				}
			}
			grid[curr.x][curr.y] = -1;
			for(int i = 0; i < 4; i++) {
				int nr = curr.x + dr[i];
				int nc = curr.y+dc[i];
				if(valid (nr, nc) && grid[nr][nc] != 1 && grid[nr][nc] != -1) {
					q.add(new coordinate(nr,nc));
					System.out.println(nr + " " + nc);
				}
			}
		}
		System.out.println(-1);
	}
	public static boolean valid(int x, int y) {
		if(x >= 0 && x < n && y >=0 && y < m) {
			return true;
		}
		return false;
	}
	static class coordinate{
		int x;
		int y;
		public coordinate(int X, int Y) {
			x = X;
			y = Y;
		}
	}
}
