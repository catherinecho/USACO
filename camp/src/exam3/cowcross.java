package exam3;
import java.util.*;
public class cowcross {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int k = in.nextInt();
	static int r = in.nextInt();
	static pair[] roads = new pair[r];
	static c[]  cows=  new c[k];
	static int[][] grid= new int[n][n];
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1, -1, 0,0};
	static pair[] cows2 = new pair[k*k - k];
	static ArrayList<pair> cows3 = new ArrayList<pair>();
	static int distant= 0;
	public static void main(String[] args) {
		for(int i = 0; i < r; i++ ) {
			roads[i] = new pair(in.nextInt()-1, in.nextInt()-1,in.nextInt()-1,in.nextInt()-1);
		}
		for(int i = 0; i < k; i++ ) {
			cows[i] = new c(in.nextInt()-1, in.nextInt()-1);
			grid[cows[i].x][cows[i].y] = 1;
		}
		int ans = k;
		int a = 0;
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < k; j++) {
				if(i != j) {
					
					cows2[a] = new pair(cows[i].x, cows[i].y, cows[j].x, cows[j].y);
					a++;
				}
				
			}
		}
		
		
		int o = 1;
		int e = 0;
		while(o != k) {
			for(int j= e; j < k - o; j++) {
				cows3.add(new pair(cows2[j].r1, cows2[j].c1, cows2[j].r2, cows2[j].c2));
			}
			o++;
			e+=o;
		}
		
		System.out.println(cows3.size());
		for(int i = 0; i < cows3.size(); i++) {
			System.out.println(cows3.get(i).r1 + " " +cows3.get(i).c1 + "     " + cows3.get(i).r2 + " " + cows3.get(i).c2);
		}
		
		for(int i = 0; i < cows2.length; i++) {
			if(cross(cows2[i].r1 ,cows2[i].c1 , cows2[i].r2,cows2[i].c2) == 0) {
				distant++;
			}
			
		}
		System.out.println(distant / 2);
		
	}
	public static int cross(int x, int y, int r, int c){
		int f= 0;
		Queue<c> q= new LinkedList<c>();
		q.add(new c(x, y));
		grid[x][y] = -1;
		while(!q.isEmpty()) {
			c cur = q.remove();
			if(cur.x== r && cur.y == c) {
				return f;
			}
			for(int i = 0; i < 4; i++) {
				int nr= cur.x + dr[i];
				int nc = cur.y + dc[i];
				if(valid(nr,nc, cur)) {
					f++;
					q.add(new c(nr,nc));
					//System.out.println(x + " "+ y + " "+ r+ " "+ c);
					grid[nr][nc] = -1;
					break;
				}
			}
		}
		return f;
		
	}
	public static boolean valid(int nr, int nc, c cur) {
		if(nr <0 || nc < 0 || nr >= n || nc >= n) {
			return false;
		}else if(grid[nr][nc] == -1) {
			return false;
		}
		for(int j= 0; j < r; j++) {
			if(cur.x == roads[j].r1 && cur.y == roads[j].c1 && nr == roads[j].r2 && nc == roads[j].c2) {
				return false;
			}
		}
		
		return true;
	}
}
class pair{
	int r1;
	int c1;
	int r2;
	int c2;
	public pair(int R, int C, int r, int c) {
		this.r1= R;
		this.c1 = C;
		this.r2 = r;
		this.c2 = c;
	}
}
class c{
	int x;
	int y;
	public c(int X,int Y) {
		this.x = X;
		this.y = Y;
	}
}
