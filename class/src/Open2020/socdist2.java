package Open2020;
import java.util.*;
import java.io.*;
public class socdist2 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("socdist2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));
		int n = Integer.parseInt(in.readLine());
		corona[] cows = new corona[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			cows[i] = new corona (Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cows);
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			if(cows[i].virus == 0) {
				if(i > 0 && i < n-1) {
					if(cows[i-1].virus == 0 && cows[i+1].virus == 1) {
						min = Math.min(min, Math.abs(cows[i+1].pos - cows[i].pos));
					}else if(cows[i-1].virus == 1 && cows[i+1].virus ==0) {
						min = Math.min(min,  Math.abs(cows[i].pos - cows[i-1].pos));
					}else {
						min = Math.min(min,  Math.abs(cows[i].pos - cows[i-1].pos));
						min = Math.min(min, Math.abs(cows[i+1].pos - cows[i].pos));
					}
					
				}else if(i == n-1) {
					if(cows[i-1].virus == 1 && cows[i+1].virus ==0) {
						min = Math.min(min,  Math.abs(cows[i].pos - cows[i-1].pos));
					}
				}else if( i ==0) {
					if(cows[i-1].virus == 0 && cows[i+1].virus == 1) {
						min = Math.min(min, Math.abs(cows[i+1].pos - cows[i].pos));
					}
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(i == n-1) {
				if(cows[i].virus == 1) {
					ans++;
					break;
				}
			}
			if(cows[i].virus ==1 && cows[i + 1].virus == 1) {
				int difference = Math.abs(cows[i+1].pos - cows[i].pos);
				if(difference >= min) {
					ans++;
				}
			}
			if(cows[i].virus == 1 && cows[i+1].virus == 0) {
				ans++;
			}
		}
		out.println(ans);
		in.close();
		out.close();
		
	}
	static class corona implements Comparable <corona>{
		int pos;
		int virus;
		public corona (int p, int v) {
			pos = p;
			virus = v;
		}
		public int compareTo(corona m) {
			if(this.pos < m.pos) {
				return -1;
			}
			return 1;
		}
	}
}
