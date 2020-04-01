/*
ID: ccho2011
LANG: JAVA
TASK: combo
*/
package training;
import java.util.*;
import java.io.*;
public class combo {
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		int[] farmer = new int[3];
		int[] master = new int[3];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < 3; i++) {
			farmer[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < 3; i++) {
			master[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				for(int k = 1; k <= n; k++) {
					int one = i;
					int two = j; 
					int three= k;
					
					if(valid(one,two, three, farmer) || valid(one, two ,three,master)) {
						ans++;
						//System.out.println(one + "" + two + "" + three );
					}
					else {
						//System.out.println(one + "" + two + "" + three );
					}
				}
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
	public static boolean valid(int one, int two, int three, int[]compare) {
		if(Math.abs(compare[0] - one) > 2 && Math.abs(compare[0] - one) <n-2) {
			return false;
		}
		if(Math.abs(compare[1] - two) > 2&& Math.abs(compare[1] - two) <n-2) {
			return false;
		}
		if(Math.abs(compare[2] - three) > 2&& Math.abs(compare[2] - three) <n-2) {
			return false;
		}
		return true;
	}
}
