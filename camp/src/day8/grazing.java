package day8;
import java.util.*;
public class grazing {
	static Scanner in = new Scanner(System.in);
	static int k = in.nextInt();
	static int ans= 0;
	static int[][] map = new int[5][5];
	public static void main(String[] args) {
		for(int i = 0 ; i < k; i++) {
			int a = in.nextInt() -1;
			int b = in.nextInt() -1;
			map[a][b] = 1;
		}
		
		dfs(0,0,1);
		
		System.out.println(ans);
	}
	public static void dfs(int x, int y, int path) {
		if(x == 4 && y == 4) {
			if(path == 25-k)
				ans++;
			return;
		}
		
		map[x][y] = 1;
		
		if(y+1  < 5 && map[x][y+1] != 1) dfs(x, y+1, path+1);
		if(x+1  < 5 && map[x+1][y] != 1) dfs(x+1, y, path+1);
		if(y-1 >= 0 && map[x][y-1] != 1) dfs(x, y-1, path+1);
		if(x-1 >= 0 && map[x-1][y] != 1) dfs(x-1, y, path+1);

		map[x][y] = 0;
	}
	
}
