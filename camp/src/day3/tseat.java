package day3;
import java.util.*;

public class tseat {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int width = in.nextInt();
		int length = in.nextInt();
		int[][] grid = new int[length][width];
		ArrayList<seats> list = new ArrayList<seats>();
		int pr = 0;
		int pc = (width)/2;
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				list.add(new seats(i+1,j+1,dist(i+1,j+1, pr+1,pc + 1)));
				//System.out.println((i+ 1)+ " "+ (j+1) + " "+ dist(i + 1,j + 1, pr+1,pc + 1));
			}
		}
		Collections.sort(list);
		
		int id = 1;
		for(int  i= 0; i < list.size(); i++) {
				grid[list.get(i).getRow() -1 ][list.get(i).getCol()- 1] = id;
				id++;
		}
		for(int i = length-1; i >= 0; i--) {
			for(int j = 0; j< width; j++) {
				System.out.print(grid[i][j] +" ");
			}
			System.out.println();
		}
	}

	public static int dist(int r, int c, int pr, int pc) {
		int distance = 0;
		distance = (r-pr)*(r-pr) + (c- pc)*(c-pc);
		return distance;
	}

}

class seats implements Comparable<seats>{
	private int row;
	private int col;
	private int distance;
	public int compareTo(seats m) {
		if(this.distance == m.distance) {
			if(this.row != m.row) {
				return this.row-m.row;
			}else {
				return this.col - m.col;
			}
		} else {
			return this.distance-m.distance;
		}

	}
	public seats(int r, int c, int d) {
		this.row = r;
		this.col = c;
		this.distance = d;
	}
	public int getRow() {return row;}
	public int getCol() {return col;}
	public int getDistance() {return distance;}
	
}

