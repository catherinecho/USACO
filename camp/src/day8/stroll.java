package day8;
import java.util.*;
public class stroll {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int[] L = new int[n+1];
	static int[]R = new int[n+1];
	static int ans = 0;
	public static void main(String[] args) {
		for(int i = 0; i <= n; i++) {
			L[i] = -1;
			R[i] = -1;
		}
		for(int i = 0; i < n-1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c=  in.nextInt();
			L[a] = b;
			R[a] = c;
		}
		dfs(1,0);
		System.out.println(ans);
	}
	public static void dfs(int state, int num) {
		if(state == -1) return;
		if(state == 0) {
			ans = Math.max(ans, num);
			return;
		}
		dfs(L[state], num + 1);
		dfs(R[state], num + 1);
	}
}
