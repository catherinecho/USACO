package Feb2020bronze;

import java.util.*;
import java.io.*;

public class swap2{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("swap.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		input[] routine = new input[n];
		int[] original = new int[n];
		int[] processed = new int[n];
		st = new StringTokenizer(in.readLine());
		routine[0] = new input( Integer.parseInt(st.nextToken()) -1,  Integer.parseInt(st.nextToken())-1 );
		st = new StringTokenizer(in.readLine());
		routine[1] = new input( Integer.parseInt(st.nextToken()) -1,  Integer.parseInt(st.nextToken())-1 );
		for(int i = 0; i < n; i++){
			original[i] =(i+1);
			processed[i] =(i+1);
		}
		/*
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list=  new ArrayList<Integer>();
		Collections.reverse(list);
		list.add(2,list2);
		*/
		int iteration = 0;
		for(int i = 0; i < 1000000000; i++){
			iteration++;
				for(int j= 0; j < 2; j++){
					for(int z = 0; z < Math.abs(routine[j].x -routine[j].y) /2 +1; z++) {
						int temp = processed[routine[j].x+z];
						processed[routine[j].x+z]= processed[routine[j].y-z];
						processed[routine[j].y-z]= temp;
					}
					/*
					StringBuilder sub = new StringBuilder();

					sub.append(processed.substring(routine[j].x, routine[j].y));
					sub = sub.reverse();
					String tmp = processed.substring(0,routine[j].x) + sub;
					if(routine[j].y < n) {
						tmp += processed.substring(routine[j].y);
					}
					processed =tmp;
					*/
				}
				if(Arrays.equals(processed, original)){
					break;
				}
		}
		System.out.println(iteration);
		k = k % iteration;
		System.out.println(k);
		for(int i = 0; i < k; i++){
				for(int j= 0; j < 2; j++){
					for(int z = 0; z <  Math.abs(routine[j].x -routine[j].y) /2 +1; z++) {
						int temp = processed[routine[j].x+z];
						processed[routine[j].x+z]= processed[routine[j].y-z];
						processed[routine[j].y-z]= temp;
					}
					/*
					StringBuilder sub = new StringBuilder();
					sub.append(processed.substring(routine[j].x, routine[j].y));
					sub = sub.reverse();
					String tmp = processed.substring(0,routine[j].x) + sub;
					if(routine[j].y < n) {
						tmp += processed.substring(routine[j].y);
					}
					processed = tmp;
					*/
				}
		}
		for(int i = 0; i < n; i++){
			out.println(processed[i]);
		}
		in.close();
		out.close();
	
	}



}
class input{
	int x;
	int y;
	public input(int X, int Y){
		x = X;
		y = Y;
	}
}
