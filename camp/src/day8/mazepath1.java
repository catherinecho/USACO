package day8;
import java.util.*;
public class mazepath1 {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int[][] map = new int[n][n];
	static int ans = 0;
	public static void main(String[] args) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n;j++) {
				int a = in.nextInt();
				map[i][j] = a;
			}
		}
		dfs(0,0);
		System.out.println(ans);
		
	}
	public static void dfs(int x, int y) {
		if(map[x][y] == 1) {
			return;
		}
		if(x == n-1 && y == n-1) {
			ans++;
			return;
		}
		
		if(y+1 < n){
			dfs(x, y+1);
		}
		if(x+1 < n){
			dfs(x+1, y);
		}
	}
}
