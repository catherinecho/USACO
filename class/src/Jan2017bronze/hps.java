package Jan2017bronze;
import java.util.*;
import java.io.*;
public class hps {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] cow1;
	static int[] cow2;
	static int[] results;
	public static void main(String[] args)throws IOException {
		in = new Scanner(new File("hps.in"));
		out = new PrintWriter(new File("hps.out"));
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
	private static void init () {
		n = in.nextInt();
		cow1 = new int [n];
		cow2 = new int[n];
		results = new int[n];
		for(int i = 0; i < n; i++) {
			cow1[i] = in.nextInt();
			cow2[i] = in.nextInt();
			results[i] = cow1[i] - cow2[i];
		}
		
	}
	//hi
	public static int solve() {
		int one = 0;
		int two = 0;
		for(int i = 0; i < n; i++) {
			if(results[i] == 1 || results[i] == -2) {
				one++;
			}else if (results[i] == -1 || results[i] == 2) {
				two++;
			}
		}
		return Math.max(two, one);
	}
}
