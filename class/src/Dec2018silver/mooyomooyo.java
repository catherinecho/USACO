package Dec2018silver;
import java.util.*;
import java.io.*;
public class mooyomooyo {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("mooyomooyo.in"));
		PrintWriter out=  new PrintWriter(new File ("mooyomooyo.out"));
		int N = in.nextInt();
		int K = in.nextInt();
		int[][] arr = new int[N][10];
		for(int r = 0; r < N; r++) {
			String s = in.next();
			for(int c = 0; c < 10; c++) {
				arr[r][c] = s.charAt(c) - '0';
			}
		}
		while(true) {
			if(iterate(arr, K, N) == false) {
				break;
			}
		}
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < 10; c++) {
				out.print(arr[r][c]);
			}
			out.println();
		}
		in.close();
		out.close();
	}
	/*
	r will always try to point to the first nonzero in that column
	bottom will increment up (going up) every time r finds a nonzero
	so that you can copy arr[r][j] to arr[bottom][j] then set arr[r][j] to be 0

	r will go up until it finds nonzero
	check to see if r is >= 0, if so, then you replace arr[bottom][j] with arr[r][j] then r-- and bottom--
	bottom will go up until it finds zero, mostly to handle the case where 0 is sandwiched between nonzeroes
	*/
	static int[][] regions = new int[100][10]; // first region is 1, second region is 2, etc
	static int[] regionSizes = new int[1001]; // regionSizes[i] represents the size of region i

	public static void fallDown(int[][] arr) {
	
		for(int j = 0; j < 10; j++){
			int bottom = arr.length - 1;
			for(int r = arr.length-1; r >= 0;){
				while(r >= 0 && arr[r][j] == 0){
					r--;
				}
				if(r >= 0) {
					arr[bottom][j] = arr[r][j];
					bottom--;
					r--;
				}
			}
			// cleanup: fill bottom all the way to row 0 at the end with zeroes
			while(bottom >= 0) {
				arr[bottom][j] = 0;
				bottom--;
			}
		}
		
	}

	public static boolean iterate(int[][] arr, int k, int n) {
		int region = 1;
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[r].length; c++) {
				regions[r][c] = 0;
			}
		}
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < 10; j++){
				regionSizes[region] = dfs(i,j,arr, arr[i][j], region);
				region++;
			}
		}
		boolean b = false;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 10; j++){
				if(regionSizes[regions[i][j]]>= k){
					arr[i][j] = 0;
					b = true;
				}
			}
		}
		fallDown(arr);
		return b;
	}
	public static int dfs( int i, int j,int[][] arr, int id, int region){
		if(arr[i][j] == 0 || arr[i][j] != id || regions[i][j] == region){
			return 0;
		}
		int size = 1;
		regions[i][j] = region; // the way to mark something as visited
		if(j +1 < 10){
			size+=dfs(i,j+1, arr, id, region);	
		}
		if(i+1 < arr.length)
			size+=dfs(i+1,j, arr, id, region);
		if(i-1>=0)
			size+=dfs(i-1,j,arr,id, region);
		if(j-1 >=0)
			size+=dfs(i, j-1, arr,id, region);
		return size;
	}


}
/*

public class mooyomooyo {
	static Scanner in;
	static PrintWriter out;
	static int n, k;
	static int[][] grid;
	static int[][] clone;
	static int[] dr = {0, 1, -1, 0};
	static int[] dc = {1, 0, 0, -1};
	public static void main(String[] args)throws IOException {
		in = new Scanner(new File("mooyomooyo.in"));
		out = new PrintWriter(new File("mooyomooyo.out"));
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
		String temp  = in.nextLine();
		n = Integer.parseInt(temp.substring(0,1));
		k = Integer.parseInt(temp.substring(2));
		grid = new int[n][10];
		for(int i = 0; i < n; i++) {
			String line = in.nextLine();
			for(int j = 0; j < 10; j++) {
				grid[i][j] = Integer.parseInt(line.substring(j,j+1));
				clone[i][j] = Integer.parseInt(line.substring(j,j+1));
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	public static int solve() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 10; j++) {
				if(grid[i][j] != 0) {
					floodfill(i,j, grid[i][j]);
				}
				
			}
		}
		//print grid
	}
	static int size = 0;
	public static void floodfill(int x, int y, int num) {
		if(grid[x][y] != num) {
			if(size <= k) {
				grid = clone;
			}else {
				clone = grid;
			}
			return;
		}
		Queue<moo> q = new LinkedList<moo>();
		q.add(new moo(x,y));
		while(!q.isEmpty()) {
			moo cur = q.remove();
			for(int i =0; i < 4; i++) {
				int nr = cur.row +dr[i];
				int nc = cur.col + dc[i];
				if(inbound(nr,nc) && grid[nr][nc] == num) {
					grid[nr][nc] = 0;
					q.add(new moo(nr,nc));
				}
			}
		}
	}
	public static boolean inbound(int nr, int nc) {
		if(nr <0 || nc < 0 || nr >= n || nc >= 10) {
			return false;
		}
		return true;
	}
}
class moo{
	int row;
	int col;

	public moo(int r, int c) {
		this.row = r;
		this.col = c;
	}
}
*/
