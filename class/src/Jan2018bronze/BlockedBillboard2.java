package Jan2018bronze;
import java.util.*;
import java.io.*;
public class BlockedBillboard2 {
	static Scanner in;
	static PrintWriter out;
	static int bottomL1x, bottomL1y , topR1x, topR1y, bottomL2x, bottomL2y , topR2x, topR2y;
	static int[][] grid;
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("billboard.in"));
		out = new PrintWriter(new File("billboard.out"));
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
	private static void init () {
		
		//hi
		bottomL1x = in.nextInt();
		bottomL1y = in.nextInt();
		topR1x= in.nextInt();
		topR1y= in.nextInt();
		bottomL2x = in.nextInt();
		bottomL2y = in.nextInt();
		topR2x = in.nextInt();
		topR2y = in.nextInt();
		grid = new int[2001][2001];
		for(int i = bottomL1x; i < topR1x; i++) {
			for(int j = bottomL1y; j < topR1y; j++) {
				grid[i+1000][j+1000] = 1;
			}
		}
		for(int i = bottomL2x; i < topR2x; i++) {
			for(int j = bottomL2y; j < topR2y; j++) {
				grid[i+1000][j+1000] = 0;
			}
		}
	}
	private static int solve () {
		boolean b = false;
		int maxX = -1000;
		int maxY = -1000;
		int minX = 2000;
		int minY = 2000;
		for(int i = 0; i <= 2000; i++) {
			for(int j = 0; j <= 2000; j++) {
				if(grid[i][j] == 1) {
					b = true;
					 maxX = Math.max(i, maxX);
					 maxY = Math.max(j, maxY);
					 minX = Math.min(i, minX);
					 minY = Math.min(j, minY);
				}
			}
		}
		if( b == false) {
			return 0;
		}
		/*
		for(int i = 0; i < 1500; i++) {
			for(int j = 0; j < 1500; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(grid[minX + 1][minY + 1]);
		*/
		//System.out.println((maxX-1000+1) + " " + (maxY-1000 +1));
		
		return ((maxX-1000 + 1 ) - (minX-1000) ) * ((maxY-1000+1 ) - (minY-1000));
		
	}
}
