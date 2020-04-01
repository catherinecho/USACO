package Dec2016silver;
import java.util.*;
import java.io.*;
public class haybales {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("haybales.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] hay = new int[n];
		
		for(int i = 0; i < n; i++) {
			hay[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(hay);
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int x =Arrays.binarySearch(hay, start);
			int y =Arrays.binarySearch(hay, end);
			if(x == -1 ) {
				x = 0;
			}else if (y == -1) {
				y = 0;
			}
			
			//do the same for x
			if(y < 0) {
				y = Math.abs(y) -1;
			}else if ( y > 0) {
				y ++;
			}
			
			y--;
			out.println(Math.abs(y- x));
		}
		
	}
}
