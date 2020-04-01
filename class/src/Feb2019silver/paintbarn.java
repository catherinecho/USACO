package Feb2019silver;
import java.util.*;
import java.io.*;
public class paintbarn {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("paintbarn.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] grid=  new int[1000][10000];
		for(int i = 0; i < n; i++){	
			st = new StringTokenizer(in.readLine());
			int x1 =  Integer.parseInt(st.nextToken());
			int y1 =  Integer.parseInt(st.nextToken());
			int x2 =  Integer.parseInt(st.nextToken());
			int y2 =  Integer.parseInt(st.nextToken());
			for(int j = x1; j < x2; j++) {
				grid[j][y1] = 1 + grid[j][y1];
				grid[j][y2]= grid[j][y2] -1;
			}
		}
		
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 1; j < grid.length; j++) {
				grid[i][j] = grid[i][j-1] + grid[i][j];
			}
		}
		int ans = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 1; j < grid.length; j++) {
				if(grid[i][j] == k) {ans++;}
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
}
