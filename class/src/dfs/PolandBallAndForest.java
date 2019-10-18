package dfs;
import java.io.*;
import java.util.*;

public class PolandBallAndForest {

	//hi
	static int n;
	static ArrayList <Integer> [] a;
	static boolean [] v;
	static Scanner in = new Scanner (System.in);

	public static void main(String[] args) {
	
		try {
			init();
			System.out.println(solve());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	private static void init () {
	
		n = in.nextInt();
		a = new ArrayList[n+1];
		v = new boolean [n+1];
		
		for (int i = 0; i < n+1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < n; i++) {
			int n1 = i+1;
			int n2 = in.nextInt();
			a[n1].add(n2);
			a[n2].add(n1);
		}
		
		in.close();
		
	}
	
	private static String solve () {
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			if(!v[i]) {
				dfs(i);
				ans++;
			}
		}
		return ans+"";
	
	}
	static void dfs(int s) {
		if(v[s]) return;
		v[s] = true;
		for(int i : a[s]) {
			if(!v[i]) dfs(i);
		}
	}

}

