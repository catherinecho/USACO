package Dec2017silver;
import java.util.*;
import java.io.*;
public class measurement {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter out = new PrintWriter(new File("measurement.out") );
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		moo[] log = new moo[n];
		HashMap<Integer,Integer> cows = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			int temp3 = Integer.parseInt(st.nextToken());
			log[i] = new moo(temp1, temp2, temp3);
		}
		int max = Integer.MIN_VALUE;
		int previous = max;
		int maxIndex = 0;
		int ans = 0;
		Arrays.sort(log);
		for(int i = 0; i < n; i++) {
			System.out.println(log[i].day + " " + log[i].cow + " " + log[i].milk);
		}
		for(int i = 0; i < n; i++) {
			if(!cows.containsKey(log[i].cow)) {
				cows.put(log[i].cow, log[i].milk);
			}else {
				cows.put(log[i].cow, cows.get(log[i].cow) +log[i].milk);
			}
			if(maxIndex == log[i].cow) {
				max= Math.max(log[i].milk,previous); 
				ans++;
			}
			else if(cows.get(log[i].cow) >= max) {
				previous = max;
				max = cows.get(log[i].cow);
				maxIndex = i;
				System.out.println(max);
				
				ans++;
			}
			
		}
		System.out.println(ans-1);
		in.close();
		out.close();
	}
}
class moo implements Comparable<moo>{
	public int day;
	public int cow;
	public int milk;
	public moo (int d, int c, int m) {
		day = d;
		cow = c;
		milk = m;
	}
	public int compareTo(moo m) {
		if(this.day < m.day) {
			return -1;
		}
		return 1;
	}
}