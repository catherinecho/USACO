package Jan2019silver;
import java.util.*;
import java.io.*;
public class perimeter {
		static BufferedReader in;
		static PrintWriter out;
		static int[] areas = new int[1000];
		static int[] perimeters = new int[1000];
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader("perimeter.in"));
		out = new PrintWriter(new File("perimeter.out"));
		int lines = Integer.parseInt(in.readLine());
		char[][] grid = new char[lines][lines];
		int[][] blobInfo = new int[lines][lines];
		for(int r = 0; r < lines; r++) {
			String line = in.readLine();
			for(int c = 0; c < line.length(); c++) {
				grid[r][c] = line.charAt(c);
				blobInfo[r][c] = -1;
			}
		}
		for(int r = 0; r < lines; r++) {
			String s = "";
			for(int c = 0; c < lines; c++) {
				s += ""+grid[r][c];
			}
			System.out.println(s);
		}

		searchLargestIceCream(grid, blobInfo); // prints the 2 numbers: largest area and associated perimeter
		out.close();
		in.close();
	}
	

	public static void findPerimeters(int[][] blobInfo) {
		for(int r = 0; r < blobInfo.length; r++) {
			for(int c = 0; c < blobInfo[r].length; c++) {
				// find perimeters here
				int p = 4;
				int region = blobInfo[r][c];
				// do some cases, error checking
				if(region <0)
					continue;
				if(r+1 < blobInfo.length && blobInfo[r+1][c] != -1)
					p--;
				if(r-1 >= 0 && blobInfo[r-1][c] !=-1)
					p--;
				if( c +1 < blobInfo.length && blobInfo[r][c+1] !=-1)
					p--;
				if(c-1 >= 0 && blobInfo[r][c-1] != -1)
					p--;
				perimeters[region] +=p;
			}
		}
	}

	public static void searchLargestIceCream(char[][] grid, int[][] blobInfo) {
		int max = 0;
		int p = 0;
		int blob = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				areas[blob] = dfs(grid, blobInfo, i, j, blob);
				blob++;
			}
		}
		findPerimeters(blobInfo);
		for(int i = 0; i < areas.length; i++){
			if(max < areas[i]){
				max = areas[i];
				p = perimeters[i];
			}else if( max == areas[i]){
				if(p > perimeters[i])
					p = perimeters[i];
			}
		}
		out.println(max + " " + p);
		//System.out.println(Arrays.toString(perimeters));
	}
	public static int dfs(char[][] grid, int[][] blobInfo, int x, int y, int blob){
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == '.' || blobInfo[x][y] != -1)
			return 0;
		int area= 1;
		blobInfo[x][y] = blob;
		grid[x][y] = '.';
		area += dfs(grid,blobInfo,x,y+1, blob);
		area+=dfs(grid,blobInfo,x,y-1, blob);
		area+=dfs(grid,blobInfo,x+1, y, blob);
		area+=dfs(grid,blobInfo,x-1,y, blob);
		return area;
	}


		
	
}
