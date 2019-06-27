package day2;
import java.util.*;
public class lakecount {
	static Scanner in = new Scanner (System.in);
	static int length = in.nextInt();
	static int width = in.nextInt();
	static int[][] lake = new int[length+2][width+2];
	public static void main(String[] args) {
		String gap = in.nextLine();

		for(int i =0; i < length; i++) {
			String line = in.nextLine();
			for(int j = 0; j < width; j++) {
				if(line.charAt(j) == 'W') {
					lake[i][j] = 0;
				}else {
					lake[i][j] = -1;
				}
			}
		}
		int id = 1;
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				if(lake[i][j] == 0) {
					floodfill(i,j,id);
					id++;
				}
			}
		}
		System.out.println(id-1);
		
		
	}
	public static int floodfill(int x, int y, int id) {
		int c = 1;
		lake[x][y] = id;
		boolean change = true;
		while(change== true) {
			change = false;
			for(int i = 0; i <length; i++) {
				for(int j = 0; j < width; j++) {
					if(lake[i][j] == 0 && neighbor(i,j,id)) {
						lake[i][j] = id;
						c++;
						change = true;
					}
				}
			}
		}
		return c;
	}
	public static boolean neighbor(int x, int y, int id) {
		for(int i = -1; i <=1 ; i++) {
			for(int j = -1; j <= 1; j++) {
				if(i==0 && j==0) {
					continue;
				}
				if(check(x+i,y+j) && lake[x+i][y+j] == id) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean check (int x, int y) {
		if(x>= 0 && x< length && y >=0 && y< width) {
			return true;
		}
		return false;
	}
}
