package Dec2019silver;
import java.util.*;
import java.io.*;
public class meetings {
	static BufferedReader in;
	static PrintWriter out;
	static int n;

	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader("meetings.in"));
		out = new PrintWriter (new File("meetings.out"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		int farm = Integer.parseInt(st.nextToken());
		meet[] cows = new meet[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int weight = Integer.parseInt(st.nextToken()); 
			cows[i] = new meet(Integer.parseInt(st.nextToken()) - 1,Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cows);
		int count = 0;
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(cows[i].d == -1 ) {
				ans += cows[i].pos - count;
				count++;
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
}
class meet implements Comparable <meet>{
	int pos;
	int d;
	public meet(int P, int D) {
		pos = P;
		d = D;
	}
	public int compareTo(meet m) {
		if (this.pos < m.pos) {
			return -1;
		}else {
			return 1;
		}
	}
}