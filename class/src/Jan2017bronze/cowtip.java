package Jan2017bronze;
import java.util.*;
import java.io.*;
public class cowtip {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static boolean[][] grid;
	public static void main(String[] args)throws IOException {
		in = new Scanner(new File("cowtip.in"));
		out = new PrintWriter(new File("cowtip.out"));
		try {
			init();
			out.println(solve());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		in.close();
		out.close();
	}
	public static void init() {
		n = in.nextInt();
		grid = new boolean[n][n];
		in.nextLine();
		for(int i = 0; i < n; i++) {
			String line = in.nextLine();
			for(int j = 0; j < n; j++) {
				if(line.charAt(j) == '0') {
					grid[i][j] = false;
				}else {
					grid[i][j] = true;
				}
				
			}
		}
		
	}
	public static int solve() {
		int ans = 0;
		for(int i= n-1; i >=0; i--) {
			for(int j = n-1; j >=0 ; j--) {
				if(grid[i][j] == true) {
					for(int x =0 ; x <= i; x++) {
						for(int y = 0; y <= j; y++) {
							grid[x][y] = !grid[x][y];
						}
					}
					ans++;
				}
				
			}
		}
		return ans;
	}
}
