package day15;

import java.util.*;

public class hannah{
	
	static Scanner in = new Scanner (System.in);
	static StringTokenizer st = new StringTokenizer(in.nextLine());
	static int H = Integer.parseInt(st.nextToken());
	static int W = Integer.parseInt(st.nextToken());
	static String[][] field = new String[W][H];
	static int[] dr = {0, 0, 1, -1, 1, 1, -1,-1};
	static int[] dc = {1, -1, 0, 0, 1, -1, 1,-1};
	public static void main(String[] args) {
		
		for(int i = 0; i < W; i++) {
			String line = in.nextLine();
			
			for(int j = 0; j < H; j++) {
				field[i][j]= line.substring(j, j+1);
			}
		}
		for(int i = 0; i < W; i++) {
			for(int j = 0; j < H; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		
		int max=  -1;
		String id = "1";
		for(int i = 0; i < W; i++) {
			for(int j = 0; j < H; j++) {
				if(field[i][j].equals(".")) {
					max = Math.max(max, floodfill(i,j, id));
					id = Integer.toString(Integer.parseInt(id) + 1 );
					
				}
				
			}
		}
		System.out.println(max);
		
	}
	
	public static int floodfill(int x, int y, String id) {
		
		int c = 1;
		field[x][y] = id;
		Queue<feed> q = new LinkedList<feed>();
		while(!q.isEmpty()) {
			feed cur = q.remove();
			for(int i =0; i < 8; i++) {
				int nr = cur.row +dr[i];
				int nc = cur.col + dc[i];
				if(neighbor(nr,nc) && field[nr][nc].equals(".")) {
					
					field[nr][nc] = id;
					q.add(new feed(nr,nc));
					c++;
				}
			}
		}
		
		return c;
		
	}
	
	public static boolean neighbor(int x, int y) {
		
		if(x < 0 || y < 0 || x >= W|| y >= H) {
			return false;
		}
		return true;
		
	}
	
	public static boolean check (int x, int y) {
		
		if(x>= 0 && x< H && y >=0 && y< W) {
			return true;
		}
		return false;
		
	}

}
class feed{
	int row;
	int col;

	public feed(int r, int c) {
		this.row = r;
		this.col = c;
	}
}
