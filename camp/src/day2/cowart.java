package day2;

import java.util.Scanner;

public class cowart {
	static Scanner in = new Scanner (System.in);
	static int length = in.nextInt();
	static int width = length;
	static int[][] lake = new int[length+2][width+2];
	public static void main(String[] args) {
		String gap = in.nextLine();
		for(int i =0; i < length; i++) {
			String line = in.nextLine();
			for(int j = 0; j < width; j++) {
				if(line.charAt(j) == 'R') {
					lake[i][j] = -2;
				}else if(line.charAt(j) == 'B'){
					lake[i][j] = -1;
				}else {
					lake[i][j]= -3;
				}
			}
		}
		int[][] lake2 = new int[length+2][width+2];
		for(int i = 0; i < lake.length; i++) {
			for(int j = 0; j < lake.length; j++) {
				lake2[i][j] = lake[i][j];
			}
		}
		
		for(int x = 0; x < 2; x++) {
			for(int i = 0; i < lake.length; i++) {
				for(int j = 0; j < lake.length; j++) {
					lake[i][j] = lake2[i][j];
				}
			}
			
			if(x ==1) {
				for(int i = 0; i < length; i++ ) {
					for(int j = 0; j < width; j++) {
						if(lake[i][j] == -3) {
							lake[i][j] = -2;
						}
					}
				}
			}
			
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < width; j++) {
					System.out.print(lake[i][j]);
				}
				System.out.println();
			}
			int count = 0;
			int id = 1;
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < width; j++) {
					if(lake[i][j] == -1) {
						floodfill(i,j,-1, id++);
						count++;
					}else if(lake[i][j] == -2) {
						floodfill(i,j,-2, id++);
						count++;
					}else if(lake[i][j] == -3) {
						floodfill(i,j,-3,id++);
						count++;
					}
				}
			}
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < width; j++) {
					System.out.print(lake[i][j]);
				}
				System.out.println();
			}
			System.out.print(id-1);
			if(x == 0) {
				System.out.print(" ");
			}
			
		}
	}
	public static int floodfill(int x, int y, int curC, int id) {
		int c = 1;
		lake[x][y] = id;
		boolean change = true;
		while(change== true) {
			change = false;
			for(int i = 0; i <length; i++) {
				for(int j = 0; j < width; j++) {
					if(lake[i][j] == curC && neighbor(i,j,id)) {
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
