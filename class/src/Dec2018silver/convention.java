package Dec2018silver;
import java.util.*;
import java.io.*;
public class convention {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int m ;
	static int c;
	static int[] time;
	static int ans = 0;
	public static void main(String[] args)throws IOException {
		in = new Scanner(new File("convention.in"));
		out = new PrintWriter(new File("convention.out"));
		try {
			init();
			out.println(solve());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		in.close();
		out.close();
	}
	private static void init() {
		n = in.nextInt();
		m = in.nextInt();
		c= in.nextInt();
		time = new int[n];
		for(int i = 0 ; i < n; i++) {
			time[i] = in.nextInt();
		}
		Arrays.sort(time);
	}
	public static int solve() {
		int max = time[time.length - 1] - time[0]; // time between last cow and first cow
		int min = 0;
		while(min <= max) {
			if (min == max) return min;
			if (min == max - 1) {
				if(valid(min)) return min;
				else return max;
			}
			int mid = (min+ max) / 2;
			if(valid(mid)) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		
		return min;
	}
	public static boolean valid(int max) {
		int num = 1;
		int pivot = 0;
		for(int x = 0; x < n; x++) {
			if(time[x] - time[pivot] > max || x - pivot + 1 > c) {
				pivot = x;
				num++;
			}
		}
		if (num > m)
			return false;
		return true;
	}

}
