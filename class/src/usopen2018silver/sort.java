package usopen2018silver;
import java.util.*;
import java.io.*;
public class sort {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("sort.in"));
		PrintWriter out = new PrintWriter(new File("sort.out"));
		int n = Integer.parseInt(in.readLine());
		int[] unsorted = new int[n];
		int[] sorted = new int[n];
		for(int i = 0; i < n; i++) {
			int a= Integer.parseInt(in.readLine());
			unsorted[i] = a;
			sorted[i] = a;
		}
		Arrays.sort(sorted);
		int ans = 0;
		for(int i = 0; i < n; i++) {
			int pastIn = Arrays.binarySearch(sorted, unsorted[i]);
			if(i - pastIn > 0) {
				ans = Math.max(ans, i-pastIn);
			}
		}
		out.println(ans+1);
		in.close();
		out.close();
	}
}
