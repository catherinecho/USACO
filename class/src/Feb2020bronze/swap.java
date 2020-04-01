package Feb2020bronze;

import java.util.*;
import java.io.*;

public class swap {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("swap.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		pairs[] routine = new pairs[n];
		String original = "";
		st = new StringTokenizer(in.readLine());
		routine[0] = new pairs( Integer.parseInt(st.nextToken()) -1,  Integer.parseInt(st.nextToken()) );
		st = new StringTokenizer(in.readLine());
		routine[1] = new pairs( Integer.parseInt(st.nextToken()) -1,  Integer.parseInt(st.nextToken()) );
		for(int i = 0; i < n; i++){
			original+=Integer.toString(i+1);
		}
	
		int iteration = 0;
		String processed = original;
		for(int i = 0; i < k; i++){
			iteration++;
				for(int j= 0; j < 2; j++){
					
					StringBuilder sub = new StringBuilder();

					sub.append(processed.substring(routine[j].x, routine[j].y));
					sub = sub.reverse();
					String tmp = processed.substring(0,routine[j].x) + sub;
					if(routine[j].y < n) {
						tmp += processed.substring(routine[j].y);
					}
					processed =tmp;
				}
				if(processed.equals(original)){
					break;
				}
		}
		k = k % iteration;
		for(int i = 0; i < k; i++){
				for(int j= 0; j < 2; j++){
					
					StringBuilder sub = new StringBuilder();
					sub.append(processed.substring(routine[j].x, routine[j].y));
					sub = sub.reverse();
					String tmp = processed.substring(0,routine[j].x) + sub;
					if(routine[j].y < n) {
						tmp += processed.substring(routine[j].y);
					}
					processed = tmp;
				}
		}
		for(int i = 0; i < n; i++){
			out.println(processed.charAt(i));
		}
		in.close();
		out.close();
	
	}



}
class pairs{
	int x;
	int y;
	public pairs(int X, int Y){
		x = X;
		y = Y;
	}
}
