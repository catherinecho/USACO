package day8;
import java.util.*;
public class moocast {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static cow[] cows = new cow[n];
	static int ans = 0;
	static int c = 0;
	static boolean[] visited = new boolean[n];
	static ArrayList<Integer> count = new ArrayList<Integer>();
	public static void main(String[] args) {
		for(int i = 0;i < n; i++) {
			cows[i] = new cow(in.nextInt(), in.nextInt(), in.nextInt());
		}
		for(int i = 0; i < n; i++) {
			int c = dfs(i);
			ans = Math.max(c,  ans);
			for(int j = 0; j < n; j++) {
				visited[j] = false;
			}
		}
		System.out.println(ans);
	}
	public static int dfs(int state) {
		visited[state]  = true;
		c = 1;
		for(int i = 0; i < n; i++) {
			if(accessible(state, i) && !visited[i]) {
				c += dfs(i);
			}
		}
		return c;
	}
	public static boolean accessible(int source, int dest) {
		int dx = cows[source].x - cows[dest].x;
		int dy = cows[source].y - cows[dest].y;
		int p = cows[source].power;
		if((p*p) >= (dx*dx) + (dy* dy)) {
			return true;
		}
		return false;
	}
}
class cow{
	int x;
	int y;
	int power;
	public cow( int X, int Y, int P) {
		this.x = X;
		this.y = Y;
		this.power = P;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public int getP() {return power;}
}