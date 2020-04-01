package training;
import java.util.*;
import java.io.*;
public class wormhole {
	public static void main (String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new FileWriter("wormhole.out"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		coordinate[] dots = new coordinate[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			dots[i] = new coordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		ArrayList<worm> combo = new ArrayList<worm>();
		for(int i = 0; i < n; i++) {
			for(int j =  i+1; j < n;j ++) {
				combo.add(new worm(dots[i],dots[j]) );
			}
		}
		ArrayList<ArrayList<worm>> holes = new ArrayList<ArrayList<worm>>();
		for(int i =0 ; i < combo.size(); i++) {
			
		}
	}
	static class coordinate{
		int x ;
		int y;
		public coordinate(int X, int Y) {
			x = X;
			y = Y;
		}
	}
	static class worm{
		coordinate enter;
		coordinate exit;
		public worm (coordinate e, coordinate ex) {
			enter = e;
			exit = ex;
		}
	}
	
}
