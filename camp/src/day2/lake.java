package day2;
import java.util.*;
public class lake {
	static Scanner in = new Scanner (System.in);
	static int length = in.nextInt();
	static int width = in.nextInt();
	static int coordinate = in.nextInt();
	static int[][] lake = new int[length+2][width+2];
	public static void main(String[] args) {
		String gap = in.nextLine();
		for(int i =0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				lake[i][j]= -1;
			}
		}
		for(int i = 0; i < coordinate; i++) {
			int k = in.nextInt()-1;
			int m = in.nextInt()-1;
			lake[k][m] = 0;
		}
		ArrayList<Integer> lakes = new ArrayList<Integer>();
		int id = 1;
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				if(lake[i][j] == 0) {
					lakes.add(floodfill(i,j,id));
					id++;
				}
			}
		}
		int max = lakes.get(0);
		for(int i = 1; i < lakes.size(); i++) {
			if (max < lakes.get(i)) {
				max = lakes.get(i);
			}
		}
		System.out.println(max);
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
		if(x>0 && lake[x-1][y] == id) {
			return true;
		}
		if(x< length&& lake[x+1][y] == id) {
			return true;
		}
		if(y>0 && lake[x][y-1] == id) {
			return true;
		}if(y< width-1 && lake[x][y+1]== id) {
			return true;
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
