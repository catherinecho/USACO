package Open2020;
import java.util.*;
import java.io.*;
public class tracing {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("tracing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] endresult = new int[n+1];
		String line = in.readLine();
		for(int i= 1 ;i <= n; i++) {
			endresult[i] = line.charAt(i-1) - 48;
		}
		infect[] list = new infect[t];
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(in.readLine());
			list[i] = new infect(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(list);
		
		String k = "";
		int pans = 0;
		int maxK = 0;
		int minK= Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			int patientzero = i+1;
			int[] curresult= new int[n+1];
			curresult[patientzero] = 1;
			int curK= 0;
			for(int j = 0; j < t; j++) {
				if (list[j].one == patientzero) {
					curresult[list[j].two] = 1;
					curK++;
				}else if (list[j].two == patientzero) {
					curresult[list[j].one] = 1;
					curK++;
				}
				
				if(Arrays.equals(curresult,endresult)) {
					boolean pzero=false;
					boolean nothing = true;
					for(int x = j+1; x < t; x++) {
						if(list[x].one == patientzero) {
							pzero = true;
							if(curresult[list[x].two]== 1) {
								nothing = false;
								break;
							}
						}else if (list[x].two == patientzero){
							pzero = true;
							if(curresult[list[x].one]== 1) {
								nothing = false;
								break;
							}
						}
						if(list[x].one != patientzero && list[x].two!= patientzero ) {
							if(curresult[list[x].one] != 1 && curresult[list[x].two] == 1 ) {
								nothing = false;
								break;
							}else if (curresult[list[x].one] == 1 && curresult[list[x].two] != 1) {
								nothing = false;
								break;
							}else if(curresult[list[x].one] == 1 && curresult[list[x].two]== 1) {
								nothing = false;
								break;
							}
						}
					}
					if(pzero == true && nothing == true) {
						maxK = Math.max(maxK, curK);
						minK  = Math.min(minK, curK);
						pans ++;
						break;
					}else if (pzero == false && nothing== true) {
						k = "infinity";
						minK  = Math.min(minK, curK);
						pans++;
						break;
					}else {
						break;
					}
				}
			}
			
			
		}
		if(k.equals("infinity")) {
			System.out.println(pans + " " + minK + " " + k);
		}else {
			System.out.println(pans + " " + minK + " " + maxK );
		}
		
	}
	static class infect implements Comparable<infect>{
		int time; 
		int one; 
		int two;
		public infect (int t, int o, int tw) {
			time = t;
			one = o;
			two = tw;
		}
		public int compareTo(infect m) {
			if(this.time < m.time) {
				return -1;
			}else {
				return 1;
			}
		}
	}
}
