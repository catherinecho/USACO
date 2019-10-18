package Jan2018bronze;
import java.util.*;
import java.io.*;

public class lifeguards {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(new File("lifeguards.in"));
		PrintWriter out = new PrintWriter(new File("lifeguards.out"));
		int n = in.nextInt();
		TreeSet<Integer> active = new TreeSet<Integer>();
		cow[] cows = new cow[2*n + 1];
		for(int i = 1; i <= 2*n; i++) {
			if(i %2 ==1) {
				cows[i] = new cow(i/2+1,in.nextInt());
			}else {
				cows[i] = new cow(i/2,in.nextInt());
			}
			
		}
		Arrays.sort(cows,1,2*n+1);

		active.add(cows[1].ind);
		int st = cows[1].time;
		long total = 0;
		long[] h = new long[n+1];

		
		for(int i = 2; i <= 2*n; i++) {
			if(active.size() == 1) {
				h[active.first()] += cows[i].time - st;
			}
			if(active.size() >0) {
				total += cows[i].time - st;
			}
			if(active.contains(cows[i].ind)) {
				active.remove(cows[i].ind);
			}else {
				active.add(cows[i].ind);
			}
			st = cows[i].time;
		}
		long min = h[1];
		for(int i = 1; i <= n; i++) {
			min = Math.min(min, h[i]);
		}
		out.println(total -min);
		out.close();
		in.close();
	}
}
class cow implements Comparable<cow>{
	int ind;
	int time; 
	public int compareTo(cow m) {
			return this.time - m.time;
	}
	public cow(int i, int t) {
		this.ind = i;
		this.time = t;
	}
}