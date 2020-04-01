package practice;
//2805baekjoon
import java.util.*;
import java.io.*;
public class treecutting {
	static Scanner in;
	static int n, m;
	static int[] tree;
	public static void main(String[] args)throws IOException {
		in = new Scanner(System.in);
		try {
			init();	
			System.out.println(solve());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		in.close();
	}
	public static void init() {
		String line = in.nextLine();
		n = Integer.parseInt(line.substring(0,1));
		m = Integer.parseInt(line.substring(2));
		tree = new int[n];
		for(int i = 0; i < n; i++) {
			tree[i] = in.nextInt();
		}
	}
	public static int solve() {
		int max = 20;
		int min = 1;
		while(min <= max) {
			int mid = (max+min) / 2;
			if(valid(mid)) {
				min = mid+1;
			}else {
				max = mid-1;
			}
		}
		return max;
	}
	public static boolean valid(int c) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			if(tree[i]>c) {
				sum+= (tree[i] - c);
			}
		}
		if(sum>= m) {
			return true;
		}
		return false;
	}
}
