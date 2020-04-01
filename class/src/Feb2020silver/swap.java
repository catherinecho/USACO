package Feb2020silver;

import java.util.*;
import java.io.*;

public class swap{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("swap.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		input[] routine = new input[m];
		
		int[] original = new int[n];
		int[] processed = new int[n];
		
		for(int i = 0; i < m ; i++) {
			st = new StringTokenizer(in.readLine());
			routine[i] = new input( Integer.parseInt(st.nextToken()) -1,  Integer.parseInt(st.nextToken())-1 );
		}
		
		ArrayList<Integer> before = new ArrayList<Integer>();;
		ArrayList<Integer> after = new ArrayList<Integer>();;
		for(int i = 0; i < n; i++){
			original[i] =(i+1);
			processed[i] =(i+1);
			before.add(i);
		}
		
		
		for(int i = 0;i < m; i++) {
			for(int z = 0; z < Math.abs(routine[i].x -routine[i].y) /2 +1; z++) {
				int temp = processed[routine[i].x+z];
				processed[routine[i].x+z]= processed[routine[i].y-z];
				processed[routine[i].y-z]= temp;
			}
		}
		//System.out.println(Arrays.toString(processed));
		for(int i= 0; i < n; i++) {
			after.add( processed[i]-1);
		}

		HashMap<Integer, Integer> delta = new HashMap<Integer,Integer>();
		for(int i = 0; i < n; i++) {
			int difference = after.indexOf(i) -before.indexOf(i) ;
			delta.put(i, difference);
		}
		
		processed = original.clone();
		int[] compare = new int[n];
		compare = original.clone();
		int iteration = 0;
		for(int i = 0; i < 1000000000; i++) {
			iteration++;
			for(int j = 0; j < n; j++) {
				processed[j+delta.get(j)] = compare[j];
			}
			compare = processed.clone();
			if(Arrays.equals(processed, original)){
				break;
			}
			
		}
		

	
		processed = original.clone();
		compare = original.clone();
		
		k = k % iteration;
		for(int i = 0; i < k; i++) {
			iteration++;
			for(int j = 0; j < n; j++) {
				processed[j+delta.get(j)] = compare[j];
			}
			compare = processed.clone();
			if(Arrays.equals(processed, original)){
				break;
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
