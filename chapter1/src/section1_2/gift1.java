/*
ID: ccho2011
LANG: JAVA
TASK: gift1
*/
package section1_2;
import java.io.*;
import java.util.*;
public class gift1 {
	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;
	static Map<String,Integer> m;
	static int n;
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("gift1.in"));
			out = new PrintWriter(new File("gift2.out"));
			init();
			out.print(solve());
			out.close();
			in.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	private static void init() {
		m = new LinkedHashMap<String,Integer>();
		n = in.nextInt();
		for(int i = 0; i < n; i++) {
			m.put(in.nextLine(), 0);
		}
	}	
	public static String solve() {
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
		StringBuilder sb = new StringBuilder();
		for(String s: m.keySet()) {
			sb.append(s).append(" ").append(m.get(s)).append("\n");
		}
		return sb.toString();
	}
}
