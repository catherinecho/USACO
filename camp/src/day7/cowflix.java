package day7;
import java.util.*;
public class cowflix {
	static Scanner in = new Scanner(System.in);
	static int capacity = in.nextInt();
	static int n = in.nextInt();
	static int[] cows = new int[n+1];
	static int[] a = new int[n+1];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		for(int i = 1; i <= n; i++) {
			cows[i] = in.nextInt();
		}
		Arrays.sort(cows);
		subset(1,0);
		int max = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i) > max) {
				max = list.get(i);
			}
		}
		System.out.println(max);
	}
	public static void subset(int x, int c) {
		if(x == n+1) {
			if(c<= capacity) {
				list.add(c);
				
			}
			return;
		}
		a[x] = 0;
		subset(x+1, c);
		a[x] = 1;
		subset(x+1, c+cows[x]);
	}
}

