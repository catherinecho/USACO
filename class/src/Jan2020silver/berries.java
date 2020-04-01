package Jan2020silver;
import java.util.*;
import java.io.*;

public class berries {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader("berries.in"));
		out = new PrintWriter(new File("berries.out") );
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] berries = new int[n];
		for(int i= 0; i < n; i++) {
			berries[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(berries);
		int max= 0;
		for(int i = berries[berries.length-1]; i >0; i--) {
			ArrayList<Integer> split = new ArrayList<Integer>();
			for(int j = 0; j < n; j++) {
				if(berries[j] <= i) {
					split.add(berries[j]);
				}else {
					int a= berries[j];
					while(a > i) {
						split.add(i);
						a -= i;
					}
					if(a != 0) {
						split.add(a);
					}
				}
			}
			Collections.sort(split);
			int temp = 0;
			for(int j = split.size() - k/2 - 1; split.size() - k >= 0 && j >= split.size()- k; j--) {
				temp+= split.get(j);
			}
			
			max = Math.max(max, temp);
		}
		out.println(max);
		in.close();
		out.close();
	}
	
}
