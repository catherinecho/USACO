package exam3;
import java.util.*;
public class mazepath2 {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int[][] grid = new int[n][n];
	static String ans = "";
	static int end = 0;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1, -1, 0,0};
	public static void main(String[] args) {
		for(int i = 0;i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = in.nextInt();
				if(i == n-1 && j == n-1) {
					end = grid[i][j];
				}
			}
		}
		for(int i = 0; i< n; i++) {
			for(int j = 0; j < n; j++ ) {
				
				
			}
		}
		path(0, 0);
		for(int i = 0; i < ans.length(); i++) {
			System.out.println(ans.charAt(i));
		}

	}
	public static void path(int x, int y) {
		
		Queue <m> q = new LinkedList<m>();
		q.add(new m(x, y));
		int a = grid[x][y];
		grid[x][y] = 0;
		while(!q.isEmpty()) {
			m cur = q.remove();
			if(grid[cur.x][cur.y] == end) {
				return;
			}
			for(int i = 0; i < 4; i++) {
				
				int nr = cur.x+ dr[i];
				int nc = cur.y + dc[i];
				if(valid(nr,nc) && gcd(a, grid[nr][nc]) == 1 ) {
					
					System.out.println(grid[nr][nc]);
					
					if(dr[i] == 0 && dc[i] == 1) {
						ans += "L";
					}else if(dr[i] == -1 && dc[i] == 0) {
						ans+="U";
					}else if (dr[i] == 1 && dc[i] == 0) {
						ans+="D";
					}else {
						ans+= "R";
					}
					a= grid[nr][nc];
					grid[nr][nc] = 0;
					q.add(new m(nr,nc));
					break;
					
					
				}
			}
			
		}
		
		
	}
	public static int gcd(int x, int y) {
		if(y == 0) {
			return x;
		}
		return gcd(y, x%y);
	}
	public static boolean valid(int nr, int nc) {
		if(nr <0 || nc < 0 || nr >= n || nc >= n) {
			return false;
		}else if(grid[nr][nc] == 0) {
			return false;
		}
		return true;
	}
}
class m{
	int x;
	int y;
	public m(int X, int Y) {
		this.x = X;
		this.y = Y;
	}
}