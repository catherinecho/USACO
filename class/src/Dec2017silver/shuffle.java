package Dec2017silver;
import java.util.*;
import java.io.*;
public class shuffle {
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter out = new PrintWriter(new File("shuffle.out"));
		int n = Integer.parseInt(in.readLine());
		int[] swap = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i =0 ;i < n; i++){
			swap[i] = Integer.parseInt(st.nextToken())-1;
		}
		int[] position = new int[n];
		for(int i =0 ;i < n; i++){
		position[swap[i]]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		int numZeroPositions = 0;
		for(int i = 0; i < n; i++){
			if(position[i] ==0){ 
				q.add(i);
				numZeroPositions++;
			}
		}
		while(!q.isEmpty()){
			int pos = q.remove();
			// try to see if we have another position that is potentially unoccupied
			position[swap[pos]]--; // swap[pos] is prior position
			if(position[swap[pos]] == 0) {
				q.add(swap[pos]);
				numZeroPositions++;
			}
		}
		
		out.println(n - numZeroPositions);
		in.close();
		out.close();
	}

}
