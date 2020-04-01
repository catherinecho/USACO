package Open2020silver;
import java.util.*;
import java.io.*;
public class socdist2 {
	static grass[] points;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("socdist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		points = new grass[m];
		for(int i = 0 ; i< m; i++) {
			st = new StringTokenizer(in.readLine());
			points[i] = new grass( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(points);
		System.out.println(search());
		
	}
	
	public static int search() {
		int lb = 0;
		int ub = points[points.length-1].end - points[0].start; 
		int totalspaces = ub + 1;
		while(lb <ub) {
			int mid = (lb+ ub+1)/2;
			if(totalspaces/mid >= n) {
				if(valid(mid)) {
					lb = mid;
				}else {
					ub = mid -1;
				}
			}else {
				ub = mid -1;
			}
			
		}
		return ub;
	}
	public static boolean valid(int num) {
		int cow = 0;
		int curr = points[0].start;
		int next = 0;
		int diff = Math.abs(points[0].start-points[0].end);
		int fit = diff / num;
		cow += fit+1;
		next = curr + (fit *num);
		next += num;
		for(int i = 1; i < m; i++) {
			if (next < points[i].start) {
				next = points[i].start;
			}else if (next > points[i].end) {
				if(i == m-1) {
					return false;
				}else {
					continue; 
				}
			}
			diff = Math.abs(next - points[i].end);
			fit = diff/ num;
			cow += fit+1;
			next += fit*num;
			next += num;
			
		}
		if(cow >= n) {
			return true;
		}else {
			return false;
		}
	}
	static class grass implements Comparable <grass>{
		int start;
		int end;
		public grass(int s, int e) {
			start = s;
			end = e;
		}
		public int compareTo(grass m) {
			if(this.start < m.start) {
				return -1;
			}
			return 1;
		}
	}
}
