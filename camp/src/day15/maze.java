package day15;

import java.util.*;
class Coordinates{
	int x;
	int y;
	public Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class maze {
	static int[][] Grid;
	static int N,M,min;
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		min = Integer.MAX_VALUE;
		Grid = new int[N][M];
		int [] dr = {1,-1,0, 0};
		int [] dc = {0, 0,1,-1};
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++){
			String x = sc.nextLine();
			for (int j = 0; j < M; j++){
				Grid[i][j] = Character.getNumericValue(x.charAt(j));
			}
		}
		Grid[A-1][B-1] = 'S';
		floodfill(A-1,B-1,0,1,dr,dc);
		for(int i = 0;i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(Grid[i][j]);
			}
			System.out.println();
		}
		int numofexits = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++){
			if (Grid[i][0] > 1){
				numofexits++;
				min = Math.min(Grid[i][0],min);
			}
			if (Grid[i][M-1] > 1){
				numofexits++;
				min = Math.min(Grid[i][M-1],min);
			}
			if (Grid[i][0] == min){
				x = i+1;
				y = 1;
			}
			if (Grid[i][M-1] == min){
				x = i+1;
				y = M;
			}
		}
		for (int i = 0; i < M; i++){
			if (Grid[0][i] > 1){
				min = Math.min(Grid[0][i],min);
				numofexits++;
			}
			if (Grid[N-1][i] > 1){
				numofexits++;
				min = Math.min(Grid[N-1][i],min);
			}
			if (Grid[0][i] == min){
				x = 1;
				y = i+1;
			}
			if (Grid[N-1][i] == min) {
				x = N;
				y = i + 1;
			}
		}

		System.out.println(x + " " + y);
		System.out.println(min-1);
		System.out.println(numofexits);
	}
	public static void floodfill(int r, int c, int prev, int p, int [] dr, int [] dc){
		Grid[r][c] = p;
		Queue<Coordinates> q = new LinkedList<Coordinates>();
		q.add(new Coordinates(r,c));

		while(!q.isEmpty()){
			Coordinates cur = q.remove();
			for (int i = 0; i < 4; i++) {
				int nr = cur.x + dr[i];
				int nc = cur.y + dc[i];
				if (inbound(nr, nc) && Grid[nr][nc] == prev) {
					Grid[nr][nc] = Grid[cur.x][cur.y] + 1;
					q.add(new Coordinates(nr,nc));
				}
			}
		}
	}

	public static boolean inbound(int x, int y){
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}