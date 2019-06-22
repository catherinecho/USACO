package bronze2018;
/*
ID: ccho2011
LANG: JAVA
TASK: backforth
 */
import java.util.*;
import java.io.*;
public class backforth {
	static Scanner in;
	static PrintWriter out;
	static int[] size1;
	static int[]size2;
	static HashSet<Integer> set=new HashSet();
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("backforth.in"));
			out = new PrintWriter(new File("backforth.out"));
			init();
			out.print(solve());
			out.close();
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void init() {
		StringTokenizer st = new StringTokenizer(in.nextLine());

		size1 = new int[10];
		size2 = new int[10];
		for(int i = 0; i < 10; i++) {
			size1[i] = Integer.parseInt(st.nextToken());
		}
		st =new StringTokenizer(in.nextLine());
		for(int i = 0; i < 10; i++) {
			size2[i] = Integer.parseInt(st.nextToken());
		}
	}
		
	public static String solve() {
			int[] keep1 = new int[10];
			int[] keep2 = new int[10];
			keep1=size1.clone();
			keep2= size2.clone();
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					int first  =0-size1[i] + size2[j];
					swap(i,j);
					for(int x = 0; x < 10; x++) {
						for(int y = 0; y < 10; y++) {
							int second = first - size1[x] + size2[y];	
							set.add(second);
						}
					}
					size1 = keep1.clone();	
					size2 = keep2.clone();
				}
			}
			
			return Integer.toString(set.size());
	}

	public static void swap(int x, int y) {
		int temp = size1[x];
		size1[x] = size2[y];
		size2[y] = temp;
	}
}
