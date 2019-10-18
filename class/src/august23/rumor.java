package august23;
import java.util.*;
import java.io.*;

public class rumor {

	static int n, m, cnt;
	static ArrayList <Integer> [] a;
	static boolean [] v;
	static Scanner in = new Scanner (System.in);
	static int[] price;
	public static void main(String[] args) {
	
		try {
			init();
			System.out.println(solve());
			//System.out.println(Arrays.toString(v));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	private static void init () {
	
		n = in.nextInt();
		m = in.nextInt();
		a = new ArrayList[n+1];
		v = new boolean [n+1];
		price = new int[n+1];
		
		for (int i = 0; i < n+1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i <= n; i++) {
			price[i] = in.nextInt();
		}
		in.nextLine();
		for (int i = 0; i < m; i++) {
			String[] line = in.nextLine().split(" ");
			//System.out.println(Arrays.toString(line));
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);

			a[x].add(y);
			a[y].add(x);
		}
		//System.out.println(Arrays.toString(a));
		in.close();
		
	}
	
	private static long solve () {
		int ans = 0;
		long cost =0;
		for(int i = 1; i <= n; i++) {
			if(!v[i]) {
				cost += dfs(i);
				
			}
		}
		
		return cost;
		
	
	}
	static long dfs(int s) {
		
		v[s] = true;
		long min = price[s];
		for(int i : a[s]) {
			if(!v[i]) min= Math.min(min, dfs(i));
		}
		return min;
	}

}

