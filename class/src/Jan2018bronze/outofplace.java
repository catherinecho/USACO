package Jan2018bronze;
import java.util.*;
import java.io.*;
public class outofplace {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] numbers;
	static int[] compare;
	static int[] line;
	public static void main(String[] args)throws IOException {
		in = new Scanner(new File("outofplace.in"));
		out = new PrintWriter(new File("outofplace.out"));
		try {
			init();
			out.println(solve());
		}
		catch (Exception e) {
			e.printStackTrace();//hi
		}
		in.close();
		out.close();
	}
	private static void init () {
		n = in.nextInt();
		compare = new int[n];
		numbers = new int[n];
		for(int i = 0; i < n; i++) {
			int t = in.nextInt();
			numbers[i] = t;
			compare[i] = t;
		}
		Arrays.sort(compare);
	}
	
	private static int solve() {
		int change = 0;
		for(int i = 0; i < n; i++ ) {
			if(compare[i] != numbers[i]) {
				change++;
			}
		}
		return change-1;
	}
}

