/*
ID: ccho2011
LANG: JAVA
TASK: ride
*/
package section1_2;
import java.io.*;
import java.util.*;
public class gift1 {
	static Scanner in;
	static PrintWriter out;
	static String inFile = "gift1.in";
	static String outFile = "gift2.out";
	static String[] result;
	static StringTokenizer st;
	static Map<String,Integer> m;
	static int n;
	public static void main(String[] args) {
		try {
			in = new Scanner(new File(inFile));
			out = new PrintWriter(new File(outFile));
			init();
			result = solve();
			for(int i = 0; i < result.length; i++) {
				out.println(result[i]);
			}
			out.close();
			in.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	private static void init() {
		m = new LinkedHashMap<String,Integer>();
		n = in.nextInt();
		result = new String[n];
		for(int i = 0; i < n; i++) {
			m.put(in.nextLine(), 0);
		}
	}	
	public static String[] solve() {
		for(int x = 0; x < n; x++) {
			String giver = in.nextLine();
			st = new StringTokenizer(in.nextLine());
			int money = Integer.parseInt(st.nextToken());
			int ppl = Integer.parseInt(st.nextToken());
			if(ppl == 0) {
				continue;
			}
			m.put(giver, m.get(giver) - money);
			int give= money / ppl;
			int remainder = money% ppl;
			for(int i = 0; i < ppl; i++) {
				String name = in.nextLine();
				m.put(name, m.get(name) + give);
			}
			m.put(giver, m.get(giver) + remainder);
		}
		int y = 0;
		for(String s: m.keySet()) {
			result[y] = s+" "+m.get(s);
			y++;
		}
		return result;
	}
}
